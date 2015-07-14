//534 Frogger
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=475
//Floyd-Warshall algorithm for MiniMax


import java.util.Scanner;


class Main_Frogger_534_FW_Minimax {

	public static void main(String[] args) {
		final int Limit=205;
		int stones,testCase=0;

		Scanner sc = new Scanner(System.in);		

		while((stones = sc.nextInt())>0)
		{
			testCase++;

			double weight[][] = new double[Limit][Limit];
			int x[]=new int[Limit], y[]=new int[Limit];
			
			//scan input for stones
			for(int i=1;i<=stones;i++)
			{
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
			}
			//initialize weights
			for(int i=1;i<=stones;i++)
				for(int j=1;j<=stones;j++)
					weight[i][j]=weight[j][i]= Integer.MAX_VALUE;

			//compute distance of stones
			for(int i=1;i<=stones;i++)
				for(int j=1;j<=stones;j++)
				{
					//calculate distance from x1y1 to x2y2
					weight[i][j] = weight[j][i] = Math.sqrt( Math.pow((x[j] - x[i]),2) + Math.pow((y[j]-y[i]),2));				
				}

			//Floyd-Warshall algorithm for MiniMax
			for(int k=1;k<=stones;k++)
				for(int i=1;i<=stones;i++)
					for(int j=1;j<=stones;j++)
					{
						weight[i][j] = Math.min(weight[i][j], Math.max(weight[i][k], weight[k][j]));
					}
			//print output
			System.out.printf("Scenario #%d%n", testCase);
			System.out.printf("Frog Distance = %.3f%n%n", weight[1][2]);
		}

	}
}
