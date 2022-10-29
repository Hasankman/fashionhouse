package com.example.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.example.domain.Product;
import com.example.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:poduct-category-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ProductRepository repo;

	@Autowired
	private ObjectMapper mapper;
	
	/*
		INSERT INTO  product_category (prodcatdesc) VALUES ('Dresses'), ('Tops'), ('Coats & Jackets'), ('Jumpers & Cardigans'), ('Hoodies & Sweatshirts'), ('Shorts'),('Skirts'), ('Jeans'), ('Shoes'), ('Jewellery & Watches'), ("Bags & Purses");

		SELECT * FROM product_category;

		DELETE  from  product_category where prod_cat_id > 0 ; 
	 
	 */

	private final Product TEST_Product = new Product();////

	private final Product TEST_SAVED_Product = new Product();////
	
	@Test
	public void testAddProductCat() throws JsonProcessingException, Exception {
		String resultString = this.mockMVC
				.perform(post("/addProductCat").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(TEST_Product)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		Product result = this.mapper.readValue(resultString, Product.class);
		assertThat(result).isEqualTo(TEST_Product);
	}
	
	@Test
	public void testreadProductById() throws Exception {
		this.mockMVC.perform(get("/productCatById")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_Product)));

	}

	@Test
	public void testgetAllProducts() throws Exception {
		final List<Product> PEOPLE = new ArrayList<>();
		PEOPLE.add(TEST_SAVED_Product);

		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/allProductCat").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<Product> results = Arrays.asList(mapper.readValue(resultString, Product[].class));
		assertThat(results).contains(this.TEST_Product).hasSize(3);
	}
	
	@Test
	public void testUpdate() throws Exception {
		final Product newProduct = new Product();//////
		String resultString = this.mockMVC
				.perform(put("/updateProductCat/{id}").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newProduct)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		Product result = this.mapper.readValue(resultString, Product.class);
		assertThat(result).isEqualTo(newProduct);
	}
	
	@Test
	public void testdeleteProducts() throws Exception {
		this.mockMVC.perform(delete("/deleteProductCat/26")).andExpect(status().isNoContent());
	}
}