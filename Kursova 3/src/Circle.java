import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Block{

	
	///same as square but for circle
	Circle(int w, int h, int x, int y, Color c) {
		super(w, h, x, y, c);
		setX(getX()+(w/2));
		setY(getY()+(h/2));
	}

	@Override
	void render(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}

	@Override
	void tick() {
		// TODO Auto-generated method stub
		
	}

}
