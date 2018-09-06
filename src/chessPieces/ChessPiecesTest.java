package chessPieces;

import org.junit.Test;

import board.*;
import exceptions.*;
import junit.framework.Assert;
import tools.*;

import org.junit.Before;

public class ChessPiecesTest {
	
	private Board emptyBoard;
	private Board board;
	final Position[] RookTest = {new Position(4,2), new Position(5,2),
	new Position(2,2), new Position(1,2), new Position(0,2), new Position(3,3),
	new Position(3,1), new Position(3,0)};
	
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
		Rook rook = new Rook(new Position(6,1), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMaxY() throws PlaceException
	{
		Rook rook = new Rook(new Position(1,4), Type.White);
		board.place(rook);
	}
	
	@Test
	public void testChessPieceMax() throws PlaceException
	{
		Rook rook = new Rook(new Position(6,4), Type.White);
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
	public void testChessPieceSmallX() throws Throwable
	{
		Rook rook = new Rook(new Position(-1,1), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceLargeX() throws Throwable
	{
		Rook rook = new Rook(new Position(7,1), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceSmallY() throws Throwable
	{
		Rook rook = new Rook(new Position(1,-1), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceLargeY() throws Throwable
	{
		Rook rook = new Rook(new Position(1,5), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceSmall() throws Throwable
	{
		Rook rook = new Rook(new Position(-1,-1), Type.White);
		board.place(rook);
	}
	
	@Test(expected = PlaceException.class)
	public void testChessPieceLarge() throws Throwable
	{
		Rook rook = new Rook(new Position(7,5), Type.White);
		board.place(rook);
	}
	
	private void refreshBoard()
	{
		board = emptyBoard;
	}
}
