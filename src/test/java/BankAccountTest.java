import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
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
}
