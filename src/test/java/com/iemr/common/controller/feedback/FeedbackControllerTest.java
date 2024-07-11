package com.iemr.common.controller.feedback;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackLog;
import com.iemr.common.data.feedback.FeedbackResponse;
import com.iemr.common.data.feedback.FeedbackSeverity;
import com.iemr.common.data.feedback.FeedbackType;
import com.iemr.common.model.feedback.FeedbackListRequestModel;
import com.iemr.common.service.feedback.FeedbackRequestService;
import com.iemr.common.service.feedback.FeedbackResponseService;
import com.iemr.common.service.feedback.FeedbackService;
import com.iemr.common.service.feedback.FeedbackSeverityServiceImpl;
import com.iemr.common.service.feedback.FeedbackTypeService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class FeedbackControllerTest {

	private final FeedbackService feedbackServiceMock = mock(FeedbackService.class, "feedbackService");

	private final FeedbackRequestService feedbackRequestServiceMock = mock(FeedbackRequestService.class,
			"feedbackRequestService");

	private final FeedbackResponseService feedbackResponseServiceMock = mock(FeedbackResponseService.class,
			"feedbackResponseService");

	private final FeedbackSeverityServiceImpl feedbackSeverityServiceMock = mock(FeedbackSeverityServiceImpl.class,
			"feedbackSeverityService");

	private final FeedbackTypeService feedbackTypeServiceMock = mock(FeedbackTypeService.class, "feedbackTypeService");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private FeedbackController target;

	@AfterEach()
	void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

	@Test()
	void feedbackRequestTest() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbackRequest("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	@Test()
	void feedbackRequestWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbackRequest("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	@Test()
	void getFeedbackByPostTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
		doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(2L);
		// Act Statement(s)
		String result = target.getFeedbackByPost(2L);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result,
					equalTo("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackRequests(2L);
		});
	}

	@Test()
	void getFeedbackByPostWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
		doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(2L);
		// Act Statement(s)
		String result = target.getFeedbackByPost(2L);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result,
					equalTo("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackRequests(2L);
		});
	}

	@Test()
	void createFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).saveFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.createFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedback("feedbackDetails1");
		});
	}

	@Test()
	void createFeedbackWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).saveFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.createFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedback("feedbackDetails1");
		});
	}

	@Test()
	void feedbacksListTest() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbacksList("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	@Test()
	void feedbacksListWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackDetails feedbackDetailsMock = mock(FeedbackDetails.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackDetailsMock).when(inputMapperMock).fromJson("request1", FeedbackDetails.class);
			doReturn(0L).when(feedbackDetailsMock).getBeneficiaryRegID();
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			List<FeedbackDetails> feedbackDetailsList = new ArrayList<>();
			doReturn(feedbackDetailsList).when(feedbackServiceMock).getFeedbackRequests(0L);
			// Act Statement(s)
			String result = target.feedbacksList("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", FeedbackDetails.class);
				verify(feedbackDetailsMock).getBeneficiaryRegID();
				verify(feedbackServiceMock).getFeedbackRequests(0L);
			});
		}
	}

	@Test()
	void getFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getAllData("feedbackRequest1");
		// Act Statement(s)
		String result = target.getFeedback("feedbackRequest1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getAllData("feedbackRequest1");
		});
	}

	@Test()
	void getFeedbackWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getAllData("feedbackRequest1");
		// Act Statement(s)
		String result = target.getFeedback("feedbackRequest1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getAllData("feedbackRequest1");
		});
	}

	@Test()
	void updateFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn(2).when(feedbackServiceMock).updateFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.updateFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"2\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedback("feedbackDetails1");
		});
	}

	@Test()
	void updateFeedbackWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn(2).when(feedbackServiceMock).updateFeedback("feedbackDetails1");
		// Act Statement(s)
		String result = target.updateFeedback("feedbackDetails1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"2\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedback("feedbackDetails1");
		});
	}

	@Test()
	void updateFeedbackStatusTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateFeedbackStatus("");
		// Act Statement(s)
		String result = target.updateFeedbackStatus("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedbackStatus("");
		});
	}

	@Test()
	void updateFeedbackStatusWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateFeedbackStatus("D");
		// Act Statement(s)
		String result = target.updateFeedbackStatus("D");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateFeedbackStatus("D");
		});
	}

	@Test()
	void searchFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback("");
		// Act Statement(s)
		String result = target.searchFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback("");
		});
	}

	@Test()
	void searchFeedbackWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback("");
		// Act Statement(s)
		String result = target.searchFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback("");
		});
	}

	@Test()
	void searchFeedback1Test() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback1("");
		// Act Statement(s)
		String result = target.searchFeedback1("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback1("");
		});
	}

	@Test()
	void searchFeedback1WhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).searchFeedback1("");
		// Act Statement(s)
		String result = target.searchFeedback1("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).searchFeedback1("");
		});
	}

	@Test()
	void getAllFeedbackByIdTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getAllFeedbackById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	@Test()
	void getAllFeedbackByIdWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getAllFeedbackById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	// Sapient generated method id: ${b55f32b0-6608-3b68-9b57-67d5998a0e5f}, hash:
	// C3E626822CB5A1BE9415B1569B6BA882
	@Test()
	void getFeedbackStatusTypesTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getFeedbackStatus("request1");
		// Act Statement(s)
		String result = target.getFeedbackStatusTypes("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackStatus("request1");
		});
	}

	// Sapient generated method id: ${10c23ab1-fb82-3597-9de6-2f93db0c3de4}, hash:
	// 5AF7F0DE664008B140EBA8CEC974E6F5
	@Test()
	void getFeedbackStatusTypesWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getFeedbackStatus("request1");
		// Act Statement(s)
		String result = target.getFeedbackStatusTypes("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getFeedbackStatus("request1");
		});
	}

	@Test()
	void getEmailStatusTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getEmailStatus("request1");
		// Act Statement(s)
		String result = target.getEmailStatus("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getEmailStatus("request1");
		});
	}

	@Test()
	void getEmailStatusWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("A").when(feedbackServiceMock).getEmailStatus("request1");
		// Act Statement(s)
		String result = target.getEmailStatus("request1");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).getEmailStatus("request1");
		});
	}

	@Test()
	void getFeedbackRequestByIdTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackRequestById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	@Test()
	void getFeedbackRequestByIdWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackRequestById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	@Test()
	void getFeedbackResponseByIdTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackResponseById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	@Test()
	void getFeedbackResponseByIdWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackRequestServiceMock).getAllFeedback("");
		// Act Statement(s)
		String result = target.getFeedbackResponseById("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackRequestServiceMock).getAllFeedback("");
		});
	}

	@Test()
	void getFeedbacksListTest() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getFeedbacksList_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		// Act Statement(s)
		String result = target.getFeedbacksList(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		});
	}

	@Test()
	void getFeedbacksListWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getFeedbacksList_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		// Act Statement(s)
		String result = target.getFeedbacksList(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getFeedbacksList(feedbackListRequestModelMock, "return_of_getHeader1");
		});
	}

	@Test()
	void updateResponseTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateResponse("");
		// Act Statement(s)
		String result = target.updateResponse("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateResponse("");
		});
	}

	@Test()
	void updateResponseWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).updateResponse("");
		// Act Statement(s)
		String result = target.updateResponse("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).updateResponse("");
		});
	}

	// Sapient generated method id: ${8cf86177-2960-3ee0-9be1-9dc3529990d7}, hash:
	// 7928D3E26A8757FC52D390C1CB7C9660
	@Test()
	void requestFeedbackTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).createFeedbackRequest("");
		// Act Statement(s)
		String result = target.requestFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).createFeedbackRequest("");
		});
	}

	@Test()
	void requestFeedbackWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).createFeedbackRequest("");
		// Act Statement(s)
		String result = target.requestFeedback("");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).createFeedbackRequest("");
		});
	}

	@Test()
	void getGrievancesByCreatedDateTest() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByCreatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByCreatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${18b97990-90b1-3d8d-a4c1-cef12be9bc57}, hash:
	// 3E15DAA476EEF73A0289776E75544FD7
	@Test()
	void getGrievancesByCreatedDateWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByCreatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByCreatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByCreatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${eafbf95c-ff4f-3081-897b-fc80540e62a5}, hash:
	// E4B3306C1EA6B4CEFE0FA407E9BA780D
	@Test()
	void getGrievancesByUpdatedDateTest() throws Exception {
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByUpdatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByUpdatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${4fb8220a-ef79-3ab4-85c6-be5d27793fc2}, hash:
	// 947A8D6C2D37A1E4B7255694C6F6B87C
	@Test()
	void getGrievancesByUpdatedDateWhenCaughtException() throws Exception {
		/*
		 * Branches:* (catch-exception (Exception)) : true** TODO: Help needed! This
		 * method is not unit testable!* Following variables could not be
		 * isolated/mocked: response* Suggestions:* You can pass them as constructor
		 * arguments or create a setter for them (avoid new operator)* or adjust the
		 * input/test parameter values manually to satisfy the requirements of the given
		 * test scenario.* The test code, including the assertion statements, has been
		 * successfully generated.
		 */
		// Arrange Statement(s)
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		doReturn("return_of_getHeader1").when(httpRequestMock).getHeader("Authorization");
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		FeedbackListRequestModel feedbackListRequestModelMock = mock(FeedbackListRequestModel.class,
				"getGrievancesByUpdatedDate_feedbackListRequestModel1");
		doReturn("A").when(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
				"return_of_getHeader1");
		// Act Statement(s)
		String result = target.getGrievancesByUpdatedDate(feedbackListRequestModelMock, httpRequestMock);
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"A\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(httpRequestMock).getHeader("Authorization");
			verify(feedbackServiceMock).getGrievancesByUpdatedDate(feedbackListRequestModelMock,
					"return_of_getHeader1");
		});
	}

	// Sapient generated method id: ${9f527abd-8937-394a-8b33-cff4018923b7}, hash:
	// A5EAFAE77C1EF099AC4E4AEDD101C48D
	@Test()
	void createFeedbackRequestTest() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).saveFeedbackRequest("A");
		// Act Statement(s)
		String result = target.createFeedbackRequest("A");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedbackRequest("A");
		});
	}

	@Test()
	void createFeedbackRequestWhenCaughtException() throws Exception {
		// Arrange Statement(s)
		target = new FeedbackController();
		autoCloseableMocks = MockitoAnnotations.openMocks(this);
		doReturn("B").when(feedbackServiceMock).saveFeedbackRequest("D");
		// Act Statement(s)
		String result = target.createFeedbackRequest("D");
		// Assert statement(s)
		assertAll("result", () -> {
			assertThat(result, equalTo(
					"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
			verify(feedbackServiceMock).saveFeedbackRequest("D");
		});
	}

	@Test()
	void getFeedbackLogsTest() throws Exception {
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackLog feedbackLogMock = mock(FeedbackLog.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackLogMock).when(inputMapperMock).fromJson("A", FeedbackLog.class);
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			doReturn("B").when(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			// Act Statement(s)
			String result = target.getFeedbackLogs("A");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("A", FeedbackLog.class);
				verify(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			});
		}
	}

	@Test()
	void getFeedbackLogsWhenCaughtException() throws Exception {

		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		FeedbackLog feedbackLogMock = mock(FeedbackLog.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			doReturn(feedbackLogMock).when(inputMapperMock).fromJson("D", FeedbackLog.class);
			target = new FeedbackController();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			doReturn("B").when(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			// Act Statement(s)
			String result = target.getFeedbackLogs("D");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result, equalTo(
						"{\"data\":{\"response\":\"B\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("D", FeedbackLog.class);
				verify(feedbackServiceMock).getFeedbackLogs(feedbackLogMock);
			});
		}
	}

	@Test()
	void feedbackRequestExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackRequests(any())).thenThrow(NotFoundException.class);

		String response = target.feedbackRequest(request);
		assertEquals(response, target.feedbackRequest(request));
	}

	@Test()
	void getFeedbackByPostExpTest() {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackRequests(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedback(request);
		assertEquals(response, target.getFeedback(request));
	}

	@Test()
	void createFeedbackExpTest() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.saveFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.createFeedback(request);
		assertEquals(response, target.createFeedback(request));
	}

	@Test()
	void feedbacksListExpTest() {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackRequests(any())).thenThrow(NotFoundException.class);

		String response = target.feedbacksList(request);
		assertEquals(response, target.feedbacksList(request));
	}

	@Test()
	void updateFeedbackExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.updateFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.updateFeedback(request);
		assertEquals(response, target.updateFeedback(request));
	}

	@Test()
	void updateFeedbackStatusExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.updateFeedbackStatus(any())).thenThrow(NotFoundException.class);

		String response = target.updateFeedbackStatus(request);
		assertEquals(response, target.updateFeedbackStatus(request));
	}

	@Test()
	void searchFeedbackExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.searchFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.searchFeedback(request);
		assertEquals(response, target.searchFeedback(request));
	}

	@Test()
	void searchFeedback1ExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.searchFeedback1(any())).thenThrow(NotFoundException.class);

		String response = target.searchFeedback1(request);
		assertEquals(response, target.searchFeedback1(request));
	}

	@Test()
	void getAllFeedbackByIdExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackRequestServiceMock.getAllFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.getAllFeedbackById(request);
		assertEquals(response, target.getAllFeedbackById(request));
	}

	@Test()
	void getFeedbackStatusTypesExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbackStatus(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackStatusTypes(request);
		assertEquals(response, target.getFeedbackStatusTypes(request));
	}

	@Test()
	void getEmailStatusExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getEmailStatus(any())).thenThrow(NotFoundException.class);

		String response = target.getEmailStatus(request);
		assertEquals(response, target.getEmailStatus(request));
	}

	@Test()
	void getFeedbackRequestByIdExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackRequestServiceMock.getAllFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackRequestById(request);
		assertTrue(response.contains("Failed with null"));
		// assertEquals(response, target.getFeedbackRequestById(request));
	}

	@Test()
	void getFeedbackResponseByIdExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackRequestServiceMock.getAllFeedback(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackResponseById(request);
		assertEquals(response, target.getFeedbackResponseById(request));
	}

	@Test()
	void getFeedbacksListExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getFeedbacksList(any(), any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbacksList(any(), any());
		assertEquals(response, target.getFeedbacksList(any(), any()));
	}

	@Test()
	void updateResponseExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.updateResponse(any())).thenThrow(NotFoundException.class);

		String response = target.updateResponse(any());
		assertEquals(response, target.updateResponse(any()));
	}

	@Test()
	void requestFeedbackExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.createFeedbackRequest(any())).thenThrow(NotFoundException.class);

		String response = target.requestFeedback(any());
		assertTrue(response.contains("Failed with null"));
