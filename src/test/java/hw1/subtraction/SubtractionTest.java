package hw1.subtraction;

import hw1.BaseClassTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractionTest extends BaseClassTest {

    @DataProvider
    public Object[][] dataProviderLongNumbers(){
        return new Object[][] {
                {2, 2, 0},
                {0, 1, -1},
                {111, 111, 0},
                {-5, -10, 5}
        };
    }

    @Test(dataProvider = "dataProviderLongNumbers")
    public void subtractTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult) {

        long actualResult = calculator.sub(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers(){
        return new Object[][] {
                {2.2, 2.2, 0.0},
                {0.3, 1.3, -1},
                {111.111, 0.111, 111.0},
                {-15.5, -10.5, -5.0}
        };
    }

    @Test(dataProvider = "dataProviderDoubleNumbers")
    public void subtractTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {

        double actualResult = calculator.sub(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }
}
