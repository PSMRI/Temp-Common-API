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
class StatesTest {

	@InjectMocks
    private States statesUnderTest;

    @BeforeEach
    void setUp() {
        statesUnderTest = new States();
    }

    @Test
    void testGetDefaultContructor() {
        // Setup
        final States expectedResult = new States();
        expectedResult.setStateCode("stateCode");
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setStateName("stateName");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final States result = statesUnderTest.getDefaultContructor();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetStates() {
        // Setup
        final States expectedResult = new States();
        expectedResult.setStateCode("stateCode");
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setStateName("stateName");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final States result = statesUnderTest.getStates(0, "StateName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetStateID() {
        // Setup
        // Run the test
        final int result = statesUnderTest.getStateID();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testSetStateID() {
        // Setup
        // Run the test
        statesUnderTest.setStateID(0);

        // Verify the results
    }

    @Test
    void testStateNameGetterAndSetter() {
        final String stateName = "stateName";
        statesUnderTest.setStateIName(stateName);
        assertThat(statesUnderTest.getStateIName()).isEqualTo(stateName);
    }

    @Test
    void testStateCodeGetterAndSetter() {
        final String stateCode = "stateCode";
        statesUnderTest.setStateCode(stateCode);
        assertThat(statesUnderTest.getStateCode()).isEqualTo(stateCode);
    }

    @Test
    void testGetCountryID() {
        // Setup
        // Run the test
        final int result = statesUnderTest.getCountryID();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testSetCountryID() {
        // Setup
        // Run the test
        statesUnderTest.setCountryID(0);

        // Verify the results
    }

    @Test
    void testIsDeleted() {
        // Setup
        // Run the test
        final boolean result = statesUnderTest.isDeleted();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        statesUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        statesUnderTest.setCreatedBy(createdBy);
        assertThat(statesUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        statesUnderTest.setModifiedBy(modifiedBy);
        assertThat(statesUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        statesUnderTest.setCreatedDate(createdDate);
        assertThat(statesUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        statesUnderTest.setLastModDate(lastModDate);
        assertThat(statesUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testStateName1GetterAndSetter() {
        final String stateName = "stateName";
        statesUnderTest.setStateIName(stateName);
        assertThat(statesUnderTest.getStateName()).isEqualTo(stateName);
    }

    @Test
    void testStateName2GetterAndSetter() {
        final String stateName = "stateName";
        statesUnderTest.setStateName(stateName);
        assertThat(statesUnderTest.getStateIName()).isEqualTo(stateName);
    }

    @Test
    void testToString() {
        assertThat(statesUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        statesUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(statesUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testLanguageGetterAndSetter() {
        final String language = "language";
        statesUnderTest.setLanguage(language);
        assertThat(statesUnderTest.getLanguage()).isEqualTo(language);
    }

    @Test
    void testGetDeleted() {
        assertThat(statesUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testDistrictsGetterAndSetter() {
        final Set<Districts> districts = Set.of(new Districts(0, "DistrictName", 0, "stateName"));
        statesUnderTest.setDistricts(districts);
        assertThat(statesUnderTest.getDistricts()).isEqualTo(districts);
    }

    @Test
    void testInstitutesGetterAndSetter() {
        final Set<Institute> institutes = Set.of(new Institute(0, "institutionName", 0, 0, 0));
        statesUnderTest.setInstitutes(institutes);
        assertThat(statesUnderTest.getInstitutes()).isEqualTo(institutes);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        statesUnderTest.setOutputMapper(outputMapper);
        assertThat(statesUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        // Setup
        // Run the test
        final boolean result = statesUnderTest.equals("o");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(statesUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        // Setup
        // Run the test
        final int result = statesUnderTest.hashCode();

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
