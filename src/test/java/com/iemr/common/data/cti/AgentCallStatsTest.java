package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgentCallStatsTest {

    private AgentCallStats agentCallStatsUnderTest;

    @BeforeEach
    void setUp() {
        agentCallStatsUnderTest = new AgentCallStats();
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        agentCallStatsUnderTest.setAgent_id(agent_id);
        assertThat(agentCallStatsUnderTest.getAgentID()).isEqualTo(agent_id);
    }

    @Test
    void testToString() {
        assertThat(agentCallStatsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponse ctiResponse = new CTIResponse();
        ctiResponse.setTransaction_id("transaction_id");
        ctiResponse.setAgent_id("agent_id");
        ctiResponse.setStatus("status");
        ctiResponse.setResponse_code("response_code");
        ctiResponse.setReason("reason");
        ctiResponse.setTotal_calls("total_calls");
        ctiResponse.setTotal_invalid_calls("total_invalid_calls");
        ctiResponse.setTotal_call_duration("total_call_duration");
        ctiResponse.setTotal_free_time("total_free_time");
        ctiResponse.setTotal_break_time("total_break_time");

        // Run the test
        agentCallStatsUnderTest.setResponse(ctiResponse);

        // Verify the results
    }

    @Test
    void testGetResponse() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgent_id("agent_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setTotal_calls("total_calls");
        expectedResult.setTotal_invalid_calls("total_invalid_calls");
        expectedResult.setTotal_call_duration("total_call_duration");
        expectedResult.setTotal_free_time("total_free_time");
        expectedResult.setTotal_break_time("total_break_time");
        assertThat(agentCallStatsUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testGetLogger() {
        assertThat(agentCallStatsUnderTest.getLogger()).isEqualTo(agentCallStatsUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        agentCallStatsUnderTest.setOutputMapper(outputMapper);
        assertThat(agentCallStatsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        agentCallStatsUnderTest.setTransaction_id(transaction_id);
        assertThat(agentCallStatsUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgent_id1GetterAndSetter() {
        final String agent_id = "agent_id";
        agentCallStatsUnderTest.setAgent_id(agent_id);
        assertThat(agentCallStatsUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testTotal_callsGetterAndSetter() {
        final String total_calls = "total_calls";
        agentCallStatsUnderTest.setTotal_calls(total_calls);
        assertThat(agentCallStatsUnderTest.getTotal_calls()).isEqualTo(total_calls);
    }

    @Test
    void testTotal_invalid_callsGetterAndSetter() {
        final String total_invalid_calls = "total_invalid_calls";
        agentCallStatsUnderTest.setTotal_invalid_calls(total_invalid_calls);
        assertThat(agentCallStatsUnderTest.getTotal_invalid_calls()).isEqualTo(total_invalid_calls);
    }

    @Test
    void testTotal_call_durationGetterAndSetter() {
        final String total_call_duration = "total_call_duration";
        agentCallStatsUnderTest.setTotal_call_duration(total_call_duration);
        assertThat(agentCallStatsUnderTest.getTotal_call_duration()).isEqualTo(total_call_duration);
    }

    @Test
    void testTotal_free_timeGetterAndSetter() {
        final String total_free_time = "total_free_time";
        agentCallStatsUnderTest.setTotal_free_time(total_free_time);
        assertThat(agentCallStatsUnderTest.getTotal_free_time()).isEqualTo(total_free_time);
    }

    @Test
    void testTotal_break_timeGetterAndSetter() {
        final String total_break_time = "total_break_time";
        agentCallStatsUnderTest.setTotal_break_time(total_break_time);
        assertThat(agentCallStatsUnderTest.getTotal_break_time()).isEqualTo(total_break_time);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        agentCallStatsUnderTest.setResponse_code(response_code);
        assertThat(agentCallStatsUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testCLIGetterAndSetter() {
        final String cLI = "CLI";
        agentCallStatsUnderTest.setCLI(cLI);
        assertThat(agentCallStatsUnderTest.getCLI()).isEqualTo(cLI);
    }

    @Test
    void testSession_idGetterAndSetter() {
        final String session_id = "session_id";
        agentCallStatsUnderTest.setSession_id(session_id);
        assertThat(agentCallStatsUnderTest.getSession_id()).isEqualTo(session_id);
    }

    @Test
    void testStateObjGetterAndSetter() throws Exception {
        final JSONObject stateObj = new JSONObject("object");
        agentCallStatsUnderTest.setStateObj(stateObj);
        assertThat(agentCallStatsUnderTest.getStateObj()).isEqualTo(stateObj);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        agentCallStatsUnderTest.setStatus(status);
        assertThat(agentCallStatsUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        agentCallStatsUnderTest.setReason(reason);
        assertThat(agentCallStatsUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testEquals() {
        assertThat(agentCallStatsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(agentCallStatsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(agentCallStatsUnderTest.hashCode()).isEqualTo(0);
    }
}
