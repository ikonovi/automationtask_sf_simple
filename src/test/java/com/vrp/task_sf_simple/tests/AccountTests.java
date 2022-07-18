package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.models.Account;
import com.vrp.task_sf_simple.pages.HomePage;
import com.vrp.task_sf_simple.pages.LoginPage;
import com.vrp.task_sf_simple.pages.accounts.AccountsPage;
import com.vrp.task_sf_simple.pages.accounts.EditAccountForm;
import com.vrp.task_sf_simple.pages.accounts.NewAccountForm;
import com.vrp.task_sf_simple.pages.accounts.ViewAccountPage;
import org.junit.jupiter.api.*;

import static com.vrp.task_sf_simple.configs.SystemProperties.PASSWORD;
import static com.vrp.task_sf_simple.configs.SystemProperties.USER_NAME;

@DisplayName("Automation task SF Simple")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTests extends TestBase {
    static AccountsPage accountsPage;
    static ViewAccountPage viewAccountPage;

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
        Account account = Account.newBuilder().name("Olaf 1").phone("+49111111111").build();

        NewAccountForm newAccountForm = accountsPage.clickNew();
        viewAccountPage = newAccountForm
                .enterAccountName(account.getName())
                .enterPhone(account.getPhone())
                .save();

        Assertions.assertAll("Account has been created.",
                () -> Assertions.assertEquals(account.getName(), viewAccountPage.getAccount(), "Account Name"),
                () -> Assertions.assertEquals(account.getPhone(), viewAccountPage.getPhone(), "Phone")
        );
    }

    @Test
    @Order(2)
    @DisplayName("Test Case no. 2: Edit an Account")
    void testEdit() {
        Account account = Account.newBuilder().name("Olaf 2").phone("+49222222222").build();

        EditAccountForm editAccountForm = viewAccountPage.clickEdit();
        ViewAccountPage viewAccountPageUpdated = editAccountForm
                .editAccountName(account.getName())
                .editPhone(account.getPhone())
                .save();

        Assertions.assertAll("Account has been updated.",
                () -> Assertions.assertTrue(viewAccountPageUpdated.isAccountUpdatedTo(account.getName()), "Account Name"),
                () -> Assertions.assertTrue(viewAccountPageUpdated.isPhoneUpdatedTo(account.getPhone()), "Phone")
        );
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}
