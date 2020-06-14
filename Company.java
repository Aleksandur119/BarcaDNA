
public class Company {
String companyName;
int inv;
float k;
int min, max;
	public Company(String companyName, int inv, float k, int min, int max) {
		this.companyName=companyName;
		this.inv=inv;
		this.k=k;
		this.min=min;
		this.max=max;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getInv() {
		return inv;
	}
	public void setInv(int inv) {
		this.inv = inv;
	}
	public float getK() {
		return k;
	}
	public void setK(float k) {
		this.k = k;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

}
