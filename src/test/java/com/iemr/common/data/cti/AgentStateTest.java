package com.iemr.common.data.cti;

import com.google.gson.JsonObject;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgentStateTest {

    private AgentState agentStateUnderTest;

    @BeforeEach
    void setUp() {
        agentStateUnderTest = new AgentState();
    }

    @Test
    void testToString() {
        // Setup
        // Run the test
        final String result = agentStateUnderTest.toString();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponseTemp ctiResponse = new CTIResponseTemp();
        ctiResponse.setTransaction_id("transaction_id");
        ctiResponse.setAgentid("agentid");
        ctiResponse.setAgent_id("agent_id");
        ctiResponse.setRequestparam("requestparam");
        ctiResponse.setStatus("status");
        ctiResponse.setResponse_code("response_code");
        ctiResponse.setReason("reason");
        ctiResponse.setSkills("skills");
        ctiResponse.setState("state");
        ctiResponse.setDialer_type("dialer_type");
        ctiResponse.setCampaign_dialerType("campaign_dialerType");
        ctiResponse.setPreviewDialing("previewDialing");
        ctiResponse.setManual_dial("manual_dial");
        ctiResponse.setLast_cust_ph_no("last_cust_ph_no");
        ctiResponse.setCall_duration("call_duration");
        ctiResponse.setCLI("CLI");
        ctiResponse.setSession_id("session_id");
        ctiResponse.setIvrs_path("ivrs_path");
        ctiResponse.setCust_ph_no("cust_ph_no");
        ctiResponse.setWrapTime("wrapTime");
        ctiResponse.setWrpupDisconnectFlag("wrpupDisconnectFlag");
        ctiResponse.setAgent_ip("agent_ip");

        // Run the test
        agentStateUnderTest.setResponse(ctiResponse);

        // Verify the results
    }

    @Test
    void testGetResponse() {
        final CTIResponseTemp expectedResult = new CTIResponseTemp();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgentid("agentid");
        expectedResult.setAgent_id("agent_id");
        expectedResult.setRequestparam("requestparam");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setSkills("skills");
        expectedResult.setState("state");
        expectedResult.setDialer_type("dialer_type");
        expectedResult.setCampaign_dialerType("campaign_dialerType");
        expectedResult.setPreviewDialing("previewDialing");
        expectedResult.setManual_dial("manual_dial");
        expectedResult.setLast_cust_ph_no("last_cust_ph_no");
        expectedResult.setCall_duration("call_duration");
        expectedResult.setCLI("CLI");
        expectedResult.setSession_id("session_id");
        expectedResult.setIvrs_path("ivrs_path");
        expectedResult.setCust_ph_no("cust_ph_no");
        expectedResult.setWrapTime("wrapTime");
        expectedResult.setWrpupDisconnectFlag("wrpupDisconnectFlag");
        expectedResult.setAgent_ip("agent_ip");
        assertThat(agentStateUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testGetLogger() {
        assertThat(agentStateUnderTest.getLogger()).isEqualTo(agentStateUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        agentStateUnderTest.setOutputMapper(outputMapper);
        assertThat(agentStateUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testStateObjGetterAndSetter() {
        final JsonObject stateObj = new JsonObject();
        agentStateUnderTest.setStateObj(stateObj);
        assertThat(agentStateUnderTest.getStateObj()).isEqualTo(stateObj);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        agentStateUnderTest.setTransaction_id(transaction_id);
        assertThat(agentStateUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        agentStateUnderTest.setAgent_id(agent_id);
        assertThat(agentStateUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        agentStateUnderTest.setAgentid(agentid);
        assertThat(agentStateUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testRequestparamGetterAndSetter() {
        final String requestparam = "requestparam";
        agentStateUnderTest.setRequestparam(requestparam);
        assertThat(agentStateUnderTest.getRequestparam()).isEqualTo(requestparam);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "state";
        agentStateUnderTest.setState(state);
        assertThat(agentStateUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testCall_durationGetterAndSetter() {
        final String call_duration = "call_duration";
        agentStateUnderTest.setCall_duration(call_duration);
        assertThat(agentStateUnderTest.getCall_duration()).isEqualTo(call_duration);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        agentStateUnderTest.setStatus(status);
        assertThat(agentStateUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        agentStateUnderTest.setResponse_code(response_code);
        assertThat(agentStateUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testCLIGetterAndSetter() {
        final String cLI = "CLI";
        agentStateUnderTest.setCLI(cLI);
        assertThat(agentStateUnderTest.getCLI()).isEqualTo(cLI);
    }

    @Test
    void testSession_idGetterAndSetter() {
        final String session_id = "session_id";
        agentStateUnderTest.setSession_id(session_id);
        assertThat(agentStateUnderTest.getSession_id()).isEqualTo(session_id);
    }

    @Test
    void testDialer_typeGetterAndSetter() {
        final String dialer_type = "dialer_type";
        agentStateUnderTest.setDialer_type(dialer_type);
        assertThat(agentStateUnderTest.getDialer_type()).isEqualTo(dialer_type);
    }

    @Test
    void testCampaign_dialerTypeGetterAndSetter() {
        final String campaign_dialerType = "campaign_dialerType";
        agentStateUnderTest.setCampaign_dialerType(campaign_dialerType);
        assertThat(agentStateUnderTest.getCampaign_dialerType()).isEqualTo(campaign_dialerType);
    }

    @Test
    void testPreviewDialingGetterAndSetter() {
        final String previewDialing = "previewDialing";
        agentStateUnderTest.setPreviewDialing(previewDialing);
        assertThat(agentStateUnderTest.getPreviewDialing()).isEqualTo(previewDialing);
    }

    @Test
    void testManual_dialGetterAndSetter() {
        final String manual_dial = "manual_dial";
        agentStateUnderTest.setManual_dial(manual_dial);
        assertThat(agentStateUnderTest.getManual_dial()).isEqualTo(manual_dial);
    }

    @Test
    void testLast_cust_ph_noGetterAndSetter() {
        final String last_cust_ph_no = "last_cust_ph_no";
        agentStateUnderTest.setLast_cust_ph_no(last_cust_ph_no);
        assertThat(agentStateUnderTest.getLast_cust_ph_no()).isEqualTo(last_cust_ph_no);
    }

    @Test
    void testIvrs_pathGetterAndSetter() {
        final String ivrs_path = "ivrs_path";
        agentStateUnderTest.setIvrs_path(ivrs_path);
        assertThat(agentStateUnderTest.getIvrs_path()).isEqualTo(ivrs_path);
    }

    @Test
    void testIvrs_languageGetterAndSetter() {
        final String ivrs_language = "ivrs_language";
        agentStateUnderTest.setIvrs_language(ivrs_language);
        assertThat(agentStateUnderTest.getIvrs_language()).isEqualTo(ivrs_language);
    }

    @Test
    void testZoneNameGetterAndSetter() {
        final String zoneName = "zoneName";
        agentStateUnderTest.setZoneName(zoneName);
        assertThat(agentStateUnderTest.getZoneName()).isEqualTo(zoneName);
    }

    @Test
    void testSkillsGetterAndSetter() {
        final String skills = "skills";
        agentStateUnderTest.setSkills(skills);
        assertThat(agentStateUnderTest.getSkills()).isEqualTo(skills);
    }

    @Test
    void testCust_ph_noGetterAndSetter() {
        final String cust_ph_no = "cust_ph_no";
        agentStateUnderTest.setCust_ph_no(cust_ph_no);
        assertThat(agentStateUnderTest.getCust_ph_no()).isEqualTo(cust_ph_no);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        agentStateUnderTest.setReason(reason);
        assertThat(agentStateUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testWrapTimeGetterAndSetter() {
        final String wrapTime = "wrapTime";
        agentStateUnderTest.setWrapTime(wrapTime);
        assertThat(agentStateUnderTest.getWrapTime()).isEqualTo(wrapTime);
    }

    @Test
    void testWrpupDisconnectFlagGetterAndSetter() {
        final String wrpupDisconnectFlag = "wrpupDisconnectFlag";
        agentStateUnderTest.setWrpupDisconnectFlag(wrpupDisconnectFlag);
        assertThat(agentStateUnderTest.getWrpupDisconnectFlag()).isEqualTo(wrpupDisconnectFlag);
    }

    @Test
    void testAgent_ipGetterAndSetter() {
        final String agent_ip = "agent_ip";
        agentStateUnderTest.setAgent_ip(agent_ip);
        assertThat(agentStateUnderTest.getAgent_ip()).isEqualTo(agent_ip);
    }

    @Test
    void testEquals() {
        assertThat(agentStateUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(agentStateUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(agentStateUnderTest.hashCode()).isEqualTo(0);
    }
}
