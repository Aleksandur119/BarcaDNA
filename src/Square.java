import java.awt.Color;
import java.awt.Graphics;

public class Square {

	int row,col;
	boolean test=false;
	Color c;
	  public Square(int row, int col,Color c,boolean test) {
	        this.row = col;
	        this.col = row;
	        this.c=c;
	        this.test=test;
	    }
	    public void render(Graphics g) {

	        g.setColor(c);
	        if(test) {
	        g.fillRect((row*80)+20, (col*80)+40, 40, 40);
	        
	        }else
	        	//System.out.println("HERE");
	        	g.fillRect((row*80), (col*80), 80, 80);
	        
	        
	    }
	
}
