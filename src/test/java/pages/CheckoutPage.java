package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By placeOrderButton = By.xpath("//a[contains(@href, '/payment')]");
    
    // Payment Form
    private By nameOnCardInput = By.name("name_on_card");
    private By cardNumberInput = By.name("card_number");
    private By cvcInput = By.name("cvc");
    private By expiryMonthInput = By.name("expiry_month");
    private By expiryYearInput = By.name("expiry_year");
    private By payConfirmButton = By.id("submit");
    
    // Order Confirmation
    private By orderConfirmedText = By.xpath("//b[contains(text(), 'Order Placed!')]");
    private By continueButton = By.xpath("//a[text()='Continue']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder() {
        clickElement(placeOrderButton);
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
