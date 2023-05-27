package tuan8_30_QLNV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getAllPhongBan() {
		ArrayList<PhongBan> dsPb = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhongBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPB = rs.getString(1);
				String tenPB = rs.getString("tenPhong");
				PhongBan p = new PhongBan(maPB, tenPB);
				dsPb.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPb;
	}
}
