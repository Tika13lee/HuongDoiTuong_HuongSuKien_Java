package tuan2ThuyKieuHCN;

import java.util.Scanner;

public class KiemThuHCN {
	public static void main(String[] args) {
		System.out.println("GT chuong trinh tinh cv, dt hinh chu nhat");
		
		HinhChuNhat cn1 = new HinhChuNhat(10, 5);
		System.out.println("Chu vi HCN la: " + cn1.chuViHCN());
		System.out.println("Dien tich HCN la: " + cn1.dienTichHCN());
		System.out.println("=================================");
				
		HinhChuNhat cn2 = taoHCN();
		System.out.println(cn2);
	}
	
	static HinhChuNhat taoHCN() {
		HinhChuNhat cnTao;
		int d, r;
		String s="Ban nhap vao chieu dai";
		d=nhapSoNguyen(s);
		r=nhapSoNguyen("Ban nhap vao chieu rong: ");
		cnTao = new HinhChuNhat(d, r);
		return cnTao;
	}
	static int nhapSoNguyen(String s) {
		int n;
		Scanner scn = new Scanner(System.in);
		System.out.println(s);
		n = scn.nextInt();
		return n;
	}
}
