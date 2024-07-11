package com.iemr.common.data.location;

import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.institute.Institute;
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
class DistrictBlockTest {

	@InjectMocks
    private DistrictBlock districtBlockUnderTest;

    @BeforeEach
    void setUp() {
        districtBlockUnderTest = new DistrictBlock(0, "BlockName");
    }

    @Test
    void testBlockIDGetterAndSetter() {
        final Integer blockID = 0;
        districtBlockUnderTest.setBlockID(blockID);
        assertThat(districtBlockUnderTest.getBlockID()).isEqualTo(blockID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        districtBlockUnderTest.setDistrictID(districtID);
        assertThat(districtBlockUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testBlockNameGetterAndSetter() {
        final String blockName = "BlockName";
        districtBlockUnderTest.setBlockName(blockName);
        assertThat(districtBlockUnderTest.getBlockName()).isEqualTo(blockName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        districtBlockUnderTest.setStateID(stateID);
        assertThat(districtBlockUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final boolean deleted = false;
        districtBlockUnderTest.setDeleted(deleted);
        assertThat(districtBlockUnderTest.isDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        districtBlockUnderTest.setCreatedBy(createdBy);
        assertThat(districtBlockUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        districtBlockUnderTest.setCreatedDate(createdDate);
        assertThat(districtBlockUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        districtBlockUnderTest.setModifiedBy(modifiedBy);
        assertThat(districtBlockUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        districtBlockUnderTest.setLastModDate(lastModDate);
        assertThat(districtBlockUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(districtBlockUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        districtBlockUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(districtBlockUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testInstitutesGetterAndSetter() {
        final Set<Institute> institutes = Set.of(new Institute(0, "institutionName", 0, 0, 0));
        districtBlockUnderTest.setInstitutes(institutes);
        assertThat(districtBlockUnderTest.getInstitutes()).isEqualTo(institutes);
    }

    @Test
    void testDeleted1GetterAndSetter() {
        final boolean deleted = false;
        districtBlockUnderTest.setDeleted(deleted);
        assertThat(districtBlockUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        districtBlockUnderTest.setOutputMapper(outputMapper);
        assertThat(districtBlockUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(districtBlockUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(districtBlockUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(districtBlockUnderTest.hashCode()).isEqualTo(0);
    }
}
