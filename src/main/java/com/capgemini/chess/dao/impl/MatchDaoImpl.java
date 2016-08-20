package com.capgemini.chess.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.Match;
import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.enums.GameArbitration;

/**
 * implementation of MatchDao
 * 
 * @findAllMatchesNotFinished get list of matches during play
 * @save sends result of unfinished matches by arbitrate if player did move for
 *       some period
 * @author DOLESIEJ
 *
 */
@Repository
public class MatchDaoImpl implements MatchDao {

	private Set<Match> allMatches = new HashSet<Match>();
	private LocalDate now = LocalDate.now();
	private LocalDate yesterday = LocalDate.of(now.getDayOfMonth(), now.getMonth(), now.getDayOfMonth() - 1);

	public MatchDaoImpl() {
		addTestMatch();
	}

	private void addTestMatch() {
		allMatches.add(new Match("Romeo", "Wiliam", GameArbitration.NONE, false, true, now));
		allMatches.add(new Match("Opium", "Hanna", GameArbitration.NONE, false, false, now));
		allMatches.add(new Match("Odyseusz", "Jan", GameArbitration.NONE, true, true, now));
		allMatches.add(new Match("Awantura", "Edmund", GameArbitration.NONE, true, false, now));
		allMatches.add(new Match("Fantomas", "Zbigniew", GameArbitration.NONE, false, false, yesterday));
		allMatches.add(new Match("Zemsta", "Aleksander", GameArbitration.NONE, false, true, yesterday));
	}

	@Override
	public List<MatchEntity> findAllMatchesNotFinished() {
		List<MatchEntity> matchesToArbitrate = new ArrayList<>();
		long idx = 0L;
		for (Match match : allMatches) {
			if (!match.isGameFinished() && match.getGameArbitration() == GameArbitration.NONE) {
				matchesToArbitrate.add(new MatchEntity(idx, match));
				idx++;
			}
		}
		return matchesToArbitrate;
	}

	@Override
	public void save(List<MatchEntity> allArbitratedMatches) {
		for (MatchEntity matchArbitrated : allArbitratedMatches) {
			for (Match match : allMatches) {
				if (matchArbitrated.getMatch().getPlayer().equals(match.getPlayer()) 
				 && matchArbitrated.getMatch().getOponent().equals(match.getOponent())) {
					match.setGameArbitration(matchArbitrated.getMatch().getGameArbitration());
				}
			}
		}
	}

}
