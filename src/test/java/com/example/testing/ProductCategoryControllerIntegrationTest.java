package com.example.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.example.domain.ProductCategory;
import com.example.repository.ProductCategoryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:productcategory-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ProductCategoryControllerIntegrationTest  {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ModelMapper mapper;
	
	private final ProductCategory TEST_ProductCategory = new ProductCategory(null, "Dress", null) ;
	
	private final ProductCategory TEST_SAVED_ProductCategory = new ProductCategory(1, "Tops", null);
	

	
	@Test
	public void testDelete() throws Exception {
		this.mockMVC.perform(delete("/deleteProductCat/2")).andExpect(status().isNoContent());
	}
	
}
