// 10653 - Bombs! NO they are Mines!!  0.880s/1721(1)
import java.util.Scanner;

class Main_10653_BombsNO_Mines_BFS {
	final int MAXROWSCOLS = 1100, INF = -1;
	
	int[][] graph;
	int numRows, numCols, bombRows;

	/********************************/
	int[] qrow = new int[MAXROWSCOLS * MAXROWSCOLS];
	int[] qcol = new int[MAXROWSCOLS * MAXROWSCOLS];
	boolean[][] visited;
	int[][] cost;
	int front, tail;
	int[] dr = {0, 1, 0, -1}; 
	int[] dc = {1, 0, -1, 0}; 
	
	void enq(int r, int c){
		qrow[tail] = r;
		qcol[tail] = c;
		tail++;
	}
	
	int deqRow() {
		return qrow[front];
	}
	
	int deqCol(){
		return qcol[front++];
	}
	
	void reset(){
		visited = new boolean[MAXROWSCOLS][MAXROWSCOLS];
		cost = new int[MAXROWSCOLS][MAXROWSCOLS];
		front = tail = 0;
		
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j < numCols; j++)
			{
				cost[i][j] = Integer.MAX_VALUE;
			}
	}
	
	int bfsShortestPath(int srcRow, int srcCol, int destCol, int destRow){
		reset();				
		visited[srcRow][srcCol] = true;
		cost[srcRow][srcCol] = 0;
		enq(srcRow,srcCol);
		
		while(front != tail){
			int sr = deqRow();
			int sc = deqCol();
			
			if(sr == destRow && sc == destCol) 
				break;
			
			for(int i = 0; i < 4; i++){
				int newr = sr + dr[i];
				int newc = sc + dc[i];
				
				if(newr >= 0 && newr < numRows 
						&& newc >= 0 && newc < numCols
						&& !visited[newr][newc] 
						&& graph[newr][newc] == 0 
						&& cost[sr][sc] + 1 < cost[newr][newc]){
					
					enq(newr,newc);
					visited[newr][newc] = true;
					cost[newr][newc] = cost[sr][sc] + 1;
				}
			}
		}		
		return cost[destRow][destCol];			
	}
	
	/*******************************/
	
	void initValues(){
		graph = new int[MAXROWSCOLS][MAXROWSCOLS];
	}

	public void solve(){
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			numRows = sc.nextInt();
			numCols = sc.nextInt();	
			if(numRows == 0 && numCols == 0 ) break;
			
			bombRows = sc.nextInt();
			initValues();	
			int r, c, num;
			for(int i = 0; i < bombRows; i++){
				r = sc.nextInt();
				num = sc.nextInt();
				for(int j = 0; j < num; j++){
					c = sc.nextInt();
					graph[r][c] = INF;
				}
			}
			int srcRow = sc.nextInt();
			int srcCol = sc.nextInt();
			int destRow = sc.nextInt();
			int destCol = sc.nextInt();
			
			int len = bfsShortestPath(srcRow, srcCol, destCol, destRow);
			System.out.println(len);
			
		}
	}

	public static void main(String[] args) {

		(new Main_10653_BombsNO_Mines_BFS()).solve();
	}

}
