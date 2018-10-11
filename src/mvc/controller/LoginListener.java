package mvc.controller;

import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.JOptionPane;

import game.GameMenu;
import game.SimplePlayer;
import mvc.view.MainFrame;

public class LoginListener extends MyActionListener  {
	private String playerID, playerPassword;
	private Collection<SimplePlayer> players = GameMenu.getAllPlayers();

	public LoginListener(GameMenu gameMenu, MainFrame mainFrame) {
		super(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			playerID = JOptionPane.showInputDialog("Please enter player ID: ");

			//User click cancel button
			if (playerID == null) {
				mainFrame.displayMessage("No player has logined");
				return;
			}
			
			// Check if the ID is unique
			else if (uniqueID(playerID)) {
				// Correct ID
//				mainFrame.displayMessage("Player with same ID already exists.");
				playerPassword = JOptionPane.showInputDialog("Enter your password: ");
				
				mainFrame.displayMessage(playerID + " has logined.");

				//User click cancel button
				if (playerPassword == null) {
					mainFrame.displayMessage("No player has logined");
					return;
				}
				return;
			}


		// Player click cancel or put in a invalidate value
		} catch (NumberFormatException exception) {
			if (playerPassword == null)
				mainFrame.displayMessage("Cancel sucessful.");
			else
				mainFrame.displayMessage("Invalid password");
		}
	}
	
	public boolean uniqueID(String id) {
		for (SimplePlayer player : players) {
			if (player.getplayerId().equals(id)) {
				return false;
			}
		}
		return true;
	}
}
