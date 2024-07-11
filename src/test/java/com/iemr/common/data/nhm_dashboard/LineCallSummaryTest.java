package com.iemr.common.data.nhm_dashboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LineCallSummaryTest {

	@InjectMocks
    private LineCallSummary lineCallSummaryUnderTest;

    @BeforeEach
    void setUp() {
        lineCallSummaryUnderTest = new LineCallSummary();
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        lineCallSummaryUnderTest.setId(id);
        assertThat(lineCallSummaryUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testLineNumberGetterAndSetter() {
        final String lineNumber = "lineNumber";
        lineCallSummaryUnderTest.setLineNumber(lineNumber);
        assertThat(lineCallSummaryUnderTest.getLineNumber()).isEqualTo(lineNumber);
    }

    @Test
    void testCampaignNameGetterAndSetter() {
        final String campaignName = "campaignName";
        lineCallSummaryUnderTest.setCampaignName(campaignName);
        assertThat(lineCallSummaryUnderTest.getCampaignName()).isEqualTo(campaignName);
    }

    @Test
    void testTotalCallsGetterAndSetter() {
        final Integer totalCalls = 0;
        lineCallSummaryUnderTest.setTotalCalls(totalCalls);
        assertThat(lineCallSummaryUnderTest.getTotalCalls()).isEqualTo(totalCalls);
    }

    @Test
    void testTotalTalkTimeGetterAndSetter() {
        final Time totalTalkTime = Time.valueOf(LocalTime.of(0, 0, 0));
        lineCallSummaryUnderTest.setTotalTalkTime(totalTalkTime);
        assertThat(lineCallSummaryUnderTest.getTotalTalkTime()).isEqualTo(totalTalkTime);
    }

    @Test
    void testAverageTalkTimeGetterAndSetter() {
        final Time averageTalkTime = Time.valueOf(LocalTime.of(0, 0, 0));
        lineCallSummaryUnderTest.setAverageTalkTime(averageTalkTime);
        assertThat(lineCallSummaryUnderTest.getAverageTalkTime()).isEqualTo(averageTalkTime);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        lineCallSummaryUnderTest.setDeleted(deleted);
        assertThat(lineCallSummaryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        lineCallSummaryUnderTest.setProcessed(processed);
        assertThat(lineCallSummaryUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        lineCallSummaryUnderTest.setCreatedBy(createdBy);
        assertThat(lineCallSummaryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        lineCallSummaryUnderTest.setCreatedDate(createdDate);
        assertThat(lineCallSummaryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        lineCallSummaryUnderTest.setModifiedBy(modifiedBy);
        assertThat(lineCallSummaryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        lineCallSummaryUnderTest.setLastModDate(lastModDate);
        assertThat(lineCallSummaryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(lineCallSummaryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(lineCallSummaryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(lineCallSummaryUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(lineCallSummaryUnderTest.toString()).isEqualTo("result");
    }
}
