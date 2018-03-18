package skip.api.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
    Connection con = null;
    
    public Connection getConnection() throws SQLException {
    	return con;
    }

    public Connect() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
          String url = "jdbc:oracle:thin:@localhost:1521:XE";
          Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
      con = DriverManager.getConnection(url, "uctf", "uctf");
    }

    public void closeConnection() throws SQLException {
          con.close();
    }
}