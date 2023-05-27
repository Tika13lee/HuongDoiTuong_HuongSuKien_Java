package bai6_48;

public class MayTinh extends PhongHoc{
	private int soMayTinh;

	public MayTinh(String maPhong, String dayNha, float dienTich, int soDen, int soMayTinh) throws Exception {
		super(maPhong, dayNha, dienTich, soDen);
		setSoMayTinh(soMayTinh);
	}

	public MayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		if(soMayTinh > 0)
			this.soMayTinh = soMayTinh;
		else
			this.soMayTinh = 0;
	}

	public boolean datChuan() {
		if(dienTich/soDen <= 10 && dienTich/soMayTinh >= 1.5)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String str = String.format(" %-15s %-15d %-15s %-15s %-15s", null, soMayTinh, null, null, null);
		return super.toString() + str;
	}
}
