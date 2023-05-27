package bai6_40;

import java.time.LocalDate;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws Exception {
		DanhSachHangHoa ds = new DanhSachHangHoa();
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		do {
			menu();
			System.out.println("Nhap chuc nang: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1: {
				taoCung(ds);
				break;
			}
			case 2: {
				xuat(ds);
				break;
			}
			case 3: {
				xoa(ds);
				break;
			}
			}
		} while (chon != 0);
	}

	static void menu() {
		System.out.println("------------------QUAN LI HANG HOA------------------");
		System.out.println("0. Thoat chuong trinh");
		System.out.println("1. Tao cung danh sach hang hoa");
		System.out.println("2. Xuat danh sach hang hoa");
		System.out.println("3. Xoa 1 hang hoa khoi danh sach");
		System.out.println("----------------------------------------------------");
	}
	
	static void xoa(DanhSachHangHoa ds) {
		Scanner sc = new Scanner(System.in);
		String ma;
		System.out.println("Nhap ma hang hoa can xoa: ");
		ma = sc.nextLine();
		boolean d = ds.delete(ma);
		if(d) 
			System.out.println("Xoa thanh cong");
		else
			System.out.println("Ma hang hoa khong ton tai");
	}

	static void xuat(DanhSachHangHoa ds) {
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		do {
			System.out.println("0. Quay lai chuong trinh chinh");
			System.out.println("1. Xuat danh sach hang thuc pham");
			System.out.println("2. Xuat danh sach hang sanh su");
			System.out.println("3. Xuat danh sach hang dien may");
			System.out.println("Chon chuc nang: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1: {
				tieuDeTP();
				for (HangHoa h : ds.getThucPham()) {
					System.out.println(h);
				}
				break;
			}
			case 2: {
				tieuDeSS();
				for (HangHoa h : ds.getSanhSu()) {
					System.out.println(h);
				}
				break;
			}
			case 3: {
				tieuDeDM();
				for (HangHoa h : ds.getDienMay()) {
					System.out.println(h);
				}
				break;
			}
			}
		} while (chon != 0);

	}

	static void tieuDeTP() {
		String str = String.format("%-15s %-15s %15s    %-15s %-15s %-15s %-15s %15s    %-15s", "Ma HH", "Ten HH",
				"Don Gia", "SL Ton", "Nha CC", "Ngay SX", "Ngay Het Han", "Tien VAT", "Danh Gia");
		System.out.println(str);
	}

	static void tieuDeSS() {
		String str = String.format("%-15s %-15s %15s    %-15s %-15s %-15s %15s    %-15s", "Ma HH", "Ten HH",
				"Don Gia", "SL Ton", "Nha SX", "Ngay Nhap Kho", "Tien VAT", "Danh Gia");
		System.out.println(str);
	}
	
	static void tieuDeDM() {
		String str = String.format("%-15s %-15s %15s    %-15s %-15s %-15s %15s    %-15s", "Ma HH", "Ten HH",
				"Don Gia", "SL Ton", "TG Bao Hanh", "Cong Suat", "Tinh VAT", "Danh Gia");
		System.out.println(str);
	}
	
	static void taoCung(DanhSachHangHoa ds) throws Exception {
		HangHoa h1 = new HangThucPham("001", "Sua Milo", 10000, 20, "Milo Nestle", LocalDate.of(2022, 12, 20),
				LocalDate.of(2023, 03, 13));
		HangHoa h2 = new HangThucPham("002", "Keo deo", 2000, 10, "VinaOrganic", LocalDate.of(2022, 12, 10),
				LocalDate.of(2023, 01, 20));
		HangHoa h3 = new HangDienMay("003", "May giat", 10000000, 13, 24, 2.5);
		HangHoa h4 = new HangDienMay("004", "Tu lanh", 5000000, 2, 24, 1.5);
		HangHoa h5 = new HangSanhSu("005", "Chen bat", 10000, 60, "Trang An", LocalDate.of(2022, 10, 30));
		HangHoa h6 = new HangSanhSu("006", "Chau su", 300000, 30, "Trang An", LocalDate.of(2022, 11, 30));

		ds.them(h1);
		ds.them(h2);
		ds.them(h3);
		ds.them(h4);
		ds.them(h5);
		ds.them(h6);

		System.out.println("Tao thanh cong");
	}
}
