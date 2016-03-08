/**
 * Created by mzaman on 3/8/16.
 *
 * 260 - Il Gioco dell'X
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=196
 *
 *  ( i-1 , j-1 ) , ( i-1 ,  j  )
 (  i  , j-1 ) , (  i  , j+1 )
 ( i+1 ,  j  ) , ( i+l , j+1 )
 *
 */
import java.util.Scanner;

class Main_260_IlGiocodellX {
    final int MAX = 202;
    char[][] matrix;
    boolean[][] visited;
    boolean isBlackWon;
    int rowNum, colNum, srcRow, srcCol;
    int[] dr = {-1,-1, 0,+1,+1,0 };
    int[] dc = {-1, 0,+1,+1, 0, -1};


    private void dfsTraverse(int r, int c)
    {
        if(isBlackWon) return;
        if(!(r >=0 && r < rowNum && c >= 0 && c < colNum)) return;
        if(matrix[r][c] != 'b') return;
        if(visited[r][c]) return;
        if(r == rowNum -1) {
            isBlackWon = true;
            return;
        }

        visited[r][c] = true;
        for(int i = 0; i < 6; i++)
            dfsTraverse(r + dr[i], c + dc[i]);

    }

    public void solve()
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        for(int tc =1; ; tc++)
        {
            rowNum = Integer.parseInt(scanner.nextLine());
            if(rowNum == 0) break;

            matrix = new char[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for(int r = 0; r < rowNum; r++)
            {
                input = scanner.nextLine().trim();
                matrix[r] = input.toCharArray();
            }
            colNum = matrix[0].length;

            int c;
            isBlackWon = false;

            for(c = 0; c < colNum; c++) {
                if (matrix[0][c] == 'b')
                {
                    dfsTraverse(0,c);

                    if(isBlackWon)    break;
                }
            }

            if(isBlackWon)
                System.out.println(tc+" B");
            else
                System.out.println(tc+" W");
        }

    }
    public static void main(String[] args)
    {
        (new Main_260_IlGiocodellX()).solve();

    }
}

/*


Sample Input

4
bbwb
wwbw
bbwb
bwww
4
bbwb
wwbw
bwwb
wwbb
0


Sample Output

1 W
2 B


 */
