import java.util.ArrayList;
import java.util.List;

public class Chance extends Field{
	private static List<Field> chance =new ArrayList<Field>();
	
	
	private final String[] positive= {"Осиновявате група сирачета, за да си вдигнете социалното реноме. \n" + 
			"Социалните мрежи са във възторг, получавате окуражителни дарения от обществото. +50 парички \n"
			,"Хващате си младо гадже, малка котка с големи възможности. \nПолучавате вечното уважение на "
					+ "кварталните пичове, както и легендарен \nстатус на вечен играч +100 парички"
					,"Напускате университета и ставате милионер. Честито! +150 парички",
					"Тийнейджъри представят гениална идея за рационализиране на \n" + 
					"производствените мощности. 	Получавате стабилен бонус. +200 парички",
					"Наемате джудже за личен асистент, обществото е "
					+ "\nуверено че междувидовата сегрегация е в историята. "
					+ "\nУважението към вас е безгранично. +250 парички "};
					
	private final String[] negative= {"Вдигате толкова голям купон, че не знаете къде се "
			+ "\nнамирате на следващата седмица."
			+ "\n С мъка установявате, че телевизорът Ви е откраднат.  -50 парички",
			"Вие сте баща на три абитуриентки, бъдете готови за стабилни разходи. -100 парички",
			"Най-добрият Ви служител получава повиквателна за казармата. Губите обучен персонал. - 150 парички",
			"На връщане от супермаркета, чудовище се опитва да ви изяде. "
			+ "\nСправяте се с неприятеля, използвайки карате, но се налага да пишете обяснения, "
			+ "\nкоито водят до пропускане на важна среща и загуба на бизнес партньор. - 200 парички",
			"Част от бизнесите Ви фалират, заради задаваща се епидемия от потна треска. - 250 парички"};
	
public Chance() {}
	

	public Chance(Insets location) {
		super(location);
		chance.add(this);
	}

	@Override
	void execute(Player player) {
		
		int dice =Dice.rollDice(10);
		int chance =Dice.rollDice(100);
		
		
		if(chance>=1&&chance<=39) {
			chanceCard(dice,0,player);
		}else if(chance>=40&&chance<65) {
			chanceCard(dice,1,player);
		}else if(chance>=65&&chance<=79) {
			chanceCard(dice,2,player);
		}else if(chance>=80&&chance<=94) {
			chanceCard(dice,3,player);
		}else if(chance>=95&&chance<=100) {
			chanceCard(dice,4,player);
		}
		
		
	}
	
	private void chanceCard(int dice,int number,Player player) {
	if(player.getEvilPlan()==0) {
		player.setMoney(player.getMoney()+100);
		System.out.println("Получихте 100 парички");
	}
		
	if(player.getTrap()[4]==0) {
		System.out.println(negative[number]);
		player.setMoney(player.getMoney()-(number+1)*50);
		player.getTrap()[4]=-1;
		return;
	}
		
		if(dice%2==0) {
		System.out.println(positive[number]);
		player.setMoney(player.getMoney()+(number+1)*50);
	}else {
		System.out.println(negative[number]);
		player.setMoney(player.getMoney()-(number+1)*50);
	}
		
		
	}

	@Override
	List<Field> getField() {
		// TODO Auto-generated method stub
		return chance;
	}

	

}
