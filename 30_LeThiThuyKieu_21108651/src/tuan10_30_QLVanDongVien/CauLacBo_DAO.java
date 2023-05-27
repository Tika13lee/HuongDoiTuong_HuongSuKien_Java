package tuan10_30_QLVanDongVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CauLacBo_DAO {
	public ArrayList<CauLacBo> getAllCLB() {
		ArrayList<CauLacBo> dsCLB = new ArrayList<CauLacBo>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CauLacBo";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				CauLacBo clb = new CauLacBo(ma, ten);
				dsCLB.add(clb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCLB;
	}
}
