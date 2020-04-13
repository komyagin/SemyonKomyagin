package hw5.test.exercise1;

import hw5.test.BaseTest;
import hw5.test.steps.HomePageSteps;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;


@Listeners({AllureScreenshotListener.class})
public class FirstHomePageTest extends BaseTest {

    @Feature("JDITesting home page functionality")
    @Story("Login on JDITesting home page and assert web elements on page")
    @Test
    public void checkWebElementsOnPage() {

        HomePageSteps homePage = new HomePageSteps(driver);
        // 1. Open site by URL
        homePage.open();

        // 2. Assert Browser title
        homePage.homePageTitleShouldBe("Home Page");

        // 3.
        homePage.login(USER, PASSWORD);

        //  4. Assert User name in the left-top side of screen that user is logged
        homePage.usernameShouldBeDisplayed();
        homePage.headerMenuShouldHaveSize(4);
        homePage.usernameShouldBe("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.headerMenuShouldBeDisplayed();
        homePage.headerMenuShouldBe(Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePage.amountOfImagesShouldBe(4);
        homePage.imagesOnIndexPageShouldBeDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.amountOfTextsUnderImagesShouldBe(4);
        homePage.textsUnderImagesShouldBe(Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good base\n"+
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePage.frameWithButtonShouldBeDisplayed();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrameWithButton();
        homePage.buttonInFrameShouldBeDisplayed();

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePage.amountOfItemsOnLeftSectionShouldBe(5);
        homePage.leftSectionItemsShouldBeDisplayed();
        homePage.leftSectionShouldBe(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        homePage.assertAll();
    }
}
