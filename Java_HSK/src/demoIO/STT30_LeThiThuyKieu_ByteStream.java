package demoIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class STT30_LeThiThuyKieu_ByteStream {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("src\\data\\number.txt");
			out = new FileOutputStream("src\\data\\dest.txt");
//			int c;
//			while ((c = in.read()) != -1) {
//				out.write(c);
			byte[] data = new byte[16];
			int nob = -1;
			while((nob = in.read(data)) != -1) {
				out.write(data, 0, nob);
			}
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}
