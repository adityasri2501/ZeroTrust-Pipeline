package com.zerotrust.controller;

import com.zerotrust.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class LoginController {

    // Hardcoded secret (for Gitleaks)
    String API_KEY = System.getenv("API_KEY");

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        try {
            Connection conn = DBUtil.getConnection();

            // SQL Injection Vulnerability
            String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return "Login Success";
            } else {
                return "Login Failed";
            }

        } catch (Exception e) {
            return "Error";
        }
    }
}