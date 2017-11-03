package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * For illustration only, DO NOT USE IN PRODUCTION.
 */
public final class DrillConnection {

	private static Connection drillConnection = null;
	
	public final static synchronized Connection getDefaultDrillConnection() throws ClassNotFoundException, SQLException {
		
		if (drillConnection == null) {
			openConnection();
		}
		
		return drillConnection;
	}
	
	public final static void closeDefaultDrillConnection() throws SQLException {
		if (drillConnection != null) {
			drillConnection.close();
		}
	}
	
	public final static Statement getStatementForDefaultConnection() throws SQLException, ClassNotFoundException {		
		return drillConnection != null ? drillConnection.createStatement() : getDefaultDrillConnection().createStatement();
	}
	
	private final static void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName(Parameters.JDBC_DRILL_DRIVER);
        drillConnection = DriverManager.getConnection(Parameters.DRILL_DB_URL);
	}
}
