package com.vrp.task_sf_simple.tests;

import org.junit.jupiter.api.*;

@DisplayName("Automation task SF Simple")
class AccountCreateTest extends TestBase {

    @BeforeAll
    static void beforeAll() {
        webDriver.get(host);
    }

    @Test
    @DisplayName("Create an Account.")
    void testCreate() {

        Assertions.assertAll("Account was created.",
                Assertions::fail
        );
    }

    @AfterAll
    static void afterAll() {
        webDriver.quit();
    }
}
