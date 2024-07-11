package com.iemr.common.data.uptsu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class T_104AppointmentDetailsTest {

	@InjectMocks
    private T_104AppointmentDetails t104AppointmentDetailsUnderTest;

    @BeforeEach
    void setUp() {
        t104AppointmentDetailsUnderTest = new T_104AppointmentDetails(0, "blockName", "facilityName", "facilityCode",
                "employeeCode", "choName", "hfrId", "facilityPhoneNo",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, "alternateMobNo", false, 0, false,
                "processed", "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testIdGetterAndSetter() {
        final Integer id = 0;
        t104AppointmentDetailsUnderTest.setId(id);
        assertThat(t104AppointmentDetailsUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testBlockNameGetterAndSetter() {
        final String blockName = "blockName";
        t104AppointmentDetailsUnderTest.setBlockName(blockName);
        assertThat(t104AppointmentDetailsUnderTest.getBlockName()).isEqualTo(blockName);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "facilityName";
        t104AppointmentDetailsUnderTest.setFacilityName(facilityName);
        assertThat(t104AppointmentDetailsUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testFacilityCodeGetterAndSetter() {
        final String facilityCode = "facilityCode";
        t104AppointmentDetailsUnderTest.setFacilityCode(facilityCode);
        assertThat(t104AppointmentDetailsUnderTest.getFacilityCode()).isEqualTo(facilityCode);
    }

    @Test
    void testEmployeeCodeGetterAndSetter() {
        final String employeeCode = "employeeCode";
        t104AppointmentDetailsUnderTest.setEmployeeCode(employeeCode);
        assertThat(t104AppointmentDetailsUnderTest.getEmployeeCode()).isEqualTo(employeeCode);
    }

    @Test
    void testChoNameGetterAndSetter() {
        final String choName = "choName";
        t104AppointmentDetailsUnderTest.setChoName(choName);
        assertThat(t104AppointmentDetailsUnderTest.getChoName()).isEqualTo(choName);
    }

    @Test
    void testHfrIdGetterAndSetter() {
        final String hfrId = "hfrId";
        t104AppointmentDetailsUnderTest.setHfrId(hfrId);
        assertThat(t104AppointmentDetailsUnderTest.getHfrId()).isEqualTo(hfrId);
    }

    @Test
    void testFacilityPhoneNoGetterAndSetter() {
        final String facilityPhoneNo = "facilityPhoneNo";
        t104AppointmentDetailsUnderTest.setFacilityPhoneNo(facilityPhoneNo);
        assertThat(t104AppointmentDetailsUnderTest.getFacilityPhoneNo()).isEqualTo(facilityPhoneNo);
    }

    @Test
    void testAppointmentDateGetterAndSetter() {
        final Timestamp appointmentDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        t104AppointmentDetailsUnderTest.setAppointmentDate(appointmentDate);
        assertThat(t104AppointmentDetailsUnderTest.getAppointmentDate()).isEqualTo(appointmentDate);
    }

    @Test
    void testBenRegIdGetterAndSetter() {
        final Long benRegId = 0L;
        t104AppointmentDetailsUnderTest.setBenRegId(benRegId);
        assertThat(t104AppointmentDetailsUnderTest.getBenRegId()).isEqualTo(benRegId);
    }

    @Test
    void testBenCallIdGetterAndSetter() {
        final Long benCallId = 0L;
        t104AppointmentDetailsUnderTest.setBenCallId(benCallId);
        assertThat(t104AppointmentDetailsUnderTest.getBenCallId()).isEqualTo(benCallId);
    }

    @Test
    void testAlternateMobNoGetterAndSetter() {
        final String alternateMobNo = "alternateMobNo";
        t104AppointmentDetailsUnderTest.setAlternateMobNo(alternateMobNo);
        assertThat(t104AppointmentDetailsUnderTest.getAlternateMobNo()).isEqualTo(alternateMobNo);
    }

    @Test
    void testRefferedFlagGetterAndSetter() {
        final Boolean refferedFlag = false;
        t104AppointmentDetailsUnderTest.setRefferedFlag(refferedFlag);
        assertThat(t104AppointmentDetailsUnderTest.getRefferedFlag()).isFalse();
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        t104AppointmentDetailsUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(t104AppointmentDetailsUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        t104AppointmentDetailsUnderTest.setDeleted(deleted);
        assertThat(t104AppointmentDetailsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        t104AppointmentDetailsUnderTest.setProcessed(processed);
        assertThat(t104AppointmentDetailsUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        t104AppointmentDetailsUnderTest.setCreatedBy(createdBy);
        assertThat(t104AppointmentDetailsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        t104AppointmentDetailsUnderTest.setCreatedDate(createdDate);
        assertThat(t104AppointmentDetailsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        t104AppointmentDetailsUnderTest.setModifiedBy(modifiedBy);
        assertThat(t104AppointmentDetailsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        t104AppointmentDetailsUnderTest.setLastModDate(lastModDate);
        assertThat(t104AppointmentDetailsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(t104AppointmentDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(t104AppointmentDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(t104AppointmentDetailsUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(t104AppointmentDetailsUnderTest.toString()).isEqualTo("result");
    }
}
