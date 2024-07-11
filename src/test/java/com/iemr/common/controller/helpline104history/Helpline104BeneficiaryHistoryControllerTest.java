package com.iemr.common.controller.helpline104history;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.helpline104history.H104BenMedHistory;
import com.iemr.common.service.helpline104history.H104BenHistoryServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;

import jakarta.ws.rs.NotFoundException;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class Helpline104BeneficiaryHistoryControllerTest {

	private final H104BenHistoryServiceImpl smpleBenHistoryServiceImplMock = mock(H104BenHistoryServiceImpl.class,
			"smpleBenHistoryServiceImpl");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private Helpline104BeneficiaryHistoryController target;

	@AfterEach()
	void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

	@Test
	void testGetBenCaseSheet_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(smpleBenHistoryServiceImplMock.geSmpleBenHistory(any()).toString()).thenThrow(NotFoundException.class);

		String response = target.getBenCaseSheet(request);
		assertEquals(response, target.getBenCaseSheet(request));
	}
}
