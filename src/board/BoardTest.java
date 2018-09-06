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
		board = new Board(7,7);
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
	

}
