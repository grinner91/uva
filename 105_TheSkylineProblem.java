
/*
 * 
 * 
 105 - The Skyline Problem
 
 */

import java.util.Scanner;

class Main_105_TheSkylineProblem {
	final int MAX = 10005; 
	int[] line;
	int x1, x2,h,maxX;
	
	private void initValues(){		
		line = new int [MAX];		
		maxX=0;
	}
	
	public void solve(){
		Scanner sc = new Scanner(System.in);
		
		initValues();	
		
		while(sc.hasNext()){
		//for(int j = 0; j < 8; j++){
			x1 = sc.nextInt();
			h = sc.nextInt();
			x2= sc.nextInt();
		
			
			if( x2 > maxX) maxX = x2;
			
			for(int i = x1; i <x2; i++){
				if( h > line[i]) line[i] = h;
			}
		}
				
		int currentH = 0;
		boolean flag = false;
		for(int i = 0; i <= maxX; i++){
			
			if(currentH != line[i]){
				
				if(flag) {  
					System.out.print(" ");
				}
				
				System.out.print(""+i+" " + line[i]);
				flag = true;				
				currentH = line[i];
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		(new Main_105_TheSkylineProblem()).solve();
	}

}

/*
 * 
 * 
Sample Input

1 11 5
2 6 7
3 13 9
12 7 16
14 3 25
19 18 22
23 13 29
24 4 28

Sample Output

1 11 3 13 9 0 12 7 16 3 19 18 22 3 23 13 29 0
 
 */
