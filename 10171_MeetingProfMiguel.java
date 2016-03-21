/**
 *
 * Created by mzaman on 3/18/16.
 *
 * 10171 - Meeting Prof. Miguel
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1112
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main_10171_MeetingProfMiguel {

    final int INF = 100000;

    final int MAX = 26;

    int[][] matrixY, matrixM;

    int u, v, w;

    public  void solve()
    {
        Scanner sc = new Scanner(System.in);

        for( int tc = 0; sc.hasNextLine() ; tc++)
        {
            int numLine = sc.nextInt();
            if(numLine == 0 ) break;
            sc.nextLine();

            String line;
            String[] strings;
            matrixY = new int[MAX][MAX];
            matrixM = new int[MAX][MAX];

            for(int i = 0; i < MAX; i++)
                for(int j = 0; j < MAX; j++)
                {
                    if(i == j) matrixM[i][j] = matrixY[i][j] = 0;
                    else matrixM[i][j] = matrixY[i][j] = INF;
                }

            for(int i = 0; i < numLine; i++)
            {
                line = sc.nextLine();
                strings = line.split(" ");
                u = strings[2].charAt(0) - 'A';
                v = strings[3].charAt(0) - 'A';
                w = Integer.parseInt(strings[4]);

                if(strings[0].charAt(0) == 'Y')
                {
                    if(strings[1].charAt(0) == 'B')
                        matrixY[u][v] =  matrixY[v][u] = Math.min(w,matrixY[u][v]);
                    else
                        matrixY[u][v] = Math.min(w,matrixY[u][v]);
                }
                else
                {
                    if(strings[1].charAt(0) == 'B')
                        matrixM[u][v] =  matrixM[v][u] = Math.min(w,matrixM[u][v]);
                    else
                        matrixM[u][v] = Math.min(w,matrixM[u][v]);;
                }
            }

            strings = sc.nextLine().split(" ");

            int srcY = strings[0].charAt(0) - 'A';
            int srcM = strings[1].charAt(0) - 'A';

            //floyd Warshall
            for(int k = 0; k < MAX; k++)
                for(int i = 0; i < MAX; i++)
                    for(int j = 0; j < MAX; j++)
                    {
                        matrixM[i][j] = Math.min(matrixM[i][j], matrixM[i][k] + matrixM[k][j]);
                        matrixY[i][j] = Math.min(matrixY[i][j], matrixY[i][k] + matrixY[k][j]);
                    }

            int minCost = INF, currentCost  = INF;
            for(int k = 0; k < MAX; k++)
            {
                currentCost = matrixY[srcY][k] + matrixM[srcM][k];
                minCost = Math.min(minCost,currentCost);
            }


            if(minCost >= INF)
                System.out.println("You will never meet.");
            else
            {
                System.out.print(minCost);
                ArrayList<Character> path = new ArrayList<Character>();
                int index = 0;
                for(int k = 0; k < MAX; k++)
                {
                    currentCost = matrixY[srcY][k] + matrixM[srcM][k];
                    if(minCost == currentCost)
                    {
                        path.add((char)(k + 'A'));
                    }
                }

                Collections.sort(path);
                for(int i = 0; i < path.size(); i++)
                    System.out.print(" "+path.get(i)+"");
                System.out.println();
            }

        }

    }
    public static void main(String[] args)
    {
        (new Main_10171_MeetingProfMiguel()).solve();
    }
}


/*

SampleInput
4
Y U A B 4
Y U C A 1
M U D B 6
M B C D 2
A D
2
Y U A B 10
M U C D 20
A D
0

SampleOutput
10 B
You will never meet.



 */
