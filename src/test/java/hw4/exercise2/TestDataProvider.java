package hw4.exercise2;

import hw4.pages.builder.TestData;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TestDataProvider {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {TestData.builder().setElements(Arrays.asList("Earth"))
                        .setColors(Arrays.asList("Yellow")).setMetals(Arrays.asList("Gold")).build()},

                {TestData.builder().setSummary(Arrays.asList("3", "8"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},

                {TestData.builder().setSummary(Arrays.asList("3", "2"))
                        .setElements(Arrays.asList("Water", "Wind", "Fire"))
                        .setMetals(Arrays.asList("Bronze")).setVegetables(Arrays.asList("Onion")).build()},

                {TestData.builder().setSummary(Arrays.asList("6", "5"))
                        .setElements(Arrays.asList("Water"))
                        .setColors(Arrays.asList("Green")).setMetals(Arrays.asList("Selen"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).build()},

                {TestData.builder().setElements(Arrays.asList("Fire"))
                        .setColors(Arrays.asList("Blue"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
        };
    }
}
