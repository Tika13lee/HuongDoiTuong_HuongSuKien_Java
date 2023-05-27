package tuan4ThuyKieuSinhVien;

import java.util.Scanner;

public class KiemThuSV {
	public static void main(String[] args) {
		inTieuDeCot();
		taoCung();
		SinhVien sv = taoMemSV();
		inTieuDeCot();
		System.out.println(sv);
	}
	static SinhVien taoMemSV()
	{
		SinhVien sv;
		Scanner scn = new Scanner(System.in);
		int ma;
		String HT="";
		float LT, TH;
		
		String s = "Ban nhap vao ma sinh vien";
		System.out.println(s);
		ma = scn.nextInt();
		s = "Ban nhap vao ho ten sinh vien";
		System.out.println(s);
		//
		
		HT = scn.nextLine();
		s = "Nhap diem ly thuyet";
		LT = nhapSoThuc(s);
		s = "Nhap diem thuc hanh";
		TH = nhapSoThuc(s);
		sv = new SinhVien(ma, HT, LT, TH);
		return sv;
		
	}
	static float nhapSoThuc(String s)
	{
		float n;
		Scanner scn = new Scanner(System.in);
		System.out.println(s);
		n = scn.nextFloat();
		return n;
	}
	static void taoCung()
	{
		SinhVien sv1 = new SinhVien(123456, "Le Thi Thuy Kieu", 9, 9);
		SinhVien sv2 = new SinhVien(456789, "Ha Chi Vu", 9, 8);
		System.out.println(sv1);
		System.out.println(sv2);
	}
	
	static void inTieuDeCot()
	{
		String str="";
		str+= String.format("%-10s %-20s %15s %15s %15s", "Ma SV", "Ho va Ten", " Diem LT", "Diem TH", "Diem TB");
		System.out.println(str);
	}
}
