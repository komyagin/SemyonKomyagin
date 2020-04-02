package hw3.exercise2;

import hw3.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AssertWebElementsOnPageTest extends BaseTest {

    // 2. Assert Browser title
    @Test(priority = 1)
    public void isIndexPageTitleCorrect() {
        assertEquals(driver.getTitle(), "Home Page", "Not expected Index page title");
    }

    // 3. Perform login
    @Test(priority = 2)
    public void isUserLoggedIn() {
        assertTrue(isWebElementDisplayed(By.id("user-name")));
    }

    // 4. Assert User name in the left-top side of screen that user is loggedIn
    @Test(priority = 3)
    public void isCorrectUserNameDisplayed() {
        assertEquals(getUserName(), "ROMAN IOVLEV", "Not expected logged user");
    }

    // 5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 4)
    public void isDifferentElementsPageOpened() {
        getWebElement(By.linkText("Service")).click();
        getWebElement(By.linkText("Different elements")).click();
        assertEquals(driver.getTitle(), "Different Elements", "Not expected Different elements" +
                "page title");
    }

    // 6. Select checkboxes
    @Test(priority = 5)
    public void areCheckboxesSelected() {
        WebElement waterCheckbox = getWebElement(By.xpath("//label[normalize-space() = 'Water']"));
        WebElement windCheckbox = getWebElement(By.xpath("//label[normalize-space() = 'Wind']"));
        waterCheckbox.click();
        windCheckbox.click();
        assertTrue(waterCheckbox.isEnabled() && windCheckbox.isEnabled(), "Water and wind " +
                "checkboxes are not selected");
    }

    // 7. Select radio
    @Test(priority = 6)
    public void isRadioButtonChecked() {
        WebElement selenRadioButton = getWebElement(By.xpath("//label[normalize-space() = 'Selen']"));
        selenRadioButton.click();
        assertTrue(selenRadioButton.isEnabled());
    }

    // 8. Select in dropdown
    @Test(priority = 7)
    public void isCorrectElementInDropDownSelected() {
        WebElement dropDownMenu = getWebElement(By.cssSelector(".colors select"));
        Select selectedElement =new Select(dropDownMenu);
        selectedElement.selectByVisibleText("Yellow");
        assertEquals(selectedElement.getFirstSelectedOption().getText(), "Yellow",
                "Not right element is selected");
    }

    /* 9. Assert that
        •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        •	for radio button there is a log row and value is corresponded to the status of radio button
        •	for dropdown there is a log row and value is corresponded to the selected value.

    */
    @Test(priority = 8)
    public void isWaterCheckboxIsDisplayedInLogRow() {
        WebElement webElement = getWebElement(By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        assertTrue(webElement.isDisplayed(), "Water checkbox is not displayed in log row");
    }

    @Test(priority = 9)
    public void isWindCheckboxIsDisplayedInLogRow() {
        WebElement webElement = getWebElement(By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        assertTrue(webElement.isDisplayed(), "Wind checkbox is not displayed in log row");
    }

    @Test(priority = 10)
    public void isSelenRadioButtonIsDisplayedInLogRow() {
        WebElement webElement = getWebElement(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]"));
        assertTrue(webElement.isDisplayed(), "Selen radio button is not displayed in log row");
    }

    @Test(priority = 11)
    public void isDropdownSelectedColorIsDisplayedInLogRow() {
        WebElement webElement = getWebElement(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
        assertTrue(webElement.isDisplayed(), "Dropdown selected color is not displayed in log row");
    }
}
