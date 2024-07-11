package com.iemr.common.data.location;

import com.iemr.common.data.beneficiary.BenDemographics;
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
class DistrictBranchMappingTest {

	@InjectMocks
    private DistrictBranchMapping districtBranchMappingUnderTest;

    @BeforeEach
    void setUp() {
        districtBranchMappingUnderTest = new DistrictBranchMapping(0, "VillageName", "PanchayatName", "Habitat",
                "PinCode");
    }

    @Test
    void testGetDistrictBranchID() {
        assertThat(districtBranchMappingUnderTest.getDistrictBranchID()).isEqualTo(0);
    }

    @Test
    void testSetDistrictBranchID() {
        // Setup
        // Run the test
        districtBranchMappingUnderTest.setDistrictBranchID(0);

        // Verify the results
    }

    @Test
    void testGetBlockID() {
        assertThat(districtBranchMappingUnderTest.getBlockID()).isEqualTo(0);
    }

    @Test
    void testSetBlockID() {
        // Setup
        // Run the test
        districtBranchMappingUnderTest.setBlockID(0);

        // Verify the results
    }

    @Test
    void testPanchayatNameGetterAndSetter() {
        final String panchayatName = "PanchayatName";
        districtBranchMappingUnderTest.setPanchayatName(panchayatName);
        assertThat(districtBranchMappingUnderTest.getPanchayatName()).isEqualTo(panchayatName);
    }

    @Test
    void testVillageNameGetterAndSetter() {
        final String villageName = "VillageName";
        districtBranchMappingUnderTest.setVillageName(villageName);
        assertThat(districtBranchMappingUnderTest.getVillageName()).isEqualTo(villageName);
    }

    @Test
    void testHabitatGetterAndSetter() {
        final String habitat = "Habitat";
        districtBranchMappingUnderTest.setHabitat(habitat);
        assertThat(districtBranchMappingUnderTest.getHabitat()).isEqualTo(habitat);
    }

    @Test
    void testPinCodeGetterAndSetter() {
        final String pinCode = "PinCode";
        districtBranchMappingUnderTest.setPinCode(pinCode);
        assertThat(districtBranchMappingUnderTest.getPinCode()).isEqualTo(pinCode);
    }

    @Test
    void testIsDeleted() {
        assertThat(districtBranchMappingUnderTest.isDeleted()).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        districtBranchMappingUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        districtBranchMappingUnderTest.setCreatedBy(createdBy);
        assertThat(districtBranchMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        districtBranchMappingUnderTest.setCreatedDate(createdDate);
        assertThat(districtBranchMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        districtBranchMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(districtBranchMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        districtBranchMappingUnderTest.setLastModDate(lastModDate);
        assertThat(districtBranchMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(districtBranchMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        districtBranchMappingUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(districtBranchMappingUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testGetDeleted() {
        assertThat(districtBranchMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        districtBranchMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(districtBranchMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(districtBranchMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(districtBranchMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(districtBranchMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
