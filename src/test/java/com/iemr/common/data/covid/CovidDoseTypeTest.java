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
class CovidDoseTypeTest {

	@InjectMocks
    private CovidDoseType covidDoseTypeUnderTest;

    @BeforeEach
    void setUp() {
        covidDoseTypeUnderTest = new CovidDoseType();
    }

    @Test
    void testCovidDoseTypeIDGetterAndSetter() {
        final Integer covidDoseTypeID = 0;
        covidDoseTypeUnderTest.setCovidDoseTypeID(covidDoseTypeID);
        assertThat(covidDoseTypeUnderTest.getCovidDoseTypeID()).isEqualTo(covidDoseTypeID);
    }

    @Test
    void testDoseTypeGetterAndSetter() {
        final String doseType = "doseType";
        covidDoseTypeUnderTest.setDoseType(doseType);
        assertThat(covidDoseTypeUnderTest.getDoseType()).isEqualTo(doseType);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        covidDoseTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(covidDoseTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        covidDoseTypeUnderTest.setDeleted(deleted);
        assertThat(covidDoseTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        covidDoseTypeUnderTest.setProcessed(processed);
        assertThat(covidDoseTypeUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        covidDoseTypeUnderTest.setCreatedBy(createdBy);
        assertThat(covidDoseTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidDoseTypeUnderTest.setCreatedDate(createdDate);
        assertThat(covidDoseTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        covidDoseTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(covidDoseTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidDoseTypeUnderTest.setLastModDate(lastModDate);
        assertThat(covidDoseTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(covidDoseTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(covidDoseTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(covidDoseTypeUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(covidDoseTypeUnderTest.toString()).isEqualTo("result");
    }
}
