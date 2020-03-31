package hw2.exercise1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SoftAssertWebElementsTest extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkWebElementsOnPage() {
        softAssert.assertTrue(waitForTitle("Home Page"));

        waitForElementLocatedBy(By.id("user-icon")).click();
        waitForElementLocatedBy(By.id("name")).sendKeys("Roman");
        waitForElementLocatedBy(By.id("password")).sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();

        softAssert.assertEquals(waitForElementLocatedBy(By.id("user-name")).getText(), "ROMAN IOVLEV");

        List<WebElement> headerElements = waitForAllElementsLocatedBy(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));
        String[] headerExpectedElements = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        for (int i = 0; i < headerExpectedElements.length; i++) {
            assertEquals(headerElements.get(i).getText(), headerExpectedElements[i]);
        }

        List<WebElement> imageElements = waitForAllElementsLocatedBy(By.className("benefit-icon"));
        softAssert.assertEquals(imageElements.size(), 4);
        imageElements.forEach((WebElement image) -> assertTrue(image.isDisplayed()));

        List<WebElement> textElements = waitForAllElementsLocatedBy(By.className("benefit"));

        String[] expectedTextElements = {"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"};

        for (int i = 0; i < expectedTextElements.length; i++) {
            softAssert.assertEquals(textElements.get(i).getText(), expectedTextElements[i]);
        }

        WebElement frameElement = waitForElementLocatedBy(By.id("frame"));
        softAssert.assertTrue(frameElement.isDisplayed());

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
        softAssert.assertTrue(waitForElementLocatedBy(By.id("frame-button")).isDisplayed());

        webDriver.switchTo().defaultContent();

        List<WebElement> leftSectionElements = waitForAllElementsLocatedBy(By.cssSelector(".sidebar-menu > li"));
        String[] leftSectionExpectedElements = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

        for (int i = 0; i < leftSectionExpectedElements.length; i++) {
            softAssert.assertEquals(leftSectionElements.get(i).getText(), leftSectionExpectedElements[i]);
        }

        softAssert.assertAll();
    }
}
