package mvc.model.chessPieces;

import java.util.ArrayList;
import java.util.List;

import mvc.model.board.Square;
import mvc.model.tools.Colour;
import mvc.model.tools.Position;

public class Rook extends ChessPiece {
	
	public Rook(Position pos, Colour pieceColour) {
		super(pos, pieceColour);
	}

	public Position[] calcPositions(Square[][] board) {
		List<Position> positions = new ArrayList<Position>();
		Position currentPosition;
		for (int i = 1; (pos.getPosX() + i) < board.length && i <=2; i++) {
			currentPosition = new Position(pos.getPosX() + i, pos.getPosY());
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - 1) >= 0 && i <= 2; i ++) {
			currentPosition = new Position((pos.getPosX() - i), pos.getPosY());
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosY() + i) < board[0].length && i <= 2; i++) {
			currentPosition = new Position(  pos.getPosX(), pos.getPosY() + i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - 1) >= 0 && i <=2; i ++) {
			currentPosition = new Position(pos.getPosX(), (pos.getPosY() - i));
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
			return "[ BR ]";
		}
		else
		{
			return "[ WR ]";
		}
	}
}
