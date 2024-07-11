package com.iemr.common.service.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.sms.SMSTemplate;
import com.iemr.common.data.sms.SMSType;
import com.iemr.common.mapper.sms.SMSMapper;
import com.iemr.common.model.sms.SMSRequest;
import com.iemr.common.model.sms.SMSTemplateResponse;
import com.iemr.common.model.sms.SMSTypeModel;
import com.iemr.common.model.sms.UpdateSMSRequest;
import com.iemr.common.repository.callhandling.TCRequestModelRepo;
import com.iemr.common.repository.feedback.FeedbackRepository;
import com.iemr.common.repository.helpline104history.PrescribedDrugRepository;
import com.iemr.common.repository.institute.InstituteRepository;
import com.iemr.common.repository.location.LocationDistrictBlockRepository;
import com.iemr.common.repository.location.LocationDistrictRepository;
import com.iemr.common.repository.location.LocationStateRepository;
import com.iemr.common.repository.mctshistory.OutboundHistoryRepository;
import com.iemr.common.repository.sms.SMSNotificationRepository;
import com.iemr.common.repository.sms.SMSParameterMapRepository;
import com.iemr.common.repository.sms.SMSParameterRepository;
import com.iemr.common.repository.sms.SMSTemplateRepository;
import com.iemr.common.repository.sms.SMSTypeRepository;
import com.iemr.common.repository.users.IEMRUserRepositoryCustom;
import com.iemr.common.service.beneficiary.IEMRSearchUserService;
import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.http.HttpUtils;

@ExtendWith(MockitoExtension.class)
class SMSServiceImplTest {

	@InjectMocks
	private SMSServiceImpl smsService;

	@Mock
	private SMSMapper smsMapper;

	@Mock
	private SMSTemplateRepository smsTemplateRepository;

	@Mock
	SMSTypeRepository smsTypeRepository;

	@Mock
	SMSParameterRepository smsParameterRepository;

	@Mock
	SMSParameterMapRepository smsParameterMapRepository;

	@Mock
	IEMRSearchUserService searchBeneficiary;

	@Mock
	InstituteRepository instituteRepository;

	@Mock
	IEMRUserRepositoryCustom userRepository;

	@Mock
	FeedbackRepository feedbackReporsitory;

	@Mock
	SMSNotificationRepository smsNotification;

	@Mock
	LocationStateRepository stateRepository;

	@Mock
	LocationDistrictRepository districtRepository;

	@Mock
	LocationDistrictBlockRepository blockRepository;

	@Mock
	HttpUtils httpUtils;

	@Mock
	PrescribedDrugRepository prescribedDrugRepository;

	@Mock
	OutboundHistoryRepository outboundHistoryRepository;

	private String prescription;

	private TCRequestModelRepo tCRequestModelRepo;
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static Boolean publishingSMS = false;
	private static final String SMS_GATEWAY_URL = ConfigProperties.getPropertyByName("sms-gateway-url");

	@Test
	void testGetSMSTemplates_smsTypeIDNull() throws Exception {
		// Arrange
		SMSRequest smsRequest = new SMSRequest();
		smsRequest.setProviderServiceMapID(123);

		SMSTemplate request = new SMSTemplate();
		given(smsMapper.requestToSMSTemplate(smsRequest)).willReturn(request);

		// Add these lines to initialize smsTemplate1 and smsTemplate2
		SMSTemplate smsTemplate1 = new SMSTemplate();
		smsTemplate1.setSmsTemplateID(1);

		SMSTemplate smsTemplate2 = new SMSTemplate();
		smsTemplate2.setSmsTemplateID(1);

		List<SMSTemplate> smsTemplates = Arrays.asList(smsTemplate1, smsTemplate2);
		given(smsTemplateRepository.getSMSTemplateByProviderServiceMapIDOrderByDeletedSmsTypeIDDesc(null))
				.willReturn(smsTemplates);

		// Act
		String result = smsService.getSMSTemplates(smsRequest);

		// Assert
		assertNotNull(result);
	}

