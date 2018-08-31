package by.makhon.webapp.connectionpool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    // JDBC Driver Name & Database URL
    private String JDBC_DB_URL = "jdbc:mysql://localhost/webappdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // JDBC Database Credentials
    private String JDBC_USER = "root";
    private String JDBC_PASS = "qwerty123#@!";
    private final int MAX_CONNECTIONS = 5;
    private List<Connection> availableConnections = new ArrayList<Connection>();
    private List<Connection> usingConnections = new ArrayList<Connection>();

    public ConnectionPool() throws SQLException {
        for (int cnt = 1 ; cnt < MAX_CONNECTIONS + 1 ; cnt++) {
            System.out.println("Connection number: " + cnt);
            availableConnections.add(this.createConnectionDB());
        }
    }

    private Connection createConnectionDB() throws SQLException{
        System.out.println("DB CONNECTED");
        return DriverManager.getConnection(this.JDBC_DB_URL, this.JDBC_USER, this.JDBC_PASS);
    }

    public Connection getConnectionFromPool() {
        if(availableConnections.isEmpty()) {
            System.out.println("ALL CONNECTIONS ARE USED");
            return null;
        }
        else {
            Connection conn = availableConnections.remove(availableConnections.size() - 1);
            usingConnections.add(conn);
            return conn;
        }
    }

    public boolean returnConnectionToPool(Connection conn) throws SQLException {
        if(conn != null) {
            usingConnections.remove(conn);
            availableConnections.add(conn);
            return true;
        }
        else {
            return false;
        }
    }

    public int getFreeConnectionsCount() {
        return availableConnections.size();
    }

}


