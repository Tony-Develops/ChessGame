package chessPieces;

import java.util.ArrayList;
import java.util.List;

import tools.Position;
import tools.Type;

public class Rook extends ChessPiece {
	
	public Rook(Position pos, Type type) {
		super(pos, type);
	}

	public Position[] calcPositions(ChessPiece[][] board) {
		List<Position> positions = new ArrayList<Position>();
		Position currentPosition;
		for (int i = 1; (pos.getPosX() + i) < board.length; i++) {
			currentPosition = new Position(pos.getPosX() + i, pos.getPosY());
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - 1) >= 0; i --) {
			currentPosition = new Position((pos.getPosX() - i), pos.getPosY());
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosY() + i) < board[0].length; i++) {
			currentPosition = new Position(  pos.getPosX(), pos.getPosY() + i);
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		for (int i = 1; (pos.getPosX() - 1) >= 0; i --) {
			currentPosition = new Position(pos.getPosX(), (pos.getPosY() - i));
			positions.add(currentPosition);
			if (checkPosition(board, currentPosition) == true) {
				break;
			}
		}
		return positions.toArray(new Position[positions.size()]);
	}
	
	public String chessDisplay() {
		return "[R]";
	}
}
