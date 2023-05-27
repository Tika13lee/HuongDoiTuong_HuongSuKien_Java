package tuan9_30_QLCauThu;

public class CauThu {
	private String maCauThu;
	private String tenCauThu;
	private int tuoi;
	private ViTriThiDau viTri;

	public CauThu(String maCauThu, String tenCauThu, int tuoi, ViTriThiDau viTri) {
		super();
		this.maCauThu = maCauThu;
		this.tenCauThu = tenCauThu;
		this.tuoi = tuoi;
		this.viTri = viTri;
	}

	public CauThu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaCauThu() {
		return maCauThu;
	}

	public void setMaCauThu(String maCauThu) {
		this.maCauThu = maCauThu;
	}

	public String getTenCauThu() {
		return tenCauThu;
	}

	public void setTenCauThu(String tenCauThu) {
		this.tenCauThu = tenCauThu;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public ViTriThiDau getViTri() {
		return viTri;
	}

	public void setViTri(ViTriThiDau viTri) {
		this.viTri = viTri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCauThu == null) ? 0 : maCauThu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CauThu other = (CauThu) obj;
		if (maCauThu == null) {
			if (other.maCauThu != null)
				return false;
		} else if (!maCauThu.equals(other.maCauThu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CauThu [maCauThu=" + maCauThu + ", tenCauThu=" + tenCauThu + ", tuoi=" + tuoi + ", viTri=" + viTri
				+ "]";
	}

	
}
