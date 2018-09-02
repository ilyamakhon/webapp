package by.makhon.webapp.dbconnection;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost/webappdb";
    public static final String USER = "root";
    public static final String PASS = "root";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("DB CONNECTED");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}
