
package Conexiones;

import com.infomedia.utils.PropertyLoader;
import java.sql.*;
import java.util.Properties;

public class Conexion {
    public static final Properties prop = PropertyLoader.load("servicemanager.properties");
    
  
    public static final String user = prop.getProperty("rmrcontrol.db.user");
    public static final String pass = prop.getProperty("rmrcontrol.db.pass");
    public static final String url = prop.getProperty("rmrcontrol.db.url");

    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,pass);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException {
        smtm.close(); 
    }
    
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close(); 
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
