/**
 * Created by mzaman on 3/9/16.
 *
 * 11396 - Claw Decomposition
 *
 */

import java.util.Scanner;

class Main_11396_ClawDecomposition {
    final int MAX = 305;
    final int INF = -1;
    int vertexNum, u,v;
    int[][] matrix;
   // boolean[] visited;
    int[] color;
    boolean isDecomposable;

    class QueueNew
    {
        int[] que;
        int front, tail;

        public QueueNew()
        {
            que = new int [MAX*MAX];
            front = tail = 0;
        }

        public void push(int node)
        {
            que[tail++] = node;
        }

        public int front()
        {
            if(isEmpty()) return  -1;

            return  que[front++];
        }

        public  boolean isEmpty()
        {
            if(front >= tail) return true;

            return false;
        }
    }

    private  void bfsTraverse()
    {
        for(int i = 0; i <= vertexNum; i++)
            color[i] = INF;

        QueueNew que = new QueueNew();
        isDecomposable = true;
        que.push(1);
        color[1] = 1;

        while(!que.isEmpty() && isDecomposable)
        {
            u = que.front();
            for(int i = 1; i <= vertexNum; i++)
            {
                if(matrix[u][i] == 1 && color[i] == INF)
                {
                    color[i] = 1 - color[u];
                    que.push(i);
                }
                else if(matrix[u][i] == 1 && color[u] == color[i])
                {
                    isDecomposable = false;
                }
            }
        }
    }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            vertexNum = scanner.nextInt();
            if(vertexNum == 0) break;

            matrix = new int[vertexNum+1][vertexNum+1];
           // visited = new boolean[vertexNum+1];
            color   = new int[vertexNum+1];

            scanner.nextLine();
            while(true) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                if (u == 0 && v == 0) break;

                matrix[u][v] = matrix[v][u] = 1;
            }
            //bipartite graph
            bfsTraverse();

            if(isDecomposable) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public  static void main(String[] args)
    {
        (new Main_11396_ClawDecomposition()).solve();
    }
}

/*
‘YES’

Sample Input
4
1 2
1 3
1 4
2 3
2 4
3 4
0 0
6
1 2
1 3
1 6
2 3
2 5
3 4
4 5
4 6
5 6
0 0
0


Sample Output
NO
NO


 */
