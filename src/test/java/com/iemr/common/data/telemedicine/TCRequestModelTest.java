package com.iemr.common.data.telemedicine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TCRequestModelTest {

	@InjectMocks
    private TCRequestModel tcRequestModelUnderTest;

    @BeforeEach
    void setUp() {
        tcRequestModelUnderTest = new TCRequestModel();
    }

    @Test
    void testTMRequestIDGetterAndSetter() {
        final Long tMRequestID = 0L;
        tcRequestModelUnderTest.settMRequestID(tMRequestID);
        assertThat(tcRequestModelUnderTest.gettMRequestID()).isEqualTo(tMRequestID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        tcRequestModelUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(tcRequestModelUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenVisitIDGetterAndSetter() {
        final Long benVisitID = 0L;
        tcRequestModelUnderTest.setBenVisitID(benVisitID);
        assertThat(tcRequestModelUnderTest.getBenVisitID()).isEqualTo(benVisitID);
    }

    @Test
    void testVisitCodeGetterAndSetter() {
        final Long visitCode = 0L;
        tcRequestModelUnderTest.setVisitCode(visitCode);
        assertThat(tcRequestModelUnderTest.getVisitCode()).isEqualTo(visitCode);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        tcRequestModelUnderTest.setUserID(userID);
        assertThat(tcRequestModelUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testRequestDateGetterAndSetter() {
        final Timestamp requestDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tcRequestModelUnderTest.setRequestDate(requestDate);
        assertThat(tcRequestModelUnderTest.getRequestDate()).isEqualTo(requestDate);
    }

    @Test
    void testDuration_minuteGetterAndSetter() {
        final Long duration_minute = 0L;
        tcRequestModelUnderTest.setDuration_minute(duration_minute);
        assertThat(tcRequestModelUnderTest.getDuration_minute()).isEqualTo(duration_minute);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        tcRequestModelUnderTest.setStatus(status);
        assertThat(tcRequestModelUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testConsultationStatsGetterAndSetter() {
        final String consultationStats = "consultationStats";
        tcRequestModelUnderTest.setConsultationStats(consultationStats);
        assertThat(tcRequestModelUnderTest.getConsultationStats()).isEqualTo(consultationStats);
    }

    @Test
    void testBeneficiaryArrivalTimeGetterAndSetter() {
        final Timestamp beneficiaryArrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tcRequestModelUnderTest.setBeneficiaryArrivalTime(beneficiaryArrivalTime);
        assertThat(tcRequestModelUnderTest.getBeneficiaryArrivalTime()).isEqualTo(beneficiaryArrivalTime);
    }

    @Test
    void testConsultation_FirstStartGetterAndSetter() {
        final Timestamp consultation_FirstStart = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tcRequestModelUnderTest.setConsultation_FirstStart(consultation_FirstStart);
        assertThat(tcRequestModelUnderTest.getConsultation_FirstStart()).isEqualTo(consultation_FirstStart);
    }

    @Test
    void testConsultation_LastEndGetterAndSetter() {
        final Timestamp consultation_LastEnd = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tcRequestModelUnderTest.setConsultation_LastEnd(consultation_LastEnd);
        assertThat(tcRequestModelUnderTest.getConsultation_LastEnd()).isEqualTo(consultation_LastEnd);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        tcRequestModelUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(tcRequestModelUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        tcRequestModelUnderTest.setDeleted(deleted);
        assertThat(tcRequestModelUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        tcRequestModelUnderTest.setProcessed(processed);
        assertThat(tcRequestModelUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        tcRequestModelUnderTest.setCreatedBy(createdBy);
        assertThat(tcRequestModelUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tcRequestModelUnderTest.setCreatedDate(createdDate);
        assertThat(tcRequestModelUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        tcRequestModelUnderTest.setModifiedBy(modifiedBy);
        assertThat(tcRequestModelUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tcRequestModelUnderTest.setLastModDate(lastModDate);
        assertThat(tcRequestModelUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testSpecializationIDGetterAndSetter() {
        final Integer specializationID = 0;
        tcRequestModelUnderTest.setSpecializationID(specializationID);
        assertThat(tcRequestModelUnderTest.getSpecializationID()).isEqualTo(specializationID);
    }
}
