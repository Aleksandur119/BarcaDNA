
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 *
 * @author Martin Cruz
 */
public class GameLoop extends Canvas implements Runnable {
	public final static int BLOCKS=64;//size of blocks
	
	public final static int WIDTH=BLOCKS*5;//width of the window
	public final static int HEIGHT = WIDTH;//height of the windows
	public  final static int SCALE = 1;
	public final static String NAME = "Game 2D";//title
	private final static long serialVersionUID = 1L;
	private   static BufferStrategy bs;
	private Board b;

	private JFrame frame;
	public boolean running = false;
	public int tickCount = 0;

	public GameLoop() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		init();
	}
	
	private void init() {
		 b=new Board(BLOCKS);
	}

	public synchronized void start() {
		new Thread(this).start();
		running = true;
	}

	public synchronized void stop() {
		running = false;
	}

	@Override
	public void run() {//game loop to count fps and refresh screen
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 64;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " frames");
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void tick() {
		tickCount++;
	}

	public void render() {//cretate base bufferstrategy
		
		  bs = getBufferStrategy();
		  
		  if (bs == null) { 
			  createBufferStrategy(3); 
			  return; 
			  }
		  
		  Graphics g = bs.getDrawGraphics(); g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		  
		
		 
		  b.render(g);//redern board
		  
		  
		  bs.show(); g.dispose();
		 
	}
}