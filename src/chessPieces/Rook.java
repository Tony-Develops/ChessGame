package chessPieces;

import tools.Position;
import tools.Type;

public class Rook extends ChessPiece {

	public Rook(Position pos, Type type) {
		super(pos, type);
	}

	public Position[] calcPositions(int boardSizeX, int boardSizeY) {
		// This code needs to be modified to depend on type
		if ((pos.getPosY() + 1) <= boardSizeY && (pos.getPosY() + 1) >= 0) {
			Position[] positions = new Positions[1];
			positions[0] = new Position(pos.getPosX(), pos.getPosY + 1); 
			return positions;
		}
		else {
		return null
		};
	}

}
