/**
 * Created by mzaman on 3/15/16.
 *
 * 10474 - Where is the Marble?
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1415
 *
 */

import java.util.Arrays;
import java.util.Scanner;

 class Main_10474_WhereistheMarble {
     final int MAX = 10000+2;

    public void solve()
    {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; sc.hasNextLine(); tc++ )
        {
            int nMarbels = sc.nextInt();
            int qNum = sc.nextInt();
            if(nMarbels == 0 && qNum == 0) break;

            boolean[] hasMarbels = new boolean[MAX];
            int[] marbels = new int[nMarbels+1];
            int num;

            for(int i=1; i <= nMarbels; i++ )
            {
                num = sc.nextInt();

                marbels[i] = num;
                hasMarbels[num]  = true;
            }

            Arrays.sort(marbels);


            System.out.println("CASE# "+ tc +":");
            for(int i = 0; i < qNum; i++)
            {
                num = sc.nextInt();

                if(hasMarbels[num] == true)
                {
                    int pos=0;
                    for(int j = 1; j <= nMarbels; j++)
                    {
                        if(marbels[j] == num)
                        {
                            pos = j;
                            break;
                        }
                    }
                    System.out.println( num + " found at " + pos);
                }
                else
                    System.out.println( num + " not found");

            }
        }
    }

    public static void main(String[] args)
    {
        (new Main_10474_WhereistheMarble()).solve();
    }
}


/*


SampleInput
4 1
2
3
5
1
5
5 2
1
3
3
3
1
2
3
0 0


SampleOutput
CASE# 1:
5 found at 4
CASE# 2:
2 not found
3 found at 3

*/
