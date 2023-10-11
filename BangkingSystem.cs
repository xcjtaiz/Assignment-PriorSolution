using System;
using Xunit;

public class BankingSystem
{
    private int totalDailyDeposit = 0;

     // Test Case No.1
    [Fact]
    public void CounterServiceInTime()
    {
        // Counter Service || Allow customer deposit transaction from 10 to 22  
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("CounterService", 10, 10000);
        Assert.Equal("The system should accept the deposit transaction.", result);
    }

    // Test Case No.2
    [Fact]
    public void CounterServiceOutTime()
    {
        // Counter Service || Allow customer deposit transaction from 10 to 22  
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("CounterService", 23, 10000);
        Assert.Equal("The system should reject the deposit transaction and notify the customer that it must be done during a specific time only.", result);
    }

     // Test Case No.3
    [Fact]
    public void BigBranchInTime()
    {
        // Big Branch || Allow customer deposit transaction from 10 to 20  
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("BigBranch", 10, 10000);
        Assert.Equal("The system should accept the deposit transaction.", result);
    }

     // Test Case No.4
    [Fact]
    public void BigBranchOutTime()
    {
        // Big Branch || Allow customer deposit transaction from 10 to 20  
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("BigBranch", 21, 10000);
        Assert.Equal("The system should reject the deposit transaction and notify the customer that it must be done during a specific time only.", result);
    }

    // Test Case No.5
    [Fact] 
    public void SmallBranchInTime()
    {
        // Small Branch || Allow customer deposit transaction from 10 to 18
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("SmallBranch", 10, 10000);
        Assert.Equal("The system should accept the deposit transaction.", result);
    }

    // Test Case No.6
    [Fact] 
    public void SmallBranchOutTime()
    {
        // Small Branch || Allow customer deposit transaction from 10 to 18
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("SmallBranch", 19, 10000);
        Assert.Equal("The system should reject the deposit transaction and notify the customer that it must be done during a specific time only.", result);
    }

    // Test Case No.7
    [Fact]
    public void NotExceedFiftyGrand()
    {
        // Daily Amount of deposit must be under 50K baht
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("SmallBranch", 10, 50000);
        Assert.Equal("The system should accept the deposit transaction.", result);
    
    }

    // Test Case No.8
    [Fact]
    public void ExceedFiftyGrand() 
    {
        // Daily Amount of deposit can not be above 50K
        var bankingSystem = new BankingSystem();
        var result = bankingSystem.Deposit("SmallBranch", 10, 60000);
        Assert.Equal("The system should reject the deposit transaction and notify the customer that there is a 1 day deposit limit.", result);
    }

    public string Deposit(string branchType, int time, int amount)
    {
        if (IsValidTime(branchType, time))
        {
            if (IsWithinDailyLimit(amount))
            {
                totalDailyDeposit += amount;
                return "The system should accept the deposit transaction.";
            }
            else
            {
                return "The system should reject the deposit transaction and notify the customer that there is a 1 day deposit limit.";
            }
        }
        else
        {
            return "The system should reject the deposit transaction and notify the customer that it must be done during a specific time only.";
        }
    }

    private bool IsValidTime(string branchType, int time)
    {
        if (branchType == "CounterService" && time >= 10 && time <= 22)
        {
            return true;
        }
        else if (branchType == "BigBranch" && time >= 10 && time <= 20)
        {
            return true;
        }
        else if (branchType == "SmallBranch" && time >= 10 && time <= 18)
        {
            return true;
        }
        return false;
    }

    private bool IsWithinDailyLimit(int amount)
    {
        return totalDailyDeposit + amount <= 50000;
    }
}


