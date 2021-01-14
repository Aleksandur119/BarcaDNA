import java.awt.Color;
import java.awt.Graphics;

public class Circle {

	int row,col;
	Color background;
	Color border;
	  public Circle(int row, int col,Color background,Color border) {
	        this.row = row;
	        this.col = col;
	        this.background=background;
	        this.border=border;
	    }
	    public void render(Graphics g) {

	        g.setColor(background);
	        g.fillOval((row*80)+20, (col*80)+40, 40, 40);
	        g.setColor(border);
	        g.fillOval((row*80)+21, (col*80)+41, 38, 38);
	        
	    }
	
}
