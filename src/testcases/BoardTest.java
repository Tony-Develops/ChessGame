package testcases;

import org.junit.Test;

import board.Board;
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
	
	//Exception should be thrown when user tries to placePiece piece outside board
	@Test(expected = PlaceException.class)
	public void placePieceOutsideOfBoardException() throws Throwable
	{
		board.placePiece(new Bishop(new Position(9,9), Colour.White));
	}
	//Exception should be thrown when user tries to movePiece nothing
	@Test(expected = MovementException.class)
	public void movingNothingException() throws Throwable
	{
		board.movePiece(new Position(0,0), new Position(3,3), Colour.White);		
	}
	
	//Exception should be thrown when user tries to movePiece their opponent's piece
	@Test(expected = MovementException.class)
	public void movingOpponentPieceException() throws Throwable
	{
		board.placePiece(new Bishop(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(3,3), Colour.Black);		
	}
	
	//Exception should be thrown when user tries to movePiece their piece in the wrong pattern
	@Test(expected = MovementException.class)
	public void bishopIncorrectPatternException() throws Throwable
	{
		board.placePiece(new Bishop(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(2,3), Colour.Black);		
	}
	
	@Test(expected = MovementException.class)
	public void bypassingBishopFails() throws Throwable
	{
		board.placePiece(new Bishop(new Position(0,0), Colour.White));
		board.placePiece(new Bishop(new Position(1,1), Colour.White));
		board.movePiece(new Position(0,0), new Position(2,2), Colour.White);	
	}
	
	@Test(expected = MovementException.class)
	public void bishopMovingMoreThanTwoFails() throws Throwable
	{
		board.placePiece(new Bishop(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(3,3), Colour.White);	
	}
	
	@Test
	public void bishopMovingTwoSuceeds() throws Throwable
	{
		board.placePiece(new Bishop(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(2,2), Colour.White);	
	}
	
	@Test(expected = MovementException.class)
	public void rookIncorrectPatternException() throws Throwable
	{
		board.placePiece(new Rook(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(3,3), Colour.Black);		
	}
	
	@Test(expected = MovementException.class)
	public void bypassingRookFails() throws Throwable
	{
		board.placePiece(new Rook(new Position(0,0), Colour.White));
		board.placePiece(new Bishop(new Position(0,1), Colour.White));
		board.movePiece(new Position(0,0), new Position(0,1), Colour.White);	
	}
	
	@Test(expected = MovementException.class)
	public void rookMovingMoreThanTwoFails() throws Throwable
	{
		board.placePiece(new Rook(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(0,3), Colour.White);	
	}
	
	@Test
	public void rookMovingTwoSuceeds() throws Throwable
	{
		board.placePiece(new Rook(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(0,2), Colour.White);	
	}
	
	@Test(expected = MovementException.class)
	public void knightIncorrectPatternException() throws Throwable
	{
		board.placePiece(new Knight(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(1,1), Colour.Black);		
	}
	
	@Test
	public void bypassingKnightSuceeds() throws Throwable
	{
		board.placePiece(new Knight(new Position(0,0), Colour.White));
		board.placePiece(new Bishop(new Position(1,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(2,1),Colour.White);	
	}
	
	@Test
	public void knightMovingSuceeds() throws Throwable
	{
		board.placePiece(new Knight(new Position(0,0), Colour.White));
		board.movePiece(new Position(0,0), new Position(2,1), Colour.White);	
	}
	//Exception should be thrown when user tries to movePiece their piece into their own piece
	@Test(expected = MovementException.class)
	public void movingIntoOwnPieceException() throws Throwable
	{
		board.placePiece(new Bishop(new Position(0,0), Colour.White));
		board.placePiece(new Bishop(new Position(3,3), Colour.White));
		board.movePiece(new Position(0,0), new Position(3,3), Colour.White);		
	}
	
	//Expect to have the same chess piece that gets killed
	
	@Test
	public void testingSetUp() throws Throwable
	{
		board.boardInit();
	}
	
	

}
