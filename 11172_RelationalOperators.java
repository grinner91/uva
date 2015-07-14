//11172 Relational Operators
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class Main_11172_RelationalOperators {
	
	public static void main(String[] args) {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);
		
		int firstNum, secndNum;		
		int testCase=sc.nextInt();
		
		for(int tc=1;tc<=testCase;tc++)
		{			
			firstNum = sc.nextInt();
			secndNum = sc.nextInt();
			
			if(firstNum < secndNum) 
				System.out.println("<");
			else if(firstNum > secndNum)
				System.out.println(">");
			else 
				System.out.println("=");
		}	
		System.out.flush();
		sc.close();
		sc=null;
	}
}
