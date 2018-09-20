package login;
import java.util.Scanner;

import exceptions.LoginException;

public class Login {

	private boolean correctPassword;
	private int playerNumb;

	private Scanner scanner = new Scanner(System.in);
	private Player player[] = {new Player("Raaid", "hello")
					,  new Player("Tony", "Only") };
	
	public void playerLogin()
	{
		String inputTemp = "";		
		
		for(int i = 0; i < 2; i++)
        {
            try
            {
                System.out.println("Player " + (i + 1) + " login:");
                inputTemp = getDetails(inputTemp);
            }
            catch(LoginException e)
            {
            	System.out.println(e.getMessage());
                i--;
            }
        }
	}
	
	public String getDetails(String inputTemp) throws LoginException
	{	
		String userNameInput;
		String passWordInput;
		
		System.out.println("Username: ");
			userNameInput = "";
			userNameInput = scanner.nextLine();
			if (userNameInput.equals(inputTemp))
			{
				throw new LoginException("\nUSER ALREADY LOGGED IN\n");
			}
			
			playerNumb = checkUserName(userNameInput);
			if (playerNumb == -1) 
			{
				throw new LoginException("\nUSER DOES NOT EXIST\n");
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
					throw new LoginException("\nINCORRECT PASSWORD\n");
				}
			} 	
			
			
	}
	
	
	
	
	protected int checkUserName(String userNameInput)
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
	
	protected boolean checkPassWord(int playerNumb, String passWordInput)
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