//		assertEquals(response, target.requestFeedback(any()));
	}

	@Test()
	void getFeedbackSeverityExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackSeverityServiceMock.getActiveFeedbackSeverity(any()).toString())
				.thenThrow(NotFoundException.class);

		String response = target.getFeedbackSeverity(any());
		assertEquals(response, target.getFeedbackSeverity(any()));
	}

	@Test()
	void getFeedbackTypeExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackTypeServiceMock.getActiveFeedbackTypes(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackType(any());
		assertEquals(response, target.getFeedbackType(any()));
	}

	@Test()
	void getGrievancesByCreatedDateExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getGrievancesByCreatedDate(any(), any())).thenThrow(NotFoundException.class);

		String response = target.getGrievancesByCreatedDate(any(), any());
		assertEquals(response, target.getGrievancesByCreatedDate(any(), any()));
	}

	@Test()
	void getGrievancesByUpdatedDateExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.getGrievancesByUpdatedDate(any(), any())).thenThrow(NotFoundException.class);

		String response = target.getGrievancesByUpdatedDate(any(), any());

		assertTrue(response.contains("error"));
		// assertEquals(response, target.getGrievancesByUpdatedDate(any(), any()));
	}

	@Test()
	void createFeedbackRequestExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.saveFeedbackRequest(any())).thenThrow(NotFoundException.class);

		String response = target.createFeedbackRequest(any());
		assertEquals(response, target.createFeedbackRequest(any()));
	}

	@Test()
	void getFeedbackLogsExpTest() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(feedbackServiceMock.saveFeedbackRequest(any())).thenThrow(NotFoundException.class);

		String response = target.getFeedbackLogs(any());
		assertEquals(response, target.getFeedbackLogs(any()));
	}

	@Test
	void testGetAllFeedbackReturnsCorrectJson() {
		// Given
		FeedbackResponse mockFeedbackResponse = new FeedbackResponse();
		mockFeedbackResponse.setFeedbackID(1L);
		ArrayList<Object[]> mockedData = new ArrayList<>();
		mockedData.add(new Object[] { "Summary", 101, "Good", "John Doe", "Manager", 1, "SupSummary", null,
				"Detailed Feedback" });

		when(feedbackResponseServiceMock.getdataById(1L)).thenReturn(mockedData);

		// When
		String result = target.getAllfeedback(mockFeedbackResponse);

		// Expected JSON
		List<Map<String, Object>> expectedResList = new ArrayList<>();
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("ResponseSummary", "Summary");
		resMap.put("FeedbackRequestID", 101);
		resMap.put("Comments", "Good");
		resMap.put("AuthName", "John Doe");
		resMap.put("AuthDesignation", "Manager");
		resMap.put("FeedbackID", 1);
		resMap.put("FeedbackSupSummary", "SupSummary");
		resMap.put("Feedback", "Detailed Feedback");
		expectedResList.add(resMap);

		Gson gson = new GsonBuilder().create();
		String expectedJson = gson.toJson(expectedResList);

		// Then
		assertEquals(expectedJson, result);

		// Verify
		verify(feedbackResponseServiceMock, times(1)).getdataById(1L);
	}

	@Test
	void testGetFeedbackByPostExceptionPath() {
		Long feedbackID = 1L;

		// Simulate an exception when feedbackService.getFeedbackRequests is called
		when(feedbackServiceMock.getFeedbackRequests(anyLong())).thenThrow(new RuntimeException("Test Exception"));

		// Execute the method that you're testing
		String result = target.getFeedbackByPost(feedbackID);

		// Assert on the response
		assertTrue(result.contains("error")); // Adjust this assertion based on how your OutputResponse.toString() is
	}

}
