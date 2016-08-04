
import java.util.Scanner;

class Main_200_Rare_Order {
	final int maxLetters = 26;
	final int maxLen = 21;
	char[][] strings;
	int[] present;		
	int strCount,index;
	
	public void solve(){
		Scanner sc = new Scanner(System.in);		
		strings = new char[5000][maxLen];
		present = new int[maxLetters];
		
		//int minLen;
		strCount = 0;
		while(true){
			strings[strCount++] = sc.nextLine().toCharArray();
			if(strings[strCount-1][0] == '#') break;		
		}	
		
		strCount--;
		for(int col = 0; col < maxLen; col++ ){			
			for(int row = 0; row < strCount; row++)
			{
				if( col < strings[row].length)
				{
					index = (strings[row][col] - 65);
					present[index]++;
					
					if(present[index] == 1)
						System.out.print(strings[row][col]);
				}
			}			
		}
		System.out.println();
	}	
	public static void main(String[] args) {
		(new Main_200_Rare_Order()).solve();
	}
}

/*


Sample Input
XWY
ZX
ZXY
ZXW
YWWX
#
Sample Output
XZYW


Critical input:
HELLO
ELLOH
EREREEEIE
W
ADFEEDE
OEREI
EEEIADFIOS
PAVMZVNZV
#
 
Critical output:
HEWAOPLRDFVIMZNS
 
Critical input:
TYKK
DCDDE
BMZOLWO
PCZL
TKKYOSWQ
ILUVL
#
 
Critical output:
TDBPIYCMKLZUOVEWSQ

*/
