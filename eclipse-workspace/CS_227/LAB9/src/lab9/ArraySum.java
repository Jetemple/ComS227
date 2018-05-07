package lab9;

public class ArraySum
{
  /**
   * Try it out.
   */
  public static void main(String[] args)
  {
    int[] test = {3, 4, 5, 1, 2, 3, 2}; // sum should be 20
    int result = getLargest(test);
    System.out.println(result);
    int n=7;
    int total = pryamid(n);
    System.out.println(total);

  }

  /**
   * Returns the sum of all array elements.
   */
  public static int arraySum(int[] arr)
  {
    return arraySumRec(arr, 0, arr.length - 1);
  }
  
  /**
   * Returns the sum of array elements from start to end, inclusive.
   */
  private static int arraySumRec(int[] arr, int start, int end)
  {
    if (start == end)
    {
      return arr[start];
    }
    else
    {
      int mid = (start + end) / 2;
      int leftSum = arraySumRec(arr, start, mid);
      int rightSum = arraySumRec(arr, mid + 1, end);
      return leftSum + rightSum;
    }
  }
  public static int getLargest(int ... myArray) {
    return getLargest(myArray, 0, myArray.length);
  }

  private static int getLargest(int[] myArray, int from, int to) {
    if(from == to) {
      throw new IllegalArgumentException("empty array");
    } else if (from + 1 == to) {
      return myArray[from];
    } else {
      int middle = (from + to)  / 2;
      return Math.max(getLargest(myArray, from, middle), getLargest(myArray, middle, to));
    }
  }

  public static int pyramid(int n){
    return pyramid(n);
  }

  private static int pryamid(int n){
    int count =0;
    int base=0;

    if (n<=0)
    {
      throw new IllegalArgumentException("impossible");
    }
    else if (n==1)
    {
      return (1);
    }
    else {
      base= n*n;
      count = pryamid(n-1);

    }
    return base+count;
  }
}