	@Test
	void updateSMSTemplateSuccess() throws Exception {
		// Given
		UpdateSMSRequest smsRequest = new UpdateSMSRequest(); // Populate with test data as needed
		SMSTemplate requestTemplate = new SMSTemplate(); // Populate with test data as needed
		SMSTemplate updatedTemplate = new SMSTemplate(); // Populate with expected result data
		when(smsMapper.updateRequestToSMSTemplate(smsRequest)).thenReturn(requestTemplate);
		when(smsTemplateRepository.updateSMSTemplate(requestTemplate.getSmsTemplateID(), requestTemplate.getDeleted()))
				.thenReturn(1);
		when(smsTemplateRepository.findBySmsTemplateID(requestTemplate.getSmsTemplateID())).thenReturn(updatedTemplate);
		when(smsMapper.smsTemplateToResponse(updatedTemplate)).thenReturn(new SMSTemplateResponse()); // Assuming a
																										// response type

		// When
		String result = smsService.updateSMSTemplate(smsRequest);

		// Then
		assertNotNull(result);
		// Additional assertions as needed, possibly checking for specific fields in the
		// result

		// Verify interactions
		verify(smsMapper).updateRequestToSMSTemplate(smsRequest);
		verify(smsTemplateRepository).updateSMSTemplate(requestTemplate.getSmsTemplateID(),
				requestTemplate.getDeleted());
		verify(smsTemplateRepository).findBySmsTemplateID(requestTemplate.getSmsTemplateID());
	}

	@Test
	void updateSMSTemplateFailure() {
		// Given
		UpdateSMSRequest smsRequest = new UpdateSMSRequest(); // Populate as needed
		SMSTemplate requestTemplate = new SMSTemplate(); // Populate as needed
		when(smsMapper.updateRequestToSMSTemplate(smsRequest)).thenReturn(requestTemplate);
		when(smsTemplateRepository.updateSMSTemplate(requestTemplate.getSmsTemplateID(), requestTemplate.getDeleted()))
				.thenReturn(0);

		// When/Then
		Exception exception = assertThrows(Exception.class, () -> {
			smsService.updateSMSTemplate(smsRequest);
		});

		// Assert
		assertEquals("Failed to update the result", exception.getMessage());

		// Verify interactions
		verify(smsMapper).updateRequestToSMSTemplate(smsRequest);
		verify(smsTemplateRepository).updateSMSTemplate(requestTemplate.getSmsTemplateID(),
				requestTemplate.getDeleted());
		verifyNoMoreInteractions(smsTemplateRepository); // No further interactions after update attempt
	}

	@Test
	void getSMSTypesSuccess() throws Exception {
		// Given
		SMSTypeModel requestModel = new SMSTypeModel(); // Setup your model
		requestModel.setServiceID(1); // Example service ID
		SMSType smsType = new SMSType(); // Your entity
		List<SMSType> smsTypes = new ArrayList<>();
		smsTypes.add(smsType);

		List<SMSTypeModel> expectedModels = new ArrayList<>(); // Expected result
		expectedModels.add(new SMSTypeModel()); // Populate as necessary

		when(smsMapper.smsTypeModelToSMSType(requestModel)).thenReturn(smsType);
		when(smsTypeRepository.findSMSTypeByDeletedNotTrue(smsType.getServiceID()))
				.thenReturn((ArrayList<SMSType>) smsTypes);
		when(smsMapper.smsTypeToSMSTypeModel(smsTypes)).thenReturn(expectedModels);

		// When
		String resultJson = smsService.getSMSTypes(requestModel);

		// Then
		assertNotNull(resultJson);
		// Assuming your JSON mapper works as expected, you might want to check for
		// specific JSON output.
		// For simplicity, here we'll just check that the result is not null or empty.
		assertFalse(resultJson.isEmpty());

		// Verify interactions
		verify(smsMapper).smsTypeModelToSMSType(requestModel);
		verify(smsTypeRepository).findSMSTypeByDeletedNotTrue(smsType.getServiceID());
		verify(smsMapper).smsTypeToSMSTypeModel(smsTypes);
	}

}
