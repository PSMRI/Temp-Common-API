package com.iemr.common.data.users;

import com.iemr.common.utils.mapper.OutputMapper;
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
class ProviderServiceAddressMappingTest {

	@InjectMocks
    private ProviderServiceAddressMapping providerServiceAddressMappingUnderTest;

    @BeforeEach
    void setUp() {
        providerServiceAddressMappingUnderTest = new ProviderServiceAddressMapping();
    }

    @Test
    void testToString() {
        assertThat(providerServiceAddressMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testPSAddMapIDGetterAndSetter() {
        final Integer pSAddMapID = 0;
        providerServiceAddressMappingUnderTest.setPSAddMapID(pSAddMapID);
        assertThat(providerServiceAddressMappingUnderTest.getpSAddMapID()).isEqualTo(pSAddMapID);
    }

    @Test
    void testUserServiceRoleMappingsGetterAndSetter() {
        final List<UserServiceRoleMapping> userServiceRoleMappings = List.of(new UserServiceRoleMapping());
        providerServiceAddressMappingUnderTest.setUserServiceRoleMappings(userServiceRoleMappings);
        assertThat(providerServiceAddressMappingUnderTest.getUserServiceRoleMappings())
                .isEqualTo(userServiceRoleMappings);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        providerServiceAddressMappingUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(providerServiceAddressMappingUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        providerServiceAddressMappingUnderTest.setDistrictID(districtID);
        assertThat(providerServiceAddressMappingUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "address";
        providerServiceAddressMappingUnderTest.setAddress(address);
        assertThat(providerServiceAddressMappingUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        providerServiceAddressMappingUnderTest.setDeleted(deleted);
        assertThat(providerServiceAddressMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        providerServiceAddressMappingUnderTest.setCreatedBy(createdBy);
        assertThat(providerServiceAddressMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        providerServiceAddressMappingUnderTest.setCreatedDate(createdDate);
        assertThat(providerServiceAddressMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        providerServiceAddressMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(providerServiceAddressMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        providerServiceAddressMappingUnderTest.setLastModDate(lastModDate);
        assertThat(providerServiceAddressMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testLocationNameGetterAndSetter() {
        final String locationName = "locationName";
        providerServiceAddressMappingUnderTest.setLocationName(locationName);
        assertThat(providerServiceAddressMappingUnderTest.getLocationName()).isEqualTo(locationName);
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        providerServiceAddressMappingUnderTest.setMapper(mapper);
        assertThat(providerServiceAddressMappingUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testEquals() {
        assertThat(providerServiceAddressMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(providerServiceAddressMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(providerServiceAddressMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
