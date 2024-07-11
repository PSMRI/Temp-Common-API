package com.iemr.common.data.users;

import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserTest {

	@InjectMocks
    private User userUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userUnderTest = new User();
    }

    @Test
    void testInitializeUsers() {
        // Setup
        final Status m_Status = new Status();
        m_Status.setStatusID(0);
        m_Status.setStatus("status");
        m_Status.setStatusDesc("statusDesc");
        m_Status.setDeleted(false);
        m_Status.setCreatedBy("createdBy");

        final UserServiceRoleMapping userServiceRoleMapping = new UserServiceRoleMapping();
        userServiceRoleMapping.setUSRMappingID(0L);
        userServiceRoleMapping.setDeleted(false);
        userServiceRoleMapping.setCreatedBy("createdBy");
        userServiceRoleMapping.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        userServiceRoleMapping.setModifiedBy("modifiedBy");
        final List<UserServiceRoleMapping> m_UserServiceRoleMapping = List.of(userServiceRoleMapping);

        // Run the test
        final User result = User.initializeUsers(0L, 0, "firstName", "middleName", "lastName", 0, 0, "aadhaarNo", "pAN",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0, "userName", "password", "emailID",
                m_Status, m_UserServiceRoleMapping, "emergencyContactPerson", "emergencyContactNo", false, false,
                "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "newPassword");
        assertThat(result.getUserID()).isEqualTo(0L);
        assertThat(result.getTitleID()).isEqualTo(0);
        assertThat(result.getFirstName()).isEqualTo("firstName");
        assertThat(result.getMiddleName()).isEqualTo("middleName");
        assertThat(result.getLastName()).isEqualTo("lastName");
        assertThat(result.getGenderID()).isEqualTo(0);
        assertThat(result.getMaritalStatusID()).isEqualTo(0);
        assertThat(result.getStatusID()).isEqualTo(0);
        assertThat(result.getAadhaarNo()).isEqualTo("aadhaarNo");
        assertThat(result.getpAN()).isEqualTo("pAN");
        assertThat(result.getdOB()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getdOJ()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getQualificationID()).isEqualTo(0);
        assertThat(result.getUserName()).isEqualTo("userName");
        assertThat(result.getPassword()).isEqualTo("password");
        assertThat(result.getEmailID()).isEqualTo("emailID");
        assertThat(result.getEmergencyContactPerson()).isEqualTo("emergencyContactPerson");
        assertThat(result.getEmergencyContactNo()).isEqualTo("emergencyContactNo");
        assertThat(result.getIsSupervisor()).isFalse();
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getNewPassword()).isEqualTo("newPassword");
        assertThat(result.getOutPutMapper()).isEqualTo(new OutputMapper());
        assertThat(result.getAgentID()).isEqualTo("agentID");
        assertThat(result.getAgentPassword()).isEqualTo("agentPassword");
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getDesignationID()).isEqualTo(0);
        assertThat(result.getDesignation()).isEqualTo(new Designation(0, "designationName"));
        assertThat(result.getM_UserServiceRoleMapping()).isEqualTo(List.of(new UserServiceRoleMapping()));
        assertThat(result.getOutboundCallRequests()).isEqualTo(Set.of(new OutboundCallRequest()));
        assertThat(result.getRoleMappings()).isEqualTo(Set.of(new UserServiceRoleMapping()));
        assertThat(result.getM_UserLangMappings()).isEqualTo(Set.of(new UserLangMapping()));
        assertThat(result.getFeedbackDetails()).isEqualTo(Set.of(new FeedbackDetails()));
        assertThat(result.getM_title()).isEqualTo(new Title());
        assertThat(result.getM_gender()).isEqualTo(new Gender());
        assertThat(result.getM_maritalstatus()).isEqualTo(new MaritalStatus());
        assertThat(result.getM_status()).isEqualTo(new Status());
        assertThat(result.getFailedAttempt()).isEqualTo(0);
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        userUnderTest.setUserID(userID);
        assertThat(userUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testTitleIDGetterAndSetter() {
        final Integer titleID = 0;
        userUnderTest.setTitleID(titleID);
        assertThat(userUnderTest.getTitleID()).isEqualTo(titleID);
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "firstName";
        userUnderTest.setFirstName(firstName);
        assertThat(userUnderTest.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testMiddleNameGetterAndSetter() {
        final String middleName = "middleName";
        userUnderTest.setMiddleName(middleName);
        assertThat(userUnderTest.getMiddleName()).isEqualTo(middleName);
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "lastName";
        userUnderTest.setLastName(lastName);
        assertThat(userUnderTest.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testGenderIDGetterAndSetter() {
        final Integer genderID = 0;
        userUnderTest.setGenderID(genderID);
        assertThat(userUnderTest.getGenderID()).isEqualTo(genderID);
    }

    @Test
    void testMaritalStatusIDGetterAndSetter() {
        final Integer maritalStatusID = 0;
        userUnderTest.setMaritalStatusID(maritalStatusID);
        assertThat(userUnderTest.getMaritalStatusID()).isEqualTo(maritalStatusID);
    }

    @Test
    void testStatusIDGetterAndSetter() {
        final Integer statusID = 0;
        userUnderTest.setStatusID(statusID);
        assertThat(userUnderTest.getStatusID()).isEqualTo(statusID);
    }

    @Test
    void testAadhaarNoGetterAndSetter() {
        final String aadhaarNo = "aadhaarNo";
        userUnderTest.setAadhaarNo(aadhaarNo);
        assertThat(userUnderTest.getAadhaarNo()).isEqualTo(aadhaarNo);
    }

    @Test
    void testPANGetterAndSetter() {
        final String pAN = "pAN";
        userUnderTest.setpAN(pAN);
        assertThat(userUnderTest.getpAN()).isEqualTo(pAN);
    }

    @Test
    void testDOBGetterAndSetter() {
        final Timestamp dOB = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userUnderTest.setdOB(dOB);
        assertThat(userUnderTest.getdOB()).isEqualTo(dOB);
    }

    @Test
    void testDOJGetterAndSetter() {
        final Timestamp dOJ = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userUnderTest.setdOJ(dOJ);
        assertThat(userUnderTest.getdOJ()).isEqualTo(dOJ);
    }

    @Test
    void testQualificationIDGetterAndSetter() {
        final Integer qualificationID = 0;
        userUnderTest.setQualificationID(qualificationID);
        assertThat(userUnderTest.getQualificationID()).isEqualTo(qualificationID);
    }

    @Test
    void testUserNameGetterAndSetter() {
        final String userName = "userName";
        userUnderTest.setUserName(userName);
        assertThat(userUnderTest.getUserName()).isEqualTo(userName);
    }

    @Test
    void testPasswordGetterAndSetter() {
        final String password = "password";
        userUnderTest.setPassword(password);
        assertThat(userUnderTest.getPassword()).isEqualTo(password);
    }

    @Test
    void testEmailIDGetterAndSetter() {
        final String emailID = "emailID";
        userUnderTest.setEmailID(emailID);
        assertThat(userUnderTest.getEmailID()).isEqualTo(emailID);
    }

    @Test
    void testEmergencyContactPersonGetterAndSetter() {
        final String emergencyContactPerson = "emergencyContactPerson";
        userUnderTest.setEmergencyContactPerson(emergencyContactPerson);
        assertThat(userUnderTest.getEmergencyContactPerson()).isEqualTo(emergencyContactPerson);
    }

    @Test
    void testEmergencyContactNoGetterAndSetter() {
        final String emergencyContactNo = "emergencyContactNo";
        userUnderTest.setEmergencyContactNo(emergencyContactNo);
        assertThat(userUnderTest.getEmergencyContactNo()).isEqualTo(emergencyContactNo);
    }

    @Test
    void testIsSupervisorGetterAndSetter() {
        final Boolean isSupervisor = false;
        userUnderTest.setIsSupervisor(isSupervisor);
        assertThat(userUnderTest.getIsSupervisor()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        userUnderTest.setDeleted(deleted);
        assertThat(userUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        userUnderTest.setCreatedBy(createdBy);
        assertThat(userUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userUnderTest.setCreatedDate(createdDate);
        assertThat(userUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        userUnderTest.setModifiedBy(modifiedBy);
        assertThat(userUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userUnderTest.setLastModDate(lastModDate);
        assertThat(userUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testNewPasswordGetterAndSetter() {
        final String newPassword = "newPassword";
        userUnderTest.setNewPassword(newPassword);
        assertThat(userUnderTest.getNewPassword()).isEqualTo(newPassword);
    }

    @Test
    void testOutPutMapperGetterAndSetter() {
        final OutputMapper outPutMapper = new OutputMapper();
        userUnderTest.setOutPutMapper(outPutMapper);
        assertThat(userUnderTest.getOutPutMapper()).isEqualTo(outPutMapper);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        userUnderTest.setAgentID(agentID);
        assertThat(userUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testAgentPasswordGetterAndSetter() {
        final String agentPassword = "agentPassword";
        userUnderTest.setAgentPassword(agentPassword);
        assertThat(userUnderTest.getAgentPassword()).isEqualTo(agentPassword);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testDesignationIDGetterAndSetter() {
        final Integer designationID = 0;
        userUnderTest.setDesignationID(designationID);
        assertThat(userUnderTest.getDesignationID()).isEqualTo(designationID);
    }

    @Test
    void testDesignationGetterAndSetter() {
        final Designation designation = new Designation(0, "designationName");
        userUnderTest.setDesignation(designation);
        assertThat(userUnderTest.getDesignation()).isEqualTo(designation);
    }

    @Test
    void testM_UserServiceRoleMappingGetterAndSetter() {
        final List<UserServiceRoleMapping> m_UserServiceRoleMapping = List.of(new UserServiceRoleMapping());
        userUnderTest.setM_UserServiceRoleMapping(m_UserServiceRoleMapping);
        assertThat(userUnderTest.getM_UserServiceRoleMapping()).isEqualTo(m_UserServiceRoleMapping);
    }

    @Test
    void testOutboundCallRequestsGetterAndSetter() {
        final Set<OutboundCallRequest> outboundCallRequests = Set.of(new OutboundCallRequest());
        userUnderTest.setOutboundCallRequests(outboundCallRequests);
        assertThat(userUnderTest.getOutboundCallRequests()).isEqualTo(outboundCallRequests);
    }

    @Test
    void testRoleMappingsGetterAndSetter() {
        final Set<UserServiceRoleMapping> roleMappings = Set.of(new UserServiceRoleMapping());
        userUnderTest.setRoleMappings(roleMappings);
        assertThat(userUnderTest.getRoleMappings()).isEqualTo(roleMappings);
    }

    @Test
    void testM_UserLangMappingsGetterAndSetter() {
        final Set<UserLangMapping> m_UserLangMappings = Set.of(new UserLangMapping());
        userUnderTest.setM_UserLangMappings(m_UserLangMappings);
        assertThat(userUnderTest.getM_UserLangMappings()).isEqualTo(m_UserLangMappings);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        userUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(userUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testM_titleGetterAndSetter() {
        final Title m_title = new Title();
        userUnderTest.setM_title(m_title);
        assertThat(userUnderTest.getM_title()).isEqualTo(m_title);
    }

    @Test
    void testM_genderGetterAndSetter() {
        final Gender m_gender = new Gender();
        userUnderTest.setM_gender(m_gender);
        assertThat(userUnderTest.getM_gender()).isEqualTo(m_gender);
    }

    @Test
    void testM_maritalstatusGetterAndSetter() {
        final MaritalStatus m_maritalstatus = new MaritalStatus();
        userUnderTest.setM_maritalstatus(m_maritalstatus);
        assertThat(userUnderTest.getM_maritalstatus()).isEqualTo(m_maritalstatus);
    }

    @Test
    void testM_statusGetterAndSetter() {
        final Status m_status = new Status();
        userUnderTest.setM_status(m_status);
        assertThat(userUnderTest.getM_status()).isEqualTo(m_status);
    }

    @Test
    void testFailedAttemptGetterAndSetter() {
        final Integer failedAttempt = 0;
        userUnderTest.setFailedAttempt(failedAttempt);
        assertThat(userUnderTest.getFailedAttempt()).isEqualTo(failedAttempt);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userUnderTest.hashCode()).isEqualTo(0);
    }
}
