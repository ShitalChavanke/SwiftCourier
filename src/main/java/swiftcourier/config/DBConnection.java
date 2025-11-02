package swiftcourier.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/swift_courier_db";
    private static final String USER = "root";
    private static final String PASS = "password";

    static {
        try {
            // If using MySQL: com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver class not found. Add the JDBC driver to classpath.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
