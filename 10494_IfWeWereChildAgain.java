/**
 * Created by mzaman on 3/30/16.
 *
 * 10494 If We Were a Child Again
 *
 */

import java.math.BigInteger;
import java.util.Scanner;
class Main_10494_IfWeWereChildAgain {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String op;
        BigInteger num1, num2;

        while(sc.hasNext())
        {

            num1 = sc.nextBigInteger();
            op =  sc.next();
            num2 = sc.nextBigInteger();

            if(op.equals("/"))
                num1 = num1.divide(num2);
            else
                num1 = num1.mod(num2);

            System.out.println(num1);
        }
    }
}


/*

Sample Input

110 / 100
99 % 10
2147483647 / 2147483647
2147483646 % 2147483647


Sample Output
1
9
1
2147483646


 */
