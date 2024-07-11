package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgentSkillsTest {

    private AgentSkills agentSkillsUnderTest;

    @BeforeEach
    void setUp() {
        agentSkillsUnderTest = new AgentSkills();
        agentSkillsUnderTest.setAgentid("agentid");
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        agentSkillsUnderTest.setAgent_id(agent_id);
        assertThat(agentSkillsUnderTest.getAgentID()).isEqualTo(agent_id);
    }

    @Test
    void testCall_idGetterAndSetter() {
        final String call_id = "call_id";
        agentSkillsUnderTest.setCall_id(call_id);
        assertThat(agentSkillsUnderTest.getCallID()).isEqualTo(call_id);
    }

    @Test
    void testSkillGetterAndSetter() {
        final String skill = "skill";
        agentSkillsUnderTest.setSkill(skill);
        assertThat(agentSkillsUnderTest.getSkill()).isEqualTo(skill);
    }

    @Test
    void testWeightGetterAndSetter() {
        final String weight = "weight";
        agentSkillsUnderTest.setWeight(weight);
        assertThat(agentSkillsUnderTest.getWeight()).isEqualTo(weight);
    }

    @Test
    void testTypeGetterAndSetter() {
        final String type = "type";
        agentSkillsUnderTest.setType(type);
        assertThat(agentSkillsUnderTest.getType()).isEqualTo(type);
    }

    @Test
    void testGetResponse() {
        // Setup
        // Run the test
        final String result = agentSkillsUnderTest.getResponse();

        // Verify the results
        assertThat(result).isEqualTo("response");
    }

    @Test
    void testGetResponseObj() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgentid("agentid");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setSkill("skill");
        expectedResult.setWeight("weight");
        final JsonArray skills = new JsonArray();
        expectedResult.setSkills(skills);
        assertThat(agentSkillsUnderTest.getResponseObj()).isEqualTo(expectedResult);
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
        response.setSkill("skill");
        response.setWeight("weight");
        final JsonArray skills = new JsonArray();
        response.setSkills(skills);

        // Run the test
        agentSkillsUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testToString() {
        assertThat(agentSkillsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCampaign_nameGetterAndSetter() {
        final String campaign_name = "campaign_name";
        agentSkillsUnderTest.setCampaign_name(campaign_name);
        assertThat(agentSkillsUnderTest.getCampaignName()).isEqualTo(campaign_name);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        agentSkillsUnderTest.setOutputMapper(outputMapper);
        assertThat(agentSkillsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testCampaign_name1GetterAndSetter() {
        final String campaign_name = "campaign_name";
        agentSkillsUnderTest.setCampaign_name(campaign_name);
        assertThat(agentSkillsUnderTest.getCampaign_name()).isEqualTo(campaign_name);
    }

    @Test
    void testAgent_id1GetterAndSetter() {
        final String agent_id = "agent_id";
        agentSkillsUnderTest.setAgent_id(agent_id);
        assertThat(agentSkillsUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testSkillsGetterAndSetter() {
        final JsonArray skills = new JsonArray(0);
        agentSkillsUnderTest.setSkills(skills);
        assertThat(agentSkillsUnderTest.getSkills()).isEqualTo(skills);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        agentSkillsUnderTest.setTransaction_id(transaction_id);
        assertThat(agentSkillsUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        agentSkillsUnderTest.setStatus(status);
        assertThat(agentSkillsUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        agentSkillsUnderTest.setResponse_code(response_code);
        assertThat(agentSkillsUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        agentSkillsUnderTest.setReason(reason);
        assertThat(agentSkillsUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testIsFeedbackGetterAndSetter() {
        final Integer isFeedback = 0;
        agentSkillsUnderTest.setIsFeedback(isFeedback);
        assertThat(agentSkillsUnderTest.getIsFeedback()).isEqualTo(isFeedback);
    }

    @Test
    void testCall_id1GetterAndSetter() {
        final String call_id = "call_id";
        agentSkillsUnderTest.setCall_id(call_id);
        assertThat(agentSkillsUnderTest.getCall_id()).isEqualTo(call_id);
    }

    @Test
    void testEquals() {
        // Setup
        // Run the test
        final boolean result = agentSkillsUnderTest.equals("o");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(agentSkillsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        // Setup
        // Run the test
        final int result = agentSkillsUnderTest.hashCode();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
