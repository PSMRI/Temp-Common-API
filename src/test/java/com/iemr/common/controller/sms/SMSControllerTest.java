package com.iemr.common.controller.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.iemr.common.model.sms.CreateSMSRequest;
import com.iemr.common.model.sms.SMSParameterModel;
import com.iemr.common.model.sms.SMSRequest;
import com.iemr.common.model.sms.SMSTypeModel;
import com.iemr.common.model.sms.UpdateSMSRequest;
import com.iemr.common.service.sms.SMSService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class SMSControllerTest {

	@InjectMocks
	SMSController smsController;

	@Mock
	SMSService smsService;

	@Mock
	private HttpServletRequest serverRequest;

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Mock
	InputMapper inputMapper = new InputMapper();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testGetSMSTemplates() throws Exception, JsonProcessingException {
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		Map<String, Object> testResponseMap = new HashMap<>();
		testResponseMap.put("key1", "value1");
		testResponseMap.put("key2", "value2");
		String requestJson = objectMapper.createObjectNode().put("providerServiceMapID", 123).toString();
		SMSRequest request = objectMapper.readValue(requestJson, SMSRequest.class);
		String testResponse = objectMapper.writeValueAsString(testResponseMap);
		when(smsService.getSMSTemplates(Mockito.any())).thenReturn(testResponse);
		String result = smsController.getSMSTemplates(request, serverRequest);
		JsonNode resultJson = objectMapper.readTree(result);
		JsonNode expData = objectMapper.readTree(testResponse);
		assertEquals(expData, resultJson.get("data"));
		verify(smsService, times(1)).getSMSTemplates(Mockito.any());
	}

	@Test
	void getFullSMSTemplate_Success() throws Exception {
		// Arrange
		SMSRequest request = new SMSRequest(); // Adjust with actual parameters if needed
		request.setProviderServiceMapID(1); // Example setter, adjust according to your SMSRequest class
		request.setSmsTemplateID(2); // Example setter

		String expectedResponse = "Expected response"; // Adjust based on your needs
		when(smsService.getFullSMSTemplate(any(SMSRequest.class))).thenReturn(expectedResponse);

		// Act
		String actualResponse = smsController.getFullSMSTemplate(request, new MockHttpServletRequest());

		// Assert
		assertTrue(actualResponse.contains(expectedResponse));
	}

	@Test
	void testSaveSMSTemplateSuccess() throws Exception {
		// Given
		CreateSMSRequest request = new CreateSMSRequest(); // Assuming you have a constructor or use a real object
		when(smsService.saveSMSTemplate(any(CreateSMSRequest.class))).thenReturn("Success response");

		// When
		String result = smsController.saveSMSTemplate(request, serverRequest);

		// Then
		assertNotNull(result);
		// Assuming the response is a JSON or similar string. You might need to adjust
		// this based on actual response structure.
		assertTrue(result.contains("Success response"));
	}

	@Test
	void testUpdateSMSTemplateSuccess() throws Exception {
		// Arrange
		UpdateSMSRequest request = new UpdateSMSRequest(); // Mock or create a real instance as needed

		when(smsService.updateSMSTemplate(any(UpdateSMSRequest.class))).thenReturn("Success response");

		// When
		String result = smsController.updateSMSTemplate(request, serverRequest);

		// Then
		assertNotNull(result);
		// Assuming the response is a JSON or similar string. You might need to adjust
		// this based on actual response structure.
		assertTrue(result.contains("Success response"));
	}

	@Test
	void testGetSMSTypesSuccess() throws Exception {
		// Arrange
		SMSTypeModel request = new SMSTypeModel(); // Assume this is your request model. Initialize as needed.

		String expectedResponse = "Expected response";
		when(smsService.getSMSTypes(any(SMSTypeModel.class))).thenReturn(expectedResponse);

		// Act
		String result = smsController.getSMSTypes(request, serverRequest);

		// Assert
		assertNotNull(result, "Result should not be null");
		assertTrue(result.contains(expectedResponse), "Result should contain the expected response");
	}

	@Test
	void testGetSMSParametersSuccess() throws Exception {
		// Arrange
		SMSParameterModel request = new SMSParameterModel(); // Prepare your request object
		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("Success response"); // Simulate a success response

		when(smsService.getSMSParameters(any(SMSParameterModel.class))).thenReturn("Success response");

		// Act
		String actualResponse = smsController.getSMSParameters(request, serverRequest);

		// Assert
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Success response"));

		verify(smsService).getSMSParameters(any(SMSParameterModel.class)); // Verify smsService was called
	}

	@Test
	void testSendSMSSuccess() throws Exception {
		// Arrange
		String jsonRequest = "[{\"providerServiceMapID\":\"1\",\"smsTemplateTypeID\":\"1\"}]"; // Simplified JSON
																								// input
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setResponse("Success");

		when(serverRequest.getHeader("Authorization")).thenReturn("Bearer token");
		when(smsService.sendSMS(anyList(), anyString())).thenReturn("Success");

		// Act
		String actualResponse = smsController.sendSMS(jsonRequest, serverRequest);

		// Assert
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Success"));

		// Verify that the service method was called with the correct parameters
		verify(smsService).sendSMS(anyList(), eq("Bearer token"));
	}

	@Test
	void testGetFullSMSTemplateThrowsException() throws Exception {
		// Setup mock for static method within the test method
		try (MockedStatic<OutputMapper> mockedOutputMapper = mockStatic(OutputMapper.class)) {
			Gson gson = new Gson(); // Or use your specific Gson configuration
			mockedOutputMapper.when(OutputMapper::gson).thenReturn(gson);

			SMSRequest request = new SMSRequest();
			// Configure your request as needed

			MockHttpServletRequest serverRequest = new MockHttpServletRequest();

			// Mock the service to throw an exception when called
			when(smsService.getFullSMSTemplate(any(SMSRequest.class)))
					.thenThrow(new RuntimeException("Test exception"));

			// Execute the method under test
			String response = smsController.getFullSMSTemplate(request, serverRequest);

			// Assertions and verifications
			assertNotNull(response);
			assertTrue(response.contains("error")); // Adjust based on your error response format
			// Verify that your service method was called as expected
			verify(smsService, times(1)).getFullSMSTemplate(any(SMSRequest.class));
		}
	}

	@Test
	void testSaveSMSTemplateThrowsException() throws Exception {
		try (MockedStatic<OutputMapper> mockedOutputMapper = Mockito.mockStatic(OutputMapper.class)) {
			mockedOutputMapper.when(() -> OutputMapper.gson()).thenReturn(new Gson()); // Provide your mocked behavior

			// Setup other mocks and dependencies as necessary
			SMSService smsService = mock(SMSService.class); // Mock your SMS service

			CreateSMSRequest request = new CreateSMSRequest(); // Populate your request
			MockHttpServletRequest serverRequest = new MockHttpServletRequest(); // Mock request

			// Execute and assertions
			String response = smsController.saveSMSTemplate(request, serverRequest);
			assertNotNull(response);
			assertTrue(response.contains("error")); // Adjust based on your error format
		}
	}

	@Test
	void updateSMSTemplate_CatchBlockExecuted() throws Exception {
		// Use try-with-resources to ensure MockedStatic is closed after the test
		try (MockedStatic<OutputMapper> mockedOutputMapper = Mockito.mockStatic(OutputMapper.class)) {
			// Mock OutputMapper.gson() to return a new Gson instance
			mockedOutputMapper.when(OutputMapper::gson).thenReturn(new Gson());

			// Mock SMSService
			SMSService mockSMSService = mock(SMSService.class);
			// Configure SMSService to throw an exception when updateSMSTemplate is called

			// Mock HttpServletRequest
			HttpServletRequest mockRequest = mock(HttpServletRequest.class);

			// Create and populate your UpdateSMSRequest here
			UpdateSMSRequest request = new UpdateSMSRequest();
			// Populate request as necessary

			// Execute the method under test
			String result = smsController.updateSMSTemplate(request, mockRequest);

			// Verify the result indicates an error
			assertTrue(result.contains("error"), "Expected the response to contain an error indication.");
		}
	}

	@Test
	void getSMSTypes_CatchBlockExecuted() throws Exception {
		// Mock the dependencies
		SMSService mockSMSService = mock(SMSService.class);
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);

		// Setup MockedStatic for OutputMapper.gson()
		try (MockedStatic<OutputMapper> mockedOutputMapper = Mockito.mockStatic(OutputMapper.class)) {
			mockedOutputMapper.when(OutputMapper::gson).thenReturn(new Gson());

			// Create a dummy SMSTypeModel instance as the request body
			SMSTypeModel request = new SMSTypeModel();
			// Populate the request object as necessary

			// Execute the method under test
			String response = smsController.getSMSTypes(request, mockRequest);

			// Verify that the response contains an error. Adjust the assertion as necessary
			// based on your error handling.
			assertTrue(response.contains("error"), "Expected the response to indicate an error");
		}
	}

	@Test
	void getSMSParameters_CatchBlockExecuted() throws Exception {
		// Create mock instances for the dependencies
		SMSService mockSMSService = mock(SMSService.class);
		HttpServletRequest mockHttpServletRequest = mock(HttpServletRequest.class);

		// Mock static method using MockedStatic
		try (MockedStatic<OutputMapper> mockedOutputMapper = Mockito.mockStatic(OutputMapper.class)) {
			// Setup the mock to return a new Gson object whenever OutputMapper.gson() is
			// called
			mockedOutputMapper.when(OutputMapper::gson).thenReturn(new Gson());

			// controller class name

			// Prepare your SMSParameterModel instance
			SMSParameterModel request = new SMSParameterModel();
			// Set properties on the request as needed

			// Call the method under test
			String result = smsController.getSMSParameters(request, mockHttpServletRequest);

			// Assert that the result contains an error message
			assertTrue(result.contains("error"),
					"The response should contain an error message due to the simulated exception.");
		}
	}

}
