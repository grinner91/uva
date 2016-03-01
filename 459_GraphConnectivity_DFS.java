/**
 * Created by zaman on 29/02/16.
 *
 * 459 - Graph Connectivity
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=400
 *
 */

import java.util.Scanner;

class Main_459_GraphConnectivity_DFS {

    int[][] graph;
    boolean[] visited;
    int maxNode;

    private  void dfs(int src)
    {
        if(visited[src]) return;

        visited[src] = true;
        for(int i=0; i <= maxNode; i++)
        {
            if(graph[src][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine().trim());
        scanner.nextLine();
        String line;

        for(int tc =0; tc < testCases; tc++)
        {
           line = scanner.nextLine().trim();
           maxNode = line.toCharArray()[0] - 'A';

            int u,v;
            graph = new int[maxNode+2][maxNode+2];
            visited = new boolean[maxNode+2];

            while(scanner.hasNextLine())
             {
                line = scanner.nextLine();
                if(null == line || line.isEmpty()) break;

                line   = line.trim();
                 u = line.charAt(0) - 'A';
                 v = line.charAt(1) - 'A';
                 graph[u][v] = graph[v][u]= 1;
             }

            int subGraphCount = 0;
            for(u = 0; u <= maxNode; u++)
            {
                    if(visited[u] == false)
                    {
                        subGraphCount++;
                        dfs(u);
                    }
            }

            if(tc > 0) System.out.println();

            System.out.println(subGraphCount);
        }
    }

    public static void main(String[] args)
    {
        (new Main_459_GraphConnectivity_DFS()).solve();
    }
}

/*

Sample Input

1

E
AB
CE
DB
EC


Sample Output

2


 */
