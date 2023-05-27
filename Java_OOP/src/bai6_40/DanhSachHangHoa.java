package bai6_40;

import java.util.ArrayList;

public class DanhSachHangHoa {
	private ArrayList<HangHoa> ds;

	public DanhSachHangHoa() {
		ds = new ArrayList<HangHoa>();
	}

	public ArrayList<HangHoa> getDs() {
		return ds;
	}

	public void setDs(ArrayList<HangHoa> ds) {
		this.ds = ds;
	}

	public DanhSachHangHoa(ArrayList<HangHoa> ds) {
		super();
		this.ds = ds;
	}

	public boolean checkMa(String ma) {
		for (HangHoa h : ds) {
			if (h.maHang.equals(ma))
				return true;
		}
		return false;
	}

	public void them(HangHoa h) throws Exception {
		if (!checkMa(h.maHang))
			ds.add(h);
		else
			throw new Exception("Error: Trung ma");
	}

	public ArrayList<HangHoa> getThucPham() {
		ArrayList<HangHoa> dsThucPham = new ArrayList<HangHoa>();
		for (HangHoa h : ds) {
			if (h instanceof HangThucPham)
				dsThucPham.add(h);
		}
		return dsThucPham;
	}

	public ArrayList<HangHoa> getSanhSu() {
		ArrayList<HangHoa> dsSanhSu = new ArrayList<HangHoa>();
		for (HangHoa h : ds) {
			if (h instanceof HangSanhSu)
				dsSanhSu.add(h);
		}
		return dsSanhSu;
	}

	public ArrayList<HangHoa> getDienMay() {
		ArrayList<HangHoa> dsDienMay = new ArrayList<HangHoa>();
		for (HangHoa h : ds) {
			if (h instanceof HangDienMay)
				dsDienMay.add(h);
		}
		return dsDienMay;
	}
	
	public boolean delete(String ma) {
		for (HangHoa h : ds) {
			if(h.maHang.equals(ma)) {
				ds.remove(h);
				return true;
			}
		}
		return false;
	}
}
