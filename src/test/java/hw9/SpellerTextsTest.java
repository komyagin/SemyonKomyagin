package hw9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hw9.dto.YandexSpellerDto;
import hw9.entity.InputDataSet;
import hw9.service.YandexSpellerAssertions;
import hw9.service.YandexSpellerSteps;
import hw9.service.enums.YandexSpellerOptions;
import hw9.service.enums.YandexSpellerParams;
import hw9.utils.FileUtils;
import hw9.utils.Properties;

import java.util.HashMap;

public class SpellerTextsTest {

    @Test(description = "Checking the ignoring of URLs")
    void checkTextWithUrl() {
        InputDataSet dataSet = InputDataSet.builder()
                .texts(new String[]{"stort", "gogle.com"})
                .expectedMistakes(new String[][]{{"start"}})
                .mistakesCount(new int[]{1}).build();

        HashMap<String, Object> params = new HashMap<>();
        params.put(YandexSpellerParams.OPTIONS.getValue(), YandexSpellerOptions.IGNORE_URLS.getValue());

        YandexSpellerDto[][] spellerResults = new YandexSpellerSteps().checkTexts(params, dataSet.getTexts());

        new YandexSpellerAssertions(spellerResults, dataSet)
                .verifyNumberOfMistakes()
                .verifyWord();
    }

    @Test(description = "Checking texts using DDT", dataProvider = "getJsonData")
    void checkTextsUsingDDT(InputDataSet dataSet) {

        YandexSpellerDto[][] spellerResults = new YandexSpellerSteps().checkTexts(dataSet.getTexts());

        new YandexSpellerAssertions(spellerResults, dataSet)
                .verifyNumberOfMistakes()
                .verifyWord();
    }

    @DataProvider
    private Object[] getJsonData() {
        return FileUtils.getDataSets(Properties.getPropByKey("data.file.path"));
    }

}
