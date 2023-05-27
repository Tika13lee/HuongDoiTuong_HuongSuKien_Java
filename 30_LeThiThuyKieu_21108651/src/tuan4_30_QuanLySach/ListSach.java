package tuan4_30_QuanLySach;

import java.util.ArrayList;

public class ListSach {
	private ArrayList<Sach> ds;

	public ListSach() {
		ds = new ArrayList<Sach>();
	}

	public ArrayList<Sach> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Sach> ds) {
		this.ds = ds;
	}

	// thêm 1 cuốn sách vào ds
	public boolean them(Sach s) {
		if (ds.contains(s))
			return false;
		ds.add(s);
		return true;
	}

	// xóa 1 cuốn sách khỏi ds
	public boolean xoa(Sach s) {
		if (ds.contains(s)) {
			ds.remove(s);
			return true;
		}
		return false;
	}

	// xóa 1 cuốn sách khi biết index
	public boolean xoa(int index) {
		if (index >= 0 || index < ds.size()) {
			ds.remove(index);
			return true;
		}
		return false;
	}

	// tìm 1 cuốn sách khi biết mã sách
	public Sach timKiem(String ma) {
		Sach s = new Sach(ma);
		if (ds.contains(s))
//			return s;
			return ds.get(ds.indexOf(s));
		return null;
	}

	// cập nhật thông tin cuốn sách khi biết mã sách
	// không được phép cập nhật mã sách
	public boolean capNhatSach(String maSachOld, Sach sachNew) {
		Sach sachOld = new Sach(maSachOld);
		if (ds.contains(sachOld)) {
			sachOld = ds.get(ds.indexOf(sachOld));
			sachOld.setTuaSach(sachNew.getTuaSach());
			sachOld.setTacGia(sachNew.getTacGia());
			sachOld.setNamXB(sachNew.getNamXB());
			sachOld.setNhaXB(sachNew.getNhaXB());
			sachOld.setSoTrang(sachNew.getSoTrang());
			sachOld.setDonGia(sachNew.getDonGia());
			sachOld.setIsbn(sachNew.getIsbn());
			return true;
		}
		return false;
	}

	public Sach getElement(int index) {
		if (index < 0 || index >= ds.size())
			return null;
		else
			return ds.get(index);
	}
}
