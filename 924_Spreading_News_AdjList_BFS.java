//optimized with Adjacent list using Array
// 924 - Spreading The News	 0.190s/1651
import java.util.Scanner;
class Main_924_Spreading_News_AdjList_BFS {
	final int MaxNodes = 2600, MaxEdges = 20;
	//int[][] graph;	
	int[][] adjList;
	
	int numNodes, numEdges, u, v, testCases, src, dest;
	int maxBoom, boomDay;
		
	/**************BFS***************************/
	int[] Q = new int[MaxNodes * MaxEdges];
	boolean[] visited;
	int[] depth;
	int[] children;
	int front, tail,level;
	
	void enqueue(int node){
		Q[tail++] = node;
	}
	
	int dequeue(){
		return Q[front++];
	}
	
	void bfsFindMaxBooms(){
		children = new int[MaxNodes];
		depth = new int[MaxNodes];
		visited = new boolean[MaxNodes];
		front = tail = 0;
		
		enqueue(src);
		depth[src] = 0;
		level = 0;
		children[level] = 0;
		visited[src] = true;
		
		while(front != tail){
			u = dequeue();
			level = depth[u] + 1;
			int adjCount = adjList[u][0];			
			for(int k = 1; k <= adjCount; k++){
				v = adjList[u][k]; 				
				if(!visited[v]){
					enqueue(v);
					depth[v] = depth[u] + 1;
					children[level] = children[level] + 1;
					visited[v] = true;
				}					
			}
		}
		maxBoom = 0;
		boomDay = 0;
		for(int i = 0; i <= level; i++){
			if(children[i] > maxBoom) {
				maxBoom = children[i];
				boomDay = i;
			}				
		}
			
	}
	
	/**************************/
	
	void initValues(){
		//graph = new int[MaxNodes][MaxNodes];
		adjList = new int[MaxNodes][MaxEdges];		
	}
	
	public void solve(){
		Scanner sc = new Scanner(System.in);
		
		initValues();
		
		numNodes = sc.nextInt();
		
		for(int i = 0; i < numNodes; i++) {			
			numEdges = sc.nextInt();
			adjList[i][0] = numEdges;			
			for(int j = 1; j <= numEdges; j++){
				v = sc.nextInt();				
				//graph[i][v] = 1;	
				adjList[i][j] = v;
			}
		}
		
		testCases = sc.nextInt();
		
		for(int tc = 0; tc < testCases; tc++){
			src = sc.nextInt();
			
			bfsFindMaxBooms();
			
			if(maxBoom > 0)
				System.out.println(maxBoom + " " + boomDay);
			else 
				System.out.println(0);
		}
	}
	
	
	public static void main(String[] args) {
		(new Main_924_Spreading_News_AdjList_BFS()).solve();
	}

}


/*

5
1 1
1 2
1 3
1 4 
1 0
5
0
1
2
3
4

1 1
1 1
1 1
1 1
1 1


Sample Input
6
2 1 2
2 3 4
3 0 4 5
1 4
0
2 0 2
3
0
4
5


Sample Output
3 2
0
2 1

*/
