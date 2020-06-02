import java.util.ArrayList;
import java.util.List;

public class Majka extends Grajdanin{

	
	private List<Baby> babies =new ArrayList<Baby>();
	
	
	public Majka(String name, String famillyName, int age, String adress, String phoneNumber, String gender) {
		super(name, famillyName, age, adress, phoneNumber, gender);
		
	}


	public List<Baby> getBabies() {
		return babies;
	}
	
	public void addBaby(Baby baby) {
		babies.add(baby);
	}
	
	public String getBabyName(int index) {
		return babies.get(index).getName();
		
	}
	
	public int getBabyAge(int index) {
		return babies.get(index).getAge();
		
	}
	public String getBabyFamillyName(int index) {
		return babies.get(index).getFamillyName();
	}
	
	
	
}
