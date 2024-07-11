package com.iemr.common.data.helpline104history;

import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
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
class T_FoodSafetyCopmlaintTest {

	@InjectMocks
    private T_FoodSafetyCopmlaint tFoodSafetyCopmlaintUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        tFoodSafetyCopmlaintUnderTest = new T_FoodSafetyCopmlaint();
    }

    @Test
    void testToString() throws Exception {
        assertThat(tFoodSafetyCopmlaintUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFSComplaintIDGetterAndSetter() {
        final Long fSComplaintID = 0L;
        tFoodSafetyCopmlaintUnderTest.setFSComplaintID(fSComplaintID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getFSComplaintID()).isEqualTo(fSComplaintID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        tFoodSafetyCopmlaintUnderTest.setRequestID(requestID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        tFoodSafetyCopmlaintUnderTest.setBenCallID(benCallID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        tFoodSafetyCopmlaintUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testTypeOfRequestGetterAndSetter() {
        final String typeOfRequest = "typeOfRequest";
        tFoodSafetyCopmlaintUnderTest.setTypeOfRequest(typeOfRequest);
        assertThat(tFoodSafetyCopmlaintUnderTest.getTypeOfRequest()).isEqualTo(typeOfRequest);
    }

    @Test
    void testIsDiarrheaGetterAndSetter() {
        final Byte isDiarrhea = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsDiarrhea(isDiarrhea);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsDiarrhea()).isEqualTo(isDiarrhea);
    }

    @Test
    void testIsVomitingGetterAndSetter() {
        final Byte isVomiting = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsVomiting(isVomiting);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsVomiting()).isEqualTo(isVomiting);
    }

    @Test
    void testIsAbdominalPainGetterAndSetter() {
        final Byte isAbdominalPain = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsAbdominalPain(isAbdominalPain);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsAbdominalPain()).isEqualTo(isAbdominalPain);
    }

    @Test
    void testIsChillsOrRigorsGetterAndSetter() {
        final Byte isChillsOrRigors = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsChillsOrRigors(isChillsOrRigors);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsChillsOrRigors()).isEqualTo(isChillsOrRigors);
    }

    @Test
    void testIsGiddinessGetterAndSetter() {
        final Byte isGiddiness = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsGiddiness(isGiddiness);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsGiddiness()).isEqualTo(isGiddiness);
    }

    @Test
    void testIsDehydrationGetterAndSetter() {
        final Byte isDehydration = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsDehydration(isDehydration);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsDehydration()).isEqualTo(isDehydration);
    }

    @Test
    void testIsRashesGetterAndSetter() {
        final Byte isRashes = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsRashes(isRashes);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsRashes()).isEqualTo(isRashes);
    }

    @Test
    void testFromWhenGetterAndSetter() {
        final Timestamp fromWhen = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tFoodSafetyCopmlaintUnderTest.setFromWhen(fromWhen);
        assertThat(tFoodSafetyCopmlaintUnderTest.getFromWhen()).isEqualTo(fromWhen);
    }

    @Test
    void testHistoryOfDietGetterAndSetter() {
        final String historyOfDiet = "historyOfDiet";
        tFoodSafetyCopmlaintUnderTest.setHistoryOfDiet(historyOfDiet);
        assertThat(tFoodSafetyCopmlaintUnderTest.getHistoryOfDiet()).isEqualTo(historyOfDiet);
    }

    @Test
    void testIsFoodConsumedGetterAndSetter() {
        final Byte isFoodConsumed = (byte) 0b0;
        tFoodSafetyCopmlaintUnderTest.setIsFoodConsumed(isFoodConsumed);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsFoodConsumed()).isEqualTo(isFoodConsumed);
    }

    @Test
    void testTypeOfFoodGetterAndSetter() {
        final String typeOfFood = "typeOfFood";
        tFoodSafetyCopmlaintUnderTest.setTypeOfFood(typeOfFood);
        assertThat(tFoodSafetyCopmlaintUnderTest.getTypeOfFood()).isEqualTo(typeOfFood);
    }

    @Test
    void testFoodConsumedFromGetterAndSetter() {
        final String foodConsumedFrom = "foodConsumedFrom";
        tFoodSafetyCopmlaintUnderTest.setFoodConsumedFrom(foodConsumedFrom);
        assertThat(tFoodSafetyCopmlaintUnderTest.getFoodConsumedFrom()).isEqualTo(foodConsumedFrom);
    }

    @Test
    void testAssociatedSymptomsGetterAndSetter() {
        final String associatedSymptoms = "associatedSymptoms";
        tFoodSafetyCopmlaintUnderTest.setAssociatedSymptoms(associatedSymptoms);
        assertThat(tFoodSafetyCopmlaintUnderTest.getAssociatedSymptoms()).isEqualTo(associatedSymptoms);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        tFoodSafetyCopmlaintUnderTest.setDistrictID(districtID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final Districts district = new Districts(0, "DistrictName", 0, "stateName");
        tFoodSafetyCopmlaintUnderTest.setDistrict(district);
        assertThat(tFoodSafetyCopmlaintUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testDistrictBlockIDGetterAndSetter() {
        final Integer districtBlockID = 0;
        tFoodSafetyCopmlaintUnderTest.setDistrictBlockID(districtBlockID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getDistrictBlockID()).isEqualTo(districtBlockID);
    }

    @Test
    void testDistrictBlockGetterAndSetter() {
        final DistrictBlock districtBlock = new DistrictBlock(0, "BlockName");
        tFoodSafetyCopmlaintUnderTest.setDistrictBlock(districtBlock);
        assertThat(tFoodSafetyCopmlaintUnderTest.getDistrictBlock()).isEqualTo(districtBlock);
    }

    @Test
    void testVillageIDGetterAndSetter() {
        final Integer villageID = 0;
        tFoodSafetyCopmlaintUnderTest.setVillageID(villageID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getVillageID()).isEqualTo(villageID);
    }

    @Test
    void testDistrictBranchMappingGetterAndSetter() {
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping(0, "VillageName", "PanchayatName",
                "Habitat", "PinCode");
        tFoodSafetyCopmlaintUnderTest.setDistrictBranchMapping(districtBranchMapping);
        assertThat(tFoodSafetyCopmlaintUnderTest.getDistrictBranchMapping()).isEqualTo(districtBranchMapping);
    }

    @Test
    void testFeedbackTypeIDGetterAndSetter() {
        final Short feedbackTypeID = (short) 0;
        tFoodSafetyCopmlaintUnderTest.setFeedbackTypeID(feedbackTypeID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getFeedbackTypeID()).isEqualTo(feedbackTypeID);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        tFoodSafetyCopmlaintUnderTest.setRemarks(remarks);
        assertThat(tFoodSafetyCopmlaintUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Integer serviceID = 0;
        tFoodSafetyCopmlaintUnderTest.setServiceID(serviceID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testIsSelfGetterAndSetter() {
        final Boolean isSelf = false;
        tFoodSafetyCopmlaintUnderTest.setIsSelf(isSelf);
        assertThat(tFoodSafetyCopmlaintUnderTest.getIsSelf()).isFalse();
    }

    @Test
    void testPatientNameGetterAndSetter() {
        final String patientName = "patientName";
        tFoodSafetyCopmlaintUnderTest.setPatientName(patientName);
        assertThat(tFoodSafetyCopmlaintUnderTest.getPatientName()).isEqualTo(patientName);
    }

    @Test
    void testPatientAgeGetterAndSetter() {
        final Integer patientAge = 0;
        tFoodSafetyCopmlaintUnderTest.setPatientAge(patientAge);
        assertThat(tFoodSafetyCopmlaintUnderTest.getPatientAge()).isEqualTo(patientAge);
    }

    @Test
    void testPatientGenderIDGetterAndSetter() {
        final Short patientGenderID = (short) 0;
        tFoodSafetyCopmlaintUnderTest.setPatientGenderID(patientGenderID);
        assertThat(tFoodSafetyCopmlaintUnderTest.getPatientGenderID()).isEqualTo(patientGenderID);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        tFoodSafetyCopmlaintUnderTest.setDeleted(deleted);
        assertThat(tFoodSafetyCopmlaintUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        tFoodSafetyCopmlaintUnderTest.setCreatedBy(createdBy);
        assertThat(tFoodSafetyCopmlaintUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        tFoodSafetyCopmlaintUnderTest.setCreatedDate(createdDate);
        assertThat(tFoodSafetyCopmlaintUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        tFoodSafetyCopmlaintUnderTest.setModifiedBy(modifiedBy);
        assertThat(tFoodSafetyCopmlaintUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        tFoodSafetyCopmlaintUnderTest.setLastModDate(lastModDate);
        assertThat(tFoodSafetyCopmlaintUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(tFoodSafetyCopmlaintUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(tFoodSafetyCopmlaintUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(tFoodSafetyCopmlaintUnderTest.hashCode()).isEqualTo(0);
    }
}
