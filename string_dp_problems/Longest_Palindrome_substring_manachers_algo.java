package dp.string_dp_problems;

/**
 * Created by sachin on 7/8/2018.
 */
public class Longest_Palindrome_substring_manachers_algo {
    public static void main(String[] args) {
        //first doing with centre of palindrome appraoch
        String s="emadamz";
        int max=1;
        int start=0;
        for(int i=1;i<s.length();i++)
        {
            int n=s.length();
            //first even
            int low=i-1;
            int high=i;
            while(low>=0&&high<n &&s.charAt(low)==s.charAt(high))
            {
                if((high-low )>max)
                {
                    max=high-low+1;
                    start=low;

                }

                low--;high++;
            }
            low=i-1;
            high=i+1;
            while(low>=0&&high<n &&s.charAt(low)==s.charAt(high))
            {
                if((high-low )>max)
                {
                    max=high-low+1;
                    start=low;

                }

                low--;high++;
            }
        }
       // System.out.println(max+"----index start"+start);
        if(max==0) s.charAt(0);
       else System.out.println(s.substring(start, start + max ));
       // System.out.println(s.charAt(0));
        System.out.println(s.substring(0,0));
    }
}
