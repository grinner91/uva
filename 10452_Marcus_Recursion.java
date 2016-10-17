/**
 *   10452 - Marcus	  0.100s/1873(2)
 *   
 * @author zaman
 *
 *   10452 - Marcus
 *   
 *   http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1393
 *
 */


import java.util.Scanner;


class Main_10452_Marcus_Recursion {
	// IEHOVA# 
	// A to Z, @, #
	private String pathChars = "IEHOVA#";	
	private final int MAX = 20;
	private int rowM, colN, srcRow, srcCol, destRow, destCol;
	private String[] cobbles;
	private String[] path;


	private void initValues(){
		cobbles = new String[MAX];
		path = new String[MAX*MAX];		
		rowM = colN = srcRow = srcCol = destRow = destCol  = 0;
	}


	private void findPath(int row, int col, int moveCount){

		if(row == destRow && col == destCol){	

			for(int k = 0; k < moveCount; k++){
				if(k>0) System.out.print(" ");
				System.out.print(path[k]);
			}	

			System.out.println();

			return;		
		}
		else {

			if(col+1 < colN && cobbles[row].charAt(col+1) == pathChars.charAt(moveCount)){
				path[moveCount] = "right";			
				findPath(row, col+1, moveCount+1);
			}
			else if(col > 0 && cobbles[row].charAt(col-1) == pathChars.charAt(moveCount)){
				path[moveCount] = "left";			
				findPath(row, col-1, moveCount+1);
			}	
			else if(row > 0 && cobbles[row-1].charAt(col) == pathChars.charAt(moveCount)){			
				path[moveCount] = "forth";		
				findPath(row-1, col, moveCount+1);
			}
		}
	}

	public void solve(){
		Scanner sc = new Scanner(System.in);

		int testCases =  sc.nextInt();

		for(int tc = 0; tc < testCases; tc++) {

			initValues();

			rowM = sc.nextInt();
			colN = sc.nextInt();
			sc.nextLine();

			for(int i = 0; i < rowM; i++){
				cobbles[i] = sc.nextLine();				
			}

			destRow = 0;

			for(int i = 0; i < colN; i++){
				if(cobbles[0].charAt(i) == '#') {
					destCol = i;
					break;
				}
			}

			srcRow = rowM - 1;

			for(int i=0; i < colN; i++){
				if('@' == cobbles[srcRow].charAt(i)){
					srcCol = i;
					break;
				}
			}

			findPath(srcRow, srcCol, 0);

		}

	}


	public static void main(String[] args) {
		(new Main_10452_Marcus_Recursion()).solve();
	}

}

/*

 Sample Input
2
6 5
PST#T
BTJAS
TYCVM
YEHOF
XIBKU
N@RJB
5 4
JA#X
JVBN
XOHD
DQEM
T@IY



Sample Output
forth forth right right forth forth forth
right forth forth left forth forth right



4
5 8
A#XMNXYY
VOXZKKKK
CHLLLLLL
IEBNBNBN
@YMMMMMM
4 8
VXX#AKKK
CXLLVOHL
XXBNBIEN
MYMMM@MM
4 5
CA#KK
LVOHL
NBXEN
MM@IM
4 4
CZ#A 
LHOV 
NEXX 
MI@Z 


 * 
 */
