package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class Largest_Nonoverlap_repeating_substring {
    public static void main(String[] args) {
        //m-1 brute force generating all substrings and checking in it 0(n^3)
        //dp 0(n^2)

        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STRING");
        String s=sc.next();
        int n=s.length();
        int table[][]=new int[n][n];
        //corner case as for i=0 as if matches we donot have i-1,j-1
       //since non overlapping i=0,j=0 should be filled separately
        table[0][0]=0;
        for (int i = 1; i <n ; i++) {
            if(s.charAt(0)==s.charAt(i))table[0][i]=1;
            else table[0][i]=0;
        }

        int max=0;
        //fill row by row and store max value of table rather  traversing again
        int index=0;
        for (int i = 1; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                if (s.charAt(i) == s.charAt(j))
                {
                    table[i][j] = 1 + table[i - 1][j - 1];
                    if(table[i][j]>max) {
                        max=table[i][j];index=i;

                    }

                }


                else
                    table[i][j] = 0;
            }
        }
        //now we cannot print last index table value ...here we have to scan complete array to find max or maintain
        //max variable at the table filling time

        System.out.println("NOW LARGEST NON OVERLAPPING REPEATING SUBSTRING IS " + max);
        int start=index-max+1;
        int end=start +max;
        System.out.println("STRING IS " + s.substring(start,end));
        //if max==1 then print first repeating character
    }
}
/*
if(max==1)
        {
        char k=h.removeFirst();
        while(!h.contains(k)){

        }
        return s.charAt(0)+"";
        }
        else


        Vector<Character> h=new Vector<>();
        for(int i=0;i<s.length();i++)
        {
        h.add(s.charAt(i));
        }*/
