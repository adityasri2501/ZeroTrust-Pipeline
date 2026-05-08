package com.zerotrust.controller;

import com.zerotrust.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class LoginController {

    String apiKey = System.getenv("API_KEY");

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        try (Connection conn = DBUtil.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(
             "SELECT username, password FROM users WHERE username=? AND password=?")) {

    pstmt.setString(1, username);
    pstmt.setString(2, password);

    try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
            return "Login Success";
        } else {
            return "Login Failed";
        }
    }

} catch (SQLException e) {
    e.printStackTrace();
    return "Error";
}
    }
}