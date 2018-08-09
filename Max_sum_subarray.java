package dp;

/**
 * Created by sachin on 6/24/2018.
 */
public class Max_sum_subarray {
    public static void main(String[] args) {
        int a[]={10,-5,-3,4,12,-8,-12,19};
      //  int a[]={-3,10,5,-20,4,11,-5,7};
        //method-1 finding all subrarrays 0(n^2)* summing and check 0(n)=0(n^3 )problem
        //method-2 is actually reducing check part of above method by maintaing cummulative sum 0(n^2)
        //dynamic programming 0(n)

        int max_sum=0,current=0,sum=0,index=0;//this index i to index will give us subarray having max sum

        for (int i = 0; i <a.length ; i++) {
           sum+=a[i];
            if(sum<0)sum=0;
            else {
                if(sum>max_sum)
                {
                    max_sum=sum;
                    index=i;
                }
            }
        }
        System.out.println(sum);
    }
}
