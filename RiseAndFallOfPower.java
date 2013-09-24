package rise.and.fall.of.power;
import java.util.*;
import java.lang.*;

/**
 * This problem is from the following URL:
 *  http://www.codechef.com/problems/A4
 * 
 * I deviated from the prompt and constructed a more user friendly
 * interface, asking for input, and displaying errors as needed.
 * 
 * @author Alex Persinger
 * @date September 24, 2013
 * @version 1.0
 */
public class RiseAndFallOfPower
{
    public static void main(String[] args)
    {
        /*
         * Need 3 variables:
         *  Test case variable
         *  n - the number to be calculated
         *  k - the maximum number of digits to be reported back
         *      ie: if the number n is 9 digits long, and k is 
         *      equal to 3, then the output will be of the first
         *      3 numbers and the last 3 numbers of n
         */
        
        int testCases;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter the number of test cases: ");
        testCases = Integer.parseInt(scanner.nextLine());
        System.out.println("");
        for(int i = 0; i < testCases; i++)
        {
            System.out.println("Test case: " + (i + 1));
            riseAndFallCalc(scanner);
        }
    }
    /*
     * Processes user input
     * 
     * @param scanner - the user input
     */
    public static void riseAndFallCalc(Scanner scanner)
    {
        String line;
        int n;
        int k;
        
        System.out.print("Please enter the number to be calculated followed"
                + " by a space, \nfollowed by the number of digits to be "
                + "displayed: ");
        line = String.valueOf(scanner.nextLine());
        n = nParser(line, 0);
        k = nParser(line, 1);
        
        if(n <= 1)
        {
            System.out.println("n must be greater than 1.");
            System.exit(0);
        }
        if(n > 10)
        {
            System.out.println("n must be less than 11.");
            System.exit(0);
        }
        if(k <= 1)
        {
            System.out.println("k must be greater than 1.");
            System.exit(0);
        }
        if(k > 9)
        {
            System.out.println("k must be less than 10.");
            System.exit(0);
        }
        
        //Perform the calcuation...
        toPower(n, k);
    }
    /*
     * Parses the user input
     * 
     * @param line - user input
     * @param num - either 0 or 1, it differentiates between n and k
     * 
     * @return int - either n or k, depends on the the method call
     */
    public static int nParser(String line, int num)
    {
        StringTokenizer st;
        String[] tempArray = new String[2];     
        
        st = new StringTokenizer(line);
        int i = 0;
        int r = 0;
        
        while (st.hasMoreTokens())
        {
            tempArray[i] = st.nextToken();
            i++;
        }
        
        if(num == 0)
        {
            r = Integer.parseInt(tempArray[0]);
        }
        else if(num == 1)
        {
            r = Integer.parseInt(tempArray[1]);
        }
        return r;
    }
    
    /*
     * Performs the power calculation of the user input digit
     * 
     * @param n - the integer to be powered
     * @param k - the number of digits to be displayed
     */
    public static void toPower(int n, int k)
    {
        double total;
        
        total = Math.pow(n, n);
        
        result((int)total, k);
    }
    
    /*
     * Displays the calculation
     * 
     * @param n - the calculated user input
     * @param k - number of digits to display
     */
    public static void result(int n, int k)
    {
        String nString = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
          
        if(k >= nString.length())
        {
            sb.append(nString);
            sb.append(" ");
            sb.append(nString);
        }
        else if(k < nString.length())
        {
            sb.append(nString.substring(0, k));
            sb.append(" ");
            sb.append(nString.substring(
                (nString.length() - k), nString.length()));
        }
        System.out.println(sb.toString());
    }
}
