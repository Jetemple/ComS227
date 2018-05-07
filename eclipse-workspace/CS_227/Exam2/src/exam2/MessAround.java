package exam2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

public class MessAround {
    public static void main (String args[]) {
        //a
//        double arr[] = {1.0,2,3,4};
//        double sum = 0;
//        for (int i = 0; i <arr.length; i++)
//        {
//            sum+=arr[i];
//        }
//        double average = sum/arr.length;
//        System.out.println(average);
        //b
        //c
        String str = "Hello, World!";
//        String newstr=str.replaceAll("[^A-Za-z0-9]","#" );
        int len = str.length();
        for (int i =0; i<len; i++)
        {
            char letter = str.charAt(i);
            boolean alpha = Character.isAlphabetic(letter);
            if (alpha==false)
            {
                str.replace(str.charAt(i), '#');
            }
        }
        System.out.println(str);
        //d (new Method) interest
//        System.out.println(interest(.5,100));
        //e
//        ArrayList<Integer> AL = new ArrayList<>(Arrays.asList(1,5,3,4,5,6));
//        int i = 0;
//        boolean order = true;
//        int before = AL.get(0);
//        while (i < AL.size() && order == true)
//        {
//            int current = AL.get(i);
//            if (before>current)
//            {
//                order = false;
//            }
//            i++;
//            before = AL.get(i-1);
//        }
//        System.out.println(order);
        //f
//        String str = "FFFFFFFFFUUUUU";
//        int i = 0;
//        boolean vowel = false;
//        while (vowel==false && i<str.length())
//        {
//            char c = str.charAt(i);
//            if (c=='a'||c=='e'||c=='i'||c=='o')
//            {
//                vowel=true;
//                break;
//            }
//            i++;
//        }
//        System.out.println(i);
        //g
//        String str = "Teet";
//        char repeat = ' ';
//        int count = 0;
//        for (int i=0; i < str.length(); i++)
//        {
//            for (int j=0; j<i; j++)
//            {
//                if (str.charAt(i)==str.charAt(j))
//                {
//                    count++;
//                    if (count>1)
//                    {
//                        repeat=str.charAt(i);
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(count);
        //h (Method) Reverse
//        int arr[] = {1,2,3,4,5};
//        reverse(arr);
//        System.out.println(Arrays.toString(arr));
        //i (Same thing as G
        //j
//        int n = 10;
//        int i = 0;
//        int spaces = n;
//        while (i != n) {
//            spaces--;
//            for (int j = 0; j < spaces; j++) {
//                System.out.print(" ");
//            }
//            System.out.println("*");
//            i++;
//        }
        //k
//        double arr[][]={{1,2,3,},{4,5,6}};
//        double arr2[]=new double[arr[0].length];
//        for (int i=0; i <arr[0].length; i++)
//        {
//            double colSum=0;
//            for (int j=0; j<arr.length; j++)
//            {
//                colSum+=arr[j][i];
//            }
//            arr2[i]=colSum/arr.length;
//        }
        //l
//        int arr[][]={{1,2,3,4},{1,2,3,4}};
//        int col[]=new int[arr[0].length];
//        for (int i=0; i<arr[0].length;i++){
//            int sum=0;
//            for(int j=0; j<arr.length;j++){
//                sum+=arr[j][i];
//            }
//            col[i]=sum;
//        }
//        int max=0;
//        for (int i=1; i<col.length; i++){
//            if(col[i]>col[i-1]){
//                max=i;
//            }
//        }
//        System.out.println("The largest column is column index "+ max);
        //m
//        System.out.println(9%2);
        //n
//        int n =14;
//        int p =n+1;
//        boolean prime = false;
//        while (n<p && prime == false){
//            for (int i=2; i<p; i++){
//                if (p%i==0){
//                    prime=false;
//                    break;
//                }
//                if (p%i!=0){
//                    prime = true;
//                }
//            }
//            if (prime == true)
//            {
//                break;
//            }
//            else{
//                p++;
//            }
//        }
//        System.out.println("The smallest prime number larger than "+ n + " is "+p);
//        System.out.println(Arrays.toString(arr2));
        //o (METHOD) Duplicates
//        int arr[]={5,4,5,6,4,2};
//        dupes(arr);
//        System.out.println(Arrays.toString(arr));
        //p (METHOD) Shorten
//        int arr[]={5,4,5,6,4,2};
//        System.out.println(Arrays.toString(shorten(arr)));
        //q
//        Random rand = new Random(2);
//        ArrayList<Integer> aL = new ArrayList<>();
//        int p = 100;
//        boolean repeat = false;
//        while (repeat==false){
//            int n=rand.nextInt(100);
//            if (aL.contains(n)){
//                break;
//            }
//            aL.add(n);
        //r
//        String str = "He's dead, Jim";
//        ArrayList<String> al = new ArrayList<>();
//        for (String word: str.split(" "))
//        {
//            al.add(word);
//        }
//
//        ArrayList<String> al2 = new ArrayList<>();
//        for (int i= al.size()-1;i>-1;i--){
//            al2.add(al.get(i));
//        }
//        System.out.println(Arrays.toString(al2.toArray()));
        //PROBLEM 2 (METHOD ENIGMA)
//        enigma(12,0 );
        //Problem 3 (Method Whatever)
//        int[] test = {6,7,4,3,5,2,7,9,8};
//        int[] test1 = new int[test.length];
//        test1=whatever(test);
//        System.out.println(Arrays.toString(test1));
        //PROBLEM 5 (METHOD getPassword)
//        getPassword();
//        String givenFile = "test.java";
//        String outfile =givenFile.substring(0,givenFile.indexOf((".java")))+".out";
//        System.out.println(outfile);

    }

