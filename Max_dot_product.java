package dp;

/**
 * Created by sachin on 7/27/2018.
 */
//import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
class Max_dot_product
{
    public static void main (String[] args)
    {
        //code
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        long ta[]=new long [t];
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            long a[]=new long[n];
            long b[]=new long[m];
            for(int j=0;j<n;j++)
            {
                a[j]=sc.nextLong();
            }
            for(int j=0;j<m;j++)
            {
                b[j]=sc.nextLong();
            }
            long table[][]=new long[m+1][n+1];
            for(int j=1;j<=m;j++)
            {
                for(int k=j;k<=n;k++)
                {
                    table[j][k]=Math.max(table[j-1][k-1]+a[k-1]*b[j-1],table[j][k-1]);
                }
            }
            ta[i]=table[m][n];
        }

        for(int i=0;i<t;i++)
        {
            System.out.println(ta[i]);
        }


    }
}