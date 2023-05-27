package tuan10_30_QLVanDongVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VanDongVien_DAO {
	public ArrayList<VanDongVien> getAllVDV() {
		ArrayList<VanDongVien> dsVDV = new ArrayList<VanDongVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from VanDongVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maCLB = rs.getString(4);
				CauLacBo clb = new CauLacBo(maCLB);
				VanDongVien vdv = new VanDongVien(ma, ten, tuoi, clb);
				dsVDV.add(vdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsVDV;
	}

	public boolean create(VanDongVien vdv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "insert into VanDongVien values(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vdv.getMaVDV());
			ps.setString(2, vdv.getTenVDV());
			ps.setInt(3, vdv.getTuoi());
			ps.setString(4, vdv.getClb().getMaCLB());
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

	public ArrayList<VanDongVien> getVDVTheoMaCLB(String maCLB) {
		ArrayList<VanDongVien> dsVDV = new ArrayList<VanDongVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "select * from VanDongVien where maCLB =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, maCLB);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maCLBo = rs.getString(4);
				CauLacBo clb = new CauLacBo(maCLBo);
				VanDongVien vdv = new VanDongVien(ma, ten, tuoi, clb);
				dsVDV.add(vdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsVDV;
	}

	public boolean xoaVDVTheoMa(String maVDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "delete from VanDongVien where maVDV=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, maVDV);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
