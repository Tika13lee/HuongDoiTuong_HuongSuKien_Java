package tuan5_30_Country;

import java.io.Serializable;
import java.util.ArrayList;

public class ListCountry implements Serializable {
	private ArrayList<Country> ds;

	public ListCountry() {
		ds = new ArrayList<Country>();
	}

	public ArrayList<Country> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Country> ds) {
		this.ds = ds;
	}

	public boolean them(Country c) {
		if (ds.contains(c))
			return false;
		ds.add(c);
		return true;
	}

	public boolean xoa(String c) {
		Country country = new Country(c);
		int index = ds.indexOf(country);
		if (ds.contains(country)) {
			ds.remove(index);
			return true;
		}
		return false;
	}

	public boolean sua(Country c) {
		int index = ds.indexOf(c);
		if (index > 1) {
			ds.set(index, c);
			return true;
		}
		return false;
	}

	public Country tim(String c) {
		for (Country country : ds) {
			if (country.getCountry().equals(c))
				return country;
		}
		return null;
	}

	public Country getElement(int i) {
		if (i < 0 || i > ds.size())
			return null;
		return ds.get(i);
	}
}
