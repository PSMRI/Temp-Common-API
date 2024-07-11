package com.iemr.common.service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.iemr.common.data.users.ServiceMaster;
import com.iemr.common.repository.services.ServiesRepository;

@ExtendWith(MockitoExtension.class)
class ServicesImplTest {

	@InjectMocks
	private ServicesImpl services;

	@Mock
	private ServiesRepository serviesRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void servicesListReturnsCorrectData() {
		// Arrange
		Set<Object[]> mockData = new HashSet<>();
		mockData.add(new Object[] { 1, "Service A", "Description A", true });
		mockData.add(new Object[] { 2, "Service B", "Description B", false }); // Assuming you handle inactive services
																				// somehow in your real method

		when(serviesRepository.getActiveServicesList()).thenReturn(mockData);

		// Act
		List<ServiceMaster> result = services.servicesList();

		// Assert
		assertNotNull(result);
		assertEquals(2, result.size()); // Assuming your real method includes inactive services in the list
		assertTrue(result.stream().anyMatch(service -> service.getServiceName().equals("Service A")));
		assertTrue(result.stream().anyMatch(service -> service.getServiceName().equals("Service B")));

		// Verify that getActiveServicesList() was called exactly once
		verify(serviesRepository, times(1)).getActiveServicesList();
	}

}
