package com.iemr.common.data.service;

import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SubServiceTest {

	@InjectMocks
    private SubService subServiceUnderTest;

    @BeforeEach
    void setUp() {
        subServiceUnderTest = new SubService(0, "subServiceName", "subServiceDesc", false);
    }

    @Test
    void testToString() {
        assertThat(subServiceUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSubServiceIDGetterAndSetter() {
        final Integer subServiceID = 0;
        subServiceUnderTest.setSubServiceID(subServiceID);
        assertThat(subServiceUnderTest.getSubServiceID()).isEqualTo(subServiceID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        subServiceUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(subServiceUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testServiceGetterAndSetter() {
        final ProviderServiceMapping service = new ProviderServiceMapping(false, 0);
        subServiceUnderTest.setService(service);
        assertThat(subServiceUnderTest.getService()).isEqualTo(service);
    }

    @Test
    void testSubServiceNameGetterAndSetter() {
        final String subServiceName = "subServiceName";
        subServiceUnderTest.setSubServiceName(subServiceName);
        assertThat(subServiceUnderTest.getSubServiceName()).isEqualTo(subServiceName);
    }

    @Test
    void testSubServiceDescGetterAndSetter() {
        final String subServiceDesc = "subServiceDesc";
        subServiceUnderTest.setSubServiceDesc(subServiceDesc);
        assertThat(subServiceUnderTest.getSubServiceDesc()).isEqualTo(subServiceDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        subServiceUnderTest.setDeleted(deleted);
        assertThat(subServiceUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        subServiceUnderTest.setCreatedBy(createdBy);
        assertThat(subServiceUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        subServiceUnderTest.setCreatedDate(createdDate);
        assertThat(subServiceUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        subServiceUnderTest.setModifiedBy(modifiedBy);
        assertThat(subServiceUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        subServiceUnderTest.setLastModDate(lastModDate);
        assertThat(subServiceUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        subServiceUnderTest.setOutputMapper(outputMapper);
        assertThat(subServiceUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(subServiceUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(subServiceUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(subServiceUnderTest.hashCode()).isEqualTo(0);
    }
}
