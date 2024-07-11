package com.iemr.common.controller.uptsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.service.uptsu.UptsuService;
import com.iemr.common.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
public class UPTechnicalSupportControllerTest {

	@Mock
	private UptsuService uptsuService;

	@InjectMocks
	private UPTechnicalSupportController controller;

	@BeforeEach
	void setUp() {
		// This is where you can set up common mock behaviors, if any.
	}

	@Test
	void testGetFacilitySuccess() {
		// Arrange
		Integer providerServiceMapID = 1;
		String blockName = "BlockA";
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setResponse("Some Facility Details"); // Assume this is what getFacility would return
		when(uptsuService.getFacility(providerServiceMapID, blockName)).thenReturn("Some Facility Details");

		// Act
		String actualResponse = controller.getFacility(providerServiceMapID, blockName);

		// Assert
		assertNotNull(actualResponse);
		// Here, you might need to parse actualResponse if it's JSON or directly compare
		// if it's a simple string
		assertEquals(expectedResponse.toString(), actualResponse);
		verify(uptsuService, times(1)).getFacility(providerServiceMapID, blockName);
	}

	@Test
	 void testGetFacilityException() throws Exception {
		// Given
		Integer providerServiceMapID = 1;
		String blockName = "TestBlock";
		doThrow(RuntimeException.class).when(uptsuService).getFacility(providerServiceMapID, blockName);

		// When
		String response = controller.getFacility(providerServiceMapID, blockName);


		// Then
		verify(uptsuService).getFacility(providerServiceMapID, blockName);

		assert response.contains("Failed with null");
	}

	@Test
	void testSaveAppointmentDetailsSuccess() throws Exception {
		String sampleRequest = "{\"key\":\"value\"}";
		String authorizationToken = "Bearer token";
		// Arrange
		String expectedResponseContent = "Success";
		when(uptsuService.saveAppointmentDetails(anyString(), anyString())).thenReturn(expectedResponseContent);

		// Act
		String actualResponse = controller.saveAppointmentDetails(sampleRequest, authorizationToken);

		// Assert
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains(expectedResponseContent)); // Simplistic check, consider using JSON parsing
																		// for deeper validation
		verify(uptsuService, times(1)).saveAppointmentDetails(sampleRequest, authorizationToken);
	}

	@Test
	void testSaveAppointmentDetailsException() throws Exception {
		String sampleRequest = "{\"key\":\"value\"}";
		String authorizationToken = "Bearer token";
		// Arrange
		when(uptsuService.saveAppointmentDetails(anyString(), anyString())).thenThrow(RuntimeException.class);

		// Act
		String actualResponse = controller.saveAppointmentDetails(sampleRequest, authorizationToken);

		// Assert
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("5000")); // Assuming your error format includes the error code
	}

}
