package tuan5ThuyKieuCD;

public class CDList {
	private CD ds[];
	public int soLuongHT = 0;
	
	//khởi tạo mảng
	public CDList(int soluong) {
		ds = new CD[soluong];
	}
	
	public CD[] getDs() {
		return ds;
	}
	public void setDs(CD[] ds) {
		this.ds = ds;
	}
	public int getSoLuongHT() {
		return soLuongHT;
	}
	public void setSoLuongHT(int soLuongHT) {
		this.soLuongHT = soLuongHT;
	}


	public void them(CD cd) throws Exception {
		if(soLuongHT == ds.length)
			tangKichThuoc();
		if(tiemKiem(cd.getMaCD()) == -1) {
			ds[soLuongHT] = cd;
			soLuongHT++;
		}
		else {
			throw new Exception("Trung ma");
		}	
	}
	public void tangKichThuoc() {
		CD temp[] = new CD[ds.length*2];
		for(int i=0; i<ds.length; i++) 
			temp[i] = ds[i];
		ds = temp;
	}
	public int tiemKiem(int maCD) {
		for(int i=0; i<soLuongHT; i++) {
			if(maCD == ds[i].getMaCD())
				return i;
		}
		return -1;
	}
	public void xoa(CD cd) {
		int vt = tiemKiem(cd.getMaCD());
		for (int i=vt; i<soLuongHT-1; i++) {
			ds[i]=ds[i+1];
		}
		soLuongHT--;
	}
	public void sua(CD cd) throws Exception {
		int vt = tiemKiem(cd.getMaCD());
		if(vt!=-1)
			ds[vt]= cd;
		else
			throw new Exception("Khong tim thay obj de sua");
	}
	public void swap(CD list[], int i, int j, CD temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
	}
	public void sortTheoGiaThanh() {
		CD temp = null;
		for(int i = 0; i<soLuongHT-1; i++) {
			for(int j=i+1; j<soLuongHT; j++)
				if(ds[i].getGiaThanh() > ds[j].getGiaThanh())
					swap(ds, i, j, temp);
		}
	}
	public void sortTheoTuaCD() {
		CD temp = null;
		for(int i = 0; i<soLuongHT-1; i++) {
			for(int j=i+1; j<soLuongHT; j++)
				if(ds[i].getTuaCD().compareTo(ds[j].getTuaCD()) > 0)
					swap(ds, i, j, temp);
		}
	}
	public double getMonney() {
		double ans = 0;
		for (int i=0; i<soLuongHT; i++)
			ans+= ds[i].getGiaThanh();
		return ans;
	}
}
