package tuan8_30_QLNV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhanVien_DAO {
	public NhanVien_DAO() {

	}

	// get all nhan vien
	public ArrayList<NhanVien> getalltbNhanVien() {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int ma = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean gt = rs.getBoolean(5);
				String maP = rs.getString(6);
				PhongBan pb = new PhongBan(maP);
				double tien = rs.getDouble(7);
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, gt, tien, pb);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	// get nhan vien by phong ban
	public ArrayList<NhanVien> getNhanVienTheoPhongBan(String idpb) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from nhanvien where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, idpb);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String hoNV = rs.getString("ho");
				String tenNV = rs.getString("ten");
				int tuoi = rs.getInt("tuoi");
				boolean phai = rs.getBoolean("phai");
				PhongBan pb = new PhongBan(rs.getString("maPhong"));
				double luong = rs.getDouble("tienLuong");
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pb);
//				NhanVien nv = new NhanVien(maNV);
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dsNV;
	}

	// create nhan vien
	public boolean createNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " NhanVien values(?, ? , ?, ?, ?, ?, ?)");
			stmt.setInt(1, nv.getMaNV());
			stmt.setString(2, nv.getHo());
			stmt.setString(3, nv.getTen());
			stmt.setInt(4, nv.getTuoi());
			stmt.setBoolean(5, nv.isPhai());
			stmt.setString(6, nv.getPhong().getMaPhong());
			stmt.setDouble(7, nv.getTienLuong());
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

	// delete nhan vien by ma
	public boolean xoaNVTheoMa(int ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "delete from NhanVien where maNV = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ma);
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

	// get nhan vien by ma
	public ArrayList<NhanVien> getNVTheoMa(int ma) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "select * from NhanVien where maNV = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean gt = rs.getBoolean(5);
				String maP = rs.getString(6);
				PhongBan pb = new PhongBan(maP);
				double tien = rs.getDouble(7);
				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, gt, tien, pb);
				ds.add(nv);
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
		return ds;
	}

	public boolean updateNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "update NhanVien set ho=?, ten=?, tuoi=?, phai=?, maPhong=?, tienLuong=? where maNV=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, nv.getHo());
			ps.setString(2, nv.getTen());
			ps.setInt(3, nv.getTuoi());
			ps.setBoolean(4, nv.isPhai());
			ps.setString(5, nv.getPhong().getMaPhong());
			ps.setDouble(6, nv.getTienLuong());
			ps.setInt(7, nv.getMaNV());
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