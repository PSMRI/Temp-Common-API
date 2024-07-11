package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlockUnblockNumberTest {

    private BlockUnblockNumber blockUnblockNumberUnderTest;

    @BeforeEach
    void setUp() {
        blockUnblockNumberUnderTest = new BlockUnblockNumber();
    }

    @Test
    void testServiceNameGetterAndSetter() {
        final String serviceName = "serviceName";
        blockUnblockNumberUnderTest.setServiceName(serviceName);
        assertThat(blockUnblockNumberUnderTest.getServiceName()).isEqualTo(serviceName);
    }

    @Test
    void testTypeGetterAndSetter() {
        final String type = "type";
        blockUnblockNumberUnderTest.setType(type);
        assertThat(blockUnblockNumberUnderTest.getType()).isEqualTo(type);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        blockUnblockNumberUnderTest.setPhoneNo(phoneNo);
        assertThat(blockUnblockNumberUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testCampaignNameGetterAndSetter() {
        final String campaignName = "campaignName";
        blockUnblockNumberUnderTest.setCampaignName(campaignName);
        assertThat(blockUnblockNumberUnderTest.getCampaignName()).isEqualTo(campaignName);
    }

    @Test
    void testToString() {
        assertThat(blockUnblockNumberUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setCampaign("campaign");
        assertThat(blockUnblockNumberUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        response.setCampaign("campaign");

        // Run the test
        blockUnblockNumberUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testGetLogger() {
        assertThat(blockUnblockNumberUnderTest.getLogger()).isEqualTo(blockUnblockNumberUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        blockUnblockNumberUnderTest.setOutputMapper(outputMapper);
        assertThat(blockUnblockNumberUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        blockUnblockNumberUnderTest.setTransaction_id(transaction_id);
        assertThat(blockUnblockNumberUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testCampaignGetterAndSetter() {
        final String campaign = "campaign";
        blockUnblockNumberUnderTest.setCampaign(campaign);
        assertThat(blockUnblockNumberUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        blockUnblockNumberUnderTest.setReason(reason);
        assertThat(blockUnblockNumberUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        blockUnblockNumberUnderTest.setResponse_code(response_code);
        assertThat(blockUnblockNumberUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        blockUnblockNumberUnderTest.setStatus(status);
        assertThat(blockUnblockNumberUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() {
        assertThat(blockUnblockNumberUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(blockUnblockNumberUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(blockUnblockNumberUnderTest.hashCode()).isEqualTo(0);
    }
}
