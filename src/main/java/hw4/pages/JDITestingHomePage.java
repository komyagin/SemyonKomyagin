package hw4.pages;

import hw4.pages.components.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class JDITestingHomePage extends AbstractPage {

    private Benefits benefits;
    private FrameWithButton frameWithButton;

    public JDITestingHomePage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.frameWithButton = new FrameWithButton(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException();
    }

    public void login(String username, String password) {
        headerMenu.login(username, password);
    }

    public boolean isUserNameDisplayed() {
        return headerMenu.isUserNameDisplayed();
    }

    public String getUserName() {
        return headerMenu.getUserName();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getHeaderMenuText() {
        return headerMenu.getHeaderMenuElementsText();
    }

    public boolean isHeaderMenuItemsDisplayed() {
        return headerMenu.isElementsDisplayed(headerMenu.getWebElements());
    }

    public int getBenefitImagesCount() {
        return benefits.getBenefitImagesCount();
    }

    public int getBenefitTextsCount() {
        return benefits.getBenefitTextsCount();
    }

    public List<String> getBenefitTexts() {
        return benefits.getBenefitTexts();
    }

    public boolean isBenefitIconsDisplayed() {
        return benefits.isElementsDisplayed(benefits.getWebElements());
    }

    public boolean isIFrameDisplayed() {
        return frameWithButton.isFrameDisplayed();
    }

    public boolean isIFrameButtonDisplayed() {
        return frameWithButton.isButtonDisplayed();
    }

    public void switchToFrame() {
        frameWithButton.switchToFrame();
    }

    public void switchToDefault() {
        frameWithButton.switchToDefaultWindow();
    }

    public boolean isSidebarElementsDisplayed() {
        return sideBarMenu.isElementsDisplayed(sideBarMenu.getWebElements());
    }

    public List<String> getSideBarMenuElementsText() {
        return sideBarMenu.getSideBarMenuElementsText();
    }

    public int getSidebarElementsCount() {
        return sideBarMenu.getSidebarElementsCount();
    }

    public void goToDifferentElementsPage() {
        headerMenu.goToDifferentElementPage();
    }

    public JDITestingMetalsAndColorsPage goToJDIMetalsAndColorsPage(WebDriver driver) {
        headerMenu.goToMetalsAndColorsPage();
        return new JDITestingMetalsAndColorsPage(driver);
    }

    public JDITestingTableWithPagesPage goToJDITableWithPagesPage(WebDriver driver) {
        headerMenu.goToTableWithPagesPage();
        return new JDITestingTableWithPagesPage(driver);
    }
}
