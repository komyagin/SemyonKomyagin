package hw5.test.steps;

import hw5.pages.JDITestingHomePage;
import hw5.utils.Properties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {
    private final static String URL = Properties.getProperty("url");
    private final WebDriver driver;
    private final JDITestingHomePage homePage;
    private SoftAssert softAssert;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new JDITestingHomePage(driver);
        softAssert = new SoftAssert();
    }

    @Step("I opened Index page")
    public void open() {
        driver.get(URL);
    }

    @Step("Browser title should be '{0}'")
    public void homePageTitleShouldBe(String expectedValue) {
        String actualValue = driver.getTitle();
        softAssert.assertEquals(actualValue, expectedValue);
    }

    @Step("I login as username:'{0}' password:'{1}'")
    public void login(String username, String password) {
        homePage.login(username, password);
    }

    @Step("User name should be displayed")
    public void usernameShouldBeDisplayed() {
        softAssert.assertTrue(homePage.isUserNameDisplayed());
    }

    @Step("User name should be '{0}'")
    public void usernameShouldBe(String value) {
        softAssert.assertEquals(homePage.getUserName(), value);
    }

    @Step("Header menu should be displayed")
    public void headerMenuShouldBeDisplayed() {
        softAssert.assertTrue(homePage.isHeaderMenuItemsDisplayed());
    }

    @Step("Header section should have '{0}' items")
    public void headerMenuShouldHaveSize(int amountOfItems) {
        softAssert.assertEquals(homePage.getHeaderMenuText().size(), amountOfItems);
    }

    @Step("Header menu should be '{0}'")
    public void headerMenuShouldBe(List<String> expectedHeaderText) {
        List<String> actualHeaderMenuItemsText = homePage.getHeaderMenuText();
        softAssert.assertEquals(actualHeaderMenuItemsText.size(), 4);
        softAssert.assertEquals(actualHeaderMenuItemsText, expectedHeaderText);
    }

    @Step("Index page should have '{0}' images")
    public void amountOfImagesShouldBe(int amountOfItems) {
        softAssert.assertEquals(homePage.getBenefitImagesCount(), amountOfItems);
    }

    @Step("Images on Index page should be displayed")
    public void imagesOnIndexPageShouldBeDisplayed() {
        softAssert.assertTrue(homePage.isBenefitIconsDisplayed());
    }

    @Step("Index page should have '{0}' texts under images")
    public void amountOfTextsUnderImagesShouldBe(int amountOfItems) {
        softAssert.assertEquals(homePage.getBenefitTexts().size(), amountOfItems);
    }

    @Step("Texts under images on Index page should be '{}'")
    public void textsUnderImagesShouldBe(List<String> expectedText) {
        List<String> actualBenefitTexts = homePage.getBenefitTexts();
        softAssert.assertEquals(actualBenefitTexts, expectedText);
    }

    @Step("Frame with button should be displayed")
    public void frameWithButtonShouldBeDisplayed() {
        softAssert.assertTrue(homePage.isIFrameDisplayed());
    }

    @Step("Switch to frame with button")
    public void switchToFrameWithButton() {
        homePage.switchToFrame();
    }

    @Step("Button in frame should be displayed")
    public void buttonInFrameShouldBeDisplayed() {
        softAssert.assertTrue(homePage.isIFrameButtonDisplayed());
    }

    @Step("Switch back to default")
    public void switchToOriginalWindow() {
        homePage.switchToDefault();
    }

    @Step("Index page should have '{0}' items in left section")
    public void amountOfItemsOnLeftSectionShouldBe(int value) {
        softAssert.assertEquals(homePage.getSidebarElementsCount(), value);
    }

    @Step("Left section should be '{0}'")
    public void leftSectionShouldBe(List<String> expectedText) {
        softAssert.assertEquals(homePage.getSideBarMenuElementsText(), expectedText);
    }

    @Step("Left section elements should be displayed")
    public void leftSectionItemsShouldBeDisplayed() {
        softAssert.assertTrue(homePage.isSidebarElementsDisplayed());
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void goToDifferentElementsPage() {
        homePage.goToDifferentElementsPage();
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
