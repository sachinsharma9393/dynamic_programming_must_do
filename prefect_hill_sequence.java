package dp;

import java.util.Arrays;

/**
 * Created by sachin on 7/4/2018.
 */
public class prefect_hill_sequence {
    public static void main(String[] args) {
        //this problem states first k are below peak of hill and next k on other side of peak ,means total elements
        //2k+1 as one is peak.....we have to find longest hill sequence

        //this will use concept of ,Longest Incresing subsequence and longest decreasing subsequence and develop some relation
        //to get longest hill sequence


        int a[]={10,15,16,9,4,4,3,11,1};
        int lis[]=new int[a.length];
        int lds[]=new int[a.length];
        Arrays.fill(lis,1);Arrays.fill(lds,1);

        //first find lis

        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(a[j]<a[i]&& lis[i]<lis[j]+1)
                {
                    lis[i]=lis[j]+1;
                }
            }
        }

        //then lds

        for (int i = a.length-2; i >=0 ; i--) {
            for (int j = a.length-1; j>i ; j--) {
                if(a[i]>a[j]&&lds[i]<lds[j]+1)
                    lds[i]=lds[j]+1;
            }
        }

        int max=0;
        for (int i = 0; i <a.length ; i++) {
            int hill=(Math.min(lis[i],lds[i])-1)*2+1;//means 2*x+1  x is min. number of sequnece form lis,lds + 1 for peak
            if(hill>max)max=hill;
        }
        System.out.println("SO! HILL SEQUENCE IS OF LENGTH is " + max);
    }


}
