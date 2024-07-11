package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PrescriptionTest {

	@InjectMocks
    private Prescription prescriptionUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        prescriptionUnderTest = new Prescription();
    }

    @Test
    void testPrescriptionIDGetterAndSetter() {
        final Long prescriptionID = 0L;
        prescriptionUnderTest.setPrescriptionID(prescriptionID);
        assertThat(prescriptionUnderTest.getPrescriptionID()).isEqualTo(prescriptionID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        prescriptionUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(prescriptionUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testDiagnosisProvidedGetterAndSetter() {
        final String diagnosisProvided = "diagnosisProvided";
        prescriptionUnderTest.setDiagnosisProvided(diagnosisProvided);
        assertThat(prescriptionUnderTest.getDiagnosisProvided()).isEqualTo(diagnosisProvided);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        prescriptionUnderTest.setRemarks(remarks);
        assertThat(prescriptionUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        prescriptionUnderTest.setDeleted(deleted);
        assertThat(prescriptionUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testEquals() {
        assertThat(prescriptionUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(prescriptionUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(prescriptionUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(prescriptionUnderTest.toString()).isEqualTo("result");
    }
}
