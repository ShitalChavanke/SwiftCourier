package swiftcourier.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/swift_courier_db";
    private static final String USER = "postgres";
    private static final String PASS = "Root";

    static {
        try {
            // Using postgres
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver class not found. Add the JDBC driver to classpath.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
