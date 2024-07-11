package com.iemr.common.data.users;

import com.iemr.common.data.location.CityDetails;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.States;
import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.data.userbeneficiarydata.Religion;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserDemographicsTest {

	@InjectMocks
    private UserDemographics userDemographicsUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userDemographicsUnderTest = new UserDemographics(0, 0, "FathersName", "MothersName", 0, 0, "AddressLine1",
                "AddressLine2", "AddressLine3", "AddressLine4", "AddressLine5", 0, 0, 0, "PinCode", false, false,
                false);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userDemographicsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testDemographicIDGetterAndSetter() {
        final Integer demographicID = 0;
        userDemographicsUnderTest.setDemographicID(demographicID);
        assertThat(userDemographicsUnderTest.getDemographicID()).isEqualTo(demographicID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        userDemographicsUnderTest.setUserID(userID);
        assertThat(userDemographicsUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testM_userGetterAndSetter() {
        final User m_user = new User();
        userDemographicsUnderTest.setM_user(m_user);
        assertThat(userDemographicsUnderTest.getM_user()).isEqualTo(m_user);
    }

    @Test
    void testFathersNameGetterAndSetter() {
        final String fathersName = "FathersName";
        userDemographicsUnderTest.setFathersName(fathersName);
        assertThat(userDemographicsUnderTest.getFathersName()).isEqualTo(fathersName);
    }

    @Test
    void testMothersNameGetterAndSetter() {
        final String mothersName = "MothersName";
        userDemographicsUnderTest.setMothersName(mothersName);
        assertThat(userDemographicsUnderTest.getMothersName()).isEqualTo(mothersName);
    }

    @Test
    void testCommunityIDGetterAndSetter() {
        final Integer communityID = 0;
        userDemographicsUnderTest.setCommunityID(communityID);
        assertThat(userDemographicsUnderTest.getCommunityID()).isEqualTo(communityID);
    }

    @Test
    void testM_communityGetterAndSetter() {
        final Community m_community = new Community();
        userDemographicsUnderTest.setM_community(m_community);
        assertThat(userDemographicsUnderTest.getM_community()).isEqualTo(m_community);
    }

    @Test
    void testReligionIDGetterAndSetter() {
        final Integer religionID = 0;
        userDemographicsUnderTest.setReligionID(religionID);
        assertThat(userDemographicsUnderTest.getReligionID()).isEqualTo(religionID);
    }

    @Test
    void testM_religionGetterAndSetter() {
        final Religion m_religion = new Religion(0, "ReligionType", "ReligionDesc");
        userDemographicsUnderTest.setM_religion(m_religion);
        assertThat(userDemographicsUnderTest.getM_religion()).isEqualTo(m_religion);
    }

    @Test
    void testAddressLine1GetterAndSetter() {
        final String addressLine1 = "AddressLine1";
        userDemographicsUnderTest.setAddressLine1(addressLine1);
        assertThat(userDemographicsUnderTest.getAddressLine1()).isEqualTo(addressLine1);
    }

    @Test
    void testAddressLine2GetterAndSetter() {
        final String addressLine2 = "AddressLine2";
        userDemographicsUnderTest.setAddressLine2(addressLine2);
        assertThat(userDemographicsUnderTest.getAddressLine2()).isEqualTo(addressLine2);
    }

    @Test
    void testAddressLine3GetterAndSetter() {
        final String addressLine3 = "AddressLine3";
        userDemographicsUnderTest.setAddressLine3(addressLine3);
        assertThat(userDemographicsUnderTest.getAddressLine3()).isEqualTo(addressLine3);
    }

    @Test
    void testAddressLine4GetterAndSetter() {
        final String addressLine4 = "AddressLine4";
        userDemographicsUnderTest.setAddressLine4(addressLine4);
        assertThat(userDemographicsUnderTest.getAddressLine4()).isEqualTo(addressLine4);
    }

    @Test
    void testAddressLine5GetterAndSetter() {
        final String addressLine5 = "AddressLine5";
        userDemographicsUnderTest.setAddressLine5(addressLine5);
        assertThat(userDemographicsUnderTest.getAddressLine5()).isEqualTo(addressLine5);
    }

    @Test
    void testCityIDGetterAndSetter() {
        final Integer cityID = 0;
        userDemographicsUnderTest.setCityID(cityID);
        assertThat(userDemographicsUnderTest.getCityID()).isEqualTo(cityID);
    }

    @Test
    void testM_cityGetterAndSetter() {
        final CityDetails m_city = new CityDetails(0, "CityName");
        userDemographicsUnderTest.setM_city(m_city);
        assertThat(userDemographicsUnderTest.getM_city()).isEqualTo(m_city);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        userDemographicsUnderTest.setStateID(stateID);
        assertThat(userDemographicsUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testM_stateGetterAndSetter() {
        final States m_state = new States();
        userDemographicsUnderTest.setM_state(m_state);
        assertThat(userDemographicsUnderTest.getM_state()).isEqualTo(m_state);
    }

    @Test
    void testCountryIDGetterAndSetter() {
        final Integer countryID = 0;
        userDemographicsUnderTest.setCountryID(countryID);
        assertThat(userDemographicsUnderTest.getCountryID()).isEqualTo(countryID);
    }

    @Test
    void testM_countryGetterAndSetter() {
        final Country m_country = new Country();
        userDemographicsUnderTest.setM_country(m_country);
        assertThat(userDemographicsUnderTest.getM_country()).isEqualTo(m_country);
    }

    @Test
    void testPinCodeGetterAndSetter() {
        final String pinCode = "PinCode";
        userDemographicsUnderTest.setPinCode(pinCode);
        assertThat(userDemographicsUnderTest.getPinCode()).isEqualTo(pinCode);
    }

    @Test
    void testIsPresentGetterAndSetter() {
        final Boolean isPresent = false;
        userDemographicsUnderTest.setIsPresent(isPresent);
        assertThat(userDemographicsUnderTest.getIsPresent()).isFalse();
    }

    @Test
    void testIsPermanentGetterAndSetter() {
        final Boolean isPermanent = false;
        userDemographicsUnderTest.setIsPermanent(isPermanent);
        assertThat(userDemographicsUnderTest.getIsPermanent()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        userDemographicsUnderTest.setDeleted(deleted);
        assertThat(userDemographicsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "CreatedBy";
        userDemographicsUnderTest.setCreatedBy(createdBy);
        assertThat(userDemographicsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userDemographicsUnderTest.setCreatedDate(createdDate);
        assertThat(userDemographicsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "ModifiedBy";
        userDemographicsUnderTest.setModifiedBy(modifiedBy);
        assertThat(userDemographicsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userDemographicsUnderTest.setLastModDate(lastModDate);
        assertThat(userDemographicsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        userDemographicsUnderTest.setOutputMapper(outputMapper);
        assertThat(userDemographicsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userDemographicsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userDemographicsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userDemographicsUnderTest.hashCode()).isEqualTo(0);
    }
}
