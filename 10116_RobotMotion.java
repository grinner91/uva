/**
 * Created by mzaman on 3/7/16.
 *
 * 10116 - Robot Motion
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1057
 *
 */
import java.util.Scanner;

class Main_10116_RobotMotion {
    final int MAX = 1000;
    int row,col,srcRow, srcCol, pathIndex;
    int[] path;
    char[][] grid;
    boolean[][] visited;
    boolean isExited, isLooped;
    int stepsCount, loopCount;

    private boolean isInBoundary(int r, int c)
    {
        if(r >=0 && r < row && c >=0 && c < col)
            return true;
        else
            return  false;
    }
    private void calculateLoopCount(int r, int c)
    {
        int rcval = MAX * r + c;
        for(int i = 0; i < pathIndex; i++)
        {
            if(path[i] == rcval)
            {
                loopCount = stepsCount - i;
                break;
            }
        }

    }
    private void dfsTraverse(int r, int c)
    {
        if(isExited) return;
        if(isLooped) return;
        if(!isInBoundary(r,c))
        {
            isExited = true;
            return;
        }
        if(visited[r][c])
        {
            isLooped = true;
            calculateLoopCount(r,c);
            return;
        }

        char instruction = grid[r][c];
        visited[r][c] = true;
        stepsCount++;
        path[pathIndex++] = MAX * r + c;

        if(instruction == 'N') r--;
        else if(instruction == 'S') r++;
        else if(instruction == 'E') c++;
        else if(instruction == 'W') c--;

        dfsTraverse(r,c);

    }

    public void solve()
    {
        Scanner scanner = new Scanner(System.in);
        String input;

        while(scanner.hasNextLine())
        {
            input = scanner.nextLine();
            row = Integer.parseInt(input.split(" ")[0]);
            col = Integer.parseInt(input.split(" ")[1]);
            srcCol = Integer.parseInt(input.split(" ")[2]) - 1;
            srcRow = 0;
            if(row == 0  && col == 0) break;

            grid = new char[row+2][col+2];
            for(int r = 0; r < row; r++){
                input = scanner.nextLine().trim();
                grid[r] = input.toCharArray();
            }

            isExited = false;
            isLooped = false;
            stepsCount = 0;
            loopCount = 0;
            pathIndex = 0;
            visited = new boolean[row+2][col+2];
            path = new int[MAX];

            dfsTraverse(srcRow,srcCol);

            if(isExited)
                System.out.println( stepsCount + " step(s) to exit");
            else if(isLooped)
                System.out.println((stepsCount - loopCount)+" step(s) before a loop of "+loopCount+" step(s)");

        }
    }


    public static void main(String[] args)
    {
        (new Main_10116_RobotMotion()).solve();
    }
}


/*


SampleInput

3 6 5
NEESWE
WWWESS
SNWWWW
4 5 1
SESWE
EESNW
NWEEN
EWSEN
0 0 0


SampleOutput

10 step(s) to exit
3 step(s) before a loop of 8 step(s)



 */
