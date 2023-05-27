package tuan9_30_QLCauThu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tuan8_30_QLNV.ConnectDB;

public class CauThu_DAO {
	public ArrayList<CauThu> getAllCauThu() {
		ArrayList<CauThu> dsCauThu = new ArrayList<CauThu>();
		try {
			ConnecDB.getInstance();
			Connection con = ConnecDB.getConnection();
			String sql = "Select * from CauThu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maVT = rs.getString(4);
				ViTriThiDau vt = new ViTriThiDau(maVT);
				CauThu ct = new CauThu(ma, ten, tuoi, vt);
				dsCauThu.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCauThu;
	}

	public boolean create(CauThu ct) {
		ConnecDB.getInstance();
		Connection con = ConnecDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CauThu values(?, ?, ?, ?)");
			stmt.setString(1, ct.getMaCauThu());
			stmt.setString(2, ct.getTenCauThu());
			stmt.setInt(3, ct.getTuoi());
			stmt.setString(4, ct.getViTri().getMaViTri());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public ArrayList<CauThu> getCauThuTheoViTri(String vt) {
		ArrayList<CauThu> dsCT = new ArrayList<CauThu>();
		ConnecDB.getInstance();
		Connection con = ConnecDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from CauThu where maViTri = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, vt);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maVT = rs.getString(4);
				ViTriThiDau vTri = new ViTriThiDau(maVT);
				CauThu ct = new CauThu(ma, ten, tuoi, vTri);
				dsCT.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsCT;
	}

	public boolean xoaCTTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnecDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "delete from CauThu where maCauThu = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
