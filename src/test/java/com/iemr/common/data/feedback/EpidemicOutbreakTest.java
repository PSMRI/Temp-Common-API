package com.iemr.common.data.feedback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class EpidemicOutbreakTest {

    private EpidemicOutbreak epidemicOutbreakUnderTest;

    @BeforeEach
    void setUp() {
        epidemicOutbreakUnderTest = new EpidemicOutbreak();
    }

    @Test
    void testOutbreakComplaintIDGetterAndSetter() {
        final Long outbreakComplaintID = 0L;
        epidemicOutbreakUnderTest.setOutbreakComplaintID(outbreakComplaintID);
        assertThat(epidemicOutbreakUnderTest.getOutbreakComplaintID()).isEqualTo(outbreakComplaintID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        epidemicOutbreakUnderTest.setRequestID(requestID);
        assertThat(epidemicOutbreakUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        epidemicOutbreakUnderTest.setBenCallID(benCallID);
        assertThat(epidemicOutbreakUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        epidemicOutbreakUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(epidemicOutbreakUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testNatureOfComplaintGetterAndSetter() {
        final String natureOfComplaint = "natureOfComplaint";
        epidemicOutbreakUnderTest.setNatureOfComplaint(natureOfComplaint);
        assertThat(epidemicOutbreakUnderTest.getNatureOfComplaint()).isEqualTo(natureOfComplaint);
    }

    @Test
    void testTotalPeopleAffectedGetterAndSetter() {
        final Integer totalPeopleAffected = 0;
        epidemicOutbreakUnderTest.setTotalPeopleAffected(totalPeopleAffected);
        assertThat(epidemicOutbreakUnderTest.getTotalPeopleAffected()).isEqualTo(totalPeopleAffected);
    }

    @Test
    void testAffectedDistrictIDGetterAndSetter() {
        final Integer affectedDistrictID = 0;
        epidemicOutbreakUnderTest.setAffectedDistrictID(affectedDistrictID);
        assertThat(epidemicOutbreakUnderTest.getAffectedDistrictID()).isEqualTo(affectedDistrictID);
    }

    @Test
    void testAffectedDistrictBlockIDGetterAndSetter() {
        final Integer affectedDistrictBlockID = 0;
        epidemicOutbreakUnderTest.setAffectedDistrictBlockID(affectedDistrictBlockID);
        assertThat(epidemicOutbreakUnderTest.getAffectedDistrictBlockID()).isEqualTo(affectedDistrictBlockID);
    }

    @Test
    void testAffectedVillageIDGetterAndSetter() {
        final Integer affectedVillageID = 0;
        epidemicOutbreakUnderTest.setAffectedVillageID(affectedVillageID);
        assertThat(epidemicOutbreakUnderTest.getAffectedVillageID()).isEqualTo(affectedVillageID);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Integer serviceID = 0;
        epidemicOutbreakUnderTest.setServiceID(serviceID);
        assertThat(epidemicOutbreakUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        epidemicOutbreakUnderTest.setRemarks(remarks);
        assertThat(epidemicOutbreakUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        epidemicOutbreakUnderTest.setDeleted(deleted);
        assertThat(epidemicOutbreakUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        epidemicOutbreakUnderTest.setCreatedBy(createdBy);
        assertThat(epidemicOutbreakUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        epidemicOutbreakUnderTest.setModifiedBy(modifiedBy);
        assertThat(epidemicOutbreakUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        epidemicOutbreakUnderTest.setCreatedDate(createdDate);
        assertThat(epidemicOutbreakUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testEquals() {
        assertThat(epidemicOutbreakUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(epidemicOutbreakUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(epidemicOutbreakUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(epidemicOutbreakUnderTest.toString()).isEqualTo("result");
    }
}
