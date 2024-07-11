package com.iemr.common.service.userbeneficiarydata;

import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.repository.userbeneficiarydata.StatusRepository;
import com.iemr.common.repository.userbeneficiarydata.TitleRepository;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TitleServiceImplTest {

	@Mock
	private TitleRepository titleRepository;

	@InjectMocks
	private TitleServiceImpl titleService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getActiveTitles_whenTitlesFound() {
		// Setup
		Set<Object[]> mockResponse = new HashSet<>();
		mockResponse.add(new Object[] { 1, "Dr.", "A title description" });
		when(titleRepository.findAciveTitles()).thenReturn(mockResponse);

		// Execution
		List<Title> result = titleService.getActiveTitles();

		// Verification
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());

		// Verify the content based on getTitle method's behavior
		Title expectedTitle = new Title().getTitle(1, "Dr."); // This should match the behavior of your getTitle method
		assertEquals(expectedTitle.getTitleID(), result.get(0).getTitleID());
		assertEquals(expectedTitle.getTitleName(), result.get(0).getTitleName());

		verify(titleRepository).findAciveTitles();
	}

	@Test
	void getActiveTitles_whenNoTitlesFound() {
		// Setup
		when(titleRepository.findAciveTitles()).thenReturn(new HashSet<>());

		// Execution
		List<Title> result = titleService.getActiveTitles();

		// Verification
		assertNotNull(result);
		assertTrue(result.isEmpty());

		verify(titleRepository).findAciveTitles();
	}

}
