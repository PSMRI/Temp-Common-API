package com.iemr.common.data.callhandling;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BeneficiaryCallTest {

	@InjectMocks
    private BeneficiaryCall beneficiaryCallUnderTest;

    @BeforeEach
    void setUp() {
        beneficiaryCallUnderTest = new BeneficiaryCall(0L, Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                "remarks", 0L, 0L, 0L, Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L);
    }

    @Test
    void testToString() {
        assertThat(beneficiaryCallUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        beneficiaryCallUnderTest.setBenCallID(benCallID);
        assertThat(beneficiaryCallUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        beneficiaryCallUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(beneficiaryCallUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBeneficiaryGetterAndSetter() {
        final Beneficiary beneficiary = new Beneficiary();
        beneficiaryCallUnderTest.setBeneficiary(beneficiary);
        assertThat(beneficiaryCallUnderTest.getBeneficiary()).isEqualTo(beneficiary);
    }

    @Test
    void testCallIDGetterAndSetter() {
        final String callID = "callID";
        beneficiaryCallUnderTest.setCallID(callID);
        assertThat(beneficiaryCallUnderTest.getCallID()).isEqualTo(callID);
    }

    @Test
    void testCalledServiceIDGetterAndSetter() {
        final Integer calledServiceID = 0;
        beneficiaryCallUnderTest.setCalledServiceID(calledServiceID);
        assertThat(beneficiaryCallUnderTest.getCalledServiceID()).isEqualTo(calledServiceID);
    }

    @Test
    void testIs1097GetterAndSetter() {
        final Boolean is1097 = false;
        beneficiaryCallUnderTest.setIs1097(is1097);
        assertThat(beneficiaryCallUnderTest.getIs1097()).isFalse();
    }

    @Test
    void testCallTimeGetterAndSetter() {
        final Timestamp callTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryCallUnderTest.setCallTime(callTime);
        assertThat(beneficiaryCallUnderTest.getCallTime()).isEqualTo(callTime);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        beneficiaryCallUnderTest.setRemarks(remarks);
        assertThat(beneficiaryCallUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testServicesProvidedGetterAndSetter() {
        final String servicesProvided = "servicesProvided";
        beneficiaryCallUnderTest.setServicesProvided(servicesProvided);
        assertThat(beneficiaryCallUnderTest.getServicesProvided()).isEqualTo(servicesProvided);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        beneficiaryCallUnderTest.setCallTypeID(callTypeID);
        assertThat(beneficiaryCallUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testCallTypeObjGetterAndSetter() {
        final CallType callTypeObj = new CallType();
        beneficiaryCallUnderTest.setCallTypeObj(callTypeObj);
        assertThat(beneficiaryCallUnderTest.getCallTypeObj()).isEqualTo(callTypeObj);
    }

    @Test
    void testCallClosureTypeGetterAndSetter() {
        final String callClosureType = "callClosureType";
        beneficiaryCallUnderTest.setCallClosureType(callClosureType);
        assertThat(beneficiaryCallUnderTest.getCallClosureType()).isEqualTo(callClosureType);
    }

    @Test
    void testDispositionStatusIDGetterAndSetter() {
        final Integer dispositionStatusID = 0;
        beneficiaryCallUnderTest.setDispositionStatusID(dispositionStatusID);
        assertThat(beneficiaryCallUnderTest.getDispositionStatusID()).isEqualTo(dispositionStatusID);
    }

    @Test
    void testCallReceivedUserIDGetterAndSetter() {
        final Integer callReceivedUserID = 0;
        beneficiaryCallUnderTest.setCallReceivedUserID(callReceivedUserID);
        assertThat(beneficiaryCallUnderTest.getCallReceivedUserID()).isEqualTo(callReceivedUserID);
    }

    @Test
    void testCallEndUserIDGetterAndSetter() {
        final Integer callEndUserID = 0;
        beneficiaryCallUnderTest.setCallEndUserID(callEndUserID);
        assertThat(beneficiaryCallUnderTest.getCallEndUserID()).isEqualTo(callEndUserID);
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "category";
        beneficiaryCallUnderTest.setCategory(category);
        assertThat(beneficiaryCallUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testSubCategoryGetterAndSetter() {
        final String subCategory = "subCategory";
        beneficiaryCallUnderTest.setSubCategory(subCategory);
        assertThat(beneficiaryCallUnderTest.getSubCategory()).isEqualTo(subCategory);
    }

    @Test
    void testCDICallStatusGetterAndSetter() {
        final String cDICallStatus = "cDICallStatus";
        beneficiaryCallUnderTest.setCDICallStatus(cDICallStatus);
        assertThat(beneficiaryCallUnderTest.getCDICallStatus()).isEqualTo(cDICallStatus);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        beneficiaryCallUnderTest.setAgentID(agentID);
        assertThat(beneficiaryCallUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testIsOutboundGetterAndSetter() {
        final Boolean isOutbound = false;
        beneficiaryCallUnderTest.setOutbound(isOutbound);
        assertThat(beneficiaryCallUnderTest.isOutbound()).isFalse();
    }

    @Test
    void testIsCalledEarlierGetterAndSetter() {
        final Boolean isCalledEarlier = false;
        beneficiaryCallUnderTest.setIsCalledEarlier(isCalledEarlier);
        assertThat(beneficiaryCallUnderTest.getIsCalledEarlier()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        beneficiaryCallUnderTest.setDeleted(deleted);
        assertThat(beneficiaryCallUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        beneficiaryCallUnderTest.setCreatedBy(createdBy);
        assertThat(beneficiaryCallUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryCallUnderTest.setCreatedDate(createdDate);
        assertThat(beneficiaryCallUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        beneficiaryCallUnderTest.setModifiedBy(modifiedBy);
        assertThat(beneficiaryCallUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryCallUnderTest.setLastModDate(lastModDate);
        assertThat(beneficiaryCallUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testInformationServicesGetterAndSetter() {
        final Long informationServices = 0L;
        beneficiaryCallUnderTest.setInformationServices(informationServices);
        assertThat(beneficiaryCallUnderTest.getInformationServices()).isEqualTo(informationServices);
    }

    @Test
    void testFeedbackServicesGetterAndSetter() {
        final Long feedbackServices = 0L;
        beneficiaryCallUnderTest.setFeedbackServices(feedbackServices);
        assertThat(beneficiaryCallUnderTest.getFeedbackServices()).isEqualTo(feedbackServices);
    }

    @Test
    void testReferralServicesGetterAndSetter() {
        final Long referralServices = 0L;
        beneficiaryCallUnderTest.setReferralServices(referralServices);
        assertThat(beneficiaryCallUnderTest.getReferralServices()).isEqualTo(referralServices);
    }

    @Test
    void testCounsellingServicesGetterAndSetter() {
        final Long counsellingServices = 0L;
        beneficiaryCallUnderTest.setCounsellingServices(counsellingServices);
        assertThat(beneficiaryCallUnderTest.getCounsellingServices()).isEqualTo(counsellingServices);
    }

    @Test
    void testFilterStartDateGetterAndSetter() {
        final Timestamp filterStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryCallUnderTest.setFilterStartDate(filterStartDate);
        assertThat(beneficiaryCallUnderTest.getFilterStartDate()).isEqualTo(filterStartDate);
    }

    @Test
    void testFilterEndDateGetterAndSetter() {
        final Timestamp filterEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryCallUnderTest.setFilterEndDate(filterEndDate);
        assertThat(beneficiaryCallUnderTest.getFilterEndDate()).isEqualTo(filterEndDate);
    }

    @Test
    void testFitToBlockGetterAndSetter() {
        final Boolean fitToBlock = false;
        beneficiaryCallUnderTest.setFitToBlock(fitToBlock);
        assertThat(beneficiaryCallUnderTest.getFitToBlock()).isFalse();
    }

    @Test
    void testIsFeedbackGetterAndSetter() {
        final Boolean isFeedback = false;
        beneficiaryCallUnderTest.setIsFeedback(isFeedback);
        assertThat(beneficiaryCallUnderTest.getIsFeedback()).isFalse();
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        beneficiaryCallUnderTest.setPhoneNo(phoneNo);
        assertThat(beneficiaryCallUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testReceivedRoleNameGetterAndSetter() {
        final String receivedRoleName = "receivedRoleName";
        beneficiaryCallUnderTest.setReceivedRoleName(receivedRoleName);
        assertThat(beneficiaryCallUnderTest.getReceivedRoleName()).isEqualTo(receivedRoleName);
    }

    @Test
    void testEndCallGetterAndSetter() {
        final Boolean endCall = false;
        beneficiaryCallUnderTest.setEndCall(endCall);
        assertThat(beneficiaryCallUnderTest.getEndCall()).isFalse();
    }

    @Test
    void testAgentIPAddressGetterAndSetter() {
        final String agentIPAddress = "agentIPAddress";
        beneficiaryCallUnderTest.setAgentIPAddress(agentIPAddress);
        assertThat(beneficiaryCallUnderTest.getAgentIPAddress()).isEqualTo(agentIPAddress);
    }

    @Test
    void testMaxCountGetterAndSetter() {
        final Long maxCount = 0L;
        beneficiaryCallUnderTest.setMaxCount(maxCount);
        assertThat(beneficiaryCallUnderTest.getMaxCount()).isEqualTo(maxCount);
    }

    @Test
    void testRecordingPathGetterAndSetter() {
        final String recordingPath = "recordingPath";
        beneficiaryCallUnderTest.setRecordingPath(recordingPath);
        assertThat(beneficiaryCallUnderTest.getRecordingPath()).isEqualTo(recordingPath);
    }

    @Test
    void testArchivePathGetterAndSetter() {
        final String archivePath = "archivePath";
        beneficiaryCallUnderTest.setArchivePath(archivePath);
        assertThat(beneficiaryCallUnderTest.getArchivePath()).isEqualTo(archivePath);
    }

    @Test
    void testEmergencyTypeGetterAndSetter() {
        final Short emergencyType = (short) 0;
        beneficiaryCallUnderTest.setEmergencyType(emergencyType);
        assertThat(beneficiaryCallUnderTest.getEmergencyType()).isEqualTo(emergencyType);
    }

    @Test
    void testCountGetterAndSetter() {
        final Integer count = 0;
        beneficiaryCallUnderTest.setCount(count);
        assertThat(beneficiaryCallUnderTest.getCount()).isEqualTo(count);
    }

    @Test
    void testInboundOutboundGetterAndSetter() {
        final String inboundOutbound = "inboundOutbound";
        beneficiaryCallUnderTest.setInboundOutbound(inboundOutbound);
        assertThat(beneficiaryCallUnderTest.getInboundOutbound()).isEqualTo(inboundOutbound);
    }

    @Test
    void testBenCallIDsGetterAndSetter() {
        final String benCallIDs = "benCallIDs";
        beneficiaryCallUnderTest.setBenCallIDs(benCallIDs);
        assertThat(beneficiaryCallUnderTest.getBenCallIDs()).isEqualTo(benCallIDs);
    }

    @Test
    void testPageNoGetterAndSetter() {
        final Integer pageNo = 0;
        beneficiaryCallUnderTest.setPageNo(pageNo);
        assertThat(beneficiaryCallUnderTest.getPageNo()).isEqualTo(pageNo);
    }

    @Test
    void testPageSizeGetterAndSetter() {
        final Integer pageSize = 0;
        beneficiaryCallUnderTest.setPageSize(pageSize);
        assertThat(beneficiaryCallUnderTest.getPageSize()).isEqualTo(pageSize);
    }

    @Test
    void testCallEndTimeGetterAndSetter() {
        final Timestamp callEndTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryCallUnderTest.setCallEndTime(callEndTime);
        assertThat(beneficiaryCallUnderTest.getCallEndTime()).isEqualTo(callEndTime);
    }

    @Test
    void testCallDurationGetterAndSetter() {
        final String callDuration = "callDuration";
        beneficiaryCallUnderTest.setCallDuration(callDuration);
        assertThat(beneficiaryCallUnderTest.getCallDuration()).isEqualTo(callDuration);
    }

    @Test
    void testCZcallStartTimeGetterAndSetter() {
        final String cZcallStartTime = "cZcallStartTime";
        beneficiaryCallUnderTest.setCZcallStartTime(cZcallStartTime);
        assertThat(beneficiaryCallUnderTest.getCZcallStartTime()).isEqualTo(cZcallStartTime);
    }

    @Test
    void testCZcallEndTimeGetterAndSetter() {
        final String cZcallEndTime = "cZcallEndTime";
        beneficiaryCallUnderTest.setCZcallEndTime(cZcallEndTime);
        assertThat(beneficiaryCallUnderTest.getCZcallEndTime()).isEqualTo(cZcallEndTime);
    }

    @Test
    void testCZcallDurationGetterAndSetter() {
        final Integer cZcallDuration = 0;
        beneficiaryCallUnderTest.setCZcallDuration(cZcallDuration);
        assertThat(beneficiaryCallUnderTest.getCZcallDuration()).isEqualTo(cZcallDuration);
    }

    @Test
    void testExternalReferralGetterAndSetter() {
        final String externalReferral = "externalReferral";
        beneficiaryCallUnderTest.setExternalReferral(externalReferral);
        assertThat(beneficiaryCallUnderTest.getExternalReferral()).isEqualTo(externalReferral);
    }

    @Test
    void testInstTypeIdGetterAndSetter() {
        final Integer instTypeId = 0;
        beneficiaryCallUnderTest.setInstTypeId(instTypeId);
        assertThat(beneficiaryCallUnderTest.getInstTypeId()).isEqualTo(instTypeId);
    }

    @Test
    void testInstNameGetterAndSetter() {
        final String instName = "instName";
        beneficiaryCallUnderTest.setInstName(instName);
        assertThat(beneficiaryCallUnderTest.getInstName()).isEqualTo(instName);
    }

    @Test
    void testInstNamesGetterAndSetter() {
        final String[] instNames = new String[]{"instNames"};
        beneficiaryCallUnderTest.setInstNames(instNames);
        assertThat(beneficiaryCallUnderTest.getInstNames()).isEqualTo(instNames);
    }

    @Test
    void testIsOutboundManualDialGetterAndSetter() {
        final Boolean isOutboundManualDial = false;
        beneficiaryCallUnderTest.setIsOutboundManualDial(isOutboundManualDial);
        assertThat(beneficiaryCallUnderTest.getIsOutboundManualDial()).isFalse();
    }

    @Test
    void testIsTransferedGetterAndSetter() {
        final Boolean isTransfered = false;
        beneficiaryCallUnderTest.setIsTransfered(isTransfered);
        assertThat(beneficiaryCallUnderTest.getIsTransfered()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        beneficiaryCallUnderTest.setOutputMapper(outputMapper);
        assertThat(beneficiaryCallUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(beneficiaryCallUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(beneficiaryCallUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(beneficiaryCallUnderTest.hashCode()).isEqualTo(0);
    }
}
