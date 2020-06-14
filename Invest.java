import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Invest extends Field{

	private static List<Field> Invest =new ArrayList<Field>();
	private static List<Company> companies =new ArrayList<Company>();
   
	private static String[] names= {"Samsung", "Apple", "Philips", "Sharp", "BMW", "Devin"};
	private final int[] inv= {500, 400, 300, 200, 100, 50};
	private final float[] k= {0.2f, 0.5f, 1.5f, 2.0f, 2.5f, 5.0f};
	private final int[] max= {100, 50, 35, 50, 100, 10};
	private final int[] min= {-5, -10, -15, -8, -25, -20};
			
			
			
			
			
	
	
	
	
	
	public Invest() {}
	public Invest(Insets location) {
		super(location);
		Invest.add(this);
		initCompanies();
	}
private void initCompanies() {
	for(int i=0; i<k.length; i++) {
		companies.add(new Company(names[i], inv[i], k[i], min[i], max[i]));
	}
}
	@Override
	void execute(Player player) {
		if(player.getEvilPlan()==1) {
			player.setMoney(player.getMoney()+100);
			System.out.println("Получихте 100 парички");
		}
		
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i<k.length; i++) {
			System.out.println("{"+(i+1)+"}"+"."+companies.get(i).getCompanyName()+
					"|"+companies.get(i).getInv()+
					"|"+companies.get(i).getK()+
					"|"+companies.get(i).getMin()+
					"/"+companies.get(i).getMax());
	
		}
		System.out.println("{N}:Не ми се инвестира повече ");
		
		
		int n;
		if(!player.title.equals("Bot")) {
			n=input.nextInt();	
		}else {
			n=Dice.rollDice(50+25)-25;
		if(n<=0) {
			n=7;
		}else {
			n=Dice.rollDice(5);
		}
		}
		
		if(n>=k.length) {
			return;
		}
		if(player.getMoney()>inv[n-1]) {
			
		
			System.out.println("Ти избра да направиш инвестиция в "+names[n-1]+", посочи сумата, която си склонен да отделиш: ");
			int sum=0;
			do {

				if(!player.title.equals("Bot")) {
				sum= input.nextInt();
				}else {
					if(player.getMoney()>inv[n-1]) {
						sum=inv[n-1];
					}else {
						break;
					}
					
					
				}
				if(sum==0)
					break;
			
			
			}while(sum<inv[n-1]);
			player.getCompany().add(companies.get(n-1));
			player.setMoney(player.getMoney()-sum);
			player.setInv(sum);
		}else {
			System.out.println("Нямаш пари");
		}
		
		
		
	}

	@Override
	List<Field> getField() {
		// TODO Auto-generated method stub
		return Invest;
	}

	

}
