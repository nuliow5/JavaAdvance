package eu.codeacademy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/regitra";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    private static Connection connection;

    private static Connection buildConnection() {

        Connection conn;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = buildConnection();
        }
        return connection;
    }
}
