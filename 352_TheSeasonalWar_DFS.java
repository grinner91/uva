/**
 * Created by zaman on 29/02/16.
 *
 * 352 - The Seasonal War
 *
 */

import java.util.Scanner;

class Main_352_TheSeasonalWar_DFS {


    int dim;
    int[][] graph;
    boolean[][] visited;
    int eagleCount;
    int[] dr={-1,-1,-1,0, +1, +1,+1,0};
    int[] dc={-1, 0,+1,+1,+1, 0, -1,-1};

    private  boolean isInBoundary(int r, int c)
    {
        if(r > 0 && r <= dim && c > 0 && c <=dim )
            return  true;

        return  false;
    }

    private  void dfs(int r, int c)
    {
        if(visited[r][c] == true) return;

       int newr, newc;
       visited[r][c] = true;
       for(int i = 0; i < 8; i++)
       {
           newr = r + dr[i];
           newc = c + dc[i];

           if(isInBoundary(newr,newc)
                   && graph[newr][newc] == 1
                   && visited[newr][newc]==false)
               dfs(newr,newc);
       }

    }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);
        String line;
        int testCase = 0;
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            if(null == line || line.isEmpty()) break;

            testCase++;
            dim = Integer.parseInt(line);
            graph = new int[dim+2][dim+2];

           for(int i = 1; i <= dim; i++ )
           {
               char[] eagles = scanner.nextLine().toCharArray();
               for(int j=0; j < dim; j++)
               {
                    if(eagles[j] == '1')
                        graph[i][j+1] = 1;
               }
           }

            eagleCount = 0;
            visited = new boolean[dim+2][dim+2];
            for(int u = 1; u <= dim; u++)
            {
                for(int v=1; v <= dim; v++)
                {
                    if(graph[u][v] == 1 && visited[u][v] == false)
                    {
                        eagleCount++;
                        dfs(u,v);
                    }
                }
            }
            System.out.println("Image number "+testCase+" contains "+eagleCount+" war eagles.");
        }
    }

    public  static void main(String[] args)
    {
        (new Main_352_TheSeasonalWar_DFS()).solve();

    }
}

/*

Sample input

6
100100
001010
000000
110000
111000
010100
8
01100101
01000001
00011000
00000010
11000011
10100010
10000001
01100000



Sample output

Image number 1 contains 3 war eagles.
Image number 2 contains 6 war eagles.


 */
