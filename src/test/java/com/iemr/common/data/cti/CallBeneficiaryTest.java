package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CallBeneficiaryTest {

    private CallBeneficiary callBeneficiaryUnderTest;

    @BeforeEach
    void setUp() {
        callBeneficiaryUnderTest = new CallBeneficiary();
    }

    @Test
    void testToString() {
        assertThat(callBeneficiaryUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setAgentid("agentid");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        assertThat(callBeneficiaryUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponse ctiResponse = new CTIResponse();
        final OutputMapper mapper = new OutputMapper();
        ctiResponse.setMapper(mapper);
        ctiResponse.setAgentid("agentid");
        ctiResponse.setStatus("status");
        ctiResponse.setResponse_code("response_code");
        ctiResponse.setReason("reason");

        // Run the test
        callBeneficiaryUnderTest.setResponse(ctiResponse);

        // Verify the results
    }

    @Test
    void testGetLogger() {
        assertThat(callBeneficiaryUnderTest.getLogger()).isEqualTo(callBeneficiaryUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        callBeneficiaryUnderTest.setOutputMapper(outputMapper);
        assertThat(callBeneficiaryUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final String agent_id = "agent_id";
        callBeneficiaryUnderTest.setAgent_id(agent_id);
        assertThat(callBeneficiaryUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testPhone_numGetterAndSetter() {
        final String phone_num = "phone_num";
        callBeneficiaryUnderTest.setPhone_num(phone_num);
        assertThat(callBeneficiaryUnderTest.getPhone_num()).isEqualTo(phone_num);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        callBeneficiaryUnderTest.setTransaction_id(transaction_id);
        assertThat(callBeneficiaryUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        callBeneficiaryUnderTest.setAgentid(agentid);
        assertThat(callBeneficiaryUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testRequestparamGetterAndSetter() {
        final String requestparam = "requestparam";
        callBeneficiaryUnderTest.setRequestparam(requestparam);
        assertThat(callBeneficiaryUnderTest.getRequestparam()).isEqualTo(requestparam);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        callBeneficiaryUnderTest.setStatus(status);
        assertThat(callBeneficiaryUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        callBeneficiaryUnderTest.setResponse_code(response_code);
        assertThat(callBeneficiaryUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        callBeneficiaryUnderTest.setReason(reason);
        assertThat(callBeneficiaryUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testEquals() {
        assertThat(callBeneficiaryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(callBeneficiaryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(callBeneficiaryUnderTest.hashCode()).isEqualTo(0);
    }
}
