package hw3.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
    }

    protected final String SITE_URL = properties.getProperty("url");
    protected final String USER = properties.getProperty("user");
    protected final String PASSWORD = properties.getProperty("password");
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }


    // 12. Close browser for exercise1
    // 10. Close browser for exercise2
    @AfterMethod
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }


    public void openSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


}
