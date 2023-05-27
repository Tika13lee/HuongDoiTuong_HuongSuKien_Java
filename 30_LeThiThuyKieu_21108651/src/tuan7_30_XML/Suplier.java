package tuan7_30_XML;

public class Suplier {
	private String suplierName;
	private String country;
	private String website;

	public Suplier(String suplierName, String country, String website) {
		super();
		this.suplierName = suplierName;
		this.country = country;
		this.website = website;
	}

	public Suplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suplier(String suplierName) {
		this.suplierName = suplierName;
	}

	public String getSuplierName() {
		return suplierName;
	}

	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suplierName == null) ? 0 : suplierName.hashCode());
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
		Suplier other = (Suplier) obj;
		if (suplierName == null) {
			if (other.suplierName != null)
				return false;
		} else if (!suplierName.equals(other.suplierName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Suplier [suplierName=" + suplierName + ", country=" + country + ", website=" + website + "]";
	}

}
