package com.capgemini.chess.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.chess.facade.UserFacade;
import com.capgemini.chess.service.to.UserProfileTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class UserRestServiceTest {

	public UserRestServiceTest() {
	}

	@Autowired
	private UserFacade userFacade;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		Mockito.reset(userFacade);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@ComponentScan("com.capgemini.chess")
	//@Configuration 
	static class RankServiceTestContextConfiguration {
	}
	
	@Test
	public void testShouldFindPlayerByLogin() throws Exception {

		// given:
		final UserProfileTO userProfileTO1 = new UserProfileTO();
		userProfileTO1.setId(1L);
		userProfileTO1.setLogin("login");
		userProfileTO1.setName("name");

		Mockito.when(userFacade.findPlayerByLogin(Mockito.anyString())).thenReturn(userProfileTO1);
		// when
		ResultActions response = this.mockMvc.perform(get("/rest/findLogin").param("login", "login")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("id").value((int)userProfileTO1.getId()))
				.andExpect(jsonPath("login").value(userProfileTO1.getLogin()))
				.andExpect(jsonPath("name").value(userProfileTO1.getName()));
	}

	@Test
	public void testShouldFindPlayerByName() throws Exception {

		// given:
		final UserProfileTO userProfileTO1 = new UserProfileTO();
		userProfileTO1.setId(1L);
		userProfileTO1.setLogin("login");
		userProfileTO1.setName("name");
		
		Mockito.when(userFacade.findPlayerByName(Mockito.anyString())).thenReturn(userProfileTO1);
		// when
		ResultActions response = this.mockMvc.perform(get("/rest/findName").param("name", "name")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("id").value((int)userProfileTO1.getId()))
				.andExpect(jsonPath("login").value(userProfileTO1.getLogin()))
				.andExpect(jsonPath("name").value(userProfileTO1.getName()));
	}

}
