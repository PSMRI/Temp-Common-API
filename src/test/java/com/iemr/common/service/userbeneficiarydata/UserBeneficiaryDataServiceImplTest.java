package com.iemr.common.service.userbeneficiarydata;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.repository.userbeneficiarydata.UserBeneficiaryDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class UserBeneficiaryDataServiceImplTest {

	@Mock
	private UserBeneficiaryDataRepository userBeneficiaryDataRepository;

	@InjectMocks
	private UserBeneficiaryDataServiceImpl userBeneficiaryDataService;

	@BeforeEach
	 void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	 void getActiveGender_WhenFound() {
		// Arrange
		Set<Object[]> mockResponse = new HashSet<>();
		mockResponse.add(new Object[] { 1, "Male" });
		mockResponse.add(new Object[] { 2, "Female" });
		when(userBeneficiaryDataRepository.findActiveGenders()).thenReturn(mockResponse);

		// Act
		List<Gender> result = userBeneficiaryDataService.getActiveGender();

		// Assert
		assertEquals(2, result.size());
		assertTrue(result.stream().anyMatch(g -> g.getGenderName().equals("Male") && g.getGenderID().equals(1)));
		assertTrue(result.stream().anyMatch(g -> g.getGenderName().equals("Female") && g.getGenderID().equals(2)));
	}

	@Test
	 void getActiveGender_WhenNoneFound() {
		// Arrange
		Set<Object[]> mockResponse = new HashSet<>();
		when(userBeneficiaryDataRepository.findActiveGenders()).thenReturn(mockResponse);

		// Act
		List<Gender> result = userBeneficiaryDataService.getActiveGender();

		// Assert
		assertTrue(result.isEmpty());
	}

}
