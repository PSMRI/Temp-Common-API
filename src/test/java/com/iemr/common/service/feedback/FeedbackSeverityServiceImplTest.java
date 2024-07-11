package com.iemr.common.service.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.feedback.FeedbackSeverity;
import com.iemr.common.repository.feedback.FeedbackSeverityRepository;

@ExtendWith(MockitoExtension.class)
class FeedbackSeverityServiceImplTest {

	@Mock
	private FeedbackSeverityRepository feedbackSeverityRepository;

	@InjectMocks
	private FeedbackSeverityServiceImpl feedbackSeverityService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetActiveFeedbackSeverity() {
		Set<Object[]> mockData = new HashSet<>();
		mockData.add(new Object[] { 1, "High" });
		mockData.add(new Object[] { 2, "Medium" });
		when(feedbackSeverityRepository.getActiveFeedbackSeverity()).thenReturn(mockData);

		List<FeedbackSeverity> result = feedbackSeverityService.getActiveFeedbackSeverity();

		assertNotNull(result);
		assertEquals(2, result.size());
		verify(feedbackSeverityRepository).getActiveFeedbackSeverity();
	}

	@Test
	void testGetActiveFeedbackSeverityWithProviderServiceMapID() {
		Integer providerServiceMapID = 1;
		List<FeedbackSeverity> mockData = List.of(new FeedbackSeverity(1, "High"));
		when(feedbackSeverityRepository.getActiveFeedbackSeverity(providerServiceMapID)).thenReturn(mockData);

		List<FeedbackSeverity> result = feedbackSeverityService.getActiveFeedbackSeverity(providerServiceMapID);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("High", result.get(0).getSeverityTypeName());
		verify(feedbackSeverityRepository).getActiveFeedbackSeverity(providerServiceMapID);
	}

}
