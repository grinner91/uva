/**
 * Created by mzaman on 3/10/16.
 *
 * 11461 Square Numbers
 *
 */

import java.util.Scanner;

class Main_11461_SquareNumbers {
    final int MAX = 100000 + 5;
    int[] sqrnums;

    private void preCalculateSqureNums()
    {
        sqrnums = new int [MAX];
        sqrnums[0] = 0;
        sqrnums[1] = 1;
        sqrnums[2] = 1;

        double sqrt;

        for(int i = 3; i < MAX; i++)
        {
             sqrt = Math.sqrt(i);
            if(Double.compare(sqrt, Math.floor(sqrt)) == 0)
                sqrnums[i] = sqrnums[i-1] + 1;
            else
                sqrnums[i] = sqrnums[i-1];
        }
    }

    private void solve()
    {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        preCalculateSqureNums();
        while(scanner.hasNextLine())
        {
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            if(num1 == 0 && num2 == 0) break;;

            System.out.println((sqrnums[num2] - sqrnums[num1-1]));
        }
    }

    public static void main(String[] args)
    {
        (new Main_11461_SquareNumbers()).solve();
    }
}


/*

Sample Input
1 4
1 10
0 0

Sample Output
2
3


 */
