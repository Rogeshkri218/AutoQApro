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
    private By loginErrorText = By.xpath("//p[contains(text(), 'incorrect!')]");

    // Registration Locators - Step 1
    private By signupNameInput = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");

    // Registration Locators - Step 2 (Account Info)
    private By titleMrRadio = By.id("id_gender1");
    private By regPasswordInput = By.id("password");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By address1Input = By.id("address1");
    private By countrySelect = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    
    // Post Registration
    private By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");

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

    public void fillAccountInformation(String password, String firstName, String lastName, 
                                       String address, String state, String city, 
                                       String zipcode, String mobile) {
        clickElement(titleMrRadio);
        typeText(regPasswordInput, password);
        typeText(firstNameInput, firstName);
        typeText(lastNameInput, lastName);
        typeText(address1Input, address);
        typeText(stateInput, state);
        typeText(cityInput, city);
        typeText(zipcodeInput, zipcode);
        typeText(mobileNumberInput, mobile);
        clickElement(createAccountButton);
    }

    public boolean isAccountCreated() {
        return isElementDisplayed(accountCreatedText);
    }

    public void clickContinueAfterRegistration() {
        clickElement(continueButton);
    }

    public boolean isEmailFieldRequired() {
        String required = waitForElement(loginEmailInput).getAttribute("required");
        return required != null && (required.equals("true") || required.equals("required") || required.isEmpty());
    }
}
