/**
 * Created by mzaman on 3/14/16.
 *
 * 10034 Freckles
 *
 * https://uva.onlinejudge.org/external/100/10034.pdf
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main_10034_Freckles_MST_Kruskal {

    //final int MAX = 102;

    class UnionFindDisjoinSet
    {
        final int MAX = 102;
        int[] parent;
        int[] rank;
        int numSets;

        public UnionFindDisjoinSet(int vrtx)
        {
            parent = new int[MAX];
            rank = new int[MAX];
            numSets = vrtx;
            initSet();
        }

        public void initSet()
        {
            for(int i = 0; i < MAX; i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public  int findSet(int x)
        {
            if(parent[x] == x) return x;
            else return findSet(parent[x]);
        }

        public boolean unionSet(int x, int y)
        {
            int xParent = findSet(x);
            int yParent = findSet(y);

            if(xParent == yParent) return false;

            numSets--;
            if(rank[xParent] > rank[yParent])
            {
                 parent[yParent] = xParent;
            }
            else if(rank[xParent] < rank[yParent])
            {
                parent[xParent] = yParent;
            }
            else
            {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
            return  true;
        }
    }


    class Edge implements Comparable<Edge>
    {
        int u;
        int v;
        double w;
        public Edge(int i, int j, double ww)
        {
            u = i;
            v = j;
            w = ww;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    double[] x;
    double[] y;
    double[][] matrix;
    double minCost;
    int numPoints;
    ArrayList<Edge> edgeList;

    private void kruskalMST()
    {
        Collections.sort(edgeList);

        UnionFindDisjoinSet unionfind = new UnionFindDisjoinSet(numPoints);

        int size = edgeList.size();
        Edge edg;
        minCost = 0;
        for(int i = 0; i < size; i++)
        {
            edg = edgeList.get(i);
            if(unionfind.unionSet(edg.u,edg.v)) {
                minCost += edg.w;
            }
        }
    }

    public void solve()
    {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();


        for(int tc = 0; tc < testCases; tc++)
        {
            scanner.nextLine();
            numPoints = scanner.nextInt();
            x = new double[numPoints+1];
            y = new double[numPoints+1];

            for(int i= 1; i <= numPoints; i ++)
            {
                x[i] = scanner.nextDouble();
                y[i] = scanner.nextDouble();
            }

            edgeList = new ArrayList<Edge>();
            double distance;
            for(int i = 1; i <= numPoints; i++)
            {
                for( int j = 1; j <= numPoints; j++)
                {
                    if(i == j) continue;

                    distance = Math.sqrt( Math.pow(x[j] - x[i],2) + Math.pow (y[j] - y[i],2));

                    edgeList.add(new Edge(i,j,distance));
                }
            }

            kruskalMST();

            if(tc > 0) System.out.println();
            System.out.printf("%.2f\n", minCost);



        }
    }

    public static void main(String[] args)
    {
        (new Main_10034_Freckles_MST_Kruskal()).solve();
    }

}


/*


2







SampleInput
2

3
1.0 1.0
2.0 2.0
2.0 4.0

4
1.0 1.0
1.0 2.0
10.0 10.0
10.0 11.0


SampleOutput
3.41
14.04

 */
