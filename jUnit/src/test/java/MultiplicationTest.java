import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MultiplicationTest {

   private static Calculation calculation;
    private int firstParam;
    private int secondParam;

    public MultiplicationTest(int firstParam, int secondParam) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> multiplicationParams() {
        Object[][] mParams = new Object[][] {{4, 5}, {3, 7}, {6, 8}, {5, 0}};
        return Arrays.asList(mParams);
    }

    @BeforeClass
    public static void initCalculation() {
        calculation = new Calculation();
    }

    @Test
    public void multiplicationIsCorrect() {
        int first = firstParam;
        int second = secondParam;
        int result = calculation.multiplyNumbers(first, second);
        assertEquals("Result doesn't match",result, first * second);
    }
}
