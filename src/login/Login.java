package login;
import java.util.Scanner;

public class Login {

	private boolean correctPassword;
	private int continueCheck;
	private int playerNumb;
	private int turnNumb;
	private int maxTurn1;
	private int maxTurn2;
	private int maxTurnAvg;
	private String userNameInput;
	private String passWordInput;
	private String nameTemp;
	private String passTemp;
	private Scanner scanner = new Scanner(System.in);
	private Player player[] = {new Player("Raaid", "hello")
					,  new Player("Tony", "Only") };
	
	public void run()
	{
		getPlayerOne();		
		getPlayerTwo();
		
		maxTurnAvg = (maxTurn1 + maxTurn2) / 2;
		System.out.println("Amount of turns: " + maxTurnAvg);
	}
	
	private int getDetails(String string)
	{
		System.out.println(string);
		
			System.out.println("Username: ");
			userNameInput = "";
			userNameInput = scanner.nextLine();
			playerNumb = checkUserName();
			if (playerNumb == -1) {
				System.out.println("USER DOES NOT EXIST\n");
				return -1;
			} else {
				System.out.println("Password: ");
				passWordInput = scanner.nextLine();
				correctPassword = checkPassWord(playerNumb);
				if (correctPassword == true) {
					System.out.println("Amount of turns:");
					turnNumb = scanner.nextInt();
					return turnNumb;
				} else { 
					
					System.out.println("INCORRECT PASSWORD");
					return -1;
				}
			} 
			
		
		
		
		
	}
	
	public void getPlayerOne()
	{
		continueCheck = -1;
		while (continueCheck == -1)
		{
			maxTurn1 = getDetails("PLAYER ONE LOGIN\n");
			continueCheck = maxTurn1;
		}
	}
	public void getPlayerTwo()
	{
		continueCheck = -1;
		while (continueCheck == -1)
		{
			maxTurn2 = getDetails("PLAYER TWO LOGIN\n");
			continueCheck = maxTurn2;
		}
	}
	
	
	
	private int checkUserName()
	{
		
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
	
	private boolean checkPassWord(int playerNumb)
	{
		passTemp = player[playerNumb].getPassWord();
		if (passWordInput.equals(passTemp)  )
			{
				return true;
			}
		return false;
	}
	
}
