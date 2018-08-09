package dp;

import java.util.Scanner;

/**
 * Created by sachin on 7/6/2018.
 */
public class Min_cost_Path {
    public static void main(String[] args) {
        //min cost to reach from (0,0) to (n-1,m-1) by moving right ,down,diagonal down
        System.out.println("ENTER N, M");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println("ENTER VALUES");
        int table[][]=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                table[i][j]=sc.nextInt();
            }
        }

        //2 methods either make a separate table so as to compute or make changes in that table
        //soace 0(1)in making changes in that table

        //first row will have only option of moving right from starting means (0,0)->(0,1)>(0,2).....
        for (int i = 1; i <m ; i++) {
            table[0][i]+=table[0][i-1];
        }

        //first column has only 1 way of moving down (0,0)->(1,0)->(2,0)->(3,0)

        for (int i = 1; i <n ; i++) {
            table[i][0]+=table[i-1][0];
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                //first max of above
                int min_so_for=Math.min(table[i-1][j-1],Math.min(table[i-1][j],table[i][j-1]));
                //after getting min from all above 3 just add it to particular table cell value
                table[i][j]+=min_so_for;
            }
        }
        System.out.println("MIN COST IS " + table[n-1][m-1]);

    }
}
