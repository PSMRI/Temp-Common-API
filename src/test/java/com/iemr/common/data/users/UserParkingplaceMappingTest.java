package com.iemr.common.data.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserParkingplaceMappingTest {

	@InjectMocks
    private UserParkingplaceMapping userParkingplaceMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userParkingplaceMappingUnderTest = new UserParkingplaceMapping(0, 0, 0, 0, 0, 0, 0, Set.of(new MasterVan()));
    }

    @Test
    void testUserParkingPlaceMapIDGetterAndSetter() {
        final Integer userParkingPlaceMapID = 0;
        userParkingplaceMappingUnderTest.setUserParkingPlaceMapID(userParkingPlaceMapID);
        assertThat(userParkingplaceMappingUnderTest.getUserParkingPlaceMapID()).isEqualTo(userParkingPlaceMapID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        userParkingplaceMappingUnderTest.setUserID(userID);
        assertThat(userParkingplaceMappingUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        userParkingplaceMappingUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(userParkingplaceMappingUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        userParkingplaceMappingUnderTest.setStateID(stateID);
        assertThat(userParkingplaceMappingUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        userParkingplaceMappingUnderTest.setDistrictID(districtID);
        assertThat(userParkingplaceMappingUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testProviderServiceMapIdGetterAndSetter() {
        final Integer providerServiceMapId = 0;
        userParkingplaceMappingUnderTest.setProviderServiceMapId(providerServiceMapId);
        assertThat(userParkingplaceMappingUnderTest.getProviderServiceMapId()).isEqualTo(providerServiceMapId);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Integer deleted = 0;
        userParkingplaceMappingUnderTest.setDeleted(deleted);
        assertThat(userParkingplaceMappingUnderTest.getDeleted()).isEqualTo(deleted);
    }

    @Test
    void testMasterVanSetGetterAndSetter() {
        final Set<MasterVan> masterVanSet = Set.of(new MasterVan());
        userParkingplaceMappingUnderTest.setMasterVanSet(masterVanSet);
        assertThat(userParkingplaceMappingUnderTest.getMasterVanSet()).isEqualTo(masterVanSet);
    }

    @Test
    void testM_parkingplaceGetterAndSetter() {
        final Parkingplace m_parkingplace = new Parkingplace();
        userParkingplaceMappingUnderTest.setM_parkingplace(m_parkingplace);
        assertThat(userParkingplaceMappingUnderTest.getM_parkingplace()).isEqualTo(m_parkingplace);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userParkingplaceMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userParkingplaceMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userParkingplaceMappingUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userParkingplaceMappingUnderTest.toString()).isEqualTo("result");
    }
}
