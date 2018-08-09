package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class Longest_Palindrome_Subsequence {
    public static void main(String[] args) {
        //m-1 is to generate all subsequences and check in them 0(2^N)PROBLEM
        //m-2 find lcs(string,its reverse) it will give longest palindrome
        //another dp method

        System.out.println("ENTER STRING");
        Scanner sc=new Scanner(System.in);
        //using first method
        String main=sc.next();
        StringBuilder b=new StringBuilder(main);
        String rev= b.reverse().toString();
        System.out.println("LONGEST PALINDROME IS "+lcs(main, rev));

        System.out.println("M-3 DP other than lcs ");
        System.out.println("LONGEST PALINDROME IS "+ dp_lcs(main));
    }

    private static int dp_lcs(String main) {
        int n=main.length();
        int table[][]=new int[n][n];
        //here we will fill diagonal by diagonal and for i<=j
        for (int i = 0; i <n ; i++) {
            table[i][i]=1;//it represents 1 length string
        }
        //now we will go for lengths>=2
        for(int l=2;l<=n;l++)
        {
            for (int i = 0; i <n-l+1 ; i++) {
                int j=i+l-1;
                if(main.charAt(i)==main.charAt(j)&&l==2)
                {
                    table[i][j]=2;//this case is actually character matched for 2 length string ex aa,bb
                }
                else if(main.charAt(i)==main.charAt(j))
                    table[i][j]=table[i+1][j-1]+2;//for lengths >2 this will hold
                else //unmatched case
                    table[i][j]=Math.max(table[i][j-1],table[i+1][j]);
            }
        }


    return table[0][n-1];
    }

    private static int lcs(String main, String rev) {
           int n=main.length();
            int table[][]=new int[n+1][n+1];
        for (int i = 0; i <=n ; i++) {
            table[i][0]=0;
            table[0][i]=0;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {

                if(main.charAt(i-1)==rev.charAt(j-1))
                    table[i][j]=1+table[i-1][j-1];
                else
                {
                    table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        return table[n][n];

    }

}
