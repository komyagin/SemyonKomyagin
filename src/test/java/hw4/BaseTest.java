package hw4;

import hw4.webdriver.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Properties file not found {}", e);
        }
        WebDriverSingleton.INSTANCE.createdDriver(properties.getProperty("browser"));
    }

    protected final String SITE_URL = properties.getProperty("url");
    protected final String USER = properties.getProperty("user");
    protected final String PASSWORD = properties.getProperty("password");
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        wait =  WebDriverSingleton.INSTANCE.getWait();
    }


    // 12. Close browser for exercise1
    // 10. Close browser for exercise2
    @AfterMethod
    public void stop() {
        driver.manage().deleteAllCookies();
        //driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }


    public void openSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


}
