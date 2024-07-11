package com.iemr.common.service.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.dto.identity.CommonIdentityDTO;
import com.iemr.common.dto.identity.IdentityEditDTO;
import com.iemr.common.mapper.CommonIdentityMapper;
import com.iemr.common.mapper.IdentityBenEditMapper;
import com.iemr.common.mapper.utils.InputMapper;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.common.model.beneficiary.BeneficiaryGenModel;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.model.userbeneficiary.BeneficiaryIdentityModel;
import com.iemr.common.repository.mctshistory.OutboundHistoryRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.validator.Validator;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
class RegisterBenificiaryServiceImplTest {

	@InjectMocks
	RegisterBenificiaryServiceImpl registerBenificiaryServiceImpl;
	@Mock
	CommonIdentityMapper identityMapper;
	@Mock
	IdentityBeneficiaryService identityBeneficiaryService;
	@Mock
	IdentityBenEditMapper identityBenEditMapper;
	@Mock
	Validator validator;
	@Mock
	OutboundHistoryRepository outboundHistoryRepository;
	@Mock
	private InputMapper inputMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testSaveBeneficiary() {
		Beneficiary beneficiary = new Beneficiary();
		Beneficiary savedBeneficiary = registerBenificiaryServiceImpl.save(beneficiary);
		assertNotNull(savedBeneficiary, "Saved beneficiary should not be null");

		// Verify that no interactions happened with the mocks as the method is
		verifyNoInteractions(identityMapper, identityBeneficiaryService, identityBenEditMapper, validator,
				outboundHistoryRepository);
	}

	@Test
	void testUpdateBenificiary() throws IEMRException {
		BeneficiaryModel beneficiaryModel = new BeneficiaryModel(); // Create a mock BeneficiaryModel

		String auth = "Auth"; // Mock authentication string

		List<BeneficiaryIdentityModel> beneficiaryIdentities = new ArrayList<>();
		beneficiaryIdentities.add(new BeneficiaryIdentityModel());
		beneficiaryModel.setBeneficiaryIdentities(beneficiaryIdentities);
		IdentityEditDTO identityEditDTO = new IdentityEditDTO();
		when(identityBenEditMapper.BenToIdentityEditMapper(beneficiaryModel)).thenReturn(identityEditDTO);
		when(identityBeneficiaryService.editIdentityEditDTO(identityEditDTO, auth, false)).thenReturn(1);
		Integer actualUpdateBenificiaryResult = registerBenificiaryServiceImpl.updateBenificiary(beneficiaryModel,
				auth);
		verify(identityBenEditMapper).BenToIdentityEditMapper(beneficiaryModel);
		verify(identityBeneficiaryService).editIdentityEditDTO(identityEditDTO, auth, false);
		assertNotNull(beneficiaryIdentities);
		assertEquals(1, actualUpdateBenificiaryResult.intValue());
	}

	@Test
	void testSaveBeneficiaryModelHttpServletRequest() throws Exception {

		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
		beneficiaryModel.setIs1097(false); // Set a default value for is1097
		when(httpServletRequest.getHeader("authorization")).thenReturn("mockAuthToken");
		CommonIdentityDTO identityDTO = new CommonIdentityDTO();
		when(identityMapper.beneficiaryModelCommonIdentityDTO(beneficiaryModel)).thenReturn(identityDTO);
		String identityResponse = "{\"response\":{\"data\":{\"benId\":1,\"benRegId\":123}}}";
		when(identityBeneficiaryService.getIdentityResponse(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyBoolean())).thenReturn(identityResponse);
		String response = registerBenificiaryServiceImpl.save(beneficiaryModel, httpServletRequest);
		assertNotNull(response, "Response should not be null");
		verify(identityMapper).beneficiaryModelCommonIdentityDTO(beneficiaryModel);

		verify(identityBeneficiaryService).getIdentityResponse(Mockito.anyString(),
				ArgumentMatchers.eq("mockAuthToken"), ArgumentMatchers.eq(false));

	}

	@Test
	void testUpdateCommunityorEducation() throws IEMRException {
		BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
		beneficiaryModel.setBeneficiaryRegID(123L);
		beneficiaryModel.setIs1097(false);

		BeneficiaryDemographicsModel iBenDemographics = new BeneficiaryDemographicsModel();
		iBenDemographics.setCommunityID(1);
		iBenDemographics.setEducationID(2);
		beneficiaryModel.setI_bendemographics(iBenDemographics);
		String auth = "mockAuth";
		when(identityBeneficiaryService.editIdentityEditDTOCommunityorEducation(Mockito.any(IdentityEditDTO.class),
				Mockito.eq(auth), Mockito.eq(false))).thenReturn(1);

		Integer updatedRows = registerBenificiaryServiceImpl.updateCommunityorEducation(beneficiaryModel, auth);
		assertEquals(1, updatedRows);

		verify(identityBeneficiaryService).editIdentityEditDTOCommunityorEducation(Mockito.any(IdentityEditDTO.class),
				Mockito.eq(auth), Mockito.eq(false));
	}

	@Test
	void testGenerateBeneficiaryIDs() throws Exception {
		String request = "{\"request\":{}}";
		HttpServletRequest servletRequest = mock(HttpServletRequest.class);
		when(servletRequest.getHeader("authorization")).thenReturn("mockAuth");
		List<BeneficiaryGenModel> beneficiaryGenModels = new ArrayList<>();
		beneficiaryGenModels.add(new BeneficiaryGenModel());
		when(identityBeneficiaryService.generateBeneficiaryIDs(Mockito.anyString(), Mockito.eq("mockAuth")))
				.thenReturn(beneficiaryGenModels);

		String response = registerBenificiaryServiceImpl.generateBeneficiaryIDs(request, servletRequest);
		assertNotNull(response, "Response should not be null");

	}

}
