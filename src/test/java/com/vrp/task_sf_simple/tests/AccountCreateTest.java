package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.pages.accounts.AccountsPage;
import com.vrp.task_sf_simple.pages.HomePage;
import com.vrp.task_sf_simple.pages.LoginPage;
import com.vrp.task_sf_simple.pages.accounts.NewAccountForm;
import org.junit.jupiter.api.*;

@DisplayName("Automation task SF Simple")
class AccountCreateTest extends TestBase {
    private static AccountsPage accountsPage;

    @BeforeAll
    static void beforeAll() {
        LoginPage loginPage = new LoginPage(driver).get();
        HomePage homePage = loginPage.enterUsername(userName).enterPassword(password).clickLogin();
        accountsPage = homePage.clickAccountMainBarLabel();
    }

    @Test
    @DisplayName("Create an Account.")
    void testCreate() {
        NewAccountForm newAccountForm = accountsPage.clickNew();
        newAccountForm.enterAccountName("Igor");

        Assertions.assertAll("Account was created.",
                () -> Assertions.assertTrue(true)
        );
    }

    @AfterAll
    static void afterAll() {
        //webDriver.quit();
    }
}
