package client;

import game.ChessGame;
import login.GameMenu;
import mvc.controller.MainFrame;
import board.Board;
import exceptions.BoardException;

public class Driver {

	
	public static void main(String[] args) throws Throwable
	{       
		MainFrame frame = new MainFrame();
		GameMenu login = new GameMenu();
		login.menuSystem();
		
		ChessGame chessGame = new ChessGame();
		chessGame.PlayGame();
	}

}
