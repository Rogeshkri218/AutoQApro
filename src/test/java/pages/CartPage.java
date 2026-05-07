package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartLink = By.xpath("//a[contains(@href, '/view_cart')]");
    private By checkoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private By cartItems = By.cssSelector("tr[id^='product-']");
    private By removeFirstItemBtn = By.xpath("(//a[@class='cart_quantity_delete'])[1]");
    private By emptyCartMessage = By.xpath("//b[text()='Cart is empty!']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToCart() {
        clickElement(cartLink);
    }

    public boolean isProductInCart() {
        return isElementDisplayed(cartItems);
    }

    public void proceedToCheckout() {
        clickElement(checkoutButton);
    }

    public void removeProductFromCart() {
        clickElement(removeFirstItemBtn);
    }

    public boolean isCartEmpty() {
        return isElementDisplayed(emptyCartMessage);
    }
}
