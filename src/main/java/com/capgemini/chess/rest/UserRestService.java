package com.capgemini.chess.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.facade.UserFacade;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Controller
@ResponseBody //spring bind body to convert into http
public class UserRestService {

	@Autowired
	private UserFacade userFacade;

	public UserRestService() {
	}
	/**
	 * method implements search by login functionality
	 *
	 * @return TO's User Profile
	 */
	@RequestMapping(value = "/rest/findLogin", method = RequestMethod.GET)
	public UserProfileTO findPlayerByLogin(@RequestParam("login") String login) {
		return userFacade.findPlayerByLogin(login);
	}
	/**
	 * method implements search by name functionality
	 *
	 * @return TO's User Profile
	 */
	@RequestMapping(value = "/rest/findName", method = RequestMethod.GET)
	public UserProfileTO findPlayerByName(@RequestParam("name") String name) {
		return userFacade.findPlayerByName(name);
	}
	/**
	 * method implements sending requests to an opponent
	 * save opponent Profile to a request list 
	 * @return 
	 */
	@RequestMapping(value = "/rest/sendChallenge", method = RequestMethod.POST)
	public ChallengeTO sendChallengeToOpponent(@RequestBody ChallengeEntity challenge) {
		return userFacade.sendChallengeToOpponent(challenge);
	}
	/**
	 * method implements delete user by login functionality
	 *
	 * @return TO's User Profile
	 */
	@RequestMapping(value = "/rest/deleteLogin", method = RequestMethod.DELETE)
	public void deletePlayerByLogin(@RequestParam("loginId") Long loginId) {
		userFacade.deletePlayerByLogin(loginId);
	}

}
