package com.iemr.common.data.feedback;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.users.EmailStatus;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FeedbackRequestTest {

    @Mock
    private EmailStatus mockEmailStatus;

    private FeedbackRequest feedbackRequestUnderTest;

    @BeforeEach
    void setUp() {
        feedbackRequestUnderTest = new FeedbackRequest(0L, 0L, "feedbackSupSummary", 0, "comments", 0, mockEmailStatus,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "createdBy");
    }

    @Test
    void testFeedbackRequestIDGetterAndSetter() {
        final Long feedbackRequestID = 0L;
        feedbackRequestUnderTest.setFeedbackRequestID(feedbackRequestID);
        assertThat(feedbackRequestUnderTest.getFeedbackRequestID()).isEqualTo(feedbackRequestID);
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        feedbackRequestUnderTest.setFeedbackID(feedbackID);
        assertThat(feedbackRequestUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testFeedbackSupSummaryGetterAndSetter() {
        final String feedbackSupSummary = "feedbackSupSummary";
        feedbackRequestUnderTest.setFeedbackSupSummary(feedbackSupSummary);
        assertThat(feedbackRequestUnderTest.getFeedbackSupSummary()).isEqualTo(feedbackSupSummary);
    }

    @Test
    void testSupUserIDGetterAndSetter() {
        final Integer supUserID = 0;
        feedbackRequestUnderTest.setSupUserID(supUserID);
        assertThat(feedbackRequestUnderTest.getSupUserID()).isEqualTo(supUserID);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "comments";
        feedbackRequestUnderTest.setComments(comments);
        assertThat(feedbackRequestUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackRequestUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackRequestUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackRequestUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackRequestUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackRequestUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackRequestUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEmailStatusIDGetterAndSetter() {
        final Integer emailStatusID = 0;
        feedbackRequestUnderTest.setEmailStatusID(emailStatusID);
        assertThat(feedbackRequestUnderTest.getEmailStatusID()).isEqualTo(emailStatusID);
    }

    @Test
    void testFeedbackStatusIDGetterAndSetter() {
        final Integer feedbackStatusID = 0;
        feedbackRequestUnderTest.setFeedbackStatusID(feedbackStatusID);
        assertThat(feedbackRequestUnderTest.getFeedbackStatusID()).isEqualTo(feedbackStatusID);
    }

    @Test
    void testToString() {
        assertThat(feedbackRequestUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackRequestUnderTest.setDeleted(deleted);
        assertThat(feedbackRequestUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testUpdateResponses() {
        // Setup
        final KMFileManager kmFileManager = new KMFileManager();
        kmFileManager.setFileUID("fileUID");
        kmFileManager.setFileCheckSum("fileCheckSum");
        kmFileManager.setKmUploadStatus("kmUploadStatus");
        kmFileManager.setVersionNo("versionNo");
        kmFileManager.setKmFileManagerID(0);

        // Run the test
        feedbackRequestUnderTest.updateResponses("response", "respnseComments",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "responseUpdatedBy", kmFileManager,
                "attachmentPath");

        // Verify the results
    }

    @Test
    void testResponseUpdatedByGetterAndSetter() {
        final String responseUpdatedBy = "responseUpdatedBy";
        feedbackRequestUnderTest.setResponseUpdatedBy(responseUpdatedBy);
        assertThat(feedbackRequestUnderTest.getResponseUpdatedBy()).isEqualTo(responseUpdatedBy);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final FeedbackDetails feedbackDetails = new FeedbackDetails();
        feedbackRequestUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(feedbackRequestUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testEmailStatusGetterAndSetter() {
        final EmailStatus emailStatus = new EmailStatus();
        feedbackRequestUnderTest.setEmailStatus(emailStatus);
        assertThat(feedbackRequestUnderTest.getEmailStatus()).isEqualTo(emailStatus);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackRequestUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackRequestUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testResponseSummaryGetterAndSetter() {
        final String responseSummary = "responseSummary";
        feedbackRequestUnderTest.setResponseSummary(responseSummary);
        assertThat(feedbackRequestUnderTest.getResponseSummary()).isEqualTo(responseSummary);
    }

    @Test
    void testResponseCommentsGetterAndSetter() {
        final String responseComments = "responseComments";
        feedbackRequestUnderTest.setResponseComments(responseComments);
        assertThat(feedbackRequestUnderTest.getResponseComments()).isEqualTo(responseComments);
    }

    @Test
    void testResponseDateGetterAndSetter() {
        final Timestamp responseDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackRequestUnderTest.setResponseDate(responseDate);
        assertThat(feedbackRequestUnderTest.getResponseDate()).isEqualTo(responseDate);
    }

    @Test
    void testKmFileManagerGetterAndSetter() {
        final KMFileManager kmFileManager = new KMFileManager();
        feedbackRequestUnderTest.setKmFileManager(kmFileManager);
        assertThat(feedbackRequestUnderTest.getKmFileManager()).isEqualTo(kmFileManager);
    }

    @Test
    void testAttachmentPathGetterAndSetter() {
        final String attachmentPath = "attachmentPath";
        feedbackRequestUnderTest.setAttachmentPath(attachmentPath);
        assertThat(feedbackRequestUnderTest.getAttachmentPath()).isEqualTo(attachmentPath);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackRequestUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackRequestUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(feedbackRequestUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackRequestUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackRequestUnderTest.hashCode()).isEqualTo(0);
    }
}
