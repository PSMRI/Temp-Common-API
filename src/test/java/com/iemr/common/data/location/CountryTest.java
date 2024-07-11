package com.iemr.common.data.location;

import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.users.UserDemographics;
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
class CountryTest {

	@InjectMocks
    private Country countryUnderTest;

    @BeforeEach
    void setUp() {
        countryUnderTest = new Country();
    }

    @Test
    void testCreateCountry1() {
        // Setup
        final Country expectedResult = new Country();
        expectedResult.setCountryID(0);
        expectedResult.setCountryName("countryName");
        expectedResult.setCountryCode("countryCode");
        expectedResult.setContinent("continent");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final Country result = countryUnderTest.createCountry(0, "countryName", "countryCode", "Continent");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testCreateCountry2() {
        // Setup
        final Country expectedResult = new Country();
        expectedResult.setCountryID(0);
        expectedResult.setCountryName("countryName");
        expectedResult.setCountryCode("countryCode");
        expectedResult.setContinent("continent");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final Country result = countryUnderTest.createCountry(0, "countryName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(countryUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCountryIDGetterAndSetter() {
        final Integer countryID = 0;
        countryUnderTest.setCountryID(countryID);
        assertThat(countryUnderTest.getCountryID()).isEqualTo(countryID);
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        countryUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(countryUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testM_userdemographicsGetterAndSetter() {
        final Set<UserDemographics> m_userdemographics = Set.of();
        countryUnderTest.setM_userdemographics(m_userdemographics);
        assertThat(countryUnderTest.getM_userdemographics()).isEqualTo(m_userdemographics);
    }

    @Test
    void testCountryNameGetterAndSetter() {
        final String countryName = "countryName";
        countryUnderTest.setCountryName(countryName);
        assertThat(countryUnderTest.getCountryName()).isEqualTo(countryName);
    }

    @Test
    void testCountryCodeGetterAndSetter() {
        final String countryCode = "countryCode";
        countryUnderTest.setCountryCode(countryCode);
        assertThat(countryUnderTest.getCountryCode()).isEqualTo(countryCode);
    }

    @Test
    void testContinentGetterAndSetter() {
        final String continent = "continent";
        countryUnderTest.setContinent(continent);
        assertThat(countryUnderTest.getContinent()).isEqualTo(continent);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        countryUnderTest.setDeleted(deleted);
        assertThat(countryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        countryUnderTest.setCreatedBy(createdBy);
        assertThat(countryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        countryUnderTest.setCreatedDate(createdDate);
        assertThat(countryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        countryUnderTest.setModifiedBy(modifiedBy);
        assertThat(countryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        countryUnderTest.setLastModDate(lastModDate);
        assertThat(countryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        countryUnderTest.setOutputMapper(outputMapper);
        assertThat(countryUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(countryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(countryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(countryUnderTest.hashCode()).isEqualTo(0);
    }
}
