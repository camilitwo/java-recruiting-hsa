package com.testJava.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testJava.delegate.DelegateSwagger;
import com.testJava.model.Cupones;

@Controller
public class CarruselCuponesController {
	
	@RequestMapping("/CarruselCupones")
	public String obtenerCarrusel(Model modelo) {
		
		 DelegateSwagger categoriasClient = new DelegateSwagger();
		try {
			
			List<Cupones> cupones = categoriasClient.obtenerCupones();
			int i = 0;
			for (Cupones cupon : cupones) {
				Date fechaExp =new SimpleDateFormat("yyyy-MM-dd").parse(cupon.getExpiresAt().toString());
				Date hoy =java.util.Calendar.getInstance().getTime();
				if(fechaExp.after(hoy) || fechaExp.equals(hoy)) {					
					modelo.addAttribute("url"+i,cupon.getImage());
					i++;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "CarruselCupones";
	}

}
