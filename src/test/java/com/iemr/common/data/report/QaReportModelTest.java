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
class QaReportModelTest {

	@InjectMocks
    private QaReportModel qaReportModelUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        qaReportModelUnderTest = new QaReportModel();
    }

    @Test
    void testGetModel() {
        // Setup
        // Run the test
        final QaReportModel result = qaReportModelUnderTest.getModel(0L,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "callId", "agentID", "firstName",
                "receivedRoleName", "diseaseSummary", "selecteDiagnosis", "callTypeName", 0, "recordingFilePath");

        // Verify the results
    }

    @Test
    void testSNoGetterAndSetter() {
        final Long sNo = 0L;
        qaReportModelUnderTest.setSNo(sNo);
        assertThat(qaReportModelUnderTest.getSNo()).isEqualTo(sNo);
    }

    @Test
    void testDateOfCallGetterAndSetter() {
        final Timestamp dateOfCall = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        qaReportModelUnderTest.setDateOfCall(dateOfCall);
        assertThat(qaReportModelUnderTest.getDateOfCall()).isEqualTo(dateOfCall);
    }

    @Test
    void testCallIDGetterAndSetter() {
        final String callID = "callID";
        qaReportModelUnderTest.setCallID(callID);
        assertThat(qaReportModelUnderTest.getCallID()).isEqualTo(callID);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        qaReportModelUnderTest.setAgentID(agentID);
        assertThat(qaReportModelUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testAgentNameGetterAndSetter() {
        final String agentName = "agentName";
        qaReportModelUnderTest.setAgentName(agentName);
        assertThat(qaReportModelUnderTest.getAgentName()).isEqualTo(agentName);
    }

    @Test
    void testSkillSetGetterAndSetter() {
        final String skillSet = "skillSet";
        qaReportModelUnderTest.setSkillSet(skillSet);
        assertThat(qaReportModelUnderTest.getSkillSet()).isEqualTo(skillSet);
    }

    @Test
    void testSymptomGetterAndSetter() {
        final String symptom = "symptom";
        qaReportModelUnderTest.setSymptom(symptom);
        assertThat(qaReportModelUnderTest.getSymptom()).isEqualTo(symptom);
    }

    @Test
    void testDiseaseSummaryProvidedGetterAndSetter() {
        final String diseaseSummaryProvided = "diseaseSummaryProvided";
        qaReportModelUnderTest.setDiseaseSummaryProvided(diseaseSummaryProvided);
        assertThat(qaReportModelUnderTest.getDiseaseSummaryProvided()).isEqualTo(diseaseSummaryProvided);
    }

    @Test
    void testCallTypeGetterAndSetter() {
        final String callType = "callType";
        qaReportModelUnderTest.setCallType(callType);
        assertThat(qaReportModelUnderTest.getCallType()).isEqualTo(callType);
    }

    @Test
    void testCallDurationGetterAndSetter() {
        final String callDuration = "callDuration";
        qaReportModelUnderTest.setCallDuration(callDuration);
        assertThat(qaReportModelUnderTest.getCallDuration()).isEqualTo(callDuration);
    }

    @Test
    void testRecordingFilePathGetterAndSetter() {
        final String recordingFilePath = "recordingFilePath";
        qaReportModelUnderTest.setRecordingFilePath(recordingFilePath);
        assertThat(qaReportModelUnderTest.getRecordingFilePath()).isEqualTo(recordingFilePath);
    }

    @Test
    void testToString() {
        assertThat(qaReportModelUnderTest.toString()).isEqualTo("result");
    }
}
