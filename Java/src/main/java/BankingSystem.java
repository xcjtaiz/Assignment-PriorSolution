
public class BankingSystem {

	private int totalDailyDeposit = 0;
	
    public String deposit(String branchType, int time, int amount) {
        if (isValidTime(branchType, time)) {
            if (isWithinDailyLimit(amount)) {
                totalDailyDeposit += amount;
                return "The deposit transaction is completed.";
            } else {
                return "The deposit transaction has been rejected because the customer has deposited more than daily limited.";
            }
        } else {
            return "The deposit transaction has been rejected and must be done during a specific time only.";
        }
    }

    private boolean isValidTime(String branchType, int time) {
        if ("Counter Service".equals(branchType) && time >= 10 && time <= 22) {
            return true;
        } else if ("Big Branch".equals(branchType) && time >= 10 && time <= 20) {
            return true;
        } else if ("Sub Branch".equals(branchType) && time >= 10 && time <= 18) {
            return true;
        }
        return false;
    }

    private boolean isWithinDailyLimit(int amount) {
        return totalDailyDeposit + amount <= 50000;
    }
}
