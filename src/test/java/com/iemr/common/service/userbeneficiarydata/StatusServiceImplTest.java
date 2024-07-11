package com.iemr.common.service.userbeneficiarydata;

import static org.mockito.Mockito.*;

import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.repository.userbeneficiarydata.MaritalStatusRepository;
import com.iemr.common.repository.userbeneficiarydata.StatusRepository;
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

@ExtendWith(MockitoExtension.class)
class StatusServiceImplTest {

	@Mock
	private StatusRepository statusRepository;

	@InjectMocks
	private StatusServiceImpl statusService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void setTitleServiceImpl() {
		// Arrange and Act
		(new StatusServiceImpl()).setTitleServiceImpl(mock(StatusRepository.class));
	}

	@Test
	void getActiveStatus_whenStatusFound() {
		// Setup
		Set<Object[]> mockResponse = new HashSet<>();
		mockResponse.add(new Object[] { 1, "Active" });
		when(statusRepository.findAciveStatus()).thenReturn(mockResponse);

		// Execution
		List<Status> result = statusService.getActiveStatus();

		// Verification
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		assertEquals("Active", result.get(0).getStatus());

		verify(statusRepository).findAciveStatus();
	}

	@Test
	void getActiveStatus_whenStatusNotFound() {
		// Setup
		when(statusRepository.findAciveStatus()).thenReturn(new HashSet<>());

		// Execution
		List<Status> result = statusService.getActiveStatus();

		// Verification
		assertNotNull(result);
		assertTrue(result.isEmpty());

		verify(statusRepository).findAciveStatus();
	}

}
