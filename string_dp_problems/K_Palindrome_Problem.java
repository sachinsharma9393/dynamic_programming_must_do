package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class K_Palindrome_Problem {
    public static void main(String[] args) {
        //find whether after k deletion in a string it becomes palindrome or not
        //m-1 brute force find all possible combinations with 1 deletion,nC1,nC2.......0(n^k)if ki large it is exponential
        //best method is to find lcs(str,rev(str)) and then n-lcs=k bcoz this factor deletion causes palindrome

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STRING");
        String s=sc.next();
        StringBuilder sb=new StringBuilder(s);
        String srev=sb.reverse().toString();
        System.out.println(" K-DELETION PROBLEM ---REQUIRED " + lcs(s, srev) + " to make it palindrome  ");


    }

    private static int lcs(String s, String srev) {
        int n=s.length();
        int table[][]=new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(s.charAt(i-1)==srev.charAt(j-1))
                {
                    table[i][j]=1+table[i-1][j-1];
                }
                else table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
            }
        }
        System.out.println(table[n][n]);
        return (n-table[n][n]);
    }
}
