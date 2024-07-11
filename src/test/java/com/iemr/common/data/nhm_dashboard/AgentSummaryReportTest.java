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
class AgentSummaryReportTest {

	@InjectMocks
    private AgentSummaryReport agentSummaryReportUnderTest;

    @BeforeEach
    void setUp() {
        agentSummaryReportUnderTest = new AgentSummaryReport();
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        agentSummaryReportUnderTest.setId(id);
        assertThat(agentSummaryReportUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testAgent_nameGetterAndSetter() {
        final String agent_name = "agent_name";
        agentSummaryReportUnderTest.setAgent_name(agent_name);
        assertThat(agentSummaryReportUnderTest.getAgent_name()).isEqualTo(agent_name);
    }

    @Test
    void testAgent_idGetterAndSetter() {
        final Integer agent_id = 0;
        agentSummaryReportUnderTest.setAgent_id(agent_id);
        assertThat(agentSummaryReportUnderTest.getAgent_id()).isEqualTo(agent_id);
    }

    @Test
    void testAgent_identityGetterAndSetter() {
        final String agent_identity = "agent_identity";
        agentSummaryReportUnderTest.setAgent_identity(agent_identity);
        assertThat(agentSummaryReportUnderTest.getAgent_identity()).isEqualTo(agent_identity);
    }

    @Test
    void testCampaign_nameGetterAndSetter() {
        final String campaign_name = "campaign_name";
        agentSummaryReportUnderTest.setCampaign_name(campaign_name);
        assertThat(agentSummaryReportUnderTest.getCampaign_name()).isEqualTo(campaign_name);
    }

    @Test
    void testTotal_callGetterAndSetter() {
        final Integer total_call = 0;
        agentSummaryReportUnderTest.setTotal_call(total_call);
        assertThat(agentSummaryReportUnderTest.getTotal_call()).isEqualTo(total_call);
    }

    @Test
    void testAnswd_prevGetterAndSetter() {
        final Integer answd_prev = 0;
        agentSummaryReportUnderTest.setAnswd_prev(answd_prev);
        assertThat(agentSummaryReportUnderTest.getAnswd_prev()).isEqualTo(answd_prev);
    }

    @Test
    void testAnswd_proGetterAndSetter() {
        final Integer answd_pro = 0;
        agentSummaryReportUnderTest.setAnswd_pro(answd_pro);
        assertThat(agentSummaryReportUnderTest.getAnswd_pro()).isEqualTo(answd_pro);
    }

    @Test
    void testAnswd_predGetterAndSetter() {
        final Integer answd_pred = 0;
        agentSummaryReportUnderTest.setAnswd_pred(answd_pred);
        assertThat(agentSummaryReportUnderTest.getAnswd_pred()).isEqualTo(answd_pred);
    }

    @Test
    void testDisp_setGetterAndSetter() {
        final Integer disp_set = 0;
        agentSummaryReportUnderTest.setDisp_set(disp_set);
        assertThat(agentSummaryReportUnderTest.getDisp_set()).isEqualTo(disp_set);
    }

    @Test
    void testDisp_not_setGetterAndSetter() {
        final Integer disp_not_set = 0;
        agentSummaryReportUnderTest.setDisp_not_set(disp_not_set);
        assertThat(agentSummaryReportUnderTest.getDisp_not_set()).isEqualTo(disp_not_set);
    }

    @Test
    void testCalls_heldGetterAndSetter() {
        final Integer calls_held = 0;
        agentSummaryReportUnderTest.setCalls_held(calls_held);
        assertThat(agentSummaryReportUnderTest.getCalls_held()).isEqualTo(calls_held);
    }

    @Test
    void testTalk_timeGetterAndSetter() {
        final String talk_time = "talk_time";
        agentSummaryReportUnderTest.setTalk_time(talk_time);
        assertThat(agentSummaryReportUnderTest.getTalk_time()).isEqualTo(talk_time);
    }

    @Test
    void testAvg_talk_timeGetterAndSetter() {
        final String avg_talk_time = "avg_talk_time";
        agentSummaryReportUnderTest.setAvg_talk_time(avg_talk_time);
        assertThat(agentSummaryReportUnderTest.getAvg_talk_time()).isEqualTo(avg_talk_time);
    }

    @Test
    void testPreview_talk_timeGetterAndSetter() {
        final String preview_talk_time = "preview_talk_time";
        agentSummaryReportUnderTest.setPreview_talk_time(preview_talk_time);
        assertThat(agentSummaryReportUnderTest.getPreview_talk_time()).isEqualTo(preview_talk_time);
    }

    @Test
    void testActual_talk_timeGetterAndSetter() {
        final String actual_talk_time = "actual_talk_time";
        agentSummaryReportUnderTest.setActual_talk_time(actual_talk_time);
        assertThat(agentSummaryReportUnderTest.getActual_talk_time()).isEqualTo(actual_talk_time);
    }

    @Test
    void testRing_timeGetterAndSetter() {
        final String ring_time = "ring_time";
        agentSummaryReportUnderTest.setRing_time(ring_time);
        assertThat(agentSummaryReportUnderTest.getRing_time()).isEqualTo(ring_time);
    }

    @Test
    void testAvg_ring_timeGetterAndSetter() {
        final String avg_ring_time = "avg_ring_time";
        agentSummaryReportUnderTest.setAvg_ring_time(avg_ring_time);
        assertThat(agentSummaryReportUnderTest.getAvg_ring_time()).isEqualTo(avg_ring_time);
    }

    @Test
    void testHold_timeGetterAndSetter() {
        final String hold_time = "hold_time";
        agentSummaryReportUnderTest.setHold_time(hold_time);
        assertThat(agentSummaryReportUnderTest.getHold_time()).isEqualTo(hold_time);
    }

    @Test
    void testAvg_hold_timeGetterAndSetter() {
        final String avg_hold_time = "avg_hold_time";
        agentSummaryReportUnderTest.setAvg_hold_time(avg_hold_time);
        assertThat(agentSummaryReportUnderTest.getAvg_hold_time()).isEqualTo(avg_hold_time);
    }

    @Test
    void testCall_handled_timeGetterAndSetter() {
        final String call_handled_time = "call_handled_time";
        agentSummaryReportUnderTest.setCall_handled_time(call_handled_time);
        assertThat(agentSummaryReportUnderTest.getCall_handled_time()).isEqualTo(call_handled_time);
    }

    @Test
    void testAvg_call_handled_durationGetterAndSetter() {
        final String avg_call_handled_duration = "avg_call_handled_duration";
        agentSummaryReportUnderTest.setAvg_call_handled_duration(avg_call_handled_duration);
        assertThat(agentSummaryReportUnderTest.getAvg_call_handled_duration()).isEqualTo(avg_call_handled_duration);
    }

    @Test
    void testWrap_countGetterAndSetter() {
        final Integer wrap_count = 0;
        agentSummaryReportUnderTest.setWrap_count(wrap_count);
        assertThat(agentSummaryReportUnderTest.getWrap_count()).isEqualTo(wrap_count);
    }

    @Test
    void testWrapup_timeGetterAndSetter() {
        final String wrapup_time = "wrapup_time";
        agentSummaryReportUnderTest.setWrapup_time(wrapup_time);
        assertThat(agentSummaryReportUnderTest.getWrapup_time()).isEqualTo(wrapup_time);
    }

    @Test
    void testAvg_wrapup_timeGetterAndSetter() {
        final String avg_wrapup_time = "avg_wrapup_time";
        agentSummaryReportUnderTest.setAvg_wrapup_time(avg_wrapup_time);
        assertThat(agentSummaryReportUnderTest.getAvg_wrapup_time()).isEqualTo(avg_wrapup_time);
    }

    @Test
    void testTotal_login_timeGetterAndSetter() {
        final String total_login_time = "total_login_time";
        agentSummaryReportUnderTest.setTotal_login_time(total_login_time);
        assertThat(agentSummaryReportUnderTest.getTotal_login_time()).isEqualTo(total_login_time);
    }

    @Test
    void testIdle_timeGetterAndSetter() {
        final String idle_time = "idle_time";
        agentSummaryReportUnderTest.setIdle_time(idle_time);
        assertThat(agentSummaryReportUnderTest.getIdle_time()).isEqualTo(idle_time);
    }

    @Test
    void testPauseDurationGetterAndSetter() {
        final String pauseDuration = "pauseDuration";
        agentSummaryReportUnderTest.setPauseDuration(pauseDuration);
        assertThat(agentSummaryReportUnderTest.getPauseDuration()).isEqualTo(pauseDuration);
    }

    @Test
    void testPreview_pause_durationGetterAndSetter() {
        final String preview_pause_duration = "preview_pause_duration";
        agentSummaryReportUnderTest.setPreview_pause_duration(preview_pause_duration);
        assertThat(agentSummaryReportUnderTest.getPreview_pause_duration()).isEqualTo(preview_pause_duration);
    }

    @Test
    void testReady_timeGetterAndSetter() {
        final String ready_time = "ready_time";
        agentSummaryReportUnderTest.setReady_time(ready_time);
        assertThat(agentSummaryReportUnderTest.getReady_time()).isEqualTo(ready_time);
    }

    @Test
    void testStaff_timeGetterAndSetter() {
        final String staff_time = "staff_time";
        agentSummaryReportUnderTest.setStaff_time(staff_time);
        assertThat(agentSummaryReportUnderTest.getStaff_time()).isEqualTo(staff_time);
    }

    @Test
    void testConf_durationGetterAndSetter() {
        final String conf_duration = "conf_duration";
        agentSummaryReportUnderTest.setConf_duration(conf_duration);
        assertThat(agentSummaryReportUnderTest.getConf_duration()).isEqualTo(conf_duration);
    }

    @Test
    void testTotal_preview_timeGetterAndSetter() {
        final String total_preview_time = "total_preview_time";
        agentSummaryReportUnderTest.setTotal_preview_time(total_preview_time);
        assertThat(agentSummaryReportUnderTest.getTotal_preview_time()).isEqualTo(total_preview_time);
    }

    @Test
    void testPre_idle_timeGetterAndSetter() {
        final String pre_idle_time = "pre_idle_time";
        agentSummaryReportUnderTest.setPre_idle_time(pre_idle_time);
        assertThat(agentSummaryReportUnderTest.getPre_idle_time()).isEqualTo(pre_idle_time);
    }

    @Test
    void testStart_timeGetterAndSetter() {
        final String start_time = "start_time";
        agentSummaryReportUnderTest.setStart_time(start_time);
        assertThat(agentSummaryReportUnderTest.getStart_time()).isEqualTo(start_time);
    }

    @Test
    void testEnd_timeGetterAndSetter() {
        final String end_time = "end_time";
        agentSummaryReportUnderTest.setEnd_time(end_time);
        assertThat(agentSummaryReportUnderTest.getEnd_time()).isEqualTo(end_time);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        agentSummaryReportUnderTest.setDeleted(deleted);
        assertThat(agentSummaryReportUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        agentSummaryReportUnderTest.setProcessed(processed);
        assertThat(agentSummaryReportUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        agentSummaryReportUnderTest.setCreatedBy(createdBy);
        assertThat(agentSummaryReportUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        agentSummaryReportUnderTest.setCreatedDate(createdDate);
        assertThat(agentSummaryReportUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        agentSummaryReportUnderTest.setModifiedBy(modifiedBy);
        assertThat(agentSummaryReportUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        agentSummaryReportUnderTest.setLastModDate(lastModDate);
        assertThat(agentSummaryReportUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(agentSummaryReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(agentSummaryReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(agentSummaryReportUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(agentSummaryReportUnderTest.toString()).isEqualTo("result");
    }
}
