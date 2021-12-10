package com.lti.IMS.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.IMS.Model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductDaoTest {
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Autowired
	private ProductRepository productrepo;
	
	@Test
	public void testNewProduct() throws Exception{
		
		Product product=getProduct();
		
		Product saveInDb= testEntityManager.persist(product);
		Product getFromInDb= productrepo.findById(saveInDb.getId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
		
	}

	private Product getProduct() {
		// TODO Auto-generated method stub
		Product product= new Product();
		product.setId(78);
		product.setDescription("book");
		product.setPrice(5000);
		product.setQty(1);
		product.setExpiry(null);
		product.setMfd(null);
		product.setUsebefore(3);
		return product;
	}

}
