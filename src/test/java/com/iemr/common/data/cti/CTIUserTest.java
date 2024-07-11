package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CTIUserTest {

    private CTIUser ctiUserUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        ctiUserUnderTest = new CTIUser();
    }

    @Test
    void testUsernameGetterAndSetter() {
        final String username = "username";
        ctiUserUnderTest.setUsername(username);
        assertThat(ctiUserUnderTest.getUsername()).isEqualTo(username);
    }

    @Test
    void testPasswordGetterAndSetter() {
        final String password = "password";
        ctiUserUnderTest.setPassword(password);
        assertThat(ctiUserUnderTest.getPassword()).isEqualTo(password);
    }

    @Test
    void testFirstnameGetterAndSetter() {
        final String firstname = "firstname";
        ctiUserUnderTest.setFirstname(firstname);
        assertThat(ctiUserUnderTest.getFirstname()).isEqualTo(firstname);
    }

    @Test
    void testLastnameGetterAndSetter() {
        final String lastname = "lastname";
        ctiUserUnderTest.setLastname(lastname);
        assertThat(ctiUserUnderTest.getLastname()).isEqualTo(lastname);
    }

    @Test
    void testPhoneGetterAndSetter() {
        final String phone = "phone";
        ctiUserUnderTest.setPhone(phone);
        assertThat(ctiUserUnderTest.getPhone()).isEqualTo(phone);
    }

    @Test
    void testEmailGetterAndSetter() {
        final String email = "email";
        ctiUserUnderTest.setEmail(email);
        assertThat(ctiUserUnderTest.getEmail()).isEqualTo(email);
    }

    @Test
    void testRoleGetterAndSetter() {
        final String role = "role";
        ctiUserUnderTest.setRole(role);
        assertThat(ctiUserUnderTest.getRole()).isEqualTo(role);
    }

    @Test
    void testDesignationGetterAndSetter() {
        final String designation = "designation";
        ctiUserUnderTest.setDesignation(designation);
        assertThat(ctiUserUnderTest.getDesignation()).isEqualTo(designation);
    }

    @Test
    void testToString() throws Exception {
        assertThat(ctiUserUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() throws Exception {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setUser_name("user_name");
        assertThat(ctiUserUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() throws Exception {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        response.setUser_name("user_name");

        // Run the test
        ctiUserUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testGetLogger() {
        assertThat(ctiUserUnderTest.getLogger()).isEqualTo(ctiUserUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        ctiUserUnderTest.setOutputMapper(outputMapper);
        assertThat(ctiUserUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        ctiUserUnderTest.setTransaction_id(transaction_id);
        assertThat(ctiUserUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testUser_nameGetterAndSetter() {
        final String user_name = "user_name";
        ctiUserUnderTest.setUser_name(user_name);
        assertThat(ctiUserUnderTest.getUser_name()).isEqualTo(user_name);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        ctiUserUnderTest.setReason(reason);
        assertThat(ctiUserUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        ctiUserUnderTest.setResponse_code(response_code);
        assertThat(ctiUserUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        ctiUserUnderTest.setStatus(status);
        assertThat(ctiUserUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(ctiUserUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(ctiUserUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(ctiUserUnderTest.hashCode()).isEqualTo(0);
    }
}
