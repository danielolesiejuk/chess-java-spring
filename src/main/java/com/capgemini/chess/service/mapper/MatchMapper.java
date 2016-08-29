package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;


public class MatchMapper {
	
	
	
	public static MatchTO map(MatchEntity matchEntity) {
		if (matchEntity != null) {
			MatchTO matchTO = new MatchTO();
			matchTO.setId(matchEntity.getId());
			matchTO.setDate(matchEntity.getDate());
			matchTO.setGameArbitration(matchEntity.getGameArbitration());
			matchTO.setGameFinished(matchEntity.isGameFinished());
			matchTO.setOnMovePlayer(matchEntity.isOnMovePlayer());
			matchTO.setOpponent(matchEntity.getOpponent());
			matchTO.setPlayer(matchEntity.getPlayer());
			return matchTO;
		}
		return null;
	}

	public static MatchEntity map(MatchTO matchTO) {
		if (matchTO != null) {
			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setId(matchTO.getId());
			matchEntity.setDate(matchTO.getDate());
			matchEntity.setGameArbitration(matchTO.getGameArbitration());
			matchEntity.setGameFinished(matchTO.isGameFinished());
			matchEntity.setOnMovePlayer(matchTO.isOnMovePlayer());
			matchEntity.setOpponent(matchTO.getOpponent());
			matchEntity.setPlayer(matchTO.getPlayer());
			return matchEntity;
		}
		return null;
	}

	public static MatchEntity update(MatchEntity matchEntity, MatchTO matchTO) {
		if (matchTO != null && matchEntity != null) {
			matchEntity.setId(matchTO.getId());
			matchEntity.setDate(matchTO.getDate());
			matchEntity.setGameArbitration(matchTO.getGameArbitration());
			matchEntity.setGameFinished(matchTO.isGameFinished());
			matchEntity.setOnMovePlayer(matchTO.isOnMovePlayer());
			matchEntity.setOpponent(matchTO.getOpponent());
			matchEntity.setPlayer(matchTO.getPlayer());
		}
		return matchEntity;
	}

	public static List<MatchTO> map2TOs(List<MatchEntity> matchEntity) {
		return matchEntity.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

	public static List<MatchEntity> map2Entities(List<MatchTO> matchTOs) {
		return matchTOs.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

}
