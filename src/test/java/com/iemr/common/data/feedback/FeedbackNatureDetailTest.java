package com.iemr.common.data.feedback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackNatureDetailTest {

    private FeedbackNatureDetail feedbackNatureDetailUnderTest;

    @BeforeEach
    void setUp() {
        feedbackNatureDetailUnderTest = new FeedbackNatureDetail();
    }

    @Test
    void testFeedbackNatureIDGetterAndSetter() {
        final Integer feedbackNatureID = 0;
        feedbackNatureDetailUnderTest.setFeedbackNatureID(feedbackNatureID);
        assertThat(feedbackNatureDetailUnderTest.getFeedbackNatureID()).isEqualTo(feedbackNatureID);
    }

    @Test
    void testFeedbackNatureGetterAndSetter() {
        final String feedbackNature = "feedbackNature";
        feedbackNatureDetailUnderTest.setFeedbackNature(feedbackNature);
        assertThat(feedbackNatureDetailUnderTest.getFeedbackNature()).isEqualTo(feedbackNature);
    }

    @Test
    void testFeedbackNatureDescGetterAndSetter() {
        final String feedbackNatureDesc = "feedbackNatureDesc";
        feedbackNatureDetailUnderTest.setFeedbackNatureDesc(feedbackNatureDesc);
        assertThat(feedbackNatureDetailUnderTest.getFeedbackNatureDesc()).isEqualTo(feedbackNatureDesc);
    }

    @Test
    void testFeedbackTypeIDGetterAndSetter() {
        final Integer feedbackTypeID = 0;
        feedbackNatureDetailUnderTest.setFeedbackTypeID(feedbackTypeID);
        assertThat(feedbackNatureDetailUnderTest.getFeedbackTypeID()).isEqualTo(feedbackTypeID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackNatureDetailUnderTest.setDeleted(deleted);
        assertThat(feedbackNatureDetailUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackNatureDetailUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackNatureDetailUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        feedbackNatureDetailUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackNatureDetailUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackNatureDetailUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackNatureDetailUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        feedbackNatureDetailUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackNatureDetailUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testFeedbackTypeNameGetterAndSetter() {
        final String feedbackTypeName = "feedbackTypeName";
        feedbackNatureDetailUnderTest.setFeedbackTypeName(feedbackTypeName);
        assertThat(feedbackNatureDetailUnderTest.getFeedbackTypeName()).isEqualTo(feedbackTypeName);
    }

    @Test
    void testToString() {
        assertThat(feedbackNatureDetailUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        feedbackNatureDetailUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(feedbackNatureDetailUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testEquals() {
        assertThat(feedbackNatureDetailUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackNatureDetailUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackNatureDetailUnderTest.hashCode()).isEqualTo(0);
    }
}
