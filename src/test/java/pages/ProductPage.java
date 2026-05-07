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
}
