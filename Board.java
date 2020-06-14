import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

	private static  int[][] board=new int[4][8];
	
	
	private final static String legent[]= {"   ","|X|","|S|","|B|",
			"|Y|","|T|","|C|","|I|","|P|","|G|",};
	
	
	
	private List<Insets> freeSpaces =new ArrayList<Insets>();
	private Random rand =new Random();
	
	private Player bot =new Player(this,3,"You");
	private Player you =new Player(this,4,"Bot");
	
	
	
	private boolean change;
	
	public Board() {
		setUpBoard();
		
		//you.move(Dice.rollDice(1));
		menu();
		
	}
	
	
	
	
	
	private void initFiled(int end,int number,int n) {
		
		int random =0;
		for(int i=0;i<end;i++) {
			random =rand.nextInt(freeSpaces.size());
			if(number==5) {
				new Trap(freeSpaces.get(random));
			}
			else if(number==6) {
				new Chance(freeSpaces.get(random));
			}
			else if(number==7) {
				new Invest(freeSpaces.get(random));
			}
			else if(number==8) {
				 new PartyHard(freeSpaces.get(random));
			}else if(number==9) {
				new Steal(freeSpaces.get(random));
			}
			

			board[freeSpaces.get(random).getX()][freeSpaces.get(random).getY()]=number;
			freeSpaces.remove(random);
		}
	}
	
	
	
	
	private void setUpBoard() {
		
		for(int i=0;i<board.length;i+=board.length-1) {
			
			for(int j=0;j<board[i].length;j++) {
				
				freeSpaces.add(new Insets(i,j));
				board[i][j]=1;
			}
			
		}
		
		freeSpaces.remove(freeSpaces.size()-1);
		freeSpaces.remove(0);
		freeSpaces.remove(6);
	
		for(int i=0;i<board.length;i++) {
			board[i][0]=1;
			board[i][board[i].length-1]=1;
			freeSpaces.add(new Insets(i,0));
			
			freeSpaces.add(new Insets(i,board[i].length-1));
			
		}
		
	    freeSpaces.remove(freeSpaces.size()-1);
	    freeSpaces.remove(freeSpaces.size()-1);
		board[board.length-1][board[0].length-1]=2;
		
		
		for(int i=5;i<10;i++) {
			if(i==5)
				initFiled(7,i,i-5);	
			else 
				initFiled(3,i,i-5);	
			
		}
		
	}
	
	
	public   void printBoard() {
	
		
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				
				System.out.print(legent[board[i][j]]);
				
				
				
			}
			if(i==2)System.out.print("\tYou have "+you.getMoney()+" money");
			if(i==3)System.out.print("\tBot have "+bot.getMoney()+" money");

			System.out.println();
		}
		
		
	}

	public static int[][] getBoard() {
		return board;
	}

	public static void setBoard(int[][] board) {
		Board.board = board;
		
	}
	
	
	public  void reset() {
		Insets player1 =you.getLocation();
		//Insets player2 = bot.getLocation();
		setUpBoard();
		you.setTempNumber(board[player1.getX()][player1.getY()]);
		board[player1.getX()][player1.getY()]=4;
		
		if(!you.getCompany().isEmpty()) {
		int randomNum = rand.nextInt((you.getCompany().get(0).getMax() 
				- you.getCompany().get(0).getMax()) + 1) + you.getCompany().get(0).getMin();
		
		
		boolean test =false;
		if(you.getTrap()[1]==0) {
			test=Dice.rollDice(10)==2||Dice.rollDice(10) ==8;
		}
		
		if(randomNum>=0&&!test) {
			you.setMoney(you.getMoney()+you.getInv()*you.getCompany().get(0).getK());
		}
		if(you.getTrap()[0]==0) {
			you.setMoney(you.getMoney()-you.getMoney()*10/100);
		}
		
		
		}
		
		
	}
	
	boolean running=true;
	
	public void menu() {
		
		while(running) {
			if(change) {
				change=false;
				you.move(Dice.rollDice(6));
			}else {
				change=true;
				bot.move(Dice.rollDice(6));
			}
		}
		
		
		
		
	}
	
}
