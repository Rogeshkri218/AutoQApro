package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
        
        String baseUrl = ConfigReader.getProperty("baseUrl");
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
