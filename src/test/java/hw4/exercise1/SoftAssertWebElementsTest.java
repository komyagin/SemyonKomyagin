package hw4.exercise1;

import hw4.pages.JDITestingHomePage;
import hw4.BaseTest;
import hw4.pages.JDITestingTableWithPagesPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;


public class SoftAssertWebElementsTest extends BaseTest {

    @Test
    public void checkWebElementsOnPage() {

        // 1. Open site by URL
        openSite(SITE_URL);
        JDITestingHomePage homePage = new JDITestingHomePage(driver);

        SoftAssert softAssert = new SoftAssert();
        // 2. Assert Browser title
        softAssert.assertEquals(homePage.getPageTitle(), "Home Page", "Not expected Index page title");

        // 3.
        homePage.login(USER, PASSWORD);

        //  4. Assert User name in the left-top side of screen that user is logged
        softAssert.assertTrue(homePage.isUserNameDisplayed());
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV", "Not expected logged user");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(homePage.isHeaderMenuItemsDisplayed());
        List<String> actualHeaderMenuItemsText = homePage.getHeaderMenuText();
        List<String> expectedHeaderMenuItemsText = Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
        softAssert.assertEquals(actualHeaderMenuItemsText.size(), 4);
        softAssert.assertEquals(actualHeaderMenuItemsText, expectedHeaderMenuItemsText);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.getBenefitImagesCount(), 4);
        softAssert.assertTrue(homePage.isBenefitIconsDisplayed());

        // 7. Open through the header menu Service -> Table with pages
        JDITestingTableWithPagesPage tableWithPagesPage = homePage.goToJDITableWithPagesPage(driver);

        // 8. Check that default value for “Show entries” dropdown is 5
        softAssert.assertEquals(tableWithPagesPage.getSelectedDropdownValue().getText(), "5");

        // 11. Select new value for the entries in the dropdown list
        tableWithPagesPage.setDropdownValue("10");

        // 13. Assert that in the table displayed corrected amount of entries
        softAssert.assertEquals(tableWithPagesPage.getRowsCount(), 10);

        // 14. Type in “Search” text field
        String searchValue = "junit";
        tableWithPagesPage.sendKeysToSearchInput(searchValue);

        // 15. Assert the table contains only records with Search field value
        tableWithPagesPage.getTableValues().
                forEach(e -> softAssert.assertTrue(e.getText().toLowerCase().contains(searchValue.toLowerCase())));

        softAssert.assertAll();
    }
}
