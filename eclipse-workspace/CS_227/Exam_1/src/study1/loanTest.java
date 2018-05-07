package study1;

public class loanTest {
	public static void main(String[]args)
	{
		Loan n = new Loan(3000,.4);
		
		n.makePayment(100);
		System.out.println(n.getBalance());
	}

}
