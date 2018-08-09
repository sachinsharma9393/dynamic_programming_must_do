package dp.string_dp_problems;

/**
 * Created by sachin on 7/4/2018.
 */
public class Edit_Distance_Problem {

    public static void main(String[] args) {
        //make one string to another with minimum number of delete,insert,replace
        String main="SACHIN";
        String target="TDCHIS";
        //m-1 brute force will find all possible combination ,there are 3 options if it do not match,hence 0(3^n)
        //m-2 dp

        int table[][]=new int[main.length()+1][target.length()+1];
        //deal corner case
        //first if main size=0 means null string then complete insertion needs to be performed to reach target string

        for (int i = 0; i <target.length()+1 ; i++) {
            table[0][i]=i;

        }
        //if target string size=0,then complete deletion needs to be performed
        for (int i = 0; i <main.length()+1 ; i++) {
            table[i][0]=i;
        }

        for (int i = 1; i <=main.length() ; i++) {
            for (int j = 1; j <=target.length() ; j++) {
                    //case 1 matches character
                    if(main.charAt(i-1)==target.charAt(j-1))
                    {
                        table[i][j]=table[i-1][j-1];
                    }
                //now 3 possibilities of insert,delete,replace
                    else
                    {
                        //i is main string j is target string
                        //insert means table[i][j-1] since we inserted one size of target got matched and its problem size reduced
                        //delete means table[i-1][j] 1 characterv is removed from main hence its problem size reduced
                        //replace means table[i-1][j-1] both problem size reduce by 1
                        table[i][j]=1+Math.min(table[i-1][j],Math.min(table[i][j-1],table[i-1][j-1]));

                    }

            }

        }
        System.out.println("TOTAL EDIT DISTANCE IS " + table[main.length()][target.length()]);//3replaces ;)
        //target =this then 4 2 delte,2 replace
        //target=

    }



}
