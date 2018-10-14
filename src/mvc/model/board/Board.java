package mvc.model.board;

import exceptions.*;
import mvc.model.chessPieces.Bishop;
import mvc.model.chessPieces.ChessPiece;
import mvc.model.chessPieces.Knight;
import mvc.model.chessPieces.Rook;
import mvc.model.tools.Colour;
import mvc.model.tools.Position;

public class Board {

	Square[][] board;
	int sizeX;
	int sizeY;

	final int SIZE_X_FLOOR = 6;
	final int SIZE_Y_FLOOR = 4;
	final int SIZE_X_CEILING = 10;
	final int SIZE_Y_CEILING = 8;

	public Board(int sizeX, int sizeY) throws BoardException {
		if (sizeX < SIZE_X_FLOOR || sizeY < SIZE_Y_FLOOR) {
			throw new BoardException("Size must be of dimension 6x4 or greater!");
		} else if (sizeX > SIZE_X_CEILING || SIZE_Y_CEILING > 8) {
			throw new BoardException("Board size must not be greater than a dimension of 10x8!");
		} else {
			this.sizeX = sizeX;
			this.sizeY = sizeY;
			board = new Square[sizeX][sizeY];
			for(int y = 0; y < sizeY; y++)
			{
				for(int x = 0; x < sizeX; x++)
				{
					board[x][y] = new Square(new Position(x,y));
				}
			}
		}
	}

	public void displayBoard() 
	{
		for (int y = 0; y < sizeY; y++) {
			System.out.println("  ");
			for (int x = 0; x < sizeX; x++) {
				if(board[x][y] == null)
				{
					System.out.print("[    ]");
				}
				else
				{
					System.out.print(board[x][y].getChessPiece().chessDisplay());
				}
			}
		}
		System.out.println("");
	}

	public void placePiece(ChessPiece chessPiece) throws PlaceException {
		int posX = chessPiece.getPos().getPosX();
		int posY = chessPiece.getPos().getPosY();

		if (posX > sizeX - 1 || posY > sizeY - 1) {
			throw new PlaceException("Unable to placePiece chess piece there");
		}
		board[posX][posY].setChessPiece(chessPiece);
	}

	public ChessPiece movePiece(Position pos, Position destPos, Colour type) throws Throwable {
		ChessPiece chessPiece = board[pos.getPosX()][pos.getPosY()].getChessPiece();
		ChessPiece destChessPiece = board[destPos.getPosX()][destPos.getPosY()].getChessPiece();

		// Checks to see if the selected chess piece exist
		if (chessPiece == null) {
			throw new MovementException("Chess piece doesnt exist");

		}

		// Checks to see if its the current player's piece
		if (type != chessPiece.getColour()) {
			throw new MovementException("Must move your own chess piece!");
		}

		// Checks to see if the destination for that chess piece is within its movement
		// pattern
		if (!canMove(chessPiece, destPos)) {
			throw new MovementException("Destination for that piece is invalid");
		}

		// If there is a chess piece in the destination and checks if its the same
		// colour
		if (destChessPiece != null) {
			if (destChessPiece.getColour() == type) {
				throw new MovementException("Cannot move into your own chess piece!");
			}
		}

		// Move the chess piece to the new spot
		board[destPos.getPosX()][destPos.getPosY()].setChessPiece(chessPiece);
		board[pos.getPosX()][pos.getPosY()].removePiece();
		return destChessPiece;
	}

	private boolean canMove(ChessPiece chessPiece, Position destPos) {
		// Checks for the possible positions for the chess piece
		Position[] possiblePos = chessPiece.calcPositions(board);
		for (int i = 0; i < possiblePos.length; i++) 
		{
			if (destPos.equals(possiblePos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public Position[] checkPieceMovements(Position position) throws MovementException
	{
		if(board[position.getPosX()][position.getPosY()].getChessPiece() == null)
		{
			throw new MovementException("No piece exist");
		}
		return board[position.getPosX()][position.getPosY()].getChessPiece().calcPositions(board);
	}
	
	public void boardInit() throws PlaceException
	{
		placePiece(new Rook(new Position(0,0), Colour.White));
		placePiece(new Bishop(new Position(1,0), Colour.White));
		placePiece(new Knight(new Position(2,0), Colour.White));
		placePiece(new Knight(new Position(3,0), Colour.White));
		placePiece(new Bishop(new Position(4,0), Colour.White));
		placePiece(new Rook(new Position(5,0), Colour.White));
		
		placePiece(new Rook(new Position(0,3), Colour.Black));
		placePiece(new Bishop(new Position(1,3), Colour.Black));
		placePiece(new Knight(new Position(2,3), Colour.Black));
		placePiece(new Knight(new Position(3,3), Colour.Black));
		placePiece(new Bishop(new Position(4,3), Colour.Black));
		placePiece(new Rook(new Position(5,3), Colour.Black));
	}
	
	public Square[][] getBoard() {
		return board;
	}
}
