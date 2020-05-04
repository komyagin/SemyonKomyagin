package hw9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hw9.dto.YandexSpellerDto;
import hw9.entity.InputDataSet;
import hw9.service.YandexSpellerAssertions;
import hw9.service.YandexSpellerSteps;
import hw9.service.enums.YandexSpellerOptions;
import hw9.service.enums.YandexSpellerParams;

import java.util.HashMap;

public class SpellerTextTest {

    @Test(description = "Checking simple typos", dataProvider = "simpleProvider")
    void checkSimpleText(InputDataSet dataSet) {

        YandexSpellerDto[][] spellerResults = new YandexSpellerSteps().checkTexts(dataSet.getTexts());

        new YandexSpellerAssertions(spellerResults, dataSet)
                .verifyNumberOfMistakes()
                .verifyWord();
    }

    @Test(description = "Checking the ignoring words with numbers")
    void checkTextWithNumbers() {
        InputDataSet dataSet = InputDataSet.builder()
                .texts(new String[]{"blink182"})
                .expectedMistakes(new String[][]{{}})
                .mistakesCount(new int[]{0}).build();

        HashMap<String, Object> params = new HashMap<>();
        params.put(YandexSpellerParams.OPTIONS.getValue(), YandexSpellerOptions.IGNORE_DIGITS.getValue());

        YandexSpellerDto[][] spellerResults = new YandexSpellerSteps().checkTexts(params, dataSet.getTexts());

        new YandexSpellerAssertions(spellerResults, dataSet)
                .verifyNumberOfMistakes()
                .verifyWord();
    }

    @DataProvider
    public Object[] simpleProvider() {
        return new Object[]{
                InputDataSet.builder()
                        .texts(new String[]{"friond"})
                        .expectedMistakes(new String[][]{{"friend"}})
                        .mistakesCount(new int[]{1}).build(),
                InputDataSet.builder()
                        .texts(new String[]{"download" + "application"})
                        .expectedMistakes(new String[][]{{"download application"}})
                        .mistakesCount(new int[]{1}).build(),
        };
    }
}
