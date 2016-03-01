/**
 * Created by zaman on 01/03/16.
 *
 * 11854 - Egypt
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2954 *
 *
 */

import java.util.Scanner;

class Main_11854_Egypt {

    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine())
        {
            int num1 = scanner.nextInt(), num2 = scanner.nextInt(), num3 = scanner.nextInt();

            if(num1==0 && num2==0) break;

            boolean isRight = false;

            if(num1*num1 + num2*num2 == num3*num3 ) isRight = true;
            else if(num1*num1 + num3*num3 == num2*num2) isRight = true;
            else if(num2*num2 + num3*num3 == num1*num1) isRight = true;

            if(isRight) System.out.println("right");
            else  System.out.println("wrong");
        }
    }

}


/*

Sample Input
6 8 10
25 52 60
5 12 13
0 0 0


Sample Output
right
wrong
right

 */
