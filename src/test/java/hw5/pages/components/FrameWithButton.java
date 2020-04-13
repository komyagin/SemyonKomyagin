package hw5.pages.components;

import hw5.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FrameWithButton extends AbstractPageComposite {

    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "button-frame")
    private WebElement button;

    public FrameWithButton(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException();
    }

    public void switchToFrame(){
        driver.switchTo().frame("frame");
    }
    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }
    public boolean isButtonDisplayed(){
        return button.isDisplayed();
    }
    public boolean isFrameDisplayed(){
        return frame.isDisplayed();
    }
}
