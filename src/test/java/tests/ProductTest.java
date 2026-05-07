package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test(priority = 1, description = "Verify user can search for a product")
    public void testProductSearch() {
        ProductPage productPage = new ProductPage(driver);
        
        productPage.navigateToProducts();
        productPage.searchProduct("T-Shirt");
        
        Assert.assertTrue(productPage.isSearchedProductsVisible(), "'Searched Products' title should be visible.");
    }

    @Test(priority = 2, description = "Verify user can browse products by category")
    public void testBrowseProductsByCategory() {
        ProductPage productPage = new ProductPage(driver);
        
        // Ensure we are on a page where the category sidebar is visible
        productPage.navigateToProducts();
        productPage.browseWomenDressCategory();
        
        String categoryTitle = productPage.getCategoryTitle();
        Assert.assertEquals(categoryTitle, "WOMEN - DRESS PRODUCTS", "Category title does not match.");
    }

    @Test(priority = 3, description = "Verify product details are displayed correctly")
    public void testVerifyProductDetails() {
        ProductPage productPage = new ProductPage(driver);
        
        productPage.navigateToProducts();
        productPage.openFirstProductDetails();
        
        String name = productPage.getProductName();
        String price = productPage.getProductPrice();
        
        Assert.assertNotNull(name, "Product name should not be null.");
        Assert.assertFalse(name.isEmpty(), "Product name should not be empty.");
        Assert.assertNotNull(price, "Product price should not be null.");
        Assert.assertTrue(price.contains("Rs."), "Product price should contain currency.");
    }
}
