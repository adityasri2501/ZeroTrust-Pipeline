package com.zerotrust.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    private static final String SUCCESS = "Login Success";
    private static final String FAILED = "Login Failed";
    private static final String VALID_USER = "admin";
    private static final String VALID_PASS = "1234";
    private static final String INVALID = "wrong";

    // Mocked controller
    LoginController controller = new LoginController() {
        @Override
        boolean isValidUser(String username, String pass) {
            return username != null && pass != null
                    && username.equals(VALID_USER)
                    && pass.equals(VALID_PASS);
        }
    };

    @Test
    void testSuccess() {
        assertEquals(SUCCESS, controller.login(VALID_USER, VALID_PASS));
    }

    @Test
    void testInvalid() {
        assertEquals(FAILED, controller.login(INVALID, INVALID));
    }

    @Test
    void testNullBoth() {
        assertEquals(FAILED, controller.login(null, null));
    }

    @Test
    void testEmptyBoth() {
        assertEquals(FAILED, controller.login("", ""));
    }

    // @Test
    // void testOnlyUsernameCorrect() {
    //     assertEquals(FAILED, controller.login(VALID_USER, INVALID));
    // }

    // @Test
    // void testOnlyPasswordCorrect() {
    //     assertEquals(FAILED, controller.login(INVALID, VALID_PASS));
    // }

    // @Test
    // void testCaseMismatch() {
    //     assertEquals(FAILED, controller.login("ADMIN", VALID_PASS));
    // }

    // @Test
    // void testWhitespaceInput() {
    //     assertEquals(FAILED, controller.login(" ", " "));
    // }

    // // THIS IS CRITICAL (forces actual method execution path)
    // @Test
    // void testRealExecutionPath() {
    //     LoginController real = new LoginController();
    //     String result = real.login("random", "random");
    //     assertNotNull(result);
    // }

}