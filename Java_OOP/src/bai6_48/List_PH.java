package bai6_48;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class List_PH {
	ArrayList<PhongHoc> ds = new ArrayList<PhongHoc>();
	
//	public List_PH() {
//		ds = new ArrayList<PhongHoc>();
//	}

	public ArrayList<PhongHoc> getDs() {
		return ds;
	}

	public void setDs(ArrayList<PhongHoc> ds) {
		this.ds = ds;
	}
	
	public boolean checkMa(String ma) {
		for (PhongHoc p : ds) {
			if(p.maPhong.equals(ma))
				return true;
		}
		return false;
	}

	public void them(PhongHoc p) throws Exception {
		if(checkMa(p.maPhong) == false)
			ds.add(p);
		else
			throw new Exception("Trung ma");
	}
	
	public PhongHoc search(String ma) {
		for (PhongHoc p : ds) {
			if(p.maPhong.equals(ma))
				return p;
		}
		return null;
	}
	
	public boolean delete(String ma) {
		for (PhongHoc p : ds)
			if(p.maPhong.equals(ma)) {
				ds.remove(p);
				return true;
			}
		return false;
	}
	
	public void sort_DayNha() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.dayNha.compareToIgnoreCase(o2.dayNha);
			}
		});
	}
	
	public void sort_DT() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.dienTich > o2.dienTich ? -1 : 1;
			}
		});
	}
	
	public void sort_Den() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.soDen < o2.soDen ? -1 : 1;
			}
		});
	}
	
	public int tongPH() {
		return ds.size();
	}
	
	public ArrayList<PhongHoc> phDatChuan(){
		ArrayList<PhongHoc> phDC = new ArrayList<PhongHoc>();
		for (PhongHoc ph : ds) {
			if(ph.datChuan())
				phDC.add(ph);
		}
		return phDC;
	}
	
	public int viTri(String ma) {
		PhongHoc p = search(ma);
		if(p != null)
			return ds.indexOf(p);
		return -1;
	}
	
	public void sua(PhongHoc p) {
		int vt = viTri(p.getMaPhong());
		if(vt != -1)
			ds.set(vt, p);
	}
	
	public ArrayList<PhongHoc> getMayTinh(){
		ArrayList<PhongHoc> dsMayTinh = new ArrayList<PhongHoc>();
		for (PhongHoc p : ds) {
			if(p instanceof MayTinh)
				dsMayTinh.add(p);
		}
		return dsMayTinh;
	}
	
	public ArrayList<PhongHoc> getPM60(){
		ArrayList<PhongHoc> dsPM60 = new ArrayList<PhongHoc>();
		for (PhongHoc p : ds) {
			if(p instanceof MayTinh) {
				if(((MayTinh) p).getSoMayTinh() == 60)
						dsPM60.add(p);
			}
		}
		return dsPM60;
	}
}