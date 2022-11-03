package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils implements DBInfo {
	private static DBUtils instance;

	public DBUtils() {

	}

	public Connection getConnection() throws Exception {
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}

	public static DBUtils getInstance() {
		if (instance == null) {
			instance = new DBUtils();
		}
		return instance;
	}

	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}