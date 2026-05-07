package com.zerotrust.controller;

import com.zerotrust.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class LoginController {

    // Hardcoded secret (for Gitleaks)
    // String API_KEY = 
    // for normal
    String API_KEY = System.getenv("API_KEY");

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        try {
            Connection conn = DBUtil.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

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