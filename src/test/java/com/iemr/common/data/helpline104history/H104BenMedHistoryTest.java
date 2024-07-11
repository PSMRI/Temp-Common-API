package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class H104BenMedHistoryTest {

	@InjectMocks
    private H104BenMedHistory h104BenMedHistoryUnderTest;

    @BeforeEach
    void setUp() {
        h104BenMedHistoryUnderTest = new H104BenMedHistory(0L, "patientName", 0, 0, "genderName", "algorithm",
                "symptomID", "diseaseSummary", "diseaseSummaryID", "allergies", "selecteDiagnosis",
                "selecteDiagnosisID", "addedAdvice", 0L, "actionByHAO", "actionByCO", "actionByMO", "remarks", false,
                "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Date.valueOf(LocalDate.of(2020, 1, 1)));
        h104BenMedHistoryUnderTest.setRequestID("requestID");
    }

    @Test
    void testGetActionByCO() {
        assertThat(h104BenMedHistoryUnderTest.getActionByCO()).isEqualTo("actionByCO");
    }

    @Test
    void testGetActionByPD() {
        assertThat(h104BenMedHistoryUnderTest.getActionByPD()).isEqualTo("actionByPD");
    }

    @Test
    void testGetBenHistoryID() {
        assertThat(h104BenMedHistoryUnderTest.getBenHistoryID()).isEqualTo(0L);
    }

    @Test
    void testGetDistrictID() {
        assertThat(h104BenMedHistoryUnderTest.getDistrictID()).isEqualTo(0);
    }

    @Test
    void testGetCallID() {
        assertThat(h104BenMedHistoryUnderTest.getCallID()).isEqualTo("callID");
    }

    @Test
    void testGetBenCallID() {
        assertThat(h104BenMedHistoryUnderTest.getBenCallID()).isEqualTo(0L);
    }

    @Test
    void testToString() {
        assertThat(h104BenMedHistoryUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetBeneficiaryRegID() {
        assertThat(h104BenMedHistoryUnderTest.getBeneficiaryRegID()).isEqualTo(0L);
    }
}
