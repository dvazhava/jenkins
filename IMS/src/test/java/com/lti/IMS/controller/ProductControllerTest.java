package com.lti.IMS.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.IMS.Controller.ProductController;
import com.lti.IMS.Model.Product;
import com.lti.IMS.Service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class)
public class ProductControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void testNewProduct() throws Exception {
		String URI="/inventory/product";
		Product product= new Product();
		product.setId(78);
		product.setDescription("book");
		product.setPrice(5000);
		product.setQty(1);
		product.setExpiry(null);
		product.setMfd(null);
		product.setUsebefore(3);
		String jsonInput = this.converttoJson(product);
		Mockito.when(productService.CreateProduct(Mockito.any(Product.class))).thenReturn(product);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
	}
	
    private String converttoJson(Object product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
    }

}
