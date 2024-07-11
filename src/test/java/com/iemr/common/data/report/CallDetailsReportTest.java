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
class CallDetailsReportTest {

	@InjectMocks
    private CallDetailsReport callDetailsReportUnderTest;

    @BeforeEach
    void setUp() {
        callDetailsReportUnderTest = new CallDetailsReport();
    }

    @Test
    void testStartDateTimeGetterAndSetter() {
        final Timestamp startDateTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setStartDateTime(startDateTime);
        assertThat(callDetailsReportUnderTest.getStartDateTime()).isEqualTo(startDateTime);
    }

    @Test
    void testEndDateTimeGetterAndSetter() {
        final Timestamp endDateTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setEndDateTime(endDateTime);
        assertThat(callDetailsReportUnderTest.getEndDateTime()).isEqualTo(endDateTime);
    }

    @Test
    void testGetDOB() {
        assertThat(CallDetailsReport.getDOB(0)).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testCheckOutbound() {
        assertThat(callDetailsReportUnderTest.checkOutbound()).isEqualTo("Outbound");
    }

    @Test
    void testToString() {
        assertThat(callDetailsReportUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCallSummaryIDGetterAndSetter() {
        final Long callSummaryID = 0L;
        callDetailsReportUnderTest.setCallSummaryID(callSummaryID);
        assertThat(callDetailsReportUnderTest.getCallSummaryID()).isEqualTo(callSummaryID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        callDetailsReportUnderTest.setBenCallID(benCallID);
        assertThat(callDetailsReportUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        callDetailsReportUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(callDetailsReportUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenReportGetterAndSetter() {
        final BeneficiaryDetailsReport benReport = new BeneficiaryDetailsReport();
        callDetailsReportUnderTest.setBenReport(benReport);
        assertThat(callDetailsReportUnderTest.getBenReport()).isEqualTo(benReport);
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        callDetailsReportUnderTest.setFeedbackID(feedbackID);
        assertThat(callDetailsReportUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testFeedbackGetterAndSetter() {
        final FeedbackReport feedback = new FeedbackReport();
        callDetailsReportUnderTest.setFeedback(feedback);
        assertThat(callDetailsReportUnderTest.getFeedback()).isEqualTo(feedback);
    }

    @Test
    void testLoadDateGetterAndSetter() {
        final Timestamp loadDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setLoadDate(loadDate);
        assertThat(callDetailsReportUnderTest.getLoadDate()).isEqualTo(loadDate);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        callDetailsReportUnderTest.setUserID(userID);
        assertThat(callDetailsReportUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testCallStartTimeGetterAndSetter() {
        final Timestamp callStartTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setCallStartTime(callStartTime);
        assertThat(callDetailsReportUnderTest.getCallStartTime()).isEqualTo(callStartTime);
    }

    @Test
    void testCallEndTimeGetterAndSetter() {
        final Timestamp callEndTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setCallEndTime(callEndTime);
        assertThat(callDetailsReportUnderTest.getCallEndTime()).isEqualTo(callEndTime);
    }

    @Test
    void testCategoryNameGetterAndSetter() {
        final String categoryName = "categoryName";
        callDetailsReportUnderTest.setCategoryName(categoryName);
        assertThat(callDetailsReportUnderTest.getCategoryName()).isEqualTo(categoryName);
    }

    @Test
    void testSubCategoryNameGetterAndSetter() {
        final String subCategoryName = "subCategoryName";
        callDetailsReportUnderTest.setSubCategoryName(subCategoryName);
        assertThat(callDetailsReportUnderTest.getSubCategoryName()).isEqualTo(subCategoryName);
    }

    @Test
    void testDocumentNameGetterAndSetter() {
        final String documentName = "documentName";
        callDetailsReportUnderTest.setDocumentName(documentName);
        assertThat(callDetailsReportUnderTest.getDocumentName()).isEqualTo(documentName);
    }

    @Test
    void testCounselingCategoryNameGetterAndSetter() {
        final String counselingCategoryName = "counselingCategoryName";
        callDetailsReportUnderTest.setCounselingCategoryName(counselingCategoryName);
        assertThat(callDetailsReportUnderTest.getCounselingCategoryName()).isEqualTo(counselingCategoryName);
    }

    @Test
    void testCounselingSubCategoryNameGetterAndSetter() {
        final String counselingSubCategoryName = "counselingSubCategoryName";
        callDetailsReportUnderTest.setCounselingSubCategoryName(counselingSubCategoryName);
        assertThat(callDetailsReportUnderTest.getCounselingSubCategoryName()).isEqualTo(counselingSubCategoryName);
    }

    @Test
    void testCounsellingDocumentNameGetterAndSetter() {
        final String counsellingDocumentName = "counsellingDocumentName";
        callDetailsReportUnderTest.setCounsellingDocumentName(counsellingDocumentName);
        assertThat(callDetailsReportUnderTest.getCounsellingDocumentName()).isEqualTo(counsellingDocumentName);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        callDetailsReportUnderTest.setAgentID(agentID);
        assertThat(callDetailsReportUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testCallIDGetterAndSetter() {
        final String callID = "callID";
        callDetailsReportUnderTest.setCallID(callID);
        assertThat(callDetailsReportUnderTest.getCallID()).isEqualTo(callID);
    }

    @Test
    void testUsernameGetterAndSetter() {
        final String username = "username";
        callDetailsReportUnderTest.setUsername(username);
        assertThat(callDetailsReportUnderTest.getUsername()).isEqualTo(username);
    }

    @Test
    void testOutboundRequestedLanguageGetterAndSetter() {
        final String outboundRequestedLanguage = "outboundRequestedLanguage";
        callDetailsReportUnderTest.setOutboundRequestedLanguage(outboundRequestedLanguage);
        assertThat(callDetailsReportUnderTest.getOutboundRequestedLanguage()).isEqualTo(outboundRequestedLanguage);
    }

    @Test
    void testCallTransferRemarksGetterAndSetter() {
        final String callTransferRemarks = "callTransferRemarks";
        callDetailsReportUnderTest.setCallTransferRemarks(callTransferRemarks);
        assertThat(callDetailsReportUnderTest.getCallTransferRemarks()).isEqualTo(callTransferRemarks);
    }

    @Test
    void testCallTypeGetterAndSetter() {
        final String callType = "callType";
        callDetailsReportUnderTest.setCallType(callType);
        assertThat(callDetailsReportUnderTest.getCallType()).isEqualTo(callType);
    }

    @Test
    void testCallSubTypeGetterAndSetter() {
        final String callSubType = "callSubType";
        callDetailsReportUnderTest.setCallSubType(callSubType);
        assertThat(callDetailsReportUnderTest.getCallSubType()).isEqualTo(callSubType);
    }

    @Test
    void testUserRoleGetterAndSetter() {
        final String userRole = "userRole";
        callDetailsReportUnderTest.setUserRole(userRole);
        assertThat(callDetailsReportUnderTest.getUserRole()).isEqualTo(userRole);
    }

    @Test
    void testLoadedByGetterAndSetter() {
        final String loadedBy = "loadedBy";
        callDetailsReportUnderTest.setLoadedBy(loadedBy);
        assertThat(callDetailsReportUnderTest.getLoadedBy()).isEqualTo(loadedBy);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        callDetailsReportUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(callDetailsReportUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testStartTimestampGetterAndSetter() {
        final Timestamp startTimestamp = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setStartTimestamp(startTimestamp);
        assertThat(callDetailsReportUnderTest.getStartTimestamp()).isEqualTo(startTimestamp);
    }

    @Test
    void testEndTimestampGetterAndSetter() {
        final Timestamp endTimestamp = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setEndTimestamp(endTimestamp);
        assertThat(callDetailsReportUnderTest.getEndTimestamp()).isEqualTo(endTimestamp);
    }

    @Test
    void testMinAgeGetterAndSetter() {
        final Integer minAge = 0;
        callDetailsReportUnderTest.setMinAge(minAge);
        assertThat(callDetailsReportUnderTest.getMinAge()).isEqualTo(minAge);
    }

    @Test
    void testMaxAgeGetterAndSetter() {
        final Integer maxAge = 0;
        callDetailsReportUnderTest.setMaxAge(maxAge);
        assertThat(callDetailsReportUnderTest.getMaxAge()).isEqualTo(maxAge);
    }

    @Test
    void testMaxDOBGetterAndSetter() {
        final Timestamp maxDOB = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setMaxDOB(maxDOB);
        assertThat(callDetailsReportUnderTest.getMaxDOB()).isEqualTo(maxDOB);
    }

    @Test
    void testMinDOBGetterAndSetter() {
        final Timestamp minDOB = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callDetailsReportUnderTest.setMinDOB(minDOB);
        assertThat(callDetailsReportUnderTest.getMinDOB()).isEqualTo(minDOB);
    }

    @Test
    void testIsCalledEarlierGetterAndSetter() {
        final Boolean isCalledEarlier = false;
        callDetailsReportUnderTest.setIsCalledEarlier(isCalledEarlier);
        assertThat(callDetailsReportUnderTest.getIsCalledEarlier()).isFalse();
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        callDetailsReportUnderTest.setPhoneNo(phoneNo);
        assertThat(callDetailsReportUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        callDetailsReportUnderTest.setRemarks(remarks);
        assertThat(callDetailsReportUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testIsOutboundGetterAndSetter() {
        final Boolean isOutbound = false;
        callDetailsReportUnderTest.setIsOutbound(isOutbound);
        assertThat(callDetailsReportUnderTest.getIsOutbound()).isFalse();
    }

    @Test
    void testBeneficiaryCallTypeGetterAndSetter() {
        final String beneficiaryCallType = "beneficiaryCallType";
        callDetailsReportUnderTest.setBeneficiaryCallType(beneficiaryCallType);
        assertThat(callDetailsReportUnderTest.getBeneficiaryCallType()).isEqualTo(beneficiaryCallType);
    }

    @Test
    void testBeneficiaryCallSubTypeGetterAndSetter() {
        final String beneficiaryCallSubType = "beneficiaryCallSubType";
        callDetailsReportUnderTest.setBeneficiaryCallSubType(beneficiaryCallSubType);
        assertThat(callDetailsReportUnderTest.getBeneficiaryCallSubType()).isEqualTo(beneficiaryCallSubType);
    }
}
