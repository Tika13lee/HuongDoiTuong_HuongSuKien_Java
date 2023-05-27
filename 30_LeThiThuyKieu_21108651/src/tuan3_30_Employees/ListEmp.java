package tuan3_30_Employees;

import java.io.Serializable;
import java.util.ArrayList;

public class ListEmp implements Serializable {
	private ArrayList<Employee> ds;

	public ListEmp() {
		ds = new ArrayList<Employee>();
	}

	public ArrayList<Employee> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Employee> ds) {
		this.ds = ds;
	}

	// them
	public boolean them(Employee e) {
		if (ds.contains(e))
			return false;
		ds.add(e);
		return true;
	}

	//tim
	public Employee tim(String ma) {
		for (Employee employee : ds) {
			if (employee.getMaNV().equals(ma))
				return employee;
		}
		return null;
	}
	
	public Employee getEle(int i) {
		if(i > 0 || i<ds.size())
			return null;
		return ds.get(i);
	}
	
	//sua
	public boolean sua(Employee e) {
		int index = ds.indexOf(e);
		ds.set(index, e);
		return true;
	}
	
	//xoa
	public boolean xoa(Employee e) {
		if(ds.contains(e)) {
			ds.remove(e);
			return true;
		}
		return false;
	}
}
