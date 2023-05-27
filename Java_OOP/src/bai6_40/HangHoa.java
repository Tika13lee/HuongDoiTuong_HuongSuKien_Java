package bai6_40;

import java.text.DecimalFormat;

public abstract class HangHoa {
	protected String maHang;
	protected String tenHang;
	protected double donGia;
	protected int soLuongTon;

	public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) throws Exception {
		super();
		if (!maHang.equals(""))
			this.maHang = maHang;
		setTenHang(tenHang);
		setDonGia(donGia);
		setsoLuongTon(soLuongTon);
	}

	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHang() {
		return maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (!tenHang.equals(""))
			this.tenHang = tenHang;
		else
			this.tenHang = "xxx";
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia >= 0)
			this.donGia = donGia;
		else
			throw new Exception("Error: Don gia phai lon hon 0");
	}

	public int getsoLuongTon() {
		return soLuongTon;
	}

	public void setsoLuongTon(int soLuongTon) throws Exception {
		if (soLuongTon >= 0)
			this.soLuongTon = soLuongTon;
		else
			throw new Exception("Error: So luong phai lon hon 0");
	}

	public abstract double tinhVAT();

	public abstract String danhGia();

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###,###.0");
		String str1 = df.format(donGia);
		String str = String.format("%-15s %-15s %15s    %-15d", maHang, tenHang, str1, soLuongTon);
		return str;
	}

}
