package com.iemr.common.data.nhm_dashboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AbandonCallSummaryTest {

	@InjectMocks
    private AbandonCallSummary abandonCallSummaryUnderTest;

    @BeforeEach
    void setUp() {
        abandonCallSummaryUnderTest = new AbandonCallSummary();
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        abandonCallSummaryUnderTest.setId(id);
        assertThat(abandonCallSummaryUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testCustomerPhoneNumberGetterAndSetter() {
        final String customerPhoneNumber = "customerPhoneNumber";
        abandonCallSummaryUnderTest.setCustomerPhoneNumber(customerPhoneNumber);
        assertThat(abandonCallSummaryUnderTest.getCustomerPhoneNumber()).isEqualTo(customerPhoneNumber);
    }

    @Test
    void testUniqueIdGetterAndSetter() {
        final String uniqueId = "uniqueId";
        abandonCallSummaryUnderTest.setUniqueId(uniqueId);
        assertThat(abandonCallSummaryUnderTest.getUniqueId()).isEqualTo(uniqueId);
    }

    @Test
    void testQueueEnterTimeGetterAndSetter() {
        final Timestamp queueEnterTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        abandonCallSummaryUnderTest.setQueueEnterTime(queueEnterTime);
        assertThat(abandonCallSummaryUnderTest.getQueueEnterTime()).isEqualTo(queueEnterTime);
    }

    @Test
    void testQueueTimeGetterAndSetter() {
        final Integer queueTime = 0;
        abandonCallSummaryUnderTest.setQueueTime(queueTime);
        assertThat(abandonCallSummaryUnderTest.getQueueTime()).isEqualTo(queueTime);
    }

    @Test
    void testDidNumberGetterAndSetter() {
        final BigInteger didNumber = new BigInteger("100");
        abandonCallSummaryUnderTest.setDidNumber(didNumber);
        assertThat(abandonCallSummaryUnderTest.getDidNumber()).isEqualTo(didNumber);
    }

    @Test
    void testSkillsGetterAndSetter() {
        final String skills = "skills";
        abandonCallSummaryUnderTest.setSkills(skills);
        assertThat(abandonCallSummaryUnderTest.getSkills()).isEqualTo(skills);
    }

    @Test
    void testCampaignNameGetterAndSetter() {
        final String campaignName = "campaignName";
        abandonCallSummaryUnderTest.setCampaignName(campaignName);
        assertThat(abandonCallSummaryUnderTest.getCampaignName()).isEqualTo(campaignName);
    }

    @Test
    void testRedicalFlagGetterAndSetter() {
        final String redicalFlag = "redicalFlag";
        abandonCallSummaryUnderTest.setRedicalFlag(redicalFlag);
        assertThat(abandonCallSummaryUnderTest.getRedicalFlag()).isEqualTo(redicalFlag);
    }

    @Test
    void testCallTypeGetterAndSetter() {
        final String callType = "callType";
        abandonCallSummaryUnderTest.setCallType(callType);
        assertThat(abandonCallSummaryUnderTest.getCallType()).isEqualTo(callType);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        abandonCallSummaryUnderTest.setDeleted(deleted);
        assertThat(abandonCallSummaryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        abandonCallSummaryUnderTest.setProcessed(processed);
        assertThat(abandonCallSummaryUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        abandonCallSummaryUnderTest.setCreatedBy(createdBy);
        assertThat(abandonCallSummaryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        abandonCallSummaryUnderTest.setCreatedDate(createdDate);
        assertThat(abandonCallSummaryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        abandonCallSummaryUnderTest.setModifiedBy(modifiedBy);
        assertThat(abandonCallSummaryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        abandonCallSummaryUnderTest.setLastModDate(lastModDate);
        assertThat(abandonCallSummaryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(abandonCallSummaryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(abandonCallSummaryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(abandonCallSummaryUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(abandonCallSummaryUnderTest.toString()).isEqualTo("result");
    }
}
