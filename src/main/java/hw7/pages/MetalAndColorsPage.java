package hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.entities.MetalAndColors;
import hw7.forms.MetalAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


@Url("metals-colors.html") @Title("Metal and Colors")
public class MetalAndColorsPage extends BasePage {

    private MetalAndColorsForm metalAndColorsForm;

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private UIElement results;


    public void fillAndSubmitMetalAndColorsForm(MetalAndColors defaultData) {
        metalAndColorsForm.fillForm(defaultData);
        metalAndColorsForm.submitForm();
    }

    public List<String> getResults() {
        return results.getAll()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
