import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Turtle extends Block {

	private Random r= new Random();
	
	
	Positions p =new Positions();
	
	
	Turtle(int w, int h, int x, int y, Color c,int size) {
		super(w, h, x, y, c);
		
		
		
		int number=r.nextInt(Positions.positions.size());
		setX(size*Positions.positions.get(number)+(w/2));
		setY(size*2+(h/2));
		Positions.positions.remove(number);
	
	}

	@Override
	void render(Graphics g) {
		
		
		g.setColor(getColor());
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		
	}

	@Override
	void tick() {
		
		
	}
	
	

}
