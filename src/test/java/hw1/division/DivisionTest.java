package hw1.division;

import hw1.BaseClassTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionTest extends BaseClassTest {

    @DataProvider
    public Object[][] dataProviderLongNumbers(){
        return new Object[][] {
                {10, 2, 5},
                {100, 5, 20},
                {0, 22, 0}
        };
    }

    @Test(dataProvider = "dataProviderLongNumbers")
    public void divideTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){

        long actualResult = calculator.div(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }

    @DataProvider
    public Object[][] dataProviderDoubleNumbers(){
        return new Object[][] {
                {100.0, 20.0, 5.0},
                {0.50, -2.0, -0.25},
                {222.222, 2, 111.111}
        };
    }

    @Test(dataProvider = "dataProviderDoubleNumbers")
    public void divideTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){

        double actualResult = calculator.div(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void throwsNumberFormatException() {
        calculator.div(100, 0);
    }
}
