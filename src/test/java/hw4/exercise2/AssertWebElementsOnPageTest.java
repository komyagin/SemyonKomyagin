package hw4.exercise2;

import hw4.pages.JDITestingHomePage;
import hw4.BaseTest;
import hw4.pages.JDITestingMetalsAndColorsPage;
import hw4.pages.builder.TestData;
import hw4.pages.util.SummaryUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AssertWebElementsOnPageTest extends BaseTest {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "testData")
    public void assertWebElements(TestData testData) {
        // 1. Open site by URL
        openSite(SITE_URL);
        JDITestingHomePage homePage = new JDITestingHomePage(driver);

        SoftAssert softAssert = new SoftAssert();

        // 2. Perform login
        homePage.login(USER, PASSWORD);

        // 3. Click on the link on the Header section
        JDITestingMetalsAndColorsPage metalsAndColorsPage = homePage.goToJDIMetalsAndColorsPage(driver);

        // 4. Fill form on the page
        if (testData.getSummary() != null) {
            metalsAndColorsPage.selectWebElement(
                    metalsAndColorsPage.getWebElements("summaryRadioButtons"), testData.getSummary());
        }

        if (testData.getElements() != null) {
            metalsAndColorsPage.selectWebElement(
                    metalsAndColorsPage.getWebElements("elementsCheckboxes"), testData.getElements(
            ));
        }

        if (testData.getColors() != null) {
            metalsAndColorsPage.getWebElement("colorDropdown").click();
            metalsAndColorsPage.selectWebElement(
                    metalsAndColorsPage.getWebElements("colorAndMetalOptions"), testData.getColors());
        }

        if (testData.getMetals() != null) {
            metalsAndColorsPage.getWebElement("metalDropdown").click();
            metalsAndColorsPage.selectWebElement(metalsAndColorsPage
                    .getWebElements("colorAndMetalOptions"), testData.getMetals());
        }

        if (testData.getVegetables() != null) {
            metalsAndColorsPage.getWebElement("vegetablesDropdown").click();
            metalsAndColorsPage.uncheckVegetables();
            metalsAndColorsPage.selectWebElement(metalsAndColorsPage
                    .getWebElements("vegetableCheckboxes"), testData.getVegetables());

        }

        // 5. Click "Submit" button
        metalsAndColorsPage.clickSubmitButton();

        // 6. Check Results block output on the right-side
        for (WebElement result : metalsAndColorsPage.getWebElements("results")) {

            if (testData.getSummary() != null && result.getText().contains("Summary")) {
                softAssert.assertTrue(result.getText().contains(SummaryUtil.summarySum(testData.getSummary())));
            }

            if (testData.getElements() != null && result.getText().contains("Elements")) {
                softAssert.assertTrue(result.getText().contains(String.join(", ", testData.getElements())));
            }

            if (testData.getColors() != null && result.getText().contains("Colors")) {
                softAssert.assertTrue(result.getText().contains(String.join(", ", testData.getColors())));
            }

            if (testData.getMetals() != null && result.getText().contains("Metals")) {
                softAssert.assertTrue(result.getText().contains(String.join(",", testData.getMetals())));
            }

            if (testData.getVegetables() != null && result.getText().contains("Vegetables")) {
                softAssert.assertTrue(result.getText().contains(String.join(", ", testData.getVegetables())));
            }
        }
    }
}
