package hw5.pages;

import hw5.pages.components.CheckboxRow;
import hw5.pages.components.ColorsDropdown;
import hw5.pages.components.LogsSection;
import hw5.pages.components.RadioButtonsRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class JDITestingDifferentElementsPage extends AbstractPage {

    private LogsSection logSection;

    private CheckboxRow checkboxRow;

    private RadioButtonsRow radioRow;

    private ColorsDropdown colorsDropdown;

    public JDITestingDifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        this.logSection = new LogsSection(driver);
        this.checkboxRow = new CheckboxRow(driver);
        this.radioRow = new RadioButtonsRow(driver);
        this.colorsDropdown = new ColorsDropdown(driver);
    }

    public void setCheckbox(String checkboxName){
        checkboxRow.setElementToChecked(checkboxName, checkboxRow.getWebElements());
    }

    public void setRadioRow(String radioRowName){
        radioRow.setElementToChecked(radioRowName, radioRow.getWebElements());
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status){
        return logSection.isElementIsDisplayedOnSection(checkboxName,  status, logSection.getWebElements());
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logSection.isElementIsDisplayedOnSection(radioName, logSection.getWebElements());
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return logSection.isElementIsDisplayedOnSection(dropdownValue, logSection.getWebElements());
    }

    public void setColorDropDown(String color){
        Select select = new Select(colorsDropdown.getWebElement());
        select.selectByVisibleText(color);
    }



}
