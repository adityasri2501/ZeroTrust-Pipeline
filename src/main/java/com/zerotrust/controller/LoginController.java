package com.zerotrust.controller;

import com.zerotrust.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@PostMapping("/login")
public String login(@RequestParam String username, @RequestParam String password) {

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(
                 "SELECT * FROM users WHERE username=? AND password=?")) {

        pstmt.setString(1, username);
        pstmt.setString(2, password);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return "Login Success";
            } else {
                return "Login Failed";
            }
        }

    } catch (Exception e) {
        e.printStackTrace(); // debugging ke liye
        return "Error";
    }
}