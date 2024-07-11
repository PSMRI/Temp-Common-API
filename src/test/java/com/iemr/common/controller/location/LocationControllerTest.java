package com.iemr.common.controller.location;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.service.location.LocationService;

@ExtendWith(SpringExtension.class)
class LocationControllerTest {

	@Mock
	private LocationService locationService;

	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@InjectMocks
	private LocationController locationController;

	@Test
	 void testGetStates_Success() throws Exception {
		// Local setup
		States state1 = new States();
		state1.setStateID(1);
		state1.setStateName("TestState1");
		state1.setCountryID(1);

		States state2 = new States();
		state2.setStateID(2);
		state2.setStateName("TestState2");
		state2.setCountryID(1);

		int countryId = 1;
		List<States> statesList = Arrays.asList(state1, state2);

		// Mocking
		when(locationService.getStates(countryId)).thenReturn(statesList);

		// Execution
		String response = locationController.getStates(countryId);

		// Assertions
		assertNotNull(response);
		assertTrue(response.contains("TestState1"));
		assertTrue(response.contains("TestState2"));

		// Verification
		verify(locationService, times(1)).getStates(countryId);
	}


	@Test
	 void testGetDistricts_Success() throws Exception {
		// Local setup
		Districts district1 = new Districts();
		district1.setDistrictID(1);
		district1.setDistrictName("District1");
		district1.setStateID(1);

		Districts district2 = new Districts();
		district2.setDistrictID(2);
		district2.setDistrictName("District2");
		district2.setStateID(1);

		int stateId = 1;
		List<Districts> districtsList = Arrays.asList(district1, district2);

		// Mocking
		when(locationService.getDistricts(stateId)).thenReturn(districtsList);

		// Execution
		String response = locationController.getDistricts(stateId);

		// Assertions
		assertNotNull(response);
		assertTrue(response.contains("District1"));
		assertTrue(response.contains("District2"));

		// Verification
		verify(locationService, times(1)).getDistricts(stateId);
	}


	@Test
	 void testGetStateDistrictsSuccess() {
		// Given
		int stateId = 1;
		Districts district1 = new Districts(); // Assuming Districts is properly defined elsewhere
		district1.setDistrictID(1);
		district1.setDistrictName("District1");
		district1.setStateID(stateId);

		Districts district2 = new Districts();
		district2.setDistrictID(2);
		district2.setDistrictName("District2");
		district2.setStateID(stateId);

		List<Districts> mockDistrictsList = Arrays.asList(district1, district2);
		when(locationService.findStateDistrictBy(stateId)).thenReturn(mockDistrictsList);

		// When
		String response = locationController.getStatetDistricts(stateId);

		// Then
		assertNotNull(response);
		assertTrue(response.contains("District1"));
		assertTrue(response.contains("District2"));

		// Verify that the service method was called once
		verify(locationService).findStateDistrictBy(stateId);
	}


	@Test
	 void testGetDistrictBlocksSuccess() {
		// Given
		int districtId = 10;
		DistrictBlock block1 = new DistrictBlock(); // Assuming DistrictBlock is properly defined elsewhere
		block1.setBlockID(101);
		block1.setBlockName("Block1");
		block1.setDistrictID(districtId);

		DistrictBlock block2 = new DistrictBlock();
		block2.setBlockID(102);
		block2.setBlockName("Block2");
		block2.setDistrictID(districtId);

		List<DistrictBlock> mockBlockList = Arrays.asList(block1, block2);
		when(locationService.getDistrictBlocks(districtId)).thenReturn(mockBlockList);

		// When
		String response = locationController.getDistrictBlocks(districtId);

		// Then
		assertNotNull(response);
		assertTrue(response.contains("Block1"));
		assertTrue(response.contains("Block2"));

		// Verify that the service method was called once
		verify(locationService).getDistrictBlocks(districtId);
	}



	@Test
	 void testGetCitySuccess() {
		// Given
		int districtId = 1;
		DistrictBlock block1 = new DistrictBlock(); // Assuming DistrictBlock is a valid class
		block1.setBlockID(1);
		block1.setBlockName("City1");
		block1.setDistrictID(districtId);

		DistrictBlock block2 = new DistrictBlock();
		block2.setBlockID(2);
		block2.setBlockName("City2");
		block2.setDistrictID(districtId);

		List<DistrictBlock> mockDistrictBlockList = Arrays.asList(block1, block2);
		when(locationService.getDistrictBlocks(districtId)).thenReturn(mockDistrictBlockList);

		// When
		String response = locationController.getCity(districtId);

		// Then
		assertNotNull(response);
		assertTrue(response.contains("City1"));
		assertTrue(response.contains("City2"));

		// Verify that the service method was called once
		verify(locationService).getDistrictBlocks(districtId);
	}


