package com.iemr.common.data.facility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FacilityTest {

	@InjectMocks
    private Facility facilityUnderTest;

    @BeforeEach
    void setUp() {
        facilityUnderTest = new Facility(0, "facilityName", "facilityDesc", "facilityCode", 0, 0, false, 0, 0,
                "eAusadhaFacilityId", false, "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                "modifiedBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testFacilityIdGetterAndSetter() {
        final Integer facilityId = 0;
        facilityUnderTest.setFacilityId(facilityId);
        assertThat(facilityUnderTest.getFacilityId()).isEqualTo(facilityId);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "facilityName";
        facilityUnderTest.setFacilityName(facilityName);
        assertThat(facilityUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testFacilityDescGetterAndSetter() {
        final String facilityDesc = "facilityDesc";
        facilityUnderTest.setFacilityDesc(facilityDesc);
        assertThat(facilityUnderTest.getFacilityDesc()).isEqualTo(facilityDesc);
    }

    @Test
    void testFacilityCodeGetterAndSetter() {
        final String facilityCode = "facilityCode";
        facilityUnderTest.setFacilityCode(facilityCode);
        assertThat(facilityUnderTest.getFacilityCode()).isEqualTo(facilityCode);
    }

    @Test
    void testFaciliyTypeIdGetterAndSetter() {
        final Integer faciliyTypeId = 0;
        facilityUnderTest.setFaciliyTypeId(faciliyTypeId);
        assertThat(facilityUnderTest.getFaciliyTypeId()).isEqualTo(faciliyTypeId);
    }

    @Test
    void testProviderServiceMapIdGetterAndSetter() {
        final Integer providerServiceMapId = 0;
        facilityUnderTest.setProviderServiceMapId(providerServiceMapId);
        assertThat(facilityUnderTest.getProviderServiceMapId()).isEqualTo(providerServiceMapId);
    }

    @Test
    void testIsMainFacilityGetterAndSetter() {
        final Boolean isMainFacility = false;
        facilityUnderTest.setIsMainFacility(isMainFacility);
        assertThat(facilityUnderTest.getIsMainFacility()).isFalse();
    }

    @Test
    void testMainFacilityIdGetterAndSetter() {
        final Integer mainFacilityId = 0;
        facilityUnderTest.setMainFacilityId(mainFacilityId);
        assertThat(facilityUnderTest.getMainFacilityId()).isEqualTo(mainFacilityId);
    }

    @Test
    void testEAusadhiFacilityIdGetterAndSetter() {
        final Integer eAusadhiFacilityId = 0;
        facilityUnderTest.setEAusadhiFacilityId(eAusadhiFacilityId);
        assertThat(facilityUnderTest.getEAusadhiFacilityId()).isEqualTo(eAusadhiFacilityId);
    }

    @Test
    void testEAusadhaFacilityIdGetterAndSetter() {
        final String eAusadhaFacilityId = "eAusadhaFacilityId";
        facilityUnderTest.setEAusadhaFacilityId(eAusadhaFacilityId);
        assertThat(facilityUnderTest.getEAusadhaFacilityId()).isEqualTo(eAusadhaFacilityId);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        facilityUnderTest.setDeleted(deleted);
        assertThat(facilityUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        facilityUnderTest.setCreatedBy(createdBy);
        assertThat(facilityUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        facilityUnderTest.setCreatedDate(createdDate);
        assertThat(facilityUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        facilityUnderTest.setModifiedBy(modifiedBy);
        assertThat(facilityUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        facilityUnderTest.setLastModDate(lastModDate);
        assertThat(facilityUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(facilityUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(facilityUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(facilityUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(facilityUnderTest.toString()).isEqualTo("result");
    }
}
