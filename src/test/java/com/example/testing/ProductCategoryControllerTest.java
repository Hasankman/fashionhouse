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
import com.example.domain.ProductCategory;
import com.example.repository.ProductCategoryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:poduct-category-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ProductCategoryControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ProductCategoryRepository repo;

	@Autowired
	private ObjectMapper mapper;
	
	/*
		INSERT INTO  product_category (prodcatdesc) VALUES ('Dresses'), ('Tops'), ('Coats & Jackets'), ('Jumpers & Cardigans'), ('Hoodies & Sweatshirts'), ('Shorts'),('Skirts'), ('Jeans'), ('Shoes'), ('Jewellery & Watches'), ("Bags & Purses");

		SELECT * FROM product_category;

		DELETE  from  product_category where prod_cat_id > 0 ; 
	 
	 */

	private final ProductCategory TEST_ProductCategory = new ProductCategory(25, "Dresses", null);

	private final ProductCategory TEST_SAVED_ProductCategory = new ProductCategory( 26, "Tops", null);
	
	@Test
	public void testAddProductCat() throws JsonProcessingException, Exception {
		String resultString = this.mockMVC
				.perform(post("/addProductCat").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(TEST_ProductCategory)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		ProductCategory result = this.mapper.readValue(resultString, ProductCategory.class);
		assertThat(result).isEqualTo(TEST_ProductCategory);
	}
	
	@Test
	public void testreadProductCategoryById() throws Exception {
		this.mockMVC.perform(get("/productCatById")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_ProductCategory)));

	}

	@Test
	public void testgetAllProductCategorys() throws Exception {
		final List<ProductCategory> PEOPLE = new ArrayList<>();
		PEOPLE.add(TEST_SAVED_ProductCategory);

		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/allProductCat").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<ProductCategory> results = Arrays.asList(mapper.readValue(resultString, ProductCategory[].class));
		assertThat(results).contains(this.TEST_ProductCategory).hasSize(3);
	}
	
	@Test
	public void testUpdate() throws Exception {
		final ProductCategory newProductCategory = new ProductCategory( 26, "Tops", null);
		String resultString = this.mockMVC
				.perform(put("/updateProductCat/{id}").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newProductCategory)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		ProductCategory result = this.mapper.readValue(resultString, ProductCategory.class);
		assertThat(result).isEqualTo(newProductCategory);
	}
	
	@Test
	public void testdeleteProductCategorys() throws Exception {
		this.mockMVC.perform(delete("/deleteProductCat/26")).andExpect(status().isNoContent());
	}
}
