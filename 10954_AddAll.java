
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zaman on 29/01/16.
 *
 * 10954 - Add All
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1895
 *
 */
 class Main_10954_AddAll {


    public static void main(String[] args)
    {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int count, n1, n2;
        int cost, sum;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        while(true)
        {
            count = sc.nextInt();
            if(count == 0) break;

            priorityQueue.clear();

            for(int i = 0; i < count; i++)
            {
                priorityQueue.offer(sc.nextInt());
            }

            cost = sum = n1 = n2 = 0;

            while(priorityQueue.size()>1)
            {
                //get two smaller numbers and add them
                n1 = priorityQueue.poll();
                n2 = priorityQueue.poll();

                sum = n1 + n2;

                cost = cost + sum;

                //sum may be greater than next number, so it is added pq again
                priorityQueue.offer(sum);
            }

            System.out.println(cost);

        }
    }
}


/*


Sample Input

3
1 2 3
4
1 2 3 4
0

Sample Output
9
19

 */
