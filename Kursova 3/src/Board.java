import java.awt.Color;
import java.awt.Graphics;

public class Board {

	
	private int size;
	
	private Turtle t[] =new Turtle[2];//turtle variable
	
	Board(int size){
	this.size=size;	
	
	for(int i=0;i<t.length;i++) {
		t[i]=new Turtle(size/2,size/2,0,0,Color.red,size);//init turtle
	}
	}
	
	private final Block b[][]=new Square[5][5];//block on board
	private Color colors[] = {Color.red,Color.gray,Color.white,Color.gray,Color.black};//colosr
	
	public void render(Graphics g) {//render all blocks on screen
		boolean swap =false;
		for(int i=0;i<b.length;i++) {
			
			
			for(int j=0;j<b[i].length;j++) {
				if(i==2||j==2) {
					b[j][i]=new Square(size,size,size*i,size*j,Color.white);
				}else if(!swap)
					b[j][i]=new Square(size,size,size*i,size*j,colors[j]);
				else
					b[j][i]=new Square(size,size,size*i,size*j,colors[4-j]);
				
				b[j][i].render(g);
			}
			swap=!swap;
		
		}
		
		
		Circle circle =new Circle(size/2,size/2,2*size,2*size,Color.gray);//render center curcle
		circle.render(g);
		
		for(int i=0;i<t.length;i++) {
		
			t[i].render(g);//render turtles
		}
		
	}
	
	
	
}
