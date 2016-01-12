import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 12/01/16.
 *
 * 488 - Triangle Wave
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=429
 *
 *
 */

class Main_488_TriangleWave {

    private static void createWave(StringBuilder waveBuilder, int amplitude, int freq)
    {

        for(int f = 0; f < freq; f++) {

            if(f > 0) waveBuilder.append("\n");

            for (int wave = 1; wave <= amplitude; wave++) {

                for (int count = 0; count < wave; count++)
                    waveBuilder.append(wave);

                waveBuilder.append("\n");
            }

            for (int wave = amplitude - 1; wave > 0; wave--) {

                for (int count = 0; count < wave; count++)
                    waveBuilder.append(wave);

                 waveBuilder.append("\n");
            }
        }

    }

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(new BufferedReader( new InputStreamReader(System.in)));

        int testCase = scan.nextInt();

        scan.nextLine();

        while(testCase-- > 0)
        {
            int amplitude = scan.nextInt(), freq = scan.nextInt();
            StringBuilder waveBuilder = new StringBuilder();

            createWave(waveBuilder,amplitude,freq);

            if(testCase > 0 ) waveBuilder.append("\n");

            System.out.print(waveBuilder.toString());

        }

    }

}


/*

Sample Input

1

3
2

Sample Output

1
22
333
22
1

1
22
333
22
1


 */
