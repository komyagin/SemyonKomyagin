package hw5.test.exercise1;

import hw5.test.BaseTest;
import hw5.test.steps.DifferentElementsPageSteps;
import hw5.test.steps.HomePageSteps;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureScreenshotListener.class})
public class SecondDifferentElementsPageTest extends BaseTest {

    @Feature("Different elements page functionality")
    @Story("Entering different elements page through index page header menu and testing functionality of " +
            "radio, checkboxes and dropdown")
    @Test
    public void assertWebElements() {
        HomePageSteps homePage = new HomePageSteps(driver);

        //1. Open test site by URL
        homePage.open();

        // 2. Assert Browser title
        homePage.homePageTitleShouldBe("Home Page");

        //3. Perform login
        homePage.login(USER, PASSWORD);

        //4. Assert Username is logged
        homePage.usernameShouldBeDisplayed();
        homePage.headerMenuShouldHaveSize(4);
        homePage.usernameShouldBe("ROMAN IOVLEV");

        //5.Open through the header menu Service -> Different Elements Page
        homePage.goToDifferentElementsPage();
        DifferentElementsPageSteps differentElementsPage = new DifferentElementsPageSteps(driver);

        //6. Select checkboxes "Water", "Wind"
        String checkBoxOne = "Water";
        String checkBoxTwo = "Wind";
        differentElementsPage.checkCheckbox(checkBoxOne);
        differentElementsPage.checkCheckbox(checkBoxTwo);

        //7. Select radio "Selen"
        String radio = "Selen";
        differentElementsPage.checkRadio(radio);

        //8.Select in dropdown "Yellow"
        String dropdownColor = "Yellow";
        differentElementsPage.setColorDropdownTo(dropdownColor);

        //9.Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbo
        differentElementsPage.individualLogRowForCheckboxShouldBe(checkBoxOne, "true");
        differentElementsPage.individualLogRowForCheckboxShouldBe(checkBoxTwo, "true");

        //    • for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsPage.individualLogRowForRadioShouldBeDisplayed(radio);

        //    • for dropdown there is a log row and value is corresponded to the selected value
        differentElementsPage.individualLogRowForDropdownShouldBeDisplayed(dropdownColor);
    }
}
