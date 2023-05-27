package tuan5_30_Country;

import java.io.Serializable;
import java.util.Objects;

public class Country implements Serializable{
	private String country;
	private String capital;
	private int pop;
	private boolean democracy;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String country, String capital, int pop, boolean democracy) {
		super();
		this.country = country;
		this.capital = capital;
		this.pop = pop;
		this.democracy = democracy;
	}

	public Country(String c) {
		this.country = c;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) throws Exception {
		if (!country.equals(""))
			this.country = country;
		throw new Exception("Error: Rong");
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) throws Exception {
		if (!capital.equals(""))
			this.capital = capital;
		throw new Exception("Error: Rong");
	}

	public int getPop() {
		return pop;
	}

	public void setPop(int pop) {
		if (pop > 0)
			this.pop = pop;
		this.pop = 0;
	}

	public boolean isDemocracy() {
		return democracy;
	}

	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(country, other.country);
	}

	public String toString() {
		return "Country [country=" + country + ", capital=" + capital + ", pop=" + pop + ", democracy=" + democracy
				+ "]";
	}

}
