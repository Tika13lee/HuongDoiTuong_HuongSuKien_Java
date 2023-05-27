package demoIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class STT30_LeThiThuyKieu_DataOutputStream {
	private final String[] dsTenSV = { "An", "Lan", "Hoa", "Hoang", "Nga", "Kieu" };
	private final float[] dsDiemGK = { 7, 8.5f, 9, 10, 4.5f, 6 };
	private final float[] dsDiemCK = { 5, 5.5f, 6.5f, 10, 6, 4.5f };

	public void writeTo(String fileName) throws IOException {
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			for (int i = 0; i < dsTenSV.length; i++) {
				out.writeChars(dsTenSV[i]);
				out.writeFloat(dsDiemGK[i]);
				out.writeFloat(dsDiemCK[i]);
			}
		} finally {
			if (out != null)
				out.close();
		}

	}

	public void readFrom(String fileName) throws IOException {
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			while (in.available() != 0) {
				String tenSV = in.readUTF();
				float diemGK = in.readFloat();
				float diemCK = in.readFloat();
				float diemTB = (diemGK + diemCK) / 2;
				System.out.println(String.format("%-10s %7s %7s %7s", tenSV, diemGK, diemCK, diemTB));
			}
		} finally {
			if (in != null)
				in.close();
		}

	}

	public static void main(String[] args) throws IOException {
		String file = "src\\data\\sinhvien.txt";
		new STT30_LeThiThuyKieu_DataOutputStream().readFrom(file);
		new STT30_LeThiThuyKieu_DataOutputStream().writeTo(file);
	}
}
