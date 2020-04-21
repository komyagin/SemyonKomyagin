package hw7;

import hw7.entities.MetalAndColors;
import hw7.enums.HeaderMenuItem;
import hw7.dataProviders.MetalAndColorsDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MetalAndColorsTest extends BaseTest {

    @Test(dataProvider = "dataset", dataProviderClass = MetalAndColorsDataProvider.class)
    public void metalAndColorsTest(MetalAndColors data) {
        JdiSite.homePage.openNewPageByHeaderMenu(HeaderMenuItem.METALS_AND_COLORS);
        JdiSite.metalAndColorsPage.checkOpened();
        JdiSite.metalAndColorsPage.fillAndSubmitMetalAndColorsForm(data);
        Assert.assertEquals(JdiSite.metalAndColorsPage.getResults(), data.getExpectedResults());
    }
}
