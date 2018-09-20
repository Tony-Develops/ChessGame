package testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import exceptions.LoginException;
import login.Login;

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
		System.out.println("\nCorrect password check for user Raaid");
		String check = login.getDetails("TEMP");
		assertEquals(check,"Raaid");
	}
	
	@Test
	public void checkCorrectLoginForTony() throws LoginException 
	{
		System.out.println("\nCorrect password check for user Tony");
		String check = login.getDetails("TEMP");
		assertEquals(check,"Tony");
	}

	@Test (expected = LoginException.class)
	public void checkIncorrectPasswordForRaaid() throws LoginException
	{
		System.out.println("\nIncorrect password check for user Raaid");
		login.getDetails("TEMP");
	}
	
	@Test (expected = LoginException.class)
	public void checkClashingUserName() throws LoginException
	{
		System.out.println("\nCheck for clashing usernames");
		System.out.println("\nFirst player logged in as Raaid");
		login.getDetails("Raaid");
	}
	
	
}
