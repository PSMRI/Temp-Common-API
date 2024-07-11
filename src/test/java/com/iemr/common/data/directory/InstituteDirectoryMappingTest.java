package com.iemr.common.data.directory;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class InstituteDirectoryMappingTest {

    @Mock
    private Institute mockInstitute;
    @Mock
    private Directory mockDirectory;
    @Mock
    private SubDirectory mockSubDirectory;

    @InjectMocks
    private InstituteDirectoryMapping instituteDirectoryMappingUnderTest;

    @BeforeEach
    void setUp() {
        instituteDirectoryMappingUnderTest = new InstituteDirectoryMapping(0L, 0, mockInstitute, false, 0,
                mockDirectory, 0, mockSubDirectory);
    }

    @Test
    void testBlockIDGetterAndSetter() {
        final Integer blockID = 0;
        instituteDirectoryMappingUnderTest.setBlockID(blockID);
        assertThat(instituteDirectoryMappingUnderTest.getBlockID()).isEqualTo(blockID);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        instituteDirectoryMappingUnderTest.setStateID(stateID);
        assertThat(instituteDirectoryMappingUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        instituteDirectoryMappingUnderTest.setDistrictID(districtID);
        assertThat(instituteDirectoryMappingUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testInstituteDirectoryIDGetterAndSetter() {
        final Integer instituteDirectoryID = 0;
        instituteDirectoryMappingUnderTest.setInstituteDirectoryID(instituteDirectoryID);
        assertThat(instituteDirectoryMappingUnderTest.getInstituteDirectoryID()).isEqualTo(instituteDirectoryID);
    }

    @Test
    void testInstituteSubDirectoryIDGetterAndSetter() {
        final Integer instituteSubDirectoryID = 0;
        instituteDirectoryMappingUnderTest.setInstituteSubDirectoryID(instituteSubDirectoryID);
        assertThat(instituteDirectoryMappingUnderTest.getInstituteSubDirectoryID()).isEqualTo(instituteSubDirectoryID);
    }

    @Test
    void testToString() {
        assertThat(instituteDirectoryMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInstituteDirMapIDGetterAndSetter() {
        final Long instituteDirMapID = 0L;
        instituteDirectoryMappingUnderTest.setInstituteDirMapID(instituteDirMapID);
        assertThat(instituteDirectoryMappingUnderTest.getInstituteDirMapID()).isEqualTo(instituteDirMapID);
    }

    @Test
    void testInstitutionIDGetterAndSetter() {
        final Integer institutionID = 0;
        instituteDirectoryMappingUnderTest.setInstitutionID(institutionID);
        assertThat(instituteDirectoryMappingUnderTest.getInstitutionID()).isEqualTo(institutionID);
    }

    @Test
    void testInstituteGetterAndSetter() {
        final Institute institute = new Institute(0, "institutionName", 0, 0, 0);
        instituteDirectoryMappingUnderTest.setInstitute(institute);
        assertThat(instituteDirectoryMappingUnderTest.getInstitute()).isEqualTo(institute);
    }

    @Test
    void testDirectoryGetterAndSetter() {
        final Directory directory = new Directory(0, "directoryName");
        instituteDirectoryMappingUnderTest.setDirectory(directory);
        assertThat(instituteDirectoryMappingUnderTest.getDirectory()).isEqualTo(directory);
    }

    @Test
    void testSubDirectoryGetterAndSetter() {
        final SubDirectory subDirectory = new SubDirectory(0, 0, "instituteSubDirectoryName");
        instituteDirectoryMappingUnderTest.setSubDirectory(subDirectory);
        assertThat(instituteDirectoryMappingUnderTest.getSubDirectory()).isEqualTo(subDirectory);
    }

    @Test
    void testInstituteRouteDirectoryIDGetterAndSetter() {
        final Integer instituteRouteDirectoryID = 0;
        instituteDirectoryMappingUnderTest.setInstituteRouteDirectoryID(instituteRouteDirectoryID);
        assertThat(instituteDirectoryMappingUnderTest.getInstituteRouteDirectoryID())
                .isEqualTo(instituteRouteDirectoryID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        instituteDirectoryMappingUnderTest.setDeleted(deleted);
        assertThat(instituteDirectoryMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        instituteDirectoryMappingUnderTest.setCreatedBy(createdBy);
        assertThat(instituteDirectoryMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        instituteDirectoryMappingUnderTest.setCreatedDate(createdDate);
        assertThat(instituteDirectoryMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        instituteDirectoryMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(instituteDirectoryMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        instituteDirectoryMappingUnderTest.setLastModDate(lastModDate);
        assertThat(instituteDirectoryMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        instituteDirectoryMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(instituteDirectoryMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(instituteDirectoryMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(instituteDirectoryMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(instituteDirectoryMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
