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
class CityDetailsTest {

	@InjectMocks
    private CityDetails cityDetailsUnderTest;

    @BeforeEach
    void setUp() {
        cityDetailsUnderTest = new CityDetails(0, "CityName");
    }

    @Test
    void testCityIDGetterAndSetter() {
        final Integer cityID = 0;
        cityDetailsUnderTest.setCityID(cityID);
        assertThat(cityDetailsUnderTest.getCityID()).isEqualTo(cityID);
    }

    @Test
    void testCityNameGetterAndSetter() {
        final String cityName = "CityName";
        cityDetailsUnderTest.setCityName(cityName);
        assertThat(cityDetailsUnderTest.getCityName()).isEqualTo(cityName);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        cityDetailsUnderTest.setDistrictID(districtID);
        assertThat(cityDetailsUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        cityDetailsUnderTest.setStateID(stateID);
        assertThat(cityDetailsUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final boolean deleted = false;
        cityDetailsUnderTest.setDeleted(deleted);
        assertThat(cityDetailsUnderTest.isDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        cityDetailsUnderTest.setCreatedBy(createdBy);
        assertThat(cityDetailsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        cityDetailsUnderTest.setCreatedDate(createdDate);
        assertThat(cityDetailsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        cityDetailsUnderTest.setModifiedBy(modifiedBy);
        assertThat(cityDetailsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        cityDetailsUnderTest.setLastModDate(lastModDate);
        assertThat(cityDetailsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(cityDetailsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        cityDetailsUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(cityDetailsUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testDeleted1GetterAndSetter() {
        final boolean deleted = false;
        cityDetailsUnderTest.setDeleted(deleted);
        assertThat(cityDetailsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        cityDetailsUnderTest.setOutputMapper(outputMapper);
        assertThat(cityDetailsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(cityDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(cityDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(cityDetailsUnderTest.hashCode()).isEqualTo(0);
    }
}
