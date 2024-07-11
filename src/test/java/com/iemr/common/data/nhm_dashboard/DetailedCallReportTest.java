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
class DetailedCallReportTest {

	@InjectMocks
    private DetailedCallReport detailedCallReportUnderTest;

    @BeforeEach
    void setUp() {
        detailedCallReportUnderTest = new DetailedCallReport();
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        detailedCallReportUnderTest.setId(id);
        assertThat(detailedCallReportUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testAgent_NameGetterAndSetter() {
        final String agent_Name = "Agent_Name";
        detailedCallReportUnderTest.setAgent_Name(agent_Name);
        assertThat(detailedCallReportUnderTest.getAgent_Name()).isEqualTo(agent_Name);
    }

    @Test
    void testAgent_IDGetterAndSetter() {
        final Integer agent_ID = 0;
        detailedCallReportUnderTest.setAgent_ID(agent_ID);
        assertThat(detailedCallReportUnderTest.getAgent_ID()).isEqualTo(agent_ID);
    }

    @Test
    void testUnique_idGetterAndSetter() {
        final String unique_id = "Unique_id";
        detailedCallReportUnderTest.setUnique_id(unique_id);
        assertThat(detailedCallReportUnderTest.getUnique_id()).isEqualTo(unique_id);
    }

    @Test
    void testCampaign_NameGetterAndSetter() {
        final String campaign_Name = "Campaign_Name";
        detailedCallReportUnderTest.setCampaign_Name(campaign_Name);
        assertThat(detailedCallReportUnderTest.getCampaign_Name()).isEqualTo(campaign_Name);
    }

    @Test
    void testList_NameGetterAndSetter() {
        final String list_Name = "List_Name";
        detailedCallReportUnderTest.setList_Name(list_Name);
        assertThat(detailedCallReportUnderTest.getList_Name()).isEqualTo(list_Name);
    }

    @Test
    void testCustomer_NameGetterAndSetter() {
        final String customer_Name = "Customer_Name";
        detailedCallReportUnderTest.setCustomer_Name(customer_Name);
        assertThat(detailedCallReportUnderTest.getCustomer_Name()).isEqualTo(customer_Name);
    }

    @Test
    void testPHONEGetterAndSetter() {
        final String pHONE = "PHONE";
        detailedCallReportUnderTest.setPHONE(pHONE);
        assertThat(detailedCallReportUnderTest.getPHONE()).isEqualTo(pHONE);
    }

    @Test
    void testZoneGetterAndSetter() {
        final String zone = "Zone";
        detailedCallReportUnderTest.setZone(zone);
        assertThat(detailedCallReportUnderTest.getZone()).isEqualTo(zone);
    }

    @Test
    void testCall_Start_TimeGetterAndSetter() {
        final String call_Start_Time = "Call_Start_Time";
        detailedCallReportUnderTest.setCall_Start_Time(call_Start_Time);
        assertThat(detailedCallReportUnderTest.getCall_Start_Time()).isEqualTo(call_Start_Time);
    }

    @Test
    void testCall_End_TimeGetterAndSetter() {
        final String call_End_Time = "Call_End_Time";
        detailedCallReportUnderTest.setCall_End_Time(call_End_Time);
        assertThat(detailedCallReportUnderTest.getCall_End_Time()).isEqualTo(call_End_Time);
    }

    @Test
    void testCallStartTimeGetterAndSetter() {
        final Timestamp callStartTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        detailedCallReportUnderTest.setCallStartTime(callStartTime);
        assertThat(detailedCallReportUnderTest.getCallStartTime()).isEqualTo(callStartTime);
    }

    @Test
    void testCallEndTimeGetterAndSetter() {
        final Timestamp callEndTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        detailedCallReportUnderTest.setCallEndTime(callEndTime);
        assertThat(detailedCallReportUnderTest.getCallEndTime()).isEqualTo(callEndTime);
    }

    @Test
    void testCall_StatusGetterAndSetter() {
        final String call_Status = "Call_Status";
        detailedCallReportUnderTest.setCall_Status(call_Status);
        assertThat(detailedCallReportUnderTest.getCall_Status()).isEqualTo(call_Status);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "Remarks";
        detailedCallReportUnderTest.setRemarks(remarks);
        assertThat(detailedCallReportUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testSession_IDGetterAndSetter() {
        final String session_ID = "Session_ID";
        detailedCallReportUnderTest.setSession_ID(session_ID);
        assertThat(detailedCallReportUnderTest.getSession_ID()).isEqualTo(session_ID);
    }

    @Test
    void testMonitor_File_PathGetterAndSetter() {
        final String monitor_File_Path = "Monitor_File_Path";
        detailedCallReportUnderTest.setMonitor_File_Path(monitor_File_Path);
        assertThat(detailedCallReportUnderTest.getMonitor_File_Path()).isEqualTo(monitor_File_Path);
    }

    @Test
    void testMonitor_File_NameGetterAndSetter() {
        final String monitor_File_Name = "Monitor_File_Name";
        detailedCallReportUnderTest.setMonitor_File_Name(monitor_File_Name);
        assertThat(detailedCallReportUnderTest.getMonitor_File_Name()).isEqualTo(monitor_File_Name);
    }

    @Test
    void testAgent_DispositionGetterAndSetter() {
        final String agent_Disposition = "Agent_Disposition";
        detailedCallReportUnderTest.setAgent_Disposition(agent_Disposition);
        assertThat(detailedCallReportUnderTest.getAgent_Disposition()).isEqualTo(agent_Disposition);
    }

    @Test
    void testQueue_timeGetterAndSetter() {
        final Integer queue_time = 0;
        detailedCallReportUnderTest.setQueue_time(queue_time);
        assertThat(detailedCallReportUnderTest.getQueue_time()).isEqualTo(queue_time);
    }

    @Test
    void testWrapup_timeGetterAndSetter() {
        final Integer wrapup_time = 0;
        detailedCallReportUnderTest.setWrapup_time(wrapup_time);
        assertThat(detailedCallReportUnderTest.getWrapup_time()).isEqualTo(wrapup_time);
    }

    @Test
    void testAgent_Disposition_CategoryGetterAndSetter() {
        final String agent_Disposition_Category = "Agent_Disposition_Category";
        detailedCallReportUnderTest.setAgent_Disposition_Category(agent_Disposition_Category);
        assertThat(detailedCallReportUnderTest.getAgent_Disposition_Category()).isEqualTo(agent_Disposition_Category);
    }

    @Test
    void testCall_SkillGetterAndSetter() {
        final String call_Skill = "Call_Skill";
        detailedCallReportUnderTest.setCall_Skill(call_Skill);
        assertThat(detailedCallReportUnderTest.getCall_Skill()).isEqualTo(call_Skill);
    }

    @Test
    void testDID_NumberGetterAndSetter() {
        final String dID_Number = "DID_Number";
        detailedCallReportUnderTest.setDID_Number(dID_Number);
        assertThat(detailedCallReportUnderTest.getDID_Number()).isEqualTo(dID_Number);
    }

    @Test
    void testHold_timeGetterAndSetter() {
        final Integer hold_time = 0;
        detailedCallReportUnderTest.setHold_time(hold_time);
        assertThat(detailedCallReportUnderTest.getHold_time()).isEqualTo(hold_time);
    }

    @Test
    void testOrientation_TypeGetterAndSetter() {
        final String orientation_Type = "Orientation_Type";
        detailedCallReportUnderTest.setOrientation_Type(orientation_Type);
        assertThat(detailedCallReportUnderTest.getOrientation_Type()).isEqualTo(orientation_Type);
    }

    @Test
    void testTransferred_ToGetterAndSetter() {
        final String transferred_To = "Transferred_To";
        detailedCallReportUnderTest.setTransferred_To(transferred_To);
        assertThat(detailedCallReportUnderTest.getTransferred_To()).isEqualTo(transferred_To);
    }

    @Test
    void testTransferred_fromGetterAndSetter() {
        final String transferred_from = "Transferred_from";
        detailedCallReportUnderTest.setTransferred_from(transferred_from);
        assertThat(detailedCallReportUnderTest.getTransferred_from()).isEqualTo(transferred_from);
    }

    @Test
    void testRing_Start_TimeGetterAndSetter() {
        final String ring_Start_Time = "Ring_Start_Time";
        detailedCallReportUnderTest.setRing_Start_Time(ring_Start_Time);
        assertThat(detailedCallReportUnderTest.getRing_Start_Time()).isEqualTo(ring_Start_Time);
    }

    @Test
    void testRing_End_TimeGetterAndSetter() {
        final String ring_End_Time = "Ring_End_Time";
        detailedCallReportUnderTest.setRing_End_Time(ring_End_Time);
        assertThat(detailedCallReportUnderTest.getRing_End_Time()).isEqualTo(ring_End_Time);
    }

    @Test
    void testAgent_Ring_Start_TimeGetterAndSetter() {
        final String agent_Ring_Start_Time = "Agent_Ring_Start_Time";
        detailedCallReportUnderTest.setAgent_Ring_Start_Time(agent_Ring_Start_Time);
        assertThat(detailedCallReportUnderTest.getAgent_Ring_Start_Time()).isEqualTo(agent_Ring_Start_Time);
    }

    @Test
    void testAgent_Ring_End_TimeGetterAndSetter() {
        final String agent_Ring_End_Time = "Agent_Ring_End_Time";
        detailedCallReportUnderTest.setAgent_Ring_End_Time(agent_Ring_End_Time);
        assertThat(detailedCallReportUnderTest.getAgent_Ring_End_Time()).isEqualTo(agent_Ring_End_Time);
    }

    @Test
    void testAgent_Ring_Start_Time_TGetterAndSetter() {
        final Timestamp agent_Ring_Start_Time_T = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        detailedCallReportUnderTest.setAgent_Ring_Start_Time_T(agent_Ring_Start_Time_T);
        assertThat(detailedCallReportUnderTest.getAgent_Ring_Start_Time_T()).isEqualTo(agent_Ring_Start_Time_T);
    }

    @Test
    void testAgent_Ring_End_Time_TGetterAndSetter() {
        final Timestamp agent_Ring_End_Time_T = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        detailedCallReportUnderTest.setAgent_Ring_End_Time_T(agent_Ring_End_Time_T);
        assertThat(detailedCallReportUnderTest.getAgent_Ring_End_Time_T()).isEqualTo(agent_Ring_End_Time_T);
    }

    @Test
    void testHold_Num_TimesGetterAndSetter() {
        final Integer hold_Num_Times = 0;
        detailedCallReportUnderTest.setHold_Num_Times(hold_Num_Times);
        assertThat(detailedCallReportUnderTest.getHold_Num_Times()).isEqualTo(hold_Num_Times);
    }

    @Test
    void testCaller_IdGetterAndSetter() {
        final String caller_Id = "Caller_Id";
        detailedCallReportUnderTest.setCaller_Id(caller_Id);
        assertThat(detailedCallReportUnderTest.getCaller_Id()).isEqualTo(caller_Id);
    }

    @Test
    void testChannelGetterAndSetter() {
        final String channel = "Channel";
        detailedCallReportUnderTest.setChannel(channel);
        assertThat(detailedCallReportUnderTest.getChannel()).isEqualTo(channel);
    }

    @Test
    void testCall_DurationGetterAndSetter() {
        final Integer call_Duration = 0;
        detailedCallReportUnderTest.setCall_Duration(call_Duration);
        assertThat(detailedCallReportUnderTest.getCall_Duration()).isEqualTo(call_Duration);
    }

    @Test
    void testWait_TimeGetterAndSetter() {
        final Integer wait_Time = 0;
        detailedCallReportUnderTest.setWait_Time(wait_Time);
        assertThat(detailedCallReportUnderTest.getWait_Time()).isEqualTo(wait_Time);
    }

    @Test
    void testCall_TypeGetterAndSetter() {
        final String call_Type = "Call_Type";
        detailedCallReportUnderTest.setCall_Type(call_Type);
        assertThat(detailedCallReportUnderTest.getCall_Type()).isEqualTo(call_Type);
    }

    @Test
    void testRedial_FlagGetterAndSetter() {
        final String redial_Flag = "Redial_Flag";
        detailedCallReportUnderTest.setRedial_Flag(redial_Flag);
        assertThat(detailedCallReportUnderTest.getRedial_Flag()).isEqualTo(redial_Flag);
    }

    @Test
    void testCustom_Monitor_File_NameGetterAndSetter() {
        final String custom_Monitor_File_Name = "Custom_Monitor_File_Name";
        detailedCallReportUnderTest.setCustom_Monitor_File_Name(custom_Monitor_File_Name);
        assertThat(detailedCallReportUnderTest.getCustom_Monitor_File_Name()).isEqualTo(custom_Monitor_File_Name);
    }

    @Test
    void testNext_Call_TimeGetterAndSetter() {
        final Integer next_Call_Time = 0;
        detailedCallReportUnderTest.setNext_Call_Time(next_Call_Time);
        assertThat(detailedCallReportUnderTest.getNext_Call_Time()).isEqualTo(next_Call_Time);
    }

    @Test
    void testPhone_typeGetterAndSetter() {
        final String phone_type = "phone_type";
        detailedCallReportUnderTest.setPhone_type(phone_type);
        assertThat(detailedCallReportUnderTest.getPhone_type()).isEqualTo(phone_type);
    }

    @Test
    void testIvrs_pathGetterAndSetter() {
        final String ivrs_path = "ivrs_path";
        detailedCallReportUnderTest.setIvrs_path(ivrs_path);
        assertThat(detailedCallReportUnderTest.getIvrs_path()).isEqualTo(ivrs_path);
    }

    @Test
    void testDisconnected_ByGetterAndSetter() {
        final String disconnected_By = "Disconnected_By";
        detailedCallReportUnderTest.setDisconnected_By(disconnected_By);
        assertThat(detailedCallReportUnderTest.getDisconnected_By()).isEqualTo(disconnected_By);
    }

    @Test
    void testRingingGetterAndSetter() {
        final String ringing = "Ringing";
        detailedCallReportUnderTest.setRinging(ringing);
        assertThat(detailedCallReportUnderTest.getRinging()).isEqualTo(ringing);
    }

    @Test
    void testTotal_AttemptGetterAndSetter() {
        final Integer total_Attempt = 0;
        detailedCallReportUnderTest.setTotal_Attempt(total_Attempt);
        assertThat(detailedCallReportUnderTest.getTotal_Attempt()).isEqualTo(total_Attempt);
    }

    @Test
    void testTotal_Phone_AttemptGetterAndSetter() {
        final Integer total_Phone_Attempt = 0;
        detailedCallReportUnderTest.setTotal_Phone_Attempt(total_Phone_Attempt);
        assertThat(detailedCallReportUnderTest.getTotal_Phone_Attempt()).isEqualTo(total_Phone_Attempt);
    }

    @Test
    void testDialer_ActionGetterAndSetter() {
        final String dialer_Action = "Dialer_Action";
        detailedCallReportUnderTest.setDialer_Action(dialer_Action);
        assertThat(detailedCallReportUnderTest.getDialer_Action()).isEqualTo(dialer_Action);
    }

    @Test
    void testRing_DurationGetterAndSetter() {
        final Integer ring_Duration = 0;
        detailedCallReportUnderTest.setRing_Duration(ring_Duration);
        assertThat(detailedCallReportUnderTest.getRing_Duration()).isEqualTo(ring_Duration);
    }

    @Test
    void testActual_Talk_TimeGetterAndSetter() {
        final Integer actual_Talk_Time = 0;
        detailedCallReportUnderTest.setActual_Talk_Time(actual_Talk_Time);
        assertThat(detailedCallReportUnderTest.getActual_Talk_Time()).isEqualTo(actual_Talk_Time);
    }

    @Test
    void testFinal_Call_StatusGetterAndSetter() {
        final String final_Call_Status = "Final_Call_Status";
        detailedCallReportUnderTest.setFinal_Call_Status(final_Call_Status);
        assertThat(detailedCallReportUnderTest.getFinal_Call_Status()).isEqualTo(final_Call_Status);
    }

    @Test
    void testFailure_ReasonGetterAndSetter() {
        final Integer failure_Reason = 0;
        detailedCallReportUnderTest.setFailure_Reason(failure_Reason);
        assertThat(detailedCallReportUnderTest.getFailure_Reason()).isEqualTo(failure_Reason);
    }

    @Test
    void testAgent_Ring_DurationGetterAndSetter() {
        final Integer agent_Ring_Duration = 0;
        detailedCallReportUnderTest.setAgent_Ring_Duration(agent_Ring_Duration);
        assertThat(detailedCallReportUnderTest.getAgent_Ring_Duration()).isEqualTo(agent_Ring_Duration);
    }

    @Test
    void testWrapped_ByGetterAndSetter() {
        final String wrapped_By = "Wrapped_By";
        detailedCallReportUnderTest.setWrapped_By(wrapped_By);
        assertThat(detailedCallReportUnderTest.getWrapped_By()).isEqualTo(wrapped_By);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        detailedCallReportUnderTest.setDeleted(deleted);
        assertThat(detailedCallReportUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        detailedCallReportUnderTest.setProcessed(processed);
        assertThat(detailedCallReportUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        detailedCallReportUnderTest.setCreatedBy(createdBy);
        assertThat(detailedCallReportUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        detailedCallReportUnderTest.setCreatedDate(createdDate);
        assertThat(detailedCallReportUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        detailedCallReportUnderTest.setModifiedBy(modifiedBy);
        assertThat(detailedCallReportUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        detailedCallReportUnderTest.setLastModDate(lastModDate);
        assertThat(detailedCallReportUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(detailedCallReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(detailedCallReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(detailedCallReportUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(detailedCallReportUnderTest.toString()).isEqualTo("result");
    }
}
