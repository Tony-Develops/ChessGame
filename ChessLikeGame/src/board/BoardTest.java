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
	
	@Test(expected = ChessPieceException.class)
	public void chessPieceException() throws Throwable
	{
		board.move(new Position(0,0), new Position(3,3), Type.White);		
	}

	@Test(expected = MovementException.class)
	public void movementException1() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.Black);		
	}
	
	@Test(expected = MovementException.class)
	public void movementException2() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(3,3), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.White);		
	}
	
	@Test
	public void moveTest() throws Throwable
	{
		ChessPiece chessPieceReturn;
		ChessPiece chessPieceExpect = new Bishop(new Position(3,3), Type.Black);
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(chessPieceExpect);
		chessPieceReturn = board.move(new Position(0,0), new Position(3,3), Type.White);	
		assertEquals(chessPieceReturn, chessPieceExpect);
		
	}
	

}
