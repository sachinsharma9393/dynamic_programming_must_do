package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class Min_cost_identical_string {

    public static void main(String[] args) {
        //min cost to make string x to y using delete operation
        //first method is to find lcs(x,y)=l say it is l, then [len(x)-l]p +[len(y)-l]*q
        //forming dp

        System.out.println("ENTER X STRING");
        Scanner sc=new Scanner(System.in);
        String x=sc.next();
        System.out.println("ENTER Y STRING");
        String y=sc.next();
        System.out.println("ENTER COST TO DELETE FROM X ...P");
        int p=sc.nextInt();
        System.out.println("ENTER COST TO DELETE FROM Y ...Q");
        int q=sc.nextInt();

        find_cost(x,y,p,q);
        int lcs=get_lcs(x,y);
        System.out.println(("USING LCS METHOD COST IS "+((x.length() - lcs) * p + (y.length() - lcs) * q)));

    }

    private static int get_lcs(String x, String y) {
        int n=x.length(),m=y.length();
        int [][]table=new int[n+1][m+1];

        for (int i = 0; i <=n ; i++) {
            table[i][0]=0;//corner case as one string 0 then common subsequence is 0
        }
        for (int i = 0; i <=m ; i++) {
            table[0][i]=0;//corner case as one string 0 then common subsequence is 0
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(x.charAt(i-1)==y.charAt(j-1))//bcoz string index starts from 0
                    table[i][j]=1+table[i-1][j-1];
                else {
                    table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        return table[n][m];

    }

    private static void find_cost(String x, String y, int p, int q) {

        int n=x.length();
        int m=y.length();
        int table[][]=new int[n+1][m+1];
        //corner case
        //if x is null string then we have to delete all from y
        for (int i = 0; i <=m ; i++) {
            table[0][i]=i*q;//all q costs to delete from string y

        }
        //similarly if y is null then we have to delete al  from x
        for(int i=1;i<=n;i++)
        {
            table[i][0]=i*p;
        }
        //now main cases
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(x.charAt(i-1)==y.charAt(j-1))table[i][j]=table[i-1][j-1];//no cost required
                else
                    table[i][j]=Math.min(table[i-1][j]+p,table[i][j-1]+q);
            }
        }

        System.out.println("COST IS USING OTHER DP METHOD IS " + table[n][n]);

    }
}
