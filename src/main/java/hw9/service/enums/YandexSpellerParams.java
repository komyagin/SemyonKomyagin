package hw9.service.enums;

import lombok.Getter;

@Getter
public enum YandexSpellerParams {

    LANGUAGE("lang"),
    OPTIONS("options"),
    FORMAT("format");

    private String value;

    YandexSpellerParams(String value) {
        this.value = value;
    }
}
