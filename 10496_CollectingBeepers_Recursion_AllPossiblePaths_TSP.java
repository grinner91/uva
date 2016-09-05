

/*
 
 Traveling Salesman Problem (TSP) 
 
10496 - Collecting Beepers	 0.080s/2073
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1437

 * 
 */


import java.util.Scanner;

class Main_10496_CollectingBeepers_Recursion_AllPossiblePaths_TSP {

	final int MAXROWSCOLS = 25, MAXBeepers = 15;
	int numRows, numCols, srcRow, srcCol, numBeepers, beepersCount;
	Beeper[] beepers;
	int minDist;
	boolean[] visited;
	
	static class Beeper{
		public int x;
		public int y;
		
		public Beeper(int r, int c){
			x = r;
			y = c;
		}
	}
	
	int getDist(int r1, int c1, int r2, int c2){

		int x = r1 > r2 ? r1 - r2 : r2 - r1;
		int y = c1 > c2 ? c1-c2 : c2 - c1;

		return x + y;		
	}

	void dfsFindBeepers(Beeper[] beeps, int level){	

		if(level == numBeepers){	
	
			int tempDist = getDist(srcRow, srcCol, beeps[0].x, beeps[0].y);
			
			for(int i = 1; i < numBeepers; i++ ){
				tempDist += getDist(beeps[i].x, beeps[i].y,beeps[i-1].x, beeps[i-1].y);				
			}
			
			tempDist += getDist(srcRow, srcCol, beeps[numBeepers-1].x, beeps[numBeepers-1].y);
			
			if(tempDist < minDist) minDist = tempDist;

			return;
		}	
		
		for(int index = 0 ; index < numBeepers; index++){
			
			if(visited[index]) continue;
			
			visited[index] = true;
			
			beeps[level] = beepers[index];
			
			dfsFindBeepers(beeps, level + 1);
			
			visited[index] = false;
		}
	}


	void initValues(){	
		beepers = new Beeper[MAXROWSCOLS];
		visited = new boolean[MAXROWSCOLS];
	}
	
	
	public void solve(){
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();
		while(testCases-- > 0){
			initValues();

			numRows = sc.nextInt();
			numCols = sc.nextInt();			

			srcRow = sc.nextInt();
			srcCol = sc.nextInt();

			numBeepers = sc.nextInt();

			beepersCount = 0;
			
			int tempx, tempy;
			for(int i = 0; i < numBeepers; i++ ){
				 tempx = sc.nextInt();
				 tempy = sc.nextInt();
				 
				 beepers[i] = new Beeper(tempx, tempy);			
			}		

			minDist = Integer.MAX_VALUE;
				
			Beeper[] beeps = beepers.clone();
			dfsFindBeepers(beeps, 0);
			
			System.out.println("The shortest path has length "+minDist);
		}		
	}

	public static void main(String[] args) {		
		(new Main_10496_CollectingBeepers_Recursion_AllPossiblePaths_TSP()).solve();
	}

}

/*
 * 
 * 
 * Sample Input

1
1 4
1 1
10
1 1
1 1
1 2
1 4
1 4
1 1
1 1
1 1
1 4
1 1

The shortest path has length 6


1
10 10
1 1
4
2 3
5 5
9 4
6 5

Sample Output

The shortest path has length 24

 */
