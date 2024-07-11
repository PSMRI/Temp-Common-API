package com.iemr.common.service.directory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.repository.directory.DirectoryRepository;

@ExtendWith(MockitoExtension.class)
class DirectoryServiceImplTest {

	@Mock
	private DirectoryRepository directoryRepository;

	@InjectMocks
	private DirectoryServiceImpl directoryService;

	@Test
	void getDirectories_ReturnsListOfDirectories() {
		Set<Object[]> mockData = new HashSet<>();
		mockData.add(new Object[] { 1, "Directory 1" });
		mockData.add(new Object[] { 2, "Directory 2" });
		when(directoryRepository.findAciveDirectories()).thenReturn(mockData);

		List<Directory> directories = directoryService.getDirectories();

		assertNotNull(directories);
		assertEquals(2, directories.size());
	}

	@Test
	void getDirectories_WithProviderServiceMapID_ReturnsFilteredDirectories() {
		Integer providerServiceMapID = 100;
		List<Directory> mockData = List.of(new Directory(1, "Filtered Directory"));
		when(directoryRepository.findAciveDirectories(providerServiceMapID)).thenReturn(mockData);

		List<Directory> directories = directoryService.getDirectories(providerServiceMapID);

		assertNotNull(directories);
		assertEquals(1, directories.size());
		assertEquals("Filtered Directory", directories.get(0).getInstituteDirectoryName());
	}

}
