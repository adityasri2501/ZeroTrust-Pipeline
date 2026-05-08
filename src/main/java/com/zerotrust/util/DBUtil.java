package com.zerotrust.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBUtil {

    private DBUtil() {}  // add this

    public static Connection getConnection() throws SQLException {

        String dbPassword = System.getenv("DB_PASSWORD");

        Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb", "sa", dbPassword
        );

        try (Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS users (username VARCHAR(50), password VARCHAR(50))");

            stmt.execute("MERGE INTO users KEY(username) VALUES ('admin','1234')");
        }

        return conn;
    }
}