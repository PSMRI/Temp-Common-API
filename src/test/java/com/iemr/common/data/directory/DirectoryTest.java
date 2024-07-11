package com.iemr.common.data.directory;

import com.iemr.common.data.users.ProviderServiceMapping;
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
class DirectoryTest {

	@InjectMocks
    private Directory directoryUnderTest;

    @BeforeEach
    void setUp() {
        directoryUnderTest = new Directory(0, "directoryName");
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        directoryUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(directoryUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testToString() {
        assertThat(directoryUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInstituteDirectoryIDGetterAndSetter() {
        final Integer instituteDirectoryID = 0;
        directoryUnderTest.setInstituteDirectoryID(instituteDirectoryID);
        assertThat(directoryUnderTest.getInstituteDirectoryID()).isEqualTo(instituteDirectoryID);
    }

    @Test
    void testInstituteDirectoryMappingsGetterAndSetter() {
        final List<InstituteDirectoryMapping> instituteDirectoryMappings = List.of(new InstituteDirectoryMapping());
        directoryUnderTest.setInstituteDirectoryMappings(instituteDirectoryMappings);
        assertThat(directoryUnderTest.getInstituteDirectoryMappings()).isEqualTo(instituteDirectoryMappings);
    }

    @Test
    void testInstituteDirectoryNameGetterAndSetter() {
        final String instituteDirectoryName = "directoryName";
        directoryUnderTest.setInstituteDirectoryName(instituteDirectoryName);
        assertThat(directoryUnderTest.getInstituteDirectoryName()).isEqualTo(instituteDirectoryName);
    }

    @Test
    void testInstituteDirectoryDescGetterAndSetter() {
        final String instituteDirectoryDesc = "instituteDirectoryDesc";
        directoryUnderTest.setInstituteDirectoryDesc(instituteDirectoryDesc);
        assertThat(directoryUnderTest.getInstituteDirectoryDesc()).isEqualTo(instituteDirectoryDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        directoryUnderTest.setDeleted(deleted);
        assertThat(directoryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        directoryUnderTest.setCreatedBy(createdBy);
        assertThat(directoryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        directoryUnderTest.setCreatedDate(createdDate);
        assertThat(directoryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        directoryUnderTest.setModifiedBy(modifiedBy);
        assertThat(directoryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        directoryUnderTest.setLastModDate(lastModDate);
        assertThat(directoryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        directoryUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(directoryUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        directoryUnderTest.setOutputMapper(outputMapper);
        assertThat(directoryUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(directoryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(directoryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(directoryUnderTest.hashCode()).isEqualTo(0);
    }
}
