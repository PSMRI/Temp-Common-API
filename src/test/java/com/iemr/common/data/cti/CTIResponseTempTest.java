package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CTIResponseTempTest {

    private CTIResponseTemp ctiResponseTempUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        ctiResponseTempUnderTest = new CTIResponseTemp();
    }

    @Test
    void testToString() throws Exception {
        assertThat(ctiResponseTempUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testIsSuccessResponse() {
        // Setup
        // Run the test
        final Boolean result = ctiResponseTempUnderTest.isSuccessResponse();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        ctiResponseTempUnderTest.setMapper(mapper);
        assertThat(ctiResponseTempUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        ctiResponseTempUnderTest.setTransaction_id(transaction_id);
        assertThat(ctiResponseTempUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        ctiResponseTempUnderTest.setAgentid(agentid);
        assertThat(ctiResponseTempUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        ctiResponseTempUnderTest.setAgent_id(agent_id);
        assertThat(ctiResponseTempUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testRequestparamGetterAndSetter() {
        final String requestparam = "requestparam";
        ctiResponseTempUnderTest.setRequestparam(requestparam);
        assertThat(ctiResponseTempUnderTest.getRequestparam()).isEqualTo(requestparam);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        ctiResponseTempUnderTest.setStatus(status);
        assertThat(ctiResponseTempUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        ctiResponseTempUnderTest.setResponse_code(response_code);
        assertThat(ctiResponseTempUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        ctiResponseTempUnderTest.setReason(reason);
        assertThat(ctiResponseTempUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testSkillGetterAndSetter() {
        final String skill = "skill";
        ctiResponseTempUnderTest.setSkill(skill);
        assertThat(ctiResponseTempUnderTest.getSkill()).isEqualTo(skill);
    }

    @Test
    void testWeightGetterAndSetter() {
        final String weight = "weight";
        ctiResponseTempUnderTest.setWeight(weight);
        assertThat(ctiResponseTempUnderTest.getWeight()).isEqualTo(weight);
    }

    @Test
    void testSkillsGetterAndSetter() {
        final String skills = "skills";
        ctiResponseTempUnderTest.setSkills(skills);
        assertThat(ctiResponseTempUnderTest.getSkills()).isEqualTo(skills);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "state";
        ctiResponseTempUnderTest.setState(state);
        assertThat(ctiResponseTempUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testDialer_typeGetterAndSetter() {
        final String dialer_type = "dialer_type";
        ctiResponseTempUnderTest.setDialer_type(dialer_type);
        assertThat(ctiResponseTempUnderTest.getDialer_type()).isEqualTo(dialer_type);
    }

    @Test
    void testCampaign_dialerTypeGetterAndSetter() {
        final String campaign_dialerType = "campaign_dialerType";
        ctiResponseTempUnderTest.setCampaign_dialerType(campaign_dialerType);
        assertThat(ctiResponseTempUnderTest.getCampaign_dialerType()).isEqualTo(campaign_dialerType);
    }

    @Test
    void testPreviewDialingGetterAndSetter() {
        final String previewDialing = "previewDialing";
        ctiResponseTempUnderTest.setPreviewDialing(previewDialing);
        assertThat(ctiResponseTempUnderTest.getPreviewDialing()).isEqualTo(previewDialing);
    }

    @Test
    void testManual_dialGetterAndSetter() {
        final String manual_dial = "manual_dial";
        ctiResponseTempUnderTest.setManual_dial(manual_dial);
        assertThat(ctiResponseTempUnderTest.getManual_dial()).isEqualTo(manual_dial);
    }

    @Test
    void testLast_cust_ph_noGetterAndSetter() {
        final String last_cust_ph_no = "last_cust_ph_no";
        ctiResponseTempUnderTest.setLast_cust_ph_no(last_cust_ph_no);
        assertThat(ctiResponseTempUnderTest.getLast_cust_ph_no()).isEqualTo(last_cust_ph_no);
    }

    @Test
    void testCall_durationGetterAndSetter() {
        final String call_duration = "call_duration";
        ctiResponseTempUnderTest.setCall_duration(call_duration);
        assertThat(ctiResponseTempUnderTest.getCall_duration()).isEqualTo(call_duration);
    }

    @Test
    void testCLIGetterAndSetter() {
        final String cLI = "CLI";
        ctiResponseTempUnderTest.setCLI(cLI);
        assertThat(ctiResponseTempUnderTest.getCLI()).isEqualTo(cLI);
    }

    @Test
    void testSession_idGetterAndSetter() {
        final String session_id = "session_id";
        ctiResponseTempUnderTest.setSession_id(session_id);
        assertThat(ctiResponseTempUnderTest.getSession_id()).isEqualTo(session_id);
    }

    @Test
    void testIvrs_pathGetterAndSetter() {
        final String ivrs_path = "ivrs_path";
        ctiResponseTempUnderTest.setIvrs_path(ivrs_path);
        assertThat(ctiResponseTempUnderTest.getIvrs_path()).isEqualTo(ivrs_path);
    }

    @Test
    void testCust_ph_noGetterAndSetter() {
        final String cust_ph_no = "cust_ph_no";
        ctiResponseTempUnderTest.setCust_ph_no(cust_ph_no);
        assertThat(ctiResponseTempUnderTest.getCust_ph_no()).isEqualTo(cust_ph_no);
    }

    @Test
    void testWrapTimeGetterAndSetter() {
        final String wrapTime = "wrapTime";
        ctiResponseTempUnderTest.setWrapTime(wrapTime);
        assertThat(ctiResponseTempUnderTest.getWrapTime()).isEqualTo(wrapTime);
    }

    @Test
    void testWrpupDisconnectFlagGetterAndSetter() {
        final String wrpupDisconnectFlag = "wrpupDisconnectFlag";
        ctiResponseTempUnderTest.setWrpupDisconnectFlag(wrpupDisconnectFlag);
        assertThat(ctiResponseTempUnderTest.getWrpupDisconnectFlag()).isEqualTo(wrpupDisconnectFlag);
    }

    @Test
    void testCampaignGetterAndSetter() {
        final JsonArray campaign = new JsonArray(0);
        ctiResponseTempUnderTest.setCampaign(campaign);
        assertThat(ctiResponseTempUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testAgent_ipGetterAndSetter() {
        final String agent_ip = "agent_ip";
        ctiResponseTempUnderTest.setAgent_ip(agent_ip);
        assertThat(ctiResponseTempUnderTest.getAgent_ip()).isEqualTo(agent_ip);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(ctiResponseTempUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(ctiResponseTempUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(ctiResponseTempUnderTest.hashCode()).isEqualTo(0);
    }
}
