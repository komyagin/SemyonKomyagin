package hw3.pages;

import hw3.pages.components.CheckboxRow;
import hw3.pages.components.LogsSection;
import hw3.pages.components.RadioButtonsRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JDITestingDifferentElementsPage extends AbstractPage {

    private LogsSection logSection;

    private CheckboxRow checkboxRow;

    private RadioButtonsRow radioRow;

    private WebElement colorsDropdown;

    public JDITestingDifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        this.logSection = new LogsSection(driver);
        this.checkboxRow = new CheckboxRow(driver);
        this.radioRow = new RadioButtonsRow(driver);
    }

    public void setCheckbox(String checkboxName){
        checkboxRow.setCheckBox(checkboxName);
    }

    public void setRadioRow(String radioRowName){
        radioRow.setRadio(radioRowName);
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status){
        return logSection.isCheckboxLogDisplayed(checkboxName,  status);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logSection.isRadioLogDisplayed(radioName);
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return logSection.isDropdownLogDisplayed(dropdownValue);
    }

    public void setColorDropDown(String color){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        colorsDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".colors select")));
        Select select = new Select(colorsDropdown);
        select.selectByVisibleText(color);
    }
}
