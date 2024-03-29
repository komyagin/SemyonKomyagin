package hw6.pages;

import hw6.pages.components.LogsSection;
import hw6.pages.enteties.JdiUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JdiTestingUserTablePage extends AbstractPage {

    private LogsSection logsSection;

    @FindBy(css = "#user-table tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#user-table select")
    private List<WebElement> usersSelects;

    @FindBy(css = "#user-table a")
    private List<WebElement> usersNames;

    @FindBy(css = "#user-table span")
    private List<WebElement> usersImagesDescriptions;

    @FindBy(css = "#user-table input")
    private List<WebElement> usersCheckboxes;

    @FindBy(xpath = "//td[text()=number()]")
    private List<WebElement> usersIds;

    public JdiTestingUserTablePage(WebDriver driver) {
        this.driver = driver;
        logsSection = new LogsSection(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<String> getUserRoles(String username) {
        waitForVisibilityOf(tableRows);
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(username)) {
                return getListAsString(webElement.findElements(By.cssSelector("select option")));
            }
        }
        return null;
    }

    public void setVipCheckbox(String username) {
        waitForVisibilityOf(tableRows);
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(username)) {
                webElement.findElement(By.tagName("input")).click();
            }
        }
    }

    public boolean isLogTextDisplayed(String logText) {
        return logsSection.isLogTextDisplayed(logText);
    }

    public List<String> getUsersIds() {
        waitForVisibilityOf(usersIds);
        return getListAsString(usersIds);
    }

    public List<String> getUsersNames() {
        waitForVisibilityOf(usersNames);
        return getListAsString(usersNames);
    }

    public List<String> getUsersImagesDescriptions() {
        waitForVisibilityOf(usersImagesDescriptions);
        return getListAsString(usersImagesDescriptions);
    }

    public List<WebElement> getUsersSelects() {
        waitForVisibilityOf(usersSelects);
        return usersSelects;
    }

    public List<WebElement> getUsersCheckboxes() {
        waitForVisibilityOf(usersCheckboxes);
        return usersCheckboxes;
    }

    public boolean isUsersDropdownsDisplayed() {
        waitForVisibilityOf(usersSelects);
        return isDisplayed(usersSelects);
    }

    public boolean isUsersNamesDisplayed() {
        waitForVisibilityOf(usersNames);
        return isDisplayed(usersNames);
    }

    public boolean isUsersImagesDescriptionDisplayed() {
        waitForVisibilityOf(usersImagesDescriptions);
        return isDisplayed(usersImagesDescriptions);
    }

    public boolean isUsersCheckboxesDisplayed() {
        waitForVisibilityOf(usersCheckboxes);
        return isDisplayed(usersCheckboxes);
    }

    public boolean isUsersSelectsDisplayed() {
        waitForVisibilityOf(usersSelects);
        return isDisplayed(usersSelects);
    }

    private boolean isDisplayed(List<WebElement> elements) {
        boolean isDisplayed = false;
        for (WebElement element : elements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    private List<String> getListAsString(List<WebElement> elements) {
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private void waitForVisibilityOf(List<WebElement> elements) {
        logsSection.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public List<JdiUser> getUsers() {
        List<JdiUser> actualUserTable = new ArrayList<>();
        List<String> numbers = getUsersIds();
        List<String> usernames = getUsersNames();
        List<String> description = getUsersImagesDescriptions();
        for (int i = 0; i < numbers.size(); i++) {
            actualUserTable.add(new JdiUser(numbers.get(i), usernames.get(i), description.get(i)));
        }
        return actualUserTable;
    }
}
