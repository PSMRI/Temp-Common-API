package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferCallTest {

    private TransferCall transferCallUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        transferCallUnderTest = new TransferCall();
    }

    @Test
    void testSkillGetterAndSetter() {
        final String skill = "skill";
        transferCallUnderTest.setSkill(skill);
        assertThat(transferCallUnderTest.getSkill()).isEqualTo(skill);
    }

    @Test
    void testGetResponse() throws Exception {
        // Setup
        // Run the test
        final String result = transferCallUnderTest.getResponse();

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
        assertThat(transferCallUnderTest.getResponseObj()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() throws Exception {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setAgentid("agentid");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");

        // Run the test
        transferCallUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testToString() throws Exception {
        assertThat(transferCallUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        transferCallUnderTest.setAgentid(agentid);
        assertThat(transferCallUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        transferCallUnderTest.setOutputMapper(outputMapper);
        assertThat(transferCallUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testTransfer_toGetterAndSetter() {
        final String transfer_to = "transfer_to";
        transferCallUnderTest.setTransfer_to(transfer_to);
        assertThat(transferCallUnderTest.getTransfer_to()).isEqualTo(transfer_to);
    }

    @Test
    void testTransfer_fromGetterAndSetter() {
        final String transfer_from = "transfer_from";
        transferCallUnderTest.setTransfer_from(transfer_from);
        assertThat(transferCallUnderTest.getTransfer_from()).isEqualTo(transfer_from);
    }

    @Test
    void testTransfer_campaign_infoGetterAndSetter() {
        final String transfer_campaign_info = "transfer_campaign_info";
        transferCallUnderTest.setTransfer_campaign_info(transfer_campaign_info);
        assertThat(transferCallUnderTest.getTransfer_campaign_info()).isEqualTo(transfer_campaign_info);
    }

    @Test
    void testSkill_transfer_flagGetterAndSetter() {
        final String skill_transfer_flag = "skill_transfer_flag";
        transferCallUnderTest.setSkill_transfer_flag(skill_transfer_flag);
        assertThat(transferCallUnderTest.getSkill_transfer_flag()).isEqualTo(skill_transfer_flag);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        transferCallUnderTest.setTransaction_id(transaction_id);
        assertThat(transferCallUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        transferCallUnderTest.setStatus(status);
        assertThat(transferCallUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        transferCallUnderTest.setResponse_code(response_code);
        assertThat(transferCallUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        transferCallUnderTest.setReason(reason);
        assertThat(transferCallUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testAgentIPAddressGetterAndSetter() {
        final String agentIPAddress = "agentIPAddress";
        transferCallUnderTest.setAgentIPAddress(agentIPAddress);
        assertThat(transferCallUnderTest.getAgentIPAddress()).isEqualTo(agentIPAddress);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        transferCallUnderTest.setBenCallID(benCallID);
        assertThat(transferCallUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        transferCallUnderTest.setCallTypeID(callTypeID);
        assertThat(transferCallUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testEquals() throws Exception {
        // Setup
        // Run the test
        final boolean result = transferCallUnderTest.equals("o");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(transferCallUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        // Setup
        // Run the test
        final int result = transferCallUnderTest.hashCode();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