    public static String getPassword(){
        boolean same = false;
        Scanner reader = new Scanner(System.in);
        while (same == false){
            System.out.println("Please enter your password: ");
            String first = reader.next();
            System.out.println("Please enter your password again to confirm it: ");
            String second = reader.next();
            if (first.equals(second)){
                same = true;
                return first;
            }
            System.out.println("Sorry. The passwords didn't match!");
        }
        return null;
    }

    public static void commentOut()
    {
        String givenFile = "NewFile";
        String outfile =givenFile.substring(0,givenFile.indexOf((".java")))+".out";
    }

    public static void dupes(int arr[])
    {
        for (int i=0; i<arr.length;i++){
            for (int j=0; i<arr.length;j++)
            {
                if(j==i)
                {
                    j++;
                    break;
                }
                else{
                    if (arr[i]==arr[j]){
                        for (int k =j+1;k<arr.length;k++)
                        {
                            arr[k-1]=arr[k];
                        }
                        arr[arr.length-1]=0;
                    }
                }
            }
        }
    }
    public static int[] shorten(int arr[])
    {
        for (int i=0; i<arr.length;i++){
            for (int j=0; i<arr.length;j++)
            {
                if(j==i)
                {
                    j++;
                    break;
                }
                else{
                    if (arr[i]==arr[j]){
                        for (int k =j+1;k<arr.length;k++)
                        {
                            arr[k-1]=arr[k];
                        }
                        arr[arr.length-1]=0;
                    }
                }
            }
        }
        int len =0;
        int i=0;
        while (arr[i]!=0){
            len++;
            i++;
        }
        int arr2[]=new int[len];
        for (int j =0; j<len; j++)
        {
            arr2[j]=arr[j];
        }
        return arr2;
    }

    public static int interest(double rate, double balance){
        int month=0;
        double monthly=(rate/12.0);
        double goal = balance *2;
        while (balance<=(goal))
        {
            balance = balance + (balance * monthly);
            month++;
        }
        return month;
    }
    public static void reverse(int[] arr)
    {
        int[] arr2 = new int[arr.length];
        for (int i=0; i<arr.length; i++)
        {
            arr2[arr.length-1-i]=arr[i];
        }
        arr=arr2;
    }
    public static void enigma(int x, int y)
    {
        while (x>0)
        {
            if (x % 2 ==0 )
            {
                y = y+1;
            }
            else
            {
                x=x+2;
            }
            x=x-y;
            System.out.println(x + ", " +y);
        }
    }
    public static int[] whatever(int[] arr)
    {
        int i =0;
        for (int count =0; count<arr.length; count ++)
        {
            if (arr[i] % 2 !=0)
            {
                for (int j =i; j< arr.length-1; j ++)
                {
                    arr[j]=arr[j+1];
                }
                arr[arr.length-1]=0;
            }
            else
            {
                i++;
            }
        }
        return arr;
    }
}
