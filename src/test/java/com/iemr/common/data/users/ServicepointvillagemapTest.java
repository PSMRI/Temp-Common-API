package com.iemr.common.data.users;

import com.iemr.common.data.location.DistrictBranchMapping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ServicepointvillagemapTest {

	@InjectMocks
    private Servicepointvillagemap servicepointvillagemapUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        servicepointvillagemapUnderTest = new Servicepointvillagemap(0, "villageName");
    }

    @Test
    void testServicePointIDGetterAndSetter() {
        final Integer servicePointID = 0;
        servicepointvillagemapUnderTest.setServicePointID(servicePointID);
        assertThat(servicepointvillagemapUnderTest.getServicePointID()).isEqualTo(servicePointID);
    }

    @Test
    void testDistrictBranchIDGetterAndSetter() {
        final Integer districtBranchID = 0;
        servicepointvillagemapUnderTest.setDistrictBranchID(districtBranchID);
        assertThat(servicepointvillagemapUnderTest.getDistrictBranchID()).isEqualTo(districtBranchID);
    }

    @Test
    void testDistrictBranchMappingGetterAndSetter() {
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping(0, "VillageName", "PanchayatName",
                "Habitat", "PinCode");
        servicepointvillagemapUnderTest.setDistrictBranchMapping(districtBranchMapping);
        assertThat(servicepointvillagemapUnderTest.getDistrictBranchMapping()).isEqualTo(districtBranchMapping);
    }

    @Test
    void testVillageNameGetterAndSetter() {
        final String villageName = "villageName";
        servicepointvillagemapUnderTest.setVillageName(villageName);
        assertThat(servicepointvillagemapUnderTest.getVillageName()).isEqualTo(villageName);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        servicepointvillagemapUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(servicepointvillagemapUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        servicepointvillagemapUnderTest.setDeleted(deleted);
        assertThat(servicepointvillagemapUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        servicepointvillagemapUnderTest.setProcessed(processed);
        assertThat(servicepointvillagemapUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        servicepointvillagemapUnderTest.setCreatedBy(createdBy);
        assertThat(servicepointvillagemapUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        servicepointvillagemapUnderTest.setCreatedDate(createdDate);
        assertThat(servicepointvillagemapUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        servicepointvillagemapUnderTest.setModifiedBy(modifiedBy);
        assertThat(servicepointvillagemapUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        servicepointvillagemapUnderTest.setLastModDate(lastModDate);
        assertThat(servicepointvillagemapUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testServicePointVillageMapIDGetterAndSetter() {
        final Integer servicePointVillageMapID = 0;
        servicepointvillagemapUnderTest.setServicePointVillageMapID(servicePointVillageMapID);
        assertThat(servicepointvillagemapUnderTest.getServicePointVillageMapID()).isEqualTo(servicePointVillageMapID);
    }

    @Test
    void testM_providerServiceMappingGetterAndSetter() {
        final ProviderServiceMapping m_providerServiceMapping = new ProviderServiceMapping(false, 0);
        servicepointvillagemapUnderTest.setM_providerServiceMapping(m_providerServiceMapping);
        assertThat(servicepointvillagemapUnderTest.getM_providerServiceMapping()).isEqualTo(m_providerServiceMapping);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(servicepointvillagemapUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(servicepointvillagemapUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(servicepointvillagemapUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(servicepointvillagemapUnderTest.toString()).isEqualTo("result");
    }
}
