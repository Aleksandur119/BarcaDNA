import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trap extends Field {

	private static List<Field> traps =new ArrayList<Field>();
	public Trap() {}
	
	public static int trap=-1;
	public Trap(Insets location) {
		super(location);
		traps.add(this);
	}

	@Override
	void execute(Player player) {
		if(player.getTrap()[2]==0) {
			System.out.println("Не можеш да залагаш повече капани този цикъл");
			 return;
		}
		
		if(isFree()) {
			Scanner s =new Scanner(System.in);
			System.out.println("Желаете ли да заложите капан? \n" + 
					"*	(1) : Данъчна ревизия (100 шп) \n" + 
					"*	(2) : Развод по котешки (200 шп) \n" + 
					"*	(3) : Пропаганда (100 шп) \n" + 
					"*	(4) : Проглеждане (50 шп) \n" + 
					"*	(5) : Хазартен бос (100 шп) \n" + 
					"*	(N) : Не, благодаря, не вярвам в злото" 
					);	
			
		
			
			int n=0;
			
			if(!player.title.equals("Bot")) {
				n=s.nextInt();	
			}else {
				n=Dice.rollDice(50+25)-25;
			if(n<=0) {
				n=7;
			}else {
				n=Dice.rollDice(5);
			}
			}
			
			if(n<=5) {
				trap=n;
				setFree(false);
			}
			switch(n) {
			case 1:
				player.setMoney(player.getMoney()-100);
				
				
				break;
			case 2:
				player.setMoney(player.getMoney()-200);
				
				break;
			case 3:
				player.setMoney(player.getMoney()-100);
				
				break;
			case 4:
				player.setMoney(player.getMoney()-50);
				
				break;
			case 5:
				player.setMoney(player.getMoney()-100);
				break;
			}
		//	s.close();		
			
		}else {
			player.getTrap()[trap-1]=0;
			
			
		}
	
		
	}
	@Override
	List<Field> getField() {
		return traps;
	
	}
	

}
