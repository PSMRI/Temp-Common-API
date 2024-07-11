package com.iemr.common.controller.everwellTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.catalina.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.catalina.users.MemoryUserDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.common.model.user.LoginRequestModelEverwell;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class EverwellControllerTest {
	@Mock
	private EverwellController everwellController;

	@Test
	void testAddSupportAction() throws Exception {
		// Arrange
		MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
				.post("/everwell/addSupportAction/{id}", 1L).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletRequestBuilder requestBuilder = contentTypeResult
				.content((new ObjectMapper()).writeValueAsString("foo"));

		// Act
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(everwellController).build()
				.perform(requestBuilder);

		// Assert
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testAddSupportAction2() throws Exception {
		// Arrange
		User user = mock(User.class);
		when(user.getName()).thenReturn("Name");
		MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/everwell/addSupportAction/{id}", 1L);
		postResult.principal(new UserDatabaseRealm.UserDatabasePrincipal(user, new MemoryUserDatabase()));
		MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);
		MockHttpServletRequestBuilder requestBuilder = contentTypeResult
				.content((new ObjectMapper()).writeValueAsString("foo"));

		// Act
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(everwellController).build()
				.perform(requestBuilder);

		// Assert
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testEditManualDoses() throws Exception {
		// Arrange
		MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
				.post("/everwell/editManualDoses/{id}", 1L).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletRequestBuilder requestBuilder = contentTypeResult
				.content((new ObjectMapper()).writeValueAsString("foo"));

		// Act
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(everwellController).build()
				.perform(requestBuilder);

		// Assert
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testEditManualDoses2() throws Exception {
		// Arrange
		User user = mock(User.class);
		when(user.getName()).thenReturn("Name");
		MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/everwell/editManualDoses/{id}", 1L);
		postResult.principal(new UserDatabaseRealm.UserDatabasePrincipal(user, new MemoryUserDatabase()));
		MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);
		MockHttpServletRequestBuilder requestBuilder = contentTypeResult
				.content((new ObjectMapper()).writeValueAsString("foo"));

		// Act
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(everwellController).build()
				.perform(requestBuilder);

		// Assert
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testEverwellLogin() throws Exception {
		// Arrange
		LoginRequestModelEverwell loginRequestModelEverwell = new LoginRequestModelEverwell();
		loginRequestModelEverwell.setEverwellAuthKey("Everwell Auth Key");
		loginRequestModelEverwell.setEverwellPassword("iloveyou");
		loginRequestModelEverwell.setEverwellUserName("janedoe");
		String content = (new ObjectMapper()).writeValueAsString(loginRequestModelEverwell);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/everwell/login")
				.contentType(MediaType.APPLICATION_JSON).content(content);

		// Act
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(everwellController).build()
				.perform(requestBuilder);

		// Assert
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testGetdata() throws Exception {
		// Arrange
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/everwell/getjson");

		// Act
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(everwellController).build()
				.perform(requestBuilder);

		// Assert
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
