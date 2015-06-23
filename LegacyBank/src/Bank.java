import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Bank {
	
	private static final double interestRate = 0.0254;
    
    public void updateBalances(List<BankAccount> accounts){
   	 for (BankAccount account : accounts) 
   		 applyInterest(account);
    }

	public void applyInterest(BankAccount account) {
			double interest = calculateInterest(account);
   		 BankAccount acc = (BankAccount) account;
   		 acc.setBalance(acc.getBalance() + interest);
	}
    
    public double calculateInterest(BankAccount account) {
	   	 Date dateOpened = account.getDateOpened();
	   	 double amount = account.getBalance();
	   	 int diff = calculateTimeSinceOpening(dateOpened);
	     //return  2.54 * amount;
	   	 return diff * interestRate * amount;
    }

	public int calculateTimeSinceOpening(Date dateOpened) {
		Calendar a = Calendar.getInstance(Locale.US);
			a.setTime(new Date());
			Calendar b = Calendar.getInstance(Locale.US);
			b.setTime(dateOpened);
			int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
			if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
		    	(a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
		    	diff--;
			}
		 
		if(diff<0) 
			diff=-diff;
		return diff;
	}


}


