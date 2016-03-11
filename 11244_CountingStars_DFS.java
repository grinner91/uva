/**
 * Created by mzaman on 3/11/16.
 *
 * 11244 Counting Stars
 *
 * https://uva.onlinejudge.org/external/112/11244.pdf
 *
 */


import java.util.Scanner;

class Main_11244_CountingStars {
    //final int MAX = 1000;
    char[][] matrix;
    boolean[][] visited;
    int rowNum, colNum, nodeCount, starCount;

    int[] dr = {-1,-1,-1, 0, +1, +1, +1, 0};
    int[] dc = {-1, 0,+1,+1, +1,  0, -1, -1};

    private boolean isInBoundary(int r, int c)
    {
        if(r >= 0 && r < rowNum && c >=0 && c < colNum)
            return  true;
        else
            return false;
    }
    private void dfsTraverse(int r, int c)
    {
        if(!isInBoundary(r,c)) return;
        if(visited[r][c]) return;
        if(matrix[r][c] != '*') return;

        nodeCount++;
        visited[r][c] = true;
        for(int i = 0; i < 8; i++)
        {
            dfsTraverse(r + dr[i], c + dc[i]);
        }
    }

     public  void solve()
    {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine())
        {
            rowNum = scanner.nextInt();
            colNum = scanner.nextInt();
            if(rowNum == 0  && colNum == 0) break;
            scanner.nextLine();

            matrix = new char[rowNum+1][colNum+1];
            visited = new boolean[rowNum+1][colNum+1];

            for(int r = 0; r < rowNum; r++)
            {
                matrix[r] = scanner.nextLine().toCharArray();
            }

            starCount = 0;
            for(int r = 0; r < rowNum; r++)
            {
                for(int c = 0; c < colNum; c++)
                {
                    if(matrix[r][c] == '*' && !visited[r][c]) {
                        nodeCount = 0;
                        dfsTraverse(r, c);
                        if(nodeCount == 1)
                            starCount++;
                    }
                }
            }
            System.out.println(starCount);

        }
    }

    public static void main(String[] args)
    {
        (new Main_11244_CountingStars()).solve();
    }
}

/*

Sample Input

5 5
.....
....*
....*
...*.
*....
4 3
...
.*.
...
*.*
0 0


Sample Output
1
3


 */
