package hw6.steps;

import hw6.pages.JdiTestingHomePage;
import hw6.pages.utils.WebDriverSingleton;
import hw6.utils.Properties;
import io.cucumber.java.en.Given;

public class GivenSteps {

    private JdiTestingHomePage homePage;

    @Given("I am on Home page")
    public void iAmOnHomePage() {
        WebDriverSingleton.INSTANCE.getDriver().get(Properties.getProperty("url"));
        homePage = new JdiTestingHomePage(WebDriverSingleton.INSTANCE.getDriver());
    }

    @Given("I login as username: {string} password: {string}")
    public void iLoginOnIndexPage(String username, String password) {
        homePage.login(username, password);
    }

    @Given("I go through the header menu Service -> Different Elements Page")
    public void iOpenDifferentElementsPageThroughHeaderOnIndexPage() {
        homePage.goToDifferentElementsPage();
    }

    @Given("I go through the header menu Service -> User Table")
    public void iOpenUserTablePageThroughHeaderOnIndexPage() {
        homePage.goToUserTablePage();
    }
}
