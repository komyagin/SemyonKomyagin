package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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

    private final String SITE_URL = properties.getProperty("url");
    private final String USER = properties.getProperty("user");
    private final String PASSWORD = properties.getProperty("password");
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        // 1. Open site by URL
        openSite(SITE_URL);
        // 3. Perform login
        logIn();
    }


    // 12. Close browser for exercise1
    // 10. Close browser for exercise2
    @AfterClass
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void logIn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("name"))).sendKeys(USER);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    public void openSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public boolean isWebElementDisplayed(By by) {
        return waitForWebElementLocated(by).isDisplayed();
    }

    public String getWebElementText(By by) {
        return waitForWebElementLocated(by).getText();
    }

    public WebElement getWebElement(By by) {
        return waitForWebElementLocated(by);
    }

    private WebElement waitForWebElementLocated(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitForWebElementsLocated(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public String getUserName() {
        return getWebElementText(By.id("user-name"));
    }

}
