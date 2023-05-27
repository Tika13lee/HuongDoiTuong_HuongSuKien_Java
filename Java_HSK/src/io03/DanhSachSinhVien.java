package io03;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSinhVien implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<SinhVien> dssv;
	
	public DanhSachSinhVien() {
		// TODO Auto-generated constructor stub
		dssv=new ArrayList<SinhVien>();
	}
	
	public boolean themSinhVien(SinhVien sv) {
		if(dssv.contains(sv))
			return false;
		dssv.add(sv);
		return true;		
	}
	
	public String xuatThongTin() {
		String kq="MaSV TenSV Diem trung binh\n";
		for(SinhVien i: dssv)
			kq+=i.toString()+"\n";
		return kq;
	}
	
	public void xuatDanhSach() {
		for(SinhVien i: dssv)
			System.out.println(i);
	}
	public ArrayList<SinhVien> getDssv() {
		return dssv;
	}
}
