/*
* http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=12&page=show_problem&problem=989
*/

import java.util.Scanner;

class Main_Audiophobia_10048_FW_Minimax {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase=0;
		while(true)
		{
			testCase++;			

			int cross=sc.nextInt(),street=sc.nextInt(),query=sc.nextInt();

			if(cross==0 && street==0 && query==0) break;

			int weight[][] = new int[cross+1][cross+1];
			int r,c;

			for(int i=1;i<=cross;i++)
				for(int j=1;j<=cross;j++)
					weight[i][j] =  Integer.MAX_VALUE;

			for(int i=1;i<=street;i++)		
			{
				r = sc.nextInt(); 
				c = sc.nextInt();			  
				weight[r][c] = weight[c][r] = sc.nextInt();
			}

			//floy-warshall minimax
			for(int k=1; k<=cross; k++)
				for(int i=1; i<=cross; i++)
					for(int j=1;j<=cross;j++)
						weight[i][j] = weight[j][i]  = Math.min(weight[i][j], Math.max(weight[i][k], weight[k][j]));

			if(testCase > 1) System.out.println("");

			System.out.printf("Case #%d%n",testCase);

			for(int i=1;i<=query;i++)
			{
				r = sc.nextInt();
				c = sc.nextInt();

				if(weight[r][c] == Integer.MAX_VALUE) System.out.println("no path");
				else System.out.printf("%d%n", weight[r][c]);	

			}			
		}		
	}
}
