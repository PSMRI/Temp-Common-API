package com.iemr.common.service.snomedct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.iemr.common.data.snomedct.SCTDescription;
import com.iemr.common.repo.snomedct.SnomedRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SnomedServiceImplTest {

	@Test
	void testFindSnomedCTRecordFromTerm() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SnomedRepository snomedRepository = mock(SnomedRepository.class);
		when(snomedRepository.findSnomedCTRecordFromTerm(Mockito.<String>any())).thenReturn(new ArrayList<>());

		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();
		snomedServiceImpl.setSnomedRepository(snomedRepository);

		// Act
		SCTDescription actualFindSnomedCTRecordFromTermResult = snomedServiceImpl.findSnomedCTRecordFromTerm("Term");

		// Assert
		verify(snomedRepository).findSnomedCTRecordFromTerm(("Term"));
		assertNull(actualFindSnomedCTRecordFromTermResult);
	}

	@Test
	void testFindSnomedCTRecordFromTerm2() {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		ArrayList<Object[]> objectArrayList = new ArrayList<>();
		objectArrayList.add(new Object[] { "42", "42" });
		SnomedRepository snomedRepository = mock(SnomedRepository.class);
		when(snomedRepository.findSnomedCTRecordFromTerm(Mockito.<String>any())).thenReturn(objectArrayList);

		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();
		snomedServiceImpl.setSnomedRepository(snomedRepository);

		// Act
		SCTDescription actualFindSnomedCTRecordFromTermResult = snomedServiceImpl.findSnomedCTRecordFromTerm("Term");

		// Assert
		verify(snomedRepository).findSnomedCTRecordFromTerm(("Term"));
		assertEquals("42", actualFindSnomedCTRecordFromTermResult.getConceptID());
		assertEquals("42", actualFindSnomedCTRecordFromTermResult.getTerm());
	}

	@Test
	void testFindSnomedCTRecordList() throws Exception {
		assertThrows(Exception.class, () -> (new SnomedServiceImpl()).findSnomedCTRecordList(null));
	}

	@Test
	void testFindSnomedCTRecordList2() throws Exception {

		// Arrange
		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();

		SCTDescription sctdescription = new SCTDescription();
		sctdescription.setActive("Active");
		sctdescription.setCaseSignificanceID("Case Significance ID");
		sctdescription.setConceptID("Concept ID");
		sctdescription.setSctDesID(1L);
		sctdescription.setPageNo(null);
		sctdescription.setTerm(null);

		// Act and Assert
		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
	}

	@Test
	void testFindSnomedCTRecordList3() throws Exception {

		// Arrange
		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();

		SCTDescription sctdescription = new SCTDescription();
		sctdescription.setActive("Active");
		sctdescription.setCaseSignificanceID("Case Significance ID");
		sctdescription.setConceptID("Concept ID");
		sctdescription.setSctDesID(1L);
		sctdescription.setPageNo(null);
		sctdescription.setTerm("foo");

		// Act and Assert
		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
	}
}
