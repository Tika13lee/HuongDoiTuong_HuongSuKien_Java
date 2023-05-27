package tuan3_30_DemoJTree;

import java.util.Objects;

public class PhongBan {
	private String maPB;
	private String tenPB;
//	private int soNV;
	private ListNV dsNV;

	public PhongBan(String maPB, String tenPB) {
		super();
		this.maPB = maPB;
		this.tenPB = tenPB;
//		this.soNV = soNV;
		dsNV = new ListNV();
	}

	public PhongBan() {
		super();
		dsNV = new ListNV();
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}

//	public int getSoNV() {
//		return soNV;
//	}
//
//	public void setSoNV(int soNV) {
//		this.soNV = soNV;
//	}

	public ListNV getDsNV() {
		return dsNV;
	}

	public void setDsNV(ListNV dsNV) {
		this.dsNV = dsNV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(maPB, other.maPB);
	}

	@Override
	public String toString() {
		return tenPB;
	}
}
