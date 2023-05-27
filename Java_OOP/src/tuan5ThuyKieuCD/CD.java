package tuan5ThuyKieuCD;

public class CD {
	private int maCD, soBH;
	private String tuaCD;
	private double giaThanh;
	public CD(int maCD, int soBH, String tuaCD, double giaThanh) {
		super();
		this.maCD = maCD;
		this.soBH = soBH;
		this.tuaCD = tuaCD;
		this.giaThanh = giaThanh;
	}
	public CD() {
		super();
	}
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		if(maCD > 0)
			this.maCD = maCD;
		else
			this.maCD = 999999;
	}
	public int getSoBH() {
		return soBH;
	}
	public void setSoBH(int soBH) throws Exception {
		if(soBH > 0)
			this.soBH = soBH;
		else
			throw new Exception("So bai hat phai lon hon 0"); 
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		if(!tuaCD.equals(" "))
			this.tuaCD = tuaCD;
		else 
			this.tuaCD = "chua xac dinh";
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) {
		this.giaThanh = giaThanh;
	}
	@Override
	public String toString() {
		String str = String.format("%-10d %-10d %-30s %,15.2f", maCD, soBH, tuaCD, giaThanh);
		return str;
	}
}
