package io03;

import java.io.Serializable;

public class SinhVien implements Serializable{
	private static final long serialVersionUID = 1L;
	private String maSo, tenSv;
	private double dtb;
	public SinhVien(String maSo, String tenSv, double dtb) {
		super();
		this.maSo = maSo;
		this.tenSv = tenSv;
		this.dtb = dtb;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-10s %-10s %8.2f", maSo,tenSv,dtb);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		SinhVien sv2=(SinhVien)obj;
		return this.maSo.equalsIgnoreCase(sv2.maSo);
	}

	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getTenSv() {
		return tenSv;
	}
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
}
