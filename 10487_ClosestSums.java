
/*
 * 
10487 - Closest Sums

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1428
 * 
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

class Main_10487_ClosestSums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = 0;
		
		while(true){
			
			testCase++;
			
			int N = sc.nextInt();
			if(N == 0) break;
			
			int[] nums = new int[N+2];
			
			for(int i = 0; i < N; i++){
				nums[i] = sc.nextInt();
			}
			
			int[] sums = new int[N*N];
			Arrays.fill(sums, Integer.MAX_VALUE);
			
			int sumCount  = 0;
			for(int index = 0 ; index < N - 1; index++){
				for(int j = index+1; j < N; j++ ){
					sums[sumCount++] = nums[index] + nums[j];
				}
			}	
			
			sums = Arrays.copyOf(sums, sumCount);
			
			Arrays.sort(sums);
			
			System.out.println("Case " + testCase + ":");
			
			int M = sc.nextInt();	
			
			for(int index = 0; index < M; index++){
			
				int sum = sc.nextInt();
				int colsestSum = 0, minDiff = Integer.MAX_VALUE, diff;
				
				for(int indexJ = 0; indexJ < sumCount; indexJ++ ){					
					diff = Math.abs(sums[indexJ] - sum);				
					if(diff < minDiff) {
						minDiff = diff;
						colsestSum = sums[indexJ];
						}					
					}					
								
				System.out.println("Closest sum to "+sum+" is " + colsestSum + ".");
			}
			
		}

	}

}


/*

Sample Input
5
3
12
17
33
34
3
1
51
30
3
1
2
3
3
1
2
3
3
1
2
3
3
4
5
6
0
Sample Output
Case 1:
Closest sum to 1 is 15.
Closest sum to 51 is 51.
Closest sum to 30 is 29.
Case 2:
Closest sum to 1 is 3.
Closest sum to 2 is 3.
Closest sum to 3 is 3.
Case 3:
Closest sum to 4 is 4.
Closest sum to 5 is 5.
Closest sum to 6 is 5.

*/
