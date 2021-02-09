package com.testJava.delegate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.testJava.model.Categorias;
import com.testJava.model.Cupones;

@RestController
public class DelegateSwagger {
	final static String CATEGORIAS_API = "https://cs-hsa-api-categories.herokuapp.com/categories";
	final static String CUPONES_API = "https://cs-hsa-api-coupons.herokuapp.com/coupons";
	
	
    private WebClient.Builder webClientBuilder ;
	
    @Autowired
    private void setApplicationContext(WebClient.Builder web) {
    	webClientBuilder = WebClient.builder();       
    }
	
    
    @RequestMapping(value = "/buscarCategorias", method = RequestMethod.GET)
    public Categorias obtenerCategorias() throws JsonParseException, JsonMappingException, IOException {
        
		setApplicationContext(webClientBuilder);
		
        Object categoriasClient = webClientBuilder.build()
                .get()
                .uri(CATEGORIAS_API)
                .retrieve()
                .bodyToMono(Categorias.class)
                .block();
        
        Categorias categorias = (Categorias)categoriasClient;
        
        return categorias;
    }
	
	
    @RequestMapping(value = "/buscarCupones", method = RequestMethod.GET)
    public List<Cupones> obtenerCupones() throws JsonParseException, JsonMappingException, IOException {
        
		setApplicationContext(webClientBuilder);
		
        Object cuponesClient = webClientBuilder.build()
                .get()
                .uri(CUPONES_API)
                .retrieve()
                .bodyToMono(Cupones[].class)
                .block();
        
        Cupones[] cupones = (Cupones[])cuponesClient;
        
        return Arrays.asList(cupones);
    }
}
