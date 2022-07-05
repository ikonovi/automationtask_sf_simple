package com.vrp.task_sf_simple.tests;

import org.junit.jupiter.api.*;

@DisplayName("Automation task SF Simple")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountEditTest extends TestBase {

    @Test
    @Order(1)
    @DisplayName("Create an Account.")
    void testCreate() {

        Assertions.assertAll("Account was created.",
                Assertions::fail
        );
    }

    @Test
    @Order(2)
    @DisplayName("Edit an Account")
    void testEdit() {
        Assertions.assertAll("Account was updated.",
                Assertions::fail
        );
    }
}
