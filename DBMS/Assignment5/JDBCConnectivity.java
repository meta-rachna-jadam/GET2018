import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnectivity {

    public static Connection getConnection(String databaseName, String uername, String password)
	  {
	    Connection connectionInstance = null;
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      String url = "jdbc:mysql://localhost:3306/"+ databaseName;
	      connectionInstance = DriverManager.getConnection(url, uername , password);
	    }
	    catch (ClassNotFoundException classNotFoundException)
	    {
	      classNotFoundException.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException sqlException)
	    {
	      sqlException.printStackTrace();
	      System.exit(2);
	    }
	    return connectionInstance;
	  }
}
