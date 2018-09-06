package game;

import board.Board;
import exceptions.BoardException;
import exceptions.PlaceException;
import chessPieces.*;
import tools.*;

public class ChessGame {
	
	private Board board;
	final int BOARD_SIZE_X = 6;
	final int BOARD_SIZE_Y = 4;
	
	public ChessGame()
	{
		try
		{
			board = new Board(BOARD_SIZE_X, BOARD_SIZE_Y);
			gameInit();
		} 
		catch (BoardException | PlaceException e) 
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void PlayGame()
	{
		board.displayBoard();
	}

	
	private void gameInit() throws PlaceException
	{
		board.place(new Rook(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(1,0), Type.White));
		board.place(new Knight(new Position(2,0), Type.White));
		board.place(new Knight(new Position(3,0), Type.White));
		board.place(new Bishop(new Position(4,0), Type.White));
		board.place(new Rook(new Position(5,0), Type.White));
		
		board.place(new Rook(new Position(0,3), Type.Black));
		board.place(new Bishop(new Position(1,3), Type.Black));
		board.place(new Knight(new Position(2,3), Type.Black));
		board.place(new Knight(new Position(3,3), Type.Black));
		board.place(new Bishop(new Position(4,3), Type.Black));
		board.place(new Rook(new Position(5,3), Type.Black));
	}
}
