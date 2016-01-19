import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 19/01/16.
 *
 * 11547 - Automatic Answer
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2542
 *
 *
 * “Multiply n by 567, then divide the result by 9, then add 7492, then multiply by 235, then divide
 by 47, then subtract 498. What is the digit in the tens column?”
 *
 */
 class Main_11547_AutomaticAnswer {

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCase = scanner.nextInt();
        long num;

        while(testCase-- > 0)
        {
            num = scanner.nextInt();

            num = (((((num * 567) / 9) + 7492) * 235) / 47) - 498;

            num = (num % 100) / 10;

            num = num < 0 ? num * -1 : num;

            System.out.println(num);

        }
    }
}


/*

Sample Input
2
637
-120

Sample Output
1
3

 */
