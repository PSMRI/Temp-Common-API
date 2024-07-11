package com.iemr.common.controller.nhmdashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import com.iemr.common.data.nhm_dashboard.DetailedCallReport;
import com.iemr.common.repository.nhm_dashboard.DetailedCallReportRepo;
import com.iemr.common.repository.report.CallReportRepo;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class NHMDetailCallReportSchedulerTest {

	@Mock
	private DetailedCallReportRepo detailedCallReportRepo;

	@Mock
	private CallReportRepo callReportRepo;

	@InjectMocks
	private NHMDetailCallReportScheduler scheduler;

	@Value("${start-ctidatacheck-scheduler}")
	private boolean startCtiDataCheckFlag = true; // Assuming this is how you would like to inject values for testing
													// purposes

	@Test
	void testDetailedCallReportSchedulerEnabledAndRecordsFound() {
		// Use ReflectionTestUtils to set the private field value
		ReflectionTestUtils.setField(scheduler, "startCtiDataCheckFlag", true);

		DetailedCallReport report = new DetailedCallReport(); // Set necessary fields
		report.setSession_ID("session1");
		report.setPHONE("1234567890");
		List<DetailedCallReport> reports = Collections.singletonList(report);

		when(detailedCallReportRepo.findByCallStartTimeBetween(any(Timestamp.class), any(Timestamp.class)))
				.thenReturn(reports);
		when(callReportRepo.getBenCallDetailsBySessionIDAndPhone(anyString(), anyString())).thenReturn(null);

		// When
		scheduler.detailedCallReport();

		// Then
		verify(callReportRepo, times(1)).getBenCallDetailsBySessionIDAndPhone(anyString(), anyString());
	}

	@Test
	void testDetailedCallReportSchedulerDisabled() {
		// Given
		this.startCtiDataCheckFlag = false; // Directly set the flag to false or use a setter method

		// When
		scheduler.detailedCallReport();

		// Then
		verify(detailedCallReportRepo, never()).findByCallStartTimeBetween(any(Timestamp.class), any(Timestamp.class));
	}

}
