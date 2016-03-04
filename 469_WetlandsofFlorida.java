/**
 * Created by zaman on 02/03/16.
 *
 * 469 - Wetlands of Florida
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=410
 *
 */

import java.util.Scanner;
 class Main_469_WetlandsofFlorida {
     boolean[][] mVisited;
     int[][] mGraph;
     int mRow, mCol, mSrcRow, mSrcCol, mWCount;
     int[] dr = {-1,-1,-1, 0, +1, +1, +1, 0};
     int[] dc = {-1, 0,+1,+1, +1,  0, -1, -1};

     private void dfs(int r, int c)
     {
         if(r <= 0 || r > mRow || c <= 0 || c > mCol) return;
         if(mVisited[r][c]) return;
         if(mGraph[r][c] == 0) return;

         mVisited[r][c] = true;
         mWCount++;
         for(int i = 0; i < 8; i++)
         {
             dfs(r+dr[i], c+dc[i]);
         }
     }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine().trim());
        scanner.nextLine();

        char ch;
        String line;
        for(int tc = 0; tc < testCases; tc++)
        {
            if(tc > 0) System.out.println();

            line = null;
            mGraph = new int[110][110];
            mRow = mCol = 0;
            while(scanner.hasNextLine())
            {
                line = scanner.nextLine().trim();
                if(line.charAt(0) != 'L' && line.charAt(0) != 'W')  break;

                    mCol = line.length();
                    mRow++;
                    for (int i = 1; i <= mCol; i++) {
                        ch = line.charAt(i - 1);
                        if (ch == 'W') mGraph[mRow][i] = 1;
                        else mGraph[mRow][i] = 0;
                    }
            }

           if(null == line || line.isEmpty()) break;

            mSrcRow = Integer.parseInt(line.split(" ")[0]);
            mSrcCol = Integer.parseInt(line.split(" ")[1]);

            mVisited = new boolean[110][110];
            mWCount = 0;
            dfs(mSrcRow,mSrcCol);
            System.out.println(mWCount);

            while(scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                if(line.isEmpty()) break;
                mSrcRow = Integer.parseInt(line.split(" ")[0]);
                mSrcCol = Integer.parseInt(line.split(" ")[1]);

                mVisited = new boolean[110][110];
                mWCount = 0;
                dfs(mSrcRow,mSrcCol);
                System.out.println(mWCount);
            }

        }
    }


    public static void main(String[] args)
    {
        (new Main_469_WetlandsofFlorida()).solve();
    }
}

/*

Sample Input

2

LLLLLLLLL
LLWWLLWLL
LWWLLLLLL
LWWWLWWLL
LLLWWWLLL
LLLLLLLLL
LLLWWLLWL
LLWLWLLLL
LLLLLLLLL
3 2
7 5

LLLLLLLLL
LLWWLLWLL
LWWLLLLLL
LWWWLWWLL
LLLWWWLLL
LLLLLLLLL
LLLWWLLWL
LLWLWLLLL
LLLLLLLLL
2 7
7 5

Sample Output

12
4


 */
