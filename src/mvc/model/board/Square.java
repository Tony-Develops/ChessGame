package mvc.model.board;

import mvc.model.chessPieces.ChessPiece;
import mvc.model.tools.Position;

public class Square 
{
	Position position;
	ChessPiece chessPiece;
	
	public Square(Position position)
	{
		this.position = position;
	}
	
	public void setChessPiece(ChessPiece chessPiece)
	{
		this.chessPiece = chessPiece;
	}
	
	public ChessPiece getChessPiece()
	{
		return chessPiece;
	}
	
	public void removePiece()
	{
		chessPiece = null;
	}

}
