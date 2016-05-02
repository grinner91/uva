/**
 * Created by zaman on 26/04/16.
 * 
 * https://uva.onlinejudge.org/external/5/562.html
 */

import java.util.Scanner;

class Main_DividingCoins {
	final int MAXCoin = 105, MAXVal = 25005;
    int numCoins;
    int[] coins;
    int total;
    int[][] matrix;

    int findDifference(int N, int level, int remain)  {

    	
            	
        if( matrix[level][remain] >= 0 )   return matrix[level][remain];     
        
        if(remain == 0)
        {        	
        	matrix[level][remain] = 0;
            return matrix[level][remain];
        }
        
        if(N == level)  return remain;
        
        int temp1, temp2;
        if(remain - coins[level] >= 0)
            temp1 = findDifference(N, level+1, remain - coins[level]);
        else
            temp1 = remain;
        
        temp2 = findDifference(N,level+1,remain);      
        
        matrix[level][remain] = Math.min(temp1, temp2);
        
        return  matrix[level][remain];
    }

    public  void solve()
    {
        Scanner sc = new Scanner(System.in);

        int testCases  = sc.nextInt();
        while(testCases-- > 0)
        {
            numCoins = sc.nextInt();
            total = 0;
            coins = new int[numCoins];
            matrix = new int[MAXCoin][MAXVal];

            for(int i = 0; i < MAXCoin; i++)
                for(int j = 0; j < MAXVal; j++)
                    matrix[i][j] = -1;

            for(int i = 0; i < numCoins; i++) {
                coins[i] = sc.nextInt();
                total+= coins[i];
            }
            
            int diff = findDifference(numCoins, 0, total/2);

            if(total%2 == 0)
                System.out.println(2*diff);
            else
                System.out.println(2*diff+1);
        }
    }

    public static void main(String[] args)
    {
        (new Main_DividingCoins()).solve();
    }

}

/*

Sample Input

2
3
2 3 5
4
1 2 4 6

Sample Output

0
1


 */
