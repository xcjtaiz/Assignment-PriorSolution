
public class BankingSystem {

	private int totalDailyDeposit = 0;
	
    public String deposit(String branchType, int time, int amount) {
        if (isValidTime(branchType, time)) {
            if (isWithinDailyLimit(amount)) {
                totalDailyDeposit += amount;
                return "Accept the deposit transaction.";
            } else {
                return "Reject the deposit transaction and notify the customer that there is a 1 day deposit limit.";
            }
        } else {
            return "Reject the deposit transaction and notify the customer that it must be done during a specific time only.";
        }
    }

    private boolean isValidTime(String branchType, int time) {
        if ("CounterService".equals(branchType) && time >= 10 && time <= 22) {
            return true;
        } else if ("BigBranch".equals(branchType) && time >= 10 && time <= 20) {
            return true;
        } else if ("SubBranch".equals(branchType) && time >= 10 && time <= 18) {
            return true;
        }
        return false;
    }

    private boolean isWithinDailyLimit(int amount) {
        return totalDailyDeposit + amount <= 50000;
    }
}
