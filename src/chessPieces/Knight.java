package chessPieces;

import java.util.ArrayList;
import java.util.List;

import board.Square;
import tools.Position;
import tools.Colour;

public class Knight extends ChessPiece {

	public Knight(Position pos, Colour pieceColour) {
		super(pos, pieceColour);
	}

	public Position[] calcPositions(Square[][] board) {
		List<Position> positions = new ArrayList<Position>();
		if ((pos.getPosY() + 2) < board[0].length && (pos.getPosX() + 1) < board.length) {
			positions.add(new Position(pos.getPosX() + 1, pos.getPosY() + 2));
		}
		if ((pos.getPosY() + 2) < board[0].length && (pos.getPosX() - 1) >= 0) {
			positions.add(new Position(pos.getPosX() - 1, pos.getPosY() + 2));
		}
		if ((pos.getPosY() - 2) >= 0 && (pos.getPosX() + 1) < board.length) {
			positions.add(new Position(pos.getPosX() + 1, pos.getPosY() - 2));
		}
		if ((pos.getPosY() - 2) >= 0 && (pos.getPosX() - 1) >= 0) {
			positions.add(new Position(pos.getPosX() - 1, pos.getPosY() - 2));
		}
		if ((pos.getPosX() + 2) < board.length && (pos.getPosY() + 1) < board[0].length) {
			positions.add(new Position(pos.getPosX() + 2, pos.getPosY() + 1));
		}
		if ((pos.getPosX() + 2) < board.length && (pos.getPosY() - 1) > 0) {
			positions.add(new Position(pos.getPosX() + 2, pos.getPosY() - 1));
		}
		if ((pos.getPosX() - 2) >= 0 && (pos.getPosY() + 1) < board[0].length) {
			positions.add(new Position(pos.getPosX() - 2, pos.getPosY() + 1));
		}
		if ((pos.getPosX() - 2) >= 0 && (pos.getPosY() - 1) >= 0) {
			positions.add(new Position(pos.getPosX() - 2, pos.getPosY() - 1));
		}
		return positions.toArray(new Position[positions.size()]);
	}

	public String chessDisplay() {
		if(pieceColour == Colour.Black)
		{
			return "[ BK ]";
		}
		else
		{
			return "[ WK ]";
		}
	}
}
