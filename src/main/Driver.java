package main;

import game.ChessGame;
import login.Login;
import board.Board;
import exceptions.BoardException;

public class Driver {

	
	public static void main(String[] args) throws Throwable
	{
		Login login = new Login();
<<<<<<< HEAD
		login.run();
		
		Board

=======
		login.playerLogin();
		
		ChessGame chessGame = new ChessGame();
		chessGame.PlayGame();
>>>>>>> c95f29eec0d3170de5f6861ba54a5d64bd7d57f4
	}

}
