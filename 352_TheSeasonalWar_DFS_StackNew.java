/**
 * Created by zaman on 29/02/16.
 *
 * 352 - The Seasonal War
 *
 */

import java.util.Scanner;

class Main_352_TheSeasonalWar_DFS_StackNew {

class StackNew
{
    final int MAXS = 100000;
    int[] stk;
    int index;

    public StackNew()
    {
        stk = new int[MAXS];
        index = 1;
    }

    public void push(int r, int c)
    {
        stk[index++] = r * 100 + c;
    }

    public  int pop()
    {
        if(isEmpty()) return  -1;

        return stk[--index];
    }

    public boolean isEmpty()
    {
        if(index <= 0 )
            return  true;

        return false;
    }
}
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

       int newr, newc, u, v, node;
       visited[r][c] = true;
        StackNew stk = new StackNew();
        stk.push(r,c);

        while(!stk.isEmpty()) {

            node = stk.pop();
            u = node / 100;
            v = node % 100;

            for (int i = 0; i < 8; i++) {
                newr = u + dr[i];
                newc = v + dc[i];

                if (isInBoundary(newr, newc)
                        && graph[newr][newc] == 1
                        && visited[newr][newc] == false)
                {
                    visited[newr][newc] = true;
                    stk.push(newr,newc);
                }
            }
        }

    }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);
        String line;
        int testCase = 10;
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
        (new Main_352_TheSeasonalWar_DFS_StackNew()).solve();
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
