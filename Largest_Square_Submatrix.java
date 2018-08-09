package dp;

/**
 * Created by sachin on 6/25/2018.
 */
public class Largest_Square_Submatrix {
    public static void main(String[] args) {
        int a[][]={{1,1,1,1,1},{0,1,1,1,1},{1,1,1,1,1},{0,1,1,0,1},{0,0,1,1,1}};
       // System.out.println(a.length);
        int output[][]=new int[5][5];
        //brute force approach is to try all possible submatrices(n^3)* checking value of all whether 1 or not (n)=0(n^4)
        //solving with dp in 0(n^2) and if change in that question then 0(1)space  otherwise 0(n^2)space

        //first copy the first row and first column in the output array


      /*  for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }*/


        for (int i = 0; i <5 ; i++) {
            output[i][0]=a[i][0];
            output[0][i]=a[0][i];
        }
        for (int i = 1; i <5 ; i++) {
            for (int j = 1; j <5 ; j++) {

                if(a[i][j]==0)output[i][j]=0;
                else
                output[i][j]=min(output[i-1][j-1],output[i-1][j],output[i][j-1])+1;
            }
        }
        //after filling table we have to find max value in the table that will tell as the max possible sub matrics
        System.out.println("matrix filled is like this");
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
        int max=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a.length ; j++) {
                    if(output[i][j]>max)
                        max=output[i][j];
            }
        }
        System.out.println("max subarray is of "+max);
    }

    private static int min(int a, int b, int c) {

        if(a<b)
        {
            if(a<c)
                return a;
            else return c;
        }
        else
        {
            if(b<c)return b;
            else return c;

        }

    }
}
