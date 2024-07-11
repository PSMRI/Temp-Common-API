package com.iemr.common.data.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CovidVaccineTypeTest {

	@InjectMocks
    private CovidVaccineType covidVaccineTypeUnderTest;

    @BeforeEach
    void setUp() {
        covidVaccineTypeUnderTest = new CovidVaccineType();
    }

    @Test
    void testCovidVaccineTypeIDGetterAndSetter() {
        final Integer covidVaccineTypeID = 0;
        covidVaccineTypeUnderTest.setCovidVaccineTypeID(covidVaccineTypeID);
        assertThat(covidVaccineTypeUnderTest.getCovidVaccineTypeID()).isEqualTo(covidVaccineTypeID);
    }

    @Test
    void testVaccineTypeGetterAndSetter() {
        final String vaccineType = "vaccineType";
        covidVaccineTypeUnderTest.setVaccineType(vaccineType);
        assertThat(covidVaccineTypeUnderTest.getVaccineType()).isEqualTo(vaccineType);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        covidVaccineTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(covidVaccineTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        covidVaccineTypeUnderTest.setDeleted(deleted);
        assertThat(covidVaccineTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        covidVaccineTypeUnderTest.setProcessed(processed);
        assertThat(covidVaccineTypeUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        covidVaccineTypeUnderTest.setCreatedBy(createdBy);
        assertThat(covidVaccineTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccineTypeUnderTest.setCreatedDate(createdDate);
        assertThat(covidVaccineTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        covidVaccineTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(covidVaccineTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidVaccineTypeUnderTest.setLastModDate(lastModDate);
        assertThat(covidVaccineTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(covidVaccineTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(covidVaccineTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(covidVaccineTypeUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(covidVaccineTypeUnderTest.toString()).isEqualTo("result");
    }
}
