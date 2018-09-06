package main;

import login.Login;
import board.Board;
import exceptions.BoardException;

public class Driver {

	
	public static void main(String[] args) throws BoardException 
	{	
		
		Login login = new Login();
		login.run();
		
		Board board = new Board();
		board.displayBoard();

	}

}
