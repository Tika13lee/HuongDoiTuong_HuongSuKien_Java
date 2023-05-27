package tuan8_30_QLNV;

import java.util.Objects;

public class NhanVien {
	private int maNV;
	private String ho;
	private String ten;
	private int tuoi;
	private boolean phai;
	private double tienLuong;
	private PhongBan phong;

//	private Date ns;

	public NhanVien(int maNV, String ho, String ten, int tuoi, boolean phai, double tienLuong, PhongBan phong) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.phai = phai;
		this.tienLuong = tienLuong;
		this.phong = phong;
	}

	public NhanVien(int maNV) {
		this.maNV = maNV;
	}

//	public NhanVien(int maNV, String ho, String ten, int tuoi, boolean phai, double tienLuong, PhongBan phong,
//			Date ns) {
//		super();
//		this.maNV = maNV;
//		this.ho = ho;
//		this.ten = ten;
//		this.tuoi = tuoi;
//		this.phai = phai;
//		this.tienLuong = tienLuong;
//		this.phong = phong;
//		this.ns = ns;
//	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}

	public PhongBan getPhong() {
		return phong;
	}

	public void setPhong(PhongBan phong) {
		this.phong = phong;
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
		NhanVien other = (NhanVien) obj;
		return maNV == other.maNV;
	}

//	@Override
//	public String toString() {
//		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", phai=" + phai
//				+ ", tienLuong=" + tienLuong + ", phong=" + phong + ", ns=" + ns + "]";
//	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", phai=" + phai
				+ ", tienLuong=" + tienLuong + ", phong=" + phong + "]";
	}

}
