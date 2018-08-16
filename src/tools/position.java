package tools;

public class position {

private int posX;
private int posY;

public void position(int posX, int posY) {
	this.posX = posX;
	this.posY = posY;
}

public void update(int posX, int posY) {
    this.posX = posX;
	this.posY = posY;
}

public int getPosX() {
	return posX;
}

public int getPosY() {
	return posY;
}