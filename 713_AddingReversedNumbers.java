import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by zaman on 08/02/16. *
 *
 * 713 Adding Reversed Numbers
 *
 * https://uva.onlinejudge.org/external/7/713.pdf
 *
 */
class Main_713_AddingReversedNumbers {


    public  static  void main(String[] args)
    {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        while(testCases-- > 0)
        {
            BigInteger num1 = scanner.nextBigInteger();
            BigInteger num2 = scanner.nextBigInteger();

            StringBuilder builder = new StringBuilder(num1.toString());
            num1 = new BigInteger(builder.reverse().toString());

            builder = new StringBuilder(num2.toString());
            num2 = new BigInteger(builder.reverse().toString());

            BigInteger sum = num1.add(num2);
            builder  = new StringBuilder(sum.toString());

            sum = new BigInteger(builder.reverse().toString());

            System.out.println(sum);

        }

    }
}

/*


Sample Input
3
24 1
4358 754
305 794


Sample Output
34
1998
1


 */
