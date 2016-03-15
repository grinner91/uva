/**
 * Created by mzaman on 3/15/16.
 *
 * 871 - Counting Cells in a Blob
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=812
 *
 */

import java.util.Scanner;
class Main_871_CountingCellsinaBlob_DFS {
    final  int MAX = 26;
    char[][] matrix;
    boolean[][] visited;
    int colNum, rowNum, blobCount, maxBlobCount;
    int[] dr = {-1,-1,-1, 0, +1, +1, +1, 0};
    int[] dc = {-1, 0,+1,+1, +1,  0, -1, -1};


    private boolean isInBoundary(int r, int c)
    {
        if(r >= 0 && r < rowNum && c >= 0 && c < colNum)
            return  true;
        else
            return  false;
    }

    private void dfsTraverse(int r, int c)
    {
        if(!isInBoundary(r,c)) return;
        if(visited[r][c]) return;
        if(matrix[r][c] == '0') return;

        blobCount++;
        visited[r][c] = true;
        for(int i = 0; i < 8; i++)
            dfsTraverse(r + dr[i], c + dc[i]);
    }

    public void solve()
    {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();

        String line;
        for(int tc = 0 ; tc < testCases; tc++)
        {
            matrix = new char[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for( int r = 0; sc.hasNextLine(); r++)
            {
                line = sc.nextLine().trim();
                if(line.isEmpty()) break;
                matrix[r] = line.toCharArray();
                rowNum = r;
                colNum = line.length();
            }
            rowNum++;

            maxBlobCount =  0;
            for(int r = 0; r < rowNum; r++)
            {
                for(int c = 0; c < colNum; c++)
                {
                    if(matrix[r][c] == '1' && !visited[r][c])
                    {
                        blobCount = 0;

                        dfsTraverse(r,c);

                        if(blobCount > maxBlobCount)
                            maxBlobCount = blobCount;
                    }
                }
            }

            if(tc > 0 ) System.out.println();

            System.out.println(maxBlobCount);

        }
    }

    public  static void main(String[] args)
    {
        (new Main_871_CountingCellsinaBlob_DFS()).solve();
    }
}


/*

20

000001000000
001011010000
000000000001
000000100100
000110001000
101000001000
000100011011
000011110100
000000000001

0100001
0100000
0000010

000011010000
110101000000
001110001011
001000001100

0
0
0
0

00001
00101
10000
01101
10001
10000
01010
00000
00100
01100
10001
10000
00000
11100
01100
10011
11000
10000
00010
00010
00100

11011010010001110
01000000100000100

010010110010011110
000010000010000110
010001001001000010
000010001001101100
110100010000101010
000000010011010011
001110011000000010
100000000100100100
000100000110010001
000100100000001000
001001001010001100
000001000010001010
000000100100011001
000000000000000000
001000010000000000
000000000010000000

00
01
00
00
01
10
00
11
01
00
00
10
00
11
10
00
01
00
00
11
00
00
10

0000010000
0000000000
0000000010
0100000000
0100000100
0001000000

00
10
00
00
01

00
10
01
10
00
00
11
00
01
10
01
01
00
00
00
00
00
01

11000010000
00101100000
00010000000
01001110001
00100000110
01000000000
00001000000
00000000010

0010101
0010000
0100000
1000010
0001000
0000001
1110100
0110001

0010000010000000000001
0010000101000000100010
1010010110000100100010
0000000000000101100000
0000010001000101010001
0000000110001010100010
0101110000000000100000
0010100000000011100000

0000001001010001
0001000011000001
1001000001000100

0
0
1
0
0
0
0
0
1
0
0
1
0

00101
01000
10001
10000
00100
00000

01000
11000
10000
00000
00001
00000
00000
00000
00001
10000
01001
00000
00000
00000
00110
00011
00000
01001

00000001
01001010
11000000
10100001
10000000
00110100
10000010
11000000
10000000
00000101
00000010
10000110
10000000
01001100
00001011
10000000
00011100
11011000
10010000
00100000
00010000

0000
0010
0001
0110

output


16

2

10

0

11

4

24

3

2

1

4

10

5

16

4

1

4

4

8

4


 */
