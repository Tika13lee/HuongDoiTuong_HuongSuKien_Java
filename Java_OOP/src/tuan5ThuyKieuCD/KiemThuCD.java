package tuan5ThuyKieuCD;

import java.util.Scanner;

public class KiemThuCD {
	public static void main(String[] args) throws Exception {
		CDList ds = new CDList(100000);
		Scanner scn = new Scanner(System.in);
		int chon=0;
		
		do {
			menu();
			System.out.println("Ban chon: ");
			chon = scn.nextInt();
			switch(chon) {
			case 1: 
				nhapCung(ds);
				xuat(ds);
				break;
			case 2:
				them(ds);
				xuat(ds);
				break;
			case 3:
				xoa(ds);
				xuat(ds);
				break;
			case 4:
				sua(ds);
				xuat(ds);
				break;
			case 5:
				timKiem(ds);
				break;
			case 6: 
				ds.sortTheoGiaThanh();
				xuat(ds);
				break;
			case 7:
				ds.sortTheoTuaCD();
				xuat(ds);
				break;
			case 8:
				double sum = ds.getMonney();
				System.out.println("Tong gia thanh la: "+ sum);
				break;
			}
		}while(chon != 0);

	}
	static void menu() {
		System.out.println("-----------------------------------------");
		System.out.println("Chuong trinh quan li CD");
		System.out.println("1. Nhap cung");
		System.out.println("2. Them");
		System.out.println("3. Xoa");
		System.out.println("4. Sua");
		System.out.println("5. Tim kiem theo ma CD");
		System.out.println("6. Sap xep tang dan theo gia thanh");
		System.out.println("7. Sap xep tang dan theo tua CD");
		System.out.println("8. Xuat tong gia thanh");
		System.out.println("0. Thoat");
	}
	static void timKiem(CDList ds) {
		Scanner scn = new Scanner(System.in);
		int maCD;
		System.out.println("Nhap ma CD can tim");
		maCD = scn.nextInt();
		int vt = ds.tiemKiem(maCD);
		if(vt == -1)
			System.out.println("Khong tim thay - Ma CD khong ton tai");
		else {
			inTieuDeCot();
			System.out.println(ds.getDs()[vt]);
		}
	}
	static void menuSua() {
		System.out.println("Moi nhap thong tin can sua");
		System.out.println("1. So bai hat");
		System.out.println("2. Tua bai hat");
		System.out.println("3. Gia thanh");
		System.out.println("4. Ve menu chinh");
	}
	static void sua(CDList ds) throws Exception {
		Scanner scn = new Scanner(System.in);
		int maCD, chon =-1;
		String tuaBH;
		System.out.println("Nhap ma CD: ");
		maCD = scn.nextInt();
		int vt = ds.tiemKiem(maCD);
		CD cdSua = ds.getDs()[vt];
		if(vt == -1) {
			System.out.println("Ma CD khong ton tai");
		}
		else {
			System.out.println("Thong tin CD cua ban ");
			inTieuDeCot();
			System.out.println(cdSua);
			do {
				menuSua();
				System.out.println("Nhap lua chon");
				chon = scn.nextInt();
				switch(chon) {
				case 1:
					System.out.println("Nhap so bai hat: ");
					cdSua.setSoBH(scn.nextInt());
					break;
				case 2:
					scn.nextLine();
					System.out.println("Nhap tua de: ");
					tuaBH = scn.nextLine();
					break;
				case 3:
					System.out.println("Nhap gia thanh: ");
					cdSua.setGiaThanh(scn.nextDouble());
					break;
				default:
					ds.sua(cdSua);
					System.out.println("Da sua thanh cong. Tro ve menu chinh");
				}
			}while(chon!=4);
		}	
	}
	static void xoa(CDList ds) {
		Scanner scn = new Scanner(System.in);
		int maCD;
		System.out.println("Nhap ma CD can xoa: ");
		maCD = scn.nextInt();
		int vt = ds.tiemKiem(maCD);
		if(vt == -1)
			System.out.println("Ma CD khong ton tai");
		else {
			String acp;
			System.out.println("Ban co chac chan muon xoa CD nay khoi danh sach [y/n]");
			acp = new  Scanner(System.in).nextLine();
			if(acp.equals("y")) {
				ds.xoa(ds.getDs()[vt]);
				System.out.println("Xoa thanh cong");
			}
			else {
				System.out.println("Xoa khong thanh cong!! Ve menu chinh");
			}
		}
	}
	static void them(CDList ds) throws Exception {
		Scanner scn = new Scanner(System.in);
		CD cd = new CD();
		int maCD;
		System.out.println("Nhap ma CD: ");
		maCD = scn.nextInt();
		if(ds.tiemKiem(maCD) == -1) {
			cd.setMaCD(maCD);
			System.out.println("Nhap so bai hat");
			cd.setSoBH(scn.nextInt());
			scn.nextLine();
			System.out.println("Nhap tua de: ");
			cd.setTuaCD(scn.nextLine());
			System.out.println("Nhap gia thanh");
			cd.setGiaThanh(scn.nextDouble());
			System.out.println("Them thanh cong");
			ds.them(cd);
		}
		else 
			System.out.println("Them khong thanh cong - Trung ma CD");
	}
	static void inTieuDeCot() {
		String str = String.format("%-10s %-10s %-30s %15s", "Ma CD", "So bai hat", "Tua de", "Gia thanh");
		System.out.println(str);
	}
	static void xuat(CDList ds) {
		inTieuDeCot();
        for(int i=0; i<ds.getSoLuongHT(); i++) {
            System.out.println(ds.getDs()[i]);
        }
    }
	static void nhapCung(CDList ds) throws Exception {
		CD cd = new CD(1, 3, "Dan ca", 10000);
		ds.them(cd);
		cd = new CD(2, 10, "Nhac cach mang", 50000);
		ds.them(cd);
		cd = new CD(3, 10, "Nhac hoa", 5000);
		ds.them(cd);
	}

}
