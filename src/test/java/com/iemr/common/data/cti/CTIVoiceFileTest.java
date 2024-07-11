package com.iemr.common.data.cti;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CTIVoiceFileTest {

    private CTIVoiceFile ctiVoiceFileUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        ctiVoiceFileUnderTest = new CTIVoiceFile();
    }

    @Test
    void testToString() throws Exception {
        assertThat(ctiVoiceFileUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSetResponse() throws Exception {
        // Setup
        final CTIResponse ctiResponse = new CTIResponse();
        ctiResponse.setTransaction_id("transaction_id");
        ctiResponse.setAgentid("agentid");
        ctiResponse.setStatus("status");
        ctiResponse.setResponse_code("response_code");
        ctiResponse.setReason("reason");
        ctiResponse.setResult("result");
        ctiResponse.setPath("path");
        ctiResponse.setFilename("filename");
        ctiResponse.setDisconnect_by("disconnect_by");

        // Run the test
        ctiVoiceFileUnderTest.setResponse(ctiResponse);

        // Verify the results
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        ctiVoiceFileUnderTest.setMapper(mapper);
        assertThat(ctiVoiceFileUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testGetResponse() throws Exception {
        final CTIResponse expectedResult = new CTIResponse();
        expectedResult.setTransaction_id("transaction_id");
        expectedResult.setAgentid("agentid");
        expectedResult.setStatus("status");
        expectedResult.setResponse_code("response_code");
        expectedResult.setReason("reason");
        expectedResult.setResult("result");
        expectedResult.setPath("path");
        expectedResult.setFilename("filename");
        expectedResult.setDisconnect_by("disconnect_by");
        assertThat(ctiVoiceFileUnderTest.getResponse()).isEqualTo(expectedResult);
    }

    @Test
    void testAgent_idGetterAndSetter() throws Exception {
        final String agent_id = "agent_id";
        ctiVoiceFileUnderTest.setAgent_id(agent_id);
        assertThat(ctiVoiceFileUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testAgent_ipGetterAndSetter() {
        final String agent_ip = "agent_ip";
        ctiVoiceFileUnderTest.setAgent_ip(agent_ip);
        assertThat(ctiVoiceFileUnderTest.getAgent_ip()).isEqualTo(agent_ip);
    }

    @Test
    void testSession_idGetterAndSetter() {
        final String session_id = "session_id";
        ctiVoiceFileUnderTest.setSession_id(session_id);
        assertThat(ctiVoiceFileUnderTest.getSession_id()).isEqualTo(session_id);
    }

    @Test
    void testTransaction_idGetterAndSetter() throws Exception {
        final String transaction_id = "transaction_id";
        ctiVoiceFileUnderTest.setTransaction_id(transaction_id);
        assertThat(ctiVoiceFileUnderTest.getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void testAgentidGetterAndSetter() {
        final String agentid = "agentid";
        ctiVoiceFileUnderTest.setAgentid(agentid);
        assertThat(ctiVoiceFileUnderTest.getAgentid()).isEqualTo(agentid);
    }

    @Test
    void testStatusGetterAndSetter() throws Exception {
        final String status = "status";
        ctiVoiceFileUnderTest.setStatus(status);
        assertThat(ctiVoiceFileUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testReasonGetterAndSetter() throws Exception {
        final String reason = "reason";
        ctiVoiceFileUnderTest.setReason(reason);
        assertThat(ctiVoiceFileUnderTest.getReason()).isEqualTo(reason);
    }

    @Test
    void testResponse_codeGetterAndSetter() throws Exception {
        final String response_code = "response_code";
        ctiVoiceFileUnderTest.setResponse_code(response_code);
        assertThat(ctiVoiceFileUnderTest.getResponse_code()).isEqualTo(response_code);
    }

    @Test
    void testResultGetterAndSetter() {
        final String result1 = "result";
        ctiVoiceFileUnderTest.setResult(result1);
        assertThat(ctiVoiceFileUnderTest.getResult()).isEqualTo(result1);
    }

    @Test
    void testPathGetterAndSetter() {
        final String path = "path";
        ctiVoiceFileUnderTest.setPath(path);
        assertThat(ctiVoiceFileUnderTest.getPath()).isEqualTo(path);
    }

    @Test
    void testFilenameGetterAndSetter() {
        final String filename = "filename";
        ctiVoiceFileUnderTest.setFilename(filename);
        assertThat(ctiVoiceFileUnderTest.getFilename()).isEqualTo(filename);
    }

    @Test
    void testDisconnect_byGetterAndSetter() {
        final String disconnect_by = "disconnect_by";
        ctiVoiceFileUnderTest.setDisconnect_by(disconnect_by);
        assertThat(ctiVoiceFileUnderTest.getDisconnect_by()).isEqualTo(disconnect_by);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(ctiVoiceFileUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(ctiVoiceFileUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(ctiVoiceFileUnderTest.hashCode()).isEqualTo(0);
    }
}
