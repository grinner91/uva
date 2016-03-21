/**
 * Created by mzaman on 3/21/16.
 *
 * 11953 - Battleships
 *
 */

import java.util.Scanner;

class Main_11953_Battleships_DFS {
    char[][] matrix;
    int numRow, shipCount;
    int[] dr = {+1,-1,0, 0};
    int[] dc = {0,0,+1,-1};

    private boolean isInBoundary(int r, int c)
    {
        if(r >=0 && r < numRow && c >=0 && c < numRow) return true;
        else return false;
    }

    private void dfsTraverse(int r, int c)
    {
        if(!isInBoundary(r,c)) return;
        if(matrix[r][c] == '.') return;

        matrix[r][c] = '.';
        for(int i = 0; i < 4; i++)
            dfsTraverse( r + dr[i], c + dc[i]);
    }

    public  void solve()
    {
        Scanner sc  = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for(int tc =  1; tc <= testCases; tc++)
        {
             numRow = sc.nextInt();
            sc.nextLine();

            matrix = new char[numRow][numRow];

            for(int r = 0; r < numRow; r++)
            {
                matrix[r] = sc.nextLine().toCharArray();
            }

            shipCount = 0;
            for(int r = 0; r < numRow; r++)
                for(int c= 0; c < numRow; c++)
                {
                    if(matrix[r][c] == 'x')
                    {
                        shipCount++;
                        dfsTraverse(r,c);
                    }
                }

            System.out.println("Case " + tc + ": " + shipCount);

        }

    }
    public  static void main(String[] args)
    {
        (new Main_11953_Battleships_DFS()).solve();
    }
}


/*

2
4
x...
..x.
@.@.
....
2
..
x.

Sample Output

Case  1:  2
Case  2:  1


 */
