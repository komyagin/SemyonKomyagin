package hw6.steps;

import hw6.pages.JdiTestingHomePage;
import hw6.pages.enteties.User;
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
        homePage.login(new User(username, password));
    }

    @Given("I go through the header menu Service -> {string}")
    public void iGoOnSpecificPage(String page) {
        switch (page) {
            case "Different Elements Page":
                homePage.goToDifferentElementsPage();
                break;
            case "User Table":
                homePage.goToUserTablePage();
                break;
        }

    }
}
