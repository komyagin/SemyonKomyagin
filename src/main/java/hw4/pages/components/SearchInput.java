package hw4.pages.components;

import hw4.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchInput extends AbstractPageComposite {

    @FindBy(css = ".dataTables_filter input")
    private WebElement searchInput;

    public SearchInput(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("Not supported in SearchInput");
    }

    public WebElement getWebElement() {
        return searchInput;
    }
}
