package hw4.pages;

import hw4.pages.components.HeaderMenu;
import hw4.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractPageComposite {
    protected SideBarMenu sideBarMenu;
    protected HeaderMenu headerMenu;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        sideBarMenu = new SideBarMenu(driver);
        headerMenu = new HeaderMenu(driver);
    }
}
