package board;

import org.junit.Test;

import chessPieces.*;
import exceptions.*;
import tools.*;

import static org.junit.Assert.*;

import org.junit.After;
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
	public void boardExceptionSizeLessThanLimit() throws Throwable
	{
		board = new Board(1,1);		
	}
	
	//Exception should be thrown when user tries to place piece outside board
	@Test(expected = PlaceException.class)
	public void placeOutsideOfBoardException() throws Throwable
	{
		board.place(new Bishop(new Position(9,9), Type.White));
	}
	//Exception should be thrown when user tries to move nothing
	@Test(expected = MovementException.class)
	public void movingNothingException() throws Throwable
	{
		board.move(new Position(0,0), new Position(3,3), Type.White);		
	}
	
	//Exception should be thrown when user tries to move their opponent's piece
	@Test(expected = MovementException.class)
	public void movingOpponentPieceException() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.Black);		
	}
	
	//Exception should be thrown when user tries to move their piece in the wrong pattern
	@Test(expected = MovementException.class)
	public void bishopIncorrectPatternException() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(2,3), Type.Black);		
	}
	
	@Test(expected = MovementException.class)
	public void bypassingBishopFails() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(1,1), Type.White));
		board.move(new Position(0,0), new Position(2,2), Type.White);	
	}
	
	@Test(expected = MovementException.class)
	public void bishopMovingMoreThanTwoFails() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.White);	
	}
	
	@Test
	public void bishopMovingTwoSuceeds() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(2,2), Type.White);	
	}
	
	@Test(expected = MovementException.class)
	public void rookIncorrectPatternException() throws Throwable
	{
		board.place(new Rook(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.Black);		
	}
	
	@Test(expected = MovementException.class)
	public void bypassingRookFails() throws Throwable
	{
		board.place(new Rook(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(0,1), Type.White));
		board.move(new Position(0,0), new Position(0,1), Type.White);	
	}
	
	@Test(expected = MovementException.class)
	public void rookMovingMoreThanTwoFails() throws Throwable
	{
		board.place(new Rook(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(0,3), Type.White);	
	}
	
	@Test
	public void rookMovingTwoSuceeds() throws Throwable
	{
		board.place(new Rook(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(0,2), Type.White);	
	}
	
	@Test(expected = MovementException.class)
	public void knightIncorrectPatternException() throws Throwable
	{
		board.place(new Knight(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(1,1), Type.Black);		
	}
	
	@Test
	public void bypassingKnightSuceeds() throws Throwable
	{
		board.place(new Knight(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(1,0), Type.White));
		board.move(new Position(0,0), new Position(2,1),Type.White);	
	}
	
	@Test
	public void knightMovingSuceeds() throws Throwable
	{
		board.place(new Knight(new Position(0,0), Type.White));
		board.move(new Position(0,0), new Position(2,1), Type.White);	
	}
	//Exception should be thrown when user tries to move their piece into their own piece
	@Test(expected = MovementException.class)
	public void movingIntoOwnPieceException() throws Throwable
	{
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(new Bishop(new Position(3,3), Type.White));
		board.move(new Position(0,0), new Position(3,3), Type.White);		
	}
	
	//Expect to have the same chess piece that gets killed
	@Test
	public void deadBishopExpected() throws Throwable
	{
		ChessPiece chessPieceReturn;
		ChessPiece chessPieceExpect = new Bishop(new Position(3,3), Type.Black);
		board.place(new Bishop(new Position(0,0), Type.White));
		board.place(chessPieceExpect);
		board.displayBoard();
		board.move(new Position(3,3), new Position(2,2), Type.Black);
		board.displayBoard();
		chessPieceReturn = board.move(new Position(0,0), new Position(2,2), Type.White);	
		assertEquals(chessPieceReturn, chessPieceExpect);
	}
	
	@Test
	public void testingSetUp() throws Throwable
	{
		board.boardInit();
	}
	
	@After
	public void testingDisplay() throws Throwable
	{
		board.displayBoard();
		System.out.println("---------------------");
	}
	

}
