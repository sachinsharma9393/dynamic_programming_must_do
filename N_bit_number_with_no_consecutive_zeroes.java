package dp;

import java.util.Scanner;

/**
 * Created by sachin on 6/25/2018.
 */
public class N_bit_number_with_no_consecutive_zeroes {
    public static void main(String[] args) {

        //method-1 is brute force where we generate every possible numbers with n bits and then checking
        //in it whether it contains consecutive 0's or not so 0(2^n * n)problem


        //method-2 is doing with Dynamic programming 0(n) time and space 0(n)
        //m-3 dp with 0(n)time and space 0(n)

        Scanner sc=new Scanner(System.in);
        System.out.println(" ENTER NUMBER ");
        int n=sc.nextInt();
        find_number_of_nbit(n);
    }

    private static void find_number_of_nbit(int n) {
            int temp[]=new int[n+1];//leaving 0^th index
        temp[1]=2;
        temp[2]=3;
        //base case add

        for (int i = 3; i <=n ; i++) {
            temp[i]=temp[i-1]+temp[i-2];
        }
        System.out.println("space 0(n) approach --> possible number are "+temp[n]);
        int a=2;
        int b=3;
        for (int i = 3; i <=n ; i++) {
            int val=a+b;
            //now replace values of a,b
            a=b;//shifting 1 values just like array as a was temp[1] b was temp[2] now as we got temp[3]
            //now put a=temp[2] and b will be newly calculated temp[3],similarly go on till n of loop
            b=val;//last answer will be b
        }
        System.out.println("space 0(1) approach --> possible number are "+b);
    }
}
