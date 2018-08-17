package board;

import chessPieces.ChessPiece;

public class Board {
	
	ChessPiece[][] board;
	
	public Board(int sizeX, int sizeY)
	{
		if(sizeX < 6 || sizeY < 4)
		{
			System.out.println("Size must be of dimension 6x4 or greater!");
		}
		else
		{
			board = new ChessPiece[sizeX][sizeY];
		}
	}
}
