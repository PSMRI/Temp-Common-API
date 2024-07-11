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

import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.repo.snomedct.SnomedRepository;
import com.iemr.common.repository.beneficiary.CommunityRepository;
import com.iemr.common.repository.userbeneficiarydata.TitleRepository;
import com.iemr.common.service.snomedct.SnomedServiceImpl;
import com.iemr.common.service.userbeneficiarydata.CommunityServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CommunityServiceImplTest {

	@Mock
	private CommunityRepository communityRepository;

	@InjectMocks
	private CommunityServiceImpl communityService;

	@BeforeEach
	 void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	 void testGetActiveCommunities_WithValidData() {
		// Setup mock data
		Set<Object[]> mockData = new HashSet<>();
		mockData.add(new Object[] { 1, "Community A" });
		mockData.add(new Object[] { 2, "Community B" });

		// Mocking repository call
		when(communityRepository.findAciveCommunities()).thenReturn(mockData);

		// Call the method under test
		List<Community> result = communityService.getActiveCommunities();

		// Assertions
		assertEquals(2, result.size());
		
	}

	@Test
	 void testGetActiveCommunities_EmptySet() {
		// Setup empty set for mocking
		Set<Object[]> mockData = new HashSet<>();

		// Mocking repository call
		when(communityRepository.findAciveCommunities()).thenReturn(mockData);

		// Call the method under test
		List<Community> result = communityService.getActiveCommunities();

		// Assertions
		assertEquals(0, result.size());
	}

}
