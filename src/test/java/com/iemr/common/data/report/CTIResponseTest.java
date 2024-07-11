package com.iemr.common.data.report;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CTIResponseTest {

	@InjectMocks
    private CTIResponse ctiResponseUnderTest;

    @BeforeEach
    void setUp() {
        ctiResponseUnderTest = new CTIResponse();
    }

    @Test
    void testCall_start_date_timeGetterAndSetter() {
        final String call_start_date_time = "call_start_date_time";
        ctiResponseUnderTest.setCall_start_date_time(call_start_date_time);
        assertThat(ctiResponseUnderTest.getCall_start_date_time()).isEqualTo(call_start_date_time);
    }

    @Test
    void testCall_end_date_timeGetterAndSetter() {
        final String call_end_date_time = "call_end_date_time";
        ctiResponseUnderTest.setCall_end_date_time(call_end_date_time);
        assertThat(ctiResponseUnderTest.getCall_end_date_time()).isEqualTo(call_end_date_time);
    }

    @Test
    void testToString() {
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
    void testTransaction_idGetterAndSetter() {
        final String transaction_id = "transaction_id";
        ctiResponseUnderTest.setTransaction_id(transaction_id);
        assertThat(ctiResponseUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testResponse_codeGetterAndSetter() {
        final String response_code = "response_code";
        ctiResponseUnderTest.setResponse_code(response_code);
        assertThat(ctiResponseUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        ctiResponseUnderTest.setAgentid(agentid);
        assertThat(ctiResponseUnderTest.getAgentid()).isEqualTo(agentid);
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
    void testStatusGetterAndSetter() {
        final String status = "status";
        ctiResponseUnderTest.setStatus(status);
        assertThat(ctiResponseUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testGetSuccess() {
        assertThat(CTIResponse.getSuccess()).isEqualTo("success");
    }

    @Test
    void testResponseGetterAndSetter() {
        final String response = "response";
        ctiResponseUnderTest.setResponse(response);
        assertThat(ctiResponseUnderTest.getResponse()).isEqualTo(response);
    }
}
