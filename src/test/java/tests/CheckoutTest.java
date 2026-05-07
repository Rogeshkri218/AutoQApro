package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import java.util.UUID;

public class CheckoutTest extends BaseTest {

    @Test(priority = 1, description = "Verify checkout without login prompts to login/register")
    public void testCheckoutWithoutLogin() {
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
        
        Assert.assertTrue(checkoutPage.isRegisterLoginModalDisplayed(), "Register / Login modal should be displayed.");
        
        checkoutPage.clickRegisterLoginFromModal();
        LoginPage loginPage = new LoginPage(driver);
        
        // As a basic validation, check if login button exists
        Assert.assertTrue(loginPage.isEmailFieldRequired(), "Should be redirected to login page.");
    }

    @Test(priority = 2, description = "Verify complete checkout flow")
    public void testCompleteCheckoutFlow() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Register a user first
        loginPage.navigateToLogin();
        String randomEmail = "buyer" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        loginPage.registerNewUser("Buyer User", randomEmail);
        loginPage.fillAccountInformation("Pass123", "Buyer", "User", "123 Main St", "NY", "New York", "10001", "1234567890");
        loginPage.clickContinueAfterRegistration();
        
        // 2. Add product to cart
        productPage.navigateToProducts();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        
        // 3. Proceed to checkout
        cartPage.navigateToCart();
        cartPage.proceedToCheckout();
        
        // 4. Place order
        checkoutPage.placeOrder();
        
        // 5. Enter payment details
        checkoutPage.enterPaymentDetails("Buyer User", "4111222233334444", "123", "12", "2025");
        checkoutPage.confirmPayment();
        
        // 6. Verify order success
        Assert.assertTrue(checkoutPage.isOrderConfirmed(), "Order should be confirmed successfully.");
        
        // 7. Cleanup (Logout or Delete Account, just logging out for now)
        loginPage.logout();
    }
}
