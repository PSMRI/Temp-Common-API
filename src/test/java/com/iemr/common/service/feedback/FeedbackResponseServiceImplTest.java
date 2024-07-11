package com.iemr.common.service.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.notification.exception.IEMRException;
import com.iemr.common.repository.feedback.FeedbackRequestRepository;
import com.iemr.common.repository.feedback.FeedbackResponseRepository;
import com.iemr.common.utils.mapper.InputMapper;

@ExtendWith(MockitoExtension.class)
class FeedbackResponseServiceImplTest {

	@Mock
	private FeedbackResponseRepository feedbackResponseRepository;

	@Mock
	private FeedbackRequestRepository feedbackRequestRepository;

	@Mock
	private InputMapper inputMapper;

	@InjectMocks
	private FeedbackResponseServiceImpl service;

	@Test
	void testGetFeedbackResponse() {
		FeedbackResponse mockResponse = new FeedbackResponse();
		mockResponse.setFeedbackResponseID(1L); // Assuming an ID setter method exists
		when(feedbackResponseRepository.findByFeedbackResponseID(1L)).thenReturn(mockResponse);

		FeedbackResponse result = service.getFeedbackResponse(1L);

		assertNotNull(result);
		assertEquals(1L, result.getFeedbackResponseID());
	}

	@Test
	void testCreateFeedbackResponse() {
		FeedbackResponse feedbackResponse = new FeedbackResponse();
		when(feedbackResponseRepository.save(any(FeedbackResponse.class))).thenReturn(feedbackResponse);

		FeedbackResponse createdResponse = service.createFeedbackResponse(feedbackResponse);

		assertNotNull(createdResponse);
	}

	@Test
	void testCreateFeedbackRequest() {
		FeedbackRequest feedbackRequest = new FeedbackRequest();
		when(feedbackRequestRepository.save(any(FeedbackRequest.class))).thenReturn(feedbackRequest);

		FeedbackRequest createdRequest = service.createFeedbackRequest(feedbackRequest);

		assertNotNull(createdRequest);
	}

	@Test
	void testGetdataById() {
		Long id = 1L;
		ArrayList<Object[]> mockData = new ArrayList<>();
		mockData.add(new Object[] { "Data1", "Data2" }); // Simplify to match your actual use case
		when(feedbackResponseRepository.getdatabyId(id)).thenReturn(mockData);

		ArrayList<Object[]> result = service.getdataById(id);

		assertFalse(result.isEmpty());
		assertEquals(2, result.get(0).length);
	}

}
