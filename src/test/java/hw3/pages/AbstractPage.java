package hw3.pages;

import org.openqa.selenium.WebDriver;
import hw3.pages.components.SideBarMenu;
import hw3.pages.components.HeaderMenu;

public class AbstractPage {
    protected WebDriver driver;
    protected SideBarMenu sideBarMenu;
    protected HeaderMenu headerMenu;
}
