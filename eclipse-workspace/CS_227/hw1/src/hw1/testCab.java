package hw1;

public class testCab 
{
	public static void main (String[] args)
	{
		Cab t = new Cab(3, 5);
		t.pickUp();
		t.drive(10);
		t.drive(2.2);
//		
//		System.out.println(t.pickUp(););
//		System.out.println(t.drive(10));
		System.out.println(t.getMeter());
		System.out.println("Expected 64");
	    
//	    // initially the total miles, total cash, current rate, 
//	    // and meter should be zero
//	    System.out.println(t.getTotalMiles());
//	    System.out.println("Expected 0");
//	    System.out.println(t.getTotalCash());
//	    System.out.println("Expected 0");
//	    System.out.println(t.getCurrentRate());
//	    System.out.println("Expected 0");
//	    System.out.println(t.getMeter());
//	    System.out.println("Expected 0");
//	    System.out.println();
//	    
//	    // after driving 5 miles, total mileage should be 5
//	    t.drive(5);
//	    System.out.println(t.getTotalMiles());
//	    System.out.println("Expected 5.0");
//	    
//	    // after pickUp, the meter should be 2.00 and the current rate should be 3.00
//	    t.pickUp();  // a passenger gets in
//	    System.out.println(t.getMeter());
//	    System.out.println("Expected 2.0");
//	    System.out.println(t.getCurrentRate());
//	    System.out.println("Expected 3.0");
//	    System.out.println();
//	   
//	    // after driving 10 miles, the meter should be 32.00  
//	    t.drive(10);
//	    System.out.println(t.getMeter());
//	    System.out.println("Expected 32.0");
////
//	    // after dropOff, meter and current rate should be 0
//	    t.dropOff();    
//	    System.out.println(t.getMeter());
//	    System.out.println("Expected 0");
//	    System.out.println(t.getCurrentRate());
//	    System.out.println("Expected 0");
//	    System.out.println();
////	    
//	    // total cash collected should be 32.00
//	    System.out.println(t.getTotalCash());
//	    System.out.println("Expected 32.0");
//	    
//	    // total miles should be 15
//	    System.out.println(t.getTotalMiles());
//	    System.out.println("Expected 15.0");

	}

}
