/**
 *
 * Created by zaman on 24/02/16.
 *
 * 118 - Mutant Flatworld Explorers
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=54
 *  *
 */

/*

problem analysis: this is simple graph traversal / simulation problem

Solution analysis:

1. robot can move into the lost cell from where previous robot lost,
but can not move to the lost direction, since there is scent, therefore, the instruction with scent direction must ignore

2. consider corner cells (input is in discussion forum)

 */

import java.util.Scanner;


 class Main_118_MutantFlatworldExplorers {

     int mRow;
     int mCol;
     int mCurrentRow;
     int mCurrentCol;
     int[][] mGrid;
     char mCurrentFace;
     boolean mIsLost;
     String mDirections = "NWSE";

     public void moveRobot()
     {
         //if there is lost scent to moving direction, then ignore move
         if(mCurrentFace == mGrid[mCurrentRow][mCurrentCol]) return;

         int newRow = mCurrentRow, newCol = mCurrentCol;

        //otherwise, move forward
         if(mCurrentFace == 'N')  newCol++;
         else if(mCurrentFace == 'W') newRow--;
         else if(mCurrentFace == 'S' ) newCol--;
         else if(mCurrentFace == 'E' ) newRow++;

         if( newRow < 0 || newCol < 0 || newRow > mRow || newCol > mCol )
         {
             if(mGrid[mCurrentRow][mCurrentCol] == 0) {
                 mGrid[mCurrentRow][mCurrentCol] = mCurrentFace;
                 mIsLost = true;
             }
         }
         else
         {
             mCurrentRow = newRow;
             mCurrentCol = newCol;
         }

     }

     public  void solve()
     {
         Scanner scanner = new Scanner(System.in);

         mRow = scanner.nextInt();
         mCol = scanner.nextInt();
         scanner.nextLine(); //cursor move to the next line
         mGrid = new int[mRow +1][mCol +1];

         char[] instruction;
         while(scanner.hasNext()) {

             String line = scanner.nextLine();

             //if(line == null || line.isEmpty()) continue;

             mCurrentRow = Integer.parseInt(line.split(" ")[0]);
             mCurrentCol = Integer.parseInt(line.split(" ")[1]);
             mCurrentFace = line.split(" ")[2].charAt(0);
             instruction = scanner.nextLine().trim().toCharArray();

             mIsLost = false;

             for(int i = 0; i < instruction.length; i++ )
             {
                 if(mIsLost) break;

                 switch (instruction[i])
                 {
                     case 'F':
                        moveRobot();
                         break;
                     case 'R':
                         mCurrentFace = mDirections.charAt( (mDirections.indexOf(mCurrentFace) + 3) % 4);
                         break;
                     case 'L':
                         mCurrentFace = mDirections.charAt( (mDirections.indexOf(mCurrentFace) + 1) % 4);
                         break;
                 }
             }

             if(mIsLost) System.out.println(mCurrentRow +" "+ mCurrentCol + " " + mCurrentFace + " LOST");
             else System.out.println(mCurrentRow +" "+ mCurrentCol + " " + mCurrentFace);
         }
     }

    public static void main(String[] args)
    {
        (new Main_118_MutantFlatworldExplorers()).solve();
    }

}

/*

Sample Input

5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL


Sample Output

1 1 E
3 3 N LOST
2 3 S


 */
