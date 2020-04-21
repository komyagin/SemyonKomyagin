package hw6.pages.components;

import hw6.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxRow extends AbstractPageComposite {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    public CheckboxRow(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return checkBoxElements;
    }

}
