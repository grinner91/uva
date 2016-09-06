/*
 
 574 Sum It Up
 
 * 
 */
import java.util.Scanner;

class Main_574_SumItUp_Recursion_Backtrack {
	final int MAX = 1000;

	int total, numsCount, resultCount = 0;
	int[] numbers;
	int[][] result;
	boolean[] visited;
	String[] resultStr;

	private void initValues(){
		numbers = new int[MAX];
		result = new int[MAX][MAX];
		visited = new boolean[MAX];
		resultCount = 0;
		numsCount = 0;
		total = 0;
		resultStr = new String[MAX];
	}

	private void checkSumResult(int[] numsArr, int partialSum, int total, int level){
		
		if(partialSum == total){
			
			boolean isValidResult = true;
			String str="";
			
			for(int index = 0; index < level; index++){
				
				if(index > 0)
				{
					str =  str + "+" + numsArr[index];
					
					if( numsArr[index-1] < numsArr[index]) 
					{
						isValidResult = false;
						break;
					}
				}
				else
				{
					str = str + numsArr[index];
				}					
			}	
			
			if(isValidResult){
				
				for(int index = 0; index < resultCount; index++){					
					if(resultStr[index].equalsIgnoreCase(str)) 
					{
						isValidResult = false;
						break;
					}
				}
			}
			
			if(isValidResult){					
				resultStr[resultCount] = str;
				resultCount++;
			}
		}
	}
	
	private void findSum(int[] numsArr, int partialSum, int total, int level){

		if(level == numsCount) {
			
			checkSumResult(numsArr, partialSum, total, level);
			
			return;
		}

		if(partialSum == total){

			checkSumResult(numsArr, partialSum, total, level);

			return;
		}

		if(partialSum > total)
			return;

		for(int index = 0 ; index < numsCount; index++){

			if(visited[index] || index < level) continue;

			visited[index] = true;

			numsArr[level] = numbers[index];

			findSum(numsArr, partialSum + numsArr[level], total, level+1);

			visited[index] = false;
		}	
		
	}

	public void solve(){
		Scanner sc = new Scanner(System.in);

		while(true){
			initValues();
			
			total = sc.nextInt();
			numsCount = sc.nextInt();

			if(total == 0) break;

			
			//input
			for(int index = 0; index < numsCount; index++){
				numbers[index] = sc.nextInt();
			}
			
			//recursion
			findSum(numbers.clone(), 0, total, 0);
			
			//print result
			System.out.println("Sums of " + total + ":");
			if(resultCount > 0)
			{				
				for(int indexI  = 0; indexI < resultCount; indexI++){	
						
						System.out.println(resultStr[indexI]);
				
					//System.out.println();
				}
			}
			else 
				System.out.println("NONE");
		}
	}

	public static void main(String[] args) {
		(new Main_574_SumItUp_Recursion_Backtrack()).solve();
	}

}

/*
 
 Sample Input

4 6 4 3 2 2 1 1
5 3 2 1 1
400 12 50 50 50 50 50 50 25 25 25 25 25 25
0 0


Sample Output

Sums of 4:
4
3+1
2+2
2+1+1


Sums of 5:
NONE
Sums of 400:
50+50+50+50+50+50+25+25+25+25
50+50+50+50+50+25+25+25+25+25+25
 
 
 */
