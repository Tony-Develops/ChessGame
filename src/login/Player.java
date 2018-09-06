package login;

public class Player {


	private String userName;
	private String passWord;
	private boolean isLoggedIn;
	
	public Player(String userName, String passWord)
	{
		this.userName = userName;
		this.passWord = passWord;
	}
	


	public String getUserName()
	{
		return userName;
	}
	

	public String getPassWord() {
		
		return passWord;
	}

}
