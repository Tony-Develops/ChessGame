package chessPieces;

import java.util.ArrayList;
import java.util.List;

import tools.Position;
import tools.Type;

public class Bishop extends ChessPiece {

	public Bishop(Position pos, Type type) {
		super(pos, type);
	}

	public Position[] calcPositions(ChessPiece[][] board) {
		List<Position> positions = new ArrayList<Position>();
		Position currentPosition;
		for (int i = 1; (pos.getPosX() + i) < board.length && (pos.getPosY() + i) < board[0].length; i ++) {
			currentPosition = new Position(pos.getPosX() + i, pos.getPosY() + i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() + i) < board.length && (pos.getPosY() - i) > 0; i ++) {
			currentPosition = new Position(pos.getPosX() + i, pos.getPosY() - i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - i) > 0 && (pos.getPosY() + i) < board[0].length; i ++) {
			currentPosition = new Position(pos.getPosX() - i, pos.getPosY() + 1);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - i) > 0 && (pos.getPosY() - i) > 0; i ++) {
			currentPosition = new Position(pos.getPosX() - i, pos.getPosY() - 1);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		return positions.toArray(new Position[positions.size()]);
	}

}
