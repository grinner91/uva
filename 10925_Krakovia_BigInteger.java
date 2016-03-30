/**
 * Created by mzaman on 3/30/16.
 *
 * 10925 - Krakovia
 *
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1866
 *
 */

import java.math.BigInteger;
import java.util.Scanner;

class Main_10925_Krakovia_BigInteger {

    public  static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1;  sc.hasNextLine(); tc++)
        {
            int numBills, numFriends;

            numBills = sc.nextInt();
            numFriends = sc.nextInt();

            if(numBills == 0 && numFriends == 0) break;

            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < numBills; i++)
            {
                BigInteger bill = sc.nextBigInteger();
                sum = sum.add(bill);
            }
            System.out.println("Bill #" + tc + " costs " + sum + ": each friend should pay " + sum.divide(BigInteger.valueOf(numFriends)));
            System.out.println();
        }
    }
}

/*

Sample Input

3 3
5400000000
5400000000
5400000000
3 2
5400000000
5400000000
9000000001
0 0


Sample Output
Bill #1 costs 16200000000: each friend should pay 5400000000
Bill #2 costs 19800000001: each friend should pay 9900000000

 */
