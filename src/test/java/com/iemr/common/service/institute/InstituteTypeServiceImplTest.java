package com.iemr.common.service.institute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.data.institute.InstituteType;
import com.iemr.common.repository.institute.InstituteRepository;
import com.iemr.common.repository.institute.InstituteTypeRepository;
import com.iemr.common.utils.mapper.InputMapper;

@ExtendWith(MockitoExtension.class)
class InstituteTypeServiceImplTest {

	@Mock
	private InstituteTypeRepository instituteTypeRepository;

	@Mock
	private InstituteRepository instituteRepository;

	@Mock
	private InputMapper inputMapper;

	@InjectMocks
	private InstituteTypeServiceImpl instituteTypeService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetInstitutionTypesWithNonNullProviderServiceMapID() throws Exception {
		String instituteTypeRequest = "{\"providerServiceMapID\":1}";
		InstituteType mockInstituteType = new InstituteType();
		mockInstituteType.setProviderServiceMapID(1);

		List<InstituteType> mockResult = new ArrayList<>();
		mockResult.add(new InstituteType()); // Add mock data as per your requirement

		// when(inputMapper.gson()).thenReturn(new Gson());
		when(instituteTypeRepository.findAciveInstitutesTypes(1)).thenReturn(mockResult);

		List<InstituteType> result = instituteTypeService.getInstitutionTypes(instituteTypeRequest);

		assertFalse(result.isEmpty());
		verify(instituteTypeRepository).findAciveInstitutesTypes(1);
	}

	@Test
	void testGetInstitutionTypesWithoutProviderServiceMapID() throws Exception {
		// Assuming the instituteTypeRequest does not contain a providerServiceMapID or
		// it's null
		String instituteTypeRequest = "{}"; // No providerServiceMapID provided
		List<InstituteType> mockResult = new ArrayList<>();
		InstituteType mockInstituteType1 = new InstituteType();
		mockInstituteType1.setInstitutionTypeID(1);
		mockInstituteType1.setInstitutionType("Type A");
		mockInstituteType1.setInstitutionTypeDesc("TypeDescA");

		InstituteType mockInstituteType2 = new InstituteType();
		mockInstituteType2.setInstitutionTypeID(2);
		mockInstituteType2.setInstitutionType("Type B");
		mockInstituteType2.setInstitutionTypeDesc("TypeDescB");

		mockResult.add(mockInstituteType1);
		mockResult.add(mockInstituteType2);

		when(instituteTypeRepository.findAciveInstitutesTypes()).thenReturn(mockResult);

		// Execute the test method
		List<InstituteType> result = instituteTypeService.getInstitutionTypes(instituteTypeRequest);

		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(2, result.size()); // Expecting 2 institute types based on the mocked data

		verify(instituteTypeRepository, times(1)).findAciveInstitutesTypes();

		verify(instituteTypeRepository, never()).findAciveInstitutesTypes(anyInt());
	}

	@Test
	void testGetInstitutionName() throws Exception {
		Integer institutionTypeID = 1;
		ArrayList<Object[]> mockResult = new ArrayList<>();
		mockResult.add(new Object[] { 1, "Institute A" });

		when(instituteRepository.getInstitutionNameByType(institutionTypeID)).thenReturn(mockResult);

		List<Institute> result = instituteTypeService.getInstitutionName(institutionTypeID);

		assertFalse(result.isEmpty());
		assertEquals("Institute A", result.get(0).getInstitutionName());
	}

	@Test
	void testGetInstitutionNameByTypeAndDistrict() throws Exception {
		Integer institutionTypeID = 1;
		Integer districtID = 1;
		ArrayList<Object[]> mockResult = new ArrayList<>();
		mockResult.add(new Object[] { 1, "Institute B" });

		when(instituteRepository.getInstitutionNameByTypeAndDistrict(institutionTypeID, districtID))
				.thenReturn(mockResult);

		List<Institute> result = instituteTypeService.getInstitutionNameByTypeAndDistrict(institutionTypeID,
				districtID);

		assertFalse(result.isEmpty());
		assertEquals("Institute B", result.get(0).getInstitutionName());
	}

}
