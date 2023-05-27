package bai6_48;

public class ThiNghiem extends PhongHoc {
	private String chuyenNganh;
	private String sucChua;
	private boolean bonRua;

	public ThiNghiem(String maPhong, String dayNha, float dienTich, int soDen, String chuyenNganh, String sucChua,
			boolean bonRua) throws Exception {
		super(maPhong, dayNha, dienTich, soDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}

	public ThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public String getSucChua() {
		return sucChua;
	}

	public void setSucChua(String sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}
	
	public boolean datChuan() {
		if (dienTich/soDen <= 10 && bonRua == true)
			return true;
		return false;
	}

	@Override
	public String toString() {
		String str = String.format(" %-15s %-15s %-15s %-15s %-15s", null, null, chuyenNganh, sucChua, bonRua);
		return super.toString() + str;
	};
	
}
