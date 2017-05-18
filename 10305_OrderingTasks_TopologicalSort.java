
//Accepted

import java.util.Scanner;

class Main_10305_OrderingTasks {

	

	public static void main(String[] args) {
		int N, M;
		int[][] graph;
		Scanner sc = new Scanner(System.in);

		while(true){

			N = sc.nextInt();
			M = sc.nextInt();			
			if(N == 0 && M == 0) break;

			graph = new int[N+2][N+2];
			
			for(int i=0; i <= N+1; i++)
				for(int j=0; j <= N+1; j++)
					graph[i][j] = 0;

			int u,v;
			for(int i = 1; i <= M; i++){				
				u = sc.nextInt();
				v = sc.nextInt();
				graph[u][v] = 1;
			}


			for(int i = 1; i <= N; i++){

				int indegree = 0, j = 0;
				for(j = 1; j <= N; j++)
				{
					indegree += graph[j][i];
				}

				graph[j][i] = indegree;
			}

			int[] orderedNodes = new int[N+1];
			int count = 1, tempCount=1;

			while(true){				

				boolean isNodeFound = false;
			
				tempCount = count;
				for(int node = 1; node <= N; node++){
					if(graph[N+1][node] == 0) {
						isNodeFound = true;
						orderedNodes[count++] = node;	
						graph[N+1][node] = -1;
					}
				}

				if(!isNodeFound) break;				

				for(int n=tempCount; n < count; n++ )
				{
					int node = orderedNodes[n];
					
					for(int i=1; i <= N; i++){
						if(graph[node][i] == 1) {						
							graph[N+1][i]--;
						}
					}
				}
			}

			System.out.print(""+orderedNodes[1]);
			for(int i=2; i<=N; i++)
				System.out.print(" "+orderedNodes[i]);
			System.out.println();

		}

	}

}

/*

Sample Input
5 4
1 2
2 3
1 3
1 5
0 0

Sample Output
1 4 2 5 3


 */ 
