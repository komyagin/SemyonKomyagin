package hw9.service.enums;

import lombok.Getter;

@Getter
public enum YandexSpellerUri {

    SINGLE_TEXT("checkText"),
    MANY_TEXTS("checkTexts");

    private String value;

    YandexSpellerUri(String value) {
        this.value = value;
    }
}
