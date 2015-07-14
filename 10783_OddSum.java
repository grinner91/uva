/**
 10783 - Odd Sum
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1724

*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



class Main_10783_OddSum_accepted {
	
	

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);


		int testCases = sc.nextInt();
		int startNum, endNum, sumOfOdds;

		for(int tc=1;tc<=testCases;tc++)
		{

			startNum = sc.nextInt();
			endNum = sc.nextInt();

			if(startNum%2==0) startNum+=1;
			
			sumOfOdds=0;
			for(int n=startNum; n<=endNum; n+=2)
			{
				sumOfOdds+=n;
			}
			System.out.printf("Case %d: %d\n", tc,sumOfOdds);

		}
		
		System.out.flush();
		sc.close();
		sc=null;
	}

}
