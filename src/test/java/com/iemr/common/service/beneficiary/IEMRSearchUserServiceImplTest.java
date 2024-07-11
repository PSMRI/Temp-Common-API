package com.iemr.common.service.beneficiary;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.data.everwell.BenPhoneMaps;
import com.iemr.common.dto.identity.Address;
import com.iemr.common.dto.identity.BenDetailDTO;
import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.dto.identity.IdentitySearchDTO;
import com.iemr.common.mapper.BenCompleteDetailMapper;
import com.iemr.common.mapper.BenPhoneMapperDecorator;
import com.iemr.common.mapper.CommunityMapper;
import com.iemr.common.mapper.DistrictBlockMapper;
import com.iemr.common.mapper.DistrictBranchMapper;
import com.iemr.common.mapper.DistrictMapper;
import com.iemr.common.mapper.EducationMapper;
import com.iemr.common.mapper.GenderMapper;
import com.iemr.common.mapper.GovtIdentityTypeMapper;
import com.iemr.common.mapper.HealthCareWorkerMapper;
import com.iemr.common.mapper.IdentityBenEditMapper;
import com.iemr.common.mapper.MaritalStatusMapper;
import com.iemr.common.mapper.RelationshipMapper;
import com.iemr.common.mapper.SexualOrientationMapper;
import com.iemr.common.mapper.StateMapper;
import com.iemr.common.mapper.TitleMapper;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.repository.beneficiary.BeneficiaryRelationshipTypeRepository;
import com.iemr.common.repository.beneficiary.CommunityRepository;
import com.iemr.common.repository.beneficiary.EducationRepository;
import com.iemr.common.repository.beneficiary.GovtIdentityTypeRepository;
import com.iemr.common.repository.location.LocationDistrictBlockRepository;
import com.iemr.common.repository.location.LocationDistrictRepository;
import com.iemr.common.repository.location.LocationDistrilctBranchRepository;
import com.iemr.common.repository.location.LocationStateRepository;
import com.iemr.common.repository.userbeneficiarydata.GenderRepository;
import com.iemr.common.repository.userbeneficiarydata.MaritalStatusRepository;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;
import com.iemr.common.repository.userbeneficiarydata.TitleRepository;
import com.iemr.common.utils.mapper.OutputMapper;

@ExtendWith(MockitoExtension.class)
class IEMRSearchUserServiceImplTest {
	@Mock
	private BenCompleteDetailMapper benCompleteDetailMapper;

	@Mock
	private BenPhoneMapperDecorator benPhoneMapperDecorator;

	@Mock
	private BeneficiaryRelationshipTypeRepository beneficiaryRelationshipTypeRepository;

	@Mock
	private CommunityMapper communityMapper;

	@Mock
	private CommunityRepository communityRepository;

	@Mock
	private DistrictBlockMapper districtBlockMapper;

	@Mock
	private DistrictBranchMapper districtBranchMapper;

	@Mock
	private DistrictMapper districtMapper;

	@Mock
	private EducationMapper educationMapper;

	@Mock
	private EducationRepository educationRepository;

	@Mock
	private GenderMapper genderMapper;

	@Mock
	private GenderRepository genderRepository;

	@Mock
	private GovtIdentityTypeMapper govtIdentityTypeMapper;

	@Mock
	private GovtIdentityTypeRepository govtIdentityTypeRepository;

	@Mock
	private HealthCareWorkerMapper healthCareWorkerMapper;

	@InjectMocks
	private IEMRSearchUserServiceImpl iEMRSearchUserServiceImpl;

	@Mock
	private IdentityBenEditMapper identityBenEditMapper;

	@Mock
	private IdentityBeneficiaryService identityBeneficiaryService;

	@Mock
	private LocationDistrictBlockRepository locationDistrictBlockRepository;

	@Mock
	private LocationDistrictRepository locationDistrictRepository;

	@Mock
	private LocationDistrilctBranchRepository locationDistrilctBranchRepository;

	@Mock
	private LocationStateRepository locationStateRepository;

	@Mock
	private MaritalStatusMapper maritalStatusMapper;

	@Mock
	private MaritalStatusRepository maritalStatusRepository;

	@Mock
	private RelationshipMapper relationshipMapper;

	@Mock
	private SexualOrientationMapper sexualOrientationMapper;

	@Mock
	private SexualOrientationRepository sexualOrientationRepository;

	@Mock
	private StateMapper stateMapper;

	@Mock
	private TitleMapper titleMapper;

	@Mock
	private TitleRepository titleRepository;
	@Mock
	BenPhoneMapperDecorator benPhoneMapper;
	@Mock
	private BenCompleteDetailMapper benCompleteMapper;
	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testUserExitsCheckWithId() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByBenRegID(Mockito.<Long>any(), Mockito.<String>any(),
				Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		List<BeneficiaryModel> actualUserExitsCheckWithIdResult = iEMRSearchUserServiceImpl.userExitsCheckWithId(1L,
				"Auth", true);

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByBenRegID(Mockito.<Long>any(), eq("Auth"),
				Mockito.<Boolean>any());
		assertTrue(actualUserExitsCheckWithIdResult.isEmpty());
	}

