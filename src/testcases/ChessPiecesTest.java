package testcases;

import org.junit.Test;

import board.*;
import chessPieces.Bishop;
import chessPieces.Knight;
import chessPieces.Rook;
import exceptions.*;
import tools.*;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class ChessPiecesTest {
	
	private Board emptyBoard;
	private Board board;
	final Position[] ROOKTEST = {new Position(4,2), new Position(5,2),
	new Position(2,2), new Position(1,2), new Position(3,3),
	new Position(3,1), new Position(3,0)};
	final Position[] ROOKTESTALLIES = {new Position(4,2), new Position(5,2),
	new Position(2,2), new Position(3,3), new Position(3,1), new Position(3,0)};
	final Position[] ROOKTESTENEMIES = ROOKTESTALLIES;
	final Position[] BISHOPTEST = {new Position(4,3), new Position(4,1),
	new Position(5,0), new Position(2,3), new Position(2,1), new Position(1,0)};
	final Position[] BISHOPTESTALLIES = {new Position(4,3), new Position(4,1),
	new Position(5,0), new Position(2,3), new Position(2,1)};
	final Position[] BISHOPTESTENEMIES = BISHOPTESTALLIES;
	final Position[] KNIGHTTEST = {new Position(4,0), new Position(2,0),
	new Position(5,3), new Position(5,1), new Position(1,3), new Position(1,1)};
	final Position[] KNIGHTTESTALLIES = KNIGHTTEST;
	final Position[] KNIGHTTESTENEMIES = KNIGHTTEST;
	
	@Before
	public void setUp() throws BoardException
	{
		emptyBoard = new Board(6,4);
		board = emptyBoard;
	}
	
	@Test
	public void testChessPiece() throws PlaceException
	{
		Rook rook = new Rook(new Position(1,1), Type.White);
		board.place(rook);
	}

	@Test
	public void testChessPieceMaxX() throws PlaceException
	{
		Rook rook = new Rook(new Position(5,1), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMaxY() throws PlaceException
	{
		Rook rook = new Rook(new Position(1,3), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMax() throws PlaceException
	{
		Rook rook = new Rook(new Position(5,3), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMinX() throws PlaceException
	{
		Rook rook = new Rook(new Position(0,1), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMinY() throws PlaceException
	{
		Rook rook = new Rook(new Position(1,0), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMin() throws PlaceException
	{
		Rook rook = new Rook(new Position(0,0), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceLargeX() throws Throwable
	{
		Rook rook = new Rook(new Position(7,1), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceLargeY() throws Throwable
	{
		Rook rook = new Rook(new Position(1,5), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceLarge() throws Throwable
	{
		Rook rook = new Rook(new Position(7,5), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testPositionsRook() throws PlaceException
	{
		refreshBoard();
		Rook rook = new Rook(new Position(3,2), Type.White);
		board.place(rook);
		checkPositions(ROOKTEST, rook.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsRookAllies() throws PlaceException
	{
		refreshBoard();
		Rook rook = new Rook(new Position(3,2), Type.White);
		board.place(rook);
		board.place(new Bishop(new Position(2,2), Type.White));
		board.place(new Knight(new Position(3,0), Type.White));
		checkPositions(ROOKTESTALLIES, rook.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsRookEnemies() throws PlaceException
	{
		refreshBoard();
		Rook rook = new Rook(new Position(3,2), Type.White);
		board.place(rook);
		board.place(new Bishop(new Position(2,2), Type.Black));
		board.place(new Knight(new Position(3,0), Type.Black));
		checkPositions(ROOKTESTENEMIES, rook.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsBishop() throws PlaceException
	{
		refreshBoard();
		Bishop bishop = new Bishop(new Position(3,2), Type.White);
		board.place(bishop);
		checkPositions(BISHOPTEST,bishop.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsBishopAllies() throws PlaceException
	{
		refreshBoard();
		Bishop bishop = new Bishop(new Position(3,2), Type.White);
		board.place(bishop);
		board.place(new Rook(new Position(4,3), Type.White));
		board.place(new Knight(new Position(2,1), Type.White));
		checkPositions(BISHOPTESTALLIES,bishop.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsBishopEnemies() throws PlaceException
	{
		refreshBoard();
		Bishop bishop = new Bishop(new Position(3,2), Type.White);
		board.place(bishop);
		board.place(new Rook(new Position(4,3), Type.Black));
		board.place(new Knight(new Position(2,1), Type.Black));
		checkPositions(BISHOPTESTENEMIES,bishop.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsKnight() throws PlaceException
	{
		refreshBoard();
		Knight knight = new Knight(new Position(3,2), Type.White);
		board.place(knight);
		checkPositions(KNIGHTTEST,knight.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsKnightAllies() throws PlaceException
	{
		refreshBoard();
		Knight knight = new Knight(new Position(3,2), Type.White);
		board.place(knight);
		board.place(new Rook(new Position(5,3), Type.White));
		board.place(new Bishop(new Position(1,1), Type.White));
		checkPositions(KNIGHTTESTALLIES,knight.calcPositions(board.getBoard()));
	}
	
	@Test
	public void testPositionsKnightEnemies() throws PlaceException
	{
		refreshBoard();
		Knight knight = new Knight(new Position(3,2), Type.White);
		board.place(knight);
		board.place(new Rook(new Position(5,3), Type.Black));
		board.place(new Bishop(new Position(1,1), Type.Black));
		checkPositions(KNIGHTTESTENEMIES,knight.calcPositions(board.getBoard()));
	} 
	
	private void refreshBoard()
	{
		board = emptyBoard;
	}
	
	private void checkPositions(Position[] expected, Position[] actual) {
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i].getPosX(), actual[i].getPosX());
			assertEquals(expected[i].getPosY(), actual[i].getPosY());
		}
	}
}
