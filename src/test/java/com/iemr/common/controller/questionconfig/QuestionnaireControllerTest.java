package com.iemr.common.controller.questionconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.service.questionconfig.QuestionnaireService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class QuestionnaireControllerTest {

	@InjectMocks
	QuestionnaireController questionnaireController;

	@Mock
	private QuestionnaireService questionnaireService;

	@Test
	void testCreateQuestionnaire() throws IEMRException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(questionnaireService.createQuestionnaire(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = questionnaireController.createQuestionnaire(request);

		// Verify the interaction with the mocked service
		verify(questionnaireService, times(1)).createQuestionnaire(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testCreateQuestionnaireException() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(questionnaireService.createQuestionnaire(request)).thenThrow(NotFoundException.class);

		String response = questionnaireController.createQuestionnaire(request);
		assertEquals(response, questionnaireController.createQuestionnaire(request));
	}

	@Test
	void testQuestionTypeList() {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(questionnaireService.getQuestionnaireList()).thenReturn("any response");

		// Execute the test
		String actualResponse = questionnaireController.questionTypeList();

		// Verify the interaction with the mocked service
		verify(questionnaireService, times(1)).getQuestionnaireList();

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testQuestionTypeListException() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(questionnaireService.getQuestionnaireList()).thenThrow(NotFoundException.class);

		String response = questionnaireController.questionTypeList();
		assertEquals(response, questionnaireController.questionTypeList());
	}

}
