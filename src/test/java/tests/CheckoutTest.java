package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    @Test(priority = 1, description = "Verify complete checkout flow")
    public void testCheckoutFlow() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        productPage.navigateToProducts();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        cartPage.navigateToCart();
        cartPage.proceedToCheckout();

    }
}
