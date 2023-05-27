package tuan3_30_DemoJTree;

import java.util.ArrayList;

public class ListNV {
	private ArrayList<NhanVien> dsNV;

	public ListNV() {
		dsNV = new ArrayList<NhanVien>();
	}

	// them nhan vien vao dsNV
//	public void themNV(String maNV, String ho, String ten, String maPB, boolean phai, int tuoi, double tienLuong) {
//		dsNV.add(new NhanVien(maNV, ho, ten, maPB, phai, tuoi, tienLuong));
//	}

	public ArrayList<NhanVien> getDsNV() {
		return dsNV;
	}

	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}

	public boolean themNV(NhanVien nv) {
		if (!dsNV.contains(nv)) {
			dsNV.add(nv);
			return true;
		}
		return false;
	}

	public int getSize() {
		return dsNV.size();
	}

	// lay 1 nhan vien khi biet vi tri
	public NhanVien getElement(int index) {
		if (index < 0 || index >= dsNV.size())
			return null;
		return dsNV.get(index);
	}
}
