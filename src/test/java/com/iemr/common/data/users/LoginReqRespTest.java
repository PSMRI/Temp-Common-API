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
class LoginReqRespTest {

	@InjectMocks
    private LoginReqResp loginReqRespUnderTest;

    @BeforeEach
    void setUp() {
        loginReqRespUnderTest = new LoginReqResp();
    }

    @Test
    void testToString() {
        assertThat(loginReqRespUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testUserNameGetterAndSetter() {
        final String userName = "userName";
        loginReqRespUnderTest.setUserName(userName);
        assertThat(loginReqRespUnderTest.getUserName()).isEqualTo(userName);
    }

    @Test
    void testPasswordGetterAndSetter() {
        final String password = "password";
        loginReqRespUnderTest.setPassword(password);
        assertThat(loginReqRespUnderTest.getPassword()).isEqualTo(password);
    }

    @Test
    void testHostNameGetterAndSetter() {
        final String hostName = "hostName";
        loginReqRespUnderTest.setHostName(hostName);
        assertThat(loginReqRespUnderTest.getHostName()).isEqualTo(hostName);
    }

    @Test
    void testIpAddressGetterAndSetter() {
        final String ipAddress = "ipAddress";
        loginReqRespUnderTest.setIpAddress(ipAddress);
        assertThat(loginReqRespUnderTest.getIpAddress()).isEqualTo(ipAddress);
    }

    @Test
    void testLoginKeyGetterAndSetter() {
        final String loginKey = "loginKey";
        loginReqRespUnderTest.setLoginKey(loginKey);
        assertThat(loginReqRespUnderTest.getLoginKey()).isEqualTo(loginKey);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        loginReqRespUnderTest.setUserID(userID);
        assertThat(loginReqRespUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testM_UserServiceRoleMappingGetterAndSetter() {
        final List<UserServiceRoleMapping> m_UserServiceRoleMapping = List.of(new UserServiceRoleMapping());
        loginReqRespUnderTest.setM_UserServiceRoleMapping(m_UserServiceRoleMapping);
        assertThat(loginReqRespUnderTest.getM_UserServiceRoleMapping()).isEqualTo(m_UserServiceRoleMapping);
    }

    @Test
    void testOutboundCallRequestsGetterAndSetter() {
        final Set<OutboundCallRequest> outboundCallRequests = Set.of(new OutboundCallRequest());
        loginReqRespUnderTest.setOutboundCallRequests(outboundCallRequests);
        assertThat(loginReqRespUnderTest.getOutboundCallRequests()).isEqualTo(outboundCallRequests);
    }

    @Test
    void testM_UserLangMappingsGetterAndSetter() {
        final Set<UserLangMapping> m_UserLangMappings = Set.of(new UserLangMapping());
        loginReqRespUnderTest.setM_UserLangMappings(m_UserLangMappings);
        assertThat(loginReqRespUnderTest.getM_UserLangMappings()).isEqualTo(m_UserLangMappings);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        loginReqRespUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(loginReqRespUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testTitleIDGetterAndSetter() {
        final Integer titleID = 0;
        loginReqRespUnderTest.setTitleID(titleID);
        assertThat(loginReqRespUnderTest.getTitleID()).isEqualTo(titleID);
    }

    @Test
    void testM_titleGetterAndSetter() {
        final Title m_title = new Title();
        loginReqRespUnderTest.setM_title(m_title);
        assertThat(loginReqRespUnderTest.getM_title()).isEqualTo(m_title);
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "firstName";
        loginReqRespUnderTest.setFirstName(firstName);
        assertThat(loginReqRespUnderTest.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testMiddleNameGetterAndSetter() {
        final String middleName = "middleName";
        loginReqRespUnderTest.setMiddleName(middleName);
        assertThat(loginReqRespUnderTest.getMiddleName()).isEqualTo(middleName);
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "lastName";
        loginReqRespUnderTest.setLastName(lastName);
        assertThat(loginReqRespUnderTest.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testGenderIDGetterAndSetter() {
        final Integer genderID = 0;
        loginReqRespUnderTest.setGenderID(genderID);
        assertThat(loginReqRespUnderTest.getGenderID()).isEqualTo(genderID);
    }

    @Test
    void testM_genderGetterAndSetter() {
        final Gender m_gender = new Gender();
        loginReqRespUnderTest.setM_gender(m_gender);
        assertThat(loginReqRespUnderTest.getM_gender()).isEqualTo(m_gender);
    }

    @Test
    void testMaritalStatusIDGetterAndSetter() {
        final Integer maritalStatusID = 0;
        loginReqRespUnderTest.setMaritalStatusID(maritalStatusID);
        assertThat(loginReqRespUnderTest.getMaritalStatusID()).isEqualTo(maritalStatusID);
    }

    @Test
    void testM_maritalstatusGetterAndSetter() {
        final MaritalStatus m_maritalstatus = new MaritalStatus();
        loginReqRespUnderTest.setM_maritalstatus(m_maritalstatus);
        assertThat(loginReqRespUnderTest.getM_maritalstatus()).isEqualTo(m_maritalstatus);
    }

    @Test
    void testStatusIDGetterAndSetter() {
        final Integer statusID = 0;
        loginReqRespUnderTest.setStatusID(statusID);
        assertThat(loginReqRespUnderTest.getStatusID()).isEqualTo(statusID);
    }

    @Test
    void testM_statusGetterAndSetter() {
        final Status m_status = new Status();
        loginReqRespUnderTest.setM_status(m_status);
        assertThat(loginReqRespUnderTest.getM_status()).isEqualTo(m_status);
    }

    @Test
    void testAadhaarNoGetterAndSetter() {
        final String aadhaarNo = "aadhaarNo";
        loginReqRespUnderTest.setAadhaarNo(aadhaarNo);
        assertThat(loginReqRespUnderTest.getAadhaarNo()).isEqualTo(aadhaarNo);
    }

    @Test
    void testPANGetterAndSetter() {
        final String pAN = "pAN";
        loginReqRespUnderTest.setPAN(pAN);
        assertThat(loginReqRespUnderTest.getPAN()).isEqualTo(pAN);
    }

    @Test
    void testDOBGetterAndSetter() {
        final Timestamp dOB = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        loginReqRespUnderTest.setDOB(dOB);
        assertThat(loginReqRespUnderTest.getDOB()).isEqualTo(dOB);
    }

    @Test
    void testDOJGetterAndSetter() {
        final Timestamp dOJ = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        loginReqRespUnderTest.setDOJ(dOJ);
        assertThat(loginReqRespUnderTest.getDOJ()).isEqualTo(dOJ);
    }

    @Test
    void testQualificationIDGetterAndSetter() {
        final Integer qualificationID = 0;
        loginReqRespUnderTest.setQualificationID(qualificationID);
        assertThat(loginReqRespUnderTest.getQualificationID()).isEqualTo(qualificationID);
    }

    @Test
    void testEmailIDGetterAndSetter() {
        final String emailID = "emailID";
        loginReqRespUnderTest.setEmailID(emailID);
        assertThat(loginReqRespUnderTest.getEmailID()).isEqualTo(emailID);
    }

    @Test
    void testEmergencyContactPersonGetterAndSetter() {
        final String emergencyContactPerson = "emergencyContactPerson";
        loginReqRespUnderTest.setEmergencyContactPerson(emergencyContactPerson);
        assertThat(loginReqRespUnderTest.getEmergencyContactPerson()).isEqualTo(emergencyContactPerson);
    }

    @Test
    void testEmergencyContactNoGetterAndSetter() {
        final String emergencyContactNo = "emergencyContactNo";
        loginReqRespUnderTest.setEmergencyContactNo(emergencyContactNo);
        assertThat(loginReqRespUnderTest.getEmergencyContactNo()).isEqualTo(emergencyContactNo);
    }

    @Test
    void testIsSupervisorGetterAndSetter() {
        final Boolean isSupervisor = false;
        loginReqRespUnderTest.setIsSupervisor(isSupervisor);
        assertThat(loginReqRespUnderTest.getIsSupervisor()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        loginReqRespUnderTest.setDeleted(deleted);
        assertThat(loginReqRespUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        loginReqRespUnderTest.setCreatedBy(createdBy);
        assertThat(loginReqRespUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        loginReqRespUnderTest.setCreatedDate(createdDate);
        assertThat(loginReqRespUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        loginReqRespUnderTest.setModifiedBy(modifiedBy);
        assertThat(loginReqRespUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        loginReqRespUnderTest.setLastModDate(lastModDate);
        assertThat(loginReqRespUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        loginReqRespUnderTest.setAgentID(agentID);
        assertThat(loginReqRespUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testDesignationIDGetterAndSetter() {
        final Integer designationID = 0;
        loginReqRespUnderTest.setDesignationID(designationID);
        assertThat(loginReqRespUnderTest.getDesignationID()).isEqualTo(designationID);
    }

    @Test
    void testDesignationGetterAndSetter() {
        final Designation designation = new Designation(0, "designationName");
        loginReqRespUnderTest.setDesignation(designation);
        assertThat(loginReqRespUnderTest.getDesignation()).isEqualTo(designation);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        loginReqRespUnderTest.setOutputMapper(outputMapper);
        assertThat(loginReqRespUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testAgentPasswordGetterAndSetter() {
        final String agentPassword = "agentPassword";
        loginReqRespUnderTest.setAgentPassword(agentPassword);
        assertThat(loginReqRespUnderTest.getAgentPassword()).isEqualTo(agentPassword);
    }

    @Test
    void testEquals() {
        assertThat(loginReqRespUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(loginReqRespUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(loginReqRespUnderTest.hashCode()).isEqualTo(0);
    }
}
