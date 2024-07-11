package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CTIResponseTest {

    private CTIResponse ctiResponseUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        ctiResponseUnderTest = new CTIResponse();
    }

    @Test
    void testToString() throws Exception {
        assertThat(ctiResponseUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testIsSuccessResponse() {
        // Setup
        // Run the test
        final Boolean result = ctiResponseUnderTest.isSuccessResponse();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        ctiResponseUnderTest.setMapper(mapper);
        assertThat(ctiResponseUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        ctiResponseUnderTest.setTransaction_id(transaction_id);
        assertThat(ctiResponseUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        ctiResponseUnderTest.setAgentid(agentid);
        assertThat(ctiResponseUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        ctiResponseUnderTest.setAgent_id(agent_id);
        assertThat(ctiResponseUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testRequestparamGetterAndSetter() {
        final String requestparam = "requestparam";
        ctiResponseUnderTest.setRequestparam(requestparam);
        assertThat(ctiResponseUnderTest.getRequestparam()).isEqualTo(requestparam);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        ctiResponseUnderTest.setStatus(status);
        assertThat(ctiResponseUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        ctiResponseUnderTest.setResponse_code(response_code);
        assertThat(ctiResponseUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        ctiResponseUnderTest.setReason(reason);
        assertThat(ctiResponseUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testSkillGetterAndSetter() {
        final String skill = "skill";
        ctiResponseUnderTest.setSkill(skill);
        assertThat(ctiResponseUnderTest.getSkill()).isEqualTo(skill);
    }

    @Test
    void testWeightGetterAndSetter() {
        final String weight = "weight";
        ctiResponseUnderTest.setWeight(weight);
        assertThat(ctiResponseUnderTest.getWeight()).isEqualTo(weight);
    }

    @Test
    void testSkillsGetterAndSetter() {
        final JsonArray skills = new JsonArray(0);
        ctiResponseUnderTest.setSkills(skills);
        assertThat(ctiResponseUnderTest.getSkills()).isEqualTo(skills);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "state";
        ctiResponseUnderTest.setState(state);
        assertThat(ctiResponseUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testDialer_typeGetterAndSetter() {
        final String dialer_type = "dialer_type";
        ctiResponseUnderTest.setDialer_type(dialer_type);
        assertThat(ctiResponseUnderTest.getDialer_type()).isEqualTo(dialer_type);
    }

    @Test
    void testCampaign_dialerTypeGetterAndSetter() {
        final String campaign_dialerType = "campaign_dialerType";
        ctiResponseUnderTest.setCampaign_dialerType(campaign_dialerType);
        assertThat(ctiResponseUnderTest.getCampaign_dialerType()).isEqualTo(campaign_dialerType);
    }

    @Test
    void testPreviewDialingGetterAndSetter() {
        final String previewDialing = "previewDialing";
        ctiResponseUnderTest.setPreviewDialing(previewDialing);
        assertThat(ctiResponseUnderTest.getPreviewDialing()).isEqualTo(previewDialing);
    }

    @Test
    void testManual_dialGetterAndSetter() {
        final String manual_dial = "manual_dial";
        ctiResponseUnderTest.setManual_dial(manual_dial);
        assertThat(ctiResponseUnderTest.getManual_dial()).isEqualTo(manual_dial);
    }

    @Test
    void testLast_cust_ph_noGetterAndSetter() {
        final String last_cust_ph_no = "last_cust_ph_no";
        ctiResponseUnderTest.setLast_cust_ph_no(last_cust_ph_no);
        assertThat(ctiResponseUnderTest.getLast_cust_ph_no()).isEqualTo(last_cust_ph_no);
    }

    @Test
    void testCall_durationGetterAndSetter() {
        final String call_duration = "call_duration";
        ctiResponseUnderTest.setCall_duration(call_duration);
        assertThat(ctiResponseUnderTest.getCall_duration()).isEqualTo(call_duration);
    }

    @Test
    void testCLIGetterAndSetter() {
        final String cLI = "CLI";
        ctiResponseUnderTest.setCLI(cLI);
        assertThat(ctiResponseUnderTest.getCLI()).isEqualTo(cLI);
    }

    @Test
    void testSession_idGetterAndSetter() {
        final String session_id = "session_id";
        ctiResponseUnderTest.setSession_id(session_id);
        assertThat(ctiResponseUnderTest.getSession_id()).isEqualTo(session_id);
    }

    @Test
    void testIvrs_pathGetterAndSetter() {
        final String ivrs_path = "ivrs_path";
        ctiResponseUnderTest.setIvrs_path(ivrs_path);
        assertThat(ctiResponseUnderTest.getIvrs_path()).isEqualTo(ivrs_path);
    }

    @Test
    void testCust_ph_noGetterAndSetter() {
        final String cust_ph_no = "cust_ph_no";
        ctiResponseUnderTest.setCust_ph_no(cust_ph_no);
        assertThat(ctiResponseUnderTest.getCust_ph_no()).isEqualTo(cust_ph_no);
    }

    @Test
    void testWrapTimeGetterAndSetter() {
        final String wrapTime = "wrapTime";
        ctiResponseUnderTest.setWrapTime(wrapTime);
        assertThat(ctiResponseUnderTest.getWrapTime()).isEqualTo(wrapTime);
    }

    @Test
    void testWrpupDisconnectFlagGetterAndSetter() {
        final String wrpupDisconnectFlag = "wrpupDisconnectFlag";
        ctiResponseUnderTest.setWrpupDisconnectFlag(wrpupDisconnectFlag);
        assertThat(ctiResponseUnderTest.getWrpupDisconnectFlag()).isEqualTo(wrpupDisconnectFlag);
    }

    @Test
    void testTotal_callsGetterAndSetter() {
        final String total_calls = "total_calls";
        ctiResponseUnderTest.setTotal_calls(total_calls);
        assertThat(ctiResponseUnderTest.getTotal_calls()).isEqualTo(total_calls);
    }

    @Test
    void testTotal_invalid_callsGetterAndSetter() {
        final String total_invalid_calls = "total_invalid_calls";
        ctiResponseUnderTest.setTotal_invalid_calls(total_invalid_calls);
        assertThat(ctiResponseUnderTest.getTotal_invalid_calls()).isEqualTo(total_invalid_calls);
    }

    @Test
    void testTotal_call_durationGetterAndSetter() {
        final String total_call_duration = "total_call_duration";
        ctiResponseUnderTest.setTotal_call_duration(total_call_duration);
        assertThat(ctiResponseUnderTest.getTotal_call_duration()).isEqualTo(total_call_duration);
    }

    @Test
    void testTotal_free_timeGetterAndSetter() {
        final String total_free_time = "total_free_time";
        ctiResponseUnderTest.setTotal_free_time(total_free_time);
        assertThat(ctiResponseUnderTest.getTotal_free_time()).isEqualTo(total_free_time);
    }

    @Test
    void testTotal_break_timeGetterAndSetter() {
        final String total_break_time = "total_break_time";
        ctiResponseUnderTest.setTotal_break_time(total_break_time);
        assertThat(ctiResponseUnderTest.getTotal_break_time()).isEqualTo(total_break_time);
    }

    @Test
    void testCampaignGetterAndSetter() {
        final String campaign = "campaign";
        ctiResponseUnderTest.setCampaign(campaign);
        assertThat(ctiResponseUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testLogin_keyGetterAndSetter() {
        final String login_key = "login_key";
        ctiResponseUnderTest.setLogin_key(login_key);
        assertThat(ctiResponseUnderTest.getLogin_key()).isEqualTo(login_key);
    }

    @Test
    void testUser_nameGetterAndSetter() {
        final String user_name = "user_name";
        ctiResponseUnderTest.setUser_name(user_name);
        assertThat(ctiResponseUnderTest.getUser_name()).isEqualTo(user_name);
    }

    @Test
    void testRolesGetterAndSetter() {
        final JsonArray roles = new JsonArray(0);
        ctiResponseUnderTest.setRoles(roles);
        assertThat(ctiResponseUnderTest.getRoles()).isEqualTo(roles);
    }

    @Test
    void testResultGetterAndSetter() {
        final String result1 = "result";
        ctiResponseUnderTest.setResult(result1);
        assertThat(ctiResponseUnderTest.getResult()).isEqualTo(result1);
    }

    @Test
    void testPathGetterAndSetter() {
        final String path = "path";
        ctiResponseUnderTest.setPath(path);
        assertThat(ctiResponseUnderTest.getPath()).isEqualTo(path);
    }

    @Test
    void testFilenameGetterAndSetter() {
        final String filename = "filename";
        ctiResponseUnderTest.setFilename(filename);
        assertThat(ctiResponseUnderTest.getFilename()).isEqualTo(filename);
    }

    @Test
    void testDisconnect_byGetterAndSetter() {
        final String disconnect_by = "disconnect_by";
        ctiResponseUnderTest.setDisconnect_by(disconnect_by);
        assertThat(ctiResponseUnderTest.getDisconnect_by()).isEqualTo(disconnect_by);
    }

    @Test
    void testLanguageGetterAndSetter() {
        final String language = "language";
        ctiResponseUnderTest.setLanguage(language);
        assertThat(ctiResponseUnderTest.getLanguage()).isEqualTo(language);
    }

    @Test
    void testActionGetterAndSetter() {
        final String action = "action";
        ctiResponseUnderTest.setAction(action);
        assertThat(ctiResponseUnderTest.getAction()).isEqualTo(action);
    }

    @Test
    void testResponseGetterAndSetter() {
        final String response = "response";
        ctiResponseUnderTest.setResponse(response);
        assertThat(ctiResponseUnderTest.getResponse()).isEqualTo(response);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(ctiResponseUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(ctiResponseUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(ctiResponseUnderTest.hashCode()).isEqualTo(0);
    }
}
