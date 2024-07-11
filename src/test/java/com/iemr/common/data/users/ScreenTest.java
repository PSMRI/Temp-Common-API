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
class ScreenTest {

	@InjectMocks
    private Screen screenUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        screenUnderTest = new Screen();
    }

    @Test
    void testToString() throws Exception {
        assertThat(screenUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testScreenIDGetterAndSetter() {
        final Integer screenID = 0;
        screenUnderTest.setScreenID(screenID);
        assertThat(screenUnderTest.getScreenID()).isEqualTo(screenID);
    }

    @Test
    void testServiceRoleScreenMappingsGetterAndSetter() {
        final List<ServiceRoleScreenMapping> serviceRoleScreenMappings = List.of(new ServiceRoleScreenMapping());
        screenUnderTest.setServiceRoleScreenMappings(serviceRoleScreenMappings);
        assertThat(screenUnderTest.getServiceRoleScreenMappings()).isEqualTo(serviceRoleScreenMappings);
    }

    @Test
    void testScreenNameGetterAndSetter() {
        final String screenName = "screenName";
        screenUnderTest.setScreenName(screenName);
        assertThat(screenUnderTest.getScreenName()).isEqualTo(screenName);
    }

    @Test
    void testApiUsedGetterAndSetter() {
        final String apiUsed = "apiUsed";
        screenUnderTest.setApiUsed(apiUsed);
        assertThat(screenUnderTest.getApiUsed()).isEqualTo(apiUsed);
    }

    @Test
    void testWorkflowNameGetterAndSetter() {
        final String workflowName = "workflowName";
        screenUnderTest.setWorkflowName(workflowName);
        assertThat(screenUnderTest.getWorkflowName()).isEqualTo(workflowName);
    }

    @Test
    void testScreenDescGetterAndSetter() {
        final String screenDesc = "screenDesc";
        screenUnderTest.setScreenDesc(screenDesc);
        assertThat(screenUnderTest.getScreenDesc()).isEqualTo(screenDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        screenUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(screenUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        screenUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(screenUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        screenUnderTest.setDeleted(deleted);
        assertThat(screenUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        screenUnderTest.setCreatedBy(createdBy);
        assertThat(screenUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        screenUnderTest.setCreatedDate(createdDate);
        assertThat(screenUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        screenUnderTest.setModifiedBy(modifiedBy);
        assertThat(screenUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        screenUnderTest.setLastModDate(lastModDate);
        assertThat(screenUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        screenUnderTest.setOutputMapper(outputMapper);
        assertThat(screenUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(screenUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(screenUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(screenUnderTest.hashCode()).isEqualTo(0);
    }
}
