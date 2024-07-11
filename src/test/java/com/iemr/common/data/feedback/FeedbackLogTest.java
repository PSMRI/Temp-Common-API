package com.iemr.common.data.feedback;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackLogTest {

    private FeedbackLog feedbackLogUnderTest;

    @BeforeEach
    void setUp() {
        feedbackLogUnderTest = new FeedbackLog();
    }

    @Test
    void testToString() {
        assertThat(feedbackLogUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFeedbackLogIDGetterAndSetter() {
        final Long feedbackLogID = 0L;
        feedbackLogUnderTest.setFeedbackLogID(feedbackLogID);
        assertThat(feedbackLogUnderTest.getFeedbackLogID()).isEqualTo(feedbackLogID);
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        feedbackLogUnderTest.setFeedbackID(feedbackID);
        assertThat(feedbackLogUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testFeedbackLogsGetterAndSetter() {
        final String feedbackLogs = "feedbackLogs";
        feedbackLogUnderTest.setFeedbackLogs(feedbackLogs);
        assertThat(feedbackLogUnderTest.getFeedbackLogs()).isEqualTo(feedbackLogs);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackLogUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackLogUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackLogUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackLogUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackLogUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackLogUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackLogUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackLogUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackLogUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackLogUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(feedbackLogUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackLogUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackLogUnderTest.hashCode()).isEqualTo(0);
    }
}
