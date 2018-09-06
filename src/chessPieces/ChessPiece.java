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
	
	public abstract Position[] calcPositions(ChessPiece[][] board);
	
	public Position getPos() {
		return pos;
	}
	
	public Type getType() {
		return type;
	}
	
	protected Boolean checkPosition(ChessPiece[][] board, Position position) {
		if (board[position.getPosX()][position.getPosY()] == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String chessDisplay() {
		return "";
	}
}
