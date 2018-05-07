package mini1;
import java.util.ArrayList;

/**
 * Try saying that five times fast.
 */
public class LoopTheLoopyLoopingLoopers
{

  /**
   * Private constructor means this class cannot be instantiated.
   */
  private LoopTheLoopyLoopingLoopers()
  {  
    // do nothing
  }
  
  
  /**
   * Determines the number of iterations of Newton's method
   * required to approximate the square root of x within
   * the given bound.  Newton's method starts out by 
   * setting the initial approximate <em>answer</em> to x.  
   * Then in each iteration, <em>answer</em> is replaced by 
   * the quantity <em>(answer + x / answer) / 2.0</em>.
   * The process stops when the difference between 
   * x and <em>(answer * answer)</em> is strictly less than
   * the given bound <code>err</code>.  The method
   * returns the number of iterations required.
   * The given value x must be non-negative.
   * <p>
   * For example, given x = 10 the first three iterations
   * of Newton's method produce the approximate values 
   * 5.5, 3.66, and 3.20. Those three values squared are
   * 30.29, 13.39, and 10.21, respectively.
   * Therefore <code>countIterations(10, 1.0)</code>
   * returns 3, since it takes 3 iterations to get the result 10.21
   * that is within 1.0 of x.  
   * On the other hand, <code>countIterations(10, 200)</code> returns 0,
   * since 10 * 10 = 100 is already within 200 units of x = 10.
   * @param x
   *   value whose square root is to be approximated
   * @param err
   *   given bound for the approximation
   * @return
   *   number of iterations required to get an approximation
   *   whose square is within the given bound of x
   */
  public static int countIterations(double x, double err)
  {
	  int times=0;
	  double answer=x;
	  while(Math.abs((answer*answer)-x)>err) {
		  for (int i=1; i>0;) {
			  answer=(answer+x/answer)/2.0;
			  i-=1;
			  times+=1;
			}
	  }
	  
	  return times;
	  
  }

  /**
   * Returns a string with runs of consecutive characters removed.
   * For example, <code>eliminateRuns("abbbccbbd")</code> returns 
   * the string "abcbd".
   * @param s
   *   given string (possibly empty)
   * @return
   *   string similar to s but with runs removed
   */
  public static String eliminateRuns(String s)
  {
	  String newWord = s.replaceAll("(.)\\1{1,}", "$1");
	  return newWord;
  }
  
  /**
   * Returns the second largest value in a list of numbers,
   * where the list is given as a string of text containing integer
   * values separated by arbitrary whitespace.  Duplicates are allowed, so
   * the largest and second largest numbers may be the same; for example,
   * given the string "17  137  42  137", the method returns 137. 
   * The behavior is undefined if the provided string contains any 
   * non-numeric values or contains fewer than two numbers.
   * @param text
   *   string of text containing at least two numbers separated by whitespace
   * @return
   *   second largest value in the string
   */ 
  public static int findSecondLargest(String text)
  {
	  String[] parts = text.split(" ");
	  int[] intArray = new int[parts.length];
	  for(int n = 0; n < parts.length; n++) {
	     intArray[n] = Integer.parseInt(parts[n]);
	  }

	  int largest = Integer.MIN_VALUE;
	  int secondLargest = Integer.MIN_VALUE;
	  for (int i=0; i<intArray.length; i++)
	  {
		  if (intArray[i]>largest)
		  {
			  secondLargest=largest;
			  largest=intArray[i];
		  }
		  else if (intArray[i]>=secondLargest)
		  {
			  secondLargest=intArray[i];
		  }
	  }
	  return secondLargest;
	  
  }
  
  /**
   * Determines whether the given string of text represents a 
   * <em>Lucas sequence</em>, where the given text consists of integer
   * values separated by arbitrary whitespace.  A Lucas sequence
   * is any sequence of numbers in which each value (other than
   * the first and second) is the sum of the previous two values.
   * The Fibonacci sequence is one example of a Lucas sequence.
   * Another one would be "-2 1 -1 0 -1 -1 -2 -3 -5 -8".
   * This method returns true if the sequence has fewer than 3 numbers.
   * The behavior is undefined if the provided string contains any non-numeric
   * values.
   * @param text
   *   string of text (possibly empty) containing numbers separated by whitespace
   * @return
   *   true if the given sequence of numbers is a Lucas sequence, 
   *   false otherwise
   */
  public static boolean isLucasSequence(String text)
  {
	  boolean tF= false;
	  String[] items = text.split(" ");
	  int[] intArray = new int[items.length];
	  for (int i = 0; i < items.length; i++){
		    intArray[i] = Integer.parseInt(items[i]);
	  }
	  if (intArray.length>2);
	  {
		  for (int i=2; i<intArray.length; i++)
		  {

			  if (intArray[i]==intArray[i-1]+intArray[i-2])
			  {
				  tF=true;
			  }
			  else
			  {
				  tF=false;
				  break;
			  }
		  }
	  }
	return tF;
	  }

