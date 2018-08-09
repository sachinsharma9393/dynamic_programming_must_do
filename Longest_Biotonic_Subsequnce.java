package dp;

import java.util.Arrays;

/**
 * Created by sachin on 7/15/2018.
 */

import java.util.*;
        import java.lang.*;
        import java.io.*;
class Longest_Biotonic_Subsequnce
{
    public static void main (String[] args)
    {
        //code
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int ta[]=new int[t];
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int j=0;j<n;j++)
            {
                a[j]=sc.nextInt();
            }
            ta[i]=biot(a,n);
        }

        for(int i=0;i<t;i++)
        {
            System.out.println(ta[i]);
        }
    }
    static int biot(int a[],int n)
    {
        int lis[]=new int[n];
        Arrays.fill(lis,1);
        int max=0;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[i]>a[j]&&lis[i]<lis[j]+1)
                {
                    lis[i]=lis[j]+1;
                }
            }

        }

        int lds[]=new int[n];
        Arrays.fill(lds,1);
        for(int i=n-2;i>=0;i--)
        {
            for (int j=n-1;j>i;j--)
            {
                if(a[i]>a[j]&&lds[i]<lds[j]+1)
                {
                    lds[i]=lds[j]+1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(max<lis[i]+lds[i]-1)
                max=lis[i]+lds[i]-1;
        }
        return max;
    }
}