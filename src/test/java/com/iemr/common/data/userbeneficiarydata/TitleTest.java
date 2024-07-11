package com.iemr.common.data.userbeneficiarydata;

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
class TitleTest {

	@InjectMocks
    private Title titleUnderTest;

    @BeforeEach
    void setUp() {
        titleUnderTest = new Title();
    }

    @Test
    void testGetDefaultConstructor() {
        // Setup
        final Title expectedResult = new Title();
        expectedResult.setTitleID(0);
        final User user = new User();
        user.setUserID(0L);
        expectedResult.setM_user(Set.of(user));
        expectedResult.setTitleName("titleName");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final Title result = titleUnderTest.getDefaultConstructor();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetTitle() {
        // Setup
        final Title expectedResult = new Title();
        expectedResult.setTitleID(0);
        final User user = new User();
        user.setUserID(0L);
        expectedResult.setM_user(Set.of(user));
        expectedResult.setTitleName("titleName");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final Title result = titleUnderTest.getTitle(0, "titleName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(titleUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testTitleIDGetterAndSetter() {
        final Integer titleID = 0;
        titleUnderTest.setTitleID(titleID);
        assertThat(titleUnderTest.getTitleID()).isEqualTo(titleID);
    }

    @Test
    void testM_userGetterAndSetter() {
        final Set<User> m_user = Set.of(new User());
        titleUnderTest.setM_user(m_user);
        assertThat(titleUnderTest.getM_user()).isEqualTo(m_user);
    }

    @Test
    void testI_beneficiaryGetterAndSetter() {
        final Set<Beneficiary> i_beneficiary = Set.of(new Beneficiary());
        titleUnderTest.setI_beneficiary(i_beneficiary);
        assertThat(titleUnderTest.getI_beneficiary()).isEqualTo(i_beneficiary);
    }

    @Test
    void testTitleNameGetterAndSetter() {
        final String titleName = "titleName";
        titleUnderTest.setTitleName(titleName);
        assertThat(titleUnderTest.getTitleName()).isEqualTo(titleName);
    }

    @Test
    void testTitleDescGetterAndSetter() {
        final String titleDesc = "titleDesc";
        titleUnderTest.setTitleDesc(titleDesc);
        assertThat(titleUnderTest.getTitleDesc()).isEqualTo(titleDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        titleUnderTest.setDeleted(deleted);
        assertThat(titleUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        titleUnderTest.setCreatedBy(createdBy);
        assertThat(titleUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        titleUnderTest.setCreatedDate(createdDate);
        assertThat(titleUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        titleUnderTest.setModifiedBy(modifiedBy);
        assertThat(titleUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        titleUnderTest.setLastModDate(lastModDate);
        assertThat(titleUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        titleUnderTest.setOutputMapper(outputMapper);
        assertThat(titleUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(titleUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(titleUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(titleUnderTest.hashCode()).isEqualTo(0);
    }
}
