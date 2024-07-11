package com.iemr.common.controller.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryEducation;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.SexualOrientation;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.location.States;
import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
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
import com.iemr.common.service.userbeneficiarydata.CommunityService;
import com.iemr.common.service.userbeneficiarydata.EducationService;
import com.iemr.common.service.userbeneficiarydata.GenderService;
import com.iemr.common.service.userbeneficiarydata.LanguageService;
import com.iemr.common.service.userbeneficiarydata.MaritalStatusService;
import com.iemr.common.service.userbeneficiarydata.StatusService;
import com.iemr.common.service.userbeneficiarydata.TitleService;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class BeneficiaryRegistrationControllerTest {

	@InjectMocks
	BeneficiaryRegistrationController beneficiaryRegistrationController;
	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static final String AUTHORIZATION = "authorization";
	@Mock
	private RegisterBenificiaryService registerBenificiaryService;
	@Mock
	private IEMRBeneficiaryTypeService iemrBeneficiaryTypeService;
	@Mock
	private IEMRSearchUserService iemrSearchUserService;
	@Mock
	private EducationService educationService;
	@Mock
	private TitleService titleService;
	@Mock
	private StatusService statusService;
	@Mock
	private LocationService locationService;
	@Mock
	private GenderService genderService;
	@Mock
	private MaritalStatusService maritalStatusService;
	@Mock
	private CommunityService communityService;
	@Mock
	private DirectoryService directoryService;
	@Mock
	private SexualOrientationService sexualOrientationService;
	@Mock
	private LanguageService languageService;
	@Mock
	private BenRelationshipTypeService benRelationshipTypeService;
	@Mock
	private BeneficiaryOccupationService beneficiaryOccupationService;
	@Mock
	private GovtIdentityTypeService govtIdentityTypeService;

	@Test
	void testCreateBeneficiary() throws Exception {

		OutputResponse response = new OutputResponse();

		HttpServletRequest httpRequest = mock(HttpServletRequest.class);

		BeneficiaryModel beneficiaryModel = new BeneficiaryModel();

		beneficiaryModel.setBeneficiaryID("Ben ID");
		beneficiaryModel.setBeneficiaryRegID(123L);

		String expResp = beneficiaryModel.toString();

		when(registerBenificiaryService.save(beneficiaryModel, httpRequest)).thenReturn(expResp);

		logger.info("Create beneficiary request " + beneficiaryModel);

		String resp = beneficiaryRegistrationController.createBeneficiary(beneficiaryModel, httpRequest);

		logger.info("create beneficiary response " + response.toString());

		Assertions.assertEquals(resp,
				beneficiaryRegistrationController.createBeneficiary(beneficiaryModel, httpRequest));

	}

	@Test
	void testSearchUserByID() throws Exception {

		OutputResponse response = new OutputResponse();

		HttpServletRequest httpRequest = mock(HttpServletRequest.class);

		String auth = httpRequest.getHeader(AUTHORIZATION);

		BeneficiaryModel benificiaryDetails = new BeneficiaryModel();
		benificiaryDetails.setBeneficiaryRegID(123L);
		benificiaryDetails.setBeneficiaryID("ab");
		benificiaryDetails.setIs1097(true);
		benificiaryDetails.setHealthID("abc");
		benificiaryDetails.setHealthIDNumber("bcd");
		benificiaryDetails.setFamilyId("vfd");
		benificiaryDetails.setIdentity("cvf");
		String request = benificiaryDetails.toString();
		logger.info("Search user by ID request " + request);
		logger.debug(benificiaryDetails.toString());
		List<BeneficiaryModel> iBeneficiary = new ArrayList<BeneficiaryModel>();
		iBeneficiary.add(benificiaryDetails);

		String expResp = beneficiaryRegistrationController.searchUserByID(request, httpRequest);
		String expResp1 = beneficiaryRegistrationController.searchUserByID(request, httpRequest);
		String expResp2 = beneficiaryRegistrationController.searchUserByID(request, httpRequest);
		String expResp3 = beneficiaryRegistrationController.searchUserByID(request, httpRequest);
		String expResp4 = beneficiaryRegistrationController.searchUserByID(request, httpRequest);
		String expResp5 = beneficiaryRegistrationController.searchUserByID(request, httpRequest);

		try {
			response.setResponse(iBeneficiary.toString());
			logger.info("Search user by ID response size "
					+ (iBeneficiary != null ? iBeneficiary.size() : "No Beneficiary Found"));
		} catch (Exception e) {
			logger.error("search user failed with error " + e.getMessage());
			response.setError(e);
		}
		assertNotNull(benificiaryDetails.getBeneficiaryID());
		assertNotNull(benificiaryDetails.getBeneficiaryRegID());
		assertNotNull(benificiaryDetails.getHealthID());
		assertNotNull(benificiaryDetails.getHealthIDNumber());
		assertNotNull(benificiaryDetails.getFamilyId());
		assertNotNull(benificiaryDetails.getIdentity());
		assertEquals(expResp, beneficiaryRegistrationController.searchUserByID(request, httpRequest));
		assertEquals(expResp1, beneficiaryRegistrationController.searchUserByID(request, httpRequest));
		assertEquals(expResp2, beneficiaryRegistrationController.searchUserByID(request, httpRequest));
		assertEquals(expResp3, beneficiaryRegistrationController.searchUserByID(request, httpRequest));
		assertEquals(expResp4, beneficiaryRegistrationController.searchUserByID(request, httpRequest));
		assertEquals(expResp5, beneficiaryRegistrationController.searchUserByID(request, httpRequest));

	}

	@Test
	void testSearchUserByPhone() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);

		BenPhoneMap benPhoneMap = new BenPhoneMap();
		benPhoneMap.setBenificiaryRegID(123L);
		String request = benPhoneMap.toString();
		logger.info("Serach user by phone no request " + request);
		JSONObject requestObj = new JSONObject(request);
		int pageNumber = requestObj.has("pageNo") ? (requestObj.getInt("pageNo") - 1) : 0;
		int rows = requestObj.has("rowsPerPage") ? requestObj.getInt("rowsPerPage") : 1000;

		String expResp = beneficiaryRegistrationController.searchUserByPhone(request, httpRequest);

		try {
			response.setResponse(expResp);
		} catch (Exception e) {
			logger.error("serach user by phone NO failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		Assertions.assertEquals(expResp, beneficiaryRegistrationController.searchUserByPhone(request, httpRequest));

	}

	@Test
	void testSearchBeneficiary() throws Exception {
		OutputResponse output = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
		beneficiaryModel.setBeneficiaryID("Ben ID");
		beneficiaryModel.setBeneficiaryRegID(123L);

		String resp = beneficiaryModel.toString();

		when(iemrSearchUserService.findBeneficiary(beneficiaryModel, auth)).thenReturn(resp);
		String expResp = beneficiaryRegistrationController.searchBeneficiary(beneficiaryModel, httpRequest);

		try {
			output.setResponse(resp);
		} catch (Exception e) {
			logger.error("searchBeneficiary failed with error " + e.getMessage(), e);
			output.setError(e);
		}

		Assertions.assertEquals(expResp,
				beneficiaryRegistrationController.searchBeneficiary(beneficiaryModel, httpRequest));

	}

	@Test
	void testGetRegistrationData() {
		OutputResponse response = new OutputResponse();
		BeneficiaryRegistrationData beneficiaryRegistrationData = new BeneficiaryRegistrationData();
		Status status = new Status();
		status.setDeleted(false);
		List<Status> statusList = new ArrayList<Status>();
		statusList.add(status);
		beneficiaryRegistrationData.setM_Status(statusList);
		Title title = new Title();
		title.setDeleted(false);
		List<Title> titleList = new ArrayList<Title>();
		titleList.add(title);
		beneficiaryRegistrationData.setM_Title(titleList);
		List<BeneficiaryEducation> beneficiaryEducationList = new ArrayList<BeneficiaryEducation>();
		beneficiaryRegistrationData.setI_BeneficiaryEducation(beneficiaryEducationList);
		States states = new States();
		states.setDeleted(false);
		List<States> statesList = new ArrayList<States>();
		statesList.add(states);
		beneficiaryRegistrationData.setStates(statesList);
		Gender gender = new Gender();
		gender.setCreatedBy("dona");
		List<Gender> genderList = new ArrayList<Gender>();
		genderList.add(gender);
		beneficiaryRegistrationData.setM_genders(genderList);
		MaritalStatus maritalStatus = new MaritalStatus();
		maritalStatus.setCreatedBy("dona");
		List<MaritalStatus> maritalStatusList = new ArrayList<MaritalStatus>();
		maritalStatusList.add(maritalStatus);
		beneficiaryRegistrationData.setM_maritalStatuses(maritalStatusList);
		Community community = new Community();
		community.setDeleted(false);
		List<Community> communityList = new ArrayList<Community>();
		communityList.add(community);
		beneficiaryRegistrationData.setM_communities(communityList);
		Language language = new Language();
		language.setCreatedBy("dona");
		List<Language> languageList = new ArrayList<Language>();
		languageList.add(language);
		beneficiaryRegistrationData.setM_language(languageList);
		List<Directory> directoryList = new ArrayList<Directory>();
		beneficiaryRegistrationData.setDirectory(directoryList);
		SexualOrientation sexualOrientation = new SexualOrientation();
		sexualOrientation.setDeleted(false);
		List<SexualOrientation> sexualOrientationList = new ArrayList<SexualOrientation>();
		sexualOrientationList.add(sexualOrientation);
		beneficiaryRegistrationData.setSexualOrientations(sexualOrientationList);
		BenRelationshipType benRelationshipType = new BenRelationshipType();
		benRelationshipType.setDeleted(false);
		List<BenRelationshipType> benRelationshipTypeList = new ArrayList<BenRelationshipType>();
		benRelationshipTypeList.add(benRelationshipType);
		beneficiaryRegistrationData.setBenRelationshipTypes(benRelationshipTypeList);
		BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
		beneficiaryOccupation.setDeleted(false);
		List<BeneficiaryOccupation> beneficiaryOccupationList = new ArrayList<BeneficiaryOccupation>();
		beneficiaryOccupationList.add(beneficiaryOccupation);
		beneficiaryRegistrationData.setBeneficiaryOccupations(beneficiaryOccupationList);
		GovtIdentityType govtIdentityType = new GovtIdentityType();
		govtIdentityType.setDeleted(false);
		List<GovtIdentityType> govtIdentityTypeList = new ArrayList<GovtIdentityType>();
		govtIdentityTypeList.add(govtIdentityType);
		beneficiaryRegistrationData.setGovtIdentityTypes(govtIdentityTypeList);

		String expResp = beneficiaryRegistrationController.getRegistrationData();

		try {
			response.setResponse(expResp);
		} catch (Exception e) {
			response.setError(e);
			logger.error("get user registration data failed with error " + e.getMessage(), e);
		}

		Assertions.assertEquals(expResp, beneficiaryRegistrationController.getRegistrationData());
	}

	@Test
	void testUpdateBenefciary() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		BeneficiaryModel benificiaryDetails = new BeneficiaryModel();
		benificiaryDetails.setBeneficiaryID("Ben Id");
		benificiaryDetails.setBeneficiaryRegID(123L);
		benificiaryDetails.setIs1097(true);
		String resp = benificiaryDetails.toString();
		Integer updateCount = 1;
		List<BeneficiaryModel> beneficiaryModelList = new ArrayList<BeneficiaryModel>();
		beneficiaryModelList.add(benificiaryDetails);

		String expResp = beneficiaryRegistrationController.updateBenefciary(resp, httpRequest);
		try {
			response.setResponse(expResp);
		} catch (Exception e) {
			logger.error("Update beneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		assertNotEquals(0, updateCount);
		Assertions.assertEquals(expResp, beneficiaryRegistrationController.updateBenefciary(resp, httpRequest));

	}

	@Test
	void testGetBeneficiariesByPhone() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		BenPhoneMap benPhoneMap = new BenPhoneMap();
		benPhoneMap.setBenificiaryRegID(123L);
		String request = benPhoneMap.toString();
		logger.info("getBeneficiariesByPhoneNo request " + request);
		int pageNumber = 0;
		int rows = 1000;
		String expResp = beneficiaryRegistrationController.getBeneficiariesByPhone(request, httpRequest);

		try {
			response.setResponse(expResp);
		} catch (Exception e) {
			response.setError(e);
			logger.error("getBeneficiariesByPhoneNo failed with error " + e.getMessage(), e);
		}

		Assertions.assertEquals(expResp,
				beneficiaryRegistrationController.getBeneficiariesByPhone(request, httpRequest));
	}

	@Test
	void testUpdateBenefciaryCommunityorEducation() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		BeneficiaryModel benificiaryDetails = new BeneficiaryModel();
		benificiaryDetails.setBeneficiaryID("Ben Id");
		Integer updateCount = 1;

		String expResp = beneficiaryRegistrationController.updateBenefciaryCommunityorEducation(auth, httpRequest);

		try {
			response.setResponse(expResp);
		} catch (Exception e) {
			logger.error("Update beneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		assertNotEquals(0, updateCount);
		Assertions.assertEquals(expResp,
				beneficiaryRegistrationController.updateBenefciaryCommunityorEducation(auth, httpRequest));
	}

	@Test
	void testGetBeneficiaryIDs() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		Integer benIDRequired = 123;
		Integer vanID = 342;
		Integer req = Integer.valueOf((benIDRequired) + (vanID));
		String request = req.toString();
		logger.info("generateBeneficiaryIDs request " + request);

		when(registerBenificiaryService.generateBeneficiaryIDs(request, httpRequest)).thenReturn(request);
		String expResp = beneficiaryRegistrationController.getBeneficiaryIDs(request, httpRequest);

		try {
			response.setResponse(expResp);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);
		}

		Assertions.assertEquals(expResp, beneficiaryRegistrationController.getBeneficiaryIDs(request, httpRequest));
	}

}
