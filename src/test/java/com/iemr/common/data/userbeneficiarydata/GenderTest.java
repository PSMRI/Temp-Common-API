package com.iemr.common.data.userbeneficiarydata;

import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.User;
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
class GenderTest {

	@InjectMocks
    private Gender genderUnderTest;

    @BeforeEach
    void setUp() {
        genderUnderTest = new Gender();
    }

    @Test
    void testGetDefaultConstructor() {
        // Setup
        final Gender expectedResult = new Gender();
        expectedResult.setGenderID(0);
        final Beneficiary beneficiary = new Beneficiary();
        beneficiary.setBeneficiaryRegID(0L);
        final BenDemographics i_bendemographics = new BenDemographics();
        beneficiary.setI_bendemographics(i_bendemographics);
        expectedResult.setI_beneficiary(Set.of(beneficiary));
        expectedResult.setGenderName("genderName");

        // Run the test
        final Gender result = genderUnderTest.getDefaultConstructor();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetGender() {
        // Setup
        final Gender expectedResult = new Gender();
        expectedResult.setGenderID(0);
        final Beneficiary beneficiary = new Beneficiary();
        beneficiary.setBeneficiaryRegID(0L);
        final BenDemographics i_bendemographics = new BenDemographics();
        beneficiary.setI_bendemographics(i_bendemographics);
        expectedResult.setI_beneficiary(Set.of(beneficiary));
        expectedResult.setGenderName("genderName");

        // Run the test
        final Gender result = genderUnderTest.getGender(0, "GenderName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(genderUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGenderIDGetterAndSetter() {
        final Integer genderID = 0;
        genderUnderTest.setGenderID(genderID);
        assertThat(genderUnderTest.getGenderID()).isEqualTo(genderID);
    }

    @Test
    void testI_beneficiaryGetterAndSetter() {
        final Set<Beneficiary> i_beneficiary = Set.of(new Beneficiary());
        genderUnderTest.setI_beneficiary(i_beneficiary);
        assertThat(genderUnderTest.getI_beneficiary()).isEqualTo(i_beneficiary);
    }

    @Test
    void testM_userGetterAndSetter() {
        final Set<User> m_user = Set.of(new User());
        genderUnderTest.setM_user(m_user);
        assertThat(genderUnderTest.getM_user()).isEqualTo(m_user);
    }

    @Test
    void testGenderNameGetterAndSetter() {
        final String genderName = "genderName";
        genderUnderTest.setGenderName(genderName);
        assertThat(genderUnderTest.getGenderName()).isEqualTo(genderName);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        genderUnderTest.setDeleted(deleted);
        assertThat(genderUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        genderUnderTest.setCreatedBy(createdBy);
        assertThat(genderUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        genderUnderTest.setCreatedDate(createdDate);
        assertThat(genderUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        genderUnderTest.setModifiedBy(modifiedBy);
        assertThat(genderUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        genderUnderTest.setLastModDate(lastModDate);
        assertThat(genderUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        genderUnderTest.setOutputMapper(outputMapper);
        assertThat(genderUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(genderUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(genderUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(genderUnderTest.hashCode()).isEqualTo(0);
    }
}
