package com.iemr.common.data.nhm_dashboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AgentRealTimeDataTest {

	@InjectMocks
    private AgentRealTimeData agentRealTimeDataUnderTest;

    @BeforeEach
    void setUp() {
        agentRealTimeDataUnderTest = new AgentRealTimeData();
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        agentRealTimeDataUnderTest.setId(id);
        assertThat(agentRealTimeDataUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testCampaignNameGetterAndSetter() {
        final String campaignName = "campaignName";
        agentRealTimeDataUnderTest.setCampaignName(campaignName);
        assertThat(agentRealTimeDataUnderTest.getCampaignName()).isEqualTo(campaignName);
    }

    @Test
    void testLoggedInGetterAndSetter() {
        final int loggedIn = 0;
        agentRealTimeDataUnderTest.setLoggedIn(loggedIn);
        assertThat(agentRealTimeDataUnderTest.getLoggedIn()).isEqualTo(loggedIn);
    }

    @Test
    void testFreeGetterAndSetter() {
        final int free = 0;
        agentRealTimeDataUnderTest.setFree(free);
        assertThat(agentRealTimeDataUnderTest.getFree()).isEqualTo(free);
    }

    @Test
    void testInCallGetterAndSetter() {
        final int inCall = 0;
        agentRealTimeDataUnderTest.setInCall(inCall);
        assertThat(agentRealTimeDataUnderTest.getInCall()).isEqualTo(inCall);
    }

    @Test
    void testAwtGetterAndSetter() {
        final int awt = 0;
        agentRealTimeDataUnderTest.setAwt(awt);
        assertThat(agentRealTimeDataUnderTest.getAwt()).isEqualTo(awt);
    }

    @Test
    void testHoldGetterAndSetter() {
        final int hold = 0;
        agentRealTimeDataUnderTest.setHold(hold);
        assertThat(agentRealTimeDataUnderTest.getHold()).isEqualTo(hold);
    }

    @Test
    void testNotReadyGetterAndSetter() {
        final int notReady = 0;
        agentRealTimeDataUnderTest.setNotReady(notReady);
        assertThat(agentRealTimeDataUnderTest.getNotReady()).isEqualTo(notReady);
    }

    @Test
    void testAuxGetterAndSetter() {
        final int aux = 0;
        agentRealTimeDataUnderTest.setAux(aux);
        assertThat(agentRealTimeDataUnderTest.getAux()).isEqualTo(aux);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        agentRealTimeDataUnderTest.setDeleted(deleted);
        assertThat(agentRealTimeDataUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        agentRealTimeDataUnderTest.setProcessed(processed);
        assertThat(agentRealTimeDataUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        agentRealTimeDataUnderTest.setCreatedBy(createdBy);
        assertThat(agentRealTimeDataUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        agentRealTimeDataUnderTest.setCreatedDate(createdDate);
        assertThat(agentRealTimeDataUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        agentRealTimeDataUnderTest.setModifiedBy(modifiedBy);
        assertThat(agentRealTimeDataUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testModifiedDateGetterAndSetter() {
        final Timestamp modifiedDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        agentRealTimeDataUnderTest.setModifiedDate(modifiedDate);
        assertThat(agentRealTimeDataUnderTest.getModifiedDate()).isEqualTo(modifiedDate);
    }

    @Test
    void testEquals() {
        assertThat(agentRealTimeDataUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(agentRealTimeDataUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(agentRealTimeDataUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(agentRealTimeDataUnderTest.toString()).isEqualTo("result");
    }
}
