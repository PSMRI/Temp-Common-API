package com.iemr.common.data.users;

import com.iemr.common.data.userbeneficiarydata.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ServiceProviderTest {

	@InjectMocks
    private ServiceProvider serviceProviderUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        serviceProviderUnderTest = new ServiceProvider();
    }

    @Test
    void testServiceProviderIDGetterAndSetter() {
        final Integer serviceProviderID = 0;
        serviceProviderUnderTest.setServiceProviderID(serviceProviderID);
        assertThat(serviceProviderUnderTest.getServiceProviderID()).isEqualTo(serviceProviderID);
    }

    @Test
    void testServiceProviderNameGetterAndSetter() {
        final String serviceProviderName = "serviceProviderName";
        serviceProviderUnderTest.setServiceProviderName(serviceProviderName);
        assertThat(serviceProviderUnderTest.getServiceProviderName()).isEqualTo(serviceProviderName);
    }

    @Test
    void testJoiningDateGetterAndSetter() {
        final Date joiningDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setJoiningDate(joiningDate);
        assertThat(serviceProviderUnderTest.getJoiningDate()).isEqualTo(joiningDate);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        serviceProviderUnderTest.setStateID(stateID);
        assertThat(serviceProviderUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testLogoFileNameGetterAndSetter() {
        final String logoFileName = "logoFileName";
        serviceProviderUnderTest.setLogoFileName(logoFileName);
        assertThat(serviceProviderUnderTest.getLogoFileName()).isEqualTo(logoFileName);
    }

    @Test
    void testLogoFilePathGetterAndSetter() {
        final String logoFilePath = "logoFilePath";
        serviceProviderUnderTest.setLogoFilePath(logoFilePath);
        assertThat(serviceProviderUnderTest.getLogoFilePath()).isEqualTo(logoFilePath);
    }

    @Test
    void testPrimaryContactNameGetterAndSetter() {
        final String primaryContactName = "primaryContactName";
        serviceProviderUnderTest.setPrimaryContactName(primaryContactName);
        assertThat(serviceProviderUnderTest.getPrimaryContactName()).isEqualTo(primaryContactName);
    }

    @Test
    void testPrimaryContactNoGetterAndSetter() {
        final String primaryContactNo = "primaryContactNo";
        serviceProviderUnderTest.setPrimaryContactNo(primaryContactNo);
        assertThat(serviceProviderUnderTest.getPrimaryContactNo()).isEqualTo(primaryContactNo);
    }

    @Test
    void testPrimaryContactEmailIDGetterAndSetter() {
        final String primaryContactEmailID = "primaryContactEmailID";
        serviceProviderUnderTest.setPrimaryContactEmailID(primaryContactEmailID);
        assertThat(serviceProviderUnderTest.getPrimaryContactEmailID()).isEqualTo(primaryContactEmailID);
    }

    @Test
    void testPrimaryContactAddressGetterAndSetter() {
        final String primaryContactAddress = "primaryContactAddress";
        serviceProviderUnderTest.setPrimaryContactAddress(primaryContactAddress);
        assertThat(serviceProviderUnderTest.getPrimaryContactAddress()).isEqualTo(primaryContactAddress);
    }

    @Test
    void testPrimaryContactValidityTillDateGetterAndSetter() {
        final Date primaryContactValidityTillDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setPrimaryContactValidityTillDate(primaryContactValidityTillDate);
        assertThat(serviceProviderUnderTest.getPrimaryContactValidityTillDate())
                .isEqualTo(primaryContactValidityTillDate);
    }

    @Test
    void testSecondaryContactNameGetterAndSetter() {
        final String secondaryContactName = "secondaryContactName";
        serviceProviderUnderTest.setSecondaryContactName(secondaryContactName);
        assertThat(serviceProviderUnderTest.getSecondaryContactName()).isEqualTo(secondaryContactName);
    }

    @Test
    void testSecondaryContactNoGetterAndSetter() {
        final String secondaryContactNo = "secondaryContactNo";
        serviceProviderUnderTest.setSecondaryContactNo(secondaryContactNo);
        assertThat(serviceProviderUnderTest.getSecondaryContactNo()).isEqualTo(secondaryContactNo);
    }

    @Test
    void testSecondaryContactEmailIDGetterAndSetter() {
        final String secondaryContactEmailID = "secondaryContactEmailID";
        serviceProviderUnderTest.setSecondaryContactEmailID(secondaryContactEmailID);
        assertThat(serviceProviderUnderTest.getSecondaryContactEmailID()).isEqualTo(secondaryContactEmailID);
    }

    @Test
    void testSecondaryContactAddressGetterAndSetter() {
        final String secondaryContactAddress = "secondaryContactAddress";
        serviceProviderUnderTest.setSecondaryContactAddress(secondaryContactAddress);
        assertThat(serviceProviderUnderTest.getSecondaryContactAddress()).isEqualTo(secondaryContactAddress);
    }

    @Test
    void testSecondaryContactValidityTillDateGetterAndSetter() {
        final Date secondaryContactValidityTillDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setSecondaryContactValidityTillDate(secondaryContactValidityTillDate);
        assertThat(serviceProviderUnderTest.getSecondaryContactValidityTillDate())
                .isEqualTo(secondaryContactValidityTillDate);
    }

    @Test
    void testStatusIDGetterAndSetter() {
        final Integer statusID = 0;
        serviceProviderUnderTest.setStatusID(statusID);
        assertThat(serviceProviderUnderTest.getStatusID()).isEqualTo(statusID);
    }

    @Test
    void testValidFromGetterAndSetter() {
        final Date validFrom = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setValidFrom(validFrom);
        assertThat(serviceProviderUnderTest.getValidFrom()).isEqualTo(validFrom);
    }

    @Test
    void testValidTillGetterAndSetter() {
        final Date validTill = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setValidTill(validTill);
        assertThat(serviceProviderUnderTest.getValidTill()).isEqualTo(validTill);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        serviceProviderUnderTest.setDeleted(deleted);
        assertThat(serviceProviderUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        serviceProviderUnderTest.setCreatedBy(createdBy);
        assertThat(serviceProviderUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setCreatedDate(createdDate);
        assertThat(serviceProviderUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        serviceProviderUnderTest.setModifiedBy(modifiedBy);
        assertThat(serviceProviderUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        serviceProviderUnderTest.setLastModDate(lastModDate);
        assertThat(serviceProviderUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testProviderServiceMappingsGetterAndSetter() {
        final List<ProviderServiceMapping> providerServiceMappings = List.of(new ProviderServiceMapping(false, 0));
        serviceProviderUnderTest.setProviderServiceMappings(providerServiceMappings);
        assertThat(serviceProviderUnderTest.getProviderServiceMappings()).isEqualTo(providerServiceMappings);
    }

    @Test
    void testStatusGetterAndSetter() {
        final Status status = new Status();
        serviceProviderUnderTest.setStatus(status);
        assertThat(serviceProviderUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(serviceProviderUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(serviceProviderUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(serviceProviderUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(serviceProviderUnderTest.toString()).isEqualTo("result");
    }
}
