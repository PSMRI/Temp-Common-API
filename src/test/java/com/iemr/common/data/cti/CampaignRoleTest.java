package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CampaignRoleTest {

    private CampaignRole campaignRoleUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        campaignRoleUnderTest = new CampaignRole();
    }

    @Test
    void testCampaignGetterAndSetter() {
        final String campaign = "campaign";
        campaignRoleUnderTest.setCampaign(campaign);
        assertThat(campaignRoleUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testRolesGetterAndSetter() {
        final JsonArray roles = new JsonArray(0);
        campaignRoleUnderTest.setRoles(roles);
        assertThat(campaignRoleUnderTest.getRoles()).isEqualTo(roles);
    }

    @Test
    void testToString() throws Exception {
        assertThat(campaignRoleUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetResponse() throws Exception {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setCampaign("campaign");
        final JsonArray roles = new JsonArray();
        expectedResult.setRoles(roles);
        assertThat(campaignRoleUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testSetResponse() throws Exception {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        response.setCampaign("campaign");
        final JsonArray roles = new JsonArray();
        response.setRoles(roles);

        // Run the test
        campaignRoleUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        campaignRoleUnderTest.setMapper(mapper);
        assertThat(campaignRoleUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        campaignRoleUnderTest.setTransaction_id(transaction_id);
        assertThat(campaignRoleUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        campaignRoleUnderTest.setResponse_code(response_code);
        assertThat(campaignRoleUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        campaignRoleUnderTest.setStatus(status);
        assertThat(campaignRoleUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        campaignRoleUnderTest.setReason(reason);
        assertThat(campaignRoleUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(campaignRoleUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(campaignRoleUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(campaignRoleUnderTest.hashCode()).isEqualTo(0);
    }
}
