package com.iemr.common.data.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MasterServicePointTest {

	@InjectMocks
    private MasterServicePoint masterServicePointUnderTest;

    @BeforeEach
    void setUp() {
        masterServicePointUnderTest = new MasterServicePoint(0, "servicePointName", 0, 0, false,
                Set.of(new VanServicepointMapping()));
    }

    @Test
    void testServicePointIDGetterAndSetter() {
        final Integer servicePointID = 0;
        masterServicePointUnderTest.setServicePointID(servicePointID);
        assertThat(masterServicePointUnderTest.getServicePointID()).isEqualTo(servicePointID);
    }

    @Test
    void testServicePointNameGetterAndSetter() {
        final String servicePointName = "servicePointName";
        masterServicePointUnderTest.setServicePointName(servicePointName);
        assertThat(masterServicePointUnderTest.getServicePointName()).isEqualTo(servicePointName);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        masterServicePointUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(masterServicePointUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        masterServicePointUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(masterServicePointUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        masterServicePointUnderTest.setDeleted(deleted);
        assertThat(masterServicePointUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testVanServicepointMappingGetterAndSetter() {
        final Set<VanServicepointMapping> vanServicepointMapping = Set.of(new VanServicepointMapping());
        masterServicePointUnderTest.setVanServicepointMapping(vanServicepointMapping);
        assertThat(masterServicePointUnderTest.getVanServicepointMapping()).isEqualTo(vanServicepointMapping);
    }

    @Test
    void testEquals() {
        assertThat(masterServicePointUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(masterServicePointUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(masterServicePointUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(masterServicePointUnderTest.toString()).isEqualTo("result");
    }
}
