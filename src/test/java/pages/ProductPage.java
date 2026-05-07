package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By productsLink = By.xpath("//a[contains(@href, '/products')]");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private By firstProductAddToCart = By.xpath("(//a[contains(@class, 'add-to-cart')])[1]");
    private By continueShoppingBtn = By.cssSelector("button.btn-success");

    // Category Locators
    private By womenCategoryLink = By.xpath("//a[contains(@href, '#Women')]");
    private By womenDressSubcategoryLink = By.xpath("//a[contains(@href, '/category_products/1')]");
    private By categoryTitle = By.xpath("//h2[@class='title text-center']");

    // Product Details Locators
    private By viewProductFirstLink = By.xpath("(//ul[@class='nav nav-pills nav-justified']/li/a)[1]");
    private By productNameText = By.xpath("//div[@class='product-information']/h2");
    private By productPriceText = By.xpath("//div[@class='product-information']/span/span");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProducts() {
        clickElement(productsLink);
    }

    public void searchProduct(String productName) {
        typeText(searchInput, productName);
        clickElement(searchButton);
    }

    public boolean isSearchedProductsVisible() {
        return isElementDisplayed(searchedProductsTitle);
    }

    public void addFirstProductToCart() {
        clickElement(firstProductAddToCart);
    }

    public void continueShopping() {
        clickElement(continueShoppingBtn);
    }

    public void browseWomenDressCategory() {
        clickElement(womenCategoryLink);
        clickElement(womenDressSubcategoryLink);
    }

    public String getCategoryTitle() {
        return getElementText(categoryTitle);
    }

    public void openFirstProductDetails() {
        clickElement(viewProductFirstLink);
    }

    public String getProductName() {
        return getElementText(productNameText);
    }

    public String getProductPrice() {
        return getElementText(productPriceText);
    }
}
