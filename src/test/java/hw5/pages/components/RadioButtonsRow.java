package hw5.pages.components;

import hw5.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButtonsRow extends AbstractPageComposite {

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonElemetnts;

    public RadioButtonsRow(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return radioButtonElemetnts;
    }


}
