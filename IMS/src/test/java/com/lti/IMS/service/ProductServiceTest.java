package com.lti.IMS.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.IMS.Model.Product;
import com.lti.IMS.Service.ProductService;
import com.lti.IMS.dao.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	 @MockBean
	 private ProductRepository productRepo;
	 
	 
	 @Autowired
	 private ProductService productService;
	 
	 @Test
	 public void testNewProduct() {
		 Product product= new Product();
			product.setId(78);
			product.setDescription("book");
			product.setPrice(5000);
			product.setQty(1);
			product.setExpiry(null);
			product.setMfd(null);
			product.setUsebefore(3);
			Mockito.when(productRepo.save(product)).thenReturn(product);
	        assertThat(productService.CreateProduct(product)).isEqualTo(product);
	 }

}
