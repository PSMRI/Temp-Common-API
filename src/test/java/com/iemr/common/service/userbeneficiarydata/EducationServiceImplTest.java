package com.iemr.common.service.userbeneficiarydata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
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

import com.iemr.common.data.beneficiary.BeneficiaryEducation;
import com.iemr.common.repository.beneficiary.CommunityRepository;
import com.iemr.common.repository.beneficiary.EducationRepository;

@ExtendWith(MockitoExtension.class)
public class EducationServiceImplTest {

	@Mock
	private EducationRepository educationRepository;

	@InjectMocks
	private EducationServiceImpl educationService;

	@BeforeEach
	 void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	 void testGetActiveEducations_WithValidData() {
		Set<Object[]> mockData = new HashSet<>();
		mockData.add(new Object[] { 1L, "Primary" });
		mockData.add(new Object[] { 2L, "Secondary" });

		when(educationRepository.findActiveEducations()).thenReturn(mockData);

		List<BeneficiaryEducation> result = educationService.getActiveEducations();

		assertEquals(2, result.size());
	}

	@Test
	 void testGetActiveEducations_EmptySet() {
		Set<Object[]> mockData = new HashSet<>();

		when(educationRepository.findActiveEducations()).thenReturn(mockData);

		List<BeneficiaryEducation> result = educationService.getActiveEducations();

		assertEquals(0, result.size());
	}

}
