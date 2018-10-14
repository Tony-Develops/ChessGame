package mvc.model.chessPieces;

import mvc.model.board.Square;
import mvc.model.tools.Colour;
import mvc.model.tools.Position;

abstract public class ChessPiece {
	
	protected Position pos;
	protected Colour pieceColour;
	
	public ChessPiece(Position pos, Colour pieceColour) {
		this.pos = pos;
		this.pieceColour = pieceColour;
	}
	
	public void update(Position destPos) {
		pos = destPos;
	}
	
	public abstract Position[] calcPositions(Square[][] board);
	
	public Position getPos() {

		return pos;
	}
	
	public Colour getColour() {
		return pieceColour;
	}
	
	protected Boolean checkPosition(Square[][] board, Position position) {
		if (board[position.getPosX()][position.getPosY()].getChessPiece() == null) {
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
