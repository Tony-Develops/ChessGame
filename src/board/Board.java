package board;

import org.junit.Test;

import chessPieces.ChessPiece;
import exceptions.*;
import tools.Position;
import tools.Type;

public class Board {

	ChessPiece[][] board;
	int sizeX;
	int sizeY;
<<<<<<< Updated upstream
	final int SIZE_X_LIMIT = 6;
	final int SIZE_Y_LIMIT = 4;
	
	public Board(int sizeX, int sizeY) throws BoardException
	{
		if(sizeX < SIZE_X_LIMIT || sizeY < SIZE_Y_LIMIT)
		{
=======

	public Board(int sizeX, int sizeY) throws BoardException {
		if (sizeX < 6 || sizeY < 4) {
>>>>>>> Stashed changes
			throw new BoardException("Size must be of dimension 6x4 or greater!");
		} else if (sizeX > 10 || sizeY > 8) {
			throw new BoardException("Board size must not be greater than a dimension of 10x8!");
		} else {
			this.sizeX = sizeX;
			this.sizeY = sizeY;
			board = new ChessPiece[sizeX][sizeY];
		}
	}

	public void displayBoard() {
		for (int i = 0; i < this.sizeX; i++) {
			for (int j = 0; j < this.sizeY; j++) {
				System.out.println("[  ]");
			}
			System.out.println("");
		}
	}
<<<<<<< Updated upstream
	
	public void place(ChessPiece chessPiece) throws PlaceException
	{
		int posX = chessPiece.getPos().getPosX();
		int posY = chessPiece.getPos().getPosY();
		
		if(posX > sizeX - 1 || posY > sizeY - 1)
		{
			throw new PlaceException("Unable to place chesspiece there");
=======

	public void place(ChessPiece chessPiece) throws ChessPieceException {
		int posX = chessPiece.getPos().getPosX();
		int posY = chessPiece.getPos().getPosY();

		if (posX > sizeX - 1 || posY > sizeY - 1) {
			throw new ChessPieceException("Unable to place chesspiece there");
>>>>>>> Stashed changes
		}
		board[posX][posY] = chessPiece;
	}

	public ChessPiece move(Position pos, Position destPos, Type type) throws Throwable {
		ChessPiece chessPiece = board[pos.getPosX()][pos.getPosY()];
		ChessPiece destChessPiece = board[destPos.getPosX()][destPos.getPosY()];
<<<<<<< Updated upstream
		
		//Checks to see if the selected chess piece exist
		if(chessPiece == null)
		{
			throw new MovementException("Chess piece doesnt exist");
=======

		// Checks to see if the selected chess piece exist
		if (chessPiece == null) {
			throw new ChessPieceException("Chess piece doesnt exist");
>>>>>>> Stashed changes
		}

		// Checks to see if its the current player's piece
		if (type != chessPiece.getType()) {
			throw new MovementException("Must move your own chess piece!");
		}

		// Checks to see if the destination for that chess piece is within its movement
		// pattern
		if (!checkMovement(chessPiece, destPos)) {
			throw new MovementException("Destination for that piece is invalid");
		}
<<<<<<< Updated upstream
		
		//If there is a chess piece in the destination and checks if its the same colour
		if(destChessPiece != null)
		{
			if(destChessPiece.getType() == type)
			{
				throw new MovementException("Cannot move into your own chess piece!");
			}
=======

		// If there is a chess piece in the destination and checks if its the same
		// colour
		if (destChessPiece != null) {
			throw new MovementException("Cannot move into your own chess piece!");
>>>>>>> Stashed changes
		}

		// Move the chess piece to the new spot
		board[destPos.getPosX()][destPos.getPosY()] = chessPiece;
		board[pos.getPosX()][pos.getPosY()] = null;
		return destChessPiece;
	}
<<<<<<< Updated upstream
	
	private boolean checkMovement(ChessPiece chessPiece, Position destPos)
	{
		//Checks for the possible positions for the chess piece
		Position[] possiblePos = chessPiece.calcPositions(board);
		for(int i = 0; i < possiblePos.length; i++)
		{
			if(destPos.getPosX() == possiblePos[i].getPosX() && destPos.getPosY() == possiblePos[i].getPosY())
			{
=======

	private boolean checkMovement(ChessPiece chessPiece, Position destPos) {
		// To do
		Position[] possiblePos = chessPiece.calcPositions(sizeX, sizeY);
		for (int i = 0; i < possiblePos.length; i++) {
			if (destPos == possiblePos[i]) {
>>>>>>> Stashed changes
				return true;
			}
		}
		return false;
	}
}
