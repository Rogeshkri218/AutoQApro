package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"validuser123@example.com", "Password@123"},
        };
    }
    @Test(dataProvider = "loginData", priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login(email, password);
    }

    @Test(priority = 2, description = "Verify login fails with invalid credentials")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login("invaliduser@example.com", "wrongpassword");
        
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Error message should be displayed for invalid login.");
    }
    @Test(priority = 3, description = "Verify logout functionality")
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
    }
}
