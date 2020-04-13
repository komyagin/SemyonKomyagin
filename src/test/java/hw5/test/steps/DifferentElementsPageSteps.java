package hw5.test.steps;

import hw3.pages.JDITestingDifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    private final JDITestingDifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.differentElementsPage = new JDITestingDifferentElementsPage(driver);
    }

    @Step("Check checkbox '{0}'")
    public void checkCheckbox(String checkboxName) {
        differentElementsPage.setCheckbox(checkboxName);
    }

    @Step("Check radio '{0}'")
    public void checkRadio(String radioName) {
        differentElementsPage.setRadioRow(radioName);
    }

    @Step("Set dropdown color to '{0}'")
    public void setColorDropdownTo(String color) {
        differentElementsPage.setColorDropDown(color);
    }

    @Step("For checkbox '{0}' there is individual log row with status '{1}'")
    public void individualLogRowForCheckboxShouldBe(String checkBox, String status) {
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBox, status));
    }

    @Step("For radio '{0}' there is individual log")
    public void individualLogRowForRadioShouldBeDisplayed(String radio) {
        assertTrue(differentElementsPage.isRadioLogDisplayed(radio));
    }

    @Step("For dropdown value '{0}' there is individual log row")
    public void individualLogRowForDropdownShouldBeDisplayed(String dropdownValue) {
        assertTrue(differentElementsPage.isDropdownLogDisplayed(dropdownValue));
    }
}