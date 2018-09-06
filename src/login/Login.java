package login;
import java.util.Scanner;

import exceptions.LoginException;

public class Login {

	private boolean correctPassword;
	private int playerNumb;

	private Scanner scanner = new Scanner(System.in);
	private Player player[] = {new Player("Raaid", "hello")
					,  new Player("Tony", "Only") };
	
	public void run()
	{
		boolean exit = false;
		int maxTurn1 = 0;
		int maxTurn2 = 0;
		int maxTurnAvg = 0;
		
		
		
		while (!exit) 
		{			
			try 
			{
				String inputTemp = "";
				System.out.println("Player One Login:");
				inputTemp = getDetails("TEMP");
				System.out.println("Player Two Login:");
				getDetails(inputTemp);
				exit = true;
			}
			catch (LoginException e) 
			{
				System.out.println(e.getMessage());
			} 
		}
	}
	
	private String getDetails(String inputTemp) throws LoginException
	{	
		String userNameInput;
		String passWordInput;
		System.out.println("Username: ");
			userNameInput = "";
			userNameInput = scanner.nextLine();
			if (userNameInput == inputTemp)
			{
				throw new LoginException("USER ALREADY LOGGED IN\n");
			}
			
			playerNumb = checkUserName(userNameInput);
			if (playerNumb == -1) 
			{
				throw new LoginException("USER DOES NOT EXIST\n");
			} 
			else
			{
				System.out.println("Password: ");
					passWordInput = scanner.nextLine();
					correctPassword = checkPassWord(playerNumb, passWordInput);
				
				if (correctPassword == true) 
				{
					return userNameInput;
				} 
				else
				{ 					
					throw new LoginException("INCORRECT PASSWORD\n");
				}
			} 		
	}
	
	
	
	
	private int checkUserName(String userNameInput)
	{
		String nameTemp;
		for(int i = 0; i < player.length; i++)
		{			
			nameTemp = player[i].getUserName();
			if (userNameInput.equals(nameTemp))
			{
				return i;
			}
		}
		return -1;
	}
	
	private boolean checkPassWord(int playerNumb, String passWordInput)
	{
		String passTemp;
		passTemp = player[playerNumb].getPassWord();
		if (passWordInput.equals(passTemp)  )
			{
				return true;
			}
		return false;
	}
	
}
