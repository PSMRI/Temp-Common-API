package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class QaReportModel2Test {

	@InjectMocks
    private QaReportModel2 qaReportModel2UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        qaReportModel2UnderTest = new QaReportModel2();
    }

    @Test
    void testGetModel() {
        // Setup
        // Run the test
        final QaReportModel2 result = qaReportModel2UnderTest.getModel(0L,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "callId", "agentID", "firstName",
                "receivedRoleName", "diseaseSummary", "selecteDiagnosis", "callTypeName", 0, "remarks",
                "recordingFilePath");

        // Verify the results
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        qaReportModel2UnderTest.setRemarks(remarks);
        assertThat(qaReportModel2UnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testSNoGetterAndSetter() {
        final Long sNo = 0L;
        qaReportModel2UnderTest.setSNo(sNo);
        assertThat(qaReportModel2UnderTest.getSNo()).isEqualTo(sNo);
    }

    @Test
    void testDateOfCallGetterAndSetter() {
        final Timestamp dateOfCall = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        qaReportModel2UnderTest.setDateOfCall(dateOfCall);
        assertThat(qaReportModel2UnderTest.getDateOfCall()).isEqualTo(dateOfCall);
    }

    @Test
    void testCallIDGetterAndSetter() {
        final String callID = "callID";
        qaReportModel2UnderTest.setCallID(callID);
        assertThat(qaReportModel2UnderTest.getCallID()).isEqualTo(callID);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        qaReportModel2UnderTest.setAgentID(agentID);
        assertThat(qaReportModel2UnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testAgentNameGetterAndSetter() {
        final String agentName = "agentName";
        qaReportModel2UnderTest.setAgentName(agentName);
        assertThat(qaReportModel2UnderTest.getAgentName()).isEqualTo(agentName);
    }

    @Test
    void testSkillSetGetterAndSetter() {
        final String skillSet = "skillSet";
        qaReportModel2UnderTest.setSkillSet(skillSet);
        assertThat(qaReportModel2UnderTest.getSkillSet()).isEqualTo(skillSet);
    }

    @Test
    void testSymptomGetterAndSetter() {
        final String symptom = "symptom";
        qaReportModel2UnderTest.setSymptom(symptom);
        assertThat(qaReportModel2UnderTest.getSymptom()).isEqualTo(symptom);
    }

    @Test
    void testDiseaseSummaryProvidedGetterAndSetter() {
        final String diseaseSummaryProvided = "diseaseSummaryProvided";
        qaReportModel2UnderTest.setDiseaseSummaryProvided(diseaseSummaryProvided);
        assertThat(qaReportModel2UnderTest.getDiseaseSummaryProvided()).isEqualTo(diseaseSummaryProvided);
    }

    @Test
    void testCallTypeGetterAndSetter() {
        final String callType = "callType";
        qaReportModel2UnderTest.setCallType(callType);
        assertThat(qaReportModel2UnderTest.getCallType()).isEqualTo(callType);
    }

    @Test
    void testCallDurationGetterAndSetter() {
        final String callDuration = "callDuration";
        qaReportModel2UnderTest.setCallDuration(callDuration);
        assertThat(qaReportModel2UnderTest.getCallDuration()).isEqualTo(callDuration);
    }

    @Test
    void testRecordingFilePathGetterAndSetter() {
        final String recordingFilePath = "recordingFilePath";
        qaReportModel2UnderTest.setRecordingFilePath(recordingFilePath);
        assertThat(qaReportModel2UnderTest.getRecordingFilePath()).isEqualTo(recordingFilePath);
    }

    @Test
    void testToString() throws Exception {
        assertThat(qaReportModel2UnderTest.toString()).isEqualTo("result");
    }
}
