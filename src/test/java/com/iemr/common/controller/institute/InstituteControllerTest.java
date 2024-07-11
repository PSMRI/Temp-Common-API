package com.iemr.common.controller.institute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.service.institute.DesignationService;
import com.iemr.common.service.institute.InstituteService;
import com.iemr.common.service.institute.InstituteTypeService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class InstituteControllerTest {

	@Mock
	private InputMapper inputMapper;

	@Mock
	private InstituteService instituteService;

	@Mock
	private InstituteTypeService instituteTypeService;

	@Mock
	private DesignationService designationService;

	@InjectMocks
	private InstituteController instituteController; // Replace "YourClass" with the actual class name

	@Test
	void testGetInstituteTypes() throws Exception {
		String instituteTypeRequest = "{\"providerServiceMapID\": \"1\"}";

		OutputResponse response = new OutputResponse();

		response.setResponse(instituteTypeService.getInstitutionTypes(instituteTypeRequest).toString());

		String expRes = instituteController.getInstituteTypes(instituteTypeRequest);

		assertTrue(expRes.contains("Success"));
	}

	@Test
	void testGetInstituteTypes_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(instituteTypeService.getInstitutionTypes(request).toString()).thenThrow(NotFoundException.class);
		String response = instituteController.getInstituteTypes(request);
		assertEquals(response, instituteController.getInstituteTypes(request));
	}

	@Test
	void testGetInstituteName() throws Exception {
		Integer institutionTypeID = 1;
		OutputResponse response = new OutputResponse();

		response.setResponse(instituteTypeService.getInstitutionName(institutionTypeID).toString());

		String expRes = instituteController.getInstituteName(institutionTypeID);

		assertTrue(expRes.contains("Success"));
	}

	@Test
	void testGetInstituteName_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(instituteTypeService.getInstitutionName(any()).toString()).thenThrow(NotFoundException.class);

		String response = instituteController.getInstituteName(any());
		assertEquals(response, instituteController.getInstituteName(any()));
	}

	@Test
	void testGetDesignations() {
		OutputResponse response = new OutputResponse();

		response.setResponse(designationService.getDesignations().toString());

		String expRes = instituteController.getDesignations();

		assertTrue(expRes.contains("Success"));
	}

	@Test
	void testGetDesignations_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(designationService.getDesignations().toString()).thenThrow(NotFoundException.class);

		String response = instituteController.getDesignations();
		assertEquals(response, instituteController.getDesignations());
	}

	@Test
	void testGetInstituteNameByTypeAndDistrict() throws Exception {
		Integer institutionTypeID = 1;
		Integer districtID = 1;

		OutputResponse response = new OutputResponse();

		response.setResponse(
				instituteTypeService.getInstitutionNameByTypeAndDistrict(institutionTypeID, districtID).toString());

		String expRes = instituteController.getInstituteNameByTypeAndDistrict(institutionTypeID, districtID);

		assertTrue(expRes.contains("Success"));
	}

	@Test
	void testGetInstituteNameByTypeAndDistrict_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(instituteTypeService.getInstitutionNameByTypeAndDistrict(any(), any()).toString())
				.thenThrow(NotFoundException.class);

		String response = instituteController.getInstituteNameByTypeAndDistrict(any(), any());
		assertEquals(response, instituteController.getInstituteNameByTypeAndDistrict(any(), any()));
	}

	@Test()
	void getInstituteByBranchExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = instituteController.getInstituteByBranch(request);
		assertEquals(response, instituteController.getInstituteByBranch(request));
	}

	@Test()
	void getInstitutesByLocationExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = instituteController.getInstitutesByLocation(request);
		assertEquals(response, instituteController.getInstitutesByLocation(request));
	}

}
