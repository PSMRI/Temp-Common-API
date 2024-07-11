package com.iemr.common.controller.lungassessment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.iemr.common.service.lungassessment.LungAssessmentService;

@ExtendWith(MockitoExtension.class)
class LungAssessmentControllerTest {
	@Mock
	private LungAssessmentService lungAssessmentService;

	@InjectMocks
	private LungAssessmentController lungAssessmentController;


	@Test
	void testStartAssessmentSuccess() throws Exception {
		// Arrange
		String requestJson = "{\"patientId\":\"12345\"}";
		MultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain",
				"This is a dummy file content".getBytes());
		when(lungAssessmentService.initiateAssesment(any(String.class), any(MultipartFile.class)))
				.thenReturn("Assessment started successfully");

		// Act
		String result = lungAssessmentController.startAssesment(file, requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("Assessment started successfully"));
	}


	@Test
	void testGetAssessmentSuccess() throws Exception {
		// Arrange
		String assessmentId = "123"; // Example assessment ID
		String expectedResult = "Assessment details"; // Example response from the service
		when(lungAssessmentService.getAssesment(assessmentId)).thenReturn(expectedResult);

		// Act
		String actualResult = lungAssessmentController.getAssessment(assessmentId.toString());

		// Assert
		assertNotNull(actualResult);
		assertTrue(actualResult.contains(expectedResult),
				"The response should contain the assessment details returned by the service.");
	}


	@Test
	void getAssessmentDetailsSuccess() throws Exception {
		// Arrange
		Long patientId = 1L; // Example patient ID
		String serviceResponse = "Assessment Detail"; // Mocked service layer response
		when(lungAssessmentService.getAssessmentDetails(patientId)).thenReturn(serviceResponse);

		// Act
		String result = lungAssessmentController.getAssessmentDetails(patientId);

		// Assert
		assertNotNull(result, "The result should not be null.");
		assertTrue(result.contains(serviceResponse), "The result should contain the service response.");
	}

	@Test
	void startAssesmentTest_ExceptionThrown() throws Exception {
		// Mocking the file and request
		MultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain", "some xml".getBytes());
		String request = "someRequestData";

		// Simulating an exception during the call to initiateAssesment
		doThrow(new RuntimeException("Test exception")).when(lungAssessmentService).initiateAssesment(request, file);

		// Call the method under test
		String response = lungAssessmentController.startAssesment(file, request);

		verify(lungAssessmentService).initiateAssesment(request, file);
	}

	@Test
	void getAssessment_ExceptionThrown() throws Exception {
		// Given
		String assessmentId = "testAssessmentId";
		doThrow(new RuntimeException("Test exception")).when(lungAssessmentService).getAssesment(assessmentId);

		// When
		String response = lungAssessmentController.getAssessment(assessmentId);

		// Then
		// Verify that the service method was called
		verify(lungAssessmentService).getAssesment(assessmentId);
	}

	@Test
	void getAssessmentDetails_ExceptionThrown() throws Exception {
		// Setup
		Long patientId = 1L;
		RuntimeException expectedException = new RuntimeException("Test exception");
		doThrow(expectedException).when(lungAssessmentService).getAssessmentDetails(patientId);

		// Execution
		String response = lungAssessmentController.getAssessmentDetails(patientId);

		// Verification
		verify(lungAssessmentService).getAssessmentDetails(patientId);

	}
}
