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
class MedHistoryTest {

	@InjectMocks
    private MedHistory medHistoryUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        medHistoryUnderTest = new MedHistory();
    }

    @Test
    void testBeneficiaryDataGetterAndSetter() {
        final BenDetails beneficiaryData = new BenDetails();
        medHistoryUnderTest.setBeneficiaryData(beneficiaryData);
        assertThat(medHistoryUnderTest.getBeneficiaryData()).isEqualTo(beneficiaryData);
    }

    @Test
    void testReportTypeIDGetterAndSetter() {
        final Integer reportTypeID = 0;
        medHistoryUnderTest.setReportTypeID(reportTypeID);
        assertThat(medHistoryUnderTest.getReportTypeID()).isEqualTo(reportTypeID);
    }

    @Test
    void testReportTypeGetterAndSetter() {
        final String reportType = "reportType";
        medHistoryUnderTest.setReportType(reportType);
        assertThat(medHistoryUnderTest.getReportType()).isEqualTo(reportType);
    }

    @Test
    void testFact_104BenMedHistoryIDGetterAndSetter() {
        final Long fact_104BenMedHistoryID = 0L;
        medHistoryUnderTest.setFact_104BenMedHistoryID(fact_104BenMedHistoryID);
        assertThat(medHistoryUnderTest.getFact_104BenMedHistoryID()).isEqualTo(fact_104BenMedHistoryID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        medHistoryUnderTest.setBenCallID(benCallID);
        assertThat(medHistoryUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testSymptomIDGetterAndSetter() {
        final String symptomID = "symptomID";
        medHistoryUnderTest.setSymptomID(symptomID);
        assertThat(medHistoryUnderTest.getSymptomID()).isEqualTo(symptomID);
    }

    @Test
    void testAlgorithmGetterAndSetter() {
        final String algorithm = "algorithm";
        medHistoryUnderTest.setAlgorithm(algorithm);
        assertThat(medHistoryUnderTest.getAlgorithm()).isEqualTo(algorithm);
    }

    @Test
    void testDiseaseSummaryIDGetterAndSetter() {
        final String diseaseSummaryID = "diseaseSummaryID";
        medHistoryUnderTest.setDiseaseSummaryID(diseaseSummaryID);
        assertThat(medHistoryUnderTest.getDiseaseSummaryID()).isEqualTo(diseaseSummaryID);
    }

    @Test
    void testDiseaseSummaryGetterAndSetter() {
        final String diseaseSummary = "diseaseSummary";
        medHistoryUnderTest.setDiseaseSummary(diseaseSummary);
        assertThat(medHistoryUnderTest.getDiseaseSummary()).isEqualTo(diseaseSummary);
    }

    @Test
    void testSelecteDiagnosisIDGetterAndSetter() {
        final String selecteDiagnosisID = "selecteDiagnosisID";
        medHistoryUnderTest.setSelecteDiagnosisID(selecteDiagnosisID);
        assertThat(medHistoryUnderTest.getSelecteDiagnosisID()).isEqualTo(selecteDiagnosisID);
    }

    @Test
    void testSelecteDiagnosisGetterAndSetter() {
        final String selecteDiagnosis = "selecteDiagnosis";
        medHistoryUnderTest.setSelecteDiagnosis(selecteDiagnosis);
        assertThat(medHistoryUnderTest.getSelecteDiagnosis()).isEqualTo(selecteDiagnosis);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        medHistoryUnderTest.setAgentID(agentID);
        assertThat(medHistoryUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        medHistoryUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(medHistoryUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Long roleID = 0L;
        medHistoryUnderTest.setRoleID(roleID);
        assertThat(medHistoryUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testStartDateGetterAndSetter() {
        final Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        medHistoryUnderTest.setStartDate(startDate);
        assertThat(medHistoryUnderTest.getStartDate()).isEqualTo(startDate);
    }

    @Test
    void testEndDateGetterAndSetter() {
        final Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        medHistoryUnderTest.setEndDate(endDate);
        assertThat(medHistoryUnderTest.getEndDate()).isEqualTo(endDate);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        medHistoryUnderTest.setCallTypeID(callTypeID);
        assertThat(medHistoryUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testCallTypeNameGetterAndSetter() {
        final String callTypeName = "callTypeName";
        medHistoryUnderTest.setCallTypeName(callTypeName);
        assertThat(medHistoryUnderTest.getCallTypeName()).isEqualTo(callTypeName);
    }

    @Test
    void testRoleNameGetterAndSetter() {
        final String roleName = "roleName";
        medHistoryUnderTest.setRoleName(roleName);
        assertThat(medHistoryUnderTest.getRoleName()).isEqualTo(roleName);
    }
}
