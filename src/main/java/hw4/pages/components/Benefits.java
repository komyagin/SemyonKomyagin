package hw4.pages.components;

import hw4.pages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Benefits extends AbstractPageComposite {

    @FindBy(className = "benefit-icon")
    List<WebElement> benefitImages;

    @FindBy(className = "benefit-txt")
    List<WebElement> benefitTexts;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return benefitImages;
    }

    public int getBenefitImagesCount(){
        return benefitImages.size();
    }

    public int getBenefitTextsCount(){
        return benefitTexts.size();
    }

    public List<String> getBenefitTexts(){
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
