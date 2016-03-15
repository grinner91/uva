/**
 * Created by mzaman on 3/15/16.
 *
 * 722 - Lakes
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=663
 *
 */

import java.util.Scanner;

 class Main_722_Lakes_DFS {
     final int MAX = 100;
     char[][] matrix;
     boolean[][] visited;
     int srcRow, srcCol, rowNum, colNum,waterCellCount;
     int[] dr = {+1,-1,0,0};
     int[] dc = {0,0,+1,-1};

     private boolean isInBoundary(int r, int c)
     {
        if(r >= 0  && r < rowNum && c >= 0 && c < colNum )
            return  true;
         else
            return  false;
     }


     private void dfsTraverse(int r, int c)
     {
        if(!isInBoundary(r,c)) return;
         if(visited[r][c]) return;
         if(matrix[r][c] == '1') return;

         waterCellCount++;
         visited[r][c] = true;

         for(int i = 0; i < 4; i++)
             dfsTraverse(r + dr[i], c + dc[i]);

     }

    public  void solve()
    {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        String line;
        for(int tc = 0 ; tc < testCases; tc++)
        {
            srcRow = sc.nextInt();
            srcCol   = sc.nextInt();
            sc.nextLine();
            matrix = new char[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for(int r = 0; sc.hasNextLine(); r++)
            {
                line = sc.nextLine();
                if(line.isEmpty()) break;

                matrix[r] = line.toCharArray();
                rowNum = r;
                colNum = line.length();
            }
            rowNum++;

            srcRow--;
            srcCol--;
            waterCellCount=0;

            dfsTraverse(srcRow,srcCol);

            if(tc > 0 ) System.out.println();

            System.out.println(waterCellCount);

        }

    }

    public  static void main(String[] args)
    {
        (new Main_722_Lakes_DFS()).solve();
    }

}


/*

input




11

02 01
1001101
0011111
0001001
1100011
1111111
1100110
1110111

01 06
1001101
0011111
0001001
1100011
1111111
1100110
1110111

06 07
1001101
0011111
0001001
1100011
1111111
1100110
1110111

06 04
1001101
0011111
0001001
1100011
1111111
1100110
1110111

06 07
100110111
001111111
000100111
110001101
111111110
110011001
111011110
110011101

06 03
100110111
001111111
000100111
110001101
111111110
110011001
111011110
110011101

04 08
100110111
001111111
000100111
110001101
111111110
110011001
111011110
110011101

02 02
111
101
111

02 03
10101
01010
10101

05 06
101010101010
010101010101
101010101010
010101010101
101010101010
010101010101
101010101010
010101010101
101010101010
010101010101
101010101010
010101010101
101010101010

05 05
00000
00000
00000
00000
00000


output

12

1

1

3

2

5

1

1

1

1

25


 */
