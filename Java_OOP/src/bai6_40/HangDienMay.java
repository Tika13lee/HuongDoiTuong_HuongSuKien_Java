package bai6_40;

public class HangDienMay extends HangHoa {
	private int tgBaoHanh;
	private double congSuat;

	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int tgBaoHanh, double congSuat)
			throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setTgBaoHanh(tgBaoHanh);
		setCongSuat(congSuat);
	}

	public HangDienMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTgBaoHanh() {
		return tgBaoHanh;
	}

	public void setTgBaoHanh(int tgBaoHanh) throws Exception {
		if (tgBaoHanh >= 0)
			this.tgBaoHanh = tgBaoHanh;
		else
			throw new Exception("Error: Thoi gian bao hanh lon hon hoac bang 0");
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) throws Exception {
		if (congSuat >= 0)
			this.congSuat = congSuat;
		else
			throw new Exception("Error: Cong suat lon hon hoac bang 0");
	}

	public double tinhVAT() {
		return (soLuongTon * donGia + soLuongTon * donGia * 0.1);
	}

	public String danhGia() {
		if (soLuongTon < 3)
			return "Ban duoc";
		return "";
	}

	@Override
	public String toString() {
		String str = String.format(" %-15d %-15.1f %,15.1f    %-15s", tgBaoHanh, congSuat, tinhVAT(), danhGia());
		return super.toString() + str;
	}

}
