
public class Pensioner  extends Grajdanin{

	private int pensia1;
	
	
	public Pensioner(String name, String famillyName, int age, String adress, String phoneNumber, String gender,int pensia1) {
		super(name, famillyName, age, adress, phoneNumber, gender);
		this.pensia1=pensia1;
		
	}
	
	public int getPensia1() {
		return pensia1;
	}


	public void setPensia1(int pensia1) {
		this.pensia1 = pensia1;
	}


	
	
	
	

}
