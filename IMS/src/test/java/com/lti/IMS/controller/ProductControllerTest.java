package com.lti.IMS.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lti.IMS.Controller.ProductController;
import com.lti.IMS.Service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class)
public class ProductControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;

}
