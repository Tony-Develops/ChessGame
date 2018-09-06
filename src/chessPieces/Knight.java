package chessPieces;

import java.util.ArrayList;
import java.util.List;

import tools.Position;
import tools.Type;

public class Knight extends ChessPiece {

	public Knight(Position pos, Type type) {
		super(pos, type);
	}

	public Position[] calcPositions(int boardSizeX, int boardSizeY) {
		List<Position> positions = new ArrayList<Position>();
		if ((pos.getPosY() + 2) < boardSizeY && (pos.getPosX() + 1) < boardSizeX) {
			positions.add(new Position(pos.getPosX() + 1, pos.getPosY() + 2));
		}
		if ((pos.getPosY() + 2) < boardSizeY && (pos.getPosX() - 1) > 0) {
			positions.add(new Position(pos.getPosX() - 1, pos.getPosY() + 2));
		}
		if ((pos.getPosY() - 2) > 0 && (pos.getPosX() + 1) < boardSizeX) {
			positions.add(new Position(pos.getPosX() + 1, pos.getPosY() + 2));
		}
		if ((pos.getPosY() - 2) > 0 && (pos.getPosX() - 1) > 0) {
			positions.add(new Position(pos.getPosX() - 1, pos.getPosY() + 2));
		}
		if ((pos.getPosX() + 2) < boardSizeX && (pos.getPosY() + 1) < boardSizeY) {
			positions.add(new Position(pos.getPosX() + 2, pos.getPosY() + 1));
		}
		if ((pos.getPosX() + 2) < boardSizeX && (pos.getPosY() - 1) > 0) {
			positions.add(new Position(pos.getPosX() + 2, pos.getPosY() - 1));
		}
		if ((pos.getPosX() - 2) > 0 && (pos.getPosY() + 1) < boardSizeY) {
			positions.add(new Position(pos.getPosX() + 2, pos.getPosY() + 1));
		}
		if ((pos.getPosX() - 2) > 0 && (pos.getPosY() - 1) > 0) {
			positions.add(new Position(pos.getPosX() + 2, pos.getPosY() - 1));
		}
		return positions.toArray(new Position[positions.size()]);
	}


}
