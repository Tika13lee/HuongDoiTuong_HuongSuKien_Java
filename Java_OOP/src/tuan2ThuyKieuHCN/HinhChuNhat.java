package tuan2ThuyKieuHCN;

public class HinhChuNhat {
	private int chieuDai, chieuRong;
	//tạo thuộc tính set & get
	public int getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}
	public int getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	//khởi tạo phương thức constructor có tham số
	public HinhChuNhat(int chieuDai, int chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	//khởi tạo phương thức constructor không có tham số
	public HinhChuNhat() {
		super();
		 
	}
	
	public int chuViHCN() {
		int cv, dai, rong;
		dai = this.getChieuDai();
		rong = this.getChieuRong();
		cv = (dai + rong) * 2;
		return cv;
	}
	public int dienTichHCN() {
		return this.getChieuDai() * this.getChieuRong();
	}
	
	@Override
	public String toString() {
		String str="HCN chieu dai: "+ chieuDai;
		str+="\nHCN chieu rong: "+ this.chieuRong;
		str+="\nCo chu vi: "+ chuViHCN();
		str+="\nCo dien tich: "+ dienTichHCN();
		return str;
	}
}
