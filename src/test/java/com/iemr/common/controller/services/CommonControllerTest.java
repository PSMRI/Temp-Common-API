package com.iemr.common.controller.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.service.services.CommonService;
import com.iemr.common.service.services.Services;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class CommonControllerTest {

	@InjectMocks
	CommonController commonController;

	@Mock
	private CommonService commonService;

	@Mock
	private Services services;

	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void getCategoriesTest() throws IEMRException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		String request = "{\"providerServiceMapID\":1,  \"subServiceID\":\"subServiceID\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getCategories(request).toString());

		assertEquals(response.toString(), commonController.getCategories(request));
	}

	@Test
	void getCategoriesTest_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(commonService.getCategories(request).toString()).thenThrow(NotFoundException.class);
		String response = commonController.getCategories(request);
		assertEquals(response, commonController.getCategories(request));
	}

	@Test
	void testGetSubcategories() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"categoryID\":\"1\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getSubCategories(request).toString());

		assertEquals(response.toString(), commonController.getSubcategories(request));

	}

	@Test
	void testGetSubcategories_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(commonService.getSubCategories(request).toString()).thenThrow(NotFoundException.class);
		String response = commonController.getSubcategories(request);
		assertEquals(response, commonController.getSubcategories(request));
	}

	@Test
	void testGetSubCategoryFiles() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"categoryID\":\"1\", \"providerServiceMapID\":\"1\", " + "\"subCategoryID\":\"1\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getSubCategoryFiles(request).toString());

		assertEquals(response.toString(), commonController.getSubCategoryFiles(request));
	}

	@Test
	void testGetSubCategoryFiles_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(commonService.getSubCategoryFiles(request).toString()).thenThrow(NotFoundException.class);

		String response = commonController.getSubCategoryFiles(request);
		assertEquals(response, commonController.getSubCategoryFiles(request));
	}

	@Test
	void testGetSubCategoryFilesWithURL() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"categoryID\":\"1\", \"providerServiceMapID\":\"1\", " + "\"subCategoryID\":\"1\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getSubCategoryFilesWithURL(request).toString());

		assertEquals(response.toString(), commonController.getSubCategoryFilesWithURL(request));
	}

	@Test
	void testGetSubCategoryFilesWithURL_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(commonService.getSubCategoryFilesWithURL(request).toString()).thenThrow(NotFoundException.class);

		String response = commonController.getSubCategoryFilesWithURL(request);
		assertEquals(response, commonController.getSubCategoryFilesWithURL(request));
	}

	@Test
	void testGetcategoriesById() throws IEMRException, JsonMappingException, JsonProcessingException {

		String request = "{\"subServiceID\":\"1\", \"providerServiceMapID\":\"1\", " + "\"subCategoryID\":\"1\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getCategories(request).toString());

		assertEquals(response.toString(), commonController.getcategoriesById(request));
	}

	@Test
	void testGetcategoriesById_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(commonService.getCategories(request).toString()).thenThrow(NotFoundException.class);

		String response = commonController.getcategoriesById(request);
		assertTrue(response.contains("Failed with null"));
	}

	@Test
	void testGetservicetypes() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"\"providerServiceMapID\":\"1\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getActiveServiceTypes(request).toString());

		assertEquals(response.toString(), commonController.getservicetypes(request));
	}

	@Test
	void testGetservicetypes_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(commonService.getActiveServiceTypes(request).toString()).thenThrow(NotFoundException.class);

		String response = commonController.getservicetypes(request);
		assertEquals(response, commonController.getservicetypes(request));
	}

	@Test
	void testServiceList() {
		String request = "{\"\"serviceList\":\"abc\"}";
		OutputResponse response = new OutputResponse();

		response.setResponse(services.servicesList().toString());

		assertEquals(response.toString(), commonController.serviceList(request));
	}

	@Test
	void testServiceList_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(services.servicesList().toString()).thenThrow(NotFoundException.class);

		String response = commonController.serviceList(request);
		assertEquals(response, commonController.serviceList(request));
	}

}
