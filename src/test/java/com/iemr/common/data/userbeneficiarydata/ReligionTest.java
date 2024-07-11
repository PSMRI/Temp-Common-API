package com.iemr.common.data.userbeneficiarydata;

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
class ReligionTest {

	@InjectMocks
    private Religion religionUnderTest;

    @BeforeEach
    void setUp() {
        religionUnderTest = new Religion(0, "ReligionType", "ReligionDesc");
    }

    @Test
    void testToString() {
        assertThat(religionUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testReligionIDGetterAndSetter() {
        final Integer religionID = 0;
        religionUnderTest.setReligionID(religionID);
        assertThat(religionUnderTest.getReligionID()).isEqualTo(religionID);
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        religionUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(religionUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testM_userdemographicsGetterAndSetter() {
        final Set<UserDemographics> m_userdemographics = Set.of();
        religionUnderTest.setM_userdemographics(m_userdemographics);
        assertThat(religionUnderTest.getM_userdemographics()).isEqualTo(m_userdemographics);
    }

    @Test
    void testReligionTypeGetterAndSetter() {
        final String religionType = "ReligionType";
        religionUnderTest.setReligionType(religionType);
        assertThat(religionUnderTest.getReligionType()).isEqualTo(religionType);
    }

    @Test
    void testReligionDescGetterAndSetter() {
        final String religionDesc = "ReligionDesc";
        religionUnderTest.setReligionDesc(religionDesc);
        assertThat(religionUnderTest.getReligionDesc()).isEqualTo(religionDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        religionUnderTest.setDeleted(deleted);
        assertThat(religionUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        religionUnderTest.setCreatedBy(createdBy);
        assertThat(religionUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        religionUnderTest.setCreatedDate(createdDate);
        assertThat(religionUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        religionUnderTest.setModifiedBy(modifiedBy);
        assertThat(religionUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        religionUnderTest.setLastModDate(lastModDate);
        assertThat(religionUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        religionUnderTest.setOutputMapper(outputMapper);
        assertThat(religionUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(religionUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(religionUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(religionUnderTest.hashCode()).isEqualTo(0);
    }
}
