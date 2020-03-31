package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {

    final String SITE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected WebDriver webDriver;

    @BeforeMethod (alwaysRun = true)
    public void start() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(SITE_URL);
    }

    @AfterMethod (alwaysRun = true)
    public  void stop() {
        webDriver.quit();
    }

    protected WebElement waitForElementLocatedBy(By by) {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitForAllElementsLocatedBy(By by) {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected Boolean waitForTitle(String title) {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.titleIs(title));
    }
}