	@Test
	 void testGetVillagesSuccess() {
		// Given
		int districtId = 1;
		DistrictBranchMapping village1 = new DistrictBranchMapping(); // Assuming a valid class exists
		village1.setBlockID(1);
		village1.setVillageName("Village1");
		village1.setDistrictBranchID(districtId);

		DistrictBranchMapping village2 = new DistrictBranchMapping();
		village2.setBlockID(2);
		village2.setVillageName("Village2");
		village2.setDistrictBranchID(districtId);

		List<DistrictBranchMapping> mockVillageList = Arrays.asList(village1, village2);
		when(locationService.getDistrilctBranchs(districtId)).thenReturn(mockVillageList);

		// When
		String response = locationController.getVillages(districtId);

		// Then
		assertNotNull(response);
		assertTrue(response.contains("Village1"));
		assertTrue(response.contains("Village2"));

		// Verify that the service method was called once
		verify(locationService).getDistrilctBranchs(districtId);
	}


	@Test
	void testGetCountriesSuccess() {
		// Given
		Country country1 = new Country(); // Assuming a valid Country class exists
		country1.setCountryID(1);
		country1.setCountryName("Country1");
		country1.setCountryCode("1");

		Country country2 = new Country();
		country2.setCountryID(2);
		country2.setCountryName("Country2");
		country2.setCountryCode("2");

		List<Country> mockCountryList = Arrays.asList(country1, country2);
		when(locationService.getCountries()).thenReturn(mockCountryList);

		// When
		String response = locationController.getCountries();

		// Then
		assertNotNull(response);
		assertTrue(response.contains("Country1"));
		assertTrue(response.contains("Country2"));

		// Verify that the service method was called once
		verify(locationService).getCountries();
	}

	@Test
	void testGetStatesException() {
		Integer id = 1;
		RuntimeException exception = new RuntimeException("Test exception");

		doThrow(exception).when(locationService).getStates(id);

		String result = locationController.getStates(id);

		assertTrue(result.contains("error")); // Adjust assertion based on actual output format
	}

	@Test
	void testGetDistrictsException() {
		int testId = 1;
		Exception simulatedException = new RuntimeException("Simulated exception");

		doThrow(simulatedException).when(locationService).getDistricts(testId);

		String result = locationController.getDistricts(testId);

		assertTrue(result.contains(simulatedException.getMessage()));
	}

	@Test
	 void testGetStateDistrictsExceptionHandling() {
		int testId = 1;
		String simulatedErrorMessage = "Simulated error";
		Exception simulatedException = new RuntimeException(simulatedErrorMessage);

		doThrow(simulatedException).when(locationService).findStateDistrictBy(testId);

		String result = locationController.getStatetDistricts(testId);

		assertTrue(result.contains("error")); // This assumes your OutputResponse's toString method will output
												// something that can be checked for "error"
	}

	@Test
	void testGetDistrictBlocksExceptionHandling() {
		int testId = 1;
		Exception simulatedException = new RuntimeException("Simulated exception for test");

		doThrow(simulatedException).when(locationService).getDistrictBlocks(testId);

		String result = locationController.getDistrictBlocks(testId);

		assertTrue(result.contains("error") || result.contains(simulatedException.getMessage()));
	}

	@Test
	void testGetCityExceptionHandling() {
		int testId = 1;
		Exception simulatedException = new RuntimeException("Simulated exception");

		doThrow(simulatedException).when(locationService).getDistrictBlocks(testId);

		String result = locationController.getCity(testId);
		assertTrue(result.contains("error") || result.contains(simulatedException.getMessage()));
	}

	@Test
	void testGetCountriesExceptionHandling() {
		Exception simulatedException = new RuntimeException("Simulated exception");
		doThrow(simulatedException).when(locationService).getCountries();

		String result = locationController.getCountries();
																														// logging
		assertTrue(result.contains("error") || result.contains(simulatedException.getMessage()));
	}
	
	 @Test
	    void testGetVillagesExceptionHandling() {
	        int testId = 1;
	        Exception simulatedException = new RuntimeException("Simulated exception");

	        doThrow(simulatedException).when(locationService).getDistrilctBranchs(testId);

	        String result = locationController.getVillages(testId);

	        assertTrue(result.contains("error") || result.contains(simulatedException.getMessage()));
	    }

}
