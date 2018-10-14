package testcases;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


import exceptions.LoginException;
import mvc.model.game.GameMenu;
import mvc.model.game.SimplePlayer;

public class LoginTest {

	private GameMenu gameMenu;
	
	@Before
	public void setUp() throws LoginException 
	{
		gameMenu = new GameMenu();
		Set<SimplePlayer> players = new HashSet<SimplePlayer>();
		SimplePlayer player = new SimplePlayer("Raaid", "Raaid", "123");
		players.add(player);
	}

	@Test 
	public void checkCorrectLoginForRaaid() throws LoginException 
	{
		System.out.println("\nCorrect password check for user Raaid");
		String check = gameMenu.playerLogin();
		assertEquals(check,"Raaid");
	}
	

	@Test (expected = LoginException.class)
	public void checkIncorrectPasswordForRaaid() throws LoginException
	{
		System.out.println("\nIncorrect password check for user Raaid");
		gameMenu.playerLogin();
	}
	

	
}
