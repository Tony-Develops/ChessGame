package mvc.controller;

import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.JOptionPane;

import game.GameMenu;
import game.SimplePlayer;
import mvc.view.MainFrame;

public class RegisterListener extends MyActionListener {
	private String playerID, playerName, playerPassword;
	private Collection<SimplePlayer> players = GameMenu.getAllPlayers();

	public RegisterListener(GameMenu gameMenu, MainFrame frame) {
		super(frame);
	}

	public void actionPerformed(ActionEvent event) {
		try {
			playerID = JOptionPane.showInputDialog("Please enter player ID: ");

			//User click cancel button
			if (playerID == null) {
				mainFrame.displayMessage("No player has been registered");
				return;
			}
			
			// Check if the ID is unique
			else if (!uniqueID(playerID)) {
				mainFrame.displayMessage("Player with same ID already exists.");
				return;
			}
			playerName = JOptionPane.showInputDialog("Please enter your name: ");

			//User click cancel button
			if (playerName == null) {
				mainFrame.displayMessage("No player has been added");
				return;
			}
			playerPassword = JOptionPane.showInputDialog("Enter your password: ");

			// Create a new player and then add player to the the game
			SimplePlayer addPlayer = new SimplePlayer(playerID, playerName, playerPassword);
//			gameMenu.addPlayer(addPlayer);

			// Updates status bar
//			statusBar.setMiddleLabel(String.format("Added player \" %s \"", playerName));
//			statusBar.setRightLabel(addPlayer.toString());

			mainFrame.displayMessage(playerName + " has been added to the game.");

		// Player click cancel or put in a invalidate value
		} catch (NumberFormatException e) {
			if (playerPassword == null)
				mainFrame.displayMessage("Cancel sucessful.");
			else
				mainFrame.displayMessage("Invalid password");
		}
	}

	// Check for unique ID method
	public boolean uniqueID(String id) {
		for (SimplePlayer player : players) {
			if (player.getplayerId().equals(id)) {
				return false;
			}
		}
		return true;
	}
}
