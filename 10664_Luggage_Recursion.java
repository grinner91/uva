/*
 10664 Luggage
 6-May-16
 */

import java.util.Scanner;

class Main_10664_Luggage {
	int numLuggage, total;
	int[] weights;
	boolean isEqual;
	
	private void distributeLuggage(int level, int load){
		if(isEqual) return;
		if(level == numLuggage) return;
		
		if(load == 0){ 
			isEqual = true;
			return;
		}
		
		//left tree
		if(weights[level] <= load )	{
			distributeLuggage(level+1, load - weights[level]);
		}
		
		//right tree
		distributeLuggage(level+1, load);
	}
	
	public void solve()	{
		Scanner sc = new Scanner(System.in);
		String str;
		String[] arr;
		int testCases = sc.nextInt();
		sc.nextLine();
		
		while(testCases-- > 0){			
			
			str = sc.nextLine();
			arr = str.trim().split(" ");
			
			numLuggage = arr.length;
			weights = new int[numLuggage+1];
			
			total = 0;
			for(int i = 0; i < numLuggage; i++){
				weights[i] = Integer.parseInt(arr[i].trim());
				total += weights[i];
			}
			
			isEqual = false;
			if(total % 2 == 0)
				distributeLuggage(0, total/2);
			
			if(isEqual) 
				System.out.println("YES");
			else 
				System.out.println("NO");			
		}			
	}
	
	public static void main(String[] args) {		
		(new Main_10664_Luggage()).solve();
	}
}

/*
Sample Input

3
1 2 1 2 1
2 3 4 1 2 5 10 50 3 50
3 5 2 7 1 7 5 2 8 9 1 25 15 8 3 1 38 45 8 1

Sample Output
NO
YES
YES
  
 */
