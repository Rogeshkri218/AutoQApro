package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private By signupLoginLink = By.xpath("//a[contains(@href, '/login')]");
    
    // Login Locators
    private By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loggedInUserText = By.xpath("//li/a[contains(text(), 'Logged in as')]");
    private By logoutLink = By.xpath("//a[contains(@href, '/logout')]");
    private By loginErrorText = By.xpath("//p[contains(text(), 'email address or password')]");

    // Registration Locators
    private By signupNameInput = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin() {
        clickElement(signupLoginLink);
    }

    public void login(String email, String password) {
        typeText(loginEmailInput, email);
        typeText(loginPasswordInput, password);
        clickElement(loginButton);
    }

    public boolean isLoggedIn() {
        return isElementDisplayed(loggedInUserText);
    }

    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(loginErrorText);
    }

    public void logout() {
        clickElement(logoutLink);
    }
    
    public void registerNewUser(String name, String email) {
        typeText(signupNameInput, name);
        typeText(signupEmailInput, email);
        clickElement(signupButton);
    }
}
