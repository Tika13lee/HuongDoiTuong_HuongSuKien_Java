package demoIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class STT30_LeThiThuyKieu_BufferedStream {
	private final String[] dsTenSV = { "An", "Lan", "Hoa", "Hoang", "Nga", "Tam" };
	private final float[] dsDiemGK = { 7, 8.5f, 9, 10, 4.5f, 6 };
	private final float[] dsDiemCK = { 5, 5.5f, 6.5f, 10, 6, 4.5f };

	public void writeTo(String fileName) throws IOException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)), true);
			for (int i = 0; i < dsTenSV.length; i++) {
				out.println(String.format("%-10s %10s %10s", dsTenSV[i] + ";", dsDiemGK[i] + ";", dsDiemCK[i] + ";"));
			}
		} finally {
			if (out != null)
				out.close();
		}
	}

	public void readFrom(String fileName) throws IOException {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedInputStream(new FileInputStream(fileName)));
			String line = null;
			while (in.hasNextLine()) {
				line = in.nextLine();
				String[] cols = line.split(";");
				float diemGK = Float.parseFloat(cols[1]);
				float diemCK = Float.parseFloat(cols[2]);
				float diemTB = (diemGK + diemCK) / 2;
				System.out.println(String.format("%-25s %10s", line, diemTB));
			}
		} finally {
			if (in != null)
				in.close();
		}
	}

	public static void main(String[] args) throws IOException {
		String file = "src\\data\\sinhvien.txt";
		new STT30_LeThiThuyKieu_BufferedStream().writeTo(file);
		new STT30_LeThiThuyKieu_BufferedStream().readFrom(file);
	}
}
