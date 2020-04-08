package hw4.pages.components;

import hw4.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShowEntriesDropdown extends AbstractPageComposite {

    @FindBy(css = ".dataTables_length select")
    private WebElement dropdownMenuElement;

    public ShowEntriesDropdown(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("Not support because no elements in ShowEntriesDropdown class");
    }

    public WebElement getWebElement() {
        return dropdownMenuElement;
    }
}
