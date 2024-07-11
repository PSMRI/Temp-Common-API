package com.iemr.common.data.feedback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SeverityTest {

    private Severity severityUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        severityUnderTest = new Severity();
    }

    @Test
    void testSeverityIDGetterAndSetter() {
        final Integer severityID = 0;
        severityUnderTest.setSeverityID(severityID);
        assertThat(severityUnderTest.getSeverityID()).isEqualTo(severityID);
    }

    @Test
    void testSeverityTypeNameGetterAndSetter() {
        final String severityTypeName = "severityTypeName";
        severityUnderTest.setSeverityTypeName(severityTypeName);
        assertThat(severityUnderTest.getSeverityTypeName()).isEqualTo(severityTypeName);
    }

    @Test
    void testSeverityDescGetterAndSetter() {
        final String severityDesc = "severityDesc";
        severityUnderTest.setSeverityDesc(severityDesc);
        assertThat(severityUnderTest.getSeverityDesc()).isEqualTo(severityDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        severityUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(severityUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        severityUnderTest.setDeleted(deleted);
        assertThat(severityUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        severityUnderTest.setCreatedBy(createdBy);
        assertThat(severityUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        severityUnderTest.setCreatedDate(createdDate);
        assertThat(severityUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        severityUnderTest.setModifiedBy(modifiedBy);
        assertThat(severityUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        severityUnderTest.setLastModDate(lastModDate);
        assertThat(severityUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testFeedbackGetterAndSetter() {
        final FeedbackDetails feedback = new FeedbackDetails();
        severityUnderTest.setFeedback(feedback);
        assertThat(severityUnderTest.getFeedback()).isEqualTo(feedback);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(severityUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(severityUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(severityUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(severityUnderTest.toString()).isEqualTo("result");
    }
}
