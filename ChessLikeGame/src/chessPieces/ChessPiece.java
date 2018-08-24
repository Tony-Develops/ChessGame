package chessPieces;

import tools.Position;
import tools.Type;

public abstract class ChessPiece {
	
	private Position pos;
	private Type type;
	
	public ChessPiece(Position pos, Type type) {
		this.pos = pos;
		this.type = type;
	}
	
	public void update(Position destPos) {
		pos = destPos;
	}
	
	public abstract Position[] calcPositions(int boardSizeX, int boardSizeY);
	
	public Position getPos() {
		return pos;
	}
	
	public Type getType() {
		return type;
	}
}
