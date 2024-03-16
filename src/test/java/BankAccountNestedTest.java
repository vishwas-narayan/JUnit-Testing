import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {
    @Test
    @DisplayName("Withdraw 400 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -100);
        bankAccount.withdraw(400);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero{

        @Test
        @DisplayName("Withdrawing below minimum balance exception")
        public void testWithdrawMinimumBalanceIs0(){
            BankAccount bankAccount = new BankAccount(0,0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing getting a negative balance")
        public void testWithdrawMinimumBalanceIsNegative1000(){
            BankAccount bankAccount = new BankAccount(0,-1000);
            bankAccount.withdraw(500);
            assertEquals(-500.0, bankAccount.getBalance());
        }
    }
}
