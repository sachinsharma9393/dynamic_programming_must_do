package dp;

import java.util.Scanner;

/**
 * Created by sachin on 7/6/2018.
 */
public class Coin_Change {
    public static void main(String[] args) {
        //NO OF WAYS TO GET A PARTICULAR AMOUNT WITH SET OF COINS GIVEN

        //brute force and recursive is exponential 0(amount^coins) is the time complexity
        //m-2 is dp
        System.out.println("ENTER AMOUNT");
        Scanner sc=new Scanner(System.in);
        int amount=sc.nextInt();
        System.out.println("ENTER SIZE OF COINS  ARRAY ");
        int n=sc.nextInt();
        int coin[]=new int[n];
        System.out.println("ENTER VALUES");
        for (int i = 0; i <n ; i++) {
            coin[i]=sc.nextInt();
        }
        int table[][]=new int[n+1][amount+1];
        //first handling base condition
        // 1. if amount=0 then we have one way of not choosing any of the coins
        // 2. now if coins=0 then we have no decisions to (choose or not choose) as a result for any amount we want to have
        //we have no ways so table values will be 0

        for (int i = 0; i <=n ; i++) {
            table[i][0]=1;//reason -1
        }
        for (int i = 1; i <=amount ; i++) {
            table[0][amount]=0;//reason-2
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=amount ; j++) {
                //2 cases if amount at that index which is j >= coins value,then ways are either choose
                // that coin to value or not choose ,add both cases as we want no of ways
                if(coin[i-1]<=j)
                {
                    //now 2 possibilities to count either 1 choose or not
                    table[i][j]=table[i][j-coin[i-1]]+table[i-1][j];//array index start from 0

                }
                else table[i][j]=table[i-1][j];//not include is the only option here
            }
        }

        System.out.println("NO OF WAYS ARE " + table[n][amount]);
        System.out.println("**TABLE**");
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=amount ; j++) {
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
