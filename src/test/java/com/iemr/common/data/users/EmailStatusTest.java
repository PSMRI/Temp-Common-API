package com.iemr.common.data.users;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmailStatusTest {

	@InjectMocks
    private EmailStatus emailStatusUnderTest;

    @BeforeEach
    void setUp() {
        emailStatusUnderTest = new EmailStatus();
    }

    @Test
    void testEmailStatusIDGetterAndSetter() {
        final int emailStatusID = 0;
        emailStatusUnderTest.setEmailStatusID(emailStatusID);
        assertThat(emailStatusUnderTest.getEmailStatusID()).isEqualTo(emailStatusID);
    }

    @Test
    void testEmailStatusGetterAndSetter() {
        final String emailStatus = "emailStatus";
        emailStatusUnderTest.setEmailStatus(emailStatus);
        assertThat(emailStatusUnderTest.getEmailStatus()).isEqualTo(emailStatus);
    }

    @Test
    void testEmailStatusDescGetterAndSetter() {
        final String emailStatusDesc = "emailStatusDesc";
        emailStatusUnderTest.setEmailStatusDesc(emailStatusDesc);
        assertThat(emailStatusUnderTest.getEmailStatusDesc()).isEqualTo(emailStatusDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        emailStatusUnderTest.setDeleted(deleted);
        assertThat(emailStatusUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        emailStatusUnderTest.setCreatedBy(createdBy);
        assertThat(emailStatusUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emailStatusUnderTest.setCreatedDate(createdDate);
        assertThat(emailStatusUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        emailStatusUnderTest.setModifiedBy(modifiedBy);
        assertThat(emailStatusUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emailStatusUnderTest.setLastModDate(lastModDate);
        assertThat(emailStatusUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final List<FeedbackDetails> feedbackDetails = List.of(new FeedbackDetails());
        emailStatusUnderTest.setFeedback(feedbackDetails);
        assertThat(emailStatusUnderTest.getFeedback()).isEqualTo(feedbackDetails);
    }

    @Test
    void testGetEmailStatus2() {
        // Setup
        final EmailStatus expectedResult = new EmailStatus();
        expectedResult.setEmailStatusID(0);
        expectedResult.setEmailStatus("emailStatus");
        expectedResult.setEmailStatusDesc("emailStatusDesc");
        expectedResult.setDeleted(false);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        final FeedbackDetails feedbackDetails = new FeedbackDetails();
        expectedResult.setFeedbackDetails(List.of(feedbackDetails));
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final EmailStatus result = emailStatusUnderTest.getEmailStatus(0, "emailStatus", "emailStatusDesc");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(emailStatusUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFeedbackDetails1GetterAndSetter() {
        final List<FeedbackDetails> feedbackDetails = List.of(new FeedbackDetails());
        emailStatusUnderTest.setFeedback(feedbackDetails);
        assertThat(emailStatusUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testFeedbackRequestsGetterAndSetter() {
        final List<FeedbackRequest> feedbackRequests = List.of(new FeedbackRequest());
        emailStatusUnderTest.setFeedbackRequests(feedbackRequests);
        assertThat(emailStatusUnderTest.getFeedbackRequests()).isEqualTo(feedbackRequests);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        emailStatusUnderTest.setOutputMapper(outputMapper);
        assertThat(emailStatusUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testFeedbackDetails2GetterAndSetter() {
        final List<FeedbackDetails> feedbackDetails = List.of(new FeedbackDetails());
        emailStatusUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(emailStatusUnderTest.getFeedback()).isEqualTo(feedbackDetails);
    }

    @Test
    void testEquals() {
        assertThat(emailStatusUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(emailStatusUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(emailStatusUnderTest.hashCode()).isEqualTo(0);
    }
}
