package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By placeOrderButton = By.xpath("//a[contains(@href, '/payment')]");
    
    // Checkout Modal (When not logged in)
    private By registerLoginModalLink = By.xpath("//div[@class='modal-content']//u[text()='Register / Login']");
    
    // Payment Form
    private By nameOnCardInput = By.cssSelector("input[data-qa='name-on-card']");
    private By cardNumberInput = By.cssSelector("input[data-qa='card-number']");
    private By cvcInput = By.cssSelector("input[data-qa='cvc']");
    private By expiryMonthInput = By.cssSelector("input[data-qa='expiry-month']");
    private By expiryYearInput = By.cssSelector("input[data-qa='expiry-year']");
    private By payConfirmButton = By.cssSelector("button[data-qa='pay-button']");
    
    // Order Confirmation
    private By orderConfirmedText = By.cssSelector("h2[data-qa='order-placed']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder() {
        clickElement(placeOrderButton);
    }

    public boolean isRegisterLoginModalDisplayed() {
        return isElementDisplayed(registerLoginModalLink);
    }

    public void clickRegisterLoginFromModal() {
        clickElement(registerLoginModalLink);
    }

    public void enterPaymentDetails(String name, String card, String cvc, String month, String year) {
        typeText(nameOnCardInput, name);
        typeText(cardNumberInput, card);
        typeText(cvcInput, cvc);
        typeText(expiryMonthInput, month);
        typeText(expiryYearInput, year);
    }

    public void confirmPayment() {
        clickElement(payConfirmButton);
    }

    public boolean isOrderConfirmed() {
        return isElementDisplayed(orderConfirmedText);
    }
    
    public void clickContinue() {
        clickElement(continueButton);
    }
}
