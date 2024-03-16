import static org.junit.jupiter.api.Assertions.*; // make it static manually
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateMethodsTest {
    private CalculateMethods calculateMethods = new CalculateMethods();

    @BeforeEach
    public void initTest(){
        calculateMethods = new CalculateMethods();
    }

    @Test
    public void testDivide(){
        assertEquals(10, calculateMethods.divide(100,10));
    }

    @Test
    public void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> calculateMethods.divide(100, 0));
    }

}