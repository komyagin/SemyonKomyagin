package hw3.pages;

import hw3.pages.components.Benefits;
import hw3.pages.components.HeaderMenu;
import hw3.pages.components.IFrame;
import hw3.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class JDITestingHomePage extends AbstractPage {

    private Benefits benefits;
    private IFrame iframe;

    public JDITestingHomePage(WebDriver driver) {
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.iframe = new IFrame(driver);
        this.sideBarMenu = new SideBarMenu(driver);
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
        return headerMenu.isHeaderMenuItemsDisplayed();
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
        return benefits.isBenefitIconsDisplayed();
    }

    public boolean isIFrameDisplayed() {
        return iframe.isFrameDisplayed();
    }

    public boolean isIFrameButtonDisplayed() {
        return iframe.isButtonDisplayed();
    }

    public void switchToFrame() {
        iframe.switchToFrame();
    }

    public void switchToDefault() {
        iframe.switchToDefaultWindow();
    }

    public boolean isSidebarElementsDisplayed() {
        return sideBarMenu.isSidebarElementsDisplayed();
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
}
