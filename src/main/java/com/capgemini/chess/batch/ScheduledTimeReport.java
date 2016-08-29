package com.capgemini.chess.batch;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.chess.service.MatchService;
/**
 * batches executed in period
 * @SimpleDateFormat shows time stamp every 10sec
 * @arbitrate arbitrates unfinished matches and send result by punishing lazy player
 * @author DOLESIEJ
 *
 */
@Component
public class ScheduledTimeReport {
	@Autowired
	private MatchService matchService;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
/*
	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		System.out.println("The time is now " + dateFormat.format(new Date()));
	}
	
	@Scheduled(fixedRate = 10000)
	public void arbitrate() {
		for (MatchEntity gracz : matchService.arbitrateMatches(matchService.findAllMatchesNotFinished())) {
			if (gracz.getGameArbitration() != GameArbitration.NONE)
				System.out.println("Player "+gracz.getPlayer()+ " "+ gracz.getGameArbitration().name());
		}
	}
*/
}