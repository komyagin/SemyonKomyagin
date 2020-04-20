package hw6.steps;

import hw6.pages.JdiTestingDifferentElementsPage;
import hw6.pages.JdiTestingUserTablePage;
import hw6.pages.utils.WebDriverSingleton;
import io.cucumber.java.en.When;

import java.util.List;

public class WhenSteps {

    private JdiTestingDifferentElementsPage differentElementsPage;
    private JdiTestingUserTablePage userTablePage;

    @When("I select checkboxes")
    public void iSelectCheckboxesOnDifferentElementsPage(List<String> checkboxes) {
        differentElementsPage = new JdiTestingDifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        checkboxes = checkboxes.subList(1, checkboxes.size());
        checkboxes.forEach(e -> differentElementsPage.setCheckbox(e));
    }

    @When("I select {string} radiobutton")
    public void iSelectRadioOnDifferentElementsPage(String radio) {
        differentElementsPage.setRadioRow(radio);
    }

    @When("I select {string} in dropdown menu")
    public void iSelectDropdownOnDifferentElementsPage(String color) {
        differentElementsPage.setColorDropDown(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSetCheckbox(String username) {
        userTablePage = new JdiTestingUserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        userTablePage.setVipCheckbox(username);
    }
}
