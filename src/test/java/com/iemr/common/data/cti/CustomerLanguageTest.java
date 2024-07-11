package com.iemr.common.data.cti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerLanguageTest {

    private CustomerLanguage customerLanguageUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        customerLanguageUnderTest = new CustomerLanguage();
    }

    @Test
    void testSetResponse() throws Exception {
        // Setup
        final CTIResponse response = new CTIResponse();
        response.setTransaction_id("transaction_id");
        response.setStatus("status");
        response.setResponse_code("response_code");
        response.setReason("reason");
        response.setCust_ph_no("cust_ph_no");
        response.setCampaign("campaign");
        response.setLanguage("language");

        // Run the test
        customerLanguageUnderTest.setResponse(response);

        // Verify the results
    }

    @Test
    void testToString() throws Exception {
        assertThat(customerLanguageUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCust_ph_noGetterAndSetter() {
        final String cust_ph_no = "cust_ph_no";
        customerLanguageUnderTest.setCust_ph_no(cust_ph_no);
        assertThat(customerLanguageUnderTest.getCust_ph_no()).isEqualTo(cust_ph_no);
    }

    @Test
    void testCampaign_nameGetterAndSetter() {
        final String campaign_name = "campaign_name";
        customerLanguageUnderTest.setCampaign_name(campaign_name);
        assertThat(customerLanguageUnderTest.getCampaign_name()).isEqualTo(campaign_name);
    }

    @Test
    void testLanguageGetterAndSetter() {
        final String language = "language";
        customerLanguageUnderTest.setLanguage(language);
        assertThat(customerLanguageUnderTest.getLanguage()).isEqualTo(language);
    }

    @Test
    void testActionGetterAndSetter() {
        final String action = "action";
        customerLanguageUnderTest.setAction(action);
        assertThat(customerLanguageUnderTest.getAction()).isEqualTo(action);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        customerLanguageUnderTest.setTransaction_id(transaction_id);
        assertThat(customerLanguageUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        customerLanguageUnderTest.setStatus(status);
        assertThat(customerLanguageUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        customerLanguageUnderTest.setResponse_code(response_code);
        assertThat(customerLanguageUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        customerLanguageUnderTest.setReason(reason);
        assertThat(customerLanguageUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testGetResponse() throws Exception {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setCust_ph_no("cust_ph_no");
        expectedResult.setCampaign("campaign");
        expectedResult.setLanguage("language");
        assertThat(customerLanguageUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(customerLanguageUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(customerLanguageUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(customerLanguageUnderTest.hashCode()).isEqualTo(0);
    }
}
