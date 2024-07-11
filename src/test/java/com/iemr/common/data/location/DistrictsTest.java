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
class DistrictsTest {

	@InjectMocks
    private Districts districtsUnderTest;

    @BeforeEach
    void setUp() {
        districtsUnderTest = new Districts(0, "DistrictName", 0, "stateName");
    }

    @Test
    void testGetDistrictID() {
        // Setup
        // Run the test
        final int result = districtsUnderTest.getDistrictID();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testSetDistrictID() {
        // Setup
        // Run the test
        districtsUnderTest.setDistrictID(0);

        // Verify the results
    }

    @Test
    void testDistrictNameGetterAndSetter() {
        final String districtName = "DistrictName";
        districtsUnderTest.setDistrictName(districtName);
        assertThat(districtsUnderTest.getDistrictName()).isEqualTo(districtName);
    }

    @Test
    void testIsDeleted() {
        // Setup
        // Run the test
        final boolean result = districtsUnderTest.isDeleted();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        districtsUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        districtsUnderTest.setCreatedBy(createdBy);
        assertThat(districtsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        districtsUnderTest.setCreatedDate(createdDate);
        assertThat(districtsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        districtsUnderTest.setModifiedBy(modifiedBy);
        assertThat(districtsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        districtsUnderTest.setLastModDate(lastModDate);
        assertThat(districtsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testStatesGetterAndSetter() {
        final States states = new States();
        districtsUnderTest.setStates(states);
        assertThat(districtsUnderTest.getStates()).isEqualTo(states);
    }

    @Test
    void testToString() {
        assertThat(districtsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        districtsUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(districtsUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testInstitutesGetterAndSetter() {
        final Set<Institute> institutes = Set.of(new Institute(0, "institutionName", 0, 0, 0));
        districtsUnderTest.setInstitutes(institutes);
        assertThat(districtsUnderTest.getInstitutes()).isEqualTo(institutes);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        districtsUnderTest.setStateID(stateID);
        assertThat(districtsUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testGetDeleted() {
        assertThat(districtsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        districtsUnderTest.setOutputMapper(outputMapper);
        assertThat(districtsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        // Setup
        // Run the test
        final boolean result = districtsUnderTest.equals("o");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(districtsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        // Setup
        // Run the test
        final int result = districtsUnderTest.hashCode();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
