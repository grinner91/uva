/**
 * Created by zaman on 25/02/16.
 *
 * 10106 - Product
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1047
 *
 */

import java.math.BigInteger;
import java.util.Scanner;

 class Main_10106_Product {

    public  void solve()
    {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext())
        {
            BigInteger num1 = scanner.nextBigInteger();
            BigInteger num2 = scanner.nextBigInteger();

            System.out.println(num1.multiply(num2));
        }
    }

    public  static void main(String[] args)
    {
        new Main_10106_Product().solve();

    }
}
