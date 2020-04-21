package hw6.pages.components;

import hw6.pages.AbstractPageComposite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LogsSection extends AbstractPageComposite {

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public LogsSection(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("info-panel-body-log")));
    }

    @Override
    public List<WebElement> getWebElements() {
        return logs;
    }

    public boolean isLogTextDisplayed(String logText) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(logText)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    public boolean isElementIsDisplayedOnSection(String elementName) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(elementName + ": condition changed to ")) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

}
