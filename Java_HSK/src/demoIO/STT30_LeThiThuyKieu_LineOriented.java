package demoIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class STT30_LeThiThuyKieu_LineOriented {
	public static void main(String[] args) throws IOException {
		FileWriter out = null;
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("src\\data\\number.txt"));
			out = new FileWriter("src\\data\\dest.txt");
			String line = null;
			while(in.hasNextLine()) { //boolean hasNextLine() ktra xem có dòng khác trong đầu vào của máy quét k
				line = in.nextLine(); //String nextLine() đọc giá trị chuỗi
				out.write(line + "\n");
			}
		} finally {
			 if(in != null)		in.close();
			 if(out != null)	out.close();
		}
	}
}
