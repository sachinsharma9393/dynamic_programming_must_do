package dp;

import java.util.Arrays;

/**
 * Created by sachin on 7/4/2018.
 */
public class Longest_increasing_subsequence {
    public static void main(String[] args) {
        //m-1 is brute force generating all such subsequences and then find longest among them which is 0(2^n) problem
        //m-2 is dynamic programming which reduces it to 0(n^2)time and 0(n) space

        int a[]={2,3,1,5,12,10,11};
        int lis[]=new int[a.length];
        Arrays.fill(lis,1);//worst case
        for (int i = 1; i <a.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(a[j]<a[i] &&lis[i]<lis[j]+1)//whether we need to add it to current lis
                {
                    //every time lis[i] gets updated and check with lis[j] whether we got even bigger length subsequence
                    lis[i]=lis[j]+1;
                }
            }
        }
        int longest=0;
        //not always last index will be the answer so scan the lis array and find max say last element is 0 case
        for (int i = 0; i <lis.length ; i++) {
            if(lis[i]>longest)
                longest=lis[i];
        }
        System.out.println("LIS IS OF LENGTH "+longest);
        //WE can also find the seqeunece by storing first index of lis array and then loop it from 0 to that index

    }
}
