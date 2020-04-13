package hw5.test;

import hw5.utils.Properties;
import hw5.utils.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {

    protected final String USER = Properties.getProperty("user");
    protected final String PASSWORD = Properties.getProperty("password");
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void suiteSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void start() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }


    // 12. Close browser for exercise1
    // 10. Close browser for exercise2
    @AfterMethod
    public void stop() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }

}
