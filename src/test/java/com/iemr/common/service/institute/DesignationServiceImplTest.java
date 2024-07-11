package com.iemr.common.service.institute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.repository.institute.DesignationRepository;

@ExtendWith(MockitoExtension.class)
class DesignationServiceImplTest {

	@Mock
	private DesignationRepository designationRepository;

	@InjectMocks
	private DesignationServiceImpl designationService;

	@Test
	void testGetDesignationsReturnsNonEmptyList() {
		// Setup
		List<Designation> mockDesignations = new ArrayList<>();
		mockDesignations.add(new Designation(1, "DesignationName")); // Assuming Designation has an id and name
		when(designationRepository.findAciveDesignations()).thenReturn(mockDesignations);

		// Execute
		List<Designation> result = designationService.getDesignations();

		// Verify
		verify(designationRepository).findAciveDesignations();
		assertFalse(result.isEmpty(), "The designations list should not be empty.");
		assertEquals(1, result.size(), "The designations list should contain exactly one element.");
	}

	@Test
	void testGetDesignationsReturnsEmptyList() {
		// Setup
		when(designationRepository.findAciveDesignations()).thenReturn(new ArrayList<>());

		// Execute
		List<Designation> result = designationService.getDesignations();

		// Verify
		verify(designationRepository).findAciveDesignations();
		assertTrue(result.isEmpty(), "The designations list should be empty when no active designations are found.");
	}

}
