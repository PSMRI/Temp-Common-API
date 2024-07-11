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
class UserServiceRoleMappingTest {

	@InjectMocks
    private UserServiceRoleMapping userServiceRoleMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userServiceRoleMappingUnderTest = new UserServiceRoleMapping();
        userServiceRoleMappingUnderTest.setRoleID(0);
    }

    @Test
    void testUSRMappingIDGetterAndSetter() {
        final Long uSRMappingID = 0L;
        userServiceRoleMappingUnderTest.createUserRoleMappingByID(uSRMappingID);
        assertThat(userServiceRoleMappingUnderTest.getUSRMappingID()).isEqualTo(uSRMappingID);
    }

    @Test
    void testCreateUserServiceRoleMapping() {
        // Setup
        final User m_user = new User();
        m_user.setUserID(0L);
        m_user.setTitleID(0);
        m_user.setFirstName("firstName");
        m_user.setMiddleName("middleName");
        m_user.setLastName("lastName");

        final Role m_Role = new Role();
        m_Role.setDeleted(false);
        m_Role.setWorkingLocationID(0);
        m_Role.setAgentID("agentID");
        m_Role.setInbound(false);
        m_Role.setOutbound(false);

        final ProviderServiceMapping m_ProviderServiceMapping = new ProviderServiceMapping(false, 0);
        final UserServiceRoleMapping expectedResult = new UserServiceRoleMapping();
        expectedResult.setUSRMappingID(0L);
        expectedResult.setDeleted(false);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setUserID(0L);
        final User m_user1 = new User();
        expectedResult.setM_user(m_user1);
        final Role m_Role1 = new Role();
        m_Role1.setWorkingLocationID(0);
        m_Role1.setAgentID("agentID");
        m_Role1.setInbound(false);
        m_Role1.setOutbound(false);
        expectedResult.setM_Role(m_Role1);
        expectedResult.setRoleID(0);
        expectedResult.setProviderServiceMapID(0);
        final ProviderServiceMapping m_ProviderServiceMapping1 = new ProviderServiceMapping();
        expectedResult.setM_ProviderServiceMapping(m_ProviderServiceMapping1);
        expectedResult.setAgentID("agentID");
        expectedResult.setAgentPassword("agentPassword");
        expectedResult.setInbound(false);
        expectedResult.setOutbound(false);
        expectedResult.setIsSanjeevani(false);
        expectedResult.setWorkingLocationID(0);
        final ProviderServiceAddressMapping providerServiceAddressMapping = new ProviderServiceAddressMapping();
        expectedResult.setProviderServiceAddressMapping(providerServiceAddressMapping);
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);
        expectedResult.setLanguageName("languageName");

        // Run the test
        final UserServiceRoleMapping result = userServiceRoleMappingUnderTest.createUserServiceRoleMapping(0L, m_user,
                m_Role, m_ProviderServiceMapping, false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUSRMappingID1GetterAndSetter() {
        final Long uSRMappingID = 0L;
        userServiceRoleMappingUnderTest.setUSRMappingID(uSRMappingID);
        assertThat(userServiceRoleMappingUnderTest.getUSRMappingID()).isEqualTo(uSRMappingID);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        userServiceRoleMappingUnderTest.setDeleted(deleted);
        assertThat(userServiceRoleMappingUnderTest.isDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        userServiceRoleMappingUnderTest.setCreatedBy(createdBy);
        assertThat(userServiceRoleMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userServiceRoleMappingUnderTest.setCreatedDate(createdDate);
        assertThat(userServiceRoleMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        userServiceRoleMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(userServiceRoleMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userServiceRoleMappingUnderTest.setLastModDate(lastModDate);
        assertThat(userServiceRoleMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        userServiceRoleMappingUnderTest.setUserID(userID);
        assertThat(userServiceRoleMappingUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testGetServiceID() {
        assertThat(userServiceRoleMappingUnderTest.getServiceID()).isEqualTo(0);
    }

    @Test
    void testSetServiceID() {
        // Setup
        // Run the test
        userServiceRoleMappingUnderTest.setServiceID(0);

        // Verify the results
    }

    @Test
    void testDeleted1GetterAndSetter() {
        final Boolean deleted = false;
        userServiceRoleMappingUnderTest.setDeleted(deleted);
        assertThat(userServiceRoleMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testToString() throws Exception {
        assertThat(userServiceRoleMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInitializeUserRoleMappingObjs() {
        // Setup
        final Role m_Role = new Role();
        m_Role.setDeleted(false);
        m_Role.setWorkingLocationID(0);
        m_Role.setAgentID("agentID");
        m_Role.setInbound(false);
        m_Role.setOutbound(false);

        final ProviderServiceMapping m_ProviderServiceMapping = new ProviderServiceMapping(false, 0);
        final ProviderServiceAddressMapping providerServiceAddressMapping = new ProviderServiceAddressMapping();
        providerServiceAddressMapping.setPSAddMapID(0);
        final UserServiceRoleMapping userServiceRoleMapping = new UserServiceRoleMapping();
        userServiceRoleMapping.setUSRMappingID(0L);
        userServiceRoleMapping.setDeleted(false);
        userServiceRoleMapping.setCreatedBy("createdBy");
        providerServiceAddressMapping.setUserServiceRoleMappings(List.of(userServiceRoleMapping));

        // Run the test
        final UserServiceRoleMapping result = UserServiceRoleMapping.initializeUserRoleMappingObjs(0L, 0L, 0, m_Role, 0,
                m_ProviderServiceMapping, "agentID", false, false, false, "agentPassword", 0,
                providerServiceAddressMapping);
        final User m_user = new User();
        m_user.setUserID(0L);
        m_user.setTitleID(0);
        m_user.setFirstName("firstName");
        m_user.setMiddleName("middleName");
        m_user.setLastName("lastName");

        final Role m_Role1 = new Role();
        m_Role1.setDeleted(false);
        m_Role1.setWorkingLocationID(0);
        m_Role1.setAgentID("agentID");
        m_Role1.setInbound(false);
        m_Role1.setOutbound(false);

        final ProviderServiceMapping m_ProviderServiceMapping1 = new ProviderServiceMapping(false, 0);
        assertThat(
                result.createUserServiceRoleMapping(0L, m_user, m_Role1, m_ProviderServiceMapping1, false, "createdBy",
                        Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                        Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0))
                .isEqualTo(new UserServiceRoleMapping());
        assertThat(result.getUSRMappingID()).isEqualTo(0L);
        assertThat(result.isDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getUserID()).isEqualTo(0L);
        assertThat(result.getServiceID()).isEqualTo(0);
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getAgentID()).isEqualTo("agentID");
        assertThat(result.getInbound()).isFalse();
        assertThat(result.getOutbound()).isFalse();
        assertThat(result.getAgentPassword()).isEqualTo("agentPassword");
        assertThat(result.getWorkingLocationID()).isEqualTo(0);
        assertThat(result.getLanguageName()).isEqualTo("languageName");
        assertThat(result.getM_user()).isEqualTo(new User());
        assertThat(result.getRoleID()).isEqualTo(0);
        assertThat(result.getM_Role()).isEqualTo(new Role());
        assertThat(result.getRoleID()).isEqualTo(0);
        assertThat(result.getM_ProviderServiceMapping()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getIsSanjeevani()).isFalse();
        assertThat(result.getProviderServiceAddressMapping()).isEqualTo(new ProviderServiceAddressMapping());
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        userServiceRoleMappingUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(userServiceRoleMappingUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testAgentIDGetterAndSetter() {
        final String agentID = "agentID";
        userServiceRoleMappingUnderTest.setAgentID(agentID);
        assertThat(userServiceRoleMappingUnderTest.getAgentID()).isEqualTo(agentID);
    }

    @Test
    void testInboundGetterAndSetter() {
        final Boolean inbound = false;
        userServiceRoleMappingUnderTest.setInbound(inbound);
        assertThat(userServiceRoleMappingUnderTest.getInbound()).isFalse();
    }

    @Test
    void testOutboundGetterAndSetter() {
        final Boolean outbound = false;
        userServiceRoleMappingUnderTest.setOutbound(outbound);
        assertThat(userServiceRoleMappingUnderTest.getOutbound()).isFalse();
    }

    @Test
    void testAgentPasswordGetterAndSetter() {
        final String agentPassword = "agentPassword";
        userServiceRoleMappingUnderTest.setAgentPassword(agentPassword);
        assertThat(userServiceRoleMappingUnderTest.getAgentPassword()).isEqualTo(agentPassword);
    }

    @Test
    void testWorkingLocationIDGetterAndSetter() {
        final Integer workingLocationID = 0;
        userServiceRoleMappingUnderTest.setWorkingLocationID(workingLocationID);
        assertThat(userServiceRoleMappingUnderTest.getWorkingLocationID()).isEqualTo(workingLocationID);
    }

    @Test
    void testLanguageNameGetterAndSetter() {
        final String languageName = "languageName";
        userServiceRoleMappingUnderTest.setLanguageName(languageName);
        assertThat(userServiceRoleMappingUnderTest.getLanguageName()).isEqualTo(languageName);
    }

    @Test
    void testM_userGetterAndSetter() {
        final User m_user = new User();
        userServiceRoleMappingUnderTest.setM_user(m_user);
        assertThat(userServiceRoleMappingUnderTest.getM_user()).isEqualTo(m_user);
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Integer roleID = 0;
        userServiceRoleMappingUnderTest.setRoleID(roleID);
        assertThat(userServiceRoleMappingUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testM_RoleGetterAndSetter() {
        final Role m_Role = new Role();
        userServiceRoleMappingUnderTest.setM_Role(m_Role);
        assertThat(userServiceRoleMappingUnderTest.getM_Role()).isEqualTo(m_Role);
    }

    @Test
    void testRoleID1GetterAndSetter() {
        final Integer roleID = 0;
        userServiceRoleMappingUnderTest.setRoleID(roleID);
        assertThat(userServiceRoleMappingUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testM_ProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping m_ProviderServiceMapping = new ProviderServiceMapping(false, 0);
        userServiceRoleMappingUnderTest.setM_ProviderServiceMapping(m_ProviderServiceMapping);
        assertThat(userServiceRoleMappingUnderTest.getM_ProviderServiceMapping()).isEqualTo(m_ProviderServiceMapping);
    }

    @Test
    void testIsSanjeevaniGetterAndSetter() {
        final Boolean isSanjeevani = false;
        userServiceRoleMappingUnderTest.setIsSanjeevani(isSanjeevani);
        assertThat(userServiceRoleMappingUnderTest.getIsSanjeevani()).isFalse();
    }

    @Test
    void testProviderServiceAddressMappingGetterAndSetter() {
        final ProviderServiceAddressMapping providerServiceAddressMapping = new ProviderServiceAddressMapping();
        userServiceRoleMappingUnderTest.setProviderServiceAddressMapping(providerServiceAddressMapping);
        assertThat(userServiceRoleMappingUnderTest.getProviderServiceAddressMapping())
                .isEqualTo(providerServiceAddressMapping);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        userServiceRoleMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(userServiceRoleMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userServiceRoleMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userServiceRoleMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userServiceRoleMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