	@Test
	void testUserExitsCheckWithId2() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByBenID(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		List<BeneficiaryModel> actualUserExitsCheckWithIdResult = iEMRSearchUserServiceImpl
				.userExitsCheckWithId("Beneficiary ID", "Auth", true);

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByBenID(eq("Beneficiary ID"), eq("Auth"),
				Mockito.<Boolean>any());
		assertTrue(actualUserExitsCheckWithIdResult.isEmpty());
	}

	@Test
	void testUserExitsCheckWithHealthId_ABHAId() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByHealthID_ABHAAddress(Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		List<BeneficiaryModel> actualUserExitsCheckWithHealthId_ABHAIdResult = iEMRSearchUserServiceImpl
				.userExitsCheckWithHealthId_ABHAId("Health ID", "Auth", true);

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByHealthID_ABHAAddress(eq("Health ID"), eq("Auth"),
				Mockito.<Boolean>any());
		assertTrue(actualUserExitsCheckWithHealthId_ABHAIdResult.isEmpty());
	}

	@Test
	void testUserExitsCheckWithHealthIdNo_ABHAIdNo() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByHealthIDNo_ABHAIDNo(Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		List<BeneficiaryModel> actualUserExitsCheckWithHealthIdNo_ABHAIdNoResult = iEMRSearchUserServiceImpl
				.userExitsCheckWithHealthIdNo_ABHAIdNo("Health IDNo", "Auth", true);

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByHealthIDNo_ABHAIDNo(eq("Health IDNo"), eq("Auth"),
				Mockito.<Boolean>any());
		assertTrue(actualUserExitsCheckWithHealthIdNo_ABHAIdNoResult.isEmpty());
	}

	@Test
	void testUserExitsCheckWithFamilyId() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByFamilyId(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		List<BeneficiaryModel> actualUserExitsCheckWithFamilyIdResult = iEMRSearchUserServiceImpl
				.userExitsCheckWithFamilyId("42", "Auth", true);

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByFamilyId(eq("42"), eq("Auth"), Mockito.<Boolean>any());
		assertTrue(actualUserExitsCheckWithFamilyIdResult.isEmpty());
	}

	@Test
	void testUserExitsCheckWithGovIdentity() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByGovId(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		List<BeneficiaryModel> actualUserExitsCheckWithGovIdentityResult = iEMRSearchUserServiceImpl
				.userExitsCheckWithGovIdentity("Identity", "Auth", true);

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByGovId(eq("Identity"), eq("Auth"),
				Mockito.<Boolean>any());
		assertTrue(actualUserExitsCheckWithGovIdentityResult.isEmpty());
	}

	@Test
	void testFindByBeneficiaryPhoneNo() throws Exception {
		// Arrange
		when(identityBeneficiaryService.getBeneficiaryListByPhone(Mockito.<String>any(), Mockito.<String>any(),
				Mockito.<Boolean>any())).thenReturn(new ArrayList<>());

		// Act
		String actualFindByBeneficiaryPhoneNoResult = iEMRSearchUserServiceImpl
				.findByBeneficiaryPhoneNo(new BenPhoneMap(), 1, 1, "Auth");

		// Assert
		verify(identityBeneficiaryService).getBeneficiaryListByPhone(isNull(), eq("Auth"), Mockito.<Boolean>any());
		assertEquals("[]", actualFindByBeneficiaryPhoneNoResult);
	}

	@Test
	void testGetBeneficiaryListFromMapper() {
		// Arrange, Act and Assert
		assertTrue(iEMRSearchUserServiceImpl.getBeneficiaryListFromMapper(new ArrayList<>()).isEmpty());
	}

	@Test
	void testGetBeneficiaryListFromMapper_NonEmptyList() {
		BeneficiariesDTO beneficiaryDTO = mock(BeneficiariesDTO.class);

		List<BeneficiariesDTO> beneficiariesDTOList = Collections.singletonList(beneficiaryDTO);

		BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
		when(benCompleteMapper.benDetailForOutboundDTOToIBeneficiary(beneficiaryDTO)).thenReturn(beneficiaryModel);

		when(benPhoneMapper.benPhoneMapToResponseByID(Mockito.any())).thenReturn(null);

		when(sexualOrientationMapper.sexualOrientationByIDToModel((Short) null)).thenReturn(null);

		when(govtIdentityTypeMapper.govtIdentityTypeModelByIDToModel(Mockito.any())).thenReturn(null);

		when(benCompleteMapper.createBenDemographicsModel(Mockito.any()))
				.thenReturn(mock(BeneficiaryDemographicsModel.class));

		when(healthCareWorkerMapper.getModelByWorkerID(Mockito.anyShort())).thenReturn(null);

		when(genderMapper.genderByIDToLoginResponse(Mockito.any())).thenReturn(null);

		when(maritalStatusMapper.maritalStatusByIDToResponse(Mockito.any())).thenReturn(null);

		when(titleMapper.titleByIDToResponse(Mockito.anyInt())).thenReturn(null);

		when(beneficiaryDTO.getAbhaDetails()).thenReturn(null);

		BenDetailDTO beneficiaryDetails = mock(BenDetailDTO.class);
		when(beneficiaryDTO.getBeneficiaryDetails()).thenReturn(beneficiaryDetails);

		// Test

		List<BeneficiaryModel> result = iEMRSearchUserServiceImpl.getBeneficiaryListFromMapper(beneficiariesDTOList);

		// Verify

		assertFalse(result.isEmpty());

		assertEquals(1, result.size());

		assertEquals(beneficiaryModel, result.get(0));

	}

}
