import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;




@RunWith(Parameterized.class)
public class CountFactorialTest {

    private static Calculation calculation;
    private int factorialNumber;
    private int factorialResult;

    public CountFactorialTest(int fNumber, int fResult) {
        factorialNumber = fNumber;
        factorialResult = fResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> factorialValues() {
        Object[][] fValues = new Object[][] {{3, 6}, {4, 24}, {5, 120}};
        return Arrays.asList(fValues);
    }

    @BeforeClass
    public static void initCalculation() {
        calculation = new Calculation();
    }

    @Test
    public void countFactorialTest() {
        int expected = factorialResult;
        int actual = calculation.countFactorial(factorialNumber);
        assertEquals("Result doesn't match",actual, expected);
    }
}