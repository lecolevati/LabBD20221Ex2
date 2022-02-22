package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	private Connection c;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String hostName = "127.0.0.1";
		String dbName = "unionview1";
		String user = "sa";
		String pass = "P4ssw0rd";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String connect = String.format(
				"jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s", 
				hostName, dbName, user, pass);
		c = DriverManager.getConnection(connect);
		return c;
		
	}
	
}
