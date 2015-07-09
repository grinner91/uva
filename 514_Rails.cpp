/*

514 - Rails
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=455

*/

#include <iostream>
#include <stack>
using namespace std;


int main()
{
	int N;
	while((cin >> N ) && N)
	{

		while(true)
		{
			stack<int> coaches;
			int target[1002];

			cin >> target[1];
			if(target[1] == 0) 
			{
				cout << endl;
				break;
			}

			for(int i = 2; i <= N; i++)
			{
				cin >> target[i];					
			}

			int index = 1;

			for(int coachId = 1; coachId <= N; coachId++)
			{
				coaches.push(coachId);

				while(!coaches.empty() && index <= N && coaches.top() == target[index])
				{
					coaches.pop();
					index++;
				}
			}

			if(coaches.empty()) cout << "Yes" << endl;
			else cout << "No" << endl;
		}
	}

	return 0;
}


/*

Sample Input 

5
1 2 3 4 5
5 4 1 2 3
0
6
6 5 4 3 2 1
0
0

Sample Output 

Yes
No

Yes


*/
