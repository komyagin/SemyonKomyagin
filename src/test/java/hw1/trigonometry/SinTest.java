package hw1.trigonometry;

import hw1.BaseClassTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SinTest extends BaseClassTest {

    @DataProvider
    public Object[][] dataProviderNumbers(){
        return new Object[][] {
                {0.0, 0.0000},
                {90.0, 1.0000},
                {270.0, -1.0000}
        };
    }

    @Test(dataProvider = "dataProviderNumbers")
    public void sinNumbers(double angleDegree, double expectedResult){

        double radian = Math.toRadians(angleDegree);

        double actualResult = calculator.sin(radian);

        assertEquals(actualResult, expectedResult, "Test failed because");
    }
}
