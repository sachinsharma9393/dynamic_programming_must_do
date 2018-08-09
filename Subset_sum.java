package dp;

/**
 * Created by sachin on 6/26/2018.
 */
public class Subset_sum {
    public static void main(String[] args) {
        int a[]={6,3,2,1};
       // int a[]={3, 34, 4, 12, 5, 2};
        int sum=10;
        //int sum=9;


        // brute force 2^n
        //dp 0(length of array * sum)

        int n=a.length;
        boolean table[][]= new boolean[n + 1][sum + 1];

        //base condition filling in table
        //say sum=0
        for (int i = 0; i <=n ; i++) {
            table[i][0]=true;//can form sum by not taking that element as option
        }

        //when element is null set i.e {}

        for (int i = 1; i <=sum ; i++) {
            table[0][i]=false;//cannot form sum >0 with null element
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sum ; j++) {

                if(a[i-1]<=j)//means subset can be formed and array index starts from 0
                {
                    table[i][j]=table[i-1][j-a[i-1]]|| table[i-1][j];


                }
                else {
                    table[i][j]=table[i-1][j];
                }

            }

        }
        Boolean b=table[n][sum];
        if(b) System.out.println("found subset ");
        else System.out.println("no such subsets");

    }
}
