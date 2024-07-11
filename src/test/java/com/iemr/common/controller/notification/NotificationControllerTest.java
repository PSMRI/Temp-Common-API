package com.iemr.common.controller.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.service.notification.NotificationService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

	@InjectMocks
	private NotificationController notificationController;

	@Mock
	private NotificationService notificationService;

	@Test
	void testGetNotification() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.getNotification(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.getNotification(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");

	}

	@Test
	void testGetNotificationException() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.getNotification(request)).thenThrow(NotFoundException.class);

		String response = notificationController.getNotification(request);
		assertEquals(response, notificationController.getNotification(request));
	}

	@Test
	void testGetSupervisorNotification() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.getSupervisorNotification(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.getSupervisorNotification(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testGetSupervisorNotification_Exception() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.getSupervisorNotification(request)).thenThrow(NotFoundException.class);

		String response = notificationController.getSupervisorNotification(request);
		assertEquals(response, notificationController.getSupervisorNotification(request));
	}

	@Test
	void testCreateNotification() throws NoSuchAlgorithmException, IOException, IEMRException, Exception {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.createNotification(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.createNotification(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testCreateNotification_Exception() throws NoSuchAlgorithmException, IOException, IEMRException, Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.createNotification(request)).thenThrow(NotFoundException.class);

		String response = notificationController.createNotification(request);
		assertEquals(response, notificationController.createNotification(request));
	}

	@Test
	void testUpdateNotification()
			throws NoSuchAlgorithmException, JSONException, IOException, IEMRException, Exception {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.updateNotification(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.updateNotification(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testUpdateNotification_Exception()
			throws NoSuchAlgorithmException, JSONException, IOException, IEMRException, Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.updateNotification(request)).thenThrow(NotFoundException.class);

		String response = notificationController.updateNotification(request);
		assertEquals(response, notificationController.updateNotification(request));
	}

	@Test
	void testGetNotificationType() throws IEMRException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.getNotificationType(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.getNotificationType(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testGetNotificationType_Exception() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.getNotificationType(request)).thenThrow(NotFoundException.class);

		String response = notificationController.getNotificationType(request);
		assertEquals(response, notificationController.getNotificationType(request));
	}

	@Test
	void testCreateNotificationType() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.createNotificationType(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.createNotificationType(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testCreateNotificationType_Exception() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		//when(notificationService.getNotificationType(request)).thenThrow(NotFoundException.class);

		String response = notificationController.createNotificationType(request);
		assertEquals(response, notificationController.createNotificationType(request));
	}

	@Test
	void testUpdateNotificationType() throws JSONException, IEMRException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.updateNotificationType(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.updateNotificationType(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testUpdateNotificationType_Exception() throws JSONException, IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.updateNotificationType(request)).thenThrow(NotFoundException.class);

		String response = notificationController.updateNotificationType(request);
		assertEquals(response, notificationController.updateNotificationType(request));
	}

	@Test
	void testGetEmergencyContacts() throws IEMRException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.getEmergencyContacts(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.getEmergencyContacts(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testGetEmergencyContacts_Exception() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.getEmergencyContacts(request)).thenThrow(NotFoundException.class);

		String response = notificationController.getEmergencyContacts(request);
		assertEquals(response, notificationController.getEmergencyContacts(request));
	}

	@Test
	void testGetSupervisorEmergencyContacts() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.getSupervisorEmergencyContacts(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.getSupervisorEmergencyContacts(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testGetSupervisorEmergencyContacts_Exception() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.getSupervisorEmergencyContacts(request)).thenThrow(NotFoundException.class);

		String response = notificationController.getSupervisorEmergencyContacts(request);
		assertEquals(response, notificationController.getSupervisorEmergencyContacts(request));
	}

	@Test
	void testCreateEmergencyContacts() throws NoSuchAlgorithmException, IOException, IEMRException, Exception {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.createEmergencyContacts(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.createEmergencyContacts(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testCreateEmergencyContacts_Exception()
			throws NoSuchAlgorithmException, IOException, IEMRException, Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.createEmergencyContacts(request)).thenThrow(NotFoundException.class);

		String response = notificationController.createEmergencyContacts(request);
		assertEquals(response, notificationController.createEmergencyContacts(request));

	}

	@Test
	void testUpdateEmergencyContacts()
			throws NoSuchAlgorithmException, JSONException, IOException, IEMRException, Exception {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(notificationService.updateEmergencyContacts(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = notificationController.updateEmergencyContacts(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");

	}

	@Test
	void testUpdateEmergencyContacts_Exception()
			throws NoSuchAlgorithmException, JSONException, IOException, IEMRException, Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(notificationService.updateEmergencyContacts(request)).thenThrow(NotFoundException.class);

		String response = notificationController.updateEmergencyContacts(request);
		assertEquals(response, notificationController.updateEmergencyContacts(request));

	}

}
