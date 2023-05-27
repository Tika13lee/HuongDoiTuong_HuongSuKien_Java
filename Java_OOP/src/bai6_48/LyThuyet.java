package bai6_48;

public class LyThuyet extends PhongHoc{
	public enum enum_MC {
		CO, KHONG;
	}

	private enum_MC mayChieu;

	public LyThuyet(String maPhong, String dayNha, float dienTich, int soDen, enum_MC mayChieu) throws Exception {
		super(maPhong, dayNha, dienTich, soDen);
		this.mayChieu = mayChieu;
	}

	public LyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public enum_MC getMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(enum_MC mayChieu) {
		this.mayChieu = mayChieu;
	}

	public boolean datChuan() {
		if(dienTich/soDen <= 10 && mayChieu == enum_MC.CO)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String str = String.format(" %-15s %-15s %-15s %-15s %-15s", mayChieu, null, null, null, null, null);
		return super.toString() + str;
	}
}
