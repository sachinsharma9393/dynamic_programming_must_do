package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class All_Palindrome_substring {
    public static void main(String[] args) {
        //brute force finding all possible sub string and palindrome evaluation 0(n^3)
        //dp 0(n^2)


        //for this problem first we have to build palindrome table ,,then using that table
        //we have to count accordingly

        //first build table of palindrome or not
        System.out.println("ENTER A STRING ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        Boolean table[][] = new Boolean[n][n];
        //similar to longest common palindrome fill the table
//1 length are all palindrome
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        //for l>=2
        for (int l = 2; l <= n; l++) {
            for (int i = 0, j = i + l - 1; j < n; i++, j++) {
                if (s.charAt(i) == s.charAt(j) && l == 2) {
                    table[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                }
                else table[i][j]=false;
            }
        }
        //now we build the counting table using this tables value i.e true or false,we will use count recurrence

        int count[][] = new int[n][n];
        //similarly here also we fill length 1
        for(int i=0;i<n;i++)
        {
            count[i][i]=1;
        }
        for (int l = 2; l <=n ; l++) {
            for (int i = 0,j=i+l-1; j <n ; i++,j++) {
                if(table[i][j] &&l==2)
                {
                    count[i][j]=3;//because ex a,a,aa equal strings

                }
                else if(table[i][j])
                {
                    count[i][j]=1+count[i+1][j]+count[i][j-1]-count[i+1][j-1];
                }
                else {
                    count[i][j]=count[i+1][j]+count[i][j-1]-count[i+1][j-1];
                }
            }
        }
        System.out.println("TOTAL NUMBER OF PALINDROME SUBSTRING OF LENGTH 1 AND GREATER  ARE " + count[0][n-1]);

        //case -2 of length >=2
        for(int i=0;i<n;i++)
        {
            count[i][i]=0;
        }
        for (int i = 0; i <n-1 ; i++) {
            int j=i+1;
            if(s.charAt(i)==s.charAt(j))
            count[i][j]=1;
            else count[i][j]=0;
        }
        //now same concept of filling table,here it will start from 3

        for (int l = 3; l <=n ; l++) {
            for (int i = 0,j=i+l-1; j <n ; i++,j++) {


                 if(table[i][j])
                {
                    count[i][j]=1+count[i+1][j]+count[i][j-1]-count[i+1][j-1];
                }
                else {
                    count[i][j]=count[i+1][j]+count[i][j-1]-count[i+1][j-1];
                }
            }
        }
        System.out.println("TOTAL NUMBER OF PALINDROME SUBSTRING OF LENGTH 2 AND GREATER  ARE " + count[0][n-1]);
    }
}


