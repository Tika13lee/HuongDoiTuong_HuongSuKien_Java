package bai6_48;

public abstract class PhongHoc {
	public String maPhong;
	public String dayNha;
	public float dienTich;
	public int soDen;

	public PhongHoc(String maPhong, String dayNha, float dienTich, int soDen) throws Exception {
		super();
		setMaPhong(maPhong);
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSoDen(soDen);
	}

	public PhongHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) throws Exception {
		if (!maPhong.equals(""))
			this.maPhong = maPhong;
		else
			throw new Exception("Ma rong");
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) throws Exception {
		if (!dayNha.equals(""))
			this.dayNha = dayNha;
		else
			throw new Exception("Day nha rong");
	}

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) {
		if (dienTich > 0)
			this.dienTich = dienTich;
		else
			this.dienTich = 0;
	}

	public int getSoDen() {
		return soDen;
	}

	public void setSoDen(int soDen) {
		if (soDen > 0)
			this.soDen = soDen;
		else
			this.soDen = 0;
	}

	public abstract boolean datChuan();

	@Override
	public String toString() {
		String str = String.format("%-15s %-15s %-15.1f %-15d", maPhong, dayNha, dienTich, soDen);
		return str;
	}
}
