package dp;

/**
 * Created by sachin on 7/9/2018.
 */
public class Max_sum_2xn_rectangle {

    public static void main(String[] args) {
        //we have to find max sum such that no two elements choosen are adjacent i.e neither vertically,diagonally
        //,horizontally
        int a[][]={{1,2,3,4,6},{0,5,2,1,7}};
        //brute it is 2^n problem whether to choose particular element or not

        //dp 0(n)time and space and sub problems are repeating
        int n=a[0].length;
        int dp[]=new int[n];
        //taking base
        //1 choosing elements from first index of array
        dp[0]=Math.max(a[0][0],a[1][0]);
        //2 choosing from second by leaving first
        dp[1]=Math.max(a[0][1],a[1][1]);
        for (int i = 2; i <n ; i++) {
            //now we have 2 choices
            //take index i then leave i-1 index and add to dp[i-2]sum
            //or leave index i then sum we have to take is till dp[i-1]

            int current_index_sum=dp[i-2]+Math.max(a[0][i],a[1][i]);
            int prev_index_sum=dp[i-1];
            dp[i]=Math.max(current_index_sum,prev_index_sum);
         //   System.out.println(dp[i]);
        }
        System.out.println("MAX SUM WE COULD GET IS " + dp[n - 1]);


    }
}
