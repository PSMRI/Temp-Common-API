package com.iemr.common.data.directory;

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
class SubDirectoryTest {

	@InjectMocks
    private SubDirectory subDirectoryUnderTest;

    @BeforeEach
    void setUp() {
        subDirectoryUnderTest = new SubDirectory(0, 0, "instituteSubDirectoryName");
    }

    @Test
    void testInstituteSubDirectoryIDGetterAndSetter() {
        final Integer instituteSubDirectoryID = 0;
        subDirectoryUnderTest.setInstituteSubDirectoryID(instituteSubDirectoryID);
        assertThat(subDirectoryUnderTest.getInstituteSubDirectoryID()).isEqualTo(instituteSubDirectoryID);
    }

    @Test
    void testInstituteDirectoryIDGetterAndSetter() {
        final Integer instituteDirectoryID = 0;
        subDirectoryUnderTest.setInstituteDirectoryID(instituteDirectoryID);
        assertThat(subDirectoryUnderTest.getInstituteDirectoryID()).isEqualTo(instituteDirectoryID);
    }

    @Test
    void testInstituteSubDirectoryNameGetterAndSetter() {
        final String instituteSubDirectoryName = "instituteSubDirectoryName";
        subDirectoryUnderTest.setInstituteSubDirectoryName(instituteSubDirectoryName);
        assertThat(subDirectoryUnderTest.getInstituteSubDirectoryName()).isEqualTo(instituteSubDirectoryName);
    }

    @Test
    void testInstituteSubDirectoryDescGetterAndSetter() {
        final String instituteSubDirectoryDesc = "instituteSubDirectoryDesc";
        subDirectoryUnderTest.setInstituteSubDirectoryDesc(instituteSubDirectoryDesc);
        assertThat(subDirectoryUnderTest.getInstituteSubDirectoryDesc()).isEqualTo(instituteSubDirectoryDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        subDirectoryUnderTest.setDeleted(deleted);
        assertThat(subDirectoryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        subDirectoryUnderTest.setCreatedBy(createdBy);
        assertThat(subDirectoryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        subDirectoryUnderTest.setCreatedDate(createdDate);
        assertThat(subDirectoryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        subDirectoryUnderTest.setModifiedBy(modifiedBy);
        assertThat(subDirectoryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        subDirectoryUnderTest.setLastModDate(lastModDate);
        assertThat(subDirectoryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(subDirectoryUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInstituteDirectoryMappingsGetterAndSetter() {
        final List<InstituteDirectoryMapping> instituteDirectoryMappings = List.of(new InstituteDirectoryMapping());
        subDirectoryUnderTest.setInstituteDirectoryMappings(instituteDirectoryMappings);
        assertThat(subDirectoryUnderTest.getInstituteDirectoryMappings()).isEqualTo(instituteDirectoryMappings);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        subDirectoryUnderTest.setOutputMapper(outputMapper);
        assertThat(subDirectoryUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(subDirectoryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(subDirectoryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(subDirectoryUnderTest.hashCode()).isEqualTo(0);
    }
}
