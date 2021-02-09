package com.testJava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testJava.delegate.DelegateSwagger;
import com.testJava.model.Categorias;
import com.testJava.model.CategoriasTop;
import com.testJava.model.Subcategory;
import com.testJava.model.Subcategory_;
import com.testJava.model.Subcategory__;

@Controller
public class CarruselCategoriasController {

	@RequestMapping("/CarruselCategorias")
	 public String obtenerCarrusel(Model modelo) {
		 
		 
		 DelegateSwagger categoriasClient = new DelegateSwagger();
		 try {
		 
			Categorias categorias = categoriasClient.obtenerCategorias();
			
			List<Subcategory> subcategories = categorias.getSubcategories();
			
			List<Subcategory_> subcategories2 = subcategories.get(0).getSubcategories();
			List<Subcategory_> grid = new ArrayList<>();
			List<Subcategory__> subcategories3 = null;
			List<CategoriasTop> categoriasTop = new ArrayList<>();
			CategoriasTop cat = null;
			
			subcategories2.get(0).getIconImageUrl();
			for (int i = 0; i < subcategories2.size(); i++) {
				if(subcategories2.get(i).getSubcategories().size()> 0) {
					subcategories3 = subcategories2.get(i).getSubcategories();
					if(subcategories3.get(0).getSubcategories().size()>0 && 
							subcategories3.get(0).getSubcategories().get(0).getRelevance() != null) {
						cat = new CategoriasTop();
						cat.setRelevance(subcategories3.get(0).getSubcategories().get(0).getRelevance());
						cat.setSmallImageUrl(subcategories3.get(0).getSmallImageUrl());
						cat.setMediumImageUrl(subcategories3.get(0).getMediumImageUrl());
						cat.setLargeImageUrl(subcategories3.get(0).getLargeImageUrl());
						categoriasTop.add(cat);
					}else {
						cat = new CategoriasTop();
						cat.setRelevance(subcategories3.get(0).getRelevance());
						cat.setSmallImageUrl(subcategories3.get(0).getSmallImageUrl());
						cat.setMediumImageUrl(subcategories3.get(0).getMediumImageUrl());
						cat.setLargeImageUrl(subcategories3.get(0).getLargeImageUrl());
						categoriasTop.add(cat);
					}
				}else {
					grid.add(subcategories2.get(i));
				}
			}
			
			
			List<CategoriasTop> sorted = categoriasTop.stream()
                    .sorted(Comparator.comparingInt(CategoriasTop::getRelevance))
                    .collect(Collectors.toList());
			
			for (int i = 0; i <= 4; i++) {
				modelo.addAttribute("url"+i,sorted.get(i).getSmallImageUrl());
			}
			
			
			modelo.addAttribute("categorias", grid);
			
			
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "CarruselCategorias";
	 }
}
