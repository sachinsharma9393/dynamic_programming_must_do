package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/8/2018.
 */
public class Largest_repeating_subsequence {

    public static void main(String[] args) {
        //only difference in this problem with substring is when condition of s[i]!=s[j]
        //here just conventional dp formula table[i][j]=max(table[i-1][j],table[i][j-1]) and answer will be table[n][n]

        //brute force 0(2^n)

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STRING");
        String s=sc.next();
        int n=s.length();
        int table[][]=new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            table[0][i]=0;
            table[i][0]=0;
        }
        //here no such condition of i<j as we are not talking of non overlapping
        for (int i = 1; i <=n ; i++) {
            for(int j=1;j<=n;j++)
            {
                if (s.charAt(i-1) == s.charAt(j-1)&&i!=j)
                {
                    table[i][j] = 1 + table[i - 1][j - 1];

                }


                else
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
            }
        }
        System.out.println("LONGEST REPEATING SUBSEQUENCES IS OF LENGTH " + table[n][n]);


        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=n ; j++) {
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
