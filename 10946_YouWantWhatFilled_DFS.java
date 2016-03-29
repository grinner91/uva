/**
 * Created by mzaman on 3/25/16.
 *
 * 10946 - You want what filled?
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1887
 *
 */

import java.util.*;

class Main_10946_YouWantWhatFilled {

    class FillInfo implements Comparable<FillInfo>
    {
        public char fillCh;
        public int count;
        public FillInfo(char ch, int count)
        {
            fillCh = ch;
            this.count = count;
        }
        public  int compareTo(FillInfo other)
        {
            if(this.count == other.count)
                return  Character.compare(other.fillCh, this.fillCh);

            return Integer.compare(this.count,other.count);
        }
    }

    int numRow, numCol, cellCount;
    char[][] matrix;
    ArrayList<FillInfo> fillList;
    int[] dr = {+1, -1, 0, 0};
    int[] dc = {0, 0, +1, -1};

    private void dfsTraverse(int r, int c, char fillCh)
    {
        if(!(r >= 0 && r < numRow && c >=0 && c < numCol)) return;
        if(matrix[r][c] == '.') return;
        if(matrix[r][c] != fillCh) return;

        cellCount++;
        matrix[r][c] = '.';

        for(int i = 0; i < 4; i++)
            dfsTraverse(r + dr[i], c+dc[i], fillCh);

    }

    public void solve()
    {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; sc.hasNextLine(); tc++)
        {
            numRow = sc.nextInt();
            numCol = sc.nextInt();
            if(numRow == 0 && numCol == 0 ) break;

            matrix = new char[numRow][numCol];

            sc.nextLine();
            for(int r = 0; r < numRow; r++)
            {
                matrix[r] = sc.nextLine().toCharArray();
            }

            fillList = new ArrayList<FillInfo>();
            char fillCh;
            for(int r = 0; r < numRow; r++)
            {
                for(int c = 0; c < numCol; c++)
                {
                    if(matrix[r][c] != '.')
                    {
                        fillCh = matrix[r][c];
                        cellCount = 0;

                        dfsTraverse(r,c,fillCh);

                        fillList.add(new FillInfo(fillCh, cellCount));
                    }
                }
            }

            Collections.sort(fillList);

            int size = fillList.size();

            System.out.println("Problem " + tc +":");

            for(int i = size-1; i >=0 ; i--)
            {
                System.out.println(fillList.get(i).fillCh + " " + fillList.get(i).count);
            }
        }
    }

    public  static void main(String[] args)
    {
        (new Main_10946_YouWantWhatFilled()).solve();
    }
}

/*


Sample Input

5 5
..AAA
E.BBB
..AA.
CC.DD
CC.D.
5 5
..AAA
E.BBB
..AA.
CC.DD
CC.D.
0 0

Sample Output


Problem 1:
C 4
A 3
B 3
D 3
A 2
E 1
Problem 2:
C 4
A 3
B 3
D 3
A 2
E 1

 */
