/**
 * Created by zaman on 29/02/16.
 *
 * 352 - The Seasonal War
 *
 */

import java.util.Scanner;

class Main_352_TheSeasonalWar_BFS {

    class QueueNew{
        final  int MAXQ = 100000;
        int[] qu;
        int front,tail,temp;

        public QueueNew()
        {
            qu = new int[MAXQ];
            front = tail = 0;
        }
        public void add(int r, int c)
        {
            qu[tail++] = r * 100 +c;
        }
        public  int front()
        {
            if(isEmpty()) return  -1;

            temp = qu[front++];

            return  temp;
        }

        public  boolean isEmpty()
        {
            if(front >= tail) return true;
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

    private  void bfsTraverse(int r, int c)
    {
        int u,v,node, newr,newc;
        QueueNew qu = new QueueNew();
        qu.add(r,c);
        visited[r][c] = true;

        while(!qu.isEmpty())
        {
            node= qu.front();
            u = node / 100;
            v = node % 100;

            for(int i = 0; i < 8; i++)
            {
                newr = u + dr[i];
                newc = v + dc[i];

                if(isInBoundary(newr,newc) && graph[newr][newc] == 1 && visited[newr][newc] == false)
                {
                    qu.add(newr,newc);
                    visited[newr][newc] = true;
                }
            }
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
                        bfsTraverse(u,v);
                    }
                }
            }
            System.out.println("Image number "+testCase+" contains "+eagleCount+" war eagles.");
        }
    }

    public  static void main(String[] args)
    {
        (new Main_352_TheSeasonalWar_BFS()).solve();

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
