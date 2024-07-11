package com.iemr.common.data.users;

import com.iemr.common.data.notification.Notification;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RoleTest {

	@InjectMocks
    private Role roleUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        roleUnderTest = new Role();
        roleUnderTest.setRoleID(0);
        roleUnderTest.setRoleName("roleName");
        roleUnderTest.setRoleDesc("roleDesc");
    }

    @Test
    void testCreateRole() {
        // Setup
        final UserServiceRoleMapping userServiceRoleMapping = new UserServiceRoleMapping();
        userServiceRoleMapping.setUSRMappingID(0L);
        userServiceRoleMapping.setDeleted(false);
        userServiceRoleMapping.setCreatedBy("createdBy");
        userServiceRoleMapping.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        userServiceRoleMapping.setModifiedBy("modifiedBy");
        final Set<UserServiceRoleMapping> m_UserServiceRoleMapping = Set.of(userServiceRoleMapping);
        final Role expectedResult = new Role();
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        final ServiceRoleScreenMapping serviceRoleScreenMapping = new ServiceRoleScreenMapping();
        expectedResult.setServiceRoleScreenMappings(List.of(serviceRoleScreenMapping));
        expectedResult.setWorkingLocationID(0);
        expectedResult.setAgentID("agentID");
        expectedResult.setInbound(false);
        expectedResult.setOutbound(false);
        expectedResult.setRoleID(0);
        expectedResult.setRoleName("roleName");
        expectedResult.setRoleDesc("roleDesc");
        final UserServiceRoleMapping userServiceRoleMapping1 = new UserServiceRoleMapping();
        expectedResult.setM_UserServiceRoleMapping(Set.of(userServiceRoleMapping1));

        // Run the test
        final Role result = roleUnderTest.createRole(0, "roleName", "roleDesc", false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), m_UserServiceRoleMapping);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testIsDeleted() {
        // Setup
        // Run the test
        final boolean result = roleUnderTest.isDeleted();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        roleUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        roleUnderTest.setCreatedBy(createdBy);
        assertThat(roleUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        roleUnderTest.setCreatedDate(createdDate);
        assertThat(roleUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        roleUnderTest.setModifiedBy(modifiedBy);
        assertThat(roleUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        roleUnderTest.setLastModDate(lastModDate);
        assertThat(roleUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testServiceRoleScreenMappingsGetterAndSetter() {
        final List<ServiceRoleScreenMapping> serviceRoleScreenMappings = List.of(new ServiceRoleScreenMapping());
        roleUnderTest.setServiceRoleScreenMappings(serviceRoleScreenMappings);
        assertThat(roleUnderTest.getServiceRoleScreenMappings()).isEqualTo(serviceRoleScreenMappings);
    }

    @Test
    void testToString() throws Exception {
        assertThat(roleUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInitializeRole() {
        // Run the test
        final Role result = Role.initializeRole(0, "roleName");
        final UserServiceRoleMapping userServiceRoleMapping = new UserServiceRoleMapping();
        userServiceRoleMapping.setUSRMappingID(0L);
        userServiceRoleMapping.setDeleted(false);
        userServiceRoleMapping.setCreatedBy("createdBy");
        userServiceRoleMapping.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        userServiceRoleMapping.setModifiedBy("modifiedBy");
        final Set<UserServiceRoleMapping> m_UserServiceRoleMapping = Set.of(userServiceRoleMapping);
        assertThat(result.createRole(0, "roleName", "roleDesc", false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), m_UserServiceRoleMapping))
                .isEqualTo(new Role());
        assertThat(result.isDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getRoleID()).isEqualTo(0);
        assertThat(result.getRoleName()).isEqualTo("RoleName");
        assertThat(result.getRoleDesc()).isEqualTo("RoleDesc");
        assertThat(result.getRoleID()).isEqualTo(0);
        assertThat(result.getRoleName()).isEqualTo("RoleName");
        assertThat(result.getRoleDesc()).isEqualTo("RoleDesc");
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getInbound()).isFalse();
        assertThat(result.getOutbound()).isFalse();
        assertThat(result.getM_UserServiceRoleMapping()).isEqualTo(Set.of(new UserServiceRoleMapping()));
        assertThat(result.getNotifications()).isEqualTo(Set.of(new Notification()));
        assertThat(result.getServiceRoleScreenMappings()).isEqualTo(List.of(new ServiceRoleScreenMapping()));
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.getWorkingLocationID()).isEqualTo(0);
        assertThat(result.getAgentID()).isEqualTo("agentID");
        assertThat(result.getIsSanjeevani()).isFalse();
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testWorkingLocationIDGetterAndSetter() {
        final Integer workingLocationID = 0;
        roleUnderTest.setWorkingLocationID(workingLocationID);
        assertThat(roleUnderTest.getWorkingLocationID()).isEqualTo(workingLocationID);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        roleUnderTest.setAgentID(agentID);
        assertThat(roleUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testInboundGetterAndSetter() {
        final Boolean inbound = false;
        roleUnderTest.setInbound(inbound);
        assertThat(roleUnderTest.getInbound()).isFalse();
    }

    @Test
    void testOutboundGetterAndSetter() {
        final Boolean outbound = false;
        roleUnderTest.setOutbound(outbound);
        assertThat(roleUnderTest.getOutbound()).isFalse();
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Integer roleID = 0;
        roleUnderTest.setRoleID(roleID);
        assertThat(roleUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testRoleNameGetterAndSetter() {
        final String roleName = "RoleName";
        roleUnderTest.setRoleName(roleName);
        assertThat(roleUnderTest.getRoleName()).isEqualTo(roleName);
    }

    @Test
    void testRoleDescGetterAndSetter() {
        final String roleDesc = "RoleDesc";
        roleUnderTest.setRoleDesc(roleDesc);
        assertThat(roleUnderTest.getRoleDesc()).isEqualTo(roleDesc);
    }

    @Test
    void testRoleID1GetterAndSetter() {
        final Integer roleID = 0;
        roleUnderTest.setRoleID(roleID);
        assertThat(roleUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testRoleName1GetterAndSetter() {
        final String roleName = "RoleName";
        roleUnderTest.setRoleName(roleName);
        assertThat(roleUnderTest.getRoleName()).isEqualTo(roleName);
    }

    @Test
    void testRoleDesc1GetterAndSetter() {
        final String roleDesc = "RoleDesc";
        roleUnderTest.setRoleDesc(roleDesc);
        assertThat(roleUnderTest.getRoleDesc()).isEqualTo(roleDesc);
    }

    @Test
    void testGetDeleted() {
        assertThat(roleUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testM_UserServiceRoleMappingGetterAndSetter() {
        final Set<UserServiceRoleMapping> m_UserServiceRoleMapping = Set.of(new UserServiceRoleMapping());
        roleUnderTest.setM_UserServiceRoleMapping(m_UserServiceRoleMapping);
        assertThat(roleUnderTest.getM_UserServiceRoleMapping()).isEqualTo(m_UserServiceRoleMapping);
    }

    @Test
    void testNotificationsGetterAndSetter() {
        final Set<Notification> notifications = Set.of(new Notification());
        roleUnderTest.setNotifications(notifications);
        assertThat(roleUnderTest.getNotifications()).isEqualTo(notifications);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        roleUnderTest.setOutputMapper(outputMapper);
        assertThat(roleUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testIsSanjeevaniGetterAndSetter() {
        final Boolean isSanjeevani = false;
        roleUnderTest.setIsSanjeevani(isSanjeevani);
        assertThat(roleUnderTest.getIsSanjeevani()).isFalse();
    }

    @Test
    void testEquals() throws Exception {
        assertThat(roleUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(roleUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(roleUnderTest.hashCode()).isEqualTo(0);
    }
}
