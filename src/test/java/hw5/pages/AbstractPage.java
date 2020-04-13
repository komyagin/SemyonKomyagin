package hw5.pages;

import hw5.pages.components.HeaderMenu;
import hw5.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected SideBarMenu sideBarMenu;
    protected HeaderMenu headerMenu;
}
