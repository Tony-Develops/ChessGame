package board;

import chessPieces.ChessPiece;
import exceptions.*;
import tools.Position;
import tools.Type;

public class Board {
	
	ChessPiece[][] board;
	int sizeX;
	int sizeY;
	final int SIZE_X_LIMIT = 6;
	final int SIZE_Y_LIMIT = 4;
	
	public Board(int sizeX, int sizeY) throws BoardException
	{
		if(sizeX < SIZE_X_LIMIT || sizeY < SIZE_Y_LIMIT)
		{
			throw new BoardException("Size must be of dimension 6x4 or greater!");
		}
		else
		{
			this.sizeX = sizeX;
			this.sizeY = sizeY;
			board = new ChessPiece[sizeX][sizeY];
		}
	}
	
	public void displayBoard()
	{
		//To do
	}
	
	public void place(ChessPiece chessPiece) throws PlaceException
	{
		int posX = chessPiece.getPos().getPosX();
		int posY = chessPiece.getPos().getPosY();
		
		if(posX > sizeX - 1 || posY > sizeY - 1)
		{
			throw new PlaceException("Unable to place chesspiece there");
		}
		board[posX][posY] = chessPiece;
	}
	
	public ChessPiece move(Position pos, Position destPos, Type type) throws Throwable
	{
		ChessPiece chessPiece = board[pos.getPosX()][pos.getPosY()];
		ChessPiece destChessPiece = board[destPos.getPosX()][destPos.getPosY()];
		
		//Checks to see if the selected chess piece exist
		if(chessPiece == null)
		{
			throw new MovementException("Chess piece doesnt exist");
		}
		
		//Checks to see if its the current player's piece
		if(type != chessPiece.getType())
		{
			throw new MovementException("Must move your own chess piece!");
		}
		
		//Checks to see if the destination for that chess piece is within its movement pattern
		if(!checkMovement(chessPiece, destPos))
		{
			throw new MovementException("Destination for that piece is invalid");
		}
		
		//If there is a chess piece in the destination and checks if its the same colour
		if(destChessPiece != null)
		{
			if(destChessPiece.getType() == type)
			{
				throw new MovementException("Cannot move into your own chess piece!");
			}
		}
		
		//Move the chess piece to the new spot
		board[destPos.getPosX()][destPos.getPosY()] = chessPiece;
		board[pos.getPosX()][pos.getPosY()] = null;
		return destChessPiece;
	}
	
	private boolean checkMovement(ChessPiece chessPiece, Position destPos)
	{
		//Checks for the possible positions for the chess piece
		Position[] possiblePos = chessPiece.calcPositions(board);
		for(int i = 0; i < possiblePos.length; i++)
		{
			if(destPos.getPosX() == possiblePos[i].getPosX() && destPos.getPosY() == possiblePos[i].getPosY())
			{
				return true;
			}
		}
		return false;
	}
}
