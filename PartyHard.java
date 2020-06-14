import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class PartyHard extends Field{
	private static List<Field> partyHard =new ArrayList<Field>();

	public PartyHard(Insets location) {
		super(location);
		partyHard.add(this);
	}


	

	public PartyHard() {
		// TODO Auto-generated constructor stub
	}




	@Override
	List<Field> getField() {
		// TODO Auto-generated method stub
		return partyHard;
	}


	@Override
	void execute(Player current) {
	System.out.println("Бахте на парти губите 25 парички");
		current.setMoney(current.getMoney()-25);
		
	}

}
