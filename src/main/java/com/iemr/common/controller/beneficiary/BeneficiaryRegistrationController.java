/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.controller.beneficiary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;
import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.service.beneficiary.BenRelationshipTypeService;
import com.iemr.common.service.beneficiary.BeneficiaryOccupationService;
import com.iemr.common.service.beneficiary.GovtIdentityTypeService;
import com.iemr.common.service.beneficiary.IEMRBeneficiaryTypeService;
import com.iemr.common.service.beneficiary.IEMRSearchUserService;
import com.iemr.common.service.beneficiary.RegisterBenificiaryService;
import com.iemr.common.service.beneficiary.SexualOrientationService;
import com.iemr.common.service.directory.DirectoryService;
import com.iemr.common.service.location.LocationService;
import com.iemr.common.service.reports.CallReportsService;
import com.iemr.common.service.userbeneficiarydata.CommunityService;
import com.iemr.common.service.userbeneficiarydata.EducationService;
import com.iemr.common.service.userbeneficiarydata.GenderService;
import com.iemr.common.service.userbeneficiarydata.LanguageService;
import com.iemr.common.service.userbeneficiarydata.MaritalStatusService;
import com.iemr.common.service.userbeneficiarydata.StatusService;
import com.iemr.common.service.userbeneficiarydata.TitleService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping({ "/beneficiary" })
@RestController
public class BeneficiaryRegistrationController {

	private InputMapper inputMapper = new InputMapper();

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static final String AUTHORIZATION = "authorization";
	private RegisterBenificiaryService registerBenificiaryService;
	private IEMRBeneficiaryTypeService iemrBeneficiaryTypeService;
	private IEMRSearchUserService iemrSearchUserService;
	private EducationService educationService;
	private TitleService titleService;
	private StatusService statusService;
	private LocationService locationService;
	private GenderService genderService;
	private MaritalStatusService maritalStatusService;
	private CommunityService communityService;
	private DirectoryService directoryService;
	private SexualOrientationService sexualOrientationService;
	private LanguageService languageService;
	private BenRelationshipTypeService benRelationshipTypeService;
	private BeneficiaryOccupationService beneficiaryOccupationService;
	private GovtIdentityTypeService govtIdentityTypeService;

	@Autowired
	public void setBenRelationshipTypeService(BenRelationshipTypeService benRelationshipTypeService) {
		this.benRelationshipTypeService = benRelationshipTypeService;
	}

	@Autowired
	public void setBeneficiaryOccupationService(BeneficiaryOccupationService beneficiaryOccupationService) {
		this.beneficiaryOccupationService = beneficiaryOccupationService;
	}

	@Autowired
	public void setIEMRSearchUserService(IEMRSearchUserService iemrSearchUserService) {
		this.iemrSearchUserService = iemrSearchUserService;
	}

	@Autowired
	public void setIEMRBeneficiaryTypeService(IEMRBeneficiaryTypeService iemrBeneficiaryTypeService) {
		this.iemrBeneficiaryTypeService = iemrBeneficiaryTypeService;
	}

	@Autowired
	public void setRegisterBenificiaryService(RegisterBenificiaryService registerBenificiaryService) {
		this.registerBenificiaryService = registerBenificiaryService;
	}

	@Autowired
	public void setEducationService(EducationService educationService1) {
		this.educationService = educationService1;
	}

	@Autowired
	public void setTitleService(TitleService titleService1) {
		this.titleService = titleService1;
	}

	@Autowired
	public void setStatusService(StatusService statusService1) {
		this.statusService = statusService1;
	}

	@Autowired
	public void setLocationService(LocationService locationService1) {
		this.locationService = locationService1;
	}

	@Autowired
	public void setGenderService(GenderService genderService) {
		this.genderService = genderService;
	}

	@Autowired
	public void setMaritalStatusService(MaritalStatusService maritalStatusService) {
		this.maritalStatusService = maritalStatusService;
	}

	@Autowired
	public void setCommunityService(CommunityService communityService) {
		this.communityService = communityService;
	}

	@Autowired
	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	@Autowired
	public void setDirectoryService(DirectoryService directoryService) {
		this.directoryService = directoryService;
	}

