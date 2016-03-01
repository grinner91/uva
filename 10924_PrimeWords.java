/**
 * Created by zaman on 01/03/16.
 *
 * 10924 - Prime Words
 *
 */

import java.util.Scanner;

 class Main_10924_PrimeWords {


    public  static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        String input;

        while(scanner.hasNextLine())
        {
            input = scanner.nextLine().trim();

            int len = input.length(), sum=0;
            char letter;
            for(int i = 0; i < len; i++)
            {
                letter = input.charAt(i);
                if(letter>= 'a' && letter <= 'z')
                    sum+= (letter - 'a') + 1;
                else
                    sum+= (letter - 'A') + 27;
            }

            int root = (int)Math.sqrt(sum);
            boolean isPrim = true;
            for(int i=2; i <= root; i++)
            {
                if(sum % i == 0) {
                    isPrim = false;
                    break;
                }
            }

            if(isPrim)
                System.out.println("It is a prime word.");
            else
                System.out.println("It is not a prime word.");

        }
    }
}

/*

Sample Input

UFRN
contest
AcM

Sample Output

It is a prime word.
It is not a prime word.
It is not a prime word.


 */
