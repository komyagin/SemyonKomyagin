package hw1.multiplication;

import hw1.BaseClassTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest extends BaseClassTest {

    @DataProvider
    public Object[][] dataProviderLongNumbers(){
        return new Object[][] {
                {2, 2, 4},
                {100, 4, 400},
                {5, -5, -25},
                {-33, -3, 99}
        };
    }

    @Test(dataProvider = "dataProviderLongNumbers")
    public void multiplyTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){

        long actualResult = calculator.mult(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers(){
        return new Object[][] {
                {2.0, -2.0, -4.0},
                {0.25, 4.0, 1.0},
                {11.0, 5.0, 55.0}
        };
    }

    @Test(dataProvider = "dataProviderDoubleNumbers")
    public void multiplyTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){

        double actualResult = calculator.mult(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }
}
