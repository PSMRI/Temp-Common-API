package com.iemr.common.service.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.iemr.common.data.users.EmployeeSignature;
import com.iemr.common.repository.users.EmployeeSignatureRepo;
import com.iemr.common.service.users.EmployeeSignatureServiceImpl;
@ExtendWith(MockitoExtension.class)
public class EmployeeSignatureServiceImplTest {

	@Mock
	private EmployeeSignatureRepo employeeSignatureRepo;

	@InjectMocks
	private EmployeeSignatureServiceImpl service;

	@BeforeEach
	 void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	 void testFetchSignature_ExistingUser() {
		Long userSignID = 1L;
		EmployeeSignature mockSignature = new EmployeeSignature();
		// Assuming EmployeeSignature has a setUserID method or similar to set the ID.
		mockSignature.setUserID(userSignID); // Setup mock data as per your class structure

		when(employeeSignatureRepo.findOneByUserID(userSignID)).thenReturn(mockSignature);

		EmployeeSignature result = service.fetchSignature(userSignID);

		assertNotNull(result);
		assertEquals(userSignID, result.getUserID());
		verify(employeeSignatureRepo).findOneByUserID(userSignID);
	}

	@Test
	 void testFetchSignature_NonExistingUser() {
		Long userSignID = 99L;

		when(employeeSignatureRepo.findOneByUserID(userSignID)).thenReturn(null);

		EmployeeSignature result = service.fetchSignature(userSignID);

		assertNull(result);
		verify(employeeSignatureRepo).findOneByUserID(userSignID);
	}

	@Test
	 void testExistSignature_True() {
		Long userID = 1L;

		when(employeeSignatureRepo.countByUserIDAndSignatureNotNull(userID)).thenReturn(1L);

		Boolean exists = service.existSignature(userID);

		assertTrue(exists);
		verify(employeeSignatureRepo).countByUserIDAndSignatureNotNull(userID);
	}

	@Test
	 void testExistSignature_False() {
		Long userID = 99L;

		when(employeeSignatureRepo.countByUserIDAndSignatureNotNull(userID)).thenReturn(0L);

		Boolean exists = service.existSignature(userID);

		assertFalse(exists);
		verify(employeeSignatureRepo).countByUserIDAndSignatureNotNull(userID);
	}
}
