import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by zaman on 03/12/15.
 *
 * 10189_Minesweeper
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1130
 *
 */
class Main_10189_Minesweeper {

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 0;

        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            if (0 == row) break;
            int col = Integer.parseInt(st.nextToken());

            int[][] mines = new int[row][col];
            for(int i=0; i < row; i++)
                Arrays.fill(mines[i],0);

            int[] dr = {0,0,1,-1,-1,-1, 1,1};
            int[] dc = {1,-1,0,0,-1,1,1,-1};

            for (int r = 0; r < row; r++) {
                char[] chars = br.readLine().toCharArray();

                for (int c = 0; c < col; c++) {

                    char ch = chars[c];

                    if ('*' == ch) {
                        mines[r][c] = -1; //mine

                        for (int i = 0; i < 8; i++) {

                            int newr = r + dr[i];
                            int newc = c + dc[i];

                            if (newr >= 0 && newr < row && newc >= 0 && newc < col && mines[newr][newc] != -1) {
                                mines[newr][newc] = mines[newr][newc] + 1;
                            }
                        }
                    }
                }

            }

            StringBuilder sb = new StringBuilder();

            if(testCase > 0) sb.append("\n");

            testCase++;

            sb.append("Field #"+testCase+":");

            for(int i=0; i < row; i++) {

                sb.append("\n");

                for (int j = 0; j < col; j++) {

                    if (-1 == mines[i][j]) sb.append('*');
                    else sb.append(mines[i][j]);
                }
            }

            System.out.println(sb.toString());
        }
    }
}

/*

SampleInput
4 4
*...
....
.*..
....
3 5
**...
.....
.*...
0 0


SampleOutput
Field #1:
*100
2210
1*10
1110
Field #2:
**100
33200
1*100


 */
