package lab9;

public class brickLayer {

    public static void main(String[] args)
    {
        int n = 5;
        System.out.println(countPatterns(n));
    }

    static void printArray(int arr[], int m)
    {
        for (int i = 0; i < m; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    static int countPatterns(int n)
    {
        int DP[] = new int[n + 1];

        // base cases
        DP[0] = DP[1] = DP[2] = 1;
        DP[2] = 1;

        // iterate for all values from 4 to n
        for (int i = 3; i <= n; i++)
            DP[i] = DP[i - 1] +
                    + DP[i - 3];

        return DP[n];
    }
}
