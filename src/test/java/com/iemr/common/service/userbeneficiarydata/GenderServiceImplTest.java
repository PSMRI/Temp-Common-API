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

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.repository.beneficiary.EducationRepository;
import com.iemr.common.repository.userbeneficiarydata.GenderRepository;

@ExtendWith(MockitoExtension.class)
class GenderServiceImplTest {

	@Mock
	private GenderRepository genderRepository;

	@InjectMocks
	private GenderServiceImpl genderService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetActiveGenders_ReturnsNonEmptyList() {
		// Mocking the repository response
		Set<Object[]> mockedResponse = new HashSet<>();
		mockedResponse.add(new Object[] { 1, "Male" });
		mockedResponse.add(new Object[] { 2, "Female" });

		when(genderRepository.findAciveGenders()).thenReturn(mockedResponse);

		// Calling the method under test
		List<Gender> activeGenders = genderService.getActiveGenders();

		// Assertions
		assertEquals(2, activeGenders.size(), "Should return a list with two genders");

	}

	@Test
	void testGetActiveGenders_ReturnsEmptyListWhenRepositoryIsEmpty() {
		// Mocking an empty repository response
		when(genderRepository.findAciveGenders()).thenReturn(new HashSet<>());

		// Calling the method under test
		List<Gender> activeGenders = genderService.getActiveGenders();

		// Assertions
		assertEquals(0, activeGenders.size(), "Should return an empty list");
	}

}
