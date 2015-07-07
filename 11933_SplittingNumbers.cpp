/*

11933 - Splitting Numbers
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3084

*/

#include <iostream>
using namespace std;



int main()
{
	long long number, numA, numB, shiftBits, tempNum;	
	bool turnA;

	while((cin >> number ) && number)	
	{
		numA = 0, numB = 0, tempNum=0, turnA = true;
		//check  each bit of number, shifting and masking with 1
		for(shiftBits = 0; (tempNum = 1LL << shiftBits) <= number ; shiftBits++)
		{			
			if(number & tempNum)
			{
				if(turnA) numA = numA | tempNum;
				else numB = numB | tempNum;

				turnA = !turnA;
			}					
		}		

		cout << numA << " " << numB << endl;	
	}

	return 0;
}

