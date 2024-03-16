import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {
    @Test
    @DisplayName("Test Activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
//        assumeTrue(bankAccount != null, "Account is null");
//        assertTrue(bankAccount.isActive());
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive())); // the above two statements can be combined in this form
    }
}