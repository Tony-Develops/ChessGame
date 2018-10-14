package mvc.model.tools;

public class Position {

private int posX;
private int posY;

	public Position(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public boolean equals(Position position)
	{
		if(posX == position.getPosX() && posY == position.getPosY())
		{
			return true;
		}
		return false;
	}

}