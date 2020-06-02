
public class Trudejt extends Grajdanin{

	
	private float zaplata;
	
	
	public Trudejt(String name, String famillyName, int age, String adress, String phoneNumber, String gender,float zaplata) {
		super(name, famillyName, age, adress, phoneNumber, gender);
		this.zaplata=zaplata;
	}


	public float getZaplata() {
		return zaplata;
	}


	public void setZaplata(float zaplata) {
		this.zaplata = zaplata;
	}

	
	

	

}
