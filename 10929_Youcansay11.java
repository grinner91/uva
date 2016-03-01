/**
 * Created by zaman on 01/03/16.

 10929 You can say 11

 https://uva.onlinejudge.org/external/109/10929.pdf

 */

import java.math.BigInteger;
import java.util.Scanner;

 class Main_10929_Youcansay11 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        BigInteger eleven = new BigInteger("11");

        while(scanner.hasNextLine())
        {
            input = scanner.nextLine().trim();
            if(input.equals("0")) break;

            BigInteger num = new BigInteger(input);

           if(num.mod(eleven).intValue() == 0)
               System.out.println(input + " is a multiple of 11.");
            else
               System.out.println(input + " is not a multiple of 11.");
        }

    }
}


/*

Sample Input

112233
30800
2937
323455693
5038297
112234

            112233
    00000000030800
   2937
                      323455693
          5038297          
          00000112234
00112
0

Sample Output

112233 is a multiple of 11.
30800 is a multiple of 11.
2937 is a multiple of 11.
323455693 is a multiple of 11.
5038297 is a multiple of 11.
112234 is not a multiple of 11.
112233 is a multiple of 11.
00000000030800 is a multiple of 11.
2937 is a multiple of 11.
323455693 is a multiple of 11.
5038297 is a multiple of 11.
00000112234 is not a multiple of 11.
00112 is not a multiple of 11.

 */
