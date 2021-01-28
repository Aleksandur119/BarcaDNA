import java.awt.Color;
import java.awt.Graphics;

public class Square extends Block {

	
	//extends block and crater square on the screen
	Square(int w, int h, int x, int y, Color c) {
		super(w, h, x, y, c);
		
	}

	@Override
	void render(Graphics g) {
		g.setColor(getColor());
		g.fill3DRect(getX(), getY(), getWidth(), getHeight(),true);
		
	}

	@Override
	void tick() {
		
		
	}

	

}
