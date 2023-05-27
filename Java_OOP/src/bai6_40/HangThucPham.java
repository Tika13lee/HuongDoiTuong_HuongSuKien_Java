package bai6_40;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
	private String nhaCC;
	private LocalDate ngaySX;
	private LocalDate ngayHetHan;

	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCC, LocalDate ngaySX,
			LocalDate ngayHetHan) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaCC(nhaCC);
		setNgaySX(ngaySX);
		setNgayHetHan(ngayHetHan);
	}

	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(String nhaCC) throws Exception {
		if (!nhaCC.equals(""))
			this.nhaCC = nhaCC;
		else
			throw new Exception("Error: Nha cung cap rong");
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		if (ngaySX.isBefore(LocalDate.now()))
			this.ngaySX = ngaySX;
		else
			this.ngaySX = LocalDate.now();
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan.isAfter(ngaySX))
			this.ngayHetHan = ngayHetHan;
		else
			this.ngayHetHan = ngaySX;
	}

	public boolean hetHan() {
		return (ngayHetHan.isAfter(LocalDate.now())) ? false : true;
	}

	public double tinhVAT() {
		return (soLuongTon * donGia + soLuongTon * donGia * 0.05);
	}

	public String danhGia() {
		if (soLuongTon > 0 && hetHan() == true)
			return "Kho ban";
		return "";
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String str1 = ngaySX.format(dtf);
		String str2 = ngayHetHan.format(dtf);
		String str = String.format(" %-15s %-15s %-15s %,15.1f    %-15s", nhaCC, str1, str2, tinhVAT(), danhGia());
		return super.toString() + str;
	}

}