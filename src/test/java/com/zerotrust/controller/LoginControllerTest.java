package com.zerotrust.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    @Test
    void testLogin() {
        LoginController controller = new LoginController();

        String result = controller.login("admin", "1234");

        assertNotNull(result);
    }
}