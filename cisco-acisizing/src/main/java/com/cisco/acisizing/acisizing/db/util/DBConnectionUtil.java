package com.cisco.acisizing.acisizing.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	private DBConnectionProps dbProps;

	public DBConnectionUtil() {
		dbProps = new DBConnectionProps();
	}

	public Connection openConnection() {
		Connection conn = null;

		try {
			Class.forName(dbProps.getDbDriver());
			conn = DriverManager.getConnection(dbProps.getDbUrl(),
					dbProps.getDbUsername(), dbProps.getDbPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
