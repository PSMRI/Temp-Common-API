package com.iemr.common.service.directory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.directory.SubDirectory;
import com.iemr.common.repository.directory.SubDirectoryRepository;

@ExtendWith(MockitoExtension.class)
class SubDirectoryServiceImplTest {

	@Mock
	private SubDirectoryRepository subDirectoryRepository;

	@InjectMocks
	private SubDirectoryServiceImpl subDirectoryService;

	@Test
	void getSubDirectories_ReturnsSubDirectoriesList() {
		int directoryID = 1;
		Set<Object[]> mockedResult = new HashSet<>();
		mockedResult.add(new Object[] { 10, "SubDirectory A" });
		mockedResult.add(new Object[] { 11, "SubDirectory B" });
		when(subDirectoryRepository.findAciveSubDirectories(directoryID)).thenReturn(mockedResult);

		List<SubDirectory> subDirectories = subDirectoryService.getSubDirectories(directoryID);

		assertNotNull(subDirectories, "SubDirectories list should not be null");
		assertEquals(2, subDirectories.size(), "Expected 2 subdirectories in the result");
		assertTrue(subDirectories.stream().anyMatch(sub -> "SubDirectory A".equals(sub.getInstituteSubDirectoryName())),
				"SubDirectory A should be in the result list");
		assertTrue(subDirectories.stream().anyMatch(sub -> "SubDirectory B".equals(sub.getInstituteSubDirectoryName())),
				"SubDirectory B should be in the result list");
	}

}
