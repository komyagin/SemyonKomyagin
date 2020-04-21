package hw6.hooks;

import hw6.pages.utils.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverSingleton.INSTANCE.createdDriver("chrome");
        WebDriverSingleton.INSTANCE.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }
}
