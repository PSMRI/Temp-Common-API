package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CallReportTest {

	@InjectMocks
    private CallReport callReportUnderTest;

    @BeforeEach
    void setUp() {
        callReportUnderTest = new CallReport();
    }

    @Test
    void testToString() {
        assertThat(callReportUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetStartDateTime() {
        assertThat(callReportUnderTest.getStartDateTime())
                .isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testGetEndDateTime() {
        assertThat(callReportUnderTest.getEndDateTime())
                .isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testGetProviderServiceMapID() {
        assertThat(callReportUnderTest.getProviderServiceMapID()).isEqualTo(0);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        callReportUnderTest.setAgentID(agentID);
        assertThat(callReportUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        callReportUnderTest.setPhoneNo(phoneNo);
        assertThat(callReportUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testCallTypeNameGetterAndSetter() {
        final String callTypeName = "callTypeName";
        callReportUnderTest.setCallTypeName(callTypeName);
        assertThat(callReportUnderTest.getCallTypeName()).isEqualTo(callTypeName);
    }

    @Test
    void testCallSubTypeNameGetterAndSetter() {
        final String callSubTypeName = "callSubTypeName";
        callReportUnderTest.setCallSubTypeName(callSubTypeName);
        assertThat(callReportUnderTest.getCallSubTypeName()).isEqualTo(callSubTypeName);
    }

    @Test
    void testCallDurationGetterAndSetter() {
        final String callDuration = "callDuration";
        callReportUnderTest.setCallDuration(callDuration);
        assertThat(callReportUnderTest.getCallDuration()).isEqualTo(callDuration);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        callReportUnderTest.setRemarks(remarks);
        assertThat(callReportUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callReportUnderTest.setCreatedDate(createdDate);
        assertThat(callReportUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testBeneficiaryReportGetterAndSetter() {
        final BenDetails beneficiaryReport = new BenDetails();
        callReportUnderTest.setBeneficiaryReport(beneficiaryReport);
        assertThat(callReportUnderTest.getBeneficiaryReport()).isEqualTo(beneficiaryReport);
    }

    @Test
    void testReceivedRoleNameGetterAndSetter() {
        final String receivedRoleName = "receivedRoleName";
        callReportUnderTest.setReceivedRoleName(receivedRoleName);
        assertThat(callReportUnderTest.getReceivedRoleName()).isEqualTo(receivedRoleName);
    }

    @Test
    void testRecordingFilePathGetterAndSetter() {
        final String recordingFilePath = "recordingFilePath";
        callReportUnderTest.setRecordingFilePath(recordingFilePath);
        assertThat(callReportUnderTest.getRecordingFilePath()).isEqualTo(recordingFilePath);
    }

    @Test
    void testGetBenCallID() {
        assertThat(callReportUnderTest.getBenCallID()).isEqualTo(0L);
    }

    @Test
    void testCallIDGetterAndSetter() {
        final String callID = "callID";
        callReportUnderTest.setCallID(callID);
        assertThat(callReportUnderTest.getCallID()).isEqualTo(callID);
    }

    @Test
    void testCallDuartionGetterAndSetter() {
        final String callDuartion = "callDuartion";
        callReportUnderTest.setCallDuartion(callDuartion);
        assertThat(callReportUnderTest.getCallDuartion()).isEqualTo(callDuartion);
    }

    @Test
    void testUserReportObjGetterAndSetter() {
        final DimUserReport userReportObj = new DimUserReport();
        callReportUnderTest.setUserReportObj(userReportObj);
        assertThat(callReportUnderTest.getUserReportObj()).isEqualTo(userReportObj);
    }
}
