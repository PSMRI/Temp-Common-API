package com.iemr.common.data.userbeneficiarydata;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.data.users.ServiceProvider;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StatusTest {

	@InjectMocks
    private Status statusUnderTest;

    @BeforeEach
    void setUp() {
        statusUnderTest = new Status(0, "status", "statusDesc", false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), Set.of(new User()));
    }

    @Test
    void testGetStatusID() {
        // Setup
        // Run the test
        final int result = statusUnderTest.getStatusID();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testSetStatusID() {
        // Setup
        // Run the test
        statusUnderTest.setStatusID(0);

        // Verify the results
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        statusUnderTest.setStatus(status);
        assertThat(statusUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testStatusDescGetterAndSetter() {
        final String statusDesc = "statusDesc";
        statusUnderTest.setStatusDesc(statusDesc);
        assertThat(statusUnderTest.getStatusDesc()).isEqualTo(statusDesc);
    }

    @Test
    void testIsDeleted() {
        // Setup
        // Run the test
        final boolean result = statusUnderTest.isDeleted();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        statusUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        statusUnderTest.setCreatedBy(createdBy);
        assertThat(statusUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        statusUnderTest.setCreatedDate(createdDate);
        assertThat(statusUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        statusUnderTest.setModifiedBy(modifiedBy);
        assertThat(statusUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        statusUnderTest.setLastModDate(lastModDate);
        assertThat(statusUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(statusUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testM_UsersGetterAndSetter() {
        final Set<User> m_Users = Set.of(new User());
        statusUnderTest.setM_Users(m_Users);
        assertThat(statusUnderTest.getM_Users()).isEqualTo(m_Users);
    }

    @Test
    void testI_BeneficiariesGetterAndSetter() {
        final Set<Beneficiary> i_Beneficiaries = Set.of(new Beneficiary());
        statusUnderTest.setI_Beneficiaries(i_Beneficiaries);
        assertThat(statusUnderTest.getI_Beneficiaries()).isEqualTo(i_Beneficiaries);
    }

    @Test
    void testServiceProvidersGetterAndSetter() {
        final Set<ServiceProvider> serviceProviders = Set.of(new ServiceProvider());
        statusUnderTest.setServiceProviders(serviceProviders);
        assertThat(statusUnderTest.getServiceProviders()).isEqualTo(serviceProviders);
    }

    @Test
    void testProviderServiceMappingsGetterAndSetter() {
        final Set<ProviderServiceMapping> providerServiceMappings = Set.of(new ProviderServiceMapping(false, 0));
        statusUnderTest.setProviderServiceMappings(providerServiceMappings);
        assertThat(statusUnderTest.getProviderServiceMappings()).isEqualTo(providerServiceMappings);
    }

    @Test
    void testGetDeleted() {
        assertThat(statusUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        statusUnderTest.setOutputMapper(outputMapper);
        assertThat(statusUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        // Setup
        // Run the test
        final boolean result = statusUnderTest.equals("o");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(statusUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        // Setup
        // Run the test
        final int result = statusUnderTest.hashCode();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
