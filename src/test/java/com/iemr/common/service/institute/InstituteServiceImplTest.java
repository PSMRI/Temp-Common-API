package com.iemr.common.service.institute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

import com.iemr.common.data.institute.Institute;
import com.iemr.common.repository.institute.InstituteRepository;

@ExtendWith(MockitoExtension.class)
class InstituteServiceImplTest {

	@Mock
	private InstituteRepository instituteRepository;

	@InjectMocks
	private InstituteServiceImpl instituteService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenFindActiveInstitutesByStateDistBlockIDReturnsNonEmpty_thenSuccess() {
		Set<Object[]> mockedResult = new HashSet<>();
		mockedResult.add(new Object[] { 1, "Institute A" });
		when(instituteRepository.findAciveInstitutesByStateDistBlockID(1, 1, 1)).thenReturn(mockedResult);

		List<Institute> institutes = instituteService.getInstitutesByStateDistrictBranch(1, 1, 1);

		assertFalse(institutes.isEmpty(), "Expected non-empty list of institutes");
		assertEquals(1, institutes.size(), "Expected list size to be 1");
	}

	@Test
	void whenFindActiveInstitutesByStateDistBlockIDReturnsEmpty_thenSuccess() {
		when(instituteRepository.findAciveInstitutesByStateDistBlockID(1, 1, 1)).thenReturn(new HashSet<>());

		List<Institute> institutes = instituteService.getInstitutesByStateDistrictBranch(1, 1, 1);

		assertTrue(institutes.isEmpty(), "Expected an empty list of institutes");
	}

	//
	@Test
	void whenFindActiveInstitutesByBranchIDReturnsNonEmpty_thenSuccess() {
		Set<Object[]> mockedResult = new HashSet<>();
		mockedResult.add(new Object[] { 2, "Institute B" });
		when(instituteRepository.findAciveInstitutesByBranchID(1)).thenReturn(mockedResult);

		List<Institute> institutes = instituteService.getInstitutesByBranch(1);

		assertFalse(institutes.isEmpty(), "Expected non-empty list of institutes");
		assertEquals(1, institutes.size(), "Expected list size to be 1");
	}

	@Test
	void whenFindActiveInstitutesByBranchIDReturnsEmpty_thenSuccess() {
		when(instituteRepository.findAciveInstitutesByBranchID(1)).thenReturn(new HashSet<>());

		List<Institute> institutes = instituteService.getInstitutesByBranch(1);

		assertTrue(institutes.isEmpty(), "Expected an empty list of institutes");
	}

}
