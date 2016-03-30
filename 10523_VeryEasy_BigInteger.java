/**
 * Created by mzaman on 3/30/16.
 *
 * 10523 Very Easy
 *
 * https://uva.onlinejudge.org/external/105/10523.pdf
 *
 */

import java.math.BigInteger;
import java.util.Scanner;

class Main_10523_VeryEasy_BigInteger {

    public  static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt())
        {
            int N = sc.nextInt();
            int a = sc.nextInt();

            BigInteger A = BigInteger.valueOf(a);
            BigInteger sum = new BigInteger("0");

            for(int i = 1; i <= N; i++)
            {
                sum =  sum.add(A.pow(i).multiply(BigInteger.valueOf(i)));
            }

            System.out.println(sum);
        }
    }
}

/*


Sample Input
3 3
4 4

Sample Output
102
1252


 */
