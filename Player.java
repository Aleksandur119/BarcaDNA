import java.util.ArrayList;
import java.util.List;

class Player {
	static int count=0;
	
	
	String title;
	
	
	private Insets location =new Insets();
	 private int tempNumber;
	 private int side=0;
	 private Board b;
	 private int playerNumber;
	 
	 
	 private int trap[]= {-1,-1,-1,-1,-1};
	 
	 
	 
	 private int evilPlan=-1;
	 private boolean evilplan=false;
	 private List<Company> companies=new ArrayList<Company>();
	 private int inv;
	 
	
	 

	private double money=1000;
	public Player(Board b,int playerNumber,String title) {
		location.setX(b.getBoard().length-1);
		location.setY(b.getBoard()[0].length-1);
		this.b=b;
		this.playerNumber=playerNumber;
		tempNumber=2;
		initEvilPlan();
		this.title=title;
	}
	private void initEvilPlan() {
		evilPlan=Dice.rollDice(3);
	}
	

	 public double getMoney() {
		return money;
	}



	public void setMoney(double money) {
		this.money = money;
		if(money<=0) {
			b.running=false;
			System.out.println(title+" lost the game");
		}
	}

	

	public int getSide() {
		return side;
	}



	public void setSide(int side) {
		this.side = side;
	}



	public Insets getLocation() {
		return location;
	}



	public void setLocation(int x,int y) {
		location.setX(x);
		location.setY(y);
	}


private void move(int offsetX,int offsetY){
	
	b.getBoard()[location.getX()][location.getY()]=tempNumber;
	
	tempNumber=b.getBoard()[location.getX()+offsetX][location.getY()+offsetY];
	b.getBoard()[location.getX()+offsetX][location.getY()+offsetY]=playerNumber;
	
	setLocation(location.getX()+offsetX,location.getY()+offsetY);
	
}
public void move(int by) {

		for(int i=0;i<by;i++) {
				
			try {
				if(side==0) {
					move(0,-1);
				}else if(side==1) {
					move(-1,0);
				}else if(side==2) {
					move(0,1);
				}else if(side==3) {
					move(1,0);
				}
				
			}catch(Exception e) {
				
				if(side==3) {
					side=0;
					count++;
					if(count>=2) {
						b.reset();
					}
				}else {
				side++;
				}
			}
		}
		
		b.printBoard();
		System.out.println(tempNumber);
		executeField(tempNumber,getLocation().getX(),getLocation().getY());
		
		
	
	}


private void executeField(int number,int x,int y) {
	
	if(number==5) {
		getField(new Trap().getField(),x,y);
	}else if(number==6) {
		getField(new Chance().getField(),x,y);
	}else if(number==7) {
		getField(new Invest().getField(),x,y);
	}else if(number==8) {
		getField(new PartyHard().getField(),x,y);
	}else if(number==9) {
		getField(new Steal().getField(),x,y);
	}
}

private void getField(List<Field> fields,int x,int y) {
	for(int i=0;i<fields.size();i++) {
		if(fields.get(i).getLocation().getX()==x&&fields.get(i).getLocation().getY()==y) {
			fields.get(i).execute(this);
			
		}
	}
}

public int[] getTrap() {
	return trap;
}



public void setTrap(int[] trap) {
	this.trap = trap;
}
public boolean isEvilPlan() {
	return evilplan;
}
public void setEvilPlan(boolean evilplan) {
	this.evilplan = evilplan;
}
public int getEvilPlan() {
	return evilPlan;
}
public void setEvilPlan(int evilPlan) {
	this.evilPlan = evilPlan;
}
public List<Company>  getCompany() {
	return companies;
}
public void setCompany(List<Company>  companies) {
	this.companies = companies;
}
public int getInv() {
	return inv;
}
public void setInv(int inv) {
	this.inv = inv;
}
public int getTempNumber() {
	return tempNumber;
}
public void setTempNumber(int tempNumber) {
	this.tempNumber = tempNumber;
}

	
	
	
}
