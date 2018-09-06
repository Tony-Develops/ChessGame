package chessPieces;

import java.util.ArrayList;
import java.util.List;

import tools.Position;
import tools.Type;

public class Rook extends ChessPiece {
	
	public Rook(Position pos, Type type) {
		super(pos, type);
	}

	public Position[] calcPositions(int boardSizeX, int boardSizeY) {
		List<Position> positions = new ArrayList<Position>();
		for (int i = 1; (pos.getPosX() + i) < boardSizeX; i++) {
			positions.add(new Position(pos.getPosX() + i, pos.getPosY()));
		}
		for (int i = 1; (pos.getPosX() - 1) >= 0; i --) {
			positions.add(new Position((pos.getPosX() - i), pos.getPosY()));
		}
		for (int i = 1; (pos.getPosY() + i) < boardSizeY; i++) {
			positions.add(new Position(  pos.getPosX(), pos.getPosY() + i));
		}
		for (int i = 1; (pos.getPosX() - 1) >= 0; i --) {
			positions.add(new Position(pos.getPosX(), (pos.getPosY() - i)));
		}
		return (Position[]) positions.toArray();
	}
}
