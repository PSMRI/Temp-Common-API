package com.iemr.common.service.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.repository.feedback.FeedbackRequestRepository;

@ExtendWith(MockitoExtension.class)
class FeedbackRequestServiceImplTest {

	@Mock
	private FeedbackRequestRepository feedbackRequestRepository;

	@InjectMocks
	private FeedbackRequestServiceImpl feedbackRequestService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetFeedbackRequest() {
		// Given
		Long feedbackRequestID = 1L;
		FeedbackRequest expectedFeedbackRequest = new FeedbackRequest();
		expectedFeedbackRequest.setFeedbackRequestID(feedbackRequestID);
		expectedFeedbackRequest.setFeedbackID(2L); // Additional properties as needed

		when(feedbackRequestRepository.findByFeedbackRequestID(feedbackRequestID)).thenReturn(expectedFeedbackRequest);

		// When
		FeedbackRequest result = feedbackRequestService.getFeedbackReuest(feedbackRequestID);

		// Then
		assertNotNull(result, "FeedbackRequest should not be null");
		assertEquals(expectedFeedbackRequest, result, "The returned FeedbackRequest does not match the expected");
		assertEquals(feedbackRequestID, result.getFeedbackRequestID(), "The FeedbackRequest ID does not match");

		// Verify the interaction with the mocked repository
		verify(feedbackRequestRepository, times(1)).findByFeedbackRequestID(feedbackRequestID);
	}

}
