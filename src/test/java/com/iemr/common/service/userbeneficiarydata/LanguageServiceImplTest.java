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

import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.repository.userbeneficiarydata.LanguageRepository;

@ExtendWith(MockitoExtension.class)
class LanguageServiceImplTest {

	@Mock
	private LanguageRepository languageRepository;

	@InjectMocks
	private LanguageServiceImpl languageService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void testGetActiveLanguages_ReturnsNonEmptyList() {
		// Mocking the repository response
		Set<Object[]> mockedResponse = new HashSet<>();
		mockedResponse.add(new Object[] { 1, "English" });
		mockedResponse.add(new Object[] { 2, "Spanish" });

		when(languageRepository.findAciveLanguages()).thenReturn(mockedResponse);

		// Calling the method under test
		List<Language> activeLanguages = languageService.getActiveLanguages();

		// Assertions
		assertEquals(2, activeLanguages.size(), "Should return a list with two languages");
		// Additional checks can be added to verify the contents of the list
	}

	@Test
	void testGetActiveLanguages_ReturnsEmptyListWhenRepositoryIsEmpty() {
		// Mocking an empty repository response
		when(languageRepository.findAciveLanguages()).thenReturn(new HashSet<>());

		// Calling the method under test
		List<Language> activeLanguages = languageService.getActiveLanguages();

		// Assertions
		assertEquals(0, activeLanguages.size(), "Should return an empty list");
	}

}
