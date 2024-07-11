package com.iemr.common.data.users;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.service.SubService;
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
class ServiceMasterTest {

	@InjectMocks
    private ServiceMaster serviceMasterUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        serviceMasterUnderTest = new ServiceMaster(0, "serviceName", "serviceDesc", false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), Set.of(new UserServiceRoleMapping()));
    }

    @Test
    void testGetServiceID() {
        assertThat(serviceMasterUnderTest.getServiceID()).isEqualTo(0);
    }

    @Test
    void testSetServiceID() {
        // Setup
        // Run the test
        serviceMasterUnderTest.setServiceID(0);

        // Verify the results
    }

    @Test
    void testServiceNameGetterAndSetter() {
        final String serviceName = "serviceName";
        serviceMasterUnderTest.setServiceName(serviceName);
        assertThat(serviceMasterUnderTest.getServiceName()).isEqualTo(serviceName);
    }

    @Test
    void testServiceDescGetterAndSetter() {
        final String serviceDesc = "serviceDesc";
        serviceMasterUnderTest.setServiceDesc(serviceDesc);
        assertThat(serviceMasterUnderTest.getServiceDesc()).isEqualTo(serviceDesc);
    }

    @Test
    void testIsDeleted() {
        // Setup
        // Run the test
        final boolean result = serviceMasterUnderTest.isDeleted();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        serviceMasterUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        serviceMasterUnderTest.setCreatedBy(createdBy);
        assertThat(serviceMasterUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        serviceMasterUnderTest.setCreatedDate(createdDate);
        assertThat(serviceMasterUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        serviceMasterUnderTest.setModifiedBy(modifiedBy);
        assertThat(serviceMasterUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        serviceMasterUnderTest.setLastModDate(lastModDate);
        assertThat(serviceMasterUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() throws Exception {
        assertThat(serviceMasterUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetDeleted() {
        assertThat(serviceMasterUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testM_UserServiceRoleMappingGetterAndSetter() {
        final Set<UserServiceRoleMapping> m_UserServiceRoleMapping = Set.of(new UserServiceRoleMapping());
        serviceMasterUnderTest.setM_UserServiceRoleMapping(m_UserServiceRoleMapping);
        assertThat(serviceMasterUnderTest.getM_UserServiceRoleMapping()).isEqualTo(m_UserServiceRoleMapping);
    }

    @Test
    void testSubServicesGetterAndSetter() {
        final Set<SubService> subServices = Set.of(new SubService(0, "subServiceName", "subServiceDesc", false));
        serviceMasterUnderTest.setSubServices(subServices);
        assertThat(serviceMasterUnderTest.getSubServices()).isEqualTo(subServices);
    }

    @Test
    void testFeedbacksGetterAndSetter() {
        final List<FeedbackDetails> feedbacks = List.of(new FeedbackDetails());
        serviceMasterUnderTest.setFeedbacks(feedbacks);
        assertThat(serviceMasterUnderTest.getFeedbacks()).isEqualTo(feedbacks);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        serviceMasterUnderTest.setOutputMapper(outputMapper);
        assertThat(serviceMasterUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(serviceMasterUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(serviceMasterUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(serviceMasterUnderTest.hashCode()).isEqualTo(0);
    }
}
