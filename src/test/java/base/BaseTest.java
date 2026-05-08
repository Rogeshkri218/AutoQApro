package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        String browser = ConfigReader.getProperty("browser");
        DriverFactory.initDriver(browser);
        
        String baseUrl = ConfigReader.getProperty("baseUrl");
        DriverFactory.getDriver().get(baseUrl);
    }

    @BeforeClass
    public void setUpClass() {
        // Assign the single ThreadLocal driver instance to the class-level variable
        this.driver = DriverFactory.getDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        DriverFactory.quitDriver();
    }
}
