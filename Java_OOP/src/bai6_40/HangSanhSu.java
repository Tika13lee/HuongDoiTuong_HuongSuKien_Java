package bai6_40;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa {
	private String nhaSX;
	private LocalDate ngayNhapKho;

	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSX, LocalDate ngayNhapKho)
			throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaSX(nhaSX);
		setNgayNhapKho(ngayNhapKho);
	}

	public HangSanhSu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNhaSX() {
		return nhaSX;
	}

	public void setNhaSX(String nhaSX) throws Exception {
		if (!nhaSX.equals(""))
			this.nhaSX = nhaSX;
		else
			throw new Exception("Error: Nha san xuat rong");
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if (ngayNhapKho.isBefore(LocalDate.now()))
			this.ngayNhapKho = ngayNhapKho;
		else
			this.ngayNhapKho = LocalDate.now();
	}

	public double tinhVAT() {
		return (soLuongTon * donGia + soLuongTon * donGia * 0.1);
	}

	public String danhGia() {
		if (soLuongTon > 50 && (LocalDate.now().getDayOfMonth() - ngayNhapKho.getDayOfMonth()) > 10)
			return "Ban cham";
		else
			return "";
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String str1 = ngayNhapKho.format(dtf);
		String str = String.format(" %-15s %-15s %,15.1f    %-15s", nhaSX, str1, tinhVAT(), danhGia());
		return super.toString() + str;
	}

}
