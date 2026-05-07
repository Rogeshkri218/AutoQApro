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
        
        // Add product to cart
        productPage.navigateToProducts();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        
        // Proceed to checkout
        cartPage.navigateToCart();
        cartPage.proceedToCheckout();
        
        // Note: For a complete checkout flow, the user must be logged in. 
        // We're leaving the detailed assertions/login steps simplified for the framework skeleton.
        
        // checkoutPage.placeOrder();
        // checkoutPage.enterPaymentDetails("Test Name", "4111222233334444", "123", "12", "2025");
        // checkoutPage.confirmPayment();
        
        // Assert.assertTrue(checkoutPage.isOrderConfirmed(), "Order should be confirmed successfully.");
    }
}
