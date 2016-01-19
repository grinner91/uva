import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 19/01/16.
 *
 * 382 - Perfection
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=318
 *
 */
class Main_382_Perfection {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num,middle,sum;

        System.out.println("PERFECTION OUTPUT");

        while(scanner.hasNext()) {

            num = scanner.nextInt();
            if(num == 0) break;

            middle = num / 2;

            sum = 0;
            for(int n = 1; n <= middle; n++)
            {
                if(num % n == 0)
                {
                    sum+=n;
                }
            }

            if(num == sum ) System.out.format("%5d  PERFECT%n",num);
            else if(num < sum ) System.out.format("%5d  ABUNDANT%n",num);
            else if(num > sum ) System.out.format("%5d  DEFICIENT%n",num);

        }

        System.out.println("END OF OUTPUT");


    }
}

/*


Sample Input

15 28 6 56 60000 22 496 0


Sample Output

PERFECTION OUTPUT
   15  DEFICIENT
   28  PERFECT
    6  PERFECT
   56  ABUNDANT
60000  ABUNDANT
   22  DEFICIENT
  496  PERFECT
END OF OUTPUT


 */
