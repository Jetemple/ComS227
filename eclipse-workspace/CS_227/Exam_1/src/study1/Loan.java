package study1;

public class Loan {
	double rate;
	double balance;
	public Loan(double givenBalance,double givenIntrestRate)
	{
		rate = givenIntrestRate;
		balance = givenBalance;
	}
	private double payoffAmount=balance+(balance*rate);
	public void makePayment(double payment)
	{
		balance-=payment;
	}
	public double getBalance()
	{
		return balance;
	}
	public double getPayoffAmount()
	{
		return payoffAmount;
	}
}
