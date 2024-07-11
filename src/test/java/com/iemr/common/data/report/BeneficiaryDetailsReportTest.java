package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BeneficiaryDetailsReportTest {

	@InjectMocks
    private BeneficiaryDetailsReport beneficiaryDetailsReportUnderTest;

    @BeforeEach
    void setUp() {
        beneficiaryDetailsReportUnderTest = new BeneficiaryDetailsReport();
    }

    @Test
    void testToString() {
        assertThat(beneficiaryDetailsReportUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetAge() {
        // Setup
        // Run the test
        final Integer result = beneficiaryDetailsReportUnderTest.getAge();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testGetIsHIVPositive() {
        assertThat(BeneficiaryDetailsReport.getIsHIVPositive(0)).isEqualTo("No");
    }

    @Test
    void testGetDobAsString() {
        // Setup
        // Run the test
        final String result = beneficiaryDetailsReportUnderTest.getDobAsString();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testBeneficiaryID1097GetterAndSetter() {
        final Long beneficiaryID1097 = 0L;
        beneficiaryDetailsReportUnderTest.setBeneficiaryID1097(beneficiaryID1097);
        assertThat(beneficiaryDetailsReportUnderTest.getBeneficiaryID1097()).isEqualTo(beneficiaryID1097);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        beneficiaryDetailsReportUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(beneficiaryDetailsReportUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBeneficiaryIDGetterAndSetter() {
        final Long beneficiaryID = 0L;
        beneficiaryDetailsReportUnderTest.setBeneficiaryID(beneficiaryID);
        assertThat(beneficiaryDetailsReportUnderTest.getBeneficiaryID()).isEqualTo(beneficiaryID);
    }

    @Test
    void testTitleIDGetterAndSetter() {
        final Integer titleID = 0;
        beneficiaryDetailsReportUnderTest.setTitleID(titleID);
        assertThat(beneficiaryDetailsReportUnderTest.getTitleID()).isEqualTo(titleID);
    }

    @Test
    void testTitleGetterAndSetter() {
        final String title = "title";
        beneficiaryDetailsReportUnderTest.setTitle(title);
        assertThat(beneficiaryDetailsReportUnderTest.getTitle()).isEqualTo(title);
    }

    @Test
    void testGenderIDGetterAndSetter() {
        final Integer genderID = 0;
        beneficiaryDetailsReportUnderTest.setGenderID(genderID);
        assertThat(beneficiaryDetailsReportUnderTest.getGenderID()).isEqualTo(genderID);
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "gender";
        beneficiaryDetailsReportUnderTest.setGender(gender);
        assertThat(beneficiaryDetailsReportUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testMaritalStatusIDGetterAndSetter() {
        final Integer maritalStatusID = 0;
        beneficiaryDetailsReportUnderTest.setMaritalStatusID(maritalStatusID);
        assertThat(beneficiaryDetailsReportUnderTest.getMaritalStatusID()).isEqualTo(maritalStatusID);
    }

    @Test
    void testMaritalStatusGetterAndSetter() {
        final String maritalStatus = "maritalStatus";
        beneficiaryDetailsReportUnderTest.setMaritalStatus(maritalStatus);
        assertThat(beneficiaryDetailsReportUnderTest.getMaritalStatus()).isEqualTo(maritalStatus);
    }

    @Test
    void testDobGetterAndSetter() {
        final Timestamp dob = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryDetailsReportUnderTest.setDob(dob);
        assertThat(beneficiaryDetailsReportUnderTest.getDob()).isEqualTo(dob);
    }

    @Test
    void testSexualOrientationIDGetterAndSetter() {
        final Integer sexualOrientationID = 0;
        beneficiaryDetailsReportUnderTest.setSexualOrientationID(sexualOrientationID);
        assertThat(beneficiaryDetailsReportUnderTest.getSexualOrientationID()).isEqualTo(sexualOrientationID);
    }

    @Test
    void testSexualOrientationGetterAndSetter() {
        final String sexualOrientation = "sexualOrientation";
        beneficiaryDetailsReportUnderTest.setSexualOrientation(sexualOrientation);
        assertThat(beneficiaryDetailsReportUnderTest.getSexualOrientation()).isEqualTo(sexualOrientation);
    }

    @Test
    void testIsHIVPosGetterAndSetter() {
        final Integer isHIVPos = 0;
        beneficiaryDetailsReportUnderTest.setIsHIVPos(isHIVPos);
        assertThat(beneficiaryDetailsReportUnderTest.getIsHIVPos()).isEqualTo(isHIVPos);
    }

    @Test
    void testEducationIDGetterAndSetter() {
        final Integer educationID = 0;
        beneficiaryDetailsReportUnderTest.setEducationID(educationID);
        assertThat(beneficiaryDetailsReportUnderTest.getEducationID()).isEqualTo(educationID);
    }

    @Test
    void testEducationGetterAndSetter() {
        final String education = "education";
        beneficiaryDetailsReportUnderTest.setEducation(education);
        assertThat(beneficiaryDetailsReportUnderTest.getEducation()).isEqualTo(education);
    }

    @Test
    void testOccupationIDGetterAndSetter() {
        final Integer occupationID = 0;
        beneficiaryDetailsReportUnderTest.setOccupationID(occupationID);
        assertThat(beneficiaryDetailsReportUnderTest.getOccupationID()).isEqualTo(occupationID);
    }

    @Test
    void testOccupationGetterAndSetter() {
        final String occupation = "occupation";
        beneficiaryDetailsReportUnderTest.setOccupation(occupation);
        assertThat(beneficiaryDetailsReportUnderTest.getOccupation()).isEqualTo(occupation);
    }

    @Test
    void testHealthcareWorkerIDGetterAndSetter() {
        final Integer healthcareWorkerID = 0;
        beneficiaryDetailsReportUnderTest.setHealthcareWorkerID(healthcareWorkerID);
        assertThat(beneficiaryDetailsReportUnderTest.getHealthcareWorkerID()).isEqualTo(healthcareWorkerID);
    }

    @Test
    void testHealthcareWorkerGetterAndSetter() {
        final String healthcareWorker = "healthcareWorker";
        beneficiaryDetailsReportUnderTest.setHealthcareWorker(healthcareWorker);
        assertThat(beneficiaryDetailsReportUnderTest.getHealthcareWorker()).isEqualTo(healthcareWorker);
    }

    @Test
    void testIncomeStatusGetterAndSetter() {
        final String incomeStatus = "incomeStatus";
        beneficiaryDetailsReportUnderTest.setIncomeStatus(incomeStatus);
        assertThat(beneficiaryDetailsReportUnderTest.getIncomeStatus()).isEqualTo(incomeStatus);
    }

    @Test
    void testCommunityIDGetterAndSetter() {
        final Integer communityID = 0;
        beneficiaryDetailsReportUnderTest.setCommunityID(communityID);
        assertThat(beneficiaryDetailsReportUnderTest.getCommunityID()).isEqualTo(communityID);
    }

    @Test
    void testCommunityGetterAndSetter() {
        final String community = "community";
        beneficiaryDetailsReportUnderTest.setCommunity(community);
        assertThat(beneficiaryDetailsReportUnderTest.getCommunity()).isEqualTo(community);
    }

    @Test
    void testPreferredLanguageGetterAndSetter() {
        final String preferredLanguage = "preferredLanguage";
        beneficiaryDetailsReportUnderTest.setPreferredLanguage(preferredLanguage);
        assertThat(beneficiaryDetailsReportUnderTest.getPreferredLanguage()).isEqualTo(preferredLanguage);
    }

    @Test
    void testReligionIDGetterAndSetter() {
        final Integer religionID = 0;
        beneficiaryDetailsReportUnderTest.setReligionID(religionID);
        assertThat(beneficiaryDetailsReportUnderTest.getReligionID()).isEqualTo(religionID);
    }

    @Test
    void testReligionGetterAndSetter() {
        final String religion = "religion";
        beneficiaryDetailsReportUnderTest.setReligion(religion);
        assertThat(beneficiaryDetailsReportUnderTest.getReligion()).isEqualTo(religion);
    }

    @Test
    void testPlaceOfWorkGetterAndSetter() {
        final String placeOfWork = "placeOfWork";
        beneficiaryDetailsReportUnderTest.setPlaceOfWork(placeOfWork);
        assertThat(beneficiaryDetailsReportUnderTest.getPlaceOfWork()).isEqualTo(placeOfWork);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        beneficiaryDetailsReportUnderTest.setDistrictID(districtID);
        assertThat(beneficiaryDetailsReportUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final String district = "district";
        beneficiaryDetailsReportUnderTest.setDistrict(district);
        assertThat(beneficiaryDetailsReportUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        beneficiaryDetailsReportUnderTest.setStateID(stateID);
        assertThat(beneficiaryDetailsReportUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "state";
        beneficiaryDetailsReportUnderTest.setState(state);
        assertThat(beneficiaryDetailsReportUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testSubDistrictIDGetterAndSetter() {
        final Integer subDistrictID = 0;
        beneficiaryDetailsReportUnderTest.setSubDistrictID(subDistrictID);
        assertThat(beneficiaryDetailsReportUnderTest.getSubDistrictID()).isEqualTo(subDistrictID);
    }

    @Test
    void testSubDistrictGetterAndSetter() {
        final String subDistrict = "subDistrict";
        beneficiaryDetailsReportUnderTest.setSubDistrict(subDistrict);
        assertThat(beneficiaryDetailsReportUnderTest.getSubDistrict()).isEqualTo(subDistrict);
    }

    @Test
    void testBenCreatedDateGetterAndSetter() {
        final Integer benCreatedDate = 0;
        beneficiaryDetailsReportUnderTest.setBenCreatedDate(benCreatedDate);
        assertThat(beneficiaryDetailsReportUnderTest.getBenCreatedDate()).isEqualTo(benCreatedDate);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        beneficiaryDetailsReportUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(beneficiaryDetailsReportUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testBeneficiaryCreatedByGetterAndSetter() {
        final String beneficiaryCreatedBy = "beneficiaryCreatedBy";
        beneficiaryDetailsReportUnderTest.setBeneficiaryCreatedBy(beneficiaryCreatedBy);
        assertThat(beneficiaryDetailsReportUnderTest.getBeneficiaryCreatedBy()).isEqualTo(beneficiaryCreatedBy);
    }

    @Test
    void testLoadedByGetterAndSetter() {
        final String loadedBy = "loadedBy";
        beneficiaryDetailsReportUnderTest.setLoadedBy(loadedBy);
        assertThat(beneficiaryDetailsReportUnderTest.getLoadedBy()).isEqualTo(loadedBy);
    }

    @Test
    void testLoadDateGetterAndSetter() {
        final Timestamp loadDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryDetailsReportUnderTest.setLoadDate(loadDate);
        assertThat(beneficiaryDetailsReportUnderTest.getLoadDate()).isEqualTo(loadDate);
    }

    @Test
    void testGetSTART_YEAR_1970() {
        assertThat(beneficiaryDetailsReportUnderTest.getSTART_YEAR_1970()).isEqualTo(0);
    }

    @Test
    void testGetDOB_FORMAT() {
        assertThat(beneficiaryDetailsReportUnderTest.getDOB_FORMAT())
                .isEqualTo(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US));
    }

    @Test
    void testEquals() {
        assertThat(beneficiaryDetailsReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(beneficiaryDetailsReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(beneficiaryDetailsReportUnderTest.hashCode()).isEqualTo(0);
    }
}
