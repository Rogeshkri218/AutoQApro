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
}
