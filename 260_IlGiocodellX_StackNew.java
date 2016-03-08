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

class Main_260_IlGiocodellX_StackNew {
    final int MAX = 202;
    char[][] matrix;
    boolean[][] visited;
    boolean isBlackWon;
    int rowNum, colNum, srcRow, srcCol;
    int[] dr = {-1,-1, 0,+1,+1,0 };
    int[] dc = {-1, 0,+1,+1, 0, -1};


    class StackNew
    {
        final  int MAX = 100000;
        int[] stack;
        int stkIndex;

        public StackNew()
        {
            stack = new int[MAX];
            stkIndex = 0;
        }

        public void push(int r, int c)
        {
            stack[stkIndex++] = r * MAX + c;
        }

        public int pop()
        {
            if(!isEmpty())
                return stack[--stkIndex];

            return  -1;
        }

        public boolean isEmpty()
        {
            if(stkIndex == 0) return true;
            else return false;
        }

        public int getRow(int rcval)
        {
            return rcval / MAX;
        }
        public int getCol(int rcval)
        {
            return rcval % MAX;
        }
    }

    private boolean isInBoundary(int r, int c)
    {
        if((r >=0 && r < rowNum && c >= 0 && c < colNum)) return true;
        else return false;
    }

    private void dfsTraverse(int r, int c)
    {
        int rcval, srcRow, srcCol, newr,newc;
        StackNew stack = new StackNew();
        stack.push(r,c);
        visited[r][c] = true;
        while(!stack.isEmpty() && !isBlackWon) {

            rcval = stack.pop();

            srcRow = stack.getRow(rcval);
            srcCol = stack.getCol(rcval);

            for (int i = 0; i < 6 && !isBlackWon; i++) {
                newr = srcRow + dr[i];
                newc = srcCol + dc[i];
                if(isInBoundary(newr,newc) && !visited[newr][newc] && matrix[newr][newc] == 'b')
                {
                    if(newr == rowNum-1)
                        isBlackWon = true;

                    visited[newr][newc] = true;
                    stack.push(newr,newc);
                }
            }
        }

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
        (new Main_260_IlGiocodellX_StackNew()).solve();

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
