package chessPieces;

import java.util.ArrayList;
import java.util.List;

import board.Square;
import tools.Position;
import tools.Colour;

public class Bishop extends ChessPiece {

	public Bishop(Position pos, Colour pieceColour) 
	{
		super(pos, pieceColour);
	}

	public Position[] calcPositions(Square[][] board) {
		List<Position> positions = new ArrayList<Position>();
		Position currentPosition;
		for (int i = 1; (pos.getPosX() + i) < board.length && (pos.getPosY() + i) < board[0].length && i <= 2; i ++) {
			currentPosition = new Position(pos.getPosX() + i, pos.getPosY() + i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() + i) < board.length && (pos.getPosY() - i) >= 0 && i <= 2; i ++) {
			currentPosition = new Position(pos.getPosX() + i, pos.getPosY() - i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - i) >= 0 && (pos.getPosY() + i) < board[0].length && i <= 2; i ++) {
			currentPosition = new Position(pos.getPosX() - i, pos.getPosY() + 1);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - i) >= 0 && (pos.getPosY() - i) >= 0 && i <= 2; i ++) {
			currentPosition = new Position(pos.getPosX() - i, pos.getPosY() - i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		return positions.toArray(new Position[positions.size()]);
	}
	
	public String chessDisplay() {
		if(pieceColour == Colour.Black)
		{
			return "[ BB ]";
		}
		else
		{
			return "[ WB ]";
		}
	}

}
