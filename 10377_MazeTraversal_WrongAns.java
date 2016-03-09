/**
 *
 * It gets WRONG Answer It is not accepted solution,
 *
 * Created by mzaman on 3/8/16.
 *
 * 10377 - Maze Traversal
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1318
 *
 */

import java.util.Scanner;

//It gets WRONG Answer. It is not accepted solution, though all sample input, produce correct output.
class Main_10377_MazeTraversal_WrongAns {

    //final int MAX = 65;
    char[][] matrix;
    String directions = "NESW";
    boolean isQuit;
    int rowMax, colMax, currentRow, currentCol, currentDirection;

    private void executeCommands(String commands)
    {
        int tempRow = currentRow, tempCol = currentCol;

        for(int i = 0; i < commands.length(); i++)
        {
            switch(commands.charAt(i))
            {
                case 'R':
                    currentDirection = (directions.indexOf( directions.charAt(currentDirection)) + 1) % 4;
                    break;
                case 'L':
                    currentDirection = (directions.indexOf( directions.charAt(currentDirection)) + 3) % 4;
                    break;
                case 'F':
                        if(currentDirection == 0) tempRow--;
                        else if(currentDirection == 1) tempCol++;
                        else if(currentDirection == 2) tempRow++;
                        else if(currentDirection == 3) tempCol--;

                        if(tempRow >= 0 && tempRow < rowMax
                                && tempCol >= 0 && tempCol < colMax
                                && matrix[tempRow][tempCol] != '*'){

                                currentCol = tempCol;
                                currentRow = tempRow;
                        }
                    break;
                case 'Q':
                    isQuit = true;
                    break;
            }

        }
    }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        String input,space="";

        for(int tc = 0; tc < testCases; tc++)
        {
            rowMax = scanner.nextInt();
            colMax = scanner.nextInt();
            scanner.nextLine();

            matrix  = new char[rowMax][colMax];
            space = "";

            for(int c = 0; c < colMax; c++)
            {
                space+=" ";
            }

            for(int r = 0; r < rowMax; r++)
            {
                input = scanner.nextLine();

                if(colMax - input.length() > 0)
                    input = input + space.substring(0, (colMax - input.length()));

                matrix[r] = input.toCharArray();
            }

            currentRow = scanner.nextInt() - 1;
            currentCol = scanner.nextInt() - 1;
            currentDirection = 0;
            scanner.nextLine();
            isQuit = false;

            while(!isQuit)
            {
                input = scanner.nextLine();
                //input = input.replace(" ","");
                if(input.isEmpty()) break;

                executeCommands(input);
            }

            if(tc > 0) System.out.println();

            System.out.println((currentRow+1 )+" " + (currentCol + 1)+ " " + directions.charAt(currentDirection));

           // if(tc < testCases) System.out.println();
        }
    }


    public  static void main(String[] args)
    {
        (new Main_10377_MazeTraversal_WrongAns()).solve();
    }
}


/*


Sample Input
2

7 8
********
* * * **
* * *
* * ** *
* * * *
* * **
********
2 4
RRFLFF FFR
FF
RFFQ

7 8
********
* * * **
* * *
* * ** *
* * * *
* * **
********
2 2
RRFLFF FFR
FF
RFFQ


Sample Output
5 6 W

5 4 W


 */
