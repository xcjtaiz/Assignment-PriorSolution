import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class TestBankingSystem {

    // Test Case No.1
    @Test
    public void CounterServiceInTime() {
        // Counter Service || Allow customer deposit transaction from 10 to 22 || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        String result = bankingSystem.deposit("CounterService", 10, 10000);
        assertEquals("Accept the deposit transaction.", result);
    }

    // Test Case No.2
    @Test
    public void CounterServiceOutTime() {
        // Counter Service || Allow customer deposit transaction from 10 to 22 || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        String result = bankingSystem.deposit("CounterService", 23, 10000);
        assertEquals("Reject the deposit transaction and notify the customer that it must be done during a specific time only.", result);
    }

    // Test Case No.3
    @Test
    public void BigBranchInTime() {
        // Big Branch || Allow customer deposit transaction from 10 to 20 || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        String result = bankingSystem.deposit("BigBranch", 10, 10000);
        assertEquals("Accept the deposit transaction.", result);
    }

    // Test Case No.4
    @Test
    public void BigBranchOutTime() {
        // Big Branch || Allow customer deposit transaction from 10 to 20 || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        String result = bankingSystem.deposit("BigBranch", 21, 10000);
        assertEquals("Reject the deposit transaction and notify the customer that it must be done during a specific time only.", result);
    }

    // Test Case No.5
    @Test
    public void SmallBranchInTime() {
        // Small Branch || Allow customer deposit transaction from 10 to 18 || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        String result = bankingSystem.deposit("SubBranch", 10, 10000);
        assertEquals("Accept the deposit transaction.", result);
    }

    // Test Case No.6
    @Test
    public void SmallBranchOutTime() {
        // Small Branch || Allow customer deposit transaction from 10 to 18 || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        String result = bankingSystem.deposit("SubBranch", 19, 10000);
        assertEquals("Reject the deposit transaction and notify the customer that it must be done during a specific time only.", result);
    }

    // Test Case No.7
    @Test
    public void NotExceedFiftyGrand() {
        // Daily Amount of deposit must be under 50K || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        Random random = new Random();
        int randomAmount = random.nextInt(50000) + 1;
        String result = bankingSystem.deposit("SubBranch", 10, randomAmount);
        assertEquals("Accept the deposit transaction.", result);
    }

    // Test Case No.8
    @Test
    public void ExceedFiftyGrand() {
        // Daily Amount of deposit can not be above 50K || BranchType, Time, Amount
        BankingSystem bankingSystem = new BankingSystem();
        Random random = new Random();
        int randomAmount = random.nextInt(100000) + 50000;
        String result = bankingSystem.deposit("SubBranch", 10, randomAmount);
        assertEquals("Reject the deposit transaction and notify the customer that there is a 1 day deposit limit.", result);
    }


}
