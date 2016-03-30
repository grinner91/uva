/**
 * Created by mzaman on 3/30/16.
 *
 * 465 Overow
 *
 * https://uva.onlinejudge.org/external/4/465.pdf
 */

import java.math.BigInteger;
import java.util.Scanner;
class Main_465_Overow_BigInteger {

    public  static void main(String[] args)
    {
        final BigInteger MAX = new BigInteger("2147483647");

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine())
        {
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;

            BigInteger num1 = new BigInteger(line.split(" ")[0].trim());
            BigInteger num2 = new BigInteger(line.split(" ")[2].trim());
            String op = line.split(" ")[1].trim();

            System.out.println(line);

            if(num1.compareTo(MAX) == 1)
                System.out.println("first number too big");
            if(num2.compareTo(MAX) == 1)
                System.out.println("second number too big");

            if(op.equals("+"))
                num1 = num1.add(num2);
            else
                num1 = num1.multiply(num2);

            if(num1.compareTo(MAX) == 1)
                System.out.println("result too big");

        }
    }
}


/*


Sample Input

300 + 3
9999999999999999999999 + 11


Sample Output

300 + 3 \\
9999999999999999999999 + 11
first number too big
result too big


 */
