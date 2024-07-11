package com.iemr.common.data.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MasterVanTest {

    @Mock
    private UserParkingplaceMapping mockUserParkingplaceMapping;

    @InjectMocks
    private MasterVan masterVanUnderTest;

    @BeforeEach
    void setUp() {
        masterVanUnderTest = new MasterVan(0, "vehicalNo", 0, 0, false, mockUserParkingplaceMapping);
    }

    @Test
    void testVanIDGetterAndSetter() {
        final Integer vanID = 0;
        masterVanUnderTest.setVanID(vanID);
        assertThat(masterVanUnderTest.getVanID()).isEqualTo(vanID);
    }

    @Test
    void testVehicalNoGetterAndSetter() {
        final String vehicalNo = "vehicalNo";
        masterVanUnderTest.setVehicalNo(vehicalNo);
        assertThat(masterVanUnderTest.getVehicalNo()).isEqualTo(vehicalNo);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        masterVanUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(masterVanUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        masterVanUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(masterVanUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        masterVanUnderTest.setDeleted(deleted);
        assertThat(masterVanUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testUserParkingplaceMappingGetterAndSetter() {
        final UserParkingplaceMapping userParkingplaceMapping = new UserParkingplaceMapping();
        masterVanUnderTest.setUserParkingplaceMapping(userParkingplaceMapping);
        assertThat(masterVanUnderTest.getUserParkingplaceMapping()).isEqualTo(userParkingplaceMapping);
    }

    @Test
    void testEquals() {
        assertThat(masterVanUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(masterVanUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(masterVanUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(masterVanUnderTest.toString()).isEqualTo("result");
    }
}
