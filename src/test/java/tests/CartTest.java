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
        
        // Let's open the details page first to verify the name/price matches the cart
        productPage.openFirstProductDetails();
        String expectedName = productPage.getProductName();
        String expectedPrice = productPage.getProductPrice();
        
        // Go back to products and add to cart
        productPage.navigateToProducts();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.isProductInCart(), "Product should be added to the cart.");
        
        String actualName = cartPage.getFirstProductName();
        String actualPrice = cartPage.getFirstProductPrice();
        
        Assert.assertEquals(actualName, expectedName, "Product name in cart should match.");
        Assert.assertEquals(actualPrice, expectedPrice, "Product price in cart should match.");
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
