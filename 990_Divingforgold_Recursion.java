/*
 
 990 Diving for gold
 
 */

import java.util.Scanner;

class Main_990_Divingforgold_acc {
	//final int INF = -1, MaxTreasure = 31, MaxTime = 1001;
	int airTime, wConst, numTreasure, maxGold;
	int[] depths, golds, paths, maxPaths;
	
	
	public int findMaxGold(int pos, int val){
		if(val == 0) return 0;
		if(pos == numTreasure)
		{
			int temp = 0;
			for(int k = 0; k < numTreasure; k++){
				if(paths[k] == 1) temp+= golds[k];
			}
			
			if(temp > maxGold){
				maxGold = temp;
				for(int k = 0; k < numTreasure; k++)
					maxPaths[k] = paths[k];
			}
			return 0;
		}
		
		int left, right, usedAir = (3 * wConst * depths[pos]);
		
		if(val >= usedAir){
			paths[pos] = 1;
			left = golds[pos] + findMaxGold(pos+1, val - usedAir);
		}
		else 
			left = 0;
		
		paths[pos] = 0;
		right = findMaxGold(pos+1, val);
		
		return Math.max(left, right);
	}
	
	public void solve()	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; sc.hasNextInt(); tc++)	{
			
			if(tc > 0){
				System.out.println();				
			}
			
			airTime = sc.nextInt();
			wConst = sc.nextInt();
			numTreasure = sc.nextInt();
			
			depths = new int[numTreasure+5];
			golds = new int[numTreasure+5];
			paths = new int[numTreasure+5];
			maxPaths = new int[numTreasure+5];
						
			for(int i = 0; i < numTreasure; i++){
				depths[i] = sc.nextInt();
				golds[i] = sc.nextInt();
			}	
			
			maxGold = 0;
			int totalGold = findMaxGold(0, airTime);
			
			System.out.println(totalGold);
			int tCount=0;
			for(int i = 0; i < numTreasure; i++){
				if(maxPaths[i]==1) tCount++; 
			}
			
			System.out.println(tCount);
					
			for(int i = 0; i < numTreasure; i++){
				if(maxPaths[i] == 1)
					System.out.println(depths[i]+" "+golds[i]);
			}							
		}		
	}
	
	
	public static void main(String[] args) {
		(new Main_990_Divingforgold_acc()).solve();
	}
}


/*
 
Sample Input

210 4
3
10 5
10 1
7 2

210 4
3
10 5
10 1
7 2

Sample Output

7
2
10 5
7 2
 
7
2
10 5
7 2
  
  */
