import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zaman on 18/01/16.
 *
 * 10041 - Vito's Family
 *
 *
 */
class Main_10041_VitosFamily {

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCase = scanner.nextInt();



        for(int tc = 0; tc < testCase; tc++)
        {
            scanner.nextLine();
            int relatives = scanner.nextInt();
            int[] streets = new int[relatives];

            for(int r = 0; r < relatives; r++)
            {
                streets[r] = scanner.nextInt();
            }

            Arrays.sort(streets);

            long sum = 0;
            int median = streets[relatives/2];
            for(int i = 0; i < relatives; i++)
            {
                   sum += Math.abs(median - streets[i]);
            }

            System.out.println(sum);

        }

    }

}


/*


INPUT

9
2 2 4
3 2 4 6
6 11 2 1 6 5 11
6 7 8 2 3 6 1
6 1 1 1 1 1000 1000
4 1 2 4 5
10 30 25 15 1 1 1 23 23 90 10
5 1 1 1 2 3
16 5 49 12 23 29 100 44 47 69 41 23 12 11 6 2 62


OUTPUT

2
4
20
15
1998
6
163
3
347



 */
