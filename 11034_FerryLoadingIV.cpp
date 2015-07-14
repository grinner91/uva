/*

11034 - Ferry Loading IV
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1975

*/

#include <iostream>
#include <queue>
#include <string>

using namespace std;


int main()
{
	int TC;

	cin >> TC;

	while(TC--)
	{
		int ferryLength = 0, carCount = 0, carLen = 0;
		string str;
		queue<int> leftQ, rightQ;

		cin >> ferryLength;
		cin >> carCount;

		while(carCount--)
		{
			cin >> carLen >> str;
			if(str == "left") leftQ.push(carLen);
			else rightQ.push(carLen);
		}

		int crossCount=0, carsLen = 0;
		ferryLength = ferryLength * 100; //centimeters

		while(!leftQ.empty() || !rightQ.empty())
		{			
			//left queue
			carsLen = 0;
			while(!leftQ.empty() && (carsLen + leftQ.front()) <= ferryLength)
			{
				carsLen +=  leftQ.front();
				leftQ.pop();				
			}

			if(carsLen > 0 || !rightQ.empty())  crossCount++;

			//right queue
			carsLen = 0;
			while(!rightQ.empty() && (carsLen + rightQ.front()) <= ferryLength)
			{
				carsLen +=  rightQ.front();
				rightQ.pop();				
			}

			if(carsLen > 0 || !leftQ.empty()) crossCount++;
		}

		cout << crossCount << endl;
	}
}


/*


Sample input

4
20 4
380 left
720 left
1340 right
1040 left
15 4 
380 left
720 left
1340 right
1040 left
15 4 
380 left
720 left
1340 left
1040 left
15 4 
380 right
720 right
1340 right
1040 right

Output for sample input

3
3
5
6

*/
