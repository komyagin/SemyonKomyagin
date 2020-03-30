package hw1.addition;

import hw1.BaseClassTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdditionTest extends BaseClassTest {

    @DataProvider
    public Object[][] dataProviderLongNumbers() {
        return new Object[][]{
                {0, 1, 1},
                {4, 5, 9},
                {111, 111, 222},
                {-10, -10, -20}
        };
    }

    @Test(dataProvider = "dataProviderLongNumbers")
    public void sumTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers() {
        return new Object[][]{
                {0.2, 2.0, 2.2},
                {0.5, 0.5, 1.0},
                {111.111, 111.111, 222.222}
        };
    }

    @Test(dataProvider = "dataProviderDoubleNumbers")
    public void sumTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {

        double actualResult = calculator.sum(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }
}
