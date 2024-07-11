package com.iemr.common.controller.esanjeevani;

import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.model.esanjeevani.ESanjeevaniPatientRegistration;
import com.iemr.common.service.esanjeevani.ESanjeevaniService;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class ESanjeevaniControllerTest {
	
	@InjectMocks
	ESanjeevaniController eSanjeevaniController;
	@Mock
	private ESanjeevaniService eSanjeevaniService;

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testRegisterESanjeevaniPatient() throws Exception {
		OutputResponse response = new OutputResponse();
		Long beneficiaryReqId = 123L;
		ESanjeevaniPatientRegistration reqObj = new ESanjeevaniPatientRegistration();
		reqObj.setAbhaAddress("abha address");
		reqObj.setAbhaNumber("abha num");
		reqObj.setAge(23);
		reqObj.setBirthdate("birth date");
		reqObj.setBlock(false);
		reqObj.setDisplayName("display name");
		reqObj.setFirstName("first name");
		reqObj.setGenderCode(443);
		reqObj.setLastName("last name");
		reqObj.setMiddleName("middle name");
		reqObj.setSource("source");
		reqObj.toString();
		String res = reqObj.toString();
		when(eSanjeevaniService.registerPatient(beneficiaryReqId)).thenReturn(res);
		response.setResponse(res.toString());
		String actualResp = eSanjeevaniController.registerESanjeevaniPatient(beneficiaryReqId);
		assertNotNull(actualResp);
		Assertions.assertEquals(response.toString(), actualResp);
	}
	
	@Test
	void testRegisterESanjeevaniPatient_InvalidReq() throws Exception {
		Long beneficiaryReqId = null;
		String response = eSanjeevaniController.registerESanjeevaniPatient(beneficiaryReqId);
		assertTrue(response.contains("Error while fetching E-sanjeevani route URL"), "Expected error message not found in the response.");
	}
	
	@Test
	void testRegisterESanjeevaniPatient_CatchBlock() throws Exception {
		Long beneficiaryReqId = null;
		when(eSanjeevaniService.registerPatient(beneficiaryReqId)).thenThrow(NotFoundException.class);
		String response = eSanjeevaniController.registerESanjeevaniPatient(beneficiaryReqId);
		Assertions.assertEquals(response, eSanjeevaniController.registerESanjeevaniPatient(beneficiaryReqId));
	}

}
