package com.iemr.common.service.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.beneficiary.SexualOrientation;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;

@ExtendWith(MockitoExtension.class)
class SexualOrientationServiceImplTest {
	@Mock
	private SexualOrientationRepository sexualOrientationRepository;

	@InjectMocks
	private SexualOrientationServiceImpl sexualOrientationServiceImpl;

	@Test
	void testGetSexualOrientations() {
		when(sexualOrientationRepository.findAciveOrientations()).thenReturn(new HashSet<>());
		List<SexualOrientation> actualSexualOrientations = sexualOrientationServiceImpl.getSexualOrientations();
		verify(sexualOrientationRepository).findAciveOrientations();
		assertTrue(actualSexualOrientations.isEmpty());
	}

	@Test
	void testGetSexualOrientations2() {
		HashSet<Object[]> objectArraySet = new HashSet<>();
		objectArraySet.add(new Object[] { "42" });
		when(sexualOrientationRepository.findAciveOrientations()).thenReturn(objectArraySet);
		List<SexualOrientation> actualSexualOrientations = sexualOrientationServiceImpl.getSexualOrientations();
		verify(sexualOrientationRepository).findAciveOrientations();
		assertTrue(actualSexualOrientations.isEmpty());
	}

	@Test
	void testGetSexualOrientations3() {
		HashSet<Object[]> objectArraySet = new HashSet<>();
		objectArraySet.add(null);
		when(sexualOrientationRepository.findAciveOrientations()).thenReturn(objectArraySet);
		List<SexualOrientation> actualSexualOrientations = sexualOrientationServiceImpl.getSexualOrientations();
		verify(sexualOrientationRepository).findAciveOrientations();
		assertTrue(actualSexualOrientations.isEmpty());
	}

	@Test
	void testGetSexualOrientations4() {
		HashSet<Object[]> objectArraySet = new HashSet<>();
		objectArraySet.add(new Object[] { (short) 1, "42" });
		when(sexualOrientationRepository.findAciveOrientations()).thenReturn(objectArraySet);
		List<SexualOrientation> actualSexualOrientations = sexualOrientationServiceImpl.getSexualOrientations();
		verify(sexualOrientationRepository).findAciveOrientations();
		assertEquals(1, actualSexualOrientations.size());
	}

	@Test
	void testGetSexualOrientations5() {
		HashSet<Object[]> objectArraySet = new HashSet<>();
		objectArraySet.add(new Object[] { (short) 2, "42" });
		when(sexualOrientationRepository.findAciveOrientations()).thenReturn(objectArraySet);
		List<SexualOrientation> actualSexualOrientations = sexualOrientationServiceImpl.getSexualOrientations();
		verify(sexualOrientationRepository).findAciveOrientations();
		assertEquals(1, actualSexualOrientations.size());
	}
}
