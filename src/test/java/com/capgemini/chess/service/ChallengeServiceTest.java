package com.capgemini.chess.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeServiceTest {

	@Autowired
	private ChallengeService challengeService;

	@Autowired
	private UserService userService;

	@Test
	@Transactional
	//@Rollback(false)
	public void testShouldSendChallengeToOpponent() {
		// given
		String challenger = "Opium";
		String challenged = "Fantomas";
		UserEntity challengerEntity = userService.findPlayerByLogin(challenger);
		UserEntity challengedEntity = userService.findPlayerByLogin(challenged);
		ChallengeEntity challenge = new ChallengeEntity();
		challenge.setChallenger(challengerEntity);
		challenge.setChallenged(challengedEntity);
		// when
		ChallengeEntity sentChallengeToOpponent = challengeService.sendChallengeToOpponent(challenge);
		String result = sentChallengeToOpponent.getChallenged().getLogin();
		// then
		assertEquals(challenged, result);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testShouldCancelChallenge() {
		// given
		ChallengeEntity challenge = challengeService.findChallenge(1L);
		int cnt_b4 = challengeService.findAllChallenges().size();
		// when
		challengeService.cancelChallenge(challenge);
		int result = challengeService.findAllChallenges().size();
		// then
		assertEquals(cnt_b4 - 1, result);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testShouldAcceptChallenge() {
		// given
		ChallengeEntity challenge = challengeService.findChallenge(1L);
		// when
		ChallengeEntity challengeEntity = challengeService.acceptChallenge(challenge);
		boolean result = challengeEntity.isAccepted(); 
		// then
		assertEquals(true, result);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testShouldRejectChallenge() {
		// given
		testShouldSendChallengeToOpponent();
		ChallengeEntity challenge = challengeService.findChallenge(1L);
		// when
		ChallengeEntity challengeEntity = challengeService.rejectChallenge(challenge);
		boolean result = challengeEntity.isAccepted(); 
		// then
		assertEquals(false, result);
	}
	
}
