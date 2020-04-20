package hw6.pages;

import hw6.pages.components.HeaderMenu;
import hw6.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected SideBarMenu sideBarMenu;
    protected HeaderMenu headerMenu;
}
