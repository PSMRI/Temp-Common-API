package com.iemr.common.data.feedback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class BalVivahComplaintTest {

    private BalVivahComplaint balVivahComplaintUnderTest;

    @BeforeEach
    void setUp() {
        balVivahComplaintUnderTest = new BalVivahComplaint();
    }

    @Test
    void testBalVivaComplaintIDGetterAndSetter() {
        final Long balVivaComplaintID = 0L;
        balVivahComplaintUnderTest.setBalVivaComplaintID(balVivaComplaintID);
        assertThat(balVivahComplaintUnderTest.getBalVivaComplaintID()).isEqualTo(balVivaComplaintID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        balVivahComplaintUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(balVivahComplaintUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        balVivahComplaintUnderTest.setBenCallID(benCallID);
        assertThat(balVivahComplaintUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testSubjectOfComplaintGetterAndSetter() {
        final String subjectOfComplaint = "subjectOfComplaint";
        balVivahComplaintUnderTest.setSubjectOfComplaint(subjectOfComplaint);
        assertThat(balVivahComplaintUnderTest.getSubjectOfComplaint()).isEqualTo(subjectOfComplaint);
    }

    @Test
    void testChildNameGetterAndSetter() {
        final String childName = "childName";
        balVivahComplaintUnderTest.setChildName(childName);
        assertThat(balVivahComplaintUnderTest.getChildName()).isEqualTo(childName);
    }

    @Test
    void testChildFatherNameGetterAndSetter() {
        final String childFatherName = "childFatherName";
        balVivahComplaintUnderTest.setChildFatherName(childFatherName);
        assertThat(balVivahComplaintUnderTest.getChildFatherName()).isEqualTo(childFatherName);
    }

    @Test
    void testChildAgeGetterAndSetter() {
        final String childAge = "childAge";
        balVivahComplaintUnderTest.setChildAge(childAge);
        assertThat(balVivahComplaintUnderTest.getChildAge()).isEqualTo(childAge);
    }

    @Test
    void testChildGenderGetterAndSetter() {
        final Short childGender = (short) 0;
        balVivahComplaintUnderTest.setChildGender(childGender);
        assertThat(balVivahComplaintUnderTest.getChildGender()).isEqualTo(childGender);
    }

    @Test
    void testChildStateGetterAndSetter() {
        final Integer childState = 0;
        balVivahComplaintUnderTest.setChildState(childState);
        assertThat(balVivahComplaintUnderTest.getChildState()).isEqualTo(childState);
    }

    @Test
    void testChildFatherStateGetterAndSetter() {
        final String childFatherState = "childFatherState";
        balVivahComplaintUnderTest.setChildFatherState(childFatherState);
        assertThat(balVivahComplaintUnderTest.getChildFatherState()).isEqualTo(childFatherState);
    }

    @Test
    void testChildDistrictGetterAndSetter() {
        final Integer childDistrict = 0;
        balVivahComplaintUnderTest.setChildDistrict(childDistrict);
        assertThat(balVivahComplaintUnderTest.getChildDistrict()).isEqualTo(childDistrict);
    }

    @Test
    void testChildFatherDistrictGetterAndSetter() {
        final String childFatherDistrict = "childFatherDistrict";
        balVivahComplaintUnderTest.setChildFatherDistrict(childFatherDistrict);
        assertThat(balVivahComplaintUnderTest.getChildFatherDistrict()).isEqualTo(childFatherDistrict);
    }

    @Test
    void testChildSubDistrictGetterAndSetter() {
        final String childSubDistrict = "childSubDistrict";
        balVivahComplaintUnderTest.setChildSubDistrict(childSubDistrict);
        assertThat(balVivahComplaintUnderTest.getChildSubDistrict()).isEqualTo(childSubDistrict);
    }

    @Test
    void testChildFatherSubDistrictGetterAndSetter() {
        final String childFatherSubDistrict = "childFatherSubDistrict";
        balVivahComplaintUnderTest.setChildFatherSubDistrict(childFatherSubDistrict);
        assertThat(balVivahComplaintUnderTest.getChildFatherSubDistrict()).isEqualTo(childFatherSubDistrict);
    }

    @Test
    void testChildVillageGetterAndSetter() {
        final Integer childVillage = 0;
        balVivahComplaintUnderTest.setChildVillage(childVillage);
        assertThat(balVivahComplaintUnderTest.getChildVillage()).isEqualTo(childVillage);
    }

    @Test
    void testChildFatherVillageGetterAndSetter() {
        final String childFatherVillage = "childFatherVillage";
        balVivahComplaintUnderTest.setChildFatherVillage(childFatherVillage);
        assertThat(balVivahComplaintUnderTest.getChildFatherVillage()).isEqualTo(childFatherVillage);
    }

    @Test
    void testMarriageDateGetterAndSetter() {
        final Date marriageDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        balVivahComplaintUnderTest.setMarriageDate(marriageDate);
        assertThat(balVivahComplaintUnderTest.getMarriageDate()).isEqualTo(marriageDate);
    }

    @Test
    void testComplaintDateGetterAndSetter() {
        final Timestamp complaintDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        balVivahComplaintUnderTest.setComplaintDate(complaintDate);
        assertThat(balVivahComplaintUnderTest.getComplaintDate()).isEqualTo(complaintDate);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        balVivahComplaintUnderTest.setRequestID(requestID);
        assertThat(balVivahComplaintUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        balVivahComplaintUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(balVivahComplaintUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        balVivahComplaintUnderTest.setDeleted(deleted);
        assertThat(balVivahComplaintUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        balVivahComplaintUnderTest.setCreatedBy(createdBy);
        assertThat(balVivahComplaintUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        balVivahComplaintUnderTest.setCreatedDate(createdDate);
        assertThat(balVivahComplaintUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testEquals() {
        assertThat(balVivahComplaintUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(balVivahComplaintUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(balVivahComplaintUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(balVivahComplaintUnderTest.toString()).isEqualTo("result");
    }
}
