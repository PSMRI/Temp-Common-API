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
class PrescribedDrugTest {

	@InjectMocks
    private PrescribedDrug prescribedDrugUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        prescribedDrugUnderTest = new PrescribedDrug();
    }

    @Test
    void testPrescribedDrugIDGetterAndSetter() {
        final Long prescribedDrugID = 0L;
        prescribedDrugUnderTest.setPrescribedDrugID(prescribedDrugID);
        assertThat(prescribedDrugUnderTest.getPrescribedDrugID()).isEqualTo(prescribedDrugID);
    }

    @Test
    void testPrescriptionIDGetterAndSetter() {
        final Long prescriptionID = 0L;
        prescribedDrugUnderTest.setPrescriptionID(prescriptionID);
        assertThat(prescribedDrugUnderTest.getPrescriptionID()).isEqualTo(prescriptionID);
    }

    @Test
    void testT_prescriptionGetterAndSetter() {
        final Prescription t_prescription = new Prescription();
        prescribedDrugUnderTest.setT_prescription(t_prescription);
        assertThat(prescribedDrugUnderTest.getT_prescription()).isEqualTo(t_prescription);
    }

    @Test
    void testDrugMapIDGetterAndSetter() {
        final Integer drugMapID = 0;
        prescribedDrugUnderTest.setDrugMapID(drugMapID);
        assertThat(prescribedDrugUnderTest.getDrugMapID()).isEqualTo(drugMapID);
    }

    @Test
    void testDrugNameGetterAndSetter() {
        final String drugName = "drugName";
        prescribedDrugUnderTest.setDrugName(drugName);
        assertThat(prescribedDrugUnderTest.getDrugName()).isEqualTo(drugName);
    }

    @Test
    void testM_104drugmappingGetterAndSetter() {
        final M_104drugmapping m_104drugmapping = new M_104drugmapping();
        prescribedDrugUnderTest.setM_104drugmapping(m_104drugmapping);
        assertThat(prescribedDrugUnderTest.getM_104drugmapping()).isEqualTo(m_104drugmapping);
    }

    @Test
    void testDrugFormGetterAndSetter() {
        final String drugForm = "drugForm";
        prescribedDrugUnderTest.setDrugForm(drugForm);
        assertThat(prescribedDrugUnderTest.getDrugForm()).isEqualTo(drugForm);
    }

    @Test
    void testDrugRouteGetterAndSetter() {
        final String drugRoute = "drugRoute";
        prescribedDrugUnderTest.setDrugRoute(drugRoute);
        assertThat(prescribedDrugUnderTest.getDrugRoute()).isEqualTo(drugRoute);
    }

    @Test
    void testFrequencyGetterAndSetter() {
        final String frequency = "frequency";
        prescribedDrugUnderTest.setFrequency(frequency);
        assertThat(prescribedDrugUnderTest.getFrequency()).isEqualTo(frequency);
    }

    @Test
    void testDosageGetterAndSetter() {
        final String dosage = "dosage";
        prescribedDrugUnderTest.setDosage(dosage);
        assertThat(prescribedDrugUnderTest.getDosage()).isEqualTo(dosage);
    }

    @Test
    void testNoOfDaysGetterAndSetter() {
        final Integer noOfDays = 0;
        prescribedDrugUnderTest.setNoOfDays(noOfDays);
        assertThat(prescribedDrugUnderTest.getNoOfDays()).isEqualTo(noOfDays);
    }

    @Test
    void testTimeToConsumeGetterAndSetter() {
        final String timeToConsume = "timeToConsume";
        prescribedDrugUnderTest.setTimeToConsume(timeToConsume);
        assertThat(prescribedDrugUnderTest.getTimeToConsume()).isEqualTo(timeToConsume);
    }

    @Test
    void testSideEffectsGetterAndSetter() {
        final String sideEffects = "sideEffects";
        prescribedDrugUnderTest.setSideEffects(sideEffects);
        assertThat(prescribedDrugUnderTest.getSideEffects()).isEqualTo(sideEffects);
    }

    @Test
    void testValidTillGetterAndSetter() {
        final Timestamp validTill = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        prescribedDrugUnderTest.setValidTill(validTill);
        assertThat(prescribedDrugUnderTest.getValidTill()).isEqualTo(validTill);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        prescribedDrugUnderTest.setDeleted(deleted);
        assertThat(prescribedDrugUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        prescribedDrugUnderTest.setCreatedBy(createdBy);
        assertThat(prescribedDrugUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        prescribedDrugUnderTest.setCreatedDate(createdDate);
        assertThat(prescribedDrugUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        prescribedDrugUnderTest.setModifiedBy(modifiedBy);
        assertThat(prescribedDrugUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        prescribedDrugUnderTest.setLastModDate(lastModDate);
        assertThat(prescribedDrugUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(prescribedDrugUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(prescribedDrugUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(prescribedDrugUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(prescribedDrugUnderTest.toString()).isEqualTo("result");
    }
}
