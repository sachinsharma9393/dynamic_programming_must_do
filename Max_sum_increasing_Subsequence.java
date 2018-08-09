package dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sachin on 6/24/2018.
 */
public class Max_sum_increasing_Subsequence {
    public static void main(String[] args) {
        int a[]={20,3,1,15,16,2,12,13};
        int max=0;
        //maintain sum array as for evry value we have its respective sum formation
        int sum[]=new int[a.length];//this will store all increasing sequences sum ending till that point
        for (int i = 0; i <a.length ; i++) {
            sum[i]=a[i];
        }
        //int sum[]=Arrays.copyOf(a,a.length);
        for (int i = 0; i <a.length ; i++) {

            for (int j = 0; j <i ; j++) {
                {

                    if(a[i]>a[j])
                    {
                        int temp=sum[j]+a[i];
                        if(sum[i]<temp)//checking if after adding increasing element whether we got even greater sum then what we have
                            sum[i]=temp;
                    }
                }
            }
        }
        //now after getting sum array ...finding max in it that will be max sum increasing
        for(int k=0;k<a.length;k++)
        {
            if(max<sum[k])
                max=sum[k];
        }
        System.out.println(max);

    }
}
