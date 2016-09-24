
/*

624 - CD
Recursion - knapsack 
 * 
 */

import java.util.Scanner;

class Main_624_CD {	 
	int MAX = 25;
	int N, cdNum, maxSum, count;
	int[] durations;
	boolean[] visited;	
	int[] pathValues;

	void initValues(){
		durations = new int[MAX];
		visited = new boolean[MAX];		
		pathValues  = new int[MAX];
		maxSum = 0;
		count = 0;
	}

	void findMaxSolution(int level, int partialSum){	
		
		if(partialSum <= N && partialSum > maxSum){
			count = 0;
			maxSum = partialSum;
			
			for(int k = 0; k < level ; k++)
				if(visited[k])
					pathValues[count++] = durations[k];
			
		}		
		
		if(level == cdNum ) return;
		
		if(partialSum+durations[level] <= N) {
			visited[level] = true;
			findMaxSolution(level+1, partialSum+durations[level]);
		}
		
		visited[level] = false;
		findMaxSolution(level+1, partialSum);
	}

	public void solve(){

		Scanner sc = new Scanner(System.in);		 

		while(sc.hasNextInt()){

			initValues();

			N = sc.nextInt();
			cdNum = sc.nextInt();

			for(int i = 0; i < cdNum; i++)
				durations[i] = sc.nextInt();

			findMaxSolution(0, 0);

			for(int i = 0; i < count; i++ )
				System.out.print(pathValues[i]+" ");

			System.out.println("sum:"+maxSum);

		}

	}

	public static void main(String[] args) {
		(new Main_624_CD()).solve();

	}

}

/*


Sample Input

5 3 1 3 4
10 4 9 8 4 2
20 4 10 5 7 4
90 8 10 23 1 2 3 4 5 7
45 8 4 10 44 43 12 9 8 2


Sample Output
1 4 sum:5
8 2 sum:10
10 5 4 sum:19
10 23 1 2 3 4 5 7 sum:55
4 10 12 9 8 2 sum:45


 * 
 */
