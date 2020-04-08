package hw4.pages.components;

import hw4.pages.AbstractPageComposite;
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

    public boolean isElementIsDisplayedOnSection(String elementName, String status) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(elementName + ": condition changed to " + status)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }
}
