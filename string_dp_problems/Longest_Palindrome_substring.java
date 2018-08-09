package dp.string_dp_problems;

import java.util.Scanner;

/**
 * Created by sachin on 7/4/2018.
 */
public class Longest_Palindrome_substring {
    public static void main(String[] args) {
        //brute force generating all possible substring and checking whether it is a palindrome or not
        //which is 0(n^3) solution

        //using dp 0(n^2) time and space
        //centre of odd-even substring concept


        System.out.println("ENTER A STRING ");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        Boolean table[][]= new Boolean[n][n];
        System.out.println(table[3][4]);
        //palindrome questions we have to fill the table diagonally
        //1 length string are palindrome in itself
        for (int i = 0; i <n ; i++) {//1 length palindrome
            table[i][i]=true;
        }
        for (int l=2; l <=n ; l++) {//2 and more length
            for (int i=0, j=i+l-1;j<n; i++,j++) {
               // System.out.println(i+"--"+j);
                if(s.charAt(i)==s.charAt(j)&&l>2)
                {
                    table[i][j]=table[i+1][j-1];//means consider a substring then from right 1 length gets reduced and
                    // from left one length increases for bigger substring checking
                }
               else if(s.charAt(i)==s.charAt(j)&&l==2)
                {
                    table[i][j]=true;//this is corner case as length 2 can cause values below diagonal i.e i>j cases
                }

                else table[i][j]=false;

            }
        }
        //now after filling the table we have to scan to find longest palindrome part where table cell value is true

        int longest=1;//initially consider 1 length is longest
        for(int l=2;l<=n;l++)
        {
            for (int i = 0,j=i+l-1; j<n ; i++,j++) {
                if(table[i][j])
                {
                    longest=l;
                    break  ;
                }
            }
        }
        System.out.println(" LONGEST PALINDROME SUBSTRING IS " + longest);


    }
}
