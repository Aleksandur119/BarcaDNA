import java.awt.Color;
import java.awt.Graphics;
//base class for every block in the game
abstract class Block {
private int x;
private int y;

private int w,h;

private Color c;

Block(int w,int h,int x,int y,Color c){
	this.x=x;
	this.y=y;
	this.c=c;
	this.w=w;
	this.h=h;
}

abstract void render(Graphics g);//render method to render on screen
abstract void tick();//method to update position

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public Color getColor() {
	return c;
}

public void setCcolor(Color c) {
	this.c = c;
}

public int getWidth() {
	return w;
}

public void setWidth(int w) {
	this.w = w;
}

public int getHeight() {
	return h;
}

public void setHeight(int h) {
	this.h = h;
}

	
	
	
	
}
