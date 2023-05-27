package tuan3_30_Employees;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTruEmp {
	public boolean ghiFile(Object obj, String file) throws Exception {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}

	public Object docFile(String file) throws Exception {
		Object obj = null;
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		obj = ois.readObject();
		ois.close();
		return obj;
	}
}
