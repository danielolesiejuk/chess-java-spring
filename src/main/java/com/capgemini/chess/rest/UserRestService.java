package com.capgemini.chess.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.UserProfileTO;

@Controller
@ResponseBody //spring bind body to convert into http
public class UserRestService {

	@Autowired
	private UserService userService;

	public UserRestService() {
	}
	/**
	 * method implements search by login functionality
	 *
	 * @return TO's User Profile
	 */
	@RequestMapping(value = "/rest/findLogin", method = RequestMethod.GET)
	public UserProfileTO findPlayerByLogin(@RequestParam("login") String login) {
		return userService.findPlayerByLogin(login);
	}
	/**
	 * method implements search by name functionality
	 *
	 * @return TO's User Profile
	 */
	@RequestMapping(value = "/rest/findName", method = RequestMethod.GET)
	public UserProfileTO findPlayerByName(@RequestParam("name") String name) {
		return userService.findPlayerByName(name);
	}
	/**
	 * method implements sending requests to an opponent
	 * save opponent Profile to a request list 
	 * @return 
	 */
	@RequestMapping(value = "/rest/sendChallenge", method = RequestMethod.POST)
	public UserProfileTO sendChallengeToOpponent(@RequestBody UserProfileTO opponent) {
		return userService.sendChallengeToOpponent(opponent);
	}
	/**
	 * method implements delete user by login functionality
	 *
	 * @return TO's User Profile
	 */
	@RequestMapping(value = "/rest/deleteLogin", method = RequestMethod.DELETE)
	public UserProfileTO deletePlayerByLogin(@RequestParam("login") String login) {
		return userService.deletePlayerByLogin(login);
	}

}
