package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoPreviewDialTest {

    private AutoPreviewDial autoPreviewDialUnderTest;

    @BeforeEach
    void setUp() {
        autoPreviewDialUnderTest = new AutoPreviewDial();
    }

    @Test
    void testGetResponse() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgentid("agentid");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        assertThat(autoPreviewDialUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setAgentid("agentid");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");

        // Run the test
        autoPreviewDialUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testToString() {
        assertThat(autoPreviewDialUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        autoPreviewDialUnderTest.setOutputMapper(outputMapper);
        assertThat(autoPreviewDialUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testCamp_nameGetterAndSetter() {
        final String camp_name = "camp_name";
        autoPreviewDialUnderTest.setCamp_name(camp_name);
        assertThat(autoPreviewDialUnderTest.getCamp_name()).isEqualTo(camp_name);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "Agent_id";
        autoPreviewDialUnderTest.setAgent_id(agent_id);
        assertThat(autoPreviewDialUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testMobileGetterAndSetter() {
        final String mobile = "mobile";
        autoPreviewDialUnderTest.setMobile(mobile);
        assertThat(autoPreviewDialUnderTest.getMobile()).isEqualTo(mobile);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        autoPreviewDialUnderTest.setTransaction_id(transaction_id);
        assertThat(autoPreviewDialUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        autoPreviewDialUnderTest.setAgentid(agentid);
        assertThat(autoPreviewDialUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        autoPreviewDialUnderTest.setStatus(status);
        assertThat(autoPreviewDialUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        autoPreviewDialUnderTest.setResponse_code(response_code);
        assertThat(autoPreviewDialUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        autoPreviewDialUnderTest.setReason(reason);
        assertThat(autoPreviewDialUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testEquals() {
        assertThat(autoPreviewDialUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(autoPreviewDialUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(autoPreviewDialUnderTest.hashCode()).isEqualTo(0);
    }
}
