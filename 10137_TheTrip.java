/**
 * Created by mzaman on 3/24/16.
 *
 * 10137 - The Trip
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1078
 *
 */

import java.util.Scanner;

class Main_10137_TheTrip {


    public void solve()
    {

        Scanner sc = new Scanner(System.in);
        int studentCount;
        long[] expenses;

        while(sc.hasNextLine())
        {
            studentCount = sc.nextInt();

            if(studentCount == 0) break;

            expenses = new long[studentCount];

            long temp, totalExpense = 0, avgExp = 0;
            for(int i = 0; i < studentCount; i++)
            {
                temp = Math.round(  sc.nextFloat() * 100);
                expenses[i] = temp;
                totalExpense += temp;
            }

            avgExp = Math.round((double) totalExpense / studentCount);

            long totalReceived = 0, totalGiven = 0;

            for(int i = 0 ; i < studentCount; i++)
            {
                if(expenses[i] > avgExp)
                     totalGiven += (expenses[i] - avgExp);
                else
                    totalReceived += (avgExp - expenses[i]);
            }

            long exchange = totalReceived < totalGiven ?  totalReceived : totalGiven;

            System.out.printf("$%d.%02d\n", (int) (exchange / 100), (int) (exchange % 100));

        }
    }

    public  static void main(String[] args)
    {
        (new Main_10137_TheTrip()).solve();

    }
}

/*

Sample Input

3
10.00
20.00
30.00
4
15.00
15.01
3.00
3.01
0

Sample Output
$10.00
$11.99
 */
