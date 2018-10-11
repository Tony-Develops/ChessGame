package game;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import exceptions.LoginException;
import game.SimplePlayer;

public class GameMenu {

	private Scanner scanner = new Scanner(System.in);
	private static Set<SimplePlayer> players = new HashSet<SimplePlayer>();
	boolean runMenu = true;

	public void menuSystem() throws LoginException {

		String temp = null;

		while (runMenu) {
			// Refactor this to one Sout later
			System.out.println("Chess-like Game:\n" + "-Register\n" + "-Login\n" + "-Display\n" + "Enter your choice:");
			if (scanner.hasNextLine()) {
				temp = scanner.nextLine();
			}

			if (temp.equalsIgnoreCase("register")) {
				playerRegister();
			} else if (temp.equalsIgnoreCase("login")) {
				playerLogin();
				runMenu = false;
			} else if (temp.equalsIgnoreCase("display")) {
				displayUsers();
			} else {
				System.out.println("Incorrect Input");
			}
		}

	}

	public void playerRegister() {
		String tempId, tempPass, tempName;
		Boolean isDup;

		do {
			System.out.println("Enter player Id:");
			tempId = scanner.nextLine();
			isDup = false;
			Iterator<SimplePlayer> iter = players.iterator();
			while (iter.hasNext()) {
				SimplePlayer player = iter.next();
				if (player.getplayerId() == tempId) {
					isDup = true;
					System.out.println("Id have been already choosed by another player, please try again!");
				}
			}
		} while (isDup);

		System.out.println("Enter your name:");
		tempName = scanner.nextLine();

		System.out.println("Enter your password:");
		tempPass = scanner.nextLine();
		
		SimplePlayer player = new SimplePlayer(tempId, tempName, tempPass);
		players.add(player);
		System.out.println("New player:" + player.getPlayerName() + " added");
		printPlayers();
	}
	
	public void printPlayers() {
		System.out.println("We have: "+players.size()+" in total!");
		Iterator<SimplePlayer> iter = players.iterator();
		while (iter.hasNext()) {
			SimplePlayer player = iter.next();
			System.out.println("PlayerID: "+player.getplayerId()+" ,Name: "+ player.getPlayerName());
		}	}
	
	

	public void displayUsers() throws LoginException {
		System.out.println("Users:");
		Iterator<SimplePlayer> iter = players.iterator();
		while (iter.hasNext()) {
			SimplePlayer player = iter.next();
			System.out.println(player.getPlayerName());
		}
		System.out.println("End of list");

	}

	public String playerLogin() throws LoginException {
		String inputID, playerID;
		String passwordInput;
		String correctPassword;

		System.out.println("PlayerID: ");
		inputID = null;
		while (inputID == null) {
			inputID = scanner.nextLine();
		}

		Iterator<SimplePlayer> iter = players.iterator();
		while (iter.hasNext()) {
			SimplePlayer player = iter.next();
			if (inputID.equals(player.getplayerId())) {
				playerID = player.getplayerId();

				System.out.println("Password: ");
				passwordInput = scanner.nextLine();
				correctPassword = getPlayer(playerID).getPassword();

				if (correctPassword.equals(passwordInput)) {
					// Have the access
					return player.getplayerId();

				} else {
					throw new LoginException("\nINCORRECT PASSWORD\n");
				}
			} else {
				throw new LoginException("\nUSER DOES NOT EXIST\n");
			}
		}
		return null;

	}

	public SimplePlayer getPlayer(String id) {
		Iterator<SimplePlayer> iter = players.iterator();
		while (iter.hasNext()) {
			SimplePlayer player = iter.next();
			if (player.getplayerId() == id) {
				return player;
			}
		}
		return null;
	}
	
	public void addPlayer(SimplePlayer player) {
		players.add(player);
	}
	
	public static Set<SimplePlayer> getAllPlayers() {
		return Collections.unmodifiableSet(players);
	}

}
