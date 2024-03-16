import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountAssertionsTest {
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

    @Test
    @DisplayName("Withdraw becomes negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -100);
        bankAccount.withdraw(550);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation of accounts after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test Bank Account Holder Name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Vishwas");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test can't withdraw below minimum balance")
    public void testNoWithdrawBelowMinimumBalance(){
        BankAccount bankAccount = new BankAccount(500, -100);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraws and deposit")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertAll( () -> bankAccount.withdraw(400), () -> bankAccount.deposit(1000));
    }

    @Test
    @DisplayName("Test Deposit Timeout")
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(500, 0);
       // assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(3000));
        assertTimeout(Duration.ofMinutes(1), () -> bankAccount.deposit(3000));
    }

    @Test
    @DisplayName("Test Delta value")
    public void testDelta(){
        assertEquals(0.33, 0.34, 0.2);
//        assertEquals(0.33, 1/3, "Not the same");
    }
}