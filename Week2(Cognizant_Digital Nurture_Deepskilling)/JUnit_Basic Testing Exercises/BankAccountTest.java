import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Sivagunanithi", 1000.0);  // Arrange
    }

    @AfterEach
    void tearDown() {
        account = null;
    }

    @Test
    void testDeposit() {
        double newBalance = account.deposit(500);

    
        assertEquals(1500.0, newBalance);
    }

    @Test
    void testWithdraw() {
        double remaining = account.withdraw(300);

        assertEquals(700.0, remaining);
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }

    @Test
    void testAccountHolderName() {
        String name = account.getAccountHolder();

        assertEquals("Sivagunanithi", name);
    }
}
