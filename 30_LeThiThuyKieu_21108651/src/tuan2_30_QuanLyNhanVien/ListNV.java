package tuan2_30_QuanLyNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class ListNV implements Serializable {
	private ArrayList<NhanVien> ds;

//	public ListNV() {
//		ds = new ArrayList();
//	}

	public ArrayList<NhanVien> getDs() {
		return ds;
	}

	public void setDs(ArrayList<NhanVien> ds) {
		this.ds = ds;
	}

	// them nv vao ds
	public boolean addNV(NhanVien nv) {
		if (!ds.contains(nv)) {
			ds.add(nv);
			return true;
		}
		return false;
	}

	// xoa nv khoi ds
	public boolean deleteNV(NhanVien nv) {
		if (ds.contains(nv)) {
			ds.remove(nv);
			return true;
		}
		return false;
	}

	// cap nhat nv trong ds
	public boolean updateNV(NhanVien nv) {
		int index = ds.indexOf(nv);
		if (index > 0) {
			ds.set(index, nv);
			return true;
		}
		return false;
	}

	public NhanVien searchNV(String ma) {
		for (NhanVien nv : ds) {
			if (nv.getMaNV().equals(ma))
				return nv;
		}
		return null;
	}

	public int getSize() {
		return ds.size();
	}

	// lay phan tu cua ds khi biet vi tri
	public NhanVien getElement(int index) {
		if (index < 0 || index >= ds.size())
			return null;
		else
			return (NhanVien) ds.get(index);
	}
}
