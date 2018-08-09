package dp;

/**
 * Created by sachin on 7/27/2018.
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;
class Min_jump_dp
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        int ta[]=new int [t];
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();

            int a[]=new int[n];

            for(int j=0;j<n;j++)
            {
                a[j]=sc.nextInt();
            }

            int dp[]=new int[n];
            dp[0]=0;
            for(int j=1;j<n;j++)
            {
                dp[j]=Integer.MAX_VALUE;
                for(int k=0;k<j;k++)
                {
                    if(k+a[k]>=j)
                    {
                        dp[j]=Math.min(dp[k]+1,dp[j]);
                    }
                }
            }
            if(dp[n-1]==Integer.MAX_VALUE ||dp[n-1]<0)ta[i]=-1;
            else ta[i]=dp[n-1];
        }

        for(int i=0;i<t;i++)
        {
            System.out.println(ta[i]);
        }
    }
}

/*
* 0(n) solution steps and ladder concept
*
* int findMinJump(int arr[],int n)
{
    if(arr[0]==0)return -1;
    if(n<=1)return 0;
    int ladder=arr[0];
    int stair=arr[0];
    int jump=1;
    for(int level=1;level<n;level++)
    {
        if(level==n-1)return stair==0?-1:jump;
        if(ladder<level+arr[level])
        ladder=level+arr[level];
        stair--;
        if(stair==0)
        {
            jump++;
            stair=ladder-level;
        }
    }
    return jump;
}
*
* */