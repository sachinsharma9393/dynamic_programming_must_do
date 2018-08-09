package dp;

import java.util.Arrays;

/**
 * Created by sachin on 7/4/2018.
 */
public class Longest_decreasing_subsequence {
    public static void main(String[] args) {
        //m-1 is to reverse the array and find LIS
        //or m-2 start from end then second loop from i+1 to n and find lis this will give LDS


        int a[]={2,10,11,5,3,4,12,1};
        int lds[]=new int[a.length];
        Arrays.fill(lds,1);
        for (int i = a.length-2; i >=0 ; i--) {
            for (int j=a.length-1;j>i;j--)
            {
                //same as lis
                if(a[i]>a[j]&&lds[i]<lds[j]+1)
                    lds[i]=lds[j]+1;
            }
        }
        int max_length=0;
        for (int i = 0; i <lds.length ; i++) {
            if(max_length<lds[i])
                max_length=lds[i];
        }
        System.out.println("LONGEST DECREASING SEQUENCE IS " + max_length);
    }
}
