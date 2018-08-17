package chessPieces;

public abstract class ChessPiece {
	
	private Position pos;
	private Type type;
	
	public void ChessPiece(Position pos, Type type) {
		this.pos = pos;
		this.type = type;
	}
	
	public void update(Position destPos) {
		pos = destPos;
	}
	
	public abstract calcPositions();
	
	public Position getPos() {
		return pos;
	}
	
	public Type getType() {
		return type;
	}
}
