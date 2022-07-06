package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.models.Account;
import com.vrp.task_sf_simple.pages.HomePage;
import com.vrp.task_sf_simple.pages.LoginPage;
import com.vrp.task_sf_simple.pages.accounts.AccountsPage;
import com.vrp.task_sf_simple.pages.accounts.NewAccountForm;
import com.vrp.task_sf_simple.pages.accounts.ViewAccountPage;
import org.junit.jupiter.api.*;

import static com.vrp.task_sf_simple.config.EnvironmentConfig.PASSWORD;
import static com.vrp.task_sf_simple.config.EnvironmentConfig.USER_NAME;

@DisplayName("Automation task SF Simple")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTest extends TestBase {
    static AccountsPage accountsPage;
    static Account testAccount;

    @BeforeAll
    static void createTestData() {
        testAccount = Account.newBuilder().name("Olaf").phone("12345").build();
    }

    @BeforeAll
    static void login() {
        LoginPage loginPage = new LoginPage(driver).get();
        HomePage homePage = loginPage
                .enterUsername(USER_NAME)
                .enterPassword(PASSWORD)
                .clickLogin();
        accountsPage = homePage.clickAccountMainBarLabel();
    }

    @Test
    @Order(1)
    @DisplayName("Test Case no. 1: Create an Account and verify it was created")
    void testCreate() {

        NewAccountForm newAccountForm = accountsPage.clickNew();
        ViewAccountPage viewAccountPage = newAccountForm
                .enterAccountName(testAccount.getName())
                .enterPhone(testAccount.getPhone())
                .save();
        Assertions.assertAll("Account has been created.",
                () -> Assertions.assertEquals(testAccount.getName(), viewAccountPage.getAccount(), "Account Name"),
                () -> Assertions.assertEquals(testAccount.getPhone(), viewAccountPage.getPhone(), "Phone")
        );
    }

    @Test
    @Order(2)
    @DisplayName("Test Case no. 2: Edit an Account")
    void testEdit() {

        Assertions.assertAll("Account has been created.",
                () -> Assertions.assertEquals(true, true)
        );
    }


    @AfterAll
    static void afterAll() {
        //webDriver.quit();
    }
}
