package bai6_48;

import java.util.ArrayList;
import java.util.Scanner;

import bai6_48.LyThuyet.enum_MC;

public class Demo_PH {
	public static void main(String[] args) throws Exception {
		List_PH ds = new List_PH();
		int chon = 0;
		Scanner sc = new Scanner(System.in);
		do {
			menu();
			System.out.println("Nhap lua chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				taoCung(ds);
				break;
			case 2:
				xuat(ds.getDs());
				break;
			case 3:
				them(ds);
				break;
			case 4:
				tim(ds);
				break;
			case 5:
				xoa(ds);
				break;
			case 6:
				ds.sort_DayNha();
				xuat(ds.getDs());
				break;
			case 7:
				ds.sort_DT();
				xuat(ds.getDs());
				break;
			case 8:
				ds.sort_Den();
				xuat(ds.getDs());
				break;
			case 9:
				System.out.println("Tong phong hoc la: " + ds.tongPH());
				break;
			case 10:
				xuat(ds.phDatChuan());
				break;
			case 11:
				capNhat(ds);
				break;
			case 12:
				xuat(ds.getPM60());
				break;
			}
		} while (chon != 0);
	}

	static void menu() {
		System.out.println("-----------QUAN LI PHONG HOC-----------");
		System.out.println("1. Tao cung");
		System.out.println("2. Xuat danh sach");
		System.out.println("3. Them phong hoc");
		System.out.println("4. Tim phong hoc theo ma");
		System.out.println("5. Xoa phong hoc theo ma");
		System.out.println("6. Sap xep tang dan theo day nha");
		System.out.println("7. Sap xep giam dan theo dien tich");
		System.out.println("8. Sap xep tang dan theo do bong den");
		System.out.println("9. Tong so phong hoc");
		System.out.println("10. Danh sach phong dat chuan");
		System.out.println("11. Cap nhat so may tinh khi biet ma phong");
		System.out.println("12. Danh sach cac phong may co 60 may");
		System.out.println("0. Thoat");
		System.out.println("---------------------------------------");
	}
	
	static void capNhat(List_PH ds) {
		String ma;
		int SL;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma phong may can cap nhat so may tinh: ");
		ma = sc.nextLine();
		PhongHoc p = ds.search(ma);
		if (p != null && p instanceof MayTinh) {
			System.out.println("Cap nhat so luong may tinh: ");
			SL = sc.nextInt();
			((MayTinh) p).setSoMayTinh(SL);
			ds.sua(p);
		} else
			System.out.println("Loi - Khong phai ma phong may tinh");

	}

	static void xoa(List_PH ds) {
		Scanner sc = new Scanner(System.in);
		String ma;
		System.out.println("Nhap ma phong hoc can xoa: ");
		ma = sc.nextLine();
		if (ds.delete(ma))
			System.out.println("Xoa thang cong");
		else
			System.out.println("Ma phong hoc khong ton tai");
		xuat(ds.getDs());
	}

	static void tim(List_PH ds) {
		Scanner sc = new Scanner(System.in);
		String ma;
		System.out.println("Nhap ma phong hoc can tim: ");
		ma = sc.nextLine();
		if (ds.search(ma) != null) {
			tieuDe();
			System.out.println(ds.search(ma));
		} else
			System.out.println("Khong tim thay !!!");
	}

	static void them(List_PH ds) throws Exception {
		System.out.println("Nhap cac thong tin phong hoc can them");
		PhongHoc p5 = taoMem();
		if (ds.checkMa(p5.maPhong) == false) {
			ds.them(p5);
			System.out.println("Them thanh cong");
		} else
			System.out.println("Them khong thanh cong - Trung ma");
	}

	static PhongHoc taoMem() throws Exception {
		PhongHoc temp = null;
		String ma;
		String day;
		float dt;
		int den;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ma phong hoc: ");
		ma = sc.nextLine();
		System.out.println("Day nha: ");
		day = sc.nextLine();
		System.out.println("Dien tich: ");
		dt = sc.nextFloat();
		System.out.println("So bong den: ");
		den = sc.nextInt();
		int chon;
		do {
			System.out.println("Chon loai phong can them: ");
			System.out.println("1. Phong ly thuyet");
			System.out.println("2. Phong may tinh");
			System.out.println("3. Phong thi nghiem");

			chon = sc.nextInt();
			switch (chon) {
			case 1: {
				int chon1;
				enum_MC mayChieu;
				System.out.println("Phong co may chieu khong ? ");
				System.out.println("1. Co");
				System.out.println("2. Khong");
				chon1 = sc.nextInt();
				if (chon1 == 1)
					mayChieu = enum_MC.CO;
				else
					mayChieu = enum_MC.KHONG;
				temp = new LyThuyet(ma, day, dt, den, mayChieu);
				break;
			}
			case 2: {
				int soMT;
				System.out.println("So may tinh: ");
				soMT = sc.nextInt();
				temp = new MayTinh(ma, day, dt, den, soMT);
				break;
			}
			case 3: {
				String chuyenNganh;
				String sucChua;
				boolean bonRua;
				sc.nextLine();
				System.out.println("Chuyen nganh: ");
				chuyenNganh = sc.nextLine();
				System.out.println("Suc chua: ");
				sucChua = sc.nextLine();
				System.out.println("Co bon rua hay khong ? (true/false)");
				bonRua = sc.nextBoolean();
				temp = new ThiNghiem(ma, day, dt, den, chuyenNganh, sucChua, bonRua);
				break;
			}
			}
		} while (chon < 1 || chon > 3);
		return temp;
	}

	static void xuat(ArrayList<PhongHoc> ds) {
		tieuDe();
		for (PhongHoc p : ds) {
			System.out.println(p);
		}
	}

	static void tieuDe() {
		String str = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s", "Ma Phong", "Day Nha",
				"Dien Tich", "So Bong Den", "May Chieu", "So May Tinh", "Chuyen Nganh", "Suc Chua", "Bon Rua");
		System.out.println(str);
	}

	static void taoCung(List_PH ds) throws Exception {
		LyThuyet p1 = new LyThuyet("p001", "D", 100, 15, enum_MC.CO);
		LyThuyet p2 = new LyThuyet("p002", "D", 300, 15, enum_MC.KHONG);
		MayTinh p3 = new MayTinh("p003", "B", 500, 50, 60);
		MayTinh p4 = new MayTinh("p004", "B", 200, 30, 20);
		ThiNghiem p5 = new ThiNghiem("p005", "C", 150, 17, "Hoa hoc", "20 nguoi", true);
		ThiNghiem p6 = new ThiNghiem("p006", "C", 180, 17, "Sinh hoc", "25 nguoi", false);

		ds.them(p1);
		ds.them(p2);
		ds.them(p3);
		ds.them(p4);
		ds.them(p5);
		ds.them(p6);

		System.out.println("Da tao xong");
	}
}
