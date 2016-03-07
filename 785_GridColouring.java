/**
 * Created by mzaman on 3/7/16.
 *
 * 785 - Grid Colouring
 *
 */

import java.util.Scanner;

 class Main_785_GridColouring {
     final int MAX = 100;
     char[][] grid;
     char contourChar;
     boolean[][] visited;
     int row, col;
     int[] dr = {-1, +1, 0,  0};
     int[] dc = { 0, 0, +1, -1};

     private boolean isInBoundary(int r, int c)
     {
         if( r >=0 && r < row && c >=0 && c < grid[r].length)
             return    true;

         return  false;
     }

     private void dfsFloodFill(int r, int c, char mark)
     {
         if(!isInBoundary(r,c)) return;
         if(visited[r][c] == true) return;
         if(grid[r][c] == contourChar) return;

         grid[r][c] = mark;
         visited[r][c] = true;
         for(int i = 0; i < 4; i++)
         {
             dfsFloodFill(r + dr[i], c+dc[i], mark);
         }
     }

    public void solve()
    {
        Scanner scanner = new Scanner(System.in);
        String line;

        while(scanner.hasNextLine())
        {
            line = "";
            grid = new char[MAX][MAX];
            visited = new boolean[MAX][MAX];
            row = col = 0;
            while(scanner.hasNextLine())
            {
                line = scanner.nextLine();
                if(!line.isEmpty() && line.charAt(0) == '_') break;

                grid[row++] = line.toCharArray();
            }
            grid[row] = line.toCharArray();

            //find contour char
            for(int r = 0; r < row; r++) {
                for (int c = 0; c < grid[r].length; c++){
                    if (grid[r][c] != ' ' && grid[r][c] != '_') {
                        contourChar = grid[r][c];
                        break;
                    }
                }
            }
            //mark grid
            char ch;
            for(int r = 0; r < row; r++)
            {
                for(int c = 0; c < grid[r].length; c++ )
                {
                    ch = grid[r][c];
                    if( ch != ' ' && ch != contourChar && !visited[r][c])
                    {
                        dfsFloodFill(r,c,ch);
                    }
                }
            }

            for(int r = 0; r <= row; r++)
                System.out.println(grid[r]);
        }

    }

    public static void main(String[] args)
    {
        new Main_785_GridColouring().solve();
    }
}

/*

Sample Input


  XXXXXXXXXXXXXXXXXXXX
  X      X           X
  X # #  XXXXXXXX /  X
  X             X    X
  XXXXXXXXXXXXXXXXXXXX
_____________________________

   XXXXXXXXXXXX       XXXXXX
  X       #   XXX  XXX   X X
  X  XX         X  X     X X
 X  X  X  XXXXXXX  XXXXXXX
 X   XX   X
  X       X  XXXX  XXXXXXXX
   XX     XXXX  X  X  /   X
    X           X  X    / X
    XXXXXXXXXXXXX  XXXXXXXX
_____________________________


Sample Output


  XXXXXXXXXXXXXXXXXXXX
  X######X///////////X
  X######XXXXXXXX////X
  X#############X////X
  XXXXXXXXXXXXXXXXXXXX
_____________________________

   XXXXXXXXXXXX       XXXXXX
  X###########XXX  XXX   X X
  X##XX#########X  X     X X
 X##X  X##XXXXXXX  XXXXXXX
 X###XX###X
  X#######X  XXXX  XXXXXXXX
   XX#####XXXX##X  X//////X
    X###########X  X//////X
    XXXXXXXXXXXXX  XXXXXXXX
_____________________________

 */
