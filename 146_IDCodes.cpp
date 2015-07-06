#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main()
{

	string str;

	while( (cin >> str ) && (str != "#"))
	{
		if(next_permutation(str.begin(), str.end()))
				cout << str  << endl;
		else 
			cout << "No Successor" << endl;
	}

}

/*
https://uva.onlinejudge.org/external/1/146.html

Sample input

abaacb
cbbaa
#

Sample output

ababac
No Successor

*/
