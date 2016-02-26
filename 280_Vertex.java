/**
 * Created by zaman on 26/02/16.
 *
 * 280 - Vertex
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=216
 * 
 * 
 * Solution analysis: BFS traversal is used to find unreachable nodes count. 
 *
 */

import java.util.Scanner;

class Main_280_Vertex {

     class Queue
    {
        int[] q;
        int front, tail;
        public Queue()
        {
            q = new int[1000];
            front = tail = 0;
        }

        public void enq(int x)
        {
            q[tail] = x;
            tail++;
        }

        public int deq()
        {
            if(!isEmty())   return q[front++];

            return -1;
        }

        public  boolean isEmty()
        {
            if(front >= tail) return true;

            return false;
        }
    }



    public void solve()
    {

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            int vertices = Integer.parseInt(scanner.nextLine().trim());
            if(vertices == 0) break;

            int[][] graph= new int[vertices+2][vertices+2];
            int u,v, len;
            String line, nodes[];


            while(true)
            {
                line = scanner.nextLine().trim();
                if(line.equals("0")) break;
                nodes = line.split(" ");

                u = Integer.parseInt(nodes[0]);
                len = nodes.length-1;
                for(int i=1; i < len; i++)
                {
                    v = Integer.parseInt(nodes[i]);
                    graph[u][v] = 1;
                }
            }

            line = scanner.nextLine().trim();
            nodes = line.split(" ");


            len = Integer.parseInt(nodes[0]);

            for(int i = 1; i <= len; i++)
            {
                u = Integer.parseInt(nodes[i]);
                //BFS traverse
                boolean[] reachable = new boolean[vertices+2];
                int unreachableCount = vertices;
                Queue qu = new Queue();
                qu.enq(u);
                while(!qu.isEmty())
                {
                    u = qu.deq();
                    for(v = 1; v <= vertices; v++)
                    {
                        if(graph[u][v]==1 && !reachable[v]) {
                            reachable[v] = true;
                            unreachableCount--;
                            qu.enq(v);
                        }
                    }
                }

                System.out.print(""+unreachableCount);
                for(int k=1; k <= vertices; k++) {
                    if (!reachable[k])
                        System.out.print(" "+k);
                }
                System.out.println();

            }
        }
    }

    public static void main(String[] args)
    {
        new Main_280_Vertex().solve();
    }
}

/*


Sample Input

3
1 2 0
2 2 0
3 1 2 0
0
2 1 2
0

Sample Output

2 1 3
2 1 3



 */
