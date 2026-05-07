package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test(priority = 1, description = "Verify user can add a product to the cart")
    public void testAddProductToCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        
        productPage.navigateToProducts();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.isProductInCart(), "Product should be added to the cart.");
    }

    @Test(priority = 2, description = "Verify user can remove a product from the cart")
    public void testRemoveProductFromCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        
        // Add a product first
        productPage.navigateToProducts();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        
        // Remove it
        cartPage.navigateToCart();
        cartPage.removeProductFromCart();
        
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty after removing the product.");
    }
}
