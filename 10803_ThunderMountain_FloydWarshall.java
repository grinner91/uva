/**
 * Created by mzaman on 3/21/16.
 *
 * 10803 - Thunder Mountain
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1744
 *
 */


import java.util.Scanner;

class Main_10803_ThunderMountain_FloydWarshall {

    double[] x;
    double[] y;
    double[][] matrix;
    int numPoint;

    public void solve()
    {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for(int tc = 1; tc <= testCases; tc++)
        {
            numPoint = sc.nextInt();

            x = new double[numPoint];
            y = new double[numPoint];

            for(int i = 0; i < numPoint; i++)
            {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }

            //init
            matrix = new double[numPoint][numPoint];
            for(int i = 0; i < numPoint; i++)
                for(int j = 0; j < numPoint; j++)
                {
                    if(i == j) matrix[i][j] = 0;
                    else matrix[i][j] = matrix[j][i] = Double.MAX_VALUE;
                }

            //euclidean distance
            double dist =0;
            for(int i = 0; i < numPoint; i++)
                for(int j =0 ; j < numPoint; j++)
                {
                    if(i == j) continue;

                    dist = Math.sqrt( Math.pow(Math.abs(x[j] - x[i]),2) + Math.pow(Math.abs(y[j] - y[i]),2) );
                    if(dist <= 10.0)  matrix[i][j] = matrix[j][i]= dist;
                }
            //floyd warshall
            for(int k = 0; k < numPoint; k++)
                for(int i = 0; i < numPoint; i++)
                    for(int j = 0; j < numPoint; j++)
                    {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }

            double maxDist = 0;
            for(int i = 0; i < numPoint; i++)
                for(int j = 0; j < numPoint; j++)
                {
                    maxDist = Math.max(maxDist,matrix[i][j]);
                }



            System.out.println("Case #" + tc + ":");
            if(Double.compare(maxDist, Double.MAX_VALUE) == 0)
                System.out.println("Send Kurdy");
            else
                System.out.printf("%.4f%n",maxDist);

            //if(tc > 0 )
                System.out.println();

        }
    }
    public  static void main(String[] args)
    {
        (new Main_10803_ThunderMountain_FloydWarshall()).solve();
    }
}


/*

SampleInput
2
5
0 0
10 0
10 10
13 10
13 14
2
0 0
10 1

SampleOutput
Case #1:
25.0000

Case #2:
Send Kurdy

 */
