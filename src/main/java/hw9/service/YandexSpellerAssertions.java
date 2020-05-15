package hw9.service;

import hw9.dto.YandexSpellerDto;
import hw9.entity.InputDataSet;

import static org.assertj.core.api.Assertions.assertThat;

public class YandexSpellerAssertions {

    private YandexSpellerDto[][] spellerResults;
    private InputDataSet dataSet;

    public YandexSpellerAssertions(YandexSpellerDto[][] responseBody, InputDataSet inputDataSet) {
        this.spellerResults = responseBody;
        this.dataSet = inputDataSet;
    }

    public YandexSpellerAssertions verifyNumberOfMistakes() {
        for (int i = 0; i < dataSet.getExpectedMistakes().length; i++) {
            assertThat(spellerResults[i].length).isEqualTo(dataSet.getMistakesCount()[i]);
        }
        return this;
    }

    public YandexSpellerAssertions verifyWord() {
        for (int i = 0; i < dataSet.getExpectedMistakes().length; i++) {
            for (YandexSpellerDto dto : spellerResults[i]) {
                assertThat(dto.getS()).containsAnyOf(dataSet.getExpectedMistakes()[i]);
            }
        }
        return this;
    }
}
