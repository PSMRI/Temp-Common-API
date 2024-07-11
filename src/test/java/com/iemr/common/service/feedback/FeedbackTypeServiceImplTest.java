package com.iemr.common.service.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.feedback.FeedbackType;
import com.iemr.common.repository.feedback.FeedbackTypeRepository;

@ExtendWith(MockitoExtension.class)
class FeedbackTypeServiceImplTest {

	@Test
	void testGetActiveFeedbackTypes() {
		// Initialize mocks
		FeedbackTypeRepository mockRepository = Mockito.mock(FeedbackTypeRepository.class);

		// Sample data
		Set<Object[]> sampleData = new HashSet<>();
		sampleData.add(new Object[] { 1, "Type 1" });
		sampleData.add(new Object[] { 2, "Type 2" });

		// Stubbing repository
		Mockito.when(mockRepository.findActiveFeedbackTypes()).thenReturn(sampleData);

		// Service initialization
		FeedbackTypeServiceImpl service = new FeedbackTypeServiceImpl();
		service.setFeedbackTypeRepository(mockRepository);

		// Execute service method
		List<FeedbackType> result = service.getActiveFeedbackTypes();

		// Assertions
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void testGetActiveFeedbackTypesWithProviderServiceMapID() {
		// Initialize mocks
		FeedbackTypeRepository mockRepository = Mockito.mock(FeedbackTypeRepository.class);
		Integer providerServiceMapID = 100; // Example ID

		// Sample data
		List<FeedbackType> sampleData = List.of(new FeedbackType(1, "Type 1"));

		// Stubbing repository
		Mockito.when(mockRepository.findActiveFeedbackTypes(anyInt())).thenReturn(sampleData);

		// Service initialization
		FeedbackTypeServiceImpl service = new FeedbackTypeServiceImpl();
		service.setFeedbackTypeRepository(mockRepository);

		// Execute service method
		List<FeedbackType> result = service.getActiveFeedbackTypes(providerServiceMapID);

		// Assertions
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("Type 1", result.get(0).getFeedbackTypeName());
	}

}
