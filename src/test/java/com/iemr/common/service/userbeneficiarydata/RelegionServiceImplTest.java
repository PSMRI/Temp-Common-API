package com.iemr.common.service.userbeneficiarydata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iemr.common.data.userbeneficiarydata.Religion;
import com.iemr.common.repository.userbeneficiarydata.MaritalStatusRepository;
import com.iemr.common.repository.userbeneficiarydata.ReligionRepository;

class RelegionServiceImplTest {
	@Mock
	private ReligionRepository religionRepository;

	@InjectMocks
	private RelegionServiceImpl religionService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getActiveReligionsReturnsCorrectData() {
		// Setup our mocked repository
		Object[] religionData1 = { 1, "Hinduism", "Active" };
		Object[] religionData2 = { 2, "Islam", "Active" };
		List<Object[]> mockData = Arrays.asList(religionData1, religionData2);
		when(religionRepository.getActiveReligions()).thenReturn(mockData);

		// Execute the service call
		List<Religion> result = religionService.getActiveReligions();

		// Validate the results
		assertNotNull(result, "The result should not be null");
		assertEquals(2, result.size(), "There should be two active religions in the result");

		// Validate the content of the result
		assertEquals(1, result.get(0).getReligionID());
		assertEquals("Hinduism", result.get(0).getReligionType());
		assertEquals("Active", result.get(0).getReligionDesc());

		assertEquals(2, result.get(1).getReligionID());
		assertEquals("Islam", result.get(1).getReligionType());
		assertEquals("Active", result.get(1).getReligionDesc());
	}

}
