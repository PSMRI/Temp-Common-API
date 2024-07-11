package com.iemr.common.data.institute;

import com.iemr.common.data.feedback.FeedbackDetails;
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
class DesignationTest {

	@InjectMocks
    private Designation designationUnderTest;

    @BeforeEach
    void setUp() {
        designationUnderTest = new Designation(0, "designationName");
    }

    @Test
    void testDesignationIDGetterAndSetter() {
        final int designationID = 0;
        designationUnderTest.setDesignationID(designationID);
        assertThat(designationUnderTest.getDesignationID()).isEqualTo(designationID);
    }

    @Test
    void testDesignationNameGetterAndSetter() {
        final String designationName = "designationName";
        designationUnderTest.setDesignationName(designationName);
        assertThat(designationUnderTest.getDesignationName()).isEqualTo(designationName);
    }

    @Test
    void testDesignationDescGetterAndSetter() {
        final String designationDesc = "designationDesc";
        designationUnderTest.setDesignationDesc(designationDesc);
        assertThat(designationUnderTest.getDesignationDesc()).isEqualTo(designationDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        designationUnderTest.setDeleted(deleted);
        assertThat(designationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        designationUnderTest.setCreatedBy(createdBy);
        assertThat(designationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        designationUnderTest.setCreatedDate(createdDate);
        assertThat(designationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        designationUnderTest.setModifiedBy(modifiedBy);
        assertThat(designationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        designationUnderTest.setLastModDate(lastModDate);
        assertThat(designationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(designationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        designationUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(designationUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testUsersGetterAndSetter() {
        final Set<User> users = Set.of(new User());
        designationUnderTest.setUsers(users);
        assertThat(designationUnderTest.getUsers()).isEqualTo(users);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        designationUnderTest.setOutputMapper(outputMapper);
        assertThat(designationUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(designationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(designationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(designationUnderTest.hashCode()).isEqualTo(0);
    }
}
