package tuan4ThuyKieuSinhVien;

public class SinhVien {
	private int maSinhVien;
	private String hoTen;
	private float lyThuyet, thucHanh;
	
	public float diemTrungBinh() {
		return (lyThuyet + thucHanh)/2;
	}
 
	
	public SinhVien(int maSinhVien, String hoTen, float lyThuyet, float thucHanh) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.lyThuyet = lyThuyet;
		this.thucHanh = thucHanh;
	}
	public SinhVien() {
		super();
		this.maSinhVien = 0;
		this.hoTen = "";
		this.lyThuyet = 0;
		this.thucHanh = 0;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getLyThuyet() {
		return lyThuyet;
	}
	public void setLyThuyet(float lyThuyet) {
		this.lyThuyet = lyThuyet;
	}
	public float getThucHanh() {
		return thucHanh;
	}
	public void setThucHanh(float thucHanh) {
		this.thucHanh = thucHanh;
	}

	
	@Override
	public String toString() {
		String str="";
		str+= String.format("%-10d %-20s %15.2f %15.2f %15.2f", getMaSinhVien(), getHoTen(), getLyThuyet(), getThucHanh(), diemTrungBinh());
		return str;
	}
	
	
}
