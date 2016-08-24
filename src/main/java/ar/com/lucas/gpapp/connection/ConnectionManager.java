package ar.com.lucas.gpapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection conn = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        if (conn == null) {
            String url = "jdbc:mysql://localhost:3306/"; 
            String dbName = "ejemplos";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
        }
        
        return conn;
    }
    
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
}
