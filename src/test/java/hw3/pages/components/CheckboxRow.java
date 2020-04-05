package hw3.pages.components;

import hw3.pages.AbstratctPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxRow extends AbstratctPageComposite {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    public CheckboxRow(WebDriver driver) {
        super(driver);
    }

    public void setCheckBox(String checkboxName){
        for (WebElement checkBoxElement : checkBoxElements) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(checkboxName))
                checkBoxElement.click();
        }
    }
}
