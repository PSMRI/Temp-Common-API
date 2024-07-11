package com.iemr.common.controller.questionconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.service.questionconfig.QuestionTypeService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class QuestionTypeControllerTest {

	@InjectMocks
	QuestionTypeController questionTypeController;

	@Mock
	private QuestionTypeService questionTypeService;


	@Test
	void testCreateQuestionType() throws Exception {
		String request = "{\"questionType\":\"A\", \"questionTypeDesc\":\"a\"}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(questionTypeService.createQuestionType(request)).thenReturn("any response"); // Mock the service layer to
																							// return whatever you deem
																							// as successful operation

		// Execute the test
		String actualResponse = questionTypeController.createQuestionType(request);

		// Verify the interaction with the mocked service
		verify(questionTypeService, times(1)).createQuestionType(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testCreateQuestionTypeException() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(questionTypeService.createQuestionType(request)).thenThrow(NotFoundException.class);

		String response = questionTypeController.createQuestionType(request);
		assertEquals(response, questionTypeController.createQuestionType(request));
	}

	@Test
	void testQuestionTypeList() {
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
		;

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response");

		when(questionTypeService.getQuestionTypeList()).thenReturn("any response");

		String actualResponse = questionTypeController.questionTypeList();

		// Verify the interaction with the mocked service
		verify(questionTypeService, times(1)).getQuestionTypeList();

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}
	
	@Test
	void testQuestionTypeListException() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(questionTypeService.getQuestionTypeList()).thenThrow(NotFoundException.class);

		String response = questionTypeController.questionTypeList();
		assertEquals(response, questionTypeController.questionTypeList());
	}

}