	@Autowired
	public void setSexualOrientationService(SexualOrientationService sexualOrientationService) {
		this.sexualOrientationService = sexualOrientationService;
	}

	@Autowired
	public void setGovtIdentityTypeService(GovtIdentityTypeService govtIdentityTypeService) {
		this.govtIdentityTypeService = govtIdentityTypeService;
	}

	@Autowired
	private CallReportsService callReportsService;

	@ApiOperation(value = "Create a new beneficiary")
	@CrossOrigin()
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json", headers = "Authorization")

	public String createBeneficiary(
			@ApiParam(value = "{\"providerServiceMapID\":\"Integer\",\"firstName\":\"String\",\"lastName\":\"String\",\"dOB\":\"Timestamp\","
					+ "\"ageUnits\":\"String\",\"fatherName\":\"String\",\"spouseName\":\"String\",\"govtIdentityNo\":\"String\","
					+ "\"govtIdentityTypeID\":\"Integer\",\"emergencyRegistration\":\"Boolean\",\"createdBy\":\"String\","
					+ "\"titleId\":\"Short\",\"statusID\":\"Short\",\"registeredServiceID\":\"Short\",\"maritalStatusID\":\"Short\","
					+ "\"genderID\":\"Integer\",\"i_bendemographics\":{\"educationID\":\"Long\",\"occupationID\":\"Integer\","
					+ "\"healthCareWorkerID\":\"Short\",\"communityID\":\"Integer\",\"districtID\":\"Integer\",\"stateID\":\"Integer\","
					+ "\"pinCode\":\"String\",\"blockID\":\"Integer\",\"districtBranchID\":\"Integer\",\"createdBy\":\"String\","
					+ "\"addressLine1\":\"String\"},\"benPhoneMaps\":{\"parentBenRegID\":\"Long\",\"phoneNo\":\"String\","
					+ "\"phoneTypeID\":\"Integer\",\"benRelationshipID\":\"Integer\",\"deleted\":\"Boolean\",\"createdBy\":\"String\"}}") @RequestBody BeneficiaryModel beneficiaryModel,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("Create beneficiary request " + beneficiaryModel);
		try {

			response.setResponse(registerBenificiaryService.save(beneficiaryModel, httpRequest));
		} catch (Exception e) {
			logger.error("create beneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		logger.info("create beneficiary response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Provide the list of beneficiaries based on beneficiary id")
	@RequestMapping(value = "/searchUserByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String searchUserByID(
			@ApiParam("{\"beneficiaryRegID\":\"Long\", \"beneficiaryID\":\"Long\", \"HealthID\":\"String\", \"HealthIDNo\":\"String\"} ") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();

		String auth = httpRequest.getHeader(AUTHORIZATION);
		logger.info("Search user by ID request " + request);
		try {
			BeneficiaryModel benificiaryDetails = InputMapper.gson().fromJson(request, BeneficiaryModel.class);
			logger.debug(benificiaryDetails.toString());
			List<BeneficiaryModel> iBeneficiary = null;
			if (benificiaryDetails.getBeneficiaryID() != null) {
				iBeneficiary = iemrSearchUserService.userExitsCheckWithId(benificiaryDetails.getBeneficiaryID(), auth,
						benificiaryDetails.getIs1097());
			} else if (benificiaryDetails.getBeneficiaryRegID() != null) {
				iBeneficiary = iemrSearchUserService.userExitsCheckWithId(benificiaryDetails.getBeneficiaryRegID(),
						auth, benificiaryDetails.getIs1097());
			} else if (benificiaryDetails.getHealthID() != null) {
				iBeneficiary = iemrSearchUserService.userExitsCheckWithHealthId_ABHAId(benificiaryDetails.getHealthID(),
						auth, benificiaryDetails.getIs1097());
			} else if (benificiaryDetails.getHealthIDNumber() != null) {
				iBeneficiary = iemrSearchUserService.userExitsCheckWithHealthIdNo_ABHAIdNo(
						benificiaryDetails.getHealthIDNumber(), auth, benificiaryDetails.getIs1097());
				// search by family id
			} else if (benificiaryDetails.getFamilyId() != null) {
				iBeneficiary = iemrSearchUserService.userExitsCheckWithFamilyId(benificiaryDetails.getFamilyId(), auth,
						benificiaryDetails.getIs1097());
				// search by identity
			} else if (benificiaryDetails.getIdentity() != null) {
				iBeneficiary = iemrSearchUserService.userExitsCheckWithGovIdentity(benificiaryDetails.getIdentity(),
						auth, benificiaryDetails.getIs1097());
			}

			response.setResponse(OutputMapper.gsonWithoutExposeRestriction().toJson(iBeneficiary));
			logger.info("Search user by ID response size "
					+ (iBeneficiary != null ? iBeneficiary.size() : "No Beneficiary Found"));
		} catch (Exception e) {
			logger.error("search user failed with error " + e.getMessage());
			response.setError(e);
		}
		return response.toString();
	}

	@ApiOperation(value = "Provide the list of beneficiaries based on phone number")
	@CrossOrigin()
	@RequestMapping(value = "/searchUserByPhone", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String searchUserByPhone(
			@ApiParam("{\"phoneNo\":\"String\",\"pageNo\":\"Integer\",\"rowsPerPage\":\"Integer\"}") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		logger.info("Serach user by phone no request " + request);
		try {
			JSONObject requestObj = new JSONObject(request);
			int pageNumber = requestObj.has("pageNo") ? (requestObj.getInt("pageNo") - 1) : 0;
			int rows = requestObj.has("rowsPerPage") ? requestObj.getInt("rowsPerPage") : 1000;
			BenPhoneMap benPhoneMap = OutputMapper.gsonWithoutExposeRestriction().fromJson(request, BenPhoneMap.class);
			logger.info("beneficiary request:" + benPhoneMap);
			response.setResponse(
					iemrSearchUserService.findByBeneficiaryPhoneNo(benPhoneMap, pageNumber, rows, auth).toString());
		} catch (JSONException e) {
			logger.error("serach user by phone NO failed with error " + e.getMessage(), e);
			response.setError(e);
		} catch (Exception e) {
			logger.error("serach user by phone NO failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Provide the list of beneficiaries based on search criteria")
	@RequestMapping(value = "/searchBeneficiary", method = RequestMethod.POST, headers = "Authorization")
	public String searchBeneficiary(
			@ApiParam("{\"firstName\":\"String\",\"lastName\":\"String\",\"genderID\":\"Integer\",\"beneficiaryID\":\"String\","
					+ "\"i_bendemographics\":{\"stateID\":\"Integer\",\"districtID\":\"Integer\",\"districtBranchID\":\"Integer\"}}") @RequestBody BeneficiaryModel request,
			HttpServletRequest httpRequest) {
		logger.info("searchBeneficiary request " + request);
		OutputResponse output = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		try {
			output.setResponse(iemrSearchUserService.findBeneficiary(request, auth));
		} catch (NumberFormatException ne) {
			logger.error("searchBeneficiary failed with error " + ne.getMessage(), ne);
			output.setError(ne);
		} catch (Exception e) {
			logger.error("searchBeneficiary failed with error " + e.getMessage(), e);
			output.setError(e);
		}

		return output.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Provide all common data list needed for beneficiary registration")
	@RequestMapping(value = "/getRegistrationData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getRegistrationData() {
		OutputResponse response = new OutputResponse();
		logger.info("Received get user registration data request");
		try {
			BeneficiaryRegistrationData beneficiaryRegistrationData = new BeneficiaryRegistrationData();
			beneficiaryRegistrationData.setM_Status(statusService.getActiveStatus());
			beneficiaryRegistrationData.setM_Title(titleService.getActiveTitles());
			beneficiaryRegistrationData.setI_BeneficiaryEducation(educationService.getActiveEducations());
			beneficiaryRegistrationData.setStates(locationService.getStates(1));
			beneficiaryRegistrationData.setM_genders(genderService.getActiveGenders());
			beneficiaryRegistrationData.setM_maritalStatuses(maritalStatusService.getActiveMaritalStatus());
			beneficiaryRegistrationData.setM_communities(communityService.getActiveCommunities());
			beneficiaryRegistrationData.setM_language(languageService.getActiveLanguages());
			beneficiaryRegistrationData.setDirectory(directoryService.getDirectories());
			beneficiaryRegistrationData.setSexualOrientations(sexualOrientationService.getSexualOrientations());
			beneficiaryRegistrationData
					.setBenRelationshipTypes(benRelationshipTypeService.getActiveRelationshipTypes());
			beneficiaryRegistrationData.setBeneficiaryOccupations(beneficiaryOccupationService.getActiveOccupations());
			beneficiaryRegistrationData.setGovtIdentityTypes(govtIdentityTypeService.getActiveIDTypes());
			response.setResponse(beneficiaryRegistrationData.toString());
		} catch (Exception e) {
			response.setError(e);
			logger.error("get user registration data failed with error " + e.getMessage(), e);
		}
		logger.info("get user registration data response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Provide all common data V1 list needed for beneficiary registration")
	@RequestMapping(value = "/getRegistrationDataV1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getRegistrationDataV1(
			@ApiParam(value = "{\"providerServiceMapID\":\"Integer\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		logger.info("Received get user registration data request");
		try {
			Directory instituteDirectory = inputMapper.gson().fromJson(request, Directory.class);
			BeneficiaryRegistrationData beneficiaryRegistrationData = new BeneficiaryRegistrationData();
			beneficiaryRegistrationData.setM_Status(statusService.getActiveStatus());
			beneficiaryRegistrationData.setM_Title(titleService.getActiveTitles());
			beneficiaryRegistrationData.setI_BeneficiaryEducation(educationService.getActiveEducations());
			beneficiaryRegistrationData.setStates(locationService.getStates(1));
			beneficiaryRegistrationData.setM_genders(genderService.getActiveGenders());
			beneficiaryRegistrationData.setM_maritalStatuses(maritalStatusService.getActiveMaritalStatus());
			beneficiaryRegistrationData.setM_communities(communityService.getActiveCommunities());
			beneficiaryRegistrationData.setM_language(languageService.getActiveLanguages());
			beneficiaryRegistrationData
					.setDirectory(directoryService.getDirectories(instituteDirectory.getProviderServiceMapID()));
			beneficiaryRegistrationData.setSexualOrientations(sexualOrientationService.getSexualOrientations());
			beneficiaryRegistrationData
					.setBenRelationshipTypes(benRelationshipTypeService.getActiveRelationshipTypes());
			beneficiaryRegistrationData.setBeneficiaryOccupations(beneficiaryOccupationService.getActiveOccupations());
			beneficiaryRegistrationData.setGovtIdentityTypes(govtIdentityTypeService.getActiveIDTypes());
			response.setResponse(beneficiaryRegistrationData.toString());
		} catch (Exception e) {
			response.setError(e);
			logger.error("get user registration data failed with error " + e.getMessage(), e);
		}
		logger.info("get user registration data response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Update beneficiary details")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String updateBenefciary(
			@ApiParam("{\"beneficiaryRegID\":\"Long\",\"firstName\":\"String\",\"lastName\":\"String\","
					+ "\"dOB\":\"Timestamp\",\"ageUnits\":\"String\",\"fatherName\":\"String\",\"spouseName\":\"String\","
					+ "\"govtIdentityNo\":\"String\",\"govtIdentityTypeID\":\"Integer\",\"emergencyRegistration\":\"Boolean\","
					+ "\"createdBy\":\"String\",\"titleId\":\"Short\",\"statusID\":\"Short\",\"registeredServiceID\":\"Short\","
					+ "\"maritalStatusID\":\"Short\",\"genderID\":\"Integer\",\"i_bendemographics\":{\"educationID\":\"Long\","
					+ "\"beneficiaryRegID\":\"Long\",\"occupationID\":\"Integer\",\"healthCareWorkerID\":\"Short\",\"incomeStatusID\":\"Integer\","
					+ "\"communityID\":\"Integer\",\"preferredLangID\":\"Integer\",\"districtID\":\"Integer\",\"stateID\":\"Integer\","
					+ "\"pinCode\":\"String\",\"blockID\":\"Integer\",\"districtBranchID\":\"Integer\",\"createdBy\":\"String\",\"addressLine1\":\"String\"},"
					+ "\"benPhoneMaps\":{\"parentBenRegID\":\"Long\",\"phoneNo\":\"String\",\"phoneTypeID\":\"Integer\",\"benRelationshipID\":\"Integer\","
					+ "\"deleted\":\"Boolean\",\"createdBy\":\"String\"},\"changeInSelfDetails\":\"Boolean\",\"changeInIdentities\":\"Boolean\","
					+ "\"changeInOtherDetails\":\"Boolean\",\"changeInAddress\":\"Boolean\",\"changeInContacts\":\"Boolean\","
					+ "\"changeInFamilyDetails\":\"Boolean\"}") @RequestBody String benificiaryRequest,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		Integer updateCount = 0;
		try {
			BeneficiaryModel benificiaryDetails = inputMapper.gson().fromJson(benificiaryRequest,
					BeneficiaryModel.class);
			updateCount = registerBenificiaryService.updateBenificiary(benificiaryDetails, auth);
			if (updateCount > 0) {
				JSONArray updatedUserData = new JSONArray(
						new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()
								.toJson(iemrSearchUserService.userExitsCheckWithId(
										benificiaryDetails.getBeneficiaryRegID(), auth,
										benificiaryDetails.getIs1097())));
				JSONObject responseObj = new JSONObject(updatedUserData.getJSONObject(0).toString());
				responseObj.put("updateCount", updateCount);
				response.setResponse(responseObj.toString());
			}
		} catch (JSONException e) {
			logger.error("Update beneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		} catch (Exception e) {
			logger.error("Update beneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("update beneficiary response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Fetch beneficiary details by phone no")
	@RequestMapping(value = "/getBeneficiariesByPhoneNo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getBeneficiariesByPhone(@ApiParam("{\"phoneNo\":\"String\"}") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		logger.info("getBeneficiariesByPhoneNo request " + request);
		try {
			BenPhoneMap benPhoneMap = inputMapper.gson().fromJson(request, BenPhoneMap.class);
			int pageNumber = 0;
			int rows = 1000;
			response.setResponse(iemrSearchUserService.findByBeneficiaryPhoneNo(benPhoneMap, pageNumber, rows, auth));
		} catch (Exception e) {
			response.setError(e);
			logger.error("getBeneficiariesByPhoneNo failed with error " + e.getMessage(), e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Update beneficiary community or education")
	@RequestMapping(value = "/updateCommunityorEducation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String updateBenefciaryCommunityorEducation(
			@ApiParam("{\"beneficiaryRegID\":\"Long\",\"i_bendemographics\":{\"communityID\":\"Integer\","
					+ "\"educationID\":\"Integer\"}}") @RequestBody String benificiaryRequest,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		Integer updateCount = 0;
		try {
			BeneficiaryModel benificiaryDetails = inputMapper.gson().fromJson(benificiaryRequest,
					BeneficiaryModel.class);
			updateCount = registerBenificiaryService.updateCommunityorEducation(benificiaryDetails, auth);
			if (updateCount > 0) {
				JSONArray updatedUserData = new JSONArray(
						new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()
								.toJson(iemrSearchUserService.userExitsCheckWithId(
										benificiaryDetails.getBeneficiaryRegID(), auth,
										benificiaryDetails.getIs1097())));
				JSONObject responseObj = new JSONObject(updatedUserData.getJSONObject(0).toString());
				responseObj.put("updateCount", updateCount);
				response.setResponse(responseObj.toString());
			}
		} catch (Exception e) {
			logger.error("Update beneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("update beneficiary response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Generate beneficiary id")
	@RequestMapping(value = "/generateBeneficiaryIDs", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getBeneficiaryIDs(
			@ApiParam("{\"benIDRequired\":\"Integer\",\"vanID\":\"Integer\"}") @RequestBody String request,
			HttpServletRequest httpRequest) {
		logger.info("generateBeneficiaryIDs request " + request);
		OutputResponse response = new OutputResponse();
		try {

			String res = registerBenificiaryService.generateBeneficiaryIDs(request, httpRequest);
			response.setResponse(res);
			logger.info("generateBeneficiaryIDs response " + response.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);
		}
		return response.toString();
	}

}
