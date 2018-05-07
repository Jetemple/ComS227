package hw2;
import java.util.Random;
import java.util.Scanner;

public class Testing {
	public static void main(String[]args)
	{
		Scanner reader = new Scanner(System.in);
		Random r=new Random();
		int number=r.nextInt(50-1+1)+1;
		System.out.println("Enter your first name");
		String first = reader.next();
		System.out.println("Enter your last name");
		String last = reader.next();
		String lowerFirst = first.toLowerCase();
		System.out.println(lowerFirst.charAt(0)+last.toLowerCase()+number);
		
		
	}
	
	

}
