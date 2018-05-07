package Exam_Review;
import java.util.Scanner;


public class Problem8 {

    public static int tryStuff(String text)
    {
        int total = 0;
        int i =0;
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext())
        {
            try
            {
                String s = scanner.next();
                i = Integer.parseInt(s);
                total += i;
            }
            catch (NumberFormatException nfe) {
                total -= i;

            }
        }
        return total;
    }
    public static void main(String args[])
    {
        System.out.println(tryStuff("10 20 23skido 30 foo bar"));
    }
}
