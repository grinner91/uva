import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 21/01/16.
 *
 * 10050 - Hartals
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=991
 *
 */
 class Main_10050_Hartals {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = sc.nextInt();

        while(testCases-- > 0)
        {
            int days = sc.nextInt();
            int parties = sc.nextInt();
            int[] hartals = new int[parties+1];

            for(int i=0; i < parties; i++)
            {
                hartals[i] = sc.nextInt();
            }

            int lostDays = 0;
            boolean hartalday = false;

            for(int d = 1; d <= days; d++)
            {
                if((d % 7 == 0) || ( d % 7 == 6)) continue;

                hartalday = false;
                for(int p=0; p < parties; p++)
                {
                    if((d % hartals[p]) == 0) {
                        hartalday = true;
                        break;
                    }
                }
                if(hartalday) lostDays++;
            }

            System.out.println(lostDays);
        }

    }
}

/*


Sample Input
2
14
3
3
4
8
100
4
12
15
25
40
Sample Output
5
15

 */
