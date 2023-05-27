package tuan9_30_QLCauThu;

public class ViTriThiDau {
	private String maViTri;
	private String tenViTri;

	public ViTriThiDau(String maViTri, String tenViTri) {
		super();
		this.maViTri = maViTri;
		this.tenViTri = tenViTri;
	}

	public ViTriThiDau(String maViTri) {
		this.maViTri = maViTri;
	}

	public ViTriThiDau() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMaViTri() {
		return maViTri;
	}

	public void setMaViTri(String maViTri) {
		this.maViTri = maViTri;
	}

	public String getTenViTri() {
		return tenViTri;
	}

	public void setTenViTri(String tenViTri) {
		this.tenViTri = tenViTri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maViTri == null) ? 0 : maViTri.hashCode());
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
		ViTriThiDau other = (ViTriThiDau) obj;
		if (maViTri == null) {
			if (other.maViTri != null)
				return false;
		} else if (!maViTri.equals(other.maViTri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViTriThiDau [maViTri=" + maViTri + ", tenViTri=" + tenViTri + "]";
	}

}
