package com.iemr.common.data.feedback;

import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackTypeTest {

    private FeedbackType feedbackTypeUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        feedbackTypeUnderTest = new FeedbackType(0, "feedbackTypeName");
    }

    @Test
    void testFeedbackTypeNameGetterAndSetter() {
        final String feedbackTypeName = "feedbackTypeName";
        feedbackTypeUnderTest.setFeedbackTypeName(feedbackTypeName);
        assertThat(feedbackTypeUnderTest.getFeedbackTypeName()).isEqualTo(feedbackTypeName);
    }

    @Test
    void testToString() throws Exception {
        assertThat(feedbackTypeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        feedbackTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(feedbackTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testFeedbackTypeIDGetterAndSetter() {
        final Integer feedbackTypeID = 0;
        feedbackTypeUnderTest.setFeedbackTypeID(feedbackTypeID);
        assertThat(feedbackTypeUnderTest.getFeedbackTypeID()).isEqualTo(feedbackTypeID);
    }

    @Test
    void testFeedbacksGetterAndSetter() {
        final Set<FeedbackDetails> feedbacks = Set.of(new FeedbackDetails());
        feedbackTypeUnderTest.setFeedbacks(feedbacks);
        assertThat(feedbackTypeUnderTest.getFeedbacks()).isEqualTo(feedbacks);
    }

    @Test
    void testFeedbackDescGetterAndSetter() {
        final String feedbackDesc = "feedbackDesc";
        feedbackTypeUnderTest.setFeedbackDesc(feedbackDesc);
        assertThat(feedbackTypeUnderTest.getFeedbackDesc()).isEqualTo(feedbackDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackTypeUnderTest.setDeleted(deleted);
        assertThat(feedbackTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        feedbackTypeUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackTypeUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackTypeUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        feedbackTypeUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(feedbackTypeUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackTypeUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(feedbackTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(feedbackTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(feedbackTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
