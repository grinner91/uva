/**
 * Created by mzaman on 3/30/16.
 *
 * 10551 - Basic Remains
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1492
 *
 */
import java.math.BigInteger;
import java.util.Scanner;

class Main_10551_BasicRemains {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            int base = sc.nextInt();
            if(base == 0) break;

            BigInteger p = new BigInteger(sc.next(),base);
            BigInteger m = new BigInteger(sc.next(),base);

            System.out.println(p.mod(m).toString(base));
        }
    }
}

/*



Sample Input

2 1100 101
10 123456789123456789123456789 1000
0


Sample Output
10
789

 */
