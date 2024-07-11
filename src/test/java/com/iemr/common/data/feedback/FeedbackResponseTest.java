package com.iemr.common.data.feedback;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class FeedbackResponseTest {

    private FeedbackResponse feedbackResponseUnderTest;

    @BeforeEach
    void setUp() {
        feedbackResponseUnderTest = new FeedbackResponse();
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        feedbackResponseUnderTest.setFeedbackID(feedbackID);
        assertThat(feedbackResponseUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testFeedbackResponseIDGetterAndSetter() {
        final Long feedbackResponseID = 0L;
        feedbackResponseUnderTest.setFeedbackResponseID(feedbackResponseID);
        assertThat(feedbackResponseUnderTest.getFeedbackResponseID()).isEqualTo(feedbackResponseID);
    }

    @Test
    void testFeedbackRequestIDGetterAndSetter() {
        final Long feedbackRequestID = 0L;
        feedbackResponseUnderTest.setFeedbackRequestID(feedbackRequestID);
        assertThat(feedbackResponseUnderTest.getFeedbackRequestID()).isEqualTo(feedbackRequestID);
    }

    @Test
    void testEmailStatusIDGetterAndSetter() {
        final Integer emailStatusID = 0;
        feedbackResponseUnderTest.setEmailStatusID(emailStatusID);
        assertThat(feedbackResponseUnderTest.getEmailStatusID()).isEqualTo(emailStatusID);
    }

    @Test
    void testFeedbackStatusIDGetterAndSetter() {
        final Integer feedbackStatusID = 0;
        feedbackResponseUnderTest.setFeedbackStatusID(feedbackStatusID);
        assertThat(feedbackResponseUnderTest.getFeedbackStatusID()).isEqualTo(feedbackStatusID);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "comments";
        feedbackResponseUnderTest.setComments(comments);
        assertThat(feedbackResponseUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testResponseSummaryGetterAndSetter() {
        final String responseSummary = "responseSummary";
        feedbackResponseUnderTest.setResponseSummary(responseSummary);
        assertThat(feedbackResponseUnderTest.getResponseSummary()).isEqualTo(responseSummary);
    }

    @Test
    void testAuthUserIDGetterAndSetter() {
        final Integer authUserID = 0;
        feedbackResponseUnderTest.setAuthUserID(authUserID);
        assertThat(feedbackResponseUnderTest.getAuthUserID()).isEqualTo(authUserID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        feedbackResponseUnderTest.setDeleted(deleted);
        assertThat(feedbackResponseUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testToString() {
        assertThat(feedbackResponseUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInitializeFeedbackResponse() {
        // Setup
        final KMFileManager kmFileManager = new KMFileManager();
        kmFileManager.setFileUID("fileUID");
        kmFileManager.setFileCheckSum("fileCheckSum");
        kmFileManager.setKmUploadStatus("kmUploadStatus");
        kmFileManager.setVersionNo("versionNo");
        kmFileManager.setKmFileManagerID(0);

        // Run the test
        final FeedbackResponse result = FeedbackResponse.initializeFeedbackResponse("responseSummary", 0L, "comments",
                "authName", "authDesignation", 0L, 0L, Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                "createdBy", 0, kmFileManager);
        assertThat(result.getFeedbackID()).isEqualTo(0L);
        assertThat(result.getFeedbackResponseID()).isEqualTo(0L);
        assertThat(result.getFeedbackRequestID()).isEqualTo(0L);
        assertThat(result.getEmailStatusID()).isEqualTo(0);
        assertThat(result.getFeedbackStatusID()).isEqualTo(0);
        assertThat(result.getComments()).isEqualTo("comments");
        assertThat(result.getResponseSummary()).isEqualTo("responseSummary");
        assertThat(result.getAuthUserID()).isEqualTo(0);
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getKmFileManager()).isEqualTo(new KMFileManager());
        assertThat(result.getKmFileManagerID()).isEqualTo(0);
        assertThat(result.getAttachmentPath()).isEqualTo("attachmentPath");
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getAuthName()).isEqualTo("authName");
        assertThat(result.getAuthDesignation()).isEqualTo("authDesignation");
        assertThat(result.getFeedbackRequest()).isEqualTo(new FeedbackRequest());
        assertThat(result.getFeedbackDetails()).isEqualTo(new FeedbackDetails());
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackResponseUnderTest.setCreatedDate(createdDate);
        assertThat(feedbackResponseUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        feedbackResponseUnderTest.setCreatedBy(createdBy);
        assertThat(feedbackResponseUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testKmFileManagerGetterAndSetter() {
        final KMFileManager kmFileManager = new KMFileManager();
        feedbackResponseUnderTest.setKmFileManager(kmFileManager);
        assertThat(feedbackResponseUnderTest.getKmFileManager()).isEqualTo(kmFileManager);
    }

    @Test
    void testKmFileManagerIDGetterAndSetter() {
        final Integer kmFileManagerID = 0;
        feedbackResponseUnderTest.setKmFileManagerID(kmFileManagerID);
        assertThat(feedbackResponseUnderTest.getKmFileManagerID()).isEqualTo(kmFileManagerID);
    }

    @Test
    void testAttachmentPathGetterAndSetter() {
        final String attachmentPath = "attachmentPath";
        feedbackResponseUnderTest.setAttachmentPath(attachmentPath);
        assertThat(feedbackResponseUnderTest.getAttachmentPath()).isEqualTo(attachmentPath);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        feedbackResponseUnderTest.setModifiedBy(modifiedBy);
        assertThat(feedbackResponseUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        feedbackResponseUnderTest.setLastModDate(lastModDate);
        assertThat(feedbackResponseUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testAuthNameGetterAndSetter() {
        final String authName = "authName";
        feedbackResponseUnderTest.setAuthName(authName);
        assertThat(feedbackResponseUnderTest.getAuthName()).isEqualTo(authName);
    }

    @Test
    void testAuthDesignationGetterAndSetter() {
        final String authDesignation = "authDesignation";
        feedbackResponseUnderTest.setAuthDesignation(authDesignation);
        assertThat(feedbackResponseUnderTest.getAuthDesignation()).isEqualTo(authDesignation);
    }

    @Test
    void testFeedbackRequestGetterAndSetter() {
        final FeedbackRequest feedbackRequest = new FeedbackRequest();
        feedbackResponseUnderTest.setFeedbackRequest(feedbackRequest);
        assertThat(feedbackResponseUnderTest.getFeedbackRequest()).isEqualTo(feedbackRequest);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final FeedbackDetails feedbackDetails = new FeedbackDetails();
        feedbackResponseUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(feedbackResponseUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        feedbackResponseUnderTest.setOutputMapper(outputMapper);
        assertThat(feedbackResponseUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(feedbackResponseUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(feedbackResponseUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(feedbackResponseUnderTest.hashCode()).isEqualTo(0);
    }
}
