package hw2.exercise2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AssertWebElementsOnPageTest extends BaseTest {

    Assertion assertion = new Assertion();

    @Test
    public void isIndexPageTitleCorrect() {
        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");
        // 3. Perform login
        assertTrue(isWebElementDisplayed(By.id("user-name")));
        // 4. Assert User name in the left-top side of screen that user is loggedIn
        assertEquals(getUserName(), "ROMAN IOVLEV", "Not expected logged user");
        // 5. Open through the header menu Service -> Different Elements Page
        getWebElement(By.linkText("Service")).click();
        getWebElement(By.linkText("Different elements")).click();
        assertEquals(driver.getTitle(), "Different Elements", "Not expected Different elements" +
                "page title");
        // 6. Select checkboxes
        WebElement waterCheckbox = getWebElement(By.xpath("//label[normalize-space() = 'Water']"));
        WebElement windCheckbox = getWebElement(By.xpath("//label[normalize-space() = 'Wind']"));
        waterCheckbox.click();
        windCheckbox.click();
        assertTrue(waterCheckbox.isEnabled() && windCheckbox.isEnabled(), "Water and wind " +
                "checkboxes are not selected");
        // 7. Select radio
        WebElement selenRadioButton = getWebElement(By.xpath("//label[normalize-space() = 'Selen']"));
        selenRadioButton.click();
        assertTrue(selenRadioButton.isEnabled());
        // 8. Select in dropdown
        WebElement dropDownMenu = getWebElement(By.cssSelector(".colors select"));
        Select selectedElement = new Select(dropDownMenu);
        selectedElement.selectByVisibleText("Yellow");
        assertEquals(selectedElement.getFirstSelectedOption().getText(), "Yellow",
                "Not right element is selected");
        /* 9. Assert that
        •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        •	for radio button there is a log row and value is corresponded to the status of radio button
        •	for dropdown there is a log row and value is corresponded to the selected value.

        */
        WebElement webElementWater = getWebElement(By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        assertTrue(webElementWater.isDisplayed(), "Water checkbox is not displayed in log row");
        WebElement webElementWind = getWebElement(By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        assertTrue(webElementWind.isDisplayed(), "Wind checkbox is not displayed in log row");
        WebElement webElementSelen = getWebElement(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]"));
        assertTrue(webElementSelen.isDisplayed(), "Selen radio button is not displayed in log row");
        WebElement webElementYellow = getWebElement(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
        assertTrue(webElementYellow.isDisplayed(), "Dropdown selected color is not displayed in log row");
    }

}
