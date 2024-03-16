import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

// Timeout to all test cases
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    // More precise, accurate and better approach as it only looks at the executable duration
    @Test
    public void testDepositTimeoutAssertion(BankAccount bankAccount){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertTimeout(Duration.ofMillis(1000), () -> {
            Thread.sleep(500);
        });
    }
}
