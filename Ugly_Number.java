package dp;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class Ugly_Number {
  static   int i=0,j=0,k=0;//array index starts from 0,made class level because otherwise after max finding which to incre-
    //ment was a problem
    public static void main(String[] args) {
        //brute force very difficult to analyze whether n/2,n/3,n/5 divisions
        //best is to use dynamic programming

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER N^th UGLY NUMBER YOU WANT ");
        int n=sc.nextInt();

        //now concept is to have three variables i,j,k initially pointing to 1
        //where i will be used to multiply a[i]*2, j for a[j]*3, k for a[k] *5
        //taking min of above will give next ugly number and increment count of either i,j,k

        int count=1;
        //first ugly number is 1
        int ugly[]=new int[n];
        ugly[count-1]=1;

        while (count !=n)//array index starts form 0
        {
            count++;
            int m2=ugly[i]*2;
            int m3=ugly[j]*3;
            int m5=ugly[k]*5;

          int val=  find_min(m2,m3,m5);
            ugly[count-1]=val;
            if(m2==val)i++;
            if(m3==val)j++;
            if(m5==val)k++;
            //System.out.println(i+"--"+j+"--"+k);

        }
        System.out.println( n+" UGLY NUMBER IS = " + ugly[n - 1]);
    }

    private static int find_min(int a, int b, int c) {
        if(a<b)
        {
            if(a<c)
            {
                return a;
            }

            else
            {
                return c;
            }
        }
        else {
            if(b<c)
            {
                return b;
            }
            else
            {
                return c;
            }
        }

    }
}
