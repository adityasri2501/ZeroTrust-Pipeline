package com.zerotrust.controller;

import com.zerotrust.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String pass) {

        if (isValidUser(username, pass)) {
            return "Login Success";
        } else {
            return "Login Failed";
        }
    }

    // 🔥 Extracted DB logic
    boolean isValidUser(String username, String pass) {

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT username, password FROM users WHERE username=? AND password=?")) {

            pstmt.setString(1, username);
            pstmt.setString(2, pass);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}