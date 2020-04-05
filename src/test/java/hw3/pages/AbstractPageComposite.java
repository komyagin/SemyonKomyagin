package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageComposite {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver, this);
    }

}
