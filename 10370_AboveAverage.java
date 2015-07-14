/**
10370 - Above Average 
Root :: Contest Volumes (10000...) :: Volume 103 (10300-10399)
http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=15&page=show_problem&problem=1311
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Main_10370_AboveAverage_accepted {


	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);
		
		int testCases = sc.nextInt();
		
		for(int tc=1; tc<= testCases; tc++)
		{
			
			int N = sc.nextInt();
			int[] grades = new int[N+1];
			long sum=0;
			float avg=0,percent=0;
			
			
			for(int i=1;i<=N;i++)
			{
				grades[i] = sc.nextInt();
				sum+= grades[i];						
			}
			
			Arrays.sort(grades);
			avg = sum / N;			
			for(int i=1; i<=N;i++)
			{
				if(Float.compare(grades[i],avg) > 0 ) 
				{
					percent = ((float) ((N-i)+1) / N) * 100 ;
					break;
				}
			}
			
			System.out.printf("%.3f",percent);		
			System.out.println("%");
		}

	}

}

/*
input

5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

output 

40.000%
57.143%
33.333%
66.667%
55.556%
 */
