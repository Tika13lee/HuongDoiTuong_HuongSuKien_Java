package tuan4_30_QuanLySach;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LuuTruSach {
//	private ListSach ds;

	public void ghiFile(ListSach ds, String file) throws IOException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
			out.write("MaSach;TuaSach;NamXuatBan;SoTrang;ISBN;TacGia;NhaXuatBan;DonGia\n");
			for (Sach s : ds.getDs()) {
				out.write(s.toString() + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	public void docFile(ListSach ds, String file) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedInputStream(new FileInputStream(file)));
			String line = null;
			line = in.nextLine();
			while (in.hasNextLine()) {
				line = in.nextLine();
				String[] cols = line.split(";");
				String ma = cols[0];
				String tua = cols[1];
				String tg = cols[2];
				String nam = cols[3];
				String nhaxb = cols[4];
				String trang = cols[5];
				String dongia = cols[6];
				String isbn = cols[7];
				Sach s = new Sach(ma, tua, tg, Integer.parseInt(nam), nhaxb, Integer.parseInt(trang),
						Integer.parseInt(dongia), isbn);
				ds.them(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
	}

}
