package com.iemr.common.data.feedback;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.institute.Institute;
import com.iemr.common.data.institute.InstituteType;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.data.users.EmailStatus;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackDetailsTest {

    private FeedbackDetails feedbackDetailsUnderTest;

    @BeforeEach
    void setUp() {
        feedbackDetailsUnderTest = new FeedbackDetails(0L, 0L, "instiName", 0, 0, 0, 0, "feedback", 0L, 0, 0,
                "sMSPhoneNo", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "feedbackAgainst");
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        feedbackDetailsUnderTest.setFeedbackID(feedbackID);
        assertThat(feedbackDetailsUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        feedbackDetailsUnderTest.setRequestID(requestID);
        assertThat(feedbackDetailsUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testInstitutionIDGetterAndSetter() {
        final Long institutionID = 0L;
        feedbackDetailsUnderTest.setInstitutionID(institutionID);
        assertThat(feedbackDetailsUnderTest.getInstitutionID()).isEqualTo(institutionID);
    }

    @Test
    void testInstiNameGetterAndSetter() {
        final String instiName = "instiName";
        feedbackDetailsUnderTest.setInstiName(instiName);
        assertThat(feedbackDetailsUnderTest.getInstiName()).isEqualTo(instiName);
    }

    @Test
    void testDesignationIDGetterAndSetter() {
        final Integer designationID = 0;
        feedbackDetailsUnderTest.setDesignationID(designationID);
        assertThat(feedbackDetailsUnderTest.getDesignationID()).isEqualTo(designationID);
    }

    @Test
    void testSeverityIDGetterAndSetter() {
        final Integer severityID = 0;
        feedbackDetailsUnderTest.setSeverityID(severityID);
        assertThat(feedbackDetailsUnderTest.getSeverityID()).isEqualTo(severityID);
    }

    @Test
    void testFeedbackTypeIDGetterAndSetter() {
        final Integer feedbackTypeID = 0;
        feedbackDetailsUnderTest.setFeedbackTypeID(feedbackTypeID);
        assertThat(feedbackDetailsUnderTest.getFeedbackTypeID()).isEqualTo(feedbackTypeID);
    }

    @Test
    void testFeedbackStatusIDGetterAndSetter() {
        final Integer feedbackStatusID = 0;
        feedbackDetailsUnderTest.setFeedbackStatusID(feedbackStatusID);
        assertThat(feedbackDetailsUnderTest.getFeedbackStatusID()).isEqualTo(feedbackStatusID);
    }

    @Test
    void testFeedbackGetterAndSetter() {
        final String feedback = "feedback";
        feedbackDetailsUnderTest.setFeedback(feedback);
        assertThat(feedbackDetailsUnderTest.getFeedback()).isEqualTo(feedback);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        feedbackDetailsUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(feedbackDetailsUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Integer serviceID = 0;
        feedbackDetailsUnderTest.setServiceID(serviceID);
        assertThat(feedbackDetailsUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        feedbackDetailsUnderTest.setUserID(userID);
        assertThat(feedbackDetailsUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testSMSPhoneNoGetterAndSetter() {
        final String sMSPhoneNo = "sMSPhoneNo";
        feedbackDetailsUnderTest.setsMSPhoneNo(sMSPhoneNo);
        assertThat(feedbackDetailsUnderTest.getsMSPhoneNo()).isEqualTo(sMSPhoneNo);
    }

    @Test
    void testServiceAvailDateGetterAndSetter() {
        final Timestamp serviceAvailDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackDetailsUnderTest.setServiceAvailDate(serviceAvailDate);
        assertThat(feedbackDetailsUnderTest.getServiceAvailDate()).isEqualTo(serviceAvailDate);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackDetailsUnderTest.setDeleted(deleted);
        assertThat(feedbackDetailsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackDetailsUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackDetailsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackDetailsUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackDetailsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackDetailsUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackDetailsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackDetailsUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackDetailsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        feedbackDetailsUnderTest.setBenCallID(benCallID);
        assertThat(feedbackDetailsUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testSubServiceIDGetterAndSetter() {
        final Integer subServiceID = 0;
        feedbackDetailsUnderTest.setSubServiceID(subServiceID);
        assertThat(feedbackDetailsUnderTest.getSubServiceID()).isEqualTo(subServiceID);
    }

    @Test
    void testToString() {
        assertThat(feedbackDetailsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testEmailStatusIDGetterAndSetter() {
        final Integer emailStatusID = 0;
        feedbackDetailsUnderTest.setEmailStatusID(emailStatusID);
        assertThat(feedbackDetailsUnderTest.getEmailStatusID()).isEqualTo(emailStatusID);
    }

    @Test
    void testInitializeFeedbackDetailsWithAllFeilds() {
        // Setup
        final User mUser = new User();
        mUser.setUserID(0L);
        mUser.setTitleID(0);
        mUser.setFirstName("firstName");
        mUser.setMiddleName("middleName");
        mUser.setLastName("lastName");

        final Institute institute = new Institute(0, "institutionName", 0, 0, 0);
        final Designation designation = new Designation(0, "designationName");
        final FeedbackSeverity severity = new FeedbackSeverity(0, "severityTypeName");
        final FeedbackStatus feedbackStatus = new FeedbackStatus(0, "feedbackStatus", "feedbackStatusDesc");
        final ProviderServiceMapping mservicemaster = new ProviderServiceMapping(false, 0);
        final EmailStatus emailStatus = new EmailStatus();
        emailStatus.setEmailStatusID(0);
        emailStatus.setEmailStatus("emailStatus");
        emailStatus.setEmailStatusDesc("emailStatusDesc");
        emailStatus.setDeleted(false);
        emailStatus.setCreatedBy("createdBy");

        final FeedbackType feedbackType = new FeedbackType(0, "feedbackTypeName");
        final States state = new States();
        state.setStateID(0);
        state.setStateCode("stateCode");
        state.setCountryID(0);
        state.setDeleted(false);
        state.setCreatedBy("createdBy");

        final Districts district = new Districts(0, "DistrictName", 0, "stateName");
        final DistrictBlock districtBlock = new DistrictBlock(0, "BlockName");
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping(0, "VillageName", "PanchayatName",
                "Habitat", "PinCode");
        final InstituteType instituteType = new InstituteType();
        instituteType.setInstitutionTypeID(0);
        instituteType.setInstitutionType("institutionType");
        instituteType.setInstitutionTypeDesc("institutionTypeDesc");
        instituteType.setProviderServiceMapID(0);
        instituteType.setDeleted(false);

        final FeedbackNatureDetail feedbackNatureDetail = new FeedbackNatureDetail();
        feedbackNatureDetail.setFeedbackNatureID(0);
        feedbackNatureDetail.setFeedbackNature("feedbackNature");
        feedbackNatureDetail.setFeedbackNatureDesc("feedbackNatureDesc");
        feedbackNatureDetail.setFeedbackTypeID(0);
        feedbackNatureDetail.setDeleted(false);

        // Run the test
        final FeedbackDetails result = FeedbackDetails.initializeFeedbackDetailsWithAllFeilds(0L, mUser, 0L,
                "instiName", institute, 0, designation, 0, severity, 0, feedbackStatus, 0, mservicemaster, 0, 0,
                emailStatus, "sMSPhoneNo", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "feedback", false, 0, feedbackType, 0,
                state, 0, district, 0, districtBlock, 0, districtBranchMapping, 0, instituteType, 0,
                feedbackNatureDetail, "feedbackAgainst");
        assertThat(result.getFeedbackID()).isEqualTo(0L);
        assertThat(result.getInstitutionID()).isEqualTo(0L);
        assertThat(result.getInstiName()).isEqualTo("instiName");
        assertThat(result.getDesignationID()).isEqualTo(0);
        assertThat(result.getSeverityID()).isEqualTo(0);
        assertThat(result.getFeedbackTypeID()).isEqualTo(0);
        assertThat(result.getFeedbackStatusID()).isEqualTo(0);
        assertThat(result.getFeedback()).isEqualTo("feedback");
        assertThat(result.getBeneficiaryRegID()).isEqualTo(0L);
        assertThat(result.getServiceID()).isEqualTo(0);
        assertThat(result.getUserID()).isEqualTo(0);
        assertThat(result.getsMSPhoneNo()).isEqualTo("sMSPhoneNo");
        assertThat(result.getServiceAvailDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getBenCallID()).isEqualTo(0L);
        assertThat(result.getSubServiceID()).isEqualTo(0);
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getEmailStatusID()).isEqualTo(0);
        assertThat(result.getStartDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getEndDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getDistrictID()).isEqualTo(0);
        assertThat(result.getRandomMessage()).isEqualTo("result");
        assertThat(result.getRequestID()).isEqualTo("requestID");
        assertThat(result.getFeedbackRequests()).isEqualTo(List.of(new FeedbackRequest()));
        assertThat(result.getFeedbackResponses()).isEqualTo(List.of(new FeedbackResponse()));
        assertThat(result.getConsolidatedRequests()).isEqualTo(List.of(new FeedbackRequest()));
        assertThat(result.getInstitute()).isEqualTo(new Institute(0, "institutionName", 0, 0, 0));
        assertThat(result.getInstituteName()).isEqualTo("instituteName");
        assertThat(result.getDesignation()).isEqualTo(new Designation(0, "designationName"));
        assertThat(result.getDesignationName()).isEqualTo("designationName");
        assertThat(result.getSeverity()).isEqualTo(new FeedbackSeverity(0, "severityTypeName"));
        assertThat(result.getSeverityTypeName()).isEqualTo("severityTypeName");
        assertThat(result.getFeedbackType()).isEqualTo(new FeedbackType(0, "feedbackTypeName"));
        assertThat(result.getFeedbackTypeName()).isEqualTo("feedbackTypeName");
        assertThat(result.getBeneficiary()).isEqualTo(new Beneficiary());
        assertThat(result.getBeneficiaryName()).isEqualTo("beneficiaryName");
        assertThat(result.getMservicemaster()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getServiceName()).isEqualTo("serviceName");
        assertThat(result.getMUser()).isEqualTo(new User());
        assertThat(result.getUserName()).isEqualTo("userName");
        assertThat(result.getFeedbackStatus()).isEqualTo(new FeedbackStatus(0, "feedbackStatus", "feedbackStatusDesc"));
        assertThat(result.getFeedbackStatusName()).isEqualTo("feedbackStatusName");
        assertThat(result.getEmailStatus()).isEqualTo(new EmailStatus());
        assertThat(result.getEmailStatusName()).isEqualTo("emailStatusName");
        assertThat(result.getStateID()).isEqualTo(0);
        assertThat(result.getState()).isEqualTo(new States());
        assertThat(result.getDistrict()).isEqualTo(new Districts(0, "DistrictName", 0, "stateName"));
        assertThat(result.getBlockID()).isEqualTo(0);
        assertThat(result.getDistrictBlock()).isEqualTo(new DistrictBlock(0, "BlockName"));
        assertThat(result.getDistrictBranchID()).isEqualTo(0);
        assertThat(result.getDistrictBranchMapping())
                .isEqualTo(new DistrictBranchMapping(0, "VillageName", "PanchayatName", "Habitat", "PinCode"));
        assertThat(result.getInstituteTypeID()).isEqualTo(0);
        assertThat(result.getInstituteType()).isEqualTo(new InstituteType());
        assertThat(result.getFeedbackNatureID()).isEqualTo(0);
        assertThat(result.getFeedbackNatureDetail()).isEqualTo(new FeedbackNatureDetail());
        assertThat(result.getCategoryID()).isEqualTo(0);
        assertThat(result.getSubCategoryID()).isEqualTo(0);
        assertThat(result.getFeedbackAgainst()).isEqualTo("feedbackAgainst");
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testFeedbackRequestsGetterAndSetter() {
        final List<FeedbackRequest> feedbackRequests = List.of(new FeedbackRequest());
        feedbackDetailsUnderTest.setFeedbackRequests(feedbackRequests);
        assertThat(feedbackDetailsUnderTest.getFeedbackRequests()).isEqualTo(feedbackRequests);
    }

    @Test
    void testFeedbackResponsesGetterAndSetter() {
        final List<FeedbackResponse> feedbackResponses = List.of(new FeedbackResponse());
        feedbackDetailsUnderTest.setFeedbackResponses(feedbackResponses);
        assertThat(feedbackDetailsUnderTest.getFeedbackResponses()).isEqualTo(feedbackResponses);
    }

    @Test
    void testStartDateGetterAndSetter() {
        final Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackDetailsUnderTest.setStartDate(startDate);
        assertThat(feedbackDetailsUnderTest.getStartDate()).isEqualTo(startDate);
    }

    @Test
    void testEndDateGetterAndSetter() {
        final Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackDetailsUnderTest.setEndDate(endDate);
        assertThat(feedbackDetailsUnderTest.getEndDate()).isEqualTo(endDate);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        feedbackDetailsUnderTest.setDistrictID(districtID);
        assertThat(feedbackDetailsUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testSetConsolidatedRequests1() {
        // Setup
        final FeedbackRequest feedbackRequest = new FeedbackRequest();
        feedbackRequest.setDeleted(false);
        feedbackRequest.setFeedbackRequestID(0L);
        feedbackRequest.setFeedbackID(0L);
        final FeedbackDetails feedbackDetails = new FeedbackDetails();
        feedbackRequest.setFeedbackDetails(feedbackDetails);
        feedbackRequest.setResponseUpdatedBy("responseUpdatedBy");
        final List<FeedbackRequest> feedbackRequests = List.of(feedbackRequest);
        final FeedbackResponse feedbackResponse = new FeedbackResponse();
        final KMFileManager kmFileManager = new KMFileManager();
        feedbackResponse.setKmFileManager(kmFileManager);
        feedbackResponse.setAttachmentPath("attachmentPath");
        feedbackResponse.setFeedbackRequestID(0L);
        feedbackResponse.setResponseSummary("responseSummary");
        feedbackResponse.setComments("comments");
        feedbackResponse.setCreatedBy("createdBy");
        feedbackResponse.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        final List<FeedbackResponse> feedbackResponses = List.of(feedbackResponse);

        // Run the test
        feedbackDetailsUnderTest.setConsolidatedRequests(feedbackRequests, feedbackResponses);

        // Verify the results
    }

    @Test
    void testGetRandomMessage() {
        assertThat(feedbackDetailsUnderTest.getRandomMessage()).isNull();
    }

    @Test
    void testConsolidatedRequestsGetterAndSetter() {
        final List<FeedbackRequest> consolidatedRequests = List.of(new FeedbackRequest());
        feedbackDetailsUnderTest.setConsolidatedRequests(consolidatedRequests);
        assertThat(feedbackDetailsUnderTest.getConsolidatedRequests()).isEqualTo(consolidatedRequests);
    }

    @Test
    void testInstituteGetterAndSetter() {
        final Institute institute = new Institute(0, "institutionName", 0, 0, 0);
        feedbackDetailsUnderTest.setInstitute(institute);
        assertThat(feedbackDetailsUnderTest.getInstitute()).isEqualTo(institute);
    }

    @Test
    void testInstituteNameGetterAndSetter() {
        final String instituteName = "instituteName";
        feedbackDetailsUnderTest.setInstituteName(instituteName);
        assertThat(feedbackDetailsUnderTest.getInstituteName()).isEqualTo(instituteName);
    }

    @Test
    void testDesignationGetterAndSetter() {
        final Designation designation = new Designation(0, "designationName");
        feedbackDetailsUnderTest.setDesignation(designation);
        assertThat(feedbackDetailsUnderTest.getDesignation()).isEqualTo(designation);
    }

    @Test
    void testDesignationNameGetterAndSetter() {
        final String designationName = "designationName";
        feedbackDetailsUnderTest.setDesignationName(designationName);
        assertThat(feedbackDetailsUnderTest.getDesignationName()).isEqualTo(designationName);
    }

    @Test
    void testSeverityGetterAndSetter() {
        final FeedbackSeverity severity = new FeedbackSeverity(0, "severityTypeName");
        feedbackDetailsUnderTest.setSeverity(severity);
        assertThat(feedbackDetailsUnderTest.getSeverity()).isEqualTo(severity);
    }

    @Test
    void testSeverityTypeNameGetterAndSetter() {
        final String severityTypeName = "severityTypeName";
        feedbackDetailsUnderTest.setSeverityTypeName(severityTypeName);
        assertThat(feedbackDetailsUnderTest.getSeverityTypeName()).isEqualTo(severityTypeName);
    }

    @Test
    void testFeedbackTypeGetterAndSetter() {
        final FeedbackType feedbackType = new FeedbackType(0, "feedbackTypeName");
        feedbackDetailsUnderTest.setFeedbackType(feedbackType);
        assertThat(feedbackDetailsUnderTest.getFeedbackType()).isEqualTo(feedbackType);
    }

    @Test
    void testFeedbackTypeNameGetterAndSetter() {
        final String feedbackTypeName = "feedbackTypeName";
        feedbackDetailsUnderTest.setFeedbackTypeName(feedbackTypeName);
        assertThat(feedbackDetailsUnderTest.getFeedbackTypeName()).isEqualTo(feedbackTypeName);
    }

    @Test
    void testBeneficiaryGetterAndSetter() {
        final Beneficiary beneficiary = new Beneficiary();
        feedbackDetailsUnderTest.setBeneficiary(beneficiary);
        assertThat(feedbackDetailsUnderTest.getBeneficiary()).isEqualTo(beneficiary);
    }

    @Test
    void testBeneficiaryNameGetterAndSetter() {
        final String beneficiaryName = "beneficiaryName";
        feedbackDetailsUnderTest.setBeneficiaryName(beneficiaryName);
        assertThat(feedbackDetailsUnderTest.getBeneficiaryName()).isEqualTo(beneficiaryName);
    }

    @Test
    void testMservicemasterGetterAndSetter() {
        final ProviderServiceMapping mservicemaster = new ProviderServiceMapping(false, 0);
        feedbackDetailsUnderTest.setMservicemaster(mservicemaster);
        assertThat(feedbackDetailsUnderTest.getMservicemaster()).isEqualTo(mservicemaster);
    }

    @Test
    void testServiceNameGetterAndSetter() {
        final String serviceName = "serviceName";
        feedbackDetailsUnderTest.setServiceName(serviceName);
        assertThat(feedbackDetailsUnderTest.getServiceName()).isEqualTo(serviceName);
    }

    @Test
    void testUserGetterAndSetter() {
        final User user = new User();
        feedbackDetailsUnderTest.setMUser(user);
        assertThat(feedbackDetailsUnderTest.getMUser()).isEqualTo(user);
    }

    @Test
    void testUserNameGetterAndSetter() {
        final String userName = "userName";
        feedbackDetailsUnderTest.setUserName(userName);
        assertThat(feedbackDetailsUnderTest.getUserName()).isEqualTo(userName);
    }

    @Test
    void testFeedbackStatusGetterAndSetter() {
        final FeedbackStatus feedbackStatus = new FeedbackStatus(0, "feedbackStatus", "feedbackStatusDesc");
        feedbackDetailsUnderTest.setFeedbackStatus(feedbackStatus);
        assertThat(feedbackDetailsUnderTest.getFeedbackStatus()).isEqualTo(feedbackStatus);
    }

    @Test
    void testFeedbackStatusNameGetterAndSetter() {
        final String feedbackStatusName = "feedbackStatusName";
        feedbackDetailsUnderTest.setFeedbackStatusName(feedbackStatusName);
        assertThat(feedbackDetailsUnderTest.getFeedbackStatusName()).isEqualTo(feedbackStatusName);
    }

    @Test
    void testEmailStatusGetterAndSetter() {
        final EmailStatus emailStatus = new EmailStatus();
        feedbackDetailsUnderTest.setEmailStatus(emailStatus);
        assertThat(feedbackDetailsUnderTest.getEmailStatus()).isEqualTo(emailStatus);
    }

    @Test
    void testEmailStatusNameGetterAndSetter() {
        final String emailStatusName = "emailStatusName";
        feedbackDetailsUnderTest.setEmailStatusName(emailStatusName);
        assertThat(feedbackDetailsUnderTest.getEmailStatusName()).isEqualTo(emailStatusName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        feedbackDetailsUnderTest.setStateID(stateID);
        assertThat(feedbackDetailsUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testStateGetterAndSetter() {
        final States state = new States();
        feedbackDetailsUnderTest.setState(state);
        assertThat(feedbackDetailsUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final Districts district = new Districts(0, "DistrictName", 0, "stateName");
        feedbackDetailsUnderTest.setDistrict(district);
        assertThat(feedbackDetailsUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testBlockIDGetterAndSetter() {
        final Integer blockID = 0;
        feedbackDetailsUnderTest.setBlockID(blockID);
        assertThat(feedbackDetailsUnderTest.getBlockID()).isEqualTo(blockID);
    }

    @Test
    void testDistrictBlockGetterAndSetter() {
        final DistrictBlock districtBlock = new DistrictBlock(0, "BlockName");
        feedbackDetailsUnderTest.setDistrictBlock(districtBlock);
        assertThat(feedbackDetailsUnderTest.getDistrictBlock()).isEqualTo(districtBlock);
    }

    @Test
    void testDistrictBranchIDGetterAndSetter() {
        final Integer districtBranchID = 0;
        feedbackDetailsUnderTest.setDistrictBranchID(districtBranchID);
        assertThat(feedbackDetailsUnderTest.getDistrictBranchID()).isEqualTo(districtBranchID);
    }

    @Test
    void testDistrictBranchMappingGetterAndSetter() {
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping(0, "VillageName", "PanchayatName",
                "Habitat", "PinCode");
        feedbackDetailsUnderTest.setDistrictBranchMapping(districtBranchMapping);
        assertThat(feedbackDetailsUnderTest.getDistrictBranchMapping()).isEqualTo(districtBranchMapping);
    }

    @Test
    void testInstituteTypeIDGetterAndSetter() {
        final Integer instituteTypeID = 0;
        feedbackDetailsUnderTest.setInstituteTypeID(instituteTypeID);
        assertThat(feedbackDetailsUnderTest.getInstituteTypeID()).isEqualTo(instituteTypeID);
    }

    @Test
    void testInstituteTypeGetterAndSetter() {
        final InstituteType instituteType = new InstituteType();
        feedbackDetailsUnderTest.setInstituteType(instituteType);
        assertThat(feedbackDetailsUnderTest.getInstituteType()).isEqualTo(instituteType);
    }

    @Test
    void testFeedbackNatureIDGetterAndSetter() {
        final Integer feedbackNatureID = 0;
        feedbackDetailsUnderTest.setFeedbackNatureID(feedbackNatureID);
        assertThat(feedbackDetailsUnderTest.getFeedbackNatureID()).isEqualTo(feedbackNatureID);
    }

    @Test
    void testFeedbackNatureDetailGetterAndSetter() {
        final FeedbackNatureDetail feedbackNatureDetail = new FeedbackNatureDetail();
        feedbackDetailsUnderTest.setFeedbackNatureDetail(feedbackNatureDetail);
        assertThat(feedbackDetailsUnderTest.getFeedbackNatureDetail()).isEqualTo(feedbackNatureDetail);
    }

    @Test
    void testCategoryIDGetterAndSetter() {
        final Integer categoryID = 0;
        feedbackDetailsUnderTest.setCategoryID(categoryID);
        assertThat(feedbackDetailsUnderTest.getCategoryID()).isEqualTo(categoryID);
    }

    @Test
    void testSubCategoryIDGetterAndSetter() {
        final Integer subCategoryID = 0;
        feedbackDetailsUnderTest.setSubCategoryID(subCategoryID);
        assertThat(feedbackDetailsUnderTest.getSubCategoryID()).isEqualTo(subCategoryID);
    }

    @Test
    void testFeedbackAgainstGetterAndSetter() {
        final String feedbackAgainst = "feedbackAgainst";
        feedbackDetailsUnderTest.setFeedbackAgainst(feedbackAgainst);
        assertThat(feedbackDetailsUnderTest.getFeedbackAgainst()).isEqualTo(feedbackAgainst);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackDetailsUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackDetailsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(feedbackDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackDetailsUnderTest.hashCode()).isEqualTo(0);
    }
}
