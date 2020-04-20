package hw6.pages;

import hw6.pages.components.Benefits;
import hw6.pages.components.FrameWithButton;
import hw6.pages.components.HeaderMenu;
import hw6.pages.components.SideBarMenu;
import hw6.pages.enteties.User;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class JdiTestingHomePage extends AbstractPage {

    private Benefits benefits;
    private FrameWithButton frameWithButton;

    public JdiTestingHomePage(WebDriver driver) {
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.frameWithButton = new FrameWithButton(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    public void login(User user) {
        headerMenu.login(user);
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

    public void goToUserTablePage() {
        headerMenu.goToUserTablePage();
    }
}
