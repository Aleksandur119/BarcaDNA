import java.util.ArrayList;

public class Positions {
	static ArrayList<Integer> positions =new ArrayList<Integer>();
	static boolean flag=false;
	public Positions() {
		if(!flag) {
		positions.add(0);
		positions.add(1);
		positions.add(3);
		positions.add(4);
		flag=true;
		}
	}
	
}
