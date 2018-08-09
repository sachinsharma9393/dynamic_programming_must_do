package dp;

import java.util.Scanner;

/**
 * Created by sachin on 7/1/2018.
 */
public class Knapsack_0_1 {
    public static void main(String[] args) {
        //Greedy fails for 0-1 knapsack unlike in fractional where it gives max profit bcoz of choosing maxima with
        //p/w ratio
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER SIZE OF  WEIGHT ARRAY ");
        int n=sc.nextInt();
        int weight[]=new int[n];
        System.out.println("ENTER VALUES");
        for (int i = 0; i <n ; i++) {
            weight[i]=sc.nextInt();
        }

        System.out.println("ENTER VALUES FOR PROFIT");
        int profit[]=new int[n];
        for (int i = 0; i <n ; i++) {
            profit[i]=sc.nextInt();
        }

        System.out.println("NOW ENTER CAPACITY OF KNAPSACK");
        int c=sc.nextInt();

        int table[][]=new int[n+1][c+1];
        for (int i = 0; i <=n ; i++) {
            table[i][0]=0;
        }
        for (int i = 0; i <=c ; i++) {
            table[0][c]=0;
        }
        for (int i = 1; i <=n; i++) {
            for(int j=1;j<=c;j++)
            {

                //now if capacity of knapsack is greater or equal than weight we introduce
                if(weight[i-1]<=j)//index starts from 0,equal condition is important
                {
                    //now 2 cases if we include the weight or not, so we take max of both condition
                    //if we take then add profit+what is new capacity left to process
                    //if we do not take then just previous processed values with same capacity left of knapsack
                    table[i][j]=Math.max(profit[i-1]+table[i-1][j-weight[i-1]],table[i-1][j]);
                }
                else table[i][j]=table[i-1][j];
            }

        }
        System.out.println("MAX PROFIT IS "+table[n][c]);
        System.out.println("**TABLE**");
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=c ; j++) {
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }


    }
}
