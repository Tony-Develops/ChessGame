package main;

import game.ChessGame;
import login.Login;
import board.Board;
import exceptions.BoardException;

public class Driver {

	
	public static void main(String[] args) throws Throwable
	{
		Login login = new Login();
		login.menuSystem();
		
		ChessGame chessGame = new ChessGame();
		chessGame.PlayGame();
	}

}
