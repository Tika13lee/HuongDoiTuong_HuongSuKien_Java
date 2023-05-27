package tuan9_30_QLCauThu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecDB {
	public static Connection con = null;
	private static ConnecDB instance = new ConnecDB();

	public static ConnecDB getInstance() {
		return instance;
	}

	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLCauThu";
		String user = "sa";
		String pass = "sapassword";
		con = DriverManager.getConnection(url, user, pass);
	}

	public void disConnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
