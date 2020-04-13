package hw5.test.exercise2;

import hw5.test.BaseTest;
import hw5.test.steps.HomePageSteps;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureScreenshotListener.class})
public class FirstHomePageFailedTest extends BaseTest {

    @Feature("JDITesting home page failed functionality")
    @Story("Login on JDITesting home page and assert web elements on page")
    @Test
    public void checkWebElementsOnPage() {

        HomePageSteps homePage = new HomePageSteps(driver);
        // 1. Open site by URL
        homePage.open();

        // 2. Assert Browser title
        homePage.homePageTitleShouldBe("Home Page1");

        // 3.
        homePage.login(USER, PASSWORD);

        //  4. Assert User name in the left-top side of screen that user is logged
        homePage.usernameShouldBeDisplayed();
        homePage.headerMenuShouldHaveSize(5);
        homePage.usernameShouldBe("ROMAN CARSHARING");

        homePage.assertAll();
    }
}
