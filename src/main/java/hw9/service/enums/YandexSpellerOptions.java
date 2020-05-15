package hw9.service.enums;

import lombok.Getter;

@Getter
public enum YandexSpellerOptions {

    IGNORE_DIGITS(2),
    IGNORE_URLS(4);

    private Integer value;

    YandexSpellerOptions(Integer value) {
        this.value = value;
    }
}
