/*

11498 - Division of Nlogonia

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2493

*/


#include <iostream>
using namespace std;

int main()
{
	double T, centerX, centerY, x, y;

	while(true) 
	{
	
		cin >> T;
		if( 0 == T) break;

		cin >> centerX >> centerY;

		while(T--)
		{
			cin >> x >> y;

			if( centerX == x || centerY == y)     cout << "divisa" << endl;				
			else if( y > centerY && x < centerX ) cout << "NO" << endl;
			else if(y > centerY && x > centerX)   cout << "NE" << endl;
			else if( y < centerY && x > centerX)  cout << "SE" << endl;
			else if( y < centerY && x < centerX)  cout << "SO" << endl;
		
		}
	}
	
	return 0;
}


/*

Output
For each test case in the input your program must print one line containing:

the word `
divisa
' (means border in Portuguese) if the residence is on one of the border lines
(North-South or East-West);

`
NO
' (means NW in Portuguese) if the residence is in Northwestern Nlogonia;

`
NE
' if the residence is in Northeastern Nlogonia;

`
SE
' if the residence is in Southeastern Nlogonia;

`
SO
' (means SW in Portuguese) if the residence is in Southwestern Nlogonia



SampleInput
3
2 1
10 10
-10 1
0 33
4
-1000 -1000
-1000 -1000
0 0
-2000 -10000
-999 -1001
0

Output

NE
divisa
NO
divisa
NE
SO
SE

*/

