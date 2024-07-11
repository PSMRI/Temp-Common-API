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
class FeedbackReportTest {

	@InjectMocks
    private FeedbackReport feedbackReportUnderTest;

    @BeforeEach
    void setUp() {
        feedbackReportUnderTest = new FeedbackReport();
    }

    @Test
    void testToString() {
        assertThat(feedbackReportUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFactFeedbackIDGetterAndSetter() {
        final Long factFeedbackID = 0L;
        feedbackReportUnderTest.setFactFeedbackID(factFeedbackID);
        assertThat(feedbackReportUnderTest.getFactFeedbackID()).isEqualTo(factFeedbackID);
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        feedbackReportUnderTest.setFeedbackID(feedbackID);
        assertThat(feedbackReportUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        feedbackReportUnderTest.setBenCallID(benCallID);
        assertThat(feedbackReportUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        feedbackReportUnderTest.setRequestID(requestID);
        assertThat(feedbackReportUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        feedbackReportUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(feedbackReportUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testFeedbackAgainstGetterAndSetter() {
        final String feedbackAgainst = "feedbackAgainst";
        feedbackReportUnderTest.setFeedbackAgainst(feedbackAgainst);
        assertThat(feedbackReportUnderTest.getFeedbackAgainst()).isEqualTo(feedbackAgainst);
    }

    @Test
    void testDesignationIDGetterAndSetter() {
        final Integer designationID = 0;
        feedbackReportUnderTest.setDesignationID(designationID);
        assertThat(feedbackReportUnderTest.getDesignationID()).isEqualTo(designationID);
    }

    @Test
    void testDesignationNameGetterAndSetter() {
        final String designationName = "designationName";
        feedbackReportUnderTest.setDesignationName(designationName);
        assertThat(feedbackReportUnderTest.getDesignationName()).isEqualTo(designationName);
    }

    @Test
    void testInstitutionIDGetterAndSetter() {
        final Integer institutionID = 0;
        feedbackReportUnderTest.setInstitutionID(institutionID);
        assertThat(feedbackReportUnderTest.getInstitutionID()).isEqualTo(institutionID);
    }

    @Test
    void testInstitutionNameGetterAndSetter() {
        final String institutionName = "institutionName";
        feedbackReportUnderTest.setInstitutionName(institutionName);
        assertThat(feedbackReportUnderTest.getInstitutionName()).isEqualTo(institutionName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        feedbackReportUnderTest.setStateID(stateID);
        assertThat(feedbackReportUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testStateNameGetterAndSetter() {
        final String stateName = "stateName";
        feedbackReportUnderTest.setStateName(stateName);
        assertThat(feedbackReportUnderTest.getStateName()).isEqualTo(stateName);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        feedbackReportUnderTest.setDistrictID(districtID);
        assertThat(feedbackReportUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictNameGetterAndSetter() {
        final String districtName = "districtName";
        feedbackReportUnderTest.setDistrictName(districtName);
        assertThat(feedbackReportUnderTest.getDistrictName()).isEqualTo(districtName);
    }

    @Test
    void testBlockIDGetterAndSetter() {
        final Integer blockID = 0;
        feedbackReportUnderTest.setBlockID(blockID);
        assertThat(feedbackReportUnderTest.getBlockID()).isEqualTo(blockID);
    }

    @Test
    void testBlockNameGetterAndSetter() {
        final String blockName = "blockName";
        feedbackReportUnderTest.setBlockName(blockName);
        assertThat(feedbackReportUnderTest.getBlockName()).isEqualTo(blockName);
    }

    @Test
    void testDistrictBranchIDGetterAndSetter() {
        final Integer districtBranchID = 0;
        feedbackReportUnderTest.setDistrictBranchID(districtBranchID);
        assertThat(feedbackReportUnderTest.getDistrictBranchID()).isEqualTo(districtBranchID);
    }

    @Test
    void testDistrictBranchNameGetterAndSetter() {
        final String districtBranchName = "districtBranchName";
        feedbackReportUnderTest.setDistrictBranchName(districtBranchName);
        assertThat(feedbackReportUnderTest.getDistrictBranchName()).isEqualTo(districtBranchName);
    }

    @Test
    void testInstitutionTypeIDGetterAndSetter() {
        final Integer institutionTypeID = 0;
        feedbackReportUnderTest.setInstitutionTypeID(institutionTypeID);
        assertThat(feedbackReportUnderTest.getInstitutionTypeID()).isEqualTo(institutionTypeID);
    }

    @Test
    void testInstituteTypeNameGetterAndSetter() {
        final String instituteTypeName = "instituteTypeName";
        feedbackReportUnderTest.setInstituteTypeName(instituteTypeName);
        assertThat(feedbackReportUnderTest.getInstituteTypeName()).isEqualTo(instituteTypeName);
    }

    @Test
    void testSeverityIDGetterAndSetter() {
        final Integer severityID = 0;
        feedbackReportUnderTest.setSeverityID(severityID);
        assertThat(feedbackReportUnderTest.getSeverityID()).isEqualTo(severityID);
    }

    @Test
    void testSeverityNameGetterAndSetter() {
        final String severityName = "severityName";
        feedbackReportUnderTest.setSeverityName(severityName);
        assertThat(feedbackReportUnderTest.getSeverityName()).isEqualTo(severityName);
    }

    @Test
    void testFeedbackTypeIDGetterAndSetter() {
        final Integer feedbackTypeID = 0;
        feedbackReportUnderTest.setFeedbackTypeID(feedbackTypeID);
        assertThat(feedbackReportUnderTest.getFeedbackTypeID()).isEqualTo(feedbackTypeID);
    }

    @Test
    void testFeedbackTypeNameGetterAndSetter() {
        final String feedbackTypeName = "feedbackTypeName";
        feedbackReportUnderTest.setFeedbackTypeName(feedbackTypeName);
        assertThat(feedbackReportUnderTest.getFeedbackTypeName()).isEqualTo(feedbackTypeName);
    }

    @Test
    void testFeedbackNatureIDGetterAndSetter() {
        final Integer feedbackNatureID = 0;
        feedbackReportUnderTest.setFeedbackNatureID(feedbackNatureID);
        assertThat(feedbackReportUnderTest.getFeedbackNatureID()).isEqualTo(feedbackNatureID);
    }

    @Test
    void testFeedbackNatureNameGetterAndSetter() {
        final String feedbackNatureName = "feedbackNatureName";
        feedbackReportUnderTest.setFeedbackNatureName(feedbackNatureName);
        assertThat(feedbackReportUnderTest.getFeedbackNatureName()).isEqualTo(feedbackNatureName);
    }

    @Test
    void testFeedbackStatusIDGetterAndSetter() {
        final Integer feedbackStatusID = 0;
        feedbackReportUnderTest.setFeedbackStatusID(feedbackStatusID);
        assertThat(feedbackReportUnderTest.getFeedbackStatusID()).isEqualTo(feedbackStatusID);
    }

    @Test
    void testFeedbackStatusNameGetterAndSetter() {
        final String feedbackStatusName = "feedbackStatusName";
        feedbackReportUnderTest.setFeedbackStatusName(feedbackStatusName);
        assertThat(feedbackReportUnderTest.getFeedbackStatusName()).isEqualTo(feedbackStatusName);
    }

    @Test
    void testFeedbackGetterAndSetter() {
        final String feedback = "feedback";
        feedbackReportUnderTest.setFeedback(feedback);
        assertThat(feedbackReportUnderTest.getFeedback()).isEqualTo(feedback);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        feedbackReportUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(feedbackReportUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        feedbackReportUnderTest.setUserID(userID);
        assertThat(feedbackReportUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testSmsPhoneNoGetterAndSetter() {
        final String smsPhoneNo = "smsPhoneNo";
        feedbackReportUnderTest.setSmsPhoneNo(smsPhoneNo);
        assertThat(feedbackReportUnderTest.getSmsPhoneNo()).isEqualTo(smsPhoneNo);
    }

    @Test
    void testServiceAvailDateGetterAndSetter() {
        final Timestamp serviceAvailDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackReportUnderTest.setServiceAvailDate(serviceAvailDate);
        assertThat(feedbackReportUnderTest.getServiceAvailDate()).isEqualTo(serviceAvailDate);
    }

    @Test
    void testEmailStatusIDGetterAndSetter() {
        final Integer emailStatusID = 0;
        feedbackReportUnderTest.setEmailStatusID(emailStatusID);
        assertThat(feedbackReportUnderTest.getEmailStatusID()).isEqualTo(emailStatusID);
    }

    @Test
    void testLoadedByGetterAndSetter() {
        final String loadedBy = "loadedBy";
        feedbackReportUnderTest.setLoadedBy(loadedBy);
        assertThat(feedbackReportUnderTest.getLoadedBy()).isEqualTo(loadedBy);
    }

    @Test
    void testLodadedDateGetterAndSetter() {
        final Timestamp lodadedDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackReportUnderTest.setLodadedDate(lodadedDate);
        assertThat(feedbackReportUnderTest.getLodadedDate()).isEqualTo(lodadedDate);
    }

    @Test
    void testStartDateGetterAndSetter() {
        final Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackReportUnderTest.setStartDate(startDate);
        assertThat(feedbackReportUnderTest.getStartDate()).isEqualTo(startDate);
    }

    @Test
    void testEndDateGetterAndSetter() {
        final Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackReportUnderTest.setEndDate(endDate);
        assertThat(feedbackReportUnderTest.getEndDate()).isEqualTo(endDate);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackReportUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackReportUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testEquals() {
        assertThat(feedbackReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackReportUnderTest.hashCode()).isEqualTo(0);
    }
}
