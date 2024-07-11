package com.iemr.common.data.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CovidVaccinationStatusTest {

	@InjectMocks
    private CovidVaccinationStatus covidVaccinationStatusUnderTest;

    @BeforeEach
    void setUp() {
        covidVaccinationStatusUnderTest = new CovidVaccinationStatus();
    }

    @Test
    void testCovidVSIDGetterAndSetter() {
        final BigInteger covidVSID = new BigInteger("100");
        covidVaccinationStatusUnderTest.setCovidVSID(covidVSID);
        assertThat(covidVaccinationStatusUnderTest.getCovidVSID()).isEqualTo(covidVSID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        covidVaccinationStatusUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(covidVaccinationStatusUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testCovidVaccineTypeIDGetterAndSetter() {
        final Integer covidVaccineTypeID = 0;
        covidVaccinationStatusUnderTest.setCovidVaccineTypeID(covidVaccineTypeID);
        assertThat(covidVaccinationStatusUnderTest.getCovidVaccineTypeID()).isEqualTo(covidVaccineTypeID);
    }

    @Test
    void testDoseTypeIDGetterAndSetter() {
        final Integer doseTypeID = 0;
        covidVaccinationStatusUnderTest.setDoseTypeID(doseTypeID);
        assertThat(covidVaccinationStatusUnderTest.getDoseTypeID()).isEqualTo(doseTypeID);
    }

    @Test
    void testVaccineStatusGetterAndSetter() {
        final String vaccineStatus = "vaccineStatus";
        covidVaccinationStatusUnderTest.setVaccineStatus(vaccineStatus);
        assertThat(covidVaccinationStatusUnderTest.getVaccineStatus()).isEqualTo(vaccineStatus);
    }

    @Test
    void testDose1_DateGetterAndSetter() {
        final Timestamp dose1_Date = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccinationStatusUnderTest.setDose1_Date(dose1_Date);
        assertThat(covidVaccinationStatusUnderTest.getDose1_Date()).isEqualTo(dose1_Date);
    }

    @Test
    void testDose2_DateGetterAndSetter() {
        final Timestamp dose2_Date = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccinationStatusUnderTest.setDose2_Date(dose2_Date);
        assertThat(covidVaccinationStatusUnderTest.getDose2_Date()).isEqualTo(dose2_Date);
    }

    @Test
    void testBooster_DateGetterAndSetter() {
        final Timestamp booster_Date = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccinationStatusUnderTest.setBooster_Date(booster_Date);
        assertThat(covidVaccinationStatusUnderTest.getBooster_Date()).isEqualTo(booster_Date);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        covidVaccinationStatusUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(covidVaccinationStatusUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        covidVaccinationStatusUnderTest.setDeleted(deleted);
        assertThat(covidVaccinationStatusUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        covidVaccinationStatusUnderTest.setProcessed(processed);
        assertThat(covidVaccinationStatusUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        covidVaccinationStatusUnderTest.setCreatedBy(createdBy);
        assertThat(covidVaccinationStatusUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccinationStatusUnderTest.setCreatedDate(createdDate);
        assertThat(covidVaccinationStatusUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        covidVaccinationStatusUnderTest.setModifiedBy(modifiedBy);
        assertThat(covidVaccinationStatusUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccinationStatusUnderTest.setLastModDate(lastModDate);
        assertThat(covidVaccinationStatusUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testVanSerialNoGetterAndSetter() {
        final Integer vanSerialNo = 0;
        covidVaccinationStatusUnderTest.setVanSerialNo(vanSerialNo);
        assertThat(covidVaccinationStatusUnderTest.getVanSerialNo()).isEqualTo(vanSerialNo);
    }

    @Test
    void testVanIDGetterAndSetter() {
        final Integer vanID = 0;
        covidVaccinationStatusUnderTest.setVanID(vanID);
        assertThat(covidVaccinationStatusUnderTest.getVanID()).isEqualTo(vanID);
    }

    @Test
    void testVehicalNoGetterAndSetter() {
        final Integer vehicalNo = 0;
        covidVaccinationStatusUnderTest.setVehicalNo(vehicalNo);
        assertThat(covidVaccinationStatusUnderTest.getVehicalNo()).isEqualTo(vehicalNo);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        covidVaccinationStatusUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(covidVaccinationStatusUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testSyncedByGetterAndSetter() {
        final String syncedBy = "syncedBy";
        covidVaccinationStatusUnderTest.setSyncedBy(syncedBy);
        assertThat(covidVaccinationStatusUnderTest.getSyncedBy()).isEqualTo(syncedBy);
    }

    @Test
    void testSyncedDateGetterAndSetter() {
        final Timestamp syncedDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccinationStatusUnderTest.setSyncedDate(syncedDate);
        assertThat(covidVaccinationStatusUnderTest.getSyncedDate()).isEqualTo(syncedDate);
    }

    @Test
    void testEquals() {
        assertThat(covidVaccinationStatusUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(covidVaccinationStatusUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(covidVaccinationStatusUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(covidVaccinationStatusUnderTest.toString()).isEqualTo("result");
    }
}
