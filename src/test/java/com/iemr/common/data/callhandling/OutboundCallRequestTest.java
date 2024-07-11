package com.iemr.common.data.callhandling;

import com.iemr.common.data.service.SubService;
import com.iemr.common.data.users.User;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OutboundCallRequestTest {

	@InjectMocks
    private OutboundCallRequest outboundCallRequestUnderTest;

    @BeforeEach
    void setUp() {
        outboundCallRequestUnderTest = new OutboundCallRequest();
    }

    @Test
    void testGetOutboundCall1() {
        // Setup
        final BeneficiaryModel beneficiary = new BeneficiaryModel();
        beneficiary.setBeneficiaryRegID(0L);
        final BeneficiaryDemographicsModel i_bendemographics = new BeneficiaryDemographicsModel();
        i_bendemographics.setBenDemographicsID(0L);
        i_bendemographics.setBeneficiaryRegID(0L);
        i_bendemographics.setEducationID(0);
        beneficiary.setI_bendemographics(i_bendemographics);

        final User user = new User();
        user.setUserID(0L);
        user.setTitleID(0);
        user.setFirstName("firstName");
        user.setMiddleName("middleName");
        user.setLastName("lastName");

        final SubService requestedService = new SubService(0, "subServiceName", "subServiceDesc", false);
        final OutboundCallRequest expectedResult = new OutboundCallRequest();
        expectedResult.setDeleted(false);
        final User user1 = new User();
        user1.setUserID(0L);
        expectedResult.setUser(user1);
        expectedResult.setOutboundCallReqID(0L);
        final BeneficiaryModel beneficiary1 = new BeneficiaryModel();
        expectedResult.setBeneficiary(beneficiary1);
        expectedResult.setAssignedUserID(0);
        expectedResult.setProviderServiceMapID(0);
        expectedResult.setPrefferedDateTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setRequestedFor("requestedFor");
        expectedResult.setRequestedFeature("requestedFeature");
        expectedResult.setIsCompleted(false);
        expectedResult.setRequestedServiceID(0);
        final SubService requestedService1 = new SubService();
        expectedResult.setRequestedService(requestedService1);
        expectedResult.setRequestNo("requestNo");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setNoOfTrials(0);
        expectedResult.setReceivedRoleName("receivedRoleName");
        expectedResult.setPreferredLanguageName("preferredLanguageName");
        expectedResult.setFilterStartDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setFilterEndDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setOutboundCallReqIDs(List.of(0L));
        expectedResult.setIsSelf(false);
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final OutboundCallRequest result = outboundCallRequestUnderTest.getOutboundCall(0L, beneficiary,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0, "requestedFor", user, 0,
                requestedService, "requestNo", "preferredLanguage", "requestedFeature", 0, false,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetOutboundCall2() {
        // Setup
        final OutboundCallRequest expectedResult = new OutboundCallRequest();
        expectedResult.setDeleted(false);
        final User user = new User();
        user.setUserID(0L);
        expectedResult.setUser(user);
        expectedResult.setOutboundCallReqID(0L);
        final BeneficiaryModel beneficiary = new BeneficiaryModel();
        expectedResult.setBeneficiary(beneficiary);
        expectedResult.setAssignedUserID(0);
        expectedResult.setProviderServiceMapID(0);
        expectedResult.setPrefferedDateTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setRequestedFor("requestedFor");
        expectedResult.setRequestedFeature("requestedFeature");
        expectedResult.setIsCompleted(false);
        expectedResult.setRequestedServiceID(0);
        final SubService requestedService = new SubService();
        expectedResult.setRequestedService(requestedService);
        expectedResult.setRequestNo("requestNo");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setNoOfTrials(0);
        expectedResult.setReceivedRoleName("receivedRoleName");
        expectedResult.setPreferredLanguageName("preferredLanguageName");
        expectedResult.setFilterStartDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setFilterEndDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setOutboundCallReqIDs(List.of(0L));
        expectedResult.setIsSelf(false);
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final OutboundCallRequest result = outboundCallRequestUnderTest.getOutboundCall(0L, 0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        outboundCallRequestUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(outboundCallRequestUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testAssignedUserIDGetterAndSetter() {
        final Integer assignedUserID = 0;
        outboundCallRequestUnderTest.setAssignedUserID(assignedUserID);
        assertThat(outboundCallRequestUnderTest.getAssignedUserID()).isEqualTo(assignedUserID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        outboundCallRequestUnderTest.setDeleted(deleted);
        assertThat(outboundCallRequestUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testUserGetterAndSetter() {
        final User user = new User();
        outboundCallRequestUnderTest.setUser(user);
        assertThat(outboundCallRequestUnderTest.getUser()).isEqualTo(user);
    }

    @Test
    void testOutboundCallReqIDGetterAndSetter() {
        final Long outboundCallReqID = 0L;
        outboundCallRequestUnderTest.setOutboundCallReqID(outboundCallReqID);
        assertThat(outboundCallRequestUnderTest.getOutboundCallReqID()).isEqualTo(outboundCallReqID);
    }

    @Test
    void testIsCompletedGetterAndSetter() {
        final Boolean isCompleted = false;
        outboundCallRequestUnderTest.setIsCompleted(isCompleted);
        assertThat(outboundCallRequestUnderTest.getIsCompleted()).isFalse();
    }

    @Test
    void testRequestedForGetterAndSetter() {
        final String requestedFor = "requestedFor";
        outboundCallRequestUnderTest.setRequestedFor(requestedFor);
        assertThat(outboundCallRequestUnderTest.getRequestedFor()).isEqualTo(requestedFor);
    }

    @Test
    void testRequestedServiceIDGetterAndSetter() {
        final Integer requestedServiceID = 0;
        outboundCallRequestUnderTest.setRequestedServiceID(requestedServiceID);
        assertThat(outboundCallRequestUnderTest.getRequestedServiceID()).isEqualTo(requestedServiceID);
    }

    @Test
    void testPreferredLanguageNameGetterAndSetter() {
        final String preferredLanguageName = "preferredLanguageName";
        outboundCallRequestUnderTest.setPreferredLanguageName(preferredLanguageName);
        assertThat(outboundCallRequestUnderTest.getPreferredLanguageName()).isEqualTo(preferredLanguageName);
    }

    @Test
    void testFilterStartDateGetterAndSetter() {
        final Timestamp filterStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setFilterStartDate(filterStartDate);
        assertThat(outboundCallRequestUnderTest.getStartDate()).isEqualTo(filterStartDate);
    }

    @Test
    void testFilterEndDateGetterAndSetter() {
        final Timestamp filterEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setFilterEndDate(filterEndDate);
        assertThat(outboundCallRequestUnderTest.getEndDate()).isEqualTo(filterEndDate);
    }

    @Test
    void testToString() {
        assertThat(outboundCallRequestUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInitializeOutboundCallListByCallID() {
        // Setup
        final SubService requestedService = new SubService(0, "subServiceName", "subServiceDesc", false);

        // Run the test
        final OutboundCallRequest result = OutboundCallRequest.initializeOutboundCallListByCallID(0L,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0, "requestedFor", 0, requestedService,
                "requestNo", "receivedRoleName", "preferredLanguage", 0, false,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        final BeneficiaryModel beneficiary = new BeneficiaryModel();
        beneficiary.setBeneficiaryRegID(0L);
        final BeneficiaryDemographicsModel i_bendemographics = new BeneficiaryDemographicsModel();
        i_bendemographics.setBenDemographicsID(0L);
        i_bendemographics.setBeneficiaryRegID(0L);
        i_bendemographics.setEducationID(0);
        beneficiary.setI_bendemographics(i_bendemographics);

        final User user = new User();
        user.setUserID(0L);
        user.setTitleID(0);
        user.setFirstName("firstName");
        user.setMiddleName("middleName");
        user.setLastName("lastName");

        final SubService requestedService1 = new SubService(0, "subServiceName", "subServiceDesc", false);
        assertThat(
                result.getOutboundCall(0L, beneficiary, Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0,
                        "requestedFor", user, 0, requestedService1, "requestNo", "preferredLanguage",
                        "requestedFeature", 0, false,
                        Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0))))
                .isEqualTo(new OutboundCallRequest());
        assertThat(result.getOutboundCall(0L, 0L)).isEqualTo(new OutboundCallRequest());
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getAssignedUserID()).isEqualTo(0);
        assertThat(result.getOutboundCallReqID()).isEqualTo(0L);
        assertThat(result.getIsCompleted()).isFalse();
        assertThat(result.getRequestedFor()).isEqualTo("requestedFor");
        assertThat(result.getRequestedServiceID()).isEqualTo(0);
        assertThat(result.getPreferredLanguageName()).isEqualTo("preferredLanguageName");
        assertThat(result.getStartDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getEndDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getOutboundCallReqIDs()).isEqualTo(List.of(0L));
        assertThat(result.getBeneficiaryRegID()).isEqualTo(0L);
        assertThat(result.getBeneficiary()).isEqualTo(new BeneficiaryModel());
        assertThat(result.getUser()).isEqualTo(new User());
        assertThat(result.getCallTypeID()).isEqualTo(0);
        assertThat(result.getPrefferedDateTime())
                .isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getRequestedFeature()).isEqualTo("requestedFeature");
        assertThat(result.getBenCallID()).isEqualTo(0L);
        assertThat(result.getRequestedService())
                .isEqualTo(new SubService(0, "subServiceName", "subServiceDesc", false));
        assertThat(result.getRequestNo()).isEqualTo("requestNo");
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isFalse();
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getNoOfTrials()).isEqualTo(0);
        assertThat(result.getReceivedRoleName()).isEqualTo("receivedRoleName");
        assertThat(result.getFilterStartDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getFilterEndDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getIs1097()).isFalse();
        assertThat(result.getIsSelf()).isFalse();
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testOutboundCallReqIDsGetterAndSetter() {
        final List<Long> outboundCallReqIDs = List.of(0L);
        outboundCallRequestUnderTest.setOutboundCallReqIDs(outboundCallReqIDs);
        assertThat(outboundCallRequestUnderTest.getOutboundCallReqIDs()).isEqualTo(outboundCallReqIDs);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        outboundCallRequestUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(outboundCallRequestUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBeneficiaryGetterAndSetter() {
        final BeneficiaryModel beneficiary = new BeneficiaryModel();
        outboundCallRequestUnderTest.setBeneficiary(beneficiary);
        assertThat(outboundCallRequestUnderTest.getBeneficiary()).isEqualTo(beneficiary);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        outboundCallRequestUnderTest.setCallTypeID(callTypeID);
        assertThat(outboundCallRequestUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testPrefferedDateTimeGetterAndSetter() {
        final Timestamp prefferedDateTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setPrefferedDateTime(prefferedDateTime);
        assertThat(outboundCallRequestUnderTest.getPrefferedDateTime()).isEqualTo(prefferedDateTime);
    }

    @Test
    void testRequestedFeatureGetterAndSetter() {
        final String requestedFeature = "requestedFeature";
        outboundCallRequestUnderTest.setRequestedFeature(requestedFeature);
        assertThat(outboundCallRequestUnderTest.getRequestedFeature()).isEqualTo(requestedFeature);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        outboundCallRequestUnderTest.setBenCallID(benCallID);
        assertThat(outboundCallRequestUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testRequestedServiceGetterAndSetter() {
        final SubService requestedService = new SubService(0, "subServiceName", "subServiceDesc", false);
        outboundCallRequestUnderTest.setRequestedService(requestedService);
        assertThat(outboundCallRequestUnderTest.getRequestedService()).isEqualTo(requestedService);
    }

    @Test
    void testRequestNoGetterAndSetter() {
        final String requestNo = "requestNo";
        outboundCallRequestUnderTest.setRequestNo(requestNo);
        assertThat(outboundCallRequestUnderTest.getRequestNo()).isEqualTo(requestNo);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        outboundCallRequestUnderTest.setCreatedBy(createdBy);
        assertThat(outboundCallRequestUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setCreatedDate(createdDate);
        assertThat(outboundCallRequestUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final Boolean modifiedBy = false;
        outboundCallRequestUnderTest.setModifiedBy(modifiedBy);
        assertThat(outboundCallRequestUnderTest.getModifiedBy()).isFalse();
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setLastModDate(lastModDate);
        assertThat(outboundCallRequestUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testNoOfTrialsGetterAndSetter() {
        final Integer noOfTrials = 0;
        outboundCallRequestUnderTest.setNoOfTrials(noOfTrials);
        assertThat(outboundCallRequestUnderTest.getNoOfTrials()).isEqualTo(noOfTrials);
    }

    @Test
    void testReceivedRoleNameGetterAndSetter() {
        final String receivedRoleName = "receivedRoleName";
        outboundCallRequestUnderTest.setReceivedRoleName(receivedRoleName);
        assertThat(outboundCallRequestUnderTest.getReceivedRoleName()).isEqualTo(receivedRoleName);
    }

    @Test
    void testFilterStartDate1GetterAndSetter() {
        final Timestamp filterStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setFilterStartDate(filterStartDate);
        assertThat(outboundCallRequestUnderTest.getFilterStartDate()).isEqualTo(filterStartDate);
    }

    @Test
    void testFilterEndDate1GetterAndSetter() {
        final Timestamp filterEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        outboundCallRequestUnderTest.setFilterEndDate(filterEndDate);
        assertThat(outboundCallRequestUnderTest.getFilterEndDate()).isEqualTo(filterEndDate);
    }

    @Test
    void testIs1097GetterAndSetter() {
        final Boolean is1097 = false;
        outboundCallRequestUnderTest.setIs1097(is1097);
        assertThat(outboundCallRequestUnderTest.getIs1097()).isFalse();
    }

    @Test
    void testIsSelfGetterAndSetter() {
        final Boolean isSelf = false;
        outboundCallRequestUnderTest.setIsSelf(isSelf);
        assertThat(outboundCallRequestUnderTest.getIsSelf()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        outboundCallRequestUnderTest.setOutputMapper(outputMapper);
        assertThat(outboundCallRequestUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(outboundCallRequestUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(outboundCallRequestUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(outboundCallRequestUnderTest.hashCode()).isEqualTo(0);
    }
}
