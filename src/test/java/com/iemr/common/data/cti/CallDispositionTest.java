package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CallDispositionTest {

    private CallDisposition callDispositionUnderTest;

    @BeforeEach
    void setUp() {
        callDispositionUnderTest = new CallDisposition();
    }

    @Test
    void testToString() {
        assertThat(callDispositionUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponse ctiResponse = new CTIResponse();
        ctiResponse.setTransaction_id("transaction_id");
        ctiResponse.setAgentid("agentid");
        ctiResponse.setStatus("status");
        ctiResponse.setResponse_code("response_code");
        ctiResponse.setReason("reason");

        // Run the test
        callDispositionUnderTest.setResponse(ctiResponse);

        // Verify the results
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        callDispositionUnderTest.setMapper(mapper);
        assertThat(callDispositionUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testGetResponse() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgentid("agentid");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        assertThat(callDispositionUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        callDispositionUnderTest.setAgent_id(agent_id);
        assertThat(callDispositionUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testAgent_ipGetterAndSetter() {
        final String agent_ip = "agent_ip";
        callDispositionUnderTest.setAgent_ip(agent_ip);
        assertThat(callDispositionUnderTest.getAgent_ip()).isEqualTo(agent_ip);
    }

    @Test
    void testCust_dispGetterAndSetter() {
        final String cust_disp = "cust_disp";
        callDispositionUnderTest.setCust_disp(cust_disp);
        assertThat(callDispositionUnderTest.getCust_disp()).isEqualTo(cust_disp);
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "category";
        callDispositionUnderTest.setCategory(category);
        assertThat(callDispositionUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testSession_idGetterAndSetter() {
        final String session_id = "session_id";
        callDispositionUnderTest.setSession_id(session_id);
        assertThat(callDispositionUnderTest.getSession_id()).isEqualTo(session_id);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        callDispositionUnderTest.setTransaction_id(transaction_id);
        assertThat(callDispositionUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        callDispositionUnderTest.setAgentid(agentid);
        assertThat(callDispositionUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        callDispositionUnderTest.setStatus(status);
        assertThat(callDispositionUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        callDispositionUnderTest.setReason(reason);
        assertThat(callDispositionUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        callDispositionUnderTest.setResponse_code(response_code);
        assertThat(callDispositionUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testEquals() {
        assertThat(callDispositionUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(callDispositionUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(callDispositionUnderTest.hashCode()).isEqualTo(0);
    }
}
