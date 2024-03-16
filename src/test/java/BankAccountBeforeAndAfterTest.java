import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // BeforeAll and AfterAll can be used without the 'static' keyword
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    public void beginTest(){
        System.out.println("Initializing the Bank Account");
        bankAccount = new BankAccount(500,0);
    }

//    @BeforeAll
//    public static void beginTest(){
//        System.out.println("Initializing the Bank Account");
//        bankAccount = new BankAccount(500,0);
//    }

//    @BeforeEach // Runs before each test case
//    public void beginTest(){
//        System.out.println("Initializing the Bank Account");
//        bankAccount = new BankAccount(500,0);
//    }

    @Test
    public void testWithdraw(){
        bankAccount.withdraw(150);
        assertEquals(350, bankAccount.getBalance());
    }

    @Test
    public void testDeposit(){
        bankAccount.deposit(200);
//        assertEquals(550, bankAccount.getBalance());
        assertEquals(550, bankAccount.getBalance());

    }

//    @AfterEach
//    public void endTest(){
//        System.out.println("Test Completed!");
//    }

//    @AfterAll
//    public static void endTest(){
//        System.out.println("Test Completed!");
//    }

    @AfterAll
    public static void endTest(){
        System.out.println("Test Completed!");
    }

}
