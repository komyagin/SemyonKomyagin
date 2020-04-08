package hw4.pages;

import hw4.pages.components.SearchInput;
import hw4.pages.components.ShowEntriesDropdown;
import hw4.pages.components.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JDITestingTableWithPagesPage extends AbstractPage {

    private ShowEntriesDropdown dropdown;
    private SearchInput searchInput;
    private Table table;


    protected JDITestingTableWithPagesPage(WebDriver driver) {
        super(driver);
        dropdown = new ShowEntriesDropdown(driver);
        searchInput = new SearchInput(driver);
        table = new Table(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("Not supported method in JDITestingTableWithPagesPage class");
    }

    public WebElement getDropdown() {
        return dropdown.getWebElement();
    }

    public void sendKeysToSearchInput(String keys) {
        searchInput.getWebElement().sendKeys(keys);
    }

    public void setDropdownValue(String value){
        Select select = new Select(dropdown.getWebElement());
        select.selectByVisibleText(value);
    }

    public WebElement getSelectedDropdownValue() {
        Select select = new Select(dropdown.getWebElement());
        return select.getFirstSelectedOption();
    }

    public int getRowsCount() {
        return table.getRowsCount();
    }

    public List<WebElement> getTableValues() {
        return table.getWebElements();
    }
}
