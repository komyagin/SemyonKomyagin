package hw3.exercise1;

import hw3.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class SoftAssertWebElementsTest extends BaseTest {

    @Test
    public void checkWebElementsOnPage() {
        SoftAssert softAssert = new SoftAssert();

        // 3. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");

        //  4. Assert User name in the left-top side of screen that user is logged
        softAssert.assertTrue(isWebElementDisplayed(By.id("user-name")));
        softAssert.assertEquals(getUserName(), "ROMAN IOVLEV", "Not expected logged user");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(waitForWebElementsLocated(By.cssSelector(".m-l8 > li")).size(), 4,
                "Not expected count of items on the header");
        String expectedHeaderText = "HOME\n" + "CONTACT FORM\n" + "SERVICE\n" + "METALS & COLORS";
        String actualHeaderText = getWebElementText(By.className("m-l8"));
        softAssert.assertEquals(actualHeaderText, expectedHeaderText, "Not expected text in the header");

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imageWebElementList = waitForWebElementsLocated(By.className("benefit-icon"));
        softAssert.assertEquals(imageWebElementList.size(), 4, "Not expected count of images" +
                " on the Index Page");
        imageWebElementList.forEach(e -> softAssert.assertTrue(e.isDisplayed()));

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(waitForWebElementsLocated(By.className("benefit-txt")).size(), 4,
                "Not expected count of text on the Index Page under icons");

        String expectedTextUnderIcons = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project\n" +
                "To be flexible and\n" +
                "customizable\n" +
                "To be multiplatform\n" +
                "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…";
        String actualTextUnderIcons = getWebElementText(By.className("benefits"));
        softAssert.assertEquals(actualTextUnderIcons, expectedTextUnderIcons,
                "Not expected text under icons on the Index Page");

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(isWebElementDisplayed(By.id("frame")));

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(isWebElementDisplayed(By.id("button-frame")));

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideBarMenuElements = waitForWebElementsLocated(By.cssSelector(".sidebar-menu > li"));
        softAssert.assertEquals(sideBarMenuElements.size(), 5,
                "Not expected count of items in the Left Section");
        sideBarMenuElements.forEach(elem -> softAssert.assertTrue(elem.isDisplayed()));
        String expectedSideBarMenuText = "Home\n" +
                "Contact form\n" +
                "Service\n" +
                "Metals & Colors\n" +
                "Elements packs";
        String actualSideBarMenuText = getWebElementText(By.cssSelector(".sidebar-menu"));
        softAssert.assertEquals(actualSideBarMenuText, expectedSideBarMenuText,
                "Not expected text in the Left Section");

        softAssert.assertAll();
    }
}
