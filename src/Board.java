import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


 class Board extends JFrame {
int w,h;
	String title;
	private int board[][] =new int[5][5];
	 private List<Object> pieceCollection=new ArrayList<>();
	Board(){
		setSize(new Dimension(400,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
	
	/*
	 * public void fillBoard() {
	 * 
	 * for(int row = 0; row < 5; row++) { for(int col = 0; col < 5; col++) {
	 * board[][]
	 * 
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * }
	 */
	
	 @Override
	    public void paint(Graphics g) {

	        super.paint(g);
	        Color colorsPalete[] = {Color.RED,Color.DARK_GRAY,Color.white,Color.DARK_GRAY,Color.RED};
	        Color colorsPalete2[] = {Color.DARK_GRAY,Color.RED,Color.white,Color.RED,Color.DARK_GRAY};

	        for(int row = 0; row < 5; row++) {
	            for(int col = 0; col < 5; col++) {
	            	if(row==0) {
	            	Square s =new Square(row,col,colorsPalete[col],false);
	            	s.render(g);
	            }else if(row==4) {
	            	Square s =new Square(row,col,colorsPalete2[col],false);
	            	s.render(g);
	            }else {
	            	Square s =new Square(row,col,Color.BLACK,false);
	            	s.render(g);
	            }
	          }
	        }
	        fillBoard(g);
	    }
	 
	public void fillBoard(Graphics g){
		 
		//Square s =new Square(0,0,Color.YELLOW,true);
		//s.render(g);
		
		//Circle c =new Circle(1,0,Color.GREEN,Color.YELLOW);
		//c.render(g);
		for(int j=0;j<5;j++) {
			
			
			for(int i=0;i<5;i++) {
				if(j==0) {
					if(i!=4) {
						Circle c =new Circle(i,j,Color.GREEN,Color.YELLOW);
						c.render(g);
					}else if(i==4) {
						
						Square s =new Square(j,i,Color.YELLOW,true);
						s.render(g);
					}
				}else if(j==4) {
					if(i!=4) {
						Circle c =new Circle(i,j,Color.YELLOW,Color.GREEN);
						c.render(g);
					}else {
						 
						Square s =new Square(i,j,Color.GREEN,true);
						s.render(g);
					}
				}
				
				//Circle c =new Circle(1,0,Color.GREEN,Color.YELLOW);
			}
			
		}
			  
		

		/*
		 * for(int row = 0; row < 5; row++) { for(int col = 0; col < 5; col++) {
		 * if(row==0) { if(col!=4) { //Circle circle =new
		 * Circle(col,row,Color.GREEN,Color.YELLOW); //circle.render(g); //}else {
		 * //Square s =new Square(row,col,Color.YELLOW,true); //s.render(g); } }else
		 * if(row==4) { if(col!=4) { Circle circle =new
		 * Circle(col,row,Color.YELLOW,Color.GREEN); circle.render(g); }else { Square s
		 * =new Square(row,col,Color.GREEN,true); s.render(g); } } } }
		 */
		
	}
	
}
