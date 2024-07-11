package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BenDetailsTest {

	@InjectMocks
    private BenDetails benDetailsUnderTest;

    @BeforeEach
    void setUp() {
        benDetailsUnderTest = new BenDetails();
    }

    @Test
    void testToString() {
        assertThat(benDetailsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testDim_BeneficiaryIDGetterAndSetter() {
        final Long dim_BeneficiaryID = 0L;
        benDetailsUnderTest.setDim_BeneficiaryID(dim_BeneficiaryID);
        assertThat(benDetailsUnderTest.getDim_BeneficiaryID()).isEqualTo(dim_BeneficiaryID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        benDetailsUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(benDetailsUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBeneficiaryIDGetterAndSetter() {
        final Long beneficiaryID = 0L;
        benDetailsUnderTest.setBeneficiaryID(beneficiaryID);
        assertThat(benDetailsUnderTest.getBeneficiaryID()).isEqualTo(beneficiaryID);
    }

    @Test
    void testTitleIDGetterAndSetter() {
        final Integer titleID = 0;
        benDetailsUnderTest.setTitleID(titleID);
        assertThat(benDetailsUnderTest.getTitleID()).isEqualTo(titleID);
    }

    @Test
    void testTitleGetterAndSetter() {
        final String title = "title";
        benDetailsUnderTest.setTitle(title);
        assertThat(benDetailsUnderTest.getTitle()).isEqualTo(title);
    }

    @Test
    void testGenderIDGetterAndSetter() {
        final Integer genderID = 0;
        benDetailsUnderTest.setGenderID(genderID);
        assertThat(benDetailsUnderTest.getGenderID()).isEqualTo(genderID);
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "gender";
        benDetailsUnderTest.setGender(gender);
        assertThat(benDetailsUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testMaritalStatusIDGetterAndSetter() {
        final Integer maritalStatusID = 0;
        benDetailsUnderTest.setMaritalStatusID(maritalStatusID);
        assertThat(benDetailsUnderTest.getMaritalStatusID()).isEqualTo(maritalStatusID);
    }

    @Test
    void testMaritalStatusGetterAndSetter() {
        final String maritalStatus = "maritalStatus";
        benDetailsUnderTest.setMaritalStatus(maritalStatus);
        assertThat(benDetailsUnderTest.getMaritalStatus()).isEqualTo(maritalStatus);
    }

    @Test
    void testDobGetterAndSetter() {
        final Timestamp dob = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        benDetailsUnderTest.setDob(dob);
        assertThat(benDetailsUnderTest.getDob()).isEqualTo(dob);
    }

    @Test
    void testSexualOrientationIDGetterAndSetter() {
        final Integer sexualOrientationID = 0;
        benDetailsUnderTest.setSexualOrientationID(sexualOrientationID);
        assertThat(benDetailsUnderTest.getSexualOrientationID()).isEqualTo(sexualOrientationID);
    }

    @Test
    void testSexualOrientationGetterAndSetter() {
        final String sexualOrientation = "sexualOrientation";
        benDetailsUnderTest.setSexualOrientation(sexualOrientation);
        assertThat(benDetailsUnderTest.getSexualOrientation()).isEqualTo(sexualOrientation);
    }

    @Test
    void testIsHIVPosGetterAndSetter() {
        final Integer isHIVPos = 0;
        benDetailsUnderTest.setIsHIVPos(isHIVPos);
        assertThat(benDetailsUnderTest.getIsHIVPos()).isEqualTo(isHIVPos);
    }

    @Test
    void testEducationIDGetterAndSetter() {
        final Integer educationID = 0;
        benDetailsUnderTest.setEducationID(educationID);
        assertThat(benDetailsUnderTest.getEducationID()).isEqualTo(educationID);
    }

    @Test
    void testEducationGetterAndSetter() {
        final String education = "education";
        benDetailsUnderTest.setEducation(education);
        assertThat(benDetailsUnderTest.getEducation()).isEqualTo(education);
    }

    @Test
    void testOccupationIDGetterAndSetter() {
        final Integer occupationID = 0;
        benDetailsUnderTest.setOccupationID(occupationID);
        assertThat(benDetailsUnderTest.getOccupationID()).isEqualTo(occupationID);
    }

    @Test
    void testOccupationGetterAndSetter() {
        final String occupation = "occupation";
        benDetailsUnderTest.setOccupation(occupation);
        assertThat(benDetailsUnderTest.getOccupation()).isEqualTo(occupation);
    }

    @Test
    void testHealthcareWorkerIDGetterAndSetter() {
        final Integer healthcareWorkerID = 0;
        benDetailsUnderTest.setHealthcareWorkerID(healthcareWorkerID);
        assertThat(benDetailsUnderTest.getHealthcareWorkerID()).isEqualTo(healthcareWorkerID);
    }

    @Test
    void testHealthcareWorkerGetterAndSetter() {
        final String healthcareWorker = "healthcareWorker";
        benDetailsUnderTest.setHealthcareWorker(healthcareWorker);
        assertThat(benDetailsUnderTest.getHealthcareWorker()).isEqualTo(healthcareWorker);
    }

    @Test
    void testIncomeStatusGetterAndSetter() {
        final String incomeStatus = "incomeStatus";
        benDetailsUnderTest.setIncomeStatus(incomeStatus);
        assertThat(benDetailsUnderTest.getIncomeStatus()).isEqualTo(incomeStatus);
    }

    @Test
    void testCommunityIDGetterAndSetter() {
        final Integer communityID = 0;
        benDetailsUnderTest.setCommunityID(communityID);
        assertThat(benDetailsUnderTest.getCommunityID()).isEqualTo(communityID);
    }

    @Test
    void testCommunityGetterAndSetter() {
        final String community = "community";
        benDetailsUnderTest.setCommunity(community);
        assertThat(benDetailsUnderTest.getCommunity()).isEqualTo(community);
    }

    @Test
    void testPreferredLanguageGetterAndSetter() {
        final String preferredLanguage = "preferredLanguage";
        benDetailsUnderTest.setPreferredLanguage(preferredLanguage);
        assertThat(benDetailsUnderTest.getPreferredLanguage()).isEqualTo(preferredLanguage);
    }

    @Test
    void testReligionIDGetterAndSetter() {
        final Integer religionID = 0;
        benDetailsUnderTest.setReligionID(religionID);
        assertThat(benDetailsUnderTest.getReligionID()).isEqualTo(religionID);
    }

    @Test
    void testReligionGetterAndSetter() {
        final String religion = "religion";
        benDetailsUnderTest.setReligion(religion);
        assertThat(benDetailsUnderTest.getReligion()).isEqualTo(religion);
    }

    @Test
    void testPlaceOfWorkGetterAndSetter() {
        final String placeOfWork = "placeOfWork";
        benDetailsUnderTest.setPlaceOfWork(placeOfWork);
        assertThat(benDetailsUnderTest.getPlaceOfWork()).isEqualTo(placeOfWork);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        benDetailsUnderTest.setDistrictID(districtID);
        assertThat(benDetailsUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final String district = "district";
        benDetailsUnderTest.setDistrict(district);
        assertThat(benDetailsUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        benDetailsUnderTest.setStateID(stateID);
        assertThat(benDetailsUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testStateGetterAndSetter() {
        final String state = "state";
        benDetailsUnderTest.setState(state);
        assertThat(benDetailsUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testSubDistrictIDGetterAndSetter() {
        final Integer subDistrictID = 0;
        benDetailsUnderTest.setSubDistrictID(subDistrictID);
        assertThat(benDetailsUnderTest.getSubDistrictID()).isEqualTo(subDistrictID);
    }

    @Test
    void testSubDistrictGetterAndSetter() {
        final String subDistrict = "subDistrict";
        benDetailsUnderTest.setSubDistrict(subDistrict);
        assertThat(benDetailsUnderTest.getSubDistrict()).isEqualTo(subDistrict);
    }

    @Test
    void testPermVillageIdGetterAndSetter() {
        final Integer permVillageId = 0;
        benDetailsUnderTest.setPermVillageId(permVillageId);
        assertThat(benDetailsUnderTest.getPermVillageId()).isEqualTo(permVillageId);
    }

    @Test
    void testPermVillageGetterAndSetter() {
        final String permVillage = "permVillage";
        benDetailsUnderTest.setPermVillage(permVillage);
        assertThat(benDetailsUnderTest.getPermVillage()).isEqualTo(permVillage);
    }

    @Test
    void testBenCreatedDateGetterAndSetter() {
        final Integer benCreatedDate = 0;
        benDetailsUnderTest.setBenCreatedDate(benCreatedDate);
        assertThat(benDetailsUnderTest.getBenCreatedDate()).isEqualTo(benCreatedDate);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        benDetailsUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(benDetailsUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testBeneficiaryCreatedByGetterAndSetter() {
        final String beneficiaryCreatedBy = "beneficiaryCreatedBy";
        benDetailsUnderTest.setBeneficiaryCreatedBy(beneficiaryCreatedBy);
        assertThat(benDetailsUnderTest.getBeneficiaryCreatedBy()).isEqualTo(beneficiaryCreatedBy);
    }

    @Test
    void testLoadedByGetterAndSetter() {
        final String loadedBy = "loadedBy";
        benDetailsUnderTest.setLoadedBy(loadedBy);
        assertThat(benDetailsUnderTest.getLoadedBy()).isEqualTo(loadedBy);
    }

    @Test
    void testLoadDateGetterAndSetter() {
        final Timestamp loadDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        benDetailsUnderTest.setLoadDate(loadDate);
        assertThat(benDetailsUnderTest.getLoadDate()).isEqualTo(loadDate);
    }

    @Test
    void testEquals() {
        assertThat(benDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(benDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(benDetailsUnderTest.hashCode()).isEqualTo(0);
    }
}
