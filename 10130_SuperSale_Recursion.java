/*
 
 
  
 10130 SuperSale
  
 */
import java.util.Scanner;

public class Main_10130_SuperSale {
		final int MaxObjects = 1001, MaxPrice = 101, MaxWeight = 31;
		final int INF = -1;
		int numObjs,numPeople;
		int[] prices, weights;
		int[] weightPersons;
		int sumValue;		
		int[][] matrix;
	
		public int findMaxValue(int pos, int val)
		{						
			if(val == 0) return 0;
			if(pos == numObjs ) return 0;
			if(matrix[pos][val] != INF) return matrix[pos][val];
			
			int ret1, ret2;			
			if(val >= weights[pos])
			{
				ret1 = prices[pos] + findMaxValue(pos+1, val - weights[pos]);
			}
			else 
				ret1 = 0;
			
			ret2 = findMaxValue(pos+1, val);
			
			return matrix[pos][val] = Math.max(ret1, ret2);
		}
		
	public void solve(){
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();		
		for(int t = 0; t < testCases; t++){
			
			numObjs = sc.nextInt();
			prices = new int[numObjs+1];
			weights = new int[numObjs+1];
			
			for(int i=0; i<numObjs; i++){
				prices[i] = sc.nextInt();
				weights[i] = sc.nextInt();				
			}
			
			numPeople = sc.nextInt();			
			weightPersons = new int[numPeople+1];
			
			for(int i = 0; i < numPeople; i++){
				weightPersons[i] = sc.nextInt();
			}
			
			sumValue = 0;
			for(int i = 0; i < numPeople; i++){
				
				matrix  = new int[MaxObjects][MaxWeight];
				for(int j = 0; j < MaxObjects; j++)
					for(int k = 0; k < MaxWeight; k++)
						matrix[j][k] = INF;
				
				sumValue += findMaxValue(0, weightPersons[i]);				
			}
			
			System.out.println(sumValue);			
		}
	}
	
	public static void main(String[] args) {
		
			(new Main_10130_SuperSale()).solve();
	}

}


/*
 
Sample Input
2
3
72 17
44 23
31 24
1
26
6
64 26
85 22
52 4
99 18
39 13
54 9
4
23
20
20
26

Sample Output
72
514
 * 
 */ 
