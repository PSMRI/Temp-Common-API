package com.iemr.common.data.feedback;

import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackSeverityTest {

    private FeedbackSeverity feedbackSeverityUnderTest;

    @BeforeEach
    void setUp() {
        feedbackSeverityUnderTest = new FeedbackSeverity(0, "severityTypeName");
    }

    @Test
    void testSeverityTypeNameGetterAndSetter() {
        final String severityTypeName = "severityTypeName";
        feedbackSeverityUnderTest.setSeverityTypeName(severityTypeName);
        assertThat(feedbackSeverityUnderTest.getSeverityTypeName()).isEqualTo(severityTypeName);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        feedbackSeverityUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(feedbackSeverityUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testToString() {
        assertThat(feedbackSeverityUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSeverityIDGetterAndSetter() {
        final Integer severityID = 0;
        feedbackSeverityUnderTest.setSeverityID(severityID);
        assertThat(feedbackSeverityUnderTest.getSeverityID()).isEqualTo(severityID);
    }

    @Test
    void testFeedbacksGetterAndSetter() {
        final Set<FeedbackDetails> feedbacks = Set.of(new FeedbackDetails());
        feedbackSeverityUnderTest.setFeedbacks(feedbacks);
        assertThat(feedbackSeverityUnderTest.getFeedbacks()).isEqualTo(feedbacks);
    }

    @Test
    void testSeverityDescGetterAndSetter() {
        final String severityDesc = "severityDesc";
        feedbackSeverityUnderTest.setSeverityDesc(severityDesc);
        assertThat(feedbackSeverityUnderTest.getSeverityDesc()).isEqualTo(severityDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackSeverityUnderTest.setDeleted(deleted);
        assertThat(feedbackSeverityUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackSeverityUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackSeverityUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackSeverityUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackSeverityUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackSeverityUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackSeverityUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackSeverityUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackSeverityUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        feedbackSeverityUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(feedbackSeverityUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackSeverityUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackSeverityUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(feedbackSeverityUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackSeverityUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackSeverityUnderTest.hashCode()).isEqualTo(0);
    }
}
