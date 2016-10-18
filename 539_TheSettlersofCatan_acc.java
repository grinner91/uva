/*


 539 The Settlers of Catan

 https://uva.onlinejudge.org/external/5/539.pdf


 */

import java.util.Scanner;

class Main_539_TheSettlersofCatan_acc {

	private final int MAX = 30;
	private int numNodes, numEdges, longestPath;
	private int[][] matrix;
	private boolean[][] visited;
	private boolean[] connected;

	private void initValues(){
		matrix = new int[MAX][MAX];
		visited = new boolean[MAX][MAX];
		connected = new boolean[MAX];
		numNodes = 0; 
		numEdges = 0;
		longestPath = 0;
	}

	private void findLongestPath(int currentNode, int costPath){

		if(costPath > longestPath) longestPath = costPath;	

		for(int i = 0; i < numNodes; i++){

			if(i == currentNode) continue;

			if(matrix[currentNode][i] == 1 && !visited[currentNode][i] && !visited[i][currentNode]){

				visited[currentNode][i] = true; 
				visited[i][currentNode] = true;				

				findLongestPath(i, costPath+1);

				visited[currentNode][i] = false; 
				visited[i][currentNode] = false;
			}
		}		
	}



	public void solve(){

		Scanner sc = new Scanner(System.in);

		while(true){

			initValues();

			numNodes = sc.nextInt();
			numEdges = sc.nextInt();

			if(numEdges == 0 && numNodes == 0) break;

			int u, v;
			for(int i = 0; i < numEdges; i++){
				u = sc.nextInt();
				v = sc.nextInt();

				matrix[u][v] = 1;
				matrix[v][u] = 1;

			}

			for(int n = 0; n < numNodes; n++){				

				findLongestPath(n, 0);					
			}

			System.out.println(longestPath);
		}

	}
	public static void main(String[] args) {
		(new Main_539_TheSettlersofCatan_acc()).solve();
	}

}

/*

Sample Input
3 2
0 1
1 2


15 16
0 2
1 2
2 3
3 4
3 5
4 6
5 7
6 8
7 8
7 9
8 10
9 11
10 12
11 12
10 13
12 14
0 0

Sample Output

2
12

 */
