package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class String_occured_as_subsequence_in_another {
    public static void main(String[] args) {
        //brute force approach is to generate all subsequences and check whether it occurred 0(2^n * n)
        // solving through dp

        System.out.println("ENTER MAIN STRING");
        Scanner sc=new Scanner(System.in);
        String main=sc.next();
        System.out.println("ENTER STRING TO COUNT AS SUBSEQUENCE IN MAIN");
        String sub=sc.next();
        System.out.println("NUMBER OF TIMES " + sub + " occurred in " + main + " is " + count(main, sub));
    }

    private static int count(String main, String sub) {
            int n=main.length();
        int m=sub.length();
        int table[][]=new int[n+1][m+1];
        //dealing with corner case
        //if main string is null then we will not find any subsequence of it in sub,,,,only both as empty so [0][0]=1 else 0

        for (int i = 1; i <=m ; i++) {
            table[0][i]=0;
        }
   //if sub string is empty then empty is one of the subsequence so all entries  [0][i] will be 1 including [0][0]

        for (int i = 0; i <=n ; i++) {
            table[i][0]=1;
        }

        //after corner case lets get to main code
        for(int i=1;i<=n;i++)
        {
            for (int j = 1; j <=m ; j++) {
                if(main.charAt(i-1)==sub.charAt(j-1))
                {
                    table[i][j]=table[i-1][j-1]+table[i-1][j];//table[i-1][j] is added as it can occur in remaining string of main
                }
                else table[i][j]=table[i-1][j];
            }
        }

    return table[n][m];
    }
}
