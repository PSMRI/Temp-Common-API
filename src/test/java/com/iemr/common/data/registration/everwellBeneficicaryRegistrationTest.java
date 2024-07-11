package com.iemr.common.data.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class everwellBeneficicaryRegistrationTest {

	@InjectMocks
    private everwellBeneficicaryRegistration everwellBeneficicaryRegistrationUnderTest;

    @BeforeEach
    void setUp() {
        everwellBeneficicaryRegistrationUnderTest = new everwellBeneficicaryRegistration();
    }

    @Test
    void testGetOutboundCall() {
        // Setup
        final everwellBeneficicaryRegistration expectedResult = new everwellBeneficicaryRegistration();
        expectedResult.setId(0L);
        expectedResult.setBeneficiaryRegID(0L);
        expectedResult.setProviderServiceMapID(0);
        expectedResult.setFirstName("FirstName");
        expectedResult.setLastName("LastName");
        expectedResult.setPrimaryNumber("PrimaryNumber");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        // Run the test
        final everwellBeneficicaryRegistration result = everwellBeneficicaryRegistrationUnderTest.getOutboundCall(0L, 0,
                0L, "firstName", "lastName", "primaryNumber",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testEAPIIDGetterAndSetter() {
        final Long eAPIID = 0L;
        everwellBeneficicaryRegistrationUnderTest.setEAPIID(eAPIID);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getEAPIID()).isEqualTo(eAPIID);
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        everwellBeneficicaryRegistrationUnderTest.setId(id);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        everwellBeneficicaryRegistrationUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testCallidGetterAndSetter() {
        final Long callid = 0L;
        everwellBeneficicaryRegistrationUnderTest.setCallid(callid);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getCallid()).isEqualTo(callid);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        everwellBeneficicaryRegistrationUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "FirstName";
        everwellBeneficicaryRegistrationUnderTest.setFirstName(firstName);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "LastName";
        everwellBeneficicaryRegistrationUnderTest.setLastName(lastName);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "Gender";
        everwellBeneficicaryRegistrationUnderTest.setGender(gender);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testPrimaryNumberGetterAndSetter() {
        final String primaryNumber = "PrimaryNumber";
        everwellBeneficicaryRegistrationUnderTest.setPrimaryNumber(primaryNumber);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getPrimaryNumber()).isEqualTo(primaryNumber);
    }

    @Test
    void testMissedDosesGetterAndSetter() {
        final Integer missedDoses = 0;
        everwellBeneficicaryRegistrationUnderTest.setMissedDoses(missedDoses);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getMissedDoses()).isEqualTo(missedDoses);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "FacilityName";
        everwellBeneficicaryRegistrationUnderTest.setFacilityName(facilityName);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "State";
        everwellBeneficicaryRegistrationUnderTest.setState(state);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final String district = "District";
        everwellBeneficicaryRegistrationUnderTest.setDistrict(district);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testAdherencePercentageGetterAndSetter() {
        final Integer adherencePercentage = 0;
        everwellBeneficicaryRegistrationUnderTest.setAdherencePercentage(adherencePercentage);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getAdherencePercentage()).isEqualTo(adherencePercentage);
    }

    @Test
    void testIsRegisteredGetterAndSetter() {
        final Boolean isRegistered = false;
        everwellBeneficicaryRegistrationUnderTest.setIsRegistered(isRegistered);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getIsRegistered()).isFalse();
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final Integer agentID = 0;
        everwellBeneficicaryRegistrationUnderTest.setAgentID(agentID);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testIsAllocatedGetterAndSetter() {
        final Boolean isAllocated = false;
        everwellBeneficicaryRegistrationUnderTest.setIsAllocated(isAllocated);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getIsAllocated()).isFalse();
    }

    @Test
    void testActionTakenGetterAndSetter() {
        final String actionTaken = "ActionTaken";
        everwellBeneficicaryRegistrationUnderTest.setActionTaken(actionTaken);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getActionTaken()).isEqualTo(actionTaken);
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "Category";
        everwellBeneficicaryRegistrationUnderTest.setCategory(category);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testSubCategoryGetterAndSetter() {
        final String subCategory = "SubCategory";
        everwellBeneficicaryRegistrationUnderTest.setSubCategory(subCategory);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getSubCategory()).isEqualTo(subCategory);
    }

    @Test
    void testDateOfActionGetterAndSetter() {
        final String dateOfAction = "DateOfAction";
        everwellBeneficicaryRegistrationUnderTest.setDateOfAction(dateOfAction);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getDateOfAction()).isEqualTo(dateOfAction);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "Comments";
        everwellBeneficicaryRegistrationUnderTest.setComments(comments);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testStatusUpdatedEverwellGetterAndSetter() {
        final Boolean statusUpdatedEverwell = false;
        everwellBeneficicaryRegistrationUnderTest.setStatusUpdatedEverwell(statusUpdatedEverwell);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getStatusUpdatedEverwell()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        everwellBeneficicaryRegistrationUnderTest.setDeleted(deleted);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final Character processed = 'a';
        everwellBeneficicaryRegistrationUnderTest.setProcessed(processed);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        everwellBeneficicaryRegistrationUnderTest.setCreatedBy(createdBy);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellBeneficicaryRegistrationUnderTest.setCreatedDate(createdDate);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        everwellBeneficicaryRegistrationUnderTest.setModifiedBy(modifiedBy);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellBeneficicaryRegistrationUnderTest.setLastModDate(lastModDate);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testVanSerialNoGetterAndSetter() {
        final Integer vanSerialNo = 0;
        everwellBeneficicaryRegistrationUnderTest.setVanSerialNo(vanSerialNo);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getVanSerialNo()).isEqualTo(vanSerialNo);
    }

    @Test
    void testVanIDGetterAndSetter() {
        final Integer vanID = 0;
        everwellBeneficicaryRegistrationUnderTest.setVanID(vanID);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getVanID()).isEqualTo(vanID);
    }

    @Test
    void testVehicalNoGetterAndSetter() {
        final String vehicalNo = "VehicalNo";
        everwellBeneficicaryRegistrationUnderTest.setVehicalNo(vehicalNo);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getVehicalNo()).isEqualTo(vehicalNo);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        everwellBeneficicaryRegistrationUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testSyncedByGetterAndSetter() {
        final String syncedBy = "syncedBy";
        everwellBeneficicaryRegistrationUnderTest.setSyncedBy(syncedBy);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getSyncedBy()).isEqualTo(syncedBy);
    }

    @Test
    void testSyncedDateGetterAndSetter() {
        final Timestamp syncedDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellBeneficicaryRegistrationUnderTest.setSyncedDate(syncedDate);
        assertThat(everwellBeneficicaryRegistrationUnderTest.getSyncedDate()).isEqualTo(syncedDate);
    }

    @Test
    void testEquals() {
        assertThat(everwellBeneficicaryRegistrationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(everwellBeneficicaryRegistrationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(everwellBeneficicaryRegistrationUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(everwellBeneficicaryRegistrationUnderTest.toString()).isEqualTo("result");
    }
}
