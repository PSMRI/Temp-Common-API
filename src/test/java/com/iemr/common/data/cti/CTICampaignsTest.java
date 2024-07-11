package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CTICampaignsTest {

    private CTICampaigns ctiCampaignsUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        ctiCampaignsUnderTest = new CTICampaigns();
    }

    @Test
    void testToString() throws Exception {
        assertThat(ctiCampaignsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() throws Exception {
        final CTIResponseTemp expectedResult = new CTIResponseTemp();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgentid("agentid");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        final JsonArray campaign = new JsonArray();
        expectedResult.setCampaign(campaign);
        assertThat(ctiCampaignsUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() throws Exception {
        // Setup
        final CTIResponseTemp response = new CTIResponseTemp();
        response.setTransaction_id("transaction_id");
        response.setAgentid("agentid");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        final JsonArray campaign = new JsonArray();
        response.setCampaign(campaign);

        // Run the test
        ctiCampaignsUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testGetLogger() {
        assertThat(ctiCampaignsUnderTest.getLogger()).isEqualTo(ctiCampaignsUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        ctiCampaignsUnderTest.setOutputMapper(outputMapper);
        assertThat(ctiCampaignsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        ctiCampaignsUnderTest.setAgent_id(agent_id);
        assertThat(ctiCampaignsUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        ctiCampaignsUnderTest.setTransaction_id(transaction_id);
        assertThat(ctiCampaignsUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        ctiCampaignsUnderTest.setAgentid(agentid);
        assertThat(ctiCampaignsUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testCampaignGetterAndSetter() {
        final JsonArray campaign = new JsonArray(0);
        ctiCampaignsUnderTest.setCampaign(campaign);
        assertThat(ctiCampaignsUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        ctiCampaignsUnderTest.setResponse_code(response_code);
        assertThat(ctiCampaignsUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        ctiCampaignsUnderTest.setReason(reason);
        assertThat(ctiCampaignsUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        ctiCampaignsUnderTest.setStatus(status);
        assertThat(ctiCampaignsUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(ctiCampaignsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(ctiCampaignsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(ctiCampaignsUnderTest.hashCode()).isEqualTo(0);
    }
}
