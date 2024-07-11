package com.iemr.common.service.callhandling;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.iemr.common.utils.exception.IEMRException;
import org.json.JSONException;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.data.callhandling.CallType;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.HashSet;

import org.mockito.MockedStatic;
import com.iemr.common.repository.callhandling.IEMRCalltypeRepositoryImplCustom;
import com.iemr.common.utils.mapper.InputMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Disabled;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@ExtendWith(MockitoExtension.class)
class CalltypeServiceImplTest {

	private final IEMRCalltypeRepositoryImplCustom iEMRCalltypeRepositoryImplCustomMock = mock(
			IEMRCalltypeRepositoryImplCustom.class, "iEMRCalltypeRepositoryImplCustom");

	private AutoCloseable autoCloseableMocks;

	@InjectMocks()
	private CalltypeServiceImpl target;

	@AfterEach()
	public void afterTest() throws Exception {
		if (autoCloseableMocks != null)
			autoCloseableMocks.close();
	}

	@Test()
	void getAllCalltypesWhenObjectIsNotNullAndObjectLengthGreaterThanOrEqualsTo8() throws IEMRException {
		/*
		 * Branches:* (provider.getIsInbound() != null) : true*
		 * (provider.getIsOutbound() != null) : true* (for-each(callTypesArray)) : true*
		 * (object != null) : true* (object.length >= 8) : true
		 */
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			CallType callType = new CallType();
			callType.setIsInbound(false);
			callType.setIsOutbound(false);
			callType.setProviderServiceMapID(0);
			doReturn(callType).when(inputMapperMock).fromJson("request1", CallType.class);
			target = new CalltypeServiceImpl();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			Object[] objectArray = new Object[] { "A", 1, "B", "C", false, false, false, false };
			Set<Object[]> objectSet = new HashSet<>();
			objectSet.add(objectArray);
			doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0, false, false);
			// Act Statement(s)
			List<CallType> result = target.getAllCalltypes("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result.size(), equalTo(1));
				assertThat(result.get(0), is(instanceOf(CallType.class)));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", CallType.class);
				verify(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0, false, false);
			});
		}
	}

	@Test()
	void getAllCalltypesWhenCallTypesArrayIsNotEmptyAndObjectIsNotNullAndObjectLengthGreaterThanOrEqualsTo8()
			throws IEMRException {
		/*
		 * Branches:* (provider.getIsInbound() != null) : true*
		 * (provider.getIsOutbound() != null) : false* (for-each(callTypesArray)) :
		 * true* (object != null) : true* (object.length >= 8) : true
		 */
		// Arrange Statement(s)
		InputMapper inputMapperMock = mock(InputMapper.class);
		try (MockedStatic<InputMapper> inputMapper = mockStatic(InputMapper.class)) {
			inputMapper.when(() -> InputMapper.gson()).thenReturn(inputMapperMock);
			CallType callType = new CallType();
			callType.setIsOutbound((Boolean) null);
			callType.setProviderServiceMapID(0);
			doReturn(callType).when(inputMapperMock).fromJson("request1", CallType.class);
			target = new CalltypeServiceImpl();
			autoCloseableMocks = MockitoAnnotations.openMocks(this);
			Object[] objectArray = new Object[] { "A", 1, "B", "C", false, false, false, false };
			Set<Object[]> objectSet = new HashSet<>();
			objectSet.add(objectArray);
			doReturn(objectSet).when(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0);
			// Act Statement(s)
			List<CallType> result = target.getAllCalltypes("request1");
			// Assert statement(s)
			assertAll("result", () -> {
				assertThat(result.size(), equalTo(1));
				assertThat(result.get(0), is(instanceOf(CallType.class)));
				inputMapper.verify(() -> InputMapper.gson(), atLeast(1));
				verify(inputMapperMock).fromJson("request1", CallType.class);
				verify(iEMRCalltypeRepositoryImplCustomMock).getCallTypes(0);
			});
		}
	}

}
