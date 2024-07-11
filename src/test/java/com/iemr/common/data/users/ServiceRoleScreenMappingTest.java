package com.iemr.common.data.users;

import com.iemr.common.utils.mapper.OutputMapper;
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
class ServiceRoleScreenMappingTest {

	@InjectMocks
    private ServiceRoleScreenMapping serviceRoleScreenMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        serviceRoleScreenMappingUnderTest = new ServiceRoleScreenMapping();
    }

    @Test
    void testInitializeRoleScreenMapping() {
        // Setup
        final Screen screen = new Screen();
        screen.setScreenID(0);
        final ServiceRoleScreenMapping serviceRoleScreenMapping = new ServiceRoleScreenMapping();
        serviceRoleScreenMapping.setSrsMappingID(0);
        serviceRoleScreenMapping.setScreenID(0);
        serviceRoleScreenMapping.setProviderServiceMapID(0);
        screen.setServiceRoleScreenMappings(List.of(serviceRoleScreenMapping));

        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);

        // Run the test
        final ServiceRoleScreenMapping result = ServiceRoleScreenMapping.initializeRoleScreenMapping(0, 0, screen, 0,
                providerServiceMapping, 0, false, "createdBy");
        final Screen screen1 = new Screen();
        screen1.setScreenID(0);
        final ServiceRoleScreenMapping serviceRoleScreenMapping1 = new ServiceRoleScreenMapping();
        serviceRoleScreenMapping1.setSrsMappingID(0);
        serviceRoleScreenMapping1.setScreenID(0);
        serviceRoleScreenMapping1.setProviderServiceMapID(0);
        screen1.setServiceRoleScreenMappings(List.of(serviceRoleScreenMapping1));

        final ProviderServiceMapping providerServiceMapping1 = new ProviderServiceMapping(false, 0);
        assertThat(result.createServiceRoleScreenMapping(0, 0, screen1, 0, providerServiceMapping1, 0, false,
                "createdBy")).isEqualTo(new ServiceRoleScreenMapping());
        final Screen screen2 = new Screen();
        screen2.setScreenID(0);
        final ServiceRoleScreenMapping serviceRoleScreenMapping2 = new ServiceRoleScreenMapping();
        serviceRoleScreenMapping2.setSrsMappingID(0);
        serviceRoleScreenMapping2.setScreenID(0);
        serviceRoleScreenMapping2.setProviderServiceMapID(0);
        screen2.setServiceRoleScreenMappings(List.of(serviceRoleScreenMapping2));

        assertThat(result.createServiceRoleScreenMapping(0, 0, screen2, false, "createdBy"))
                .isEqualTo(new ServiceRoleScreenMapping());
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getSrsMappingID()).isEqualTo(0);
        assertThat(result.getScreenID()).isEqualTo(0);
        assertThat(result.getScreen()).isEqualTo(new Screen());
        assertThat(result.getProviderServiceMapping()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getRoleID()).isEqualTo(0);
        assertThat(result.getRole()).isEqualTo(new Role());
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testCreateServiceRoleScreenMapping1() {
        // Setup
        final Screen screen = new Screen();
        screen.setScreenID(0);
        final ServiceRoleScreenMapping serviceRoleScreenMapping = new ServiceRoleScreenMapping();
        serviceRoleScreenMapping.setSrsMappingID(0);
        serviceRoleScreenMapping.setScreenID(0);
        serviceRoleScreenMapping.setProviderServiceMapID(0);
        screen.setServiceRoleScreenMappings(List.of(serviceRoleScreenMapping));

        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        final ServiceRoleScreenMapping expectedResult = new ServiceRoleScreenMapping();
        expectedResult.setSrsMappingID(0);
        expectedResult.setScreenID(0);
        final Screen screen1 = new Screen();
        expectedResult.setScreen(screen1);
        expectedResult.setProviderServiceMapID(0);
        final ProviderServiceMapping providerServiceMapping1 = new ProviderServiceMapping();
        expectedResult.setProviderServiceMapping(providerServiceMapping1);
        expectedResult.setRoleID(0);
        expectedResult.setDeleted(false);
        expectedResult.setCreatedBy("createdBy");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final ServiceRoleScreenMapping result = serviceRoleScreenMappingUnderTest.createServiceRoleScreenMapping(0, 0,
                screen, 0, providerServiceMapping, 0, false, "createdBy");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testCreateServiceRoleScreenMapping2() {
        // Setup
        final Screen screen = new Screen();
        screen.setScreenID(0);
        final ServiceRoleScreenMapping serviceRoleScreenMapping = new ServiceRoleScreenMapping();
        serviceRoleScreenMapping.setSrsMappingID(0);
        serviceRoleScreenMapping.setScreenID(0);
        serviceRoleScreenMapping.setProviderServiceMapID(0);
        screen.setServiceRoleScreenMappings(List.of(serviceRoleScreenMapping));

        final ServiceRoleScreenMapping expectedResult = new ServiceRoleScreenMapping();
        expectedResult.setSrsMappingID(0);
        expectedResult.setScreenID(0);
        final Screen screen1 = new Screen();
        expectedResult.setScreen(screen1);
        expectedResult.setProviderServiceMapID(0);
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping();
        expectedResult.setProviderServiceMapping(providerServiceMapping);
        expectedResult.setRoleID(0);
        expectedResult.setDeleted(false);
        expectedResult.setCreatedBy("createdBy");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final ServiceRoleScreenMapping result = serviceRoleScreenMappingUnderTest.createServiceRoleScreenMapping(0, 0,
                screen, false, "createdBy");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        serviceRoleScreenMappingUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(serviceRoleScreenMappingUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testToString() throws Exception {
        assertThat(serviceRoleScreenMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSrsMappingIDGetterAndSetter() {
        final Integer srsMappingID = 0;
        serviceRoleScreenMappingUnderTest.setSrsMappingID(srsMappingID);
        assertThat(serviceRoleScreenMappingUnderTest.getSrsMappingID()).isEqualTo(srsMappingID);
    }

    @Test
    void testScreenIDGetterAndSetter() {
        final Integer screenID = 0;
        serviceRoleScreenMappingUnderTest.setScreenID(screenID);
        assertThat(serviceRoleScreenMappingUnderTest.getScreenID()).isEqualTo(screenID);
    }

    @Test
    void testScreenGetterAndSetter() {
        final Screen screen = new Screen();
        serviceRoleScreenMappingUnderTest.setScreen(screen);
        assertThat(serviceRoleScreenMappingUnderTest.getScreen()).isEqualTo(screen);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        serviceRoleScreenMappingUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(serviceRoleScreenMappingUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Integer roleID = 0;
        serviceRoleScreenMappingUnderTest.setRoleID(roleID);
        assertThat(serviceRoleScreenMappingUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testRoleGetterAndSetter() {
        final Role role = new Role();
        serviceRoleScreenMappingUnderTest.setRole(role);
        assertThat(serviceRoleScreenMappingUnderTest.getRole()).isEqualTo(role);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        serviceRoleScreenMappingUnderTest.setDeleted(deleted);
        assertThat(serviceRoleScreenMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        serviceRoleScreenMappingUnderTest.setCreatedBy(createdBy);
        assertThat(serviceRoleScreenMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        serviceRoleScreenMappingUnderTest.setCreatedDate(createdDate);
        assertThat(serviceRoleScreenMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        serviceRoleScreenMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(serviceRoleScreenMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        serviceRoleScreenMappingUnderTest.setLastModDate(lastModDate);
        assertThat(serviceRoleScreenMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        serviceRoleScreenMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(serviceRoleScreenMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(serviceRoleScreenMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(serviceRoleScreenMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(serviceRoleScreenMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
