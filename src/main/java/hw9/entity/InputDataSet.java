package hw9.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class InputDataSet {
    String[] texts;
    String[][] expectedMistakes;
    int[] mistakesCount;
}