  /**
   * Returns the character that occurs most frequently in 
   * the given string.  If several characters occur with 
   * the same maximum frequency, returns the one that
   * occurs first in the string.  The string must be nonempty.
   * <p>
   * For example, given the string "banana" the method returns 'a'.
   * Given the string "abcbcbbcca" the method returns 'b'.
   * @param s
   *   nonempty string
   * @return
   *   most frequently occurring character in s
   */
  public static char findMostFrequentCharacter(String s)
  {
	  if (s == null || s.isEmpty()) {
	        throw new IllegalArgumentException("input word must have non-empty value.");
	    }
	    char maxchar = ' ';
	    int maxcnt = 0;	    // if you are confident that your input will be only ascii, then this array can be size 128.
	    int[] charcnt = new int[Character.MAX_VALUE + 1];
	    for (int i = s.length() - 1; i >= 0; i--) {
	        char ch = s.charAt(i);	        // increment this character's cnt and compare it to our max.
	        if (++charcnt[ch] >= maxcnt) {
	            maxcnt = charcnt[ch];
	            maxchar = ch;
	        }
	    }
	    return maxchar;
  }

  /**
   * Counts the number of times that one string occurs as a substring in
   * another, optionally allowing the occurrences to overlap.  For
   * example:
   * <ul>
   * <li><code>countOccurrences("aa", "aaaaa", false)</code> returns 2
   * <li><code>countOccurrences("aa", "aaaaa", true)</code> returns 4
   * <li><code>countOccurrences("aa", "ababab", true)</code> returns 0
   * </ul>
   * 
   * @param t
   *   string we are looking for ("target")
   * @param s
   *   string in which we are looking ("source")
   * @param allowOverlap
   *   true if occurrences of t are allowed to overlap
   * @return
   *   number of times t occurs in s as a substring
   */
  public static int countOccurrences(String t, String s, boolean allowOverlap)
  {

	  int lastIndex = 0;
	  int count = 0;
	  if (allowOverlap==false) {
		  while(lastIndex != -1){

			  lastIndex = s.indexOf(t,lastIndex);

			  if(lastIndex != -1){
				  count ++;
				  lastIndex += t.length();
			  }
		  }
	  }
	  if (allowOverlap==true) {
		  for (int i = 1; i < s.length(); i++){
			  if (t.charAt(0)+(t.charAt(t.length()-1))==s.charAt(i)+s.charAt(i-1)) {
				  count ++;
			  }
			  
		  }
	  }
	  return count;
  }
  
  /**
   * Merges two strings together, using alternating characters from each,
   * except that runs of the same character are kept together.  For example,
   * <ul>
   * <li><code>mergePreservingRuns("abcde", "xyz") returns "axbyczde"
   * <li><code>mergePreservingRuns("abbbbcde", "xyzzz") returns "axbbbbyczzzde"
   * </ul>
   * Either or both of the strings may be empty.  If the first string
   * is nonempty, its first character will be first in the returned string.
   * @param t
   *   first string
   * @param s
   *   second string
   * @return
   *   string obtained by merging characters from t and s, preserving runs
   */
  public static String mergePreservingRuns(String t, String s)
  {
	  int tNextChar = 0;
	  int sNextChar = 0;
	  String result = "";

	  while (tNextChar < t.length() && sNextChar < s.length()) {
		  char tPrevChar = t.charAt(tNextChar++);
		  result += tPrevChar;
		  while (tNextChar < t.length() && t.charAt(tNextChar) == tPrevChar) {
			  result += tPrevChar;
			  tNextChar++;
		  }
		  char sPrevCHar = s.charAt(sNextChar++);
		  result += sPrevCHar;
		  while (sNextChar < s.length() && s.charAt(sNextChar) == sPrevCHar) {
			  result += sPrevCHar;
			  sNextChar++;
		  }
	  }
	  while (tNextChar < t.length()) {
		  result += t.charAt(tNextChar++);
	  }
	  while (sNextChar < s.length()) {
		  result += s.charAt(sNextChar++);
	  }


	  return result;
  }
  
  /**
   * Separates s into two strings, each made of alternating characters
   * from s, except that runs of the same character are kept together.
   * The two strings are concatenated with a space between them to make
   * a single returned string. If the given string is empty, the returned 
   * string is a single space.
   * For example,
   * <ul>
   * <li><code>takeApartPreservingRuns("abcdefa")</code> returns "acea bdf"
   * <li><code>takeApartPreservingRuns("aabcccddddefa")</code> returns "aaccccea bddddf"
   * </ul>
   * @param s
   *   any string
   * @return
   *   pair of strings obtained by taking alternating characters from s, 
   *   keeping runs of the same character together, concatenated with 
   *   one space between them into a single string 
   */
  public static String takeApartPreservingRuns(String s) {
	  String[] out = s.split("(?<=(.))(?!\\1)");
	  ArrayList arr1 = new ArrayList();
	  ArrayList arr2 = new ArrayList();
	  for (int i=0; i<out.length; i++){
	  	if (i % 2 == 0) {
	  		arr1.add(out[i]);
		  }
	  	else {
			  arr2.add(out[i]);
		  }

	  }
	  String string1 = String.join("", arr1);
	  String string2 = String.join("", arr2);
	  return string1+" "+string2;
//	  
	  }


}
