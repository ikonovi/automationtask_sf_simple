package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.models.Account;
import com.vrp.task_sf_simple.pages.accounts.AccountsPage;
import com.vrp.task_sf_simple.pages.HomePage;
import com.vrp.task_sf_simple.pages.LoginPage;
import com.vrp.task_sf_simple.pages.accounts.ViewAccountPage;
import com.vrp.task_sf_simple.pages.accounts.NewAccountForm;
import org.junit.jupiter.api.*;

import static com.vrp.task_sf_simple.config.EnvironmentConfig.PASSWORD;
import static com.vrp.task_sf_simple.config.EnvironmentConfig.USER_NAME;

@DisplayName("Automation task SF Simple")
class AccountCreateTest extends TestBase {
    private static AccountsPage accountsPage;

    @BeforeAll
    static void beforeAll() {
        LoginPage loginPage = new LoginPage(driver).get();
        HomePage homePage = loginPage
                .enterUsername(USER_NAME)
                .enterPassword(PASSWORD)
                .clickLogin();
        accountsPage = homePage.clickAccountMainBarLabel();
    }

    @Test
    @DisplayName("Create an Account.")
    void testCreate() {
        Account account = Account.newBuilder().name("Igor").phone("12345").build();

        NewAccountForm newAccountForm = accountsPage.clickNew();
        ViewAccountPage viewAccountPage = newAccountForm
                .enterAccountName(account.getName())
                .enterPhone(account.getPhone())
                .save();
        Assertions.assertAll("Account has been created.",
                () -> Assertions.assertEquals(account.getName(), viewAccountPage.getAccount(), "Account Name"),
                () -> Assertions.assertEquals(account.getPhone(), viewAccountPage.getPhone(), "Phone")
        );
    }

    @AfterAll
    static void afterAll() {
        //webDriver.quit();
    }
}
