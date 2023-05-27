package tuan3_30_Employees;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable{
	private String maNV;
	private String hoTen;
	private int tuoi;
	private String phongBan;

	public Employee(String maNV, String hoTen, int tuoi, String phongBan) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.phongBan = phongBan;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Employee(String ma) {
//		this.maNV = maNV;
//		// TODO Auto-generated constructor stub
//	}
	
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) throws Exception {
		if(!maNV.equals(""))
			this.maNV = maNV;
		throw new Exception("Error: Rong");
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if(!hoTen.equals(""))
			this.hoTen = hoTen;
		throw new Exception("Error: Rong");
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		if(tuoi > 0)
			this.tuoi = tuoi;
		this.tuoi = 0;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) throws Exception {
		if(!phongBan.equals(""))
			this.phongBan = phongBan;
		throw new Exception("Error: Rong");
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "Employee [maNV=" + maNV + ", hoTen=" + hoTen + ", tuoi=" + tuoi + ", phongBan=" + phongBan + "]";
	}
	
}
