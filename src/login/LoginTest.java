package login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ChessPieceException;
import exceptions.LoginException;

public class LoginTest {

	private Login login;
	
	@Before
	public void setUp() throws LoginException 
	{
		login = new Login();
	}

	@Test 
	public void checkCorrectLoginForRaaid() throws LoginException 
	{
		String check = login.getDetails("TEMP");
		assertEquals(check,"Raaid");
	}
	
	@Test
	public void checkCorrectLoginForTony() throws LoginException 
	{
		String check = login.getDetails("TEMP");
		assertEquals(check,"Tony");
	}

	@Test (expected = LoginException.class)
	public void checkIncorrectPasswordForRaaid() throws LoginException
	{
		String check = login.getDetails("TEMP");
	}
	
	@Test (expected = LoginException.class)
	public void checkClashingUserName() throws LoginException
	{
		System.out.println("Player Two Login");
		login.getDetails("Raaid");
	}
	
	
}
