
public class Baby {

	private String name;
	private String famillyName;
	private int age;

	
	public Baby(String name,String famillyName,int age) {
		this.famillyName=famillyName;
		this.name=name;
		this.age=age;
		
		
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
	
	
	
	
	

}
