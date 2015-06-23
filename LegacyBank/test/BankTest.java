

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class BankTest {

	@Test
	public void testCalculateInterest() throws Exception {
		Bank b = new Bank();
		Date yearAgo = new Date();
		yearAgo.setYear(yearAgo.getYear() - 1);  //Lots of deprecation, wasn't really any other option I could see.
		BankAccount account = new BankAccount(yearAgo, 1);
		assertEquals(0.0254, b.calculateInterest(account), 0.0001); //Because imprecision is bad
		
	}
	
	@Test
	public void testUpdateBalances() throws Exception {
		Date twoYearsAgo = new Date();
		twoYearsAgo.setYear(twoYearsAgo.getYear() - 2);
		ArrayList<BankAccount> accounts = new ArrayList();
		Random r = new Random(1); //Doing it this way to make it tested. Thoroughly.
		for(int i = 0; i < 10; i++)
			accounts.add(new BankAccount(twoYearsAgo, r.nextDouble() + r.nextInt(2000)));
		Bank b = new Bank();
		b.updateBalances(accounts);
		r = new Random(1); //Using the same seed cause I was lazy yet felt random
		for(BankAccount account : accounts) {
			double principle = r.nextDouble() + r.nextInt(2000);
			assertEquals(principle * (1 +0.0254*2), account.getBalance(), 0.0001); //Because the interest formula was wrong but the Great Leader June is allowed to change it
		}
	}
	
	@Test
	public void testTimeSinceOpening() throws Exception {
		Date d = new Date();
		d.setYear(d.getYear() - 10);
		d.setMonth(10);
		Bank b = new Bank();
		assertEquals(10, b.calculateTimeSinceOpening(d));
		d.setMonth(1);
		assertEquals(11,  b.calculateTimeSinceOpening(d));
	}

}
