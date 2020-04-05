package hw3.pages.components;

import hw3.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ColorsDropdown extends AbstractPageComposite {

    @FindBy(css = ".colors select")
    private WebElement dropdownMenuElement;

    public ColorsDropdown(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("Not support because no elements in ColorsDropdown class");
    }

    public WebElement getWebElement() {
        return dropdownMenuElement;
    }

}
