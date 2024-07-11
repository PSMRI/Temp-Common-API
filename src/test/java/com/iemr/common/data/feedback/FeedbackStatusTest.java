package com.iemr.common.data.feedback;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackStatusTest {

    private FeedbackStatus feedbackStatusUnderTest;

    @BeforeEach
    void setUp() {
        feedbackStatusUnderTest = new FeedbackStatus(0, "feedbackStatus", "feedbackStatusDesc");
    }

    @Test
    void testFeedbackStatusIDGetterAndSetter() {
        final Integer feedbackStatusID = 0;
        feedbackStatusUnderTest.setFeedbackStatusID(feedbackStatusID);
        assertThat(feedbackStatusUnderTest.getFeedbackStatusID()).isEqualTo(feedbackStatusID);
    }

    @Test
    void testFeedbackStatusGetterAndSetter() {
        final String feedbackStatus = "feedbackStatus";
        feedbackStatusUnderTest.setFeedbackStatus(feedbackStatus);
        assertThat(feedbackStatusUnderTest.getFeedbackStatus()).isEqualTo(feedbackStatus);
    }

    @Test
    void testFeedbackStatusDescGetterAndSetter() {
        final String feedbackStatusDesc = "feedbackStatusDesc";
        feedbackStatusUnderTest.setFeedbackStatusDesc(feedbackStatusDesc);
        assertThat(feedbackStatusUnderTest.getFeedbackStatusDesc()).isEqualTo(feedbackStatusDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackStatusUnderTest.setDeleted(deleted);
        assertThat(feedbackStatusUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackStatusUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackStatusUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackStatusUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackStatusUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackStatusUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackStatusUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackStatusUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackStatusUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        feedbackStatusUnderTest.setFeedback(feedbackDetails);
        assertThat(feedbackStatusUnderTest.getFeedback()).isEqualTo(feedbackDetails);
    }

    @Test
    void testToString() {
        assertThat(feedbackStatusUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        feedbackStatusUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(feedbackStatusUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testFeedbackDetails1GetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        feedbackStatusUnderTest.setFeedback(feedbackDetails);
        assertThat(feedbackStatusUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackStatusUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackStatusUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testFeedbackDetails2GetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        feedbackStatusUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(feedbackStatusUnderTest.getFeedback()).isEqualTo(feedbackDetails);
    }

    @Test
    void testEquals() {
        assertThat(feedbackStatusUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackStatusUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackStatusUnderTest.hashCode()).isEqualTo(0);
    }
}
