package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dataaccess.entities.MatchEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MatchServiceTest {

	@Autowired
	MatchService matchService;

	
	 @ComponentScan("com.capgemini.chess")
	 @Configuration 
	 static class RankServiceTestContextConfiguration {
	 }
	 
	@Test
	public void testShouldArbitrate() {
		// given
		String login = "Opium";
		// when
		List<MatchEntity> result = matchService.findAllMatchesNotFinished();
		// then
		assertEquals(login, result);
	}
}
