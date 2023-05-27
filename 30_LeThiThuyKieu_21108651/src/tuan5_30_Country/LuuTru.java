package tuan5_30_Country;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	public boolean ghiFile(Object o, String file) throws Exception {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);
		oos.flush();
		oos.close();
		return true;
	}

	public Object docFile(String file) throws Exception {
		Object o = null;
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		o = ois.readObject();
		ois.close();
		return o;
	}
}
