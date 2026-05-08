package com.zerotrust.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    // Constants (Sonar clean + maintainable)
    private static final String SUCCESS = "Login Success";
    private static final String INVALID_CREDENTIALS = "Login Failed";
    private static final String VALID_USER = "admin";
    private static final String VALID_PASS = "1234";
    private static final String INVALID = "wrong";

    @Test
    void testLoginSuccess() {
        LoginController controller = new LoginController();

        String result = controller.login(VALID_USER, VALID_PASS);

        assertEquals(SUCCESS, result);
    }

    @Test
    void testLoginInvalidCredentials() {
        LoginController controller = new LoginController();

        String result = controller.login(INVALID, INVALID);

        assertEquals(INVALID_CREDENTIALS, result);
    }

    @Test
    void testLoginEmptyInput() {
        LoginController controller = new LoginController();

        String result = controller.login("", "");

        assertEquals(INVALID_CREDENTIALS, result);
    }

    @Test
    void testLoginNullInput() {
        LoginController controller = new LoginController();

        String result = controller.login(null, null);

        assertEquals(INVALID_CREDENTIALS, result);
    }

    @Test
    void testLoginPartialCorrect() {
        LoginController controller = new LoginController();

        String result = controller.login(VALID_USER, INVALID);

        assertEquals(INVALID_CREDENTIALS, result);
    }

    @Test
    void testLoginCaseSensitivity() {
        LoginController controller = new LoginController();

        String result = controller.login("ADMIN", VALID_PASS);

        assertEquals(INVALID_CREDENTIALS, result);
    }
}