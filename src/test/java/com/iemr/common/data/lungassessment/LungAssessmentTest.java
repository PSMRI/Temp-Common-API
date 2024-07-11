package com.iemr.common.data.lungassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@ExtendWith(MockitoExtension.class)
class LungAssessmentTest {

	@InjectMocks
    private LungAssessment lungAssessmentUnderTest;

    @BeforeEach
    void setUp() {
        lungAssessmentUnderTest = new LungAssessment();
    }

    @Test
    void testIdGetterAndSetter() {
        final BigInteger id = new BigInteger("100");
        lungAssessmentUnderTest.setId(id);
        assertThat(lungAssessmentUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testPatientIdGetterAndSetter() {
        final Long patientId = 0L;
        lungAssessmentUnderTest.setPatientId(patientId);
        assertThat(lungAssessmentUnderTest.getPatientId()).isEqualTo(patientId);
    }

    @Test
    void testAssessmentIdGetterAndSetter() {
        final String assessmentId = "assessmentId";
        lungAssessmentUnderTest.setAssessmentId(assessmentId);
        assertThat(lungAssessmentUnderTest.getAssessmentId()).isEqualTo(assessmentId);
    }

    @Test
    void testAgeGetterAndSetter() {
        final Integer age = 0;
        lungAssessmentUnderTest.setAge(age);
        assertThat(lungAssessmentUnderTest.getAge()).isEqualTo(age);
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "gender";
        lungAssessmentUnderTest.setGender(gender);
        assertThat(lungAssessmentUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testTimestampGetterAndSetter() {
        final String timestamp = "timestamp";
        lungAssessmentUnderTest.setTimestamp(timestamp);
        assertThat(lungAssessmentUnderTest.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void testFrequent_coughGetterAndSetter() {
        final Integer frequent_cough = 0;
        lungAssessmentUnderTest.setFrequent_cough(frequent_cough);
        assertThat(lungAssessmentUnderTest.getFrequent_cough()).isEqualTo(frequent_cough);
    }

    @Test
    void testSputumGetterAndSetter() {
        final Integer sputum = 0;
        lungAssessmentUnderTest.setSputum(sputum);
        assertThat(lungAssessmentUnderTest.getSputum()).isEqualTo(sputum);
    }

    @Test
    void testCough_at_nightGetterAndSetter() {
        final Integer cough_at_night = 0;
        lungAssessmentUnderTest.setCough_at_night(cough_at_night);
        assertThat(lungAssessmentUnderTest.getCough_at_night()).isEqualTo(cough_at_night);
    }

    @Test
    void testWheezingGetterAndSetter() {
        final Integer wheezing = 0;
        lungAssessmentUnderTest.setWheezing(wheezing);
        assertThat(lungAssessmentUnderTest.getWheezing()).isEqualTo(wheezing);
    }

    @Test
    void testPain_in_chestGetterAndSetter() {
        final Integer pain_in_chest = 0;
        lungAssessmentUnderTest.setPain_in_chest(pain_in_chest);
        assertThat(lungAssessmentUnderTest.getPain_in_chest()).isEqualTo(pain_in_chest);
    }

    @Test
    void testShortness_of_breathGetterAndSetter() {
        final Integer shortness_of_breath = 0;
        lungAssessmentUnderTest.setShortness_of_breath(shortness_of_breath);
        assertThat(lungAssessmentUnderTest.getShortness_of_breath()).isEqualTo(shortness_of_breath);
    }

    @Test
    void testRecord_durationGetterAndSetter() {
        final Double record_duration = 0.0;
        lungAssessmentUnderTest.setRecord_duration(record_duration);
        assertThat(lungAssessmentUnderTest.getRecord_duration()).isEqualTo(record_duration, within(0.0001));
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        lungAssessmentUnderTest.setStatus(status);
        assertThat(lungAssessmentUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testRiskGetterAndSetter() {
        final String risk = "risk";
        lungAssessmentUnderTest.setRisk(risk);
        assertThat(lungAssessmentUnderTest.getRisk()).isEqualTo(risk);
    }

    @Test
    void testCough_severity_scoreGetterAndSetter() {
        final Integer cough_severity_score = 0;
        lungAssessmentUnderTest.setCough_severity_score(cough_severity_score);
        assertThat(lungAssessmentUnderTest.getCough_severity_score()).isEqualTo(cough_severity_score);
    }

    @Test
    void testCough_patternGetterAndSetter() {
        final String cough_pattern = "cough_pattern";
        lungAssessmentUnderTest.setCough_pattern(cough_pattern);
        assertThat(lungAssessmentUnderTest.getCough_pattern()).isEqualTo(cough_pattern);
    }

    @Test
    void testDry_cough_countGetterAndSetter() {
        final Integer dry_cough_count = 0;
        lungAssessmentUnderTest.setDry_cough_count(dry_cough_count);
        assertThat(lungAssessmentUnderTest.getDry_cough_count()).isEqualTo(dry_cough_count);
    }

    @Test
    void testWet_cough_countGetterAndSetter() {
        final Integer wet_cough_count = 0;
        lungAssessmentUnderTest.setWet_cough_count(wet_cough_count);
        assertThat(lungAssessmentUnderTest.getWet_cough_count()).isEqualTo(wet_cough_count);
    }

    @Test
    void testSeverityGetterAndSetter() {
        final String severity = "severity";
        lungAssessmentUnderTest.setSeverity(severity);
        assertThat(lungAssessmentUnderTest.getSeverity()).isEqualTo(severity);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        lungAssessmentUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(lungAssessmentUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        lungAssessmentUnderTest.setDeleted(deleted);
        assertThat(lungAssessmentUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        lungAssessmentUnderTest.setCreatedBy(createdBy);
        assertThat(lungAssessmentUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        lungAssessmentUnderTest.setCreatedDate(createdDate);
        assertThat(lungAssessmentUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        lungAssessmentUnderTest.setModifiedBy(modifiedBy);
        assertThat(lungAssessmentUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        lungAssessmentUnderTest.setLastModDate(lastModDate);
        assertThat(lungAssessmentUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testSymptomsGetterAndSetter() {
        final SymptomsDTO symptoms = new SymptomsDTO();
        lungAssessmentUnderTest.setSymptoms(symptoms);
        assertThat(lungAssessmentUnderTest.getSymptoms()).isEqualTo(symptoms);
    }

    @Test
    void testCoughsoundfileGetterAndSetter() {
        final MultipartFile coughsoundfile = new MockMultipartFile("name", "content".getBytes());
        lungAssessmentUnderTest.setCoughsoundfile(coughsoundfile);
        assertThat(lungAssessmentUnderTest.getCoughsoundfile()).isEqualTo(coughsoundfile);
    }

    @Test
    void testMessageGetterAndSetter() {
        final String message = "message";
        lungAssessmentUnderTest.setMessage(message);
        assertThat(lungAssessmentUnderTest.getMessage()).isEqualTo(message);
    }
}
