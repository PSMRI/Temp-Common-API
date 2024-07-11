package com.iemr.common.data.users;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserQualificationTest {

	@InjectMocks
    private UserQualification userQualificationUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userQualificationUnderTest = new UserQualification(0, "Name");
    }

    @Test
    void testToString() throws Exception {
        assertThat(userQualificationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testQualificationIDGetterAndSetter() {
        final Integer qualificationID = 0;
        userQualificationUnderTest.setQualificationID(qualificationID);
        assertThat(userQualificationUnderTest.getQualificationID()).isEqualTo(qualificationID);
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "Name";
        userQualificationUnderTest.setName(name);
        assertThat(userQualificationUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testUserQualificationDescGetterAndSetter() {
        final String userQualificationDesc = "UserQualificationDesc";
        userQualificationUnderTest.setUserQualificationDesc(userQualificationDesc);
        assertThat(userQualificationUnderTest.getUserQualificationDesc()).isEqualTo(userQualificationDesc);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        userQualificationUnderTest.setDeleted(deleted);
        assertThat(userQualificationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "CreatedBy";
        userQualificationUnderTest.setCreatedBy(createdBy);
        assertThat(userQualificationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userQualificationUnderTest.setCreatedDate(createdDate);
        assertThat(userQualificationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "ModifiedBy";
        userQualificationUnderTest.setModifiedBy(modifiedBy);
        assertThat(userQualificationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userQualificationUnderTest.setLastModDate(lastModDate);
        assertThat(userQualificationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        userQualificationUnderTest.setOutputMapper(outputMapper);
        assertThat(userQualificationUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userQualificationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userQualificationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userQualificationUnderTest.hashCode()).isEqualTo(0);
    }
}
