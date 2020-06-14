import java.util.Random;

public class Dice {

	private static Random random =new Random();
	
	
	public Dice() {
		
	}
	
	public static int rollDice(int number) {
		return random.nextInt(number)+1;
	}

}
