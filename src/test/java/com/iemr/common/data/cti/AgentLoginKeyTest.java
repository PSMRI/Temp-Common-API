package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgentLoginKeyTest {

    private AgentLoginKey agentLoginKeyUnderTest;

    @BeforeEach
    void setUp() {
        agentLoginKeyUnderTest = new AgentLoginKey();
    }

    @Test
    void testUsernameGetterAndSetter() {
        final String username = "username";
        agentLoginKeyUnderTest.setUsername(username);
        assertThat(agentLoginKeyUnderTest.getUsername()).isEqualTo(username);
    }

    @Test
    void testPasswordGetterAndSetter() {
        final String password = "password";
        agentLoginKeyUnderTest.setPassword(password);
        assertThat(agentLoginKeyUnderTest.getPassword()).isEqualTo(password);
    }

    @Test
    void testToString() {
        assertThat(agentLoginKeyUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setLogin_key("login_key");
        assertThat(agentLoginKeyUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        response.setLogin_key("login_key");

        // Run the test
        agentLoginKeyUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testGetLogger() {
        assertThat(agentLoginKeyUnderTest.getLogger()).isEqualTo(agentLoginKeyUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        agentLoginKeyUnderTest.setOutputMapper(outputMapper);
        assertThat(agentLoginKeyUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        agentLoginKeyUnderTest.setTransaction_id(transaction_id);
        assertThat(agentLoginKeyUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testLogin_keyGetterAndSetter() {
        final String login_key = "login_key";
        agentLoginKeyUnderTest.setLogin_key(login_key);
        assertThat(agentLoginKeyUnderTest.getLogin_key()).isEqualTo(login_key);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        agentLoginKeyUnderTest.setReason(reason);
        assertThat(agentLoginKeyUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        agentLoginKeyUnderTest.setStatus(status);
        assertThat(agentLoginKeyUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        agentLoginKeyUnderTest.setResponse_code(response_code);
        assertThat(agentLoginKeyUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testEquals() {
        assertThat(agentLoginKeyUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(agentLoginKeyUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(agentLoginKeyUnderTest.hashCode()).isEqualTo(0);
    }
}
