package chessPieces;

import tools.Position;
import tools.Type;

abstract public class ChessPiece {
	
	protected Position pos;
	protected Type type;
	
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
