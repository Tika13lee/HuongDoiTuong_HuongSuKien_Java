package io03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test_LuuDSSinhVien {
	private static final String FILENAME = "\\src\\data\\SV.txt";

	public static void main(String[] args) {
		DanhSachSinhVien ds = null;

		// Doc danh sach SV tu file ra doi tuong ds
		if (!new File(FILENAME).exists())
			ds = new DanhSachSinhVien();
		else {
			try {
				FileInputStream fis = new FileInputStream(FILENAME);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ds = (DanhSachSinhVien) ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		int chon;
		boolean flag = true;
		do {
			System.out.println("1. Them sinh vien\n2. Xuat danh sach\n3. Luu");
			chon = new Scanner(System.in).nextInt();
			switch (chon) {
			case 1:
				if (!ds.themSinhVien(nhapSV()))
					System.out.println("Trung ID!");
				break;
			case 2:
				ds.xuatDanhSach();
				break;
			case 3:
				try {
					// Ghi danh sach SV tu doi tuong ds vao file
					FileOutputStream fos = new FileOutputStream(FILENAME);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(ds);
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				flag = false;
				break;
			}
		} while (flag);
	}

	private static SinhVien nhapSV() {
		// TODO Auto-generated method stub
		System.out.println("Nhap maso: ");
		String ma = new Scanner(System.in).nextLine();
		System.out.println("Nhap ten: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.println("Nhap DTB: ");
		double dtb = new Scanner(System.in).nextDouble();
		return new SinhVien(ma, ten, dtb);
	}
}
