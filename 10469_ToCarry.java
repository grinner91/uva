import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 29/01/16.
 *
 * 10469 - To Carry or not to Carry
 *
 *
 */
 class Main_10469_ToCarryornottocarry {

    public static  void main(String[] args)
    {

        Scanner sc = new Scanner( new BufferedReader(new InputStreamReader(System.in)));

        while(sc.hasNext())
        {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            System.out.println( (num1 ^ num2) );

        }
    }
}


/*

Sample Input
4 6
6 9


Sample Output
2
15

 */
