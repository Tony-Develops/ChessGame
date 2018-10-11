package game;

public class SimplePlayer {

	private String playerId;
	private String playerName;
	private String playerPassword;
	
	public SimplePlayer(String playerId, String playerName, String playerPassword) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerPassword = playerPassword;
	}
	
	public String getplayerId() {
		return playerId;
	}
	
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPassword() {
		return playerPassword;
	}

	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}



}

