package hw6.exercise2;

import hw6.BaseTest;
import hw6.pages.JdiTestingDifferentElementsPage;
import hw6.pages.JdiTestingHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AssertWebElementsOnPageTest extends BaseTest {

    @Test
    public void HardAssertWebElements() {
        // 1. Open test site by URL
        openSite(SITE_URL);
        JdiTestingHomePage homePage = new JdiTestingHomePage(driver);

        // 2. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page", "Not expected Index page title");

        // 3. Perform login
        homePage.login(USER, PASSWORD);

        // 4. Assert User name in the left-top side of screen that user is loggedIn
        assertTrue(homePage.isUserNameDisplayed());
        assertEquals(homePage.getUserName(), "ROMAN IOVLEV", "Not expected logged user");

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.goToDifferentElementsPage();
        JdiTestingDifferentElementsPage differentElementsPage = new JdiTestingDifferentElementsPage(driver);


        // 6. Select checkboxes
        String checkBoxOne = "Water";
        String checkBoxTwo = "Wind";
        differentElementsPage.setCheckbox(checkBoxOne);
        differentElementsPage.setCheckbox(checkBoxTwo);


        // 7. Select radio
        String radio = "Selen";
        differentElementsPage.setRadioRow(radio);

        // 8. Select in dropdown
        String color = "Yellow";
        differentElementsPage.setColorDropDown(color);

    /* 9. Assert that
        •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        •	for radio button there is a log row and value is corresponded to the status of radio button
        •	for dropdown there is a log row and value is corresponded to the selected value.

    */
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBoxOne, "true"));
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBoxTwo, "true"));
        assertTrue(differentElementsPage.isRadioLogDisplayed(radio));
        assertTrue(differentElementsPage.isDropdownLogDisplayed(color));
    }
}
