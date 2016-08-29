package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.enums.GameArbitration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchServiceTest {

	@Autowired
	MatchService matchService;
	@Autowired
	UserService userService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testShouldFindAllNotFinishedMatches() {
		// given
		// when
		List<MatchEntity> result = matchService.findAllMatchesNotFinished();
		// then
		assertEquals(9, result.size());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testShouldFindAllMatches() {
		// given
		// when
		List<MatchEntity> result = matchService.findAllMatches();
		// then
		assertEquals(15, result.size());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testShouldFindMatchById() {
		// given
		Long matchId = 3L; 
		// when
		MatchEntity result = matchService.findMatchById(matchId);
		// then
		assertEquals(matchId, result.getId());
	}
	
	@Test
	@Transactional
	//@Rollback(false)
	public void testShouldArbitrate() {
		// given
		String login = "Romeo";
		// when
		List<MatchEntity> matches = matchService.findAllMatchesNotFinished();
		List<MatchEntity> result = matchService.arbitrateMatches(matches);
		// then
		assertEquals(login, result.get(0).getPlayer().getLogin());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testShloudAddMatch() {
		// given
		final MatchEntity match = new MatchEntity();
		String playerLogin = "Odyseusz";
		String opponentLogin = "Fantomas";
		UserEntity player = userService.findPlayerByLogin(playerLogin);
		UserEntity opponent = userService.findPlayerByLogin(opponentLogin);
		Date date = new Date(System.currentTimeMillis());
		match.setPlayer(player);
		match.setOpponent(opponent);
		match.setGameFinished(true);
		match.setDate(date);
		match.setGameArbitration(GameArbitration.DRAW);
		
		int cnt_b4 = matchService.findAllMatches().size();
		
		// when
		MatchEntity matchEntity = matchService.addMatch(match);
		List<MatchEntity> matchesEntity = matchService.findAllMatches();
		// then
		assertNotNull(matchEntity);
		assertEquals(cnt_b4+1, matchesEntity.size());
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testShloudUpdateMatch() {
		// given
		MatchEntity match = new MatchEntity();
		match = matchService.findMatchById(1L);
		match.setGameFinished(true);
		match.setGameArbitration(GameArbitration.LOST);
		
		// when
		MatchEntity matchEntity = matchService.updateMatch(match);
		List<MatchEntity> matchesEntity = matchService.findAllMatches();
		
		// then
		assertNotNull(matchEntity);
		assertEquals(GameArbitration.LOST, matchesEntity.get(0).getGameArbitration());
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testShloudDeleteMatchById() {
		// given
		MatchEntity match = new MatchEntity();
		match = matchService.findMatchById(2L);
		
		// when
		int cnt_b4 = matchService.findAllMatches().size();
		matchService.deleteMatchById(match.getId());
		List<MatchEntity> matchesEntity = matchService.findAllMatches();
		
		// then
		assertNotNull(matchesEntity);
		assertEquals(cnt_b4 - 1, matchesEntity.size());
	}
}
