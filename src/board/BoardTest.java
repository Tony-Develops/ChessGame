package board;

import org.junit.Test;

import chessPieces.*;
import exceptions.*;
import tools.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private Board board;
	
	@Before
	public void setUp() throws BoardException
	{
		board = new Board(6,4);
	}
	
	//Board should throw exception when size of board is less than 6x4
	@Test(expected = BoardException.class)
	public void boardException() throws Throwable
	{
		board = new Board(1,1);		
	}
	
	//Exception should be thrown when user tries to place piece outside board
	@Test(expected = PlaceException.class)
	public void placeException() throws Throwable
	{
		board.place(new Bishop(new Position(9,9), Type.White));
	}
	//Exception should be thrown when user tries to move nothing
	@Test(expected = MovementException.class)
	public void movementException() throws Throwable
	{
		board.move(new Position(0,0), new Position(3,3), Type.White);		
	}
	
	//Exception should be thrown when user tries to move their opponent's piece
	@Test(expected = MovementException.class)
	public void movementException1() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.Black);		
	}
	
	//Exception should be thrown when user tries to move their piece in the wrong pattern
	@Test(expected = MovementException.class)
	public void movementException2() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(2,3), Type.Black);		
	}
	
	//Exception should be thrown when user tries to move their piece into their own piece
	@Test(expected = MovementException.class)
	public void movementException3() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(3,3), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.White);		
	}
	
	//Expect to have the same chess piece that gets killed
	@Test
	public void moveTest() throws Throwable
	{
		ChessPiece chessPieceReturn;
		ChessPiece chessPieceExpect = new Bishop(new Position(3,3), Type.Black);
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(chessPieceExpect);
		board.move(new Position(3,3), new Position(2,2), Type.Black);
		chessPieceReturn = board.move(new Position(0,0), new Position(2,2), Type.White);	
		assertEquals(chessPieceReturn, chessPieceExpect);
		
	}
	
	@Test
	public void display() throws Throwable
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
		board.displayBoard();
	}
	

}
