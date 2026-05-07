package com.zerotrust.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBUtil {

    public static Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb", "sa", ""
        );

        Statement stmt = conn.createStatement();

        stmt.execute("CREATE TABLE IF NOT EXISTS users (username VARCHAR(50), password VARCHAR(50))");
        stmt.execute("INSERT INTO users VALUES ('admin','1234')");

        return conn;
    }
}