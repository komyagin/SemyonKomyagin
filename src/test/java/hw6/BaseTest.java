package hw6;

import hw6.pages.utils.WebDriverSingleton;
import hw6.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);


    protected final String SITE_URL = Properties.getProperty("url");
    protected final String USER = Properties.getProperty("user");
    protected final String PASSWORD = Properties.getProperty("password");
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        wait = new WebDriverWait(driver, 5);
    }


    // 12. Close browser for exercise1
    // 10. Close browser for exercise2
    @AfterMethod
    public void stop() {
        driver.quit();
    }


    public void openSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


}
