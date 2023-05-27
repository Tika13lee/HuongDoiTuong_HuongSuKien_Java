package tuan3ThuyKieuAccount;

import java.util.Scanner;

public class KiemThuAccount {
	static Account acc1;
	static Account acc2;
	static Account acc3;
	static Account acc4;

	public static void main(String[] args) {
		int chon = 0;
		Scanner scn = new Scanner(System.in);
		do {
			menu();
			System.out.printf("Nhap lua chon cua ban: ");
			chon = scn.nextInt();
			switch (chon) {
			case 1: {
				inTieuDeCot();
				taoCungTaiKhoan();
				break;
			}
			case 2: {
				taoMemTaiKhoan();
				break;
			}
			case 3: {
				napTienVaoTaiKhoan();
				break;
			}
			case 4: {
				chuyenTien();
				break;
			}
			case 5: {
				rutTienTaiKhoan();
				break;
			}
			}
		} while (chon != 0);

	}

	static void taoMemTaiKhoan() {
		acc4 = new Account();
    	long SoTk;
    	String tenChuTk;
    	double moneyTk;
    	Scanner scn = new Scanner(System.in);
    	System.out.println("Nhap ten chu tai khoan: ");
    	tenChuTk = scn.nextLine();
    	System.out.println("Nhap so tai khoan: ");
    	SoTk = scn.nextLong();
    	System.out.println("Nhap vao so tien: ");
    	moneyTk = scn.nextDouble();
    	acc4 = new Account(SoTk, tenChuTk, moneyTk);
    	inTieuDeCot();
    	System.out.println(acc4);
	}
	static void chuyenTien() {
		Account accChuyen = null, accNhan = null;
		int chon = 0;
		long tienChuyen = 0;
		System.out.println("Chon tai khoan chuyen 1, 2, 3: ");
		chon = new Scanner(System.in).nextInt();
		if (chon == 1)
			accChuyen = acc1;
		else if (chon == 2)
			accChuyen = acc2;
		else if (chon == 3)
			accChuyen = acc3;
		System.out.println("Chon tai khoan nhan 1, 2, 3: ");
		chon = new Scanner(System.in).nextInt();
		if (chon == 1)
			accNhan = acc1;
		else if (chon == 2)
			accNhan = acc2;
		else if (chon == 3)
			accNhan = acc3;

		System.out.println("Ban muon chuyen bao nhieu: ");
		tienChuyen = new Scanner(System.in).nextLong();
		if (tienChuyen > 0)
			if (accChuyen.chuyenTien(accNhan, tienChuyen) != false)

			{
				System.out.println("Chuyen thanh cong");
				inTieuDeCot();
				System.out.println(accChuyen);
				System.out.println(accNhan);
			} 
			else
				System.out.println("Chuyen khong thanh cong");
	}
	static void rutTienTaiKhoan() {
		Account accRut = null;
		int chon;
		long tienRut = 0;
		System.out.println("Chon tai khoan muon rut 1, 2, 3: ");
		chon = new Scanner(System.in).nextInt();
		if (chon == 1) 
			accRut = acc1;
		else if (chon == 2) 
			accRut = acc2;
		else if (chon == 3) 
			accRut = acc3;
		System.out.println("Ban rut bao nhieu: ");
		tienRut = new Scanner(System.in).nextLong();
		if (tienRut > 0)
			if (accRut.rutTien(tienRut) != false) {
				System.out.println("Rut thanh cong");
				inTieuDeCot();
				System.out.println(accRut);
			} else
				System.out.println("Phai nhap tien rut >0");
	}

	static void napTienVaoTaiKhoan() {
		Account accNap = null;
		int chon;
		long tienNap = 0;
		System.out.println("Chon tai khoan nap 1, 2, 3: ");
		chon = new Scanner(System.in).nextInt();
		if (chon == 1) 
			accNap = acc1;
		else if (chon == 2) 
			accNap = acc2;
		else if (chon == 3) 
			accNap = acc3;
		System.out.println("Ban nap bao nhieu: ");
		tienNap = new Scanner(System.in).nextLong();
		if (tienNap > 0)
			if (accNap.napTien(tienNap) != false) {
				System.out.println("Nap thanh cong");
				inTieuDeCot();
				System.out.println(accNap);
			} else
				System.out.println("Phai nhap tien nap >0");
	}

	static void menu() {
		System.out.println("*******************************");
		System.out.println("Chuong trinh quan li Account");
		System.out.println("1. Tao cung tai khoan");
		System.out.println("2. Tao mem tai khoan");
		System.out.println("3. Nap tien vao tai khoan");
		System.out.println("4. Chuyen tien");
		System.out.println("5. Rut tien");
		System.out.println("0. Thoat chuong trinh");
	}

	static void taoCungTaiKhoan() {
		acc1 = new Account(1234, "Le Thi Thuy Kieu", 100000000);
		acc2 = new Account(1235, "Le Thi Thuy Vy", 20000000);
		acc3 = new Account(1236, "Le Truong Duy", 3000000);
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);
	}

	static void inTieuDeCot() {
		String str = "";
		str += String.format("%-15s %-35s %15s", "So TK", "Ten TK", "Tien TK");
		System.out.println(str);
	}
}
