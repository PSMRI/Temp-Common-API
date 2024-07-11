package com.iemr.common.data.institute;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class InstituteTypeTest {

	@InjectMocks
    private InstituteType instituteTypeUnderTest;

    @BeforeEach
    void setUp() {
        instituteTypeUnderTest = new InstituteType();
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        instituteTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(instituteTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testToString() {
        assertThat(instituteTypeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInstitutionTypeIDGetterAndSetter() {
        final Integer institutionTypeID = 0;
        instituteTypeUnderTest.setInstitutionTypeID(institutionTypeID);
        assertThat(instituteTypeUnderTest.getInstitutionTypeID()).isEqualTo(institutionTypeID);
    }

    @Test
    void testInstitutionTypeGetterAndSetter() {
        final String institutionType = "institutionType";
        instituteTypeUnderTest.setInstitutionType(institutionType);
        assertThat(instituteTypeUnderTest.getInstitutionType()).isEqualTo(institutionType);
    }

    @Test
    void testInstitutionTypeDescGetterAndSetter() {
        final String institutionTypeDesc = "institutionTypeDesc";
        instituteTypeUnderTest.setInstitutionTypeDesc(institutionTypeDesc);
        assertThat(instituteTypeUnderTest.getInstitutionTypeDesc()).isEqualTo(institutionTypeDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        instituteTypeUnderTest.setDeleted(deleted);
        assertThat(instituteTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        instituteTypeUnderTest.setCreatedBy(createdBy);
        assertThat(instituteTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        instituteTypeUnderTest.setCreatedDate(createdDate);
        assertThat(instituteTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        instituteTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(instituteTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        instituteTypeUnderTest.setLastModDate(lastModDate);
        assertThat(instituteTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        instituteTypeUnderTest.setOutputMapper(outputMapper);
        assertThat(instituteTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(instituteTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(instituteTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(instituteTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
