package com.iemr.common.service.userbeneficiarydata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.repository.userbeneficiarydata.GenderRepository;
import com.iemr.common.repository.userbeneficiarydata.MaritalStatusRepository;
@ExtendWith(MockitoExtension.class)
class MaritalStatusServiceImplTest {

	@Mock
	private MaritalStatusRepository maritalStatusRepository;

	@InjectMocks
	private MaritalStatusServiceImpl maritalStatusService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	

	@Test
	void testGetActiveMaritalStatus_ReturnsNonEmptyList() {
		// Mocking the repository response
		Set<Object[]> mockedResponse = new HashSet<>();
		mockedResponse.add(new Object[] { 1, "Single" });
		mockedResponse.add(new Object[] { 2, "Married" });

		when(maritalStatusRepository.findAciveMaritalStatus()).thenReturn(mockedResponse);

		// Calling the method under test
		List<MaritalStatus> activeMaritalStatuses = maritalStatusService.getActiveMaritalStatus();

		// Assertions
		assertEquals(2, activeMaritalStatuses.size(), "Should return a list with two marital statuses");
	}

	@Test
	void testGetActiveMaritalStatus_ReturnsEmptyListWhenRepositoryIsEmpty() {
		// Mocking an empty repository response
		when(maritalStatusRepository.findAciveMaritalStatus()).thenReturn(new HashSet<>());

		// Calling the method under test
		List<MaritalStatus> activeMaritalStatuses = maritalStatusService.getActiveMaritalStatus();

		// Assertions
		assertEquals(0, activeMaritalStatuses.size(), "Should return an empty list");
	}

}
