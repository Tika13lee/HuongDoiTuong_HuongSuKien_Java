package tuan3_30_DemoJTree;

import java.util.ArrayList;

public class ListPB {
	private ArrayList<PhongBan> dsPB;

	public ListPB() {
		dsPB = new ArrayList<PhongBan>();
	}

	// them phong ban vao dsPB
//	public void themPB(String ma, String ten, int soNV) {
//		dsPB.add(new PhongBan(ma, ten, soNV));
//	}

	public void themPB(PhongBan p) {
		dsPB.add(p);
	}

	public ArrayList<PhongBan> getDsPB() {
		return dsPB;
	}

	public void setDsPB(ArrayList<PhongBan> dsPB) {
		this.dsPB = dsPB;
	}

	// lay 1 phong ban khi biet vi tri
	public PhongBan getElement(int index) {
		if (index < 0 || index >= dsPB.size())
			return null;
		return dsPB.get(index);
	}

	// lay 1 phong ban khi biet maPB
//	public PhongBan getElement(String maPB) {
//		PhongBan p = new PhongBan(maPB, "", 0);
//		if (dsPB.contains(p)) {
//			return dsPB.get(dsPB.indexOf(p));
//		}
//		return null;
//	}
}
