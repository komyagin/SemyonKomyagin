package hw9.service;

import hw9.dto.YandexSpellerDto;
import hw9.service.enums.YandexSpellerUri;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class YandexSpellerSteps {

    public YandexSpellerDto[][] checkText(String... lines) {
        return checkTexts(new HashMap<>(), lines);
    }

    public YandexSpellerDto[][] checkTexts(Map<String, Object> params, String... lines) {
        YandexSpellerDto[][] result;

        if (lines.length <= 1) {
            result = new YandexSpellerDto[][]{createYandexSpellerService(YandexSpellerUri.SINGLE_TEXT.getValue(), params, lines)
                    .getBody().as(YandexSpellerDto[].class)};
        } else {
            result = createYandexSpellerService(YandexSpellerUri.MANY_TEXTS.getValue(), params, lines)
                    .getBody().as(YandexSpellerDto[][].class);
        }
        return result;
    }

    private Response createYandexSpellerService(String value, Map<String, Object> params, String... lines) {
        return new YandexSpellerService()
                .getResponse(YandexSpellerUri.MANY_TEXTS.getValue(), params, lines);
    }

}
