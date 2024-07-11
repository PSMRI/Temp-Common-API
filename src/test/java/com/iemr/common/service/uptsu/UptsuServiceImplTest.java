package com.iemr.common.service.uptsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iemr.common.data.uptsu.FacilityMaster;
import com.iemr.common.data.uptsu.SmsRequestOBJ;
import com.iemr.common.repository.uptsu.FacilityMasterRepo;
import com.iemr.common.repository.uptsu.T_104AppointmentDetailsRepo;
import com.iemr.common.service.sms.SMSService;

@ExtendWith(MockitoExtension.class)
class UptsuServiceImplTest {

	@InjectMocks
	private UptsuServiceImpl uptsuService;

	@Mock
	private FacilityMasterRepo facilityMasterRepo;

	@Mock
	private T_104AppointmentDetailsRepo t_104AppointmentDetailsRepo;
	@Mock
	private SMSService smsService;
	@Mock
	private RestTemplate restTemplate;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetFacility() {
		Integer providerServiceMapID = 1;
		String blockname = "TestBlock";
		FacilityMaster facility1 = new FacilityMaster(); // Assuming FacilityMaster has a parameterless constructor
		facility1.setId(1); // Assuming there's a method to set an ID or relevant fields
		facility1.setBlockName(blockname);

		FacilityMaster facility2 = new FacilityMaster();
		facility2.setId(2);
		facility2.setBlockName(blockname);

		List<FacilityMaster> expectedFacilities = Arrays.asList(facility1, facility2);

		when(facilityMasterRepo.findByProviderServiceMapIDAndBlockNameAndDeleted(providerServiceMapID, blockname,
				false)).thenReturn(expectedFacilities);

		String result = uptsuService.getFacility(providerServiceMapID, blockname);

		assertEquals(new Gson().toJson(expectedFacilities), result,
				"The returned JSON does not match the expected JSON.");
	}

	@Test
	void testCreateSmsGateway() throws Exception {
		// Arrange
		// Assuming we have some dummy data to pass to the method
		String appointmentDate = "2024-03-17";
		String appointmentTime = "10:00 AM";
		String facilityPhoneNo = "1234567890";
		String choName = "Test CHO";
		String employeeCode = "EMP123";
		String beneficiaryName = "John Doe";
		Long beneficiaryId = 12345L;
		String facilityName = "Test Facility";
		String hfrId = "HFR123";
		String benPhoneNo = "0987654321";
		Long benRegId = 67890L;
		String Authorization = "Bearer someAuthToken";
		String createdBy = "TestUser";

		// Act
		uptsuService.createSmsGateway(appointmentDate, appointmentTime, facilityPhoneNo, choName, employeeCode,
				beneficiaryName, beneficiaryId, facilityName, hfrId, benPhoneNo, benRegId, Authorization, createdBy);

		// Assert
		// Verify that smsService.sendSMS was called twice (once for CHO and once for
		// the beneficiary)
		verify(smsService, times(2)).sendSMS(anyList(), eq(Authorization));
	}

}
