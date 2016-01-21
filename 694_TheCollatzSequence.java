import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 21/01/16.
 *
 * 694 - The Collatz Sequence
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=25&page=submit_problem&category=&mosmsg=Submission+received+with+ID+16735285
 *
 */
 class Main_694_TheCollatzSequence {

    public  static void main(String[] args)
    {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = 0;

        while(true)
        {

            long A = sc.nextLong();
            long Limit = sc.nextLong();

            if(A < 0 && Limit < 0) break;

            testCase++;
            int seq = 0;
            long B = A;

            while(true)
            {
                seq++;

                if(A == 1 || A > Limit) break;

                if(A%2 == 0 )
                {
                    A = A/2;
                }
                else
                {
                    if( 3*A + 1 > Limit) break;

                    A = 3*A  + 1;
                }
            }

            System.out.format("Case %d: A = %d, limit = %d, number of terms = %d%n",testCase,B,Limit,seq);

        }
    }
}

/*


Sample Input

 3 100
 34 100
 75 250
 27 2147483647
 101 304
 101 303
 -1 -1
Sample Output

 Case 1: A = 3, limit = 100, number of terms = 8
 Case 2: A = 34, limit = 100, number of terms = 14
 Case 3: A = 75, limit = 250, number of terms = 3
 Case 4: A = 27, limit = 2147483647, number of terms = 112
 Case 5: A = 101, limit = 304, number of terms = 26
 Case 6: A = 101, limit = 303, number of terms = 1


 */
