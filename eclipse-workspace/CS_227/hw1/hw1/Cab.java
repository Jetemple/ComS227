package hw1;
//@author Jack Temple

public class Cab {
	//Current value of meter
	private double meter;
	
	// Keeps track of cash made since cab has started
	private double totalCash;
	
	//Keeps track of the total miles driven since the cab has started
	private double totalMiles;
	
	//Cost of cab per min
	private double baseFare;
	
	//Cost of cab per mile
	private double perMileRate;
	
	//Current Rate
	private double currentRate;

	
	/**
	 * Determines whether the cab currently has a passenger 
	 * (i.e., the current rate is nonzero).
	 */
	public boolean hasPassenger()
	{
		return currentRate!= 0;
	}
	
	
	/*
	 * Constructor variable to set the given base fare and the give per mile
	 * rate of the cab
	 */
	public Cab(double givenBaseFare, double givenPerMileRate)
	{
		baseFare = givenBaseFare;
		perMileRate = givenPerMileRate;
	}
	
	/**
	 * Starts a new ride, 
	 * setting the meter to the base fare and setting the current 
	 * rate to the per mile charge. If there had been a previous call to pickUp() 
	 * without a corresponding call to dropOff(), the previous value on the meter is ignored.
	 */
	public void pickUp()
	{
		meter=baseFare;
		currentRate=perMileRate;
	}
	/**
	 * Ends the current ride, 
	 * updating the total cash collected and resetting 
	 * the meter and current rate to zero.
	 */
	public void dropOff()
	{
		totalCash = meter + totalCash;
		meter=0;
		currentRate=0;
	}
	
	/**
	 * Drives the cab the given number of miles,
	 * updating the total miles and possibly updating the meter.
	 */
	public void drive(double miles)
	{
		totalMiles = miles+totalMiles;
		meter=meter+miles*currentRate;
		miles=0;
	}
	
	//Returns the total miles driven by this cab during its lifetime.
	public double getTotalMiles()
	{
		return totalMiles;
	}
	
	//Returns the total cash collected by this cab during its lifetime.
	public double getTotalCash()
	{
		return totalCash;
	}
	
	/**
	 * Returns the amount of money shown on the meter for the current ride. 
	 * This will always be zero before start() is called.
	 */
	public double getMeter()
	{
		return meter;
	}
	/**
	 * Returns the current per-mile rate, which is always either zero or 
	 * the per-mile rate given in the constructor.
	 */
	public double getCurrentRate()
	{
		return currentRate;
	}
	
	/**
	 * Average income per mile for the cab since it started driving
	 */
	public double getAverageIncomePerMile()
	{
		double averageIncomePerMile=totalCash/totalMiles;
		return averageIncomePerMile;
	}
}
