package com.capgemini.chess.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dao.impl.UserDaoImpl;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDaoImpl userDao;
	
	 @ComponentScan("com.capgemini.chess")
	 @Configuration 
	 static class RankServiceTestContextConfiguration {
	 }
	 
	@Test
	public void testShouldFindByLogin()  {
		// given
		String login = "Opium";
		// when
		UserProfileTO result = userService.findPlayerByLogin(login);
		// then
		assertEquals(login, result.getLogin());
	}

	@Test
	public void testShouldFindByName() {
		// given
		String name = "Jan";
		// when
		UserProfileTO result = userService.findPlayerByName(name);
		// then
		assertEquals(name, result.getName());
	}
	
	@Test(expected = Exception.class)
	public void testShouldNotFindByLogin() {
		// given
		String login = "Koks";
		// when
		UserProfileTO result = userService.findPlayerByLogin(login);
		// then
		assertEquals(login, result.getLogin());
	}

	@Test (expected = Exception.class)
	public void testShouldNotFindByName() {
		// given
		String name = "Janko";
		// when
		UserProfileTO result = userService.findPlayerByName(name);
		// then
		assertEquals(null, result.getName());
	}
	
	@Test 
	public void testShouldSendChallengeToOpponent() {
		// given
		String opponent = "Jan";
		// when
		userService.sendChallengeToOpponent(userService.findPlayerByName(opponent));
		String result = userDao.getChallengedUsers().get(0).getName().toString();
		// then
		assertEquals(opponent, result);
	}
}


