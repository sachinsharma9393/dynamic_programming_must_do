package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 6/26/2018.
 */
public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter first string ");
        String s1=sc.next();
        System.out.println("enter second string");
        String s2=sc.next();

        //brute force 0(2^n * m)
        //recursive 0(2^(m+n))
        //dp ---0(m*n) time and space

        int n=s1.length(),m=s2.length();
        int [][]table=new int[n+1][m+1];

        for (int i = 0; i <=n ; i++) {
            table[i][0]=0;//corner case as one string 0 then common subsequence is 0
        }
        for (int i = 0; i <=m ; i++) {
            table[0][i]=0;//corner case as one string 0 then common subsequence is 0
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))//bcoz string index starts from 0
                    table[i][j]=1+table[i-1][j-1];
                else {
                    table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        System.out.println(table[n][m]);


    }
}
