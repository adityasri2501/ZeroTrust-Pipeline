package com.zerotrust.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    private static final String SUCCESS = "Login Success";
    private static final String FAILED = "Login Failed";
    private static final String VALID_USER = "admin";
    private static final String VALID_PASS = "1234";
    private static final String INVALID = "wrong";

    // Mocked controller (override DB method)
    LoginController controller = new LoginController() {
        @Override
        boolean isValidUser(String username, String password) {
            return username != null && password != null
                    && username.equals(VALID_USER)
                    && password.equals(VALID_PASS);
        }
    };

    @Test
    void testLoginSuccess() {
        String result = controller.login(VALID_USER, VALID_PASS);
        assertEquals(SUCCESS, result);
    }

    @Test
    void testLoginInvalid() {
        String result = controller.login(INVALID, INVALID);
        assertEquals(FAILED, result);
    }

    @Test
    void testLoginNullInput() {
        String result = controller.login(null, null);
        assertEquals(FAILED, result);
    }

    @Test
    void testLoginEmptyInput() {
        String result = controller.login("", "");
        assertEquals(FAILED, result);
    }

    @Test
    void testLoginPartialCorrect() {
        String result = controller.login(VALID_USER, INVALID);
        assertEquals(FAILED, result);
    }

    @Test
    void testLoginCaseSensitivity() {
        String result = controller.login("ADMIN", VALID_PASS);
        assertEquals(FAILED, result);
    }

    // CRITICAL: missing branch coverage 
    @Test
    void testUsernameEmptyPasswordValid() {
        String result = controller.login("", VALID_PASS);
        assertEquals(FAILED, result);
    }

    @Test
    void testUsernameValidPasswordEmpty() {
        String result = controller.login(VALID_USER, "");
        assertEquals(FAILED, result);
    }
}