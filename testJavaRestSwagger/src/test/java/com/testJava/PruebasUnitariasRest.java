package com.testJava;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class PruebasUnitariasRest {
	final static String CATEGORIAS_API = "https://cs-hsa-api-categories.herokuapp.com/categories";
	final static String CUPONES_API = "https://cs-hsa-api-coupons.herokuapp.com/coupons";
	
	@Test
	public void testApiCategorias() throws Exception {
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = new URI(CATEGORIAS_API);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verifica que el servicio retorne OK
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	public void testApiCupones() throws Exception {
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = new URI(CUPONES_API);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verifica que el servicio retorne OK
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
