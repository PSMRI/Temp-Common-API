package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CampaignNamesTest {

    private CampaignNames campaignNamesUnderTest;

    @BeforeEach
    void setUp() {
        campaignNamesUnderTest = new CampaignNames();
    }

    @Test
    void testServiceNameGetterAndSetter() {
        final String serviceName = "serviceName";
        campaignNamesUnderTest.setServiceName(serviceName);
        assertThat(campaignNamesUnderTest.getServiceName()).isEqualTo(serviceName);
    }

    @Test
    void testTypeGetterAndSetter() {
        final String type = "type";
        campaignNamesUnderTest.setType(type);
        assertThat(campaignNamesUnderTest.getType()).isEqualTo(type);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        campaignNamesUnderTest.setPhoneNo(phoneNo);
        assertThat(campaignNamesUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testCampaignNameGetterAndSetter() {
        final String campaignName = "campaignName";
        campaignNamesUnderTest.setCampaignName(campaignName);
        assertThat(campaignNamesUnderTest.getCampaignName()).isEqualTo(campaignName);
    }

    @Test
    void testToString() {
        assertThat(campaignNamesUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() {
        final CTIResponseTemp expectedResult = new CTIResponseTemp();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        final JsonArray campaign = new JsonArray();
        expectedResult.setCampaign(campaign);
        assertThat(campaignNamesUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() {
        // Setup
        final CTIResponseTemp response = new CTIResponseTemp();
        response.setTransaction_id("transaction_id");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        final JsonArray campaign = new JsonArray();
        response.setCampaign(campaign);

        // Run the test
        campaignNamesUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testGetLogger() {
        assertThat(campaignNamesUnderTest.getLogger()).isEqualTo(campaignNamesUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        campaignNamesUnderTest.setOutputMapper(outputMapper);
        assertThat(campaignNamesUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        campaignNamesUnderTest.setTransaction_id(transaction_id);
        assertThat(campaignNamesUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testCampaignGetterAndSetter() {
        final JsonArray campaign = new JsonArray(0);
        campaignNamesUnderTest.setCampaign(campaign);
        assertThat(campaignNamesUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testReasonGetterAndSetter() {
        final String reason = "reason";
        campaignNamesUnderTest.setReason(reason);
        assertThat(campaignNamesUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        campaignNamesUnderTest.setResponse_code(response_code);
        assertThat(campaignNamesUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        campaignNamesUnderTest.setStatus(status);
        assertThat(campaignNamesUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() {
        assertThat(campaignNamesUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(campaignNamesUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(campaignNamesUnderTest.hashCode()).isEqualTo(0);
    }
}
