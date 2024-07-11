package com.iemr.common.service.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.location.CityDetails;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.repository.location.LocationCityRepository;
import com.iemr.common.repository.location.LocationCountryRepository;
import com.iemr.common.repository.location.LocationDistrictBlockRepository;
import com.iemr.common.repository.location.LocationDistrictRepository;
import com.iemr.common.repository.location.LocationDistrilctBranchRepository;
import com.iemr.common.repository.location.LocationStateRepository;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

	@InjectMocks
	LocationServiceImpl locationService;

	@Mock
	private LocationStateRepository locationStateRepository;

	@Mock
	private LocationDistrictRepository locationDistrictRepository;

	@Mock
	private LocationDistrictBlockRepository locationDistrictBlockRepository;

	@Mock
	private LocationDistrilctBranchRepository locationDistrilctBranchRepository;

	@Mock
	private LocationCityRepository locationCityRepository;

	@Mock
	private LocationCountryRepository locationCountryRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testGetStatesReturnsNonEmptyList() {
		// Setup
		int testId = 1;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		mockResponse.add(new Object[] { 1, "StateName" });
		when(locationStateRepository.findBy(testId)).thenReturn(mockResponse);

		// Execution
		List<States> result = locationService.getStates(testId);

		// Verification
		verify(locationStateRepository).findBy(testId);
		assertEquals(1, result.size()); // Expecting one state in the list
	}

	@Test
	void testGetStatesReturnsEmptyListForNoResults() {
		// Setup
		int testId = 2;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		when(locationStateRepository.findBy(testId)).thenReturn(mockResponse);

		// Execution
		List<States> result = locationService.getStates(testId);

		// Verification
		verify(locationStateRepository).findBy(testId);
		assertTrue(result.isEmpty()); // The list should be empty
	}

	@Test
	void testGetDistrictsReturnsNonEmptyList() {
		// Setup
		int testId = 1;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		mockResponse.add(new Object[] { 1, "DistrictName" }); // Mock data
		when(locationDistrictRepository.findBy(testId)).thenReturn(mockResponse);

		// Execute
		List<Districts> result = locationService.getDistricts(testId);

		// Verify
		verify(locationDistrictRepository).findBy(testId);
		assertFalse(result.isEmpty(), "The district list should not be empty.");
		assertEquals(1, result.size(), "The district list should contain exactly one element.");
	}

	@Test
	void testGetDistrictsReturnsEmptyListForNoResults() {
		// Setup
		int testId = 99; // Assuming this ID will return no results
		when(locationDistrictRepository.findBy(testId)).thenReturn(new ArrayList<>());

		// Execute
		List<Districts> result = locationService.getDistricts(testId);

		// Verify
		verify(locationDistrictRepository).findBy(testId);
		assertTrue(result.isEmpty(), "The district list should be empty for no results.");
	}

	@Test
	void testGetDistrictBlocksReturnsNonEmptyList() {
		// Setup
		int testId = 1;
		Set<Object[]> mockResponse = new HashSet<>();
		mockResponse.add(new Object[] { 1, "BlockName" }); // Mock data
		when(locationDistrictBlockRepository.findBy(testId)).thenReturn(mockResponse);

		// Execute
		List<DistrictBlock> result = locationService.getDistrictBlocks(testId);

		// Verify
		verify(locationDistrictBlockRepository).findBy(testId);
		assertFalse(result.isEmpty(), "The district block list should not be empty.");
		assertEquals(1, result.size(), "The district block list should contain exactly one element.");
	}

	@Test
	void testGetDistrictBlocksReturnsEmptyListForNoResults() {
		// Setup
		int testId = 99; // Assuming this ID will return no results
		when(locationDistrictBlockRepository.findBy(testId)).thenReturn(new HashSet<>());

		// Execute
		List<DistrictBlock> result = locationService.getDistrictBlocks(testId);

		// Verify
		verify(locationDistrictBlockRepository).findBy(testId);
		assertTrue(result.isEmpty(), "The district block list should be empty for no results.");
	}

	@Test
	void testFindStateDistrictByReturnsNonEmptyList() {
		// Setup
		int testId = 1;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		mockResponse.add(new Object[] { 1, "DistrictName", "StateName", 10 }); // Mock data
		when(locationDistrictRepository.findStateDistrictBy(testId)).thenReturn(mockResponse);

		// Execute
		List<Districts> result = locationService.findStateDistrictBy(testId);

		// Verify
		verify(locationDistrictRepository).findStateDistrictBy(testId);
		assertFalse(result.isEmpty(), "The state district list should not be empty.");
		assertEquals(1, result.size(), "The state district list should contain exactly one element.");
	}

	@Test
	void testFindStateDistrictByReturnsEmptyListForNoResults() {
		// Setup
		int testId = 99; // Assuming this ID will return no results
		when(locationDistrictRepository.findStateDistrictBy(testId)).thenReturn(new ArrayList<>());

		// Execute
		List<Districts> result = locationService.findStateDistrictBy(testId);

		// Verify
		verify(locationDistrictRepository).findStateDistrictBy(testId);
		assertTrue(result.isEmpty(), "The state district list should be empty for no results.");
	}

	@Test
	void testGetCitiesReturnsNonEmptyList() {
		// Setup
		int testId = 1;
		Set<Object[]> mockResponse = new HashSet<>();
		mockResponse.add(new Object[] { 1, "CityName" }); // Mock data
		when(locationDistrictBlockRepository.findBy(testId)).thenReturn(mockResponse);

		// Execute
		List<CityDetails> result = locationService.getCities(testId);

		// Verify
		verify(locationDistrictBlockRepository).findBy(testId);
		assertFalse(result.isEmpty(), "The city list should not be empty.");
		assertEquals(1, result.size(), "The city list should contain exactly one element.");
	}

	@Test
	void testGetCitiesReturnsEmptyListForNoResults() {
		// Setup
		int testId = 99; // Assuming this ID will return no results
		when(locationDistrictBlockRepository.findBy(testId)).thenReturn(new HashSet<>());

		// Execute
		List<CityDetails> result = locationService.getCities(testId);

		// Verify
		verify(locationDistrictBlockRepository).findBy(testId);
		assertTrue(result.isEmpty(), "The city list should be empty for no results.");
	}

	@Test
	void testGetDistrilctBranchsReturnsNonEmptyList() {
		// Setup
		int testId = 1;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		mockResponse.add(new Object[] { 1, "BranchName", "BranchCode", "BranchAddress", "BranchType" }); // Mock data
		when(locationDistrilctBranchRepository.findAllBy(testId)).thenReturn(mockResponse);

		// Execute
		List<DistrictBranchMapping> result = locationService.getDistrilctBranchs(testId);

		// Verify
		verify(locationDistrilctBranchRepository).findAllBy(testId);
		assertFalse(result.isEmpty(), "The distrilct branches list should not be empty.");
		assertEquals(1, result.size(), "The distrilct branches list should contain exactly one element.");
	}

	@Test
	void testGetDistrilctBranchsReturnsEmptyListForNoResults() {
		// Setup
		int testId = 99; // Assuming this ID will return no results
		when(locationDistrilctBranchRepository.findAllBy(testId)).thenReturn(new ArrayList<>());

		// Execute
		List<DistrictBranchMapping> result = locationService.getDistrilctBranchs(testId);

		// Verify
		verify(locationDistrilctBranchRepository).findAllBy(testId);
		assertTrue(result.isEmpty(), "The distrilct branches list should be empty for no results.");
	}

	@Test
	void testGetDistrilctBranchsIgnoresIncompleteData() {
		// Setup
		int testId = 2;
		ArrayList<Object[]> mockResponse = new ArrayList<>();
		mockResponse.add(new Object[] { 1, "BranchName" }); // Insufficient data
		when(locationDistrilctBranchRepository.findAllBy(testId)).thenReturn(mockResponse);

		// Execute
		List<DistrictBranchMapping> result = locationService.getDistrilctBranchs(testId);

		// Verify
		verify(locationDistrilctBranchRepository).findAllBy(testId);
		assertTrue(result.isEmpty(), "The distrilct branches list should be empty when data is incomplete.");
	}

	@Test
	void testGetCountriesReturnsNonEmptyList() {
		// Setup
		List<Country> mockCountries = new ArrayList<>();
		mockCountries.add(new Country()); // Assuming Country has an id and name
		when(locationCountryRepository.findAll()).thenReturn(mockCountries);

		// Execute
		List<Country> countries = locationService.getCountries();

		// Verify
		verify(locationCountryRepository).findAll();
		assertFalse(countries.isEmpty(), "The country list should not be empty.");
		assertEquals(1, countries.size(), "The country list should contain exactly one element.");
	}

	@Test
	void testGetCountriesReturnsEmptyListWhenNoCountriesFound() {
		// Setup
		when(locationCountryRepository.findAll()).thenReturn(new ArrayList<>());

		// Execute
		List<Country> countries = locationService.getCountries();

		// Verify
		verify(locationCountryRepository).findAll();
		assertTrue(countries.isEmpty(), "The country list should be empty when no countries are found.");
	}

}
