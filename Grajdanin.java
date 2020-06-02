
abstract class Grajdanin {

	
	private String name;
	private String famillyName;
	private int age;
	private String adress;
	private String phoneNumber;
	private String gender;
	
	public Grajdanin(String name,String famillyName,int age, String adress,String phoneNumber,String gender) {
		this.name=name;
		this.famillyName=famillyName;
		this.age=age;
		this.adress=adress;
		this.phoneNumber=phoneNumber;
		this.gender=gender;
		
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamillyName() {
		return famillyName;
	}
	public void setFamillyName(String famillyName) {
		this.famillyName = famillyName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
}
