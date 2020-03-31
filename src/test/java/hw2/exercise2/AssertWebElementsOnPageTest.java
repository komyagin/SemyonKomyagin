package hw2.exercise2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertWebElementsOnPageTest extends BaseTest {

    @Test
    public void checkWebElementsOnPage() {

        assertTrue(waitForTitle("Home Page"));

        waitForElementLocatedBy(By.id("user-icon")).click();
        waitForElementLocatedBy(By.id("name")).sendKeys("Roman");
        waitForElementLocatedBy(By.id("password")).sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();

        assertEquals(waitForElementLocatedBy(By.id("user-name")).getText(), "ROMAN IOVLEV");

        waitForElementLocatedBy(By.xpath("//header//*[contains(text(), 'Service')]")).click();
        waitForElementLocatedBy(By.xpath("//header//*[contains(text(), 'Different elements')]")).click();
        waitForElementLocatedBy(By.xpath("//label[contains(text()[normalize-space()], 'Water')]")).click();
        waitForElementLocatedBy(By.xpath("//label[contains(text()[normalize-space()], 'Wind')]")).click();
        waitForElementLocatedBy(By.xpath("//label[contains(text()[normalize-space()], 'Selen')]")).click();

        Select selectedDropDown = new Select(waitForElementLocatedBy(By.tagName("select")));
        selectedDropDown.selectByVisibleText("Yellow");

        List<WebElement> logElements = waitForAllElementsLocatedBy(By.cssSelector(".panel-body-list.logs > li"));
        String[] expectedLogs = {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true"};

        for (int i = 0; i < expectedLogs.length; i++) {
            System.out.println(logElements.get(i).getText() + "\n" + expectedLogs[i]);
            assertTrue(logElements.get(i).getText().contains(expectedLogs[i]));
        }
    }

}
