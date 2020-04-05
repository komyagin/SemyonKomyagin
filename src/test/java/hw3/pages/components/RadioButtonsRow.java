package hw3.pages.components;

import hw3.pages.AbstratctPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButtonsRow extends AbstratctPageComposite {

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonElemetnts;

    public RadioButtonsRow(WebDriver driver) {
        super(driver);
    }

    public void setRadio(String radioButtonName){
        for (WebElement radioButtonElement : radioButtonElemetnts) {
            if(!radioButtonElement.isSelected() & radioButtonElement.getText().equals(radioButtonName))
                radioButtonElement.click();
        }
    }
}
