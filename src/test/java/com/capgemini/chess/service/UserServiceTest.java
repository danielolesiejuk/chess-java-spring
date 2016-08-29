package com.capgemini.chess.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.dataaccess.entities.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	@Transactional
	//@Rollback(false)
	public void testShouldFindByLogin()  {
		// given
		String login = "Opium";
		// when
		UserEntity result = userService.findPlayerByLogin(login);
		// then
		assertEquals(login, result.getLogin());
	}

	@Test
	@Transactional
	//@Rollback(false)
	public void testShouldFindByName() {
		// given
		String name = "Jan";
		// when
		UserEntity result = userService.findPlayerByName(name);
		// then
		assertEquals(name, result.getName());
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	@Transactional
	//@Rollback(false)
	public void testShouldNotFindByLogin() {
		// given
		String login = "Koks";
		// when
		UserEntity result = userService.findPlayerByLogin(login);
		// then
		assertNotEquals(login, result.getLogin());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	@Transactional
	//@Rollback(false)
	public void testShouldNotFindByName() {
		// given
		String name = "Janko";
		// when
		UserEntity result = userService.findPlayerByName(name);
		// then
		assertNotEquals(name, result.getName());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testShouldAddUser() {
		// given
		final UserEntity player = new UserEntity();
		player.setLogin("Danelo");
		player.setName("Olesiejuk");
		
		int cnt_b4 = userService.findAllPlayers().size();
		
		// when
		UserEntity userEntity = userService.addPlayer(player);
		List<UserEntity> usersEntity = userService.findAllPlayers();
		// then
		assertNotNull(userEntity);
		assertEquals(cnt_b4+1, usersEntity.size());
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testShouldEditUser() {
		// given
		String login = "Danelo";
		String editedName = "EditedName";
		UserEntity player = new UserEntity();
		player = userService.findPlayerByLogin(login);
		player.setName(editedName);

		// when
		UserEntity userEntity = userService.editPlayer(player);
		List<UserEntity> usersEntity = userService.findAllPlayers();
		// then
		assertNotNull(userEntity);
		assertEquals(editedName, usersEntity.stream().filter(u->u.getName().equals(editedName)).findAny().orElse(null).getName());
	}
	
}


