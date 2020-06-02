import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private static final String filePath = "citizenInfomation.txt";

	public static void main(String[] a) throws FileNotFoundException {
		openFile();
		
		
		menu();
		
		
		
	}
	
	public static void decode(String line) {
		
		if(line.equals("SELECT")) {
			selectAll();
			return;
		}
		
		if(line.toLowerCase().contains("type")&&!line.toLowerCase().contains("@")) {
			selectType( line.substring(14, 15));
		}else if(line.toLowerCase().contains("SPECIAL_PROPERTY".toLowerCase())) {
			getAllKidsWithSpecificName(regexBuilder(line,"KFNAME}=[\\[](\\w{0,})[\\]]",1));
			
		}else if(line.toLowerCase().contains("AGE".toLowerCase())) {
			age(regexBuilder(line,"[\\[](\\d{0,})[\\]]",1));
			
		}
		
		
	}
	
	public static void  menu() {
		String line ;
		
		Scanner s =new Scanner(System.in);
		
		
		System.out.println("Enter:");
		line =s.nextLine();
		
		decode(line);
		
		s.close();
		
		
		
	}
	
	
	public static void femalePensioeri(String type,String gender) {
		for(int i=0;i<p.size();i++) {
			
			if(p.get(i) instanceof Pensioner&&p.get(i).getGender()==gender) {
				Pensioner m =(Pensioner)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress()+"|"+m.getPensia1());
			}
		}
	}
	
	public static void getAllKidsWithSpecificName(String name) {
		for(int i=0;i<p.size();i++) {
			if(p.get(i) instanceof Majka) {
				Majka m =(Majka)p.get(i);
				boolean flag=false;
						for(int j=0;j<m.getBabies().size();j++) {
								if(m.getBabyName(j).equals(name)) {
							
							flag=true;
							}
							
						}
						if(flag) {
							System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
									+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress());
						for(int j=0;j<m.getBabies().size();j++) {
							System.out.println((j+1)+"."+m.getBabyName(j)+"|"+m.getBabyFamillyName(j)+"|"+m.getBabyAge(j));
							
						}
					}
						
			}
		}
	}
	
	public static void age(String age) {
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getAge()==Integer.parseInt(age))
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
					+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress());
			
		}
		
		
	}
	public static void searchByName(String firstName) {
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getName()==firstName)
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
					+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress());
			
		}
		
		
	}
	
	
	public static void selectType(String type) {
		for(int i=0;i<p.size();i++) {
			if(p.get(i) instanceof Majka&&type.equals("M")) {
				Majka m =(Majka)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress());
				System.out.println("---------KIDS---------");
				
				
			
				for(int j=0;j<m.getBabies().size();j++) {
					System.out.println((j+1)+"."+m.getBabyName(j)+"|"+m.getBabyFamillyName(j)+"|"+m.getBabyAge(j));
					
				}
			
			}else if(p.get(i) instanceof Pensioner&&type.equals("P")) {
			
				Pensioner m =(Pensioner)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress()+"|"+m.getPensia1());
			
			}else if(p.get(i) instanceof Trudejt&&type.equals("W")) {
				Trudejt m =(Trudejt)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress()+"|"+m.getZaplata());
			}
		
			if(i<p.size()-1)
			System.out.println("------------------");
			
		}
			
		
		
	}
	
	
	public static void selectAll() {
		for(int i=0;i<p.size();i++) {
			
			if(p.get(i) instanceof Majka) {
				Majka m =(Majka)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress());
				System.out.println("---------KIDS---------");
				
				
			
				for(int j=0;j<m.getBabies().size();j++) {
					System.out.println((j+1)+"."+m.getBabyName(j)+"|"+m.getBabyFamillyName(j)+"|"+m.getBabyAge(j));
					
				}
			
			}else if(p.get(i) instanceof Pensioner) {
			
				Pensioner m =(Pensioner)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress()+"|"+m.getPensia1());
			
			}else if(p.get(i) instanceof Trudejt) {
				Trudejt m =(Trudejt)p.get(i);
				System.out.println(p.get(i).getName()+"|"+p.get(i).getFamillyName()+"|"+p.get(i).getAge()+"|"+p.get(i).getGender()+"|"
						+p.get(i).getPhoneNumber()+"|"+p.get(i).getAdress()+"|"+m.getZaplata());
			}
		
			if(i<p.size()-1)
			System.out.println("------------------");
			
		}
		
	}

	private static List<Grajdanin> p = new ArrayList<Grajdanin>();
	

//=\s{0,}[[](.*?)[]]
public static void openFile() throws FileNotFoundException {
	Scanner s =new Scanner(new File(filePath));
	
	while(s.hasNext()) {
		String line;
		line =s.nextLine();
		
		List<String> l =regex(line,"=\\s{0,}[\\[](.*?)[\\]]",1);
		
		
		
	
		
		
		
		Grajdanin g;
		
		if(l.get(0).equals("R")) {
			String special =regexBuilder(line,"[{]PENSION[}]=[\\[](\\d{0,})[\\]]", 1);
			
			
			
			g=new Pensioner(l.get(1),l.get(2),Integer.parseInt(l.get(3)),l.get(4),l.get(5),l.get(6),Integer.parseInt(special));
			p.add(g);
		}
		if(l.get(0).equals("W")) {
			String special =regexBuilder(line,"[{]SALARY[}]=[\\[](\\d{0,})[\\]]", 1);
			g=new Trudejt(l.get(1),l.get(2),Integer.parseInt(l.get(3)),l.get(4),l.get(5),l.get(6),Float.parseFloat(special));
			p.add(g);
		}
		if(l.get(0).equals("M")) {
			
			String special =regexBuilder(line,"[{]KID[}]=(.*?)$", 1);
			
			
			List<String> baby =regex(special,"[\\[](\\d{0,}\\w{0,})[\\]]",1);
			Majka m=new Majka(l.get(1),l.get(2),Integer.parseInt(l.get(3)),l.get(4),l.get(5),l.get(6));
			
			
			
			for(int i=0;i<baby.size() ;i+=3) {
				
				m.addBaby(new Baby(baby.get(i),baby.get(i+1),Integer.parseInt(baby.get(i+2))));
			}
			p.add(m);
		}
		
	}
	
	
		
	
	
	
	s.close();
	
	
}
//[[]\d{0,}\w{0,}[]]

//{KID}=(.*?)

//{PENSION}=[[](\d{0,})[]]


public static String regexBuilder(String rawData, String regex, int group) {
	String url = "";

	Pattern p2 = Pattern.compile(regex);
	Matcher m2 = p2.matcher(rawData);

	if (m2.find()) {
		url = (m2.group(group));
	}
	return url;
}


private static List<String> regex(String rawData, String regex, int group) {
	List<String> url = new ArrayList<String>();

	Pattern p2 = Pattern.compile(regex);
	Matcher m2 = p2.matcher(rawData);
	
	while(m2.find()) {
		url.add(m2.group(group));	
	}
	return url;
}

}
