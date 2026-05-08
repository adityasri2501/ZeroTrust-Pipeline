package com.zerotrust.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    @Test
    void testLoginSuccess() {
        LoginController controller = new LoginController();

        String result = controller.login("admin", "1234");

        assertEquals("Login Success", result);  // adjust if needed
    }

    @Test
    void testLoginInvalid() {
        LoginController controller = new LoginController();

        String result = controller.login("wrong", "wrong");

        assertNotEquals("Login Success", result);
    }

    @Test
    void testLoginEmptyInput() {
        LoginController controller = new LoginController();

        String result = controller.login("", "");

        assertNotNull(result);
    }

    @Test
    void testLoginNullInput() {
        LoginController controller = new LoginController();

        String result = controller.login(null, null);

        assertNotNull(result);
    }
}