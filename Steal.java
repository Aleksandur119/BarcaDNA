import java.util.ArrayList;
import java.util.List;

public class Steal extends Field{
	private static List<Field> steal =new ArrayList<Field>();

	
	private String stealOptions[]= {"+100 парички всеки път, когато попаднете на квадратче „Шанс“.",
			"+100 парички всеки път, когато попаднете на квадратче „Invest“",
			"+100 парички всеки път, когато попаднем на квадратче „Steal“."};
	
	
	public Steal() {
		
	}

	public Steal(Insets location) {
		super(location);
		steal.add(this);
	}
	
	@Override
	void execute(Player player) {
		if(player.getEvilPlan()==2) {
			player.setMoney(player.getMoney()+100);
		System.out.println("Получихте 100 парички");
		}
		
		if(player.getTrap()[3]==0) {
			System.out.println("Заложен ти е капан не можеш да изплозваш това поле");
		
			player.getTrap()[3]=-1;
			return;
		}
		
		if(isFree()&&!player.isEvilPlan()) {
			player.setEvilPlan(true);
			System.out.println(stealOptions[player.getEvilPlan()-1]);
		}else {
			System.out.println("Вече това полето е заето");
		}
		
	}

	@Override
	List<Field> getField() {
		// TODO Auto-generated method stub
		return steal;
	}

}
