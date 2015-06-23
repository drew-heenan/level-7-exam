import java.util.Date;


public class BankAccount {

    private Date date;
    private double balance;

    public BankAccount(Date date, double balance) {
   	 this.date = date;
   	 this.balance = balance;
    }
    
    public Date getDateOpened() {
    	return date;
    }
    
    public void setBalance(double balance) {
    	this.balance = balance;
    }

    public double getBalance() {
   	 // TODO Auto-generated method stub
   	 return balance;
    }

}