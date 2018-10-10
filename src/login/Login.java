package login;
import java.util.Scanner;

import exceptions.LoginException;

public class Login {

	private Scanner scanner = new Scanner(System.in);
	private Player[] player;
	boolean runMenu = true;
	
	public void menuSystem() throws LoginException
	{				
		
		player = playerInit(5);		
		String temp = null;
		
		while (runMenu)
		{
			//Refactor this to one Sout later
			System.out.println("Chess-like Game:\n"
								+ "-Register\n"
								+ "-Login\n"
								+ "-Display\n"
								+ "Enter your choice:");
			if (scanner.hasNextLine())
			{
				temp = scanner.nextLine();				
			}
			
			if (temp.equalsIgnoreCase("register"))
			{
				playerRegister();
			}
			else if (temp.equalsIgnoreCase("login"))
			{
				playerLogin();
				runMenu = false;
			}
			else if (temp.equalsIgnoreCase("display"))
			{
				displayUsers();
			}
			else
			{
				System.out.println("Incorrect Input");
			}
		}
		
		
	}	
	
	public Player[] playerInit(int numb)
	{
		Player[] player = new Player[numb];

		for (int i = 0; i < numb; i++)
		{
			player[i] = new Player("null", "null");
		}
		
		return player;
	}
	
	public void playerRegister()
	{
		String tempUser;
		String tempPass;
		for (int i = 0; i < player.length; i++)
		{
			if (player[i].getUserName().equals("null"))
			{
				System.out.println("Enter new account:");
				tempUser = scanner.nextLine();
				
				System.out.println("Enter new password:");
				tempPass = scanner.nextLine();
				player[i] = new Player(tempUser, tempPass);
				break;
			}
		}
	}
	
	public void displayUsers() throws LoginException
	{
		System.out.println("Users:");
		for (int i = 0; i <= player.length; i++)
		{
			if (player[i].getUserName().equals("null"))
			{
				break;
			}
			System.out.println(player[i].getUserName());			
		}
		System.out.println("End of list");
	}
	
	public void playerLogin() throws LoginException
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
		int playerNumb;
		boolean correctPassword;
		
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
