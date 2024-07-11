package com.iemr.common.data.everwell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EverwellDetailsTest {

	@InjectMocks
    private EverwellDetails everwellDetailsUnderTest;

    @BeforeEach
    void setUp() {
        everwellDetailsUnderTest = new EverwellDetails();
    }

    @Test
    void testGetOutboundCall() {
        // Setup
        final EverwellDetails expectedResult = new EverwellDetails();
        expectedResult.setEapiId(0L);
        expectedResult.setId(0L);
        expectedResult.setBeneficiaryRegId(0L);
        expectedResult.setProviderServiceMapId(0);
        expectedResult.setFirstName("FirstName");
        expectedResult.setLastName("LastName");
        expectedResult.setPrimaryNumber("PrimaryNumber");
        expectedResult.setMissedDoses(0);
        expectedResult.setFacilityName("FacilityName");
        expectedResult.setState("State");
        expectedResult.setAdherencePercentage(0);
        expectedResult.setAgentId(0);
        expectedResult.setActionTaken("actionTaken");
        expectedResult.setCategory("category");
        expectedResult.setSubCategory("subCategory");
        expectedResult.setDateOfAction(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setComments("comments");
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setEapiIds(List.of(0L));
        expectedResult.setGender("Gender");
        expectedResult.setDistrict("District");
        expectedResult.setBeneficiaryID(0L);
        expectedResult.setCurrentMonthMissedDoses(0);
        expectedResult.setRetryNeeded(false);
        expectedResult.setCallCounter(0);
        expectedResult.setLastCall("lastCall");
        expectedResult.setNoInfoDoseCount(0);
        expectedResult.setNoInfoDosesDates("noInfoDosesDates");

        // Run the test
        final EverwellDetails result = everwellDetailsUnderTest.getOutboundCall(0L, 0L, 0, 0L, 0, "firstName",
                "lastName", "primaryNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0,
                "facilityName", "state", 0, "actionTaken", "category", "subCategory",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "comments", "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "gender", "district", 0L, 0, false, 0,
                "lastCall", 0, "noInfoDosesDates");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testEapiIdsGetterAndSetter() {
        final List<Long> eapiIds = List.of(0L);
        everwellDetailsUnderTest.setEapiIds(eapiIds);
        assertThat(everwellDetailsUnderTest.getEAPIIDs()).isEqualTo(eapiIds);
    }

    @Test
    void testEapiIdGetterAndSetter() {
        final Long eapiId = 0L;
        everwellDetailsUnderTest.setEapiId(eapiId);
        assertThat(everwellDetailsUnderTest.getEapiId()).isEqualTo(eapiId);
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        everwellDetailsUnderTest.setId(id);
        assertThat(everwellDetailsUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testBeneficiaryRegIdGetterAndSetter() {
        final Long beneficiaryRegId = 0L;
        everwellDetailsUnderTest.setBeneficiaryRegId(beneficiaryRegId);
        assertThat(everwellDetailsUnderTest.getBeneficiaryRegId()).isEqualTo(beneficiaryRegId);
    }

    @Test
    void testCallIdGetterAndSetter() {
        final String callId = "callId";
        everwellDetailsUnderTest.setCallId(callId);
        assertThat(everwellDetailsUnderTest.getCallId()).isEqualTo(callId);
    }

    @Test
    void testProviderServiceMapIdGetterAndSetter() {
        final Integer providerServiceMapId = 0;
        everwellDetailsUnderTest.setProviderServiceMapId(providerServiceMapId);
        assertThat(everwellDetailsUnderTest.getProviderServiceMapId()).isEqualTo(providerServiceMapId);
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "FirstName";
        everwellDetailsUnderTest.setFirstName(firstName);
        assertThat(everwellDetailsUnderTest.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "LastName";
        everwellDetailsUnderTest.setLastName(lastName);
        assertThat(everwellDetailsUnderTest.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testPrimaryNumberGetterAndSetter() {
        final String primaryNumber = "PrimaryNumber";
        everwellDetailsUnderTest.setPrimaryNumber(primaryNumber);
        assertThat(everwellDetailsUnderTest.getPrimaryNumber()).isEqualTo(primaryNumber);
    }

    @Test
    void testMissedDosesGetterAndSetter() {
        final Integer missedDoses = 0;
        everwellDetailsUnderTest.setMissedDoses(missedDoses);
        assertThat(everwellDetailsUnderTest.getMissedDoses()).isEqualTo(missedDoses);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "FacilityName";
        everwellDetailsUnderTest.setFacilityName(facilityName);
        assertThat(everwellDetailsUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "State";
        everwellDetailsUnderTest.setState(state);
        assertThat(everwellDetailsUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testAdherencePercentageGetterAndSetter() {
        final Integer adherencePercentage = 0;
        everwellDetailsUnderTest.setAdherencePercentage(adherencePercentage);
        assertThat(everwellDetailsUnderTest.getAdherencePercentage()).isEqualTo(adherencePercentage);
    }

    @Test
    void testIsRegisteredGetterAndSetter() {
        final Boolean isRegistered = false;
        everwellDetailsUnderTest.setIsRegistered(isRegistered);
        assertThat(everwellDetailsUnderTest.getIsRegistered()).isFalse();
    }

    @Test
    void testAgentIdGetterAndSetter() {
        final Integer agentId = 0;
        everwellDetailsUnderTest.setAgentId(agentId);
        assertThat(everwellDetailsUnderTest.getAgentId()).isEqualTo(agentId);
    }

    @Test
    void testIsAllocatedGetterAndSetter() {
        final Boolean isAllocated = false;
        everwellDetailsUnderTest.setIsAllocated(isAllocated);
        assertThat(everwellDetailsUnderTest.getIsAllocated()).isFalse();
    }

    @Test
    void testActionTakenGetterAndSetter() {
        final String actionTaken = "actionTaken";
        everwellDetailsUnderTest.setActionTaken(actionTaken);
        assertThat(everwellDetailsUnderTest.getActionTaken()).isEqualTo(actionTaken);
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "category";
        everwellDetailsUnderTest.setCategory(category);
        assertThat(everwellDetailsUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testSubCategoryGetterAndSetter() {
        final String subCategory = "subCategory";
        everwellDetailsUnderTest.setSubCategory(subCategory);
        assertThat(everwellDetailsUnderTest.getSubCategory()).isEqualTo(subCategory);
    }

    @Test
    void testDateOfActionGetterAndSetter() {
        final Timestamp dateOfAction = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellDetailsUnderTest.setDateOfAction(dateOfAction);
        assertThat(everwellDetailsUnderTest.getDateOfAction()).isEqualTo(dateOfAction);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "comments";
        everwellDetailsUnderTest.setComments(comments);
        assertThat(everwellDetailsUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testStatusUpdatedEverwellGetterAndSetter() {
        final Boolean statusUpdatedEverwell = false;
        everwellDetailsUnderTest.setStatusUpdatedEverwell(statusUpdatedEverwell);
        assertThat(everwellDetailsUnderTest.getStatusUpdatedEverwell()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        everwellDetailsUnderTest.setDeleted(deleted);
        assertThat(everwellDetailsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        everwellDetailsUnderTest.setProcessed(processed);
        assertThat(everwellDetailsUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        everwellDetailsUnderTest.setCreatedBy(createdBy);
        assertThat(everwellDetailsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellDetailsUnderTest.setCreatedDate(createdDate);
        assertThat(everwellDetailsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        everwellDetailsUnderTest.setModifiedBy(modifiedBy);
        assertThat(everwellDetailsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellDetailsUnderTest.setLastModDate(lastModDate);
        assertThat(everwellDetailsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testVanSerialNoGetterAndSetter() {
        final Integer vanSerialNo = 0;
        everwellDetailsUnderTest.setVanSerialNo(vanSerialNo);
        assertThat(everwellDetailsUnderTest.getVanSerialNo()).isEqualTo(vanSerialNo);
    }

    @Test
    void testVanIdGetterAndSetter() {
        final Integer vanId = 0;
        everwellDetailsUnderTest.setVanId(vanId);
        assertThat(everwellDetailsUnderTest.getVanId()).isEqualTo(vanId);
    }

    @Test
    void testVehicalNoGetterAndSetter() {
        final String vehicalNo = "vehicalNo";
        everwellDetailsUnderTest.setVehicalNo(vehicalNo);
        assertThat(everwellDetailsUnderTest.getVehicalNo()).isEqualTo(vehicalNo);
    }

    @Test
    void testParkingPlaceIdGetterAndSetter() {
        final Integer parkingPlaceId = 0;
        everwellDetailsUnderTest.setParkingPlaceId(parkingPlaceId);
        assertThat(everwellDetailsUnderTest.getParkingPlaceId()).isEqualTo(parkingPlaceId);
    }

    @Test
    void testSyncedByGetterAndSetter() {
        final String syncedBy = "syncedBy";
        everwellDetailsUnderTest.setSyncedBy(syncedBy);
        assertThat(everwellDetailsUnderTest.getSyncedBy()).isEqualTo(syncedBy);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        everwellDetailsUnderTest.setCallTypeID(callTypeID);
        assertThat(everwellDetailsUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testRequestedServiceIDGetterAndSetter() {
        final Integer requestedServiceID = 0;
        everwellDetailsUnderTest.setRequestedServiceID(requestedServiceID);
        assertThat(everwellDetailsUnderTest.getRequestedServiceID()).isEqualTo(requestedServiceID);
    }

    @Test
    void testAssignedUserIDGetterAndSetter() {
        final Integer assignedUserID = 0;
        everwellDetailsUnderTest.setAssignedUserID(assignedUserID);
        assertThat(everwellDetailsUnderTest.getAssignedUserID()).isEqualTo(assignedUserID);
    }

    @Test
    void testSyncedDateGetterAndSetter() {
        final Timestamp syncedDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellDetailsUnderTest.setSyncedDate(syncedDate);
        assertThat(everwellDetailsUnderTest.getSyncedDate()).isEqualTo(syncedDate);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        everwellDetailsUnderTest.setBenCallID(benCallID);
        assertThat(everwellDetailsUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testIsCompletedGetterAndSetter() {
        final Boolean isCompleted = false;
        everwellDetailsUnderTest.setIsCompleted(isCompleted);
        assertThat(everwellDetailsUnderTest.getIsCompleted()).isFalse();
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "Gender";
        everwellDetailsUnderTest.setGender(gender);
        assertThat(everwellDetailsUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final String district = "District";
        everwellDetailsUnderTest.setDistrict(district);
        assertThat(everwellDetailsUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testBeneficiaryIDGetterAndSetter() {
        final Long beneficiaryID = 0L;
        everwellDetailsUnderTest.setBeneficiaryID(beneficiaryID);
        assertThat(everwellDetailsUnderTest.getBeneficiaryID()).isEqualTo(beneficiaryID);
    }

    @Test
    void testCurrentMonthMissedDosesGetterAndSetter() {
        final Integer currentMonthMissedDoses = 0;
        everwellDetailsUnderTest.setCurrentMonthMissedDoses(currentMonthMissedDoses);
        assertThat(everwellDetailsUnderTest.getCurrentMonthMissedDoses()).isEqualTo(currentMonthMissedDoses);
    }

    @Test
    void testPatientIdGetterAndSetter() {
        final Long patientId = 0L;
        everwellDetailsUnderTest.setPatientId(patientId);
        assertThat(everwellDetailsUnderTest.getPatientId()).isEqualTo(patientId);
    }

    @Test
    void testNoteGetterAndSetter() {
        final Note note = new Note();
        everwellDetailsUnderTest.setNote(note);
        assertThat(everwellDetailsUnderTest.getNote()).isEqualTo(note);
    }

    @Test
    void testAdherenceStringGetterAndSetter() {
        final String adherenceString = "AdherenceString";
        everwellDetailsUnderTest.setAdherenceString(adherenceString);
        assertThat(everwellDetailsUnderTest.getAdherenceString()).isEqualTo(adherenceString);
    }

    @Test
    void testPreferredLanguageNameGetterAndSetter() {
        final String preferredLanguageName = "preferredLanguageName";
        everwellDetailsUnderTest.setPreferredLanguageName(preferredLanguageName);
        assertThat(everwellDetailsUnderTest.getPreferredLanguageName()).isEqualTo(preferredLanguageName);
    }

    @Test
    void testFilterStartDateGetterAndSetter() {
        final Timestamp filterStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellDetailsUnderTest.setFilterStartDate(filterStartDate);
        assertThat(everwellDetailsUnderTest.getFilterStartDate()).isEqualTo(filterStartDate);
    }

    @Test
    void testRetryNeededGetterAndSetter() {
        final Boolean retryNeeded = false;
        everwellDetailsUnderTest.setRetryNeeded(retryNeeded);
        assertThat(everwellDetailsUnderTest.getRetryNeeded()).isFalse();
    }

    @Test
    void testCallCounterGetterAndSetter() {
        final Integer callCounter = 0;
        everwellDetailsUnderTest.setCallCounter(callCounter);
        assertThat(everwellDetailsUnderTest.getCallCounter()).isEqualTo(callCounter);
    }

    @Test
    void testFilterEndDateGetterAndSetter() {
        final Timestamp filterEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellDetailsUnderTest.setFilterEndDate(filterEndDate);
        assertThat(everwellDetailsUnderTest.getFilterEndDate()).isEqualTo(filterEndDate);
    }

    @Test
    void testLastCallGetterAndSetter() {
        final String lastCall = "lastCall";
        everwellDetailsUnderTest.setLastCall(lastCall);
        assertThat(everwellDetailsUnderTest.getLastCall()).isEqualTo(lastCall);
    }

    @Test
    void testNoInfoDoseCountGetterAndSetter() {
        final Integer noInfoDoseCount = 0;
        everwellDetailsUnderTest.setNoInfoDoseCount(noInfoDoseCount);
        assertThat(everwellDetailsUnderTest.getNoInfoDoseCount()).isEqualTo(noInfoDoseCount);
    }

    @Test
    void testNoInfoDosesDatesGetterAndSetter() {
        final String noInfoDosesDates = "noInfoDosesDates";
        everwellDetailsUnderTest.setNoInfoDosesDates(noInfoDosesDates);
        assertThat(everwellDetailsUnderTest.getNoInfoDosesDates()).isEqualTo(noInfoDosesDates);
    }

    @Test
    void testNoInfoDoseDatesGetterAndSetter() {
        final String[] noInfoDoseDates = new String[]{"NoInfoDoseDates"};
        everwellDetailsUnderTest.setNoInfoDoseDates(noInfoDoseDates);
        assertThat(everwellDetailsUnderTest.getNoInfoDoseDates()).isEqualTo(noInfoDoseDates);
    }

    @Test
    void testEquals() {
        assertThat(everwellDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(everwellDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(everwellDetailsUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(everwellDetailsUnderTest.toString()).isEqualTo("result");
    }
}
