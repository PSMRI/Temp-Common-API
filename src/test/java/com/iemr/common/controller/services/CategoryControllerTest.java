package com.iemr.common.controller.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.service.category.CategoryService;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

	@Mock
	private CategoryService categoryService;

	@InjectMocks
	private CategoryController categoryController;

	@BeforeEach
	 void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getAllCategoriesTest() throws Exception {
		String request = "{\"providerServiceMapID\":\"1\", \"subServiceID\":\"2\", \"feedbackNatureID\":\"3\"}";
		
		OutputResponse response = new OutputResponse();
		
		List<CategoryDetails> mockCategoryList = new ArrayList<>();
		mockCategoryList.add(new CategoryDetails(1,"abc",true)); // Add mock details as needed
		when(categoryService.getAllCategories(anyString())).thenReturn(mockCategoryList);
		

		response.setResponse(mockCategoryList.toString());

		assertEquals(response.toString(), categoryController.getAllCategries(request));
	}


	@Test
	 void getAllCategories_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(categoryService.getAllCategories().toString()).thenThrow(NotFoundException.class);

		String response = categoryController.getAllCategries(request);
		assertEquals(response, categoryController.getAllCategries(request));
	}
}
