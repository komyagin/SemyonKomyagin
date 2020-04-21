package hw7;

import hw7.entities.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class BaseTest {

    @BeforeTest
    public void beforeClass() {
        initElements(JdiSite.class);
        JdiSite.open();
        JdiSite.homePage.login(User.ROMAN);
        JdiSite.homePage.checkLoggedIn(User.ROMAN);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
