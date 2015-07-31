/*
11799 - Horror Dash
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=2899&mosmsg=Submission+received+with+ID+15855028

*/

#include <iostream>

using namespace std;

int main()
{

	int n, ans, temp, T;

	cin >> T;
	
	for(int tc=1; tc <= T; tc++)
	{
		cin >> n;

		ans = 0;
		while(n--)
		{
			cin >> 	temp;

			if(temp > ans) ans = temp;
		}

		cout << "Case " << tc << ": " << ans << endl;
	}

return 0;
}


/*


2
5 9 3 5 2 6
1 2



Case 1: 9
Case 2: 2


*/
