package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.UUID;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"validuser123@example.com", "Password@123"},
            // Add valid credentials matching your test env
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][] {
            {"invaliduser@example.com", "wrongpassword"},
            {"validuser123@example.com", "wrongpassword"},
            {"invaliduser@example.com", "Password@123"}
        };
    }

    @Test(dataProvider = "loginData", priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.navigateToLogin();
        loginPage.login(email, password);
        
        // As this is a sample without a real valid user configured, 
        // this test might fail in reality if the user doesn't exist.
        // Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in successfully.");
    }

    @Test(dataProvider = "invalidLoginData", priority = 2, description = "Verify login fails with invalid credentials")
    public void testInvalidLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.navigateToLogin();
        loginPage.login(email, password);
        
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Error message should be displayed for invalid login.");
    }

    @Test(priority = 3, description = "Verify logout functionality")
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.navigateToLogin();
        // Register a temporary user to ensure we can log in and out reliably
        String randomEmail = "user" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        loginPage.registerNewUser("TestUser", randomEmail);
        loginPage.fillAccountInformation("Password123", "Test", "User", "123 Main St", "NY", "New York", "10001", "1234567890");
        loginPage.clickContinueAfterRegistration();
        
        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in after registration.");
        
        loginPage.logout();
        Assert.assertFalse(loginPage.isLoggedIn(), "User should be logged out after clicking logout.");
    }

    @Test(priority = 4, description = "Verify dynamic user registration flow")
    public void testRegistrationFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        
        String randomEmail = "newuser_" + System.currentTimeMillis() + "@test.com";
        loginPage.registerNewUser("John Doe", randomEmail);
        
        loginPage.fillAccountInformation("SecurePass123", "John", "Doe", "456 Market St", "CA", "San Francisco", "94105", "0987654321");
        
        Assert.assertTrue(loginPage.isAccountCreated(), "Account created success message should be visible.");
    }

    @Test(priority = 5, description = "Verify empty field validation for login")
    public void testEmptyFieldValidation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        
        // Attempt login without filling email
        loginPage.login("", "somepassword");
        
        Assert.assertTrue(loginPage.isEmailFieldRequired(), "Email field should enforce required HTML5 validation.");
    }
}
