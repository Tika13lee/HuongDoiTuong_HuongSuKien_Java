package tuan9_30_QLCauThu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViTri_DAO {
	public ArrayList<ViTriThiDau> getAllViTri() {
		ArrayList<ViTriThiDau> dsViTri = new ArrayList<ViTriThiDau>();
		try {
			ConnecDB.getInstance();
			Connection con = ConnecDB.getConnection();
			String sql = "Select * from ViTriThiDau";
			Statement statment = con.createStatement();
			ResultSet rs = statment.executeQuery(sql);
			while (rs.next()) {
				String maViTri = rs.getString(1);
				String tenViTri = rs.getString(2);
				ViTriThiDau vt = new ViTriThiDau(maViTri, tenViTri);
				dsViTri.add(vt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsViTri;
	}
}
