package com.iemr.common.data.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class VanServicepointMappingTest {

	@InjectMocks
    private VanServicepointMapping vanServicepointMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        vanServicepointMappingUnderTest = new VanServicepointMapping();
    }

    @Test
    void testVanServicePointMapIDGetterAndSetter() {
        final Integer vanServicePointMapID = 0;
        vanServicepointMappingUnderTest.setVanServicePointMapID(vanServicePointMapID);
        assertThat(vanServicepointMappingUnderTest.getVanServicePointMapID()).isEqualTo(vanServicePointMapID);
    }

    @Test
    void testVanIDGetterAndSetter() {
        final Integer vanID = 0;
        vanServicepointMappingUnderTest.setVanID(vanID);
        assertThat(vanServicepointMappingUnderTest.getVanID()).isEqualTo(vanID);
    }

    @Test
    void testServicePointIDGetterAndSetter() {
        final Integer servicePointID = 0;
        vanServicepointMappingUnderTest.setServicePointID(servicePointID);
        assertThat(vanServicepointMappingUnderTest.getServicePointID()).isEqualTo(servicePointID);
    }

    @Test
    void testVanSessionGetterAndSetter() {
        final Short vanSession = (short) 0;
        vanServicepointMappingUnderTest.setVanSession(vanSession);
        assertThat(vanServicepointMappingUnderTest.getVanSession()).isEqualTo(vanSession);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() throws Exception {
        final Integer providerServiceMapID = 0;
        vanServicepointMappingUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(vanServicepointMappingUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        vanServicepointMappingUnderTest.setDeleted(deleted);
        assertThat(vanServicepointMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testMasterServicePointGetterAndSetter() {
        final MasterServicePoint masterServicePoint = new MasterServicePoint();
        vanServicepointMappingUnderTest.setMasterServicePoint(masterServicePoint);
        assertThat(vanServicepointMappingUnderTest.getMasterServicePoint()).isEqualTo(masterServicePoint);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(vanServicepointMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(vanServicepointMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(vanServicepointMappingUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(vanServicepointMappingUnderTest.toString()).isEqualTo("result");
    }
